package com.heyzap.mediation.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.common.concurrency.ListenableFuture;
import com.heyzap.common.concurrency.PausableRunnable.PauseSignal;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.net.APIClient;
import com.heyzap.http.JsonHttpResponseHandler;
import com.heyzap.http.RequestParams;
import com.heyzap.internal.Constants;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.HeaderActions;
import com.heyzap.internal.Logger;
import com.heyzap.internal.RetryManager;
import com.heyzap.internal.RetryManager.ExponentialSchedule;
import com.heyzap.internal.RetryManager.RetryableTask;
import com.heyzap.internal.SwappableProvider;
import com.heyzap.mediation.ConcurrentLoaderStrategy;
import com.heyzap.mediation.FetchRequestStore;
import com.heyzap.mediation.LocationProvider;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.adapter.AdapterPool;
import com.heyzap.mediation.adapter.AdapterScanner;
import com.heyzap.mediation.config.ConfigLoader.MediationConfigListener;
import com.heyzap.mediation.display.MediatedDisplayConfigLoader;
import com.heyzap.mediation.filters.FilterManager;
import com.heyzap.sdk.ads.HeyzapAds.AdsConfig;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallbackListener;
import com.heyzap.sdk.mediation.adapter.HeyzapAdapter;
import com.heyzap.sdk.mediation.adapter.HeyzapCrossPromoAdapter;
import com.heyzap.sdk.segmentation.SQLitePastImpressionStore;
import com.heyzap.sdk.segmentation.SegmentManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class MediationConfigLoader implements ConfigLoader {
    private static final String CONFIGURATION_CACHE_KEY = "config.cache";
    private static final String CONFIGURATION_USED_KEY = "config.used";
    private static final Integer POLLING_TIME_IN_SECONDS = Integer.valueOf(1200);
    private final AdapterPool adapterPool;
    private final AdapterScanner adapterScanner;
    private final AdsConfig adsConfig;
    private final ArrayList<Runnable> configChangedListeners = new ArrayList();
    private final SettableFuture<MediationConfig> configurationCacheFuture;
    private final ContextReference contextRef;
    private final MediatedDisplayConfigLoader displayConfigLoader;
    private final ScheduledExecutorService executorService;
    private final FetchRequestStore fetchRequestStore;
    private final FilterManager filterManager;
    private final HeaderActions headerActions;
    private final ConcurrentLoaderStrategy loaderStrategy;
    private final LocationProvider locationProvider;
    private final NetworkCallbackListener networkCallbackListener;
    private SQLitePastImpressionStore pastImpressionsStore;
    private final ExecutorService uiThreadExecutorService;

    class C14201 extends RetryableTask {

        class C14191 extends JsonHttpResponseHandler {
            C14191() {
            }

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    MediationConfigLoader.this.headerActions.onHeaders(headers);
                    if (!MediationConfigLoader.this.configurationCacheFuture.isDone()) {
                        MediationConfig config = new MediationConfig(MediationConfigLoader.this.contextRef, response, MediationConfigLoader.this.executorService, MediationConfigLoader.this.fetchRequestStore, MediationConfigLoader.this.adapterPool, MediationConfigLoader.this.displayConfigLoader, MediationConfigLoader.this.loaderStrategy, MediationConfigLoader.this.filterManager, MediationConfigLoader.this.locationProvider, MediationConfigLoader.this.pastImpressionsStore);
                        MediationConfigLoader.storeConfigurationCache(MediationConfigLoader.this.contextRef.getApp(), response);
                        MediationConfigLoader.this.configurationCacheFuture.set(config);
                    }
                } catch (JSONException e) {
                    Logger.error("Trouble Loading Mediation Config", e);
                    C14201.this.retry();
                }
            }

            public void onFailure(int statusCode, Header[] headers, byte[] responseBytes, Throwable throwable) {
                MediationConfigLoader.this.headerActions.onHeaders(headers);
                C14201.this.retry();
            }
        }

        C14201() {
        }

        public void run() {
            APIClient.get(MediationConfigLoader.this.contextRef.getApp(), "https://med.heyzap.com/start", new RequestParams(), new C14191());
        }
    }

    class C14222 extends TimerTask {

        class C14211 extends JsonHttpResponseHandler {
            C14211() {
            }

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                MediationConfigLoader.this.headerActions.onHeaders(headers);
                MediationConfigLoader.storeConfigurationCache(MediationConfigLoader.this.contextRef.getApp(), response);
                try {
                    ((SwappableProvider) ((MediationConfig) MediationConfigLoader.this.configurationCacheFuture.get()).getSegmentManager()).set(new SegmentManager(response.getJSONArray("segments"), MediationConfigLoader.this.pastImpressionsStore));
                    ((MediationConfig) MediationConfigLoader.this.configurationCacheFuture.get()).getAdapterPool().configure(((MediationConfig) MediationConfigLoader.this.configurationCacheFuture.get()).getAdapterPool().parseConfig(response.getJSONArray("networks")));
                    MediationConfigLoader.this.onConfigChanged();
                } catch (JSONException e) {
                } catch (InterruptedException e2) {
                } catch (ExecutionException e3) {
                }
            }

            public void onFailure(int statusCode, Header[] headers, byte[] responseBytes, Throwable throwable) {
                MediationConfigLoader.this.headerActions.onHeaders(headers);
            }
        }

        C14222() {
        }

        public void run() {
            APIClient.get(MediationConfigLoader.this.contextRef.getApp(), "https://med.heyzap.com/start", new RequestParams(), new C14211());
        }
    }

    public MediationConfigLoader(ContextReference contextRef, ScheduledExecutorService executorService, ExecutorService uiThreadExecutorService, FetchRequestStore fetchRequestStore, AdsConfig adsConfig, NetworkCallbackListener networkCallbackListener, PauseSignal pauseExpensiveWorkSignal) {
        this.contextRef = contextRef;
        this.executorService = executorService;
        this.fetchRequestStore = fetchRequestStore;
        this.uiThreadExecutorService = uiThreadExecutorService;
        this.adapterScanner = new AdapterScanner();
        this.configurationCacheFuture = SettableFuture.create();
        this.networkCallbackListener = networkCallbackListener;
        this.locationProvider = new LocationProvider();
        this.adapterPool = new AdapterPool(contextRef, this.fetchRequestStore, adsConfig, executorService, uiThreadExecutorService, this.networkCallbackListener, this.locationProvider, pauseExpensiveWorkSignal);
        this.filterManager = new FilterManager(contextRef, executorService);
        this.displayConfigLoader = new MediatedDisplayConfigLoader(contextRef);
        this.loaderStrategy = new ConcurrentLoaderStrategy(this.adapterPool, executorService, pauseExpensiveWorkSignal, this.fetchRequestStore);
        this.adsConfig = adsConfig;
        this.headerActions = new HeaderActions(uiThreadExecutorService, executorService, contextRef);
    }

    public void start() {
        List<Class<? extends NetworkAdapter>> adapterList;
        if ((this.adsConfig.flags & 8) == 0) {
            adapterList = this.adapterScanner.scan();
        } else {
            adapterList = Arrays.asList(new Class[]{HeyzapAdapter.class, HeyzapCrossPromoAdapter.class});
        }
        this.pastImpressionsStore = new SQLitePastImpressionStore(this.contextRef.getApp());
        this.adapterPool.addAdapters(adapterList);
        this.displayConfigLoader.start();
        JSONObject cachedConfiguration = getConfigurationCache(this.contextRef.getApp());
        if (cachedConfiguration != null) {
            try {
                this.configurationCacheFuture.set(new MediationConfig(this.contextRef, cachedConfiguration, this.executorService, this.fetchRequestStore, this.adapterPool, this.displayConfigLoader, this.loaderStrategy, this.filterManager, this.locationProvider, this.pastImpressionsStore));
            } catch (Throwable e) {
                Logger.trace(e);
            }
        }
        new RetryManager(new C14201(), new ExponentialSchedule(2.0d, 4, TimeUnit.SECONDS), this.executorService).start();
        new Timer(true).scheduleAtFixedRate(new C14222(), (long) (POLLING_TIME_IN_SECONDS.intValue() * 1000), (long) (POLLING_TIME_IN_SECONDS.intValue() * 1000));
    }

    public void get(final MediationConfigListener configListener) {
        this.configurationCacheFuture.addListener(new Runnable() {
            public void run() {
                try {
                    configListener.onConfigLoaded((MediationConfig) MediationConfigLoader.this.configurationCacheFuture.get());
                } catch (Throwable e) {
                    Logger.trace(e);
                } catch (Throwable e2) {
                    Logger.trace(e2);
                }
            }
        }, ExecutorPool.getInstance());
    }

    public void addConfigChangedListener(Runnable r) {
        this.configChangedListeners.add(r);
    }

    public void onConfigChanged() {
        Iterator it = this.configChangedListeners.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public AdapterPool getPool() {
        return this.adapterPool;
    }

    public ListenableFuture<MediationConfig> getFuture() {
        return this.configurationCacheFuture;
    }

    private static void storeConfigurationCache(Context context, JSONObject response) {
        Editor editor = context.getSharedPreferences(Constants.PREFERENCES_KEY, 0).edit();
        editor.putString(CONFIGURATION_CACHE_KEY, response.toString()).apply();
        editor.putBoolean(CONFIGURATION_USED_KEY, false);
        editor.apply();
    }

    private static JSONObject getConfigurationCache(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(Constants.PREFERENCES_KEY, 0);
        String json = prefs.getString(CONFIGURATION_CACHE_KEY, "");
        boolean dirty = prefs.getBoolean(CONFIGURATION_USED_KEY, true);
        prefs.edit().putBoolean(CONFIGURATION_USED_KEY, true).apply();
        if (json.equals("") || dirty) {
            return null;
        }
        try {
            return new JSONObject(json);
        } catch (JSONException e) {
            Logger.trace("MediationConfigLoader JSON Error!", e);
            return null;
        }
    }
}
