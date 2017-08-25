package com.heyzap.mediation;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.common.concurrency.FutureUtils.FutureRunnable;
import com.heyzap.common.concurrency.HandlerExecutorService;
import com.heyzap.common.concurrency.ListenableFuture;
import com.heyzap.common.concurrency.PausableRunnable.PauseSignal;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchFailure;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.house.Manager;
import com.heyzap.internal.Constants;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.Constants.MediationFetchMode;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.DevLogger;
import com.heyzap.internal.LargeSet;
import com.heyzap.internal.Logger;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.config.ConfigLoader.MediationConfigListener;
import com.heyzap.mediation.config.MediationConfig;
import com.heyzap.mediation.config.MediationConfigLoader;
import com.heyzap.mediation.display.DisplayConfig;
import com.heyzap.mediation.filters.FilterContext;
import com.heyzap.mediation.handler.MediationEventReporter;
import com.heyzap.mediation.handler.NetworkCallbackListenerProxy;
import com.heyzap.mediation.handler.StatusListenerMultiplexer;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.HeyzapAds.AdsConfig;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallbackListener;
import com.heyzap.sdk.ads.HeyzapAds.OnIncentiveResultListener;
import com.heyzap.sdk.ads.HeyzapAds.OnStatusListener;
import com.heyzap.sdk.ads.NativeAd.Image;
import com.heyzap.sdk.ads.NativeAdResult;
import com.heyzap.sdk.segmentation.SegmentManager;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class MediationManager {
    public static NetworkCallbackListenerProxy networkCallbackListenerProxy = new NetworkCallbackListenerProxy();
    private static volatile MediationManager ref;
    private static int sessionFullscreenAdImpressions;
    private final AdsConfig adsConfig = HeyzapAds.config;
    private final MediationConfigLoader configLoader = new MediationConfigLoader(this.contextRef, this.executorService, this.uiThreadExecutorService, this.fetchRequestStore, this.adsConfig, networkCallbackListenerProxy, this.pauseExpensiveWorkSignal);
    private final ContextReference contextRef = new ContextReference();
    private final ScheduledThreadPoolExecutor executorService = ExecutorPool.getInstance();
    private MediationFetchMode fetchMode = MediationFetchMode.HEYZAP;
    private final FetchRequestStore fetchRequestStore = new FetchRequestStore();
    private final MediationEventReporter mediationEventReporter = new MediationEventReporter(this.contextRef, ExecutorPool.getInstance());
    private final PauseSignal pauseExpensiveWorkSignal = new PauseSignal();
    private HashMap<AdUnit, StatusListenerMultiplexer> statusListenerMultiplexers = new HashMap();
    private Date timeTillAds = new Date(1970, 0, 0);
    public final ExecutorService uiThreadExecutorService = new HandlerExecutorService(new Handler(Looper.getMainLooper()));

    class C13971 implements Runnable {
        C13971() {
        }

        public void run() {
            MediationManager.this.configLoader.start();
            MediationManager.this.fetchRequestStore.makeUnlimited(AdUnit.BANNER);
            if ((MediationManager.this.adsConfig.flags & 1) == 0) {
                MediationManager.this.fetch(AdUnit.INTERSTITIAL, Constants.DEFAULT_TAG);
            }
        }
    }

    class C14003 implements Runnable {
        C14003() {
        }

        public void run() {
            MediationManager.this.contextRef.getApp().getSharedPreferences(Constants.PREFERENCES_KEY, 0).edit().putLong("time_till_ads", MediationManager.this.timeTillAds.getTime()).commit();
        }
    }

    public MediationManager() {
        initStatusListenerMultiplexers();
    }

    public static synchronized MediationManager getInstance() {
        MediationManager mediationManager;
        synchronized (MediationManager.class) {
            if (ref == null) {
                ref = new MediationManager();
            }
            mediationManager = ref;
        }
        return mediationManager;
    }

    private void initStatusListenerMultiplexers() {
        for (AdUnit adUnit : AdUnit.values()) {
            StatusListenerMultiplexer multiplexer = new StatusListenerMultiplexer(this.executorService);
            if (adUnit.equals(AdUnit.VIDEO) || adUnit.equals(AdUnit.INCENTIVIZED)) {
                multiplexer.setUsesAudio(true);
            }
            this.statusListenerMultiplexers.put(adUnit, multiplexer);
        }
    }

    public void start(Context context) {
        Manager.applicationContext = context.getApplicationContext();
        this.contextRef.updateContext(context);
        this.timeTillAds = new Date(this.contextRef.getApp().getSharedPreferences(Constants.PREFERENCES_KEY, 0).getLong("time_till_ads", System.currentTimeMillis()));
        sessionFullscreenAdImpressions = 0;
        this.executorService.execute(new C13971());
    }

    public MediationRequest display(final MediationRequest mediationRequest) {
        this.contextRef.updateContext(mediationRequest.getRequestingActivity());
        if (mediationRequest.getExecutorService() == null) {
            mediationRequest.setExecutorService(this.executorService);
        }
        this.configLoader.get(new MediationConfigListener() {
            public void onConfigLoaded(final MediationConfig config) {
                final FilterContext filterContext = new FilterContext(mediationRequest.getAdUnit(), mediationRequest.getTag());
                if (config.getFilterManager().accept(filterContext)) {
                    ListenableFuture<MediationResult> mediationResultFuture = config.getDisplayStrategy(mediationRequest.getAdUnit()).mediate(mediationRequest);
                    mediationResultFuture.addListener(new FutureRunnable<MediationResult>(mediationResultFuture) {
                        public void run(MediationResult mediationResult, Exception e) {
                            if (e != null) {
                                Logger.error("Mediation Failed", e);
                                ((StatusListenerMultiplexer) MediationManager.this.statusListenerMultiplexers.get(mediationRequest.getAdUnit())).sendDisplayFailed(mediationRequest.getTag());
                                mediationRequest.sendDisplayFailed("mediation failed");
                                return;
                            }
                            MediationManager.this.mediationEventReporter.sendFetchResults(mediationRequest, mediationResult);
                            if (mediationResult.selectedNetwork != null) {
                                DevLogger.info(String.format("Selected Network: %s", new Object[]{mediationResult.selectedNetwork.adapter.getMarketingName()}));
                                AdDisplay display = mediationResult.display;
                                if (display == null) {
                                    display = mediationResult.selectedNetwork.adapter.show(mediationRequest, mediationResult, mediationResult.displayOptions);
                                }
                                MediationManager.this.mediationEventReporter.bindDisplayCallbacks(mediationRequest, mediationResult, display);
                                ((StatusListenerMultiplexer) MediationManager.this.statusListenerMultiplexers.get(mediationRequest.getAdUnit())).addDisplay(display, mediationRequest.getTag());
                                config.getInterstitialVideoTracker().addDisplay(mediationRequest, mediationResult.selectedNetwork, display);
                                config.getFilterManager().addDisplay(filterContext, display);
                                mediationRequest.addDisplay(display);
                                if ((MediationManager.this.adsConfig.flags & 1) == 0) {
                                    MediationManager.this.fetch(mediationRequest.getAdUnit(), mediationRequest.getTag());
                                }
                                if (display.impressionOptions != null) {
                                    ((SegmentManager) config.getSegmentManager().get()).onImpression(display.impressionOptions);
                                    return;
                                }
                                return;
                            }
                            mediationRequest.sendDisplayFailed("no selected network");
                            ((StatusListenerMultiplexer) MediationManager.this.statusListenerMultiplexers.get(mediationRequest.getAdUnit())).sendDisplayFailed(mediationRequest.getTag());
                        }
                    }, MediationManager.this.executorService);
                    return;
                }
                ((StatusListenerMultiplexer) MediationManager.this.statusListenerMultiplexers.get(mediationRequest.getAdUnit())).sendDisplayFailed(mediationRequest.getTag());
                mediationRequest.sendDisplayFailed("mediation failed");
            }
        });
        return mediationRequest;
    }

    public void setAdsTimeout(long timeout) {
        this.timeTillAds = new Date(System.currentTimeMillis() + timeout);
        ExecutorPool.getInstance().execute(new C14003());
    }

    public boolean adsTimedOut() {
        return new Date().before(this.timeTillAds);
    }

    public boolean isAvailable(AdUnit adUnit, String tag) {
        ListenableFuture<MediationConfig> configFuture = this.configLoader.getFuture();
        if (!configFuture.isDone()) {
            return false;
        }
        try {
            MediationConfig config = (MediationConfig) configFuture.get();
            SettableFuture<DisplayConfig> displayConfigFuture = config.getDisplayConfigLoader().peek();
            if (!displayConfigFuture.isDone()) {
                return false;
            }
            try {
                DisplayConfig displayConfig = (DisplayConfig) displayConfigFuture.get();
                if (!config.getFilterManager().accept(new FilterContext(adUnit, tag))) {
                    return false;
                }
                boolean interstitialVideoAllowed = displayConfig.interstitialVideoEnabled && config.getInterstitialVideoTracker().interstitialCooldownExpired(displayConfig.interstitialVideoInterval);
                Collection creativeTypes = adUnit.creativeTypes();
                if (!interstitialVideoAllowed) {
                    creativeTypes.remove(CreativeType.VIDEO);
                }
                for (DisplayOptions option : ((SegmentManager) config.getSegmentManager().get()).transform(DisplayOptions.builder(adUnit).setTag(tag).setCreativeTypes(new LargeSet(creativeTypes)).build())) {
                    for (NetworkAdapter adapter : config.getAdapterPool().getAll()) {
                        if (adapter.isReady(option)) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public void fetch(final AdUnit adUnit, String ptag) {
        String tag;
        if (ptag == null) {
            tag = Constants.DEFAULT_TAG;
        } else {
            tag = ptag;
        }
        if ((this.adsConfig.flags & 1) == 0) {
            this.fetchRequestStore.makeUnlimited(adUnit);
        } else {
            this.fetchRequestStore.add(adUnit);
        }
        ((StatusListenerMultiplexer) this.statusListenerMultiplexers.get(adUnit)).addFetch(adUnit, tag, this.configLoader.getFuture());
        this.configLoader.get(new MediationConfigListener() {
            public void onConfigLoaded(MediationConfig config) {
                SegmentManager segmentManager = (SegmentManager) config.getSegmentManager().get();
                for (NetworkAdapter adapter : MediationManager.this.configLoader.getPool().getAll()) {
                    Iterator it = adUnit.creativeTypes().iterator();
                    while (it.hasNext()) {
                        FetchOptions transformedOptions = segmentManager.transform(FetchOptions.builder(adapter.getCanonicalName(), (CreativeType) it.next(), adapter.getAuctionType()).setTags(LargeSet.of(tag)).build());
                        if (transformedOptions.getCustomPlacementId() != null) {
                            adapter.start(transformedOptions);
                        }
                    }
                }
            }
        });
    }

    public SettableFuture<NativeAdResult> fetchNative(final MediationRequest mediationRequest) {
        final SettableFuture<NativeAdResult> nativeAdResultFuture = SettableFuture.create();
        this.configLoader.get(new MediationConfigListener() {
            public void onConfigLoaded(MediationConfig config) {
                ListenableFuture<MediationResult> mediationResultFuture = config.getDisplayStrategy(mediationRequest.getAdUnit()).mediate(mediationRequest);
                mediationResultFuture.addListener(new FutureRunnable<MediationResult>(mediationResultFuture) {
                    public void run(MediationResult mediationResult, Exception exception) {
                        FetchFailure fetchFailure = null;
                        if (exception != null) {
                            fetchFailure = new FetchFailure(FetchFailureReason.INTERNAL, exception.getLocalizedMessage());
                        }
                        if (mediationResult != null) {
                            MediationManager.this.mediationEventReporter.sendFetchResults(mediationRequest, mediationResult);
                            if (!(mediationResult.selectedNetwork == null || mediationResult.selectedNetwork.fetchResult == null)) {
                                if (mediationResult.selectedNetwork.fetchResult.fetchFailure != null) {
                                    fetchFailure = mediationResult.selectedNetwork.fetchResult.fetchFailure;
                                } else {
                                    NativeAdResult nativeAdResult = mediationResult.selectedNetwork.fetchResult.getNativeAdResult();
                                    nativeAdResult.setNetwork(mediationResult.selectedNetwork.network);
                                    MediationManager.this.mediationEventReporter.bindNativeCallbacks(mediationRequest, mediationResult, nativeAdResult);
                                    nativeAdResultFuture.set(nativeAdResult);
                                    return;
                                }
                            }
                            if (mediationResult.getError() != null) {
                                fetchFailure = new FetchFailure(FetchFailureReason.UNKNOWN, mediationResult.getError());
                            }
                        } else {
                            fetchFailure = new FetchFailure(FetchFailureReason.UNKNOWN, "Unknown error during fetch");
                        }
                        final FetchFailure failure = fetchFailure;
                        nativeAdResultFuture.set(new NativeAdResult() {
                            public void registerView(View view) {
                            }

                            public void onImpression() {
                            }

                            public void onClick(View view) {
                            }

                            public String getTitle() {
                                return null;
                            }

                            public Image getIcon() {
                                return null;
                            }

                            public Image getCoverImage() {
                                return null;
                            }

                            public String getBody() {
                                return null;
                            }

                            public FetchFailure getFetchFailure() {
                                return failure;
                            }

                            public String getCallToAction() {
                                return null;
                            }

                            public String getSocialContext() {
                                return null;
                            }

                            public Image getAdChoicesImage() {
                                return null;
                            }

                            public String getAdChoicesUrl() {
                                return null;
                            }

                            public Object getNativeAdObject() {
                                return null;
                            }
                        });
                    }
                }, MediationManager.this.executorService);
            }
        });
        return nativeAdResultFuture;
    }

    public ContextReference getContextRef() {
        return this.contextRef;
    }

    public void setRecentActivity(Activity activity) {
        this.contextRef.updateContext(activity);
    }

    public void setOnStatusListener(AdUnit adUnit, OnStatusListener listener) {
        ((StatusListenerMultiplexer) this.statusListenerMultiplexers.get(adUnit)).setListener(listener);
    }

    public void setOnIncentiveResultListener(OnIncentiveResultListener listener) {
        ((StatusListenerMultiplexer) this.statusListenerMultiplexers.get(AdUnit.INCENTIVIZED)).setIncentiveListener(listener);
    }

    public void setNetworkCallbackListener(NetworkCallbackListener listener) {
        networkCallbackListenerProxy.setNetworkCallbackListener(listener);
    }

    public MediationConfigLoader getConfigLoader() {
        return this.configLoader;
    }

    public void addFullscreenImpression() {
        sessionFullscreenAdImpressions++;
    }

    public static int getSessionFullscreenAdImpressions() {
        return sessionFullscreenAdImpressions;
    }

    public PauseSignal getPauseExpensiveWorkSignal() {
        return this.pauseExpensiveWorkSignal;
    }
}
