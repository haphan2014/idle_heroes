package com.heyzap.mediation.adapter;

import android.support.annotation.Nullable;
import com.heyzap.common.concurrency.PausableRunnable.PauseSignal;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.DevLogger;
import com.heyzap.internal.Logger;
import com.heyzap.mediation.FetchRequestStore;
import com.heyzap.mediation.LocationProvider;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter.ConfigurationError;
import com.heyzap.sdk.ads.HeyzapAds.AdsConfig;
import com.heyzap.sdk.ads.HeyzapAds.Network;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallbackListener;
import com.heyzap.sdk.mediation.adapter.HeyzapAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;

public class AdapterPool {
    private final AdsConfig adsConfig;
    private final ContextReference contextRef;
    private final ScheduledExecutorService executorService;
    private final FetchRequestStore fetchStore;
    private final LocationProvider locationProvider;
    private final NetworkCallbackListener networkCallbackListener;
    private final PauseSignal pauseSignal;
    private HashMap<String, NetworkAdapter> pool = new HashMap();
    private final ExecutorService uiThreadExecutorService;

    public AdapterPool(ContextReference contextRef, FetchRequestStore fetchStore, AdsConfig adsConfig, ScheduledExecutorService executorService, ExecutorService uiThreadExecutorService, NetworkCallbackListener networkCallbackListener, LocationProvider locationProvider, PauseSignal pauseExpensiveWorkSignal) {
        this.contextRef = contextRef;
        this.fetchStore = fetchStore;
        this.adsConfig = adsConfig;
        this.executorService = executorService;
        this.uiThreadExecutorService = uiThreadExecutorService;
        this.networkCallbackListener = networkCallbackListener;
        this.locationProvider = locationProvider;
        this.pauseSignal = pauseExpensiveWorkSignal;
    }

    public void addAdapters(List<Class<? extends NetworkAdapter>> implementedAdapters) {
        for (Class<? extends NetworkAdapter> adapterImplementation : implementedAdapters) {
            NetworkAdapter adapter = NetworkAdapter.createAdapterFromKlass(adapterImplementation);
            if (adapter != null) {
                boolean mediationDisabled;
                if ((this.adsConfig.flags & 8) > 0) {
                    mediationDisabled = true;
                } else {
                    mediationDisabled = false;
                }
                boolean nativeAdsOnly;
                if ((this.adsConfig.flags & 32) > 0) {
                    nativeAdsOnly = true;
                } else {
                    nativeAdsOnly = false;
                }
                if (mediationDisabled && !(adapter instanceof HeyzapAdapter)) {
                    Logger.format("Mediation is disabled, skipping %s", adapter.getMarketingName());
                } else if (adapter.isOnBoard().booleanValue()) {
                    boolean activitiesRequired;
                    DevLogger.info(adapter.getMarketingName() + " SDK is present.");
                    if (mediationDisabled || nativeAdsOnly) {
                        activitiesRequired = false;
                    } else {
                        activitiesRequired = true;
                    }
                    boolean activitiesPresent;
                    if (this.contextRef.getActivity() == null || !adapter.checkActivities(this.contextRef.getActivity())) {
                        activitiesPresent = false;
                    } else {
                        activitiesPresent = true;
                    }
                    if (!activitiesRequired || activitiesPresent) {
                        this.pool.put(adapter.getCanonicalName(), adapter);
                    } else {
                        DevLogger.error(adapter.getMarketingName() + " SDK disabled due to missing activities. Please check your AndroidManifest.xml.");
                    }
                } else {
                    DevLogger.info(adapter.getMarketingName() + " SDK is not present.");
                }
            } else {
                Logger.format("could not load adapter for %s", adapterImplementation);
            }
        }
    }

    public List<AdapterConfiguration> parseConfig(JSONArray jadapterConfigs) {
        List<AdapterConfiguration> adapterConfigs = new ArrayList();
        for (int i = 0; i < jadapterConfigs.length(); i++) {
            try {
                AdapterConfiguration adapterConfiguration = new AdapterConfiguration(jadapterConfigs.getJSONObject(i));
                adapterConfigs.add(adapterConfiguration);
                if (adapterConfiguration.getCanonicalName().equals(Network.HEYZAP)) {
                    AdapterConfiguration hzVideoConfig = new AdapterConfiguration(jadapterConfigs.getJSONObject(i));
                    hzVideoConfig.setCanonicalName("heyzap_video");
                    adapterConfigs.add(hzVideoConfig);
                    Logger.debug("adding heyzap_video config");
                }
            } catch (Throwable e) {
                Logger.format("(CONFIG) Failed to load config for: %s", String.valueOf(jadapterConfigs.optJSONObject(i)));
                Logger.trace(e);
            } catch (Throwable e2) {
                Logger.trace(e2);
            }
        }
        return adapterConfigs;
    }

    public void configure(List<AdapterConfiguration> adapterConfigs) {
        for (AdapterConfiguration configuration : adapterConfigs) {
            NetworkAdapter adapter = (NetworkAdapter) this.pool.get(configuration.getCanonicalName());
            if (adapter != null) {
                try {
                    adapter.init(this.contextRef, configuration, this.fetchStore, this.adsConfig, this.executorService, this.uiThreadExecutorService, this.networkCallbackListener, this.locationProvider, this.pauseSignal);
                } catch (ConfigurationError configurationError) {
                    Logger.format("(CONFIG) Failed to initialize adapter: %s with error: %s", adapter.getCanonicalName(), configurationError.getMessage());
                } catch (Throwable e) {
                    Logger.trace(e);
                }
            } else {
                Logger.debug("(CONFIG) invalid adapter configuration not initialized for " + configuration.getCanonicalName());
            }
        }
    }

    @Nullable
    public synchronized NetworkAdapter get(String network) {
        NetworkAdapter adapter;
        adapter = (NetworkAdapter) this.pool.get(network);
        if (adapter == null || !adapter.isInitialized()) {
            adapter = null;
        }
        return adapter;
    }

    public synchronized List<NetworkAdapter> getAll() {
        return new ArrayList(this.pool.values());
    }
}
