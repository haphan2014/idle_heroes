package com.heyzap.mediation.abstr;

import android.app.Activity;
import android.support.annotation.CallSuper;
import com.heyzap.common.concurrency.PausableRunnable.PauseSignal;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchFailure;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.common.lifecycle.FetchResult.FetchStartedListener;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.DevLogger;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import com.heyzap.mediation.FetchRequestStore;
import com.heyzap.mediation.LocationProvider;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.adapter.AdapterConfiguration;
import com.heyzap.mediation.adapter.FetchRequestConsumer;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds.AdsConfig;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallbackListener;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class NetworkAdapter {
    private static Map<Class<?>, NetworkAdapter> networkAdapterSingletons = new HashMap();
    private final AtomicBoolean adapterInitialized = new AtomicBoolean(false);
    private final AtomicBoolean adapterStarted = new AtomicBoolean(false);
    protected AdsConfig adsConfig;
    private AdapterConfiguration config;
    private ContextReference contextRef;
    protected ScheduledExecutorService executorService;
    private FetchRequestConsumer fetchConsumer;
    private FetchRequestStore fetchStore;
    protected LocationProvider locationProvider;
    private NetworkCallbackListener networkCallbackListener;
    protected PauseSignal pauseSignal;
    protected ExecutorService uiThreadExecutorService;

    public static class ConfigurationError extends Exception {
        private static final long serialVersionUID = 3375689363352764627L;

        public ConfigurationError(String message) {
            super(message);
        }
    }

    public abstract void addFetchStartedListener(FetchStartedListener fetchStartedListener, ExecutorService executorService);

    public abstract SettableFuture<FetchResult> awaitAvailability(DisplayOptions displayOptions);

    public abstract List<String> getActivities();

    public abstract EnumSet<AdUnit> getAdUnitsForCreativeType(CreativeType creativeType);

    public abstract EnumSet<AdUnit> getAllAdUnitCapabilities();

    public abstract String getCanonicalName();

    public abstract EnumSet<AdUnit> getConfiguredAdUnitCapabilities();

    public abstract FetchFailure getLastFetchFailure(DisplayOptions displayOptions);

    public abstract String getMarketingName();

    public abstract String getMarketingVersion();

    public abstract List<String> getPermissions();

    public abstract Double getScoreOverride(DisplayOptions displayOptions);

    public abstract Boolean isOnBoard();

    public abstract boolean isReadyForFetch(FetchOptions fetchOptions);

    public abstract boolean onBackPressed();

    protected abstract void onInit() throws ConfigurationError;

    protected abstract void onStart();

    public abstract AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions);

    public AuctionType getAuctionType() {
        return AuctionType.MONETIZATION;
    }

    public EnumSet<AdUnit> getAdUnitsForCreativeType(Collection<CreativeType> creativeTypes) {
        EnumSet<AdUnit> adUnits = EnumSet.noneOf(AdUnit.class);
        for (CreativeType creativeType : creativeTypes) {
            adUnits.addAll(getAdUnitsForCreativeType(creativeType));
        }
        return adUnits;
    }

    @CallSuper
    public SettableFuture<FetchResult> start(FetchOptions fetchOptions) {
        final SettableFuture<FetchResult> onStartCompleted = SettableFuture.create();
        this.uiThreadExecutorService.submit(new Runnable() {
            public void run() {
                if (!NetworkAdapter.this.isStarted()) {
                    NetworkAdapter.this.onStart();
                    NetworkAdapter.this.adapterStarted.set(true);
                }
                onStartCompleted.set(new FetchResult());
            }
        });
        return onStartCompleted;
    }

    public final boolean isInitialized() {
        return this.adapterInitialized.get();
    }

    public final boolean isStarted() {
        return this.adapterStarted.get();
    }

    public void init(ContextReference contextReference, AdapterConfiguration configuration, FetchRequestStore fetchStore, AdsConfig adsConfig, ScheduledExecutorService executorService, ExecutorService uiThreadExecutorService, NetworkCallbackListener networkCallbackListener, LocationProvider locationProvider, PauseSignal pauseSignal) throws ConfigurationError {
        if (isInitialized()) {
            Logger.warn(getMarketingName() + " Adapter already initialized, skipping.");
            return;
        }
        this.contextRef = contextReference;
        this.config = configuration;
        this.fetchConsumer = new FetchRequestConsumer(fetchStore);
        this.adsConfig = adsConfig;
        this.executorService = executorService;
        this.uiThreadExecutorService = uiThreadExecutorService;
        this.fetchStore = fetchStore;
        this.networkCallbackListener = networkCallbackListener;
        this.locationProvider = locationProvider;
        this.pauseSignal = pauseSignal;
        boolean noActivity = contextReference.getActivity() == null;
        boolean nativeAdsOnly = (adsConfig.flags & 32) != 0;
        boolean adapterSupportsNative = getAllAdUnitCapabilities().contains(AdUnit.NATIVE);
        if (!noActivity || nativeAdsOnly || adapterSupportsNative) {
            onInit();
            Logger.debug(getMarketingName() + " Adapter has been initialized.");
            this.adapterInitialized.set(true);
            return;
        }
        throw new ConfigurationError(String.format("Context is not an Activity. An Activity is required to display interstitial ads. Please pass an Activity to HeyzapAds.start to enable %s, or use the NATIVE_ADS_ONLY flag if you only want to show native ads.", new Object[]{getMarketingName()}));
    }

    public final boolean isReady(DisplayOptions displayOptions) {
        if (!isInitialized()) {
            return false;
        }
        SettableFuture<FetchResult> future = awaitAvailability(displayOptions);
        if (!future.isDone()) {
            return false;
        }
        try {
            return ((FetchResult) future.get()).success;
        } catch (Throwable e) {
            Logger.trace(e);
            return false;
        }
    }

    public boolean checkPermissions(Activity activity) {
        boolean toReturn = true;
        for (String permission : getPermissions()) {
            if (!Utils.packageHasPermission(activity, permission)) {
                DevLogger.warn("Permission " + permission + " is missing from your manifest and is required for " + getMarketingName());
                toReturn = false;
            }
        }
        return toReturn;
    }

    public boolean checkActivities(Activity activity) {
        boolean toReturn = true;
        for (String activityName : getActivities()) {
            if (!Utils.activityExistsInPackage(activity, activityName)) {
                DevLogger.warn("Activity " + activityName + " is missing from your manifest and is required for " + getMarketingName());
                toReturn = false;
            }
        }
        return toReturn;
    }

    public boolean isCapable(DisplayOptions displayOptions) {
        boolean capable;
        if (isInitialized() && displayOptions.getNetworks().contains(getCanonicalName())) {
            capable = true;
        } else {
            capable = false;
        }
        if (capable && getConfiguredAdUnitCapabilities().contains(displayOptions.getAdUnit())) {
            capable = true;
        } else {
            capable = false;
        }
        if (capable && displayOptions.getAuctionTypes().contains(getAuctionType())) {
            capable = true;
        } else {
            capable = false;
        }
        if (capable && getAdUnitsForCreativeType(displayOptions.getCreativeTypes().intersect(EnumSet.allOf(CreativeType.class))).contains(displayOptions.getAdUnit())) {
            return true;
        }
        return false;
    }

    public final AdapterConfiguration getConfiguration() {
        return this.config;
    }

    public final void setConfiguration(AdapterConfiguration config) {
        this.config = config;
    }

    protected final ContextReference getContextRef() {
        return this.contextRef;
    }

    protected FetchRequestConsumer getFetchConsumer() {
        return this.fetchConsumer;
    }

    public static <T extends NetworkAdapter> T createAdapterFromKlass(Class<T> adapterClass) {
        T adapter = (NetworkAdapter) networkAdapterSingletons.get(adapterClass);
        if (adapter != null) {
            return adapter;
        }
        try {
            adapter = (NetworkAdapter) adapterClass.getConstructor(new Class[0]).newInstance(new Object[0]);
            networkAdapterSingletons.put(adapterClass, adapter);
            return adapter;
        } catch (Throwable ex) {
            Logger.trace(ex);
            return adapter;
        }
    }

    public FetchRequestStore getFetchStore() {
        return this.fetchStore;
    }

    public NetworkCallbackListener getNetworkCallbackListener() {
        return this.networkCallbackListener;
    }

    public void onCallbackEvent(String callback) {
        this.networkCallbackListener.onNetworkCallback(getCanonicalName(), callback);
    }
}
