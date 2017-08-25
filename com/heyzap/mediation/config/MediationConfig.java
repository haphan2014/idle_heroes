package com.heyzap.mediation.config;

import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.Provider;
import com.heyzap.internal.SwappableProvider;
import com.heyzap.mediation.ConcurrentLoaderStrategy;
import com.heyzap.mediation.FetchRequestStore;
import com.heyzap.mediation.LocationProvider;
import com.heyzap.mediation.adapter.AdapterPool;
import com.heyzap.mediation.display.DisplayConfigLoader;
import com.heyzap.mediation.display.Mediator;
import com.heyzap.mediation.display.NativeMediator;
import com.heyzap.mediation.display.SerialMediator;
import com.heyzap.mediation.display.WaterfallMediator;
import com.heyzap.mediation.filters.FilterManager;
import com.heyzap.mediation.filters.InterstitialVideoTracker;
import com.heyzap.sdk.segmentation.SQLitePastImpressionStore;
import com.heyzap.sdk.segmentation.SegmentManager;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediationConfig {
    private final AdapterPool adapterPool;
    private final ContextReference contextRef;
    private final String customPublisherData;
    private DisplayConfigLoader displayConfigLoader;
    private final ScheduledExecutorService executorService;
    private final FetchRequestStore fetchRequestStore;
    private final FilterManager filterManager;
    private final long iapAdDisableTime;
    private final InterstitialVideoTracker interstitialVideoTracker;
    private final ConcurrentLoaderStrategy loaderStrategy;
    private final LocationProvider locationProvider;
    private NativeMediator nativeMediator;
    private final SQLitePastImpressionStore pastImpressionsStore;
    private final Provider<SegmentManager> segmentManager;
    private SerialMediator serialMediator;
    private WaterfallMediator waterfallMediator;

    public class AdapterNotFoundException extends Exception {
        private static final long serialVersionUID = 1;

        public AdapterNotFoundException(String name) {
            super(name);
        }
    }

    public MediationConfig(ContextReference contextRef, JSONObject jconfig, ScheduledExecutorService executorService, FetchRequestStore fetchRequestStore, AdapterPool adapterPool, DisplayConfigLoader displayConfigLoader, ConcurrentLoaderStrategy loaderStrategy, FilterManager filterManager, LocationProvider locationProvider, SQLitePastImpressionStore pastImpressionsStore) throws JSONException {
        JSONArray segments;
        this.contextRef = contextRef;
        this.executorService = executorService;
        this.fetchRequestStore = fetchRequestStore;
        this.adapterPool = adapterPool;
        this.displayConfigLoader = displayConfigLoader;
        this.loaderStrategy = loaderStrategy;
        this.filterManager = filterManager;
        this.displayConfigLoader = displayConfigLoader;
        this.pastImpressionsStore = pastImpressionsStore;
        this.interstitialVideoTracker = new InterstitialVideoTracker(executorService);
        this.locationProvider = locationProvider;
        try {
            segments = jconfig.getJSONArray("segments");
        } catch (JSONException e) {
            segments = new JSONArray();
        }
        this.segmentManager = SwappableProvider.of(new SegmentManager(segments, pastImpressionsStore));
        this.waterfallMediator = new WaterfallMediator(adapterPool, displayConfigLoader, executorService, filterManager, this.interstitialVideoTracker, this.segmentManager);
        this.serialMediator = new SerialMediator(adapterPool, displayConfigLoader, this.segmentManager);
        this.nativeMediator = new NativeMediator(adapterPool, displayConfigLoader, filterManager, this.segmentManager);
        filterManager.configure(jconfig.optJSONArray("filters"));
        filterManager.addIncentiveDailyLimitFilter(jconfig.optInt("incentivized_daily_limit", -1));
        filterManager.addRateLimitIntervalFilter(jconfig.optInt("ad_rate_limit_interval", -1));
        filterManager.addDisabledTagsFilter(jconfig.optJSONArray("disabled_tags"));
        this.iapAdDisableTime = (jconfig.optLong("iap_ad_disable_time") * 1000) * 60;
        adapterPool.configure(adapterPool.parseConfig(jconfig.getJSONArray("networks")));
        this.customPublisherData = jconfig.optString("custom_publisher_data", "{}");
        loaderStrategy.configureFromJson(jconfig.getJSONObject("loader"));
        loaderStrategy.start();
    }

    public ConcurrentLoaderStrategy getLoaderStrategy() {
        return this.loaderStrategy;
    }

    public AdapterPool getAdapterPool() {
        return this.adapterPool;
    }

    public FilterManager getFilterManager() {
        return this.filterManager;
    }

    public Provider<SegmentManager> getSegmentManager() {
        return this.segmentManager;
    }

    public DisplayConfigLoader getDisplayConfigLoader() {
        return this.displayConfigLoader;
    }

    public Mediator getDisplayStrategy(AdUnit adUnit) {
        switch (adUnit) {
            case BANNER:
                return this.serialMediator;
            case NATIVE:
                return this.nativeMediator;
            default:
                return this.waterfallMediator;
        }
    }

    public String getCustomPublisherData() {
        return this.customPublisherData;
    }

    public InterstitialVideoTracker getInterstitialVideoTracker() {
        return this.interstitialVideoTracker;
    }

    public long getIapAdDisableTime() {
        return this.iapAdDisableTime;
    }

    public LocationProvider getLocationProvider() {
        return this.locationProvider;
    }
}
