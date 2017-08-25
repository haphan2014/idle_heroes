package com.heyzap.sdk.mediation.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.PausableRunnable;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.FetchFailure;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.common.lifecycle.FetchResult.FetchStartedListener;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.Logger;
import com.heyzap.internal.ProxyActivity;
import com.heyzap.internal.RetryManager;
import com.heyzap.internal.RetryManager.ExponentialSchedule;
import com.heyzap.internal.RetryManager.RetryableTask;
import com.heyzap.internal.Utils;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.abstr.AdUnitNetworkAdapter;
import com.heyzap.mediation.adapter.AdUnitStateManager;
import com.heyzap.mediation.adapter.FetchStateManager;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds.Network;
import com.heyzap.sdk.ads.HeyzapProxyActivity;
import com.hyprmx.android.sdk.HyprMXHelper;
import com.hyprmx.android.sdk.HyprMXHelper.HyprMXListener;
import com.hyprmx.android.sdk.HyprMXPresentation;
import com.hyprmx.android.sdk.api.data.Offer;
import com.hyprmx.android.sdk.api.data.OffersAvailableResponse;
import com.hyprmx.android.sdk.utility.OnOffersAvailableResponseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class HyprmxAdapter extends AdUnitNetworkAdapter {
    private static String CANON = Network.HYPRMX;
    private static String DISTRIBUTOR_ID_KEY = "distributor_id";
    private static String KLASS = "com.hyprmx.android.sdk.HyprMXPresentation";
    private static String MARKETING_NAME = "HyprMX";
    private static String PROPERTY_ID_KEY = "property_id";
    private AdUnitStateManager adUnitStateManager = new AdUnitStateManager();
    private final FetchStateManager<SettableFuture<HyprmxFetchResult>> fetchStateManager = new FetchStateManager();

    private static class AdFetchListener implements OnOffersAvailableResponseListener {
        private final HyprMXPresentation ad;
        private final SettableFuture<HyprmxFetchResult> fetchFuture;

        public AdFetchListener(SettableFuture<HyprmxFetchResult> fetchFuture, HyprMXPresentation ad) {
            this.fetchFuture = fetchFuture;
            this.ad = ad;
        }

        private FetchFailureReason getFetchFailureReason(int errorCode) {
            return FetchFailureReason.UNKNOWN;
        }

        public void onNoOffersAvailable(OffersAvailableResponse arg0) {
            this.fetchFuture.set(new HyprmxFetchResult(FetchFailureReason.NO_FILL, "No Fill."));
        }

        public void onOffersAvailable(OffersAvailableResponse arg0) {
            this.fetchFuture.set(new HyprmxFetchResult(this.ad));
        }

        public void onError(int i, Exception e) {
            Logger.error("trouble fetching HyprMX ad", e);
            this.fetchFuture.set(new HyprmxFetchResult(getFetchFailureReason(i), e.toString()));
        }
    }

    private static class HyprMXProxyActivity extends ProxyActivity implements HyprMXListener {
        private final AdDisplay adWrapper;

        public HyprMXProxyActivity(Activity context, AdDisplay adWrapper) {
            super(context);
            this.adWrapper = adWrapper;
        }

        public void startActivityForResult(Intent intent, int requestCode) {
            HeyzapProxyActivity.SHADOW_CONTEXT = this;
            Intent parentIntent = new Intent(this, HeyzapProxyActivity.class);
            parentIntent.putExtra("parent_intent", intent);
            parentIntent.putExtra("parent_request_code", requestCode);
            this.adWrapper.displayEventStream.sendEvent(new DisplayResult());
            super.startActivityForResult(parentIntent, requestCode);
        }

        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            HyprMXHelper.processActivityResult(this, requestCode, resultCode, data, this);
            this.adWrapper.closeListener.set(Boolean.valueOf(true));
            super.onActivityResult(requestCode, resultCode, data);
        }

        public void onNoContentAvailable() {
            this.adWrapper.displayEventStream.sendEvent(new DisplayResult("No ad available"));
        }

        public void onOfferCancelled(Offer arg0) {
            this.adWrapper.incentiveListener.set(Boolean.valueOf(false));
        }

        public void onOfferCompleted(Offer arg0) {
            this.adWrapper.incentiveListener.set(Boolean.valueOf(true));
        }

        public void onUserOptedOut() {
            this.adWrapper.incentiveListener.set(Boolean.valueOf(false));
        }
    }

    private static class HyprmxFetchResult extends FetchResult {
        public final HyprMXPresentation ad;

        public HyprmxFetchResult(FetchFailureReason errorCode, String errorMessage) {
            this.fetchFailure = new FetchFailure(errorCode, errorMessage);
            this.success = false;
            this.ad = null;
        }

        public HyprmxFetchResult(HyprMXPresentation ad) {
            this.ad = ad;
            this.success = true;
        }
    }

    public boolean isInterstitialVideo() {
        return true;
    }

    public Boolean isOnBoard() {
        return Utils.classExists(KLASS);
    }

    public String getMarketingName() {
        return MARKETING_NAME;
    }

    public String getMarketingVersion() {
        return "56";
    }

    public String getCanonicalName() {
        return CANON;
    }

    private SettableFuture<HyprmxFetchResult> createFetchFuture() {
        return SettableFuture.create();
    }

    public void onInit() {
        SettableFuture<HyprmxFetchResult> future = SettableFuture.create();
        future.set(new HyprmxFetchResult(FetchFailureReason.CONFIGURATION_ERROR, "unsupported ad unit"));
        this.fetchStateManager.setDefaultValue(future);
        this.fetchStateManager.set(AdUnit.INCENTIVIZED, createFetchFuture());
    }

    protected void onStart() {
        final String distributorID = getConfiguration().getValue(DISTRIBUTOR_ID_KEY);
        final String propertyID = getConfiguration().getValue(PROPERTY_ID_KEY);
        final String userID = Utils.getAdvertisingId(getContextRef().getActivity());
        new Handler(getContextRef().getActivity().getMainLooper()).post(new Runnable() {
            public void run() {
                HyprMXHelper.getInstance(HyprmxAdapter.this.getContextRef().getApp(), distributorID, propertyID, userID);
            }
        });
    }

    public List<String> getPermissions() {
        return Arrays.asList(new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public List<String> getActivities() {
        return Arrays.asList(new String[]{"com.hyprmx.android.sdk.activity.HyprMXOfferViewerActivity", "com.hyprmx.android.sdk.activity.HyprMXRequiredInformationActivity", "com.hyprmx.android.sdk.activity.HyprMXNoOffersActivity", "com.hyprmx.android.sdk.activity.HyprMXWebTrafficActivity", "com.heyzap.sdk.ads.HeyzapProxyActivity"});
    }

    public SettableFuture<FetchResult> startAdUnits(Collection<AdUnit> adUnitList) {
        Set<AdUnit> startedUnits = this.adUnitStateManager.start(adUnitList);
        startedUnits.retainAll(getConfiguredAdUnitCapabilities());
        final SettableFuture<FetchResult> result = SettableFuture.create();
        if (startedUnits.size() > 0) {
            List<SettableFuture> futures = new ArrayList();
            for (AdUnit adUnit : startedUnits) {
                attemptNextFetch(adUnit);
                futures.add(awaitAvailability(adUnit));
            }
            FutureUtils.allOf(futures, this.executorService).addListener(new Runnable() {
                public void run() {
                    result.set(new FetchResult());
                }
            }, this.executorService);
        } else {
            result.set(new FetchResult());
        }
        return result;
    }

    public SettableFuture<FetchResult> awaitAvailability(AdUnit adUnit) {
        return (SettableFuture) this.fetchStateManager.get(adUnit);
    }

    public boolean isAdUnitStarted(Collection<AdUnit> adUnitList) {
        return this.adUnitStateManager.allStarted(adUnitList);
    }

    private void attemptNextFetch(AdUnit adUnit) {
        final SettableFuture<HyprmxFetchResult> fetchResultFuture = (SettableFuture) this.fetchStateManager.get(adUnit);
        final AdUnit adUnit2 = adUnit;
        getFetchConsumer().consumeAny(Arrays.asList(new AdUnit[]{adUnit}), new PausableRunnable(this.pauseSignal, this.executorService) {

            class C15651 extends RetryableTask {

                class C15641 implements Runnable {
                    C15641() {
                    }

                    public void run() {
                        FetchResult fetchResult = (FetchResult) FutureUtils.getImmediatelyOrDefault(fetchResultFuture, FetchResult.NOT_READY);
                        if (!fetchResult.success) {
                            HyprmxAdapter.this.setLastFailure(adUnit2, fetchResult.fetchFailure);
                            HyprmxAdapter.this.fetchStateManager.set(adUnit2, HyprmxAdapter.this.createFetchFuture());
                            C15651.this.retry();
                        }
                    }
                }

                C15651() {
                }

                public void run() {
                    HyprmxAdapter.this.fetchStateManager.start(adUnit2);
                    FutureUtils.bind(HyprmxAdapter.this.fetch(adUnit2), fetchResultFuture, HyprmxAdapter.this.executorService);
                    fetchResultFuture.addListener(new C15641(), HyprmxAdapter.this.executorService);
                }
            }

            public void runWhenUnpaused() {
                new RetryManager(new C15651(), new ExponentialSchedule(2.0d, 4, TimeUnit.SECONDS), HyprmxAdapter.this.executorService).start();
            }
        }, this.executorService);
    }

    public SettableFuture<HyprmxFetchResult> fetch(AdUnit adUnit) {
        final SettableFuture<HyprmxFetchResult> fetchFuture = SettableFuture.create();
        switch (adUnit) {
            case INCENTIVIZED:
                final HyprMXPresentation ad = new HyprMXPresentation();
                new Handler(getContextRef().getActivity().getMainLooper()).post(new Runnable() {
                    public void run() {
                        ad.prepare(new AdFetchListener(fetchFuture, ad));
                    }
                });
                break;
            default:
                fetchFuture.set(new HyprmxFetchResult(FetchFailureReason.CONFIGURATION_ERROR, "ad unit not supported"));
                break;
        }
        return fetchFuture;
    }

    public AdDisplay show(final MediationRequest mediationRequest, MediationResult mediationResult) {
        final AdDisplay adWrapper = new AdDisplay();
        this.uiThreadExecutorService.submit(new Runnable() {
            public void run() {
                final HyprMXProxyActivity proxyActivity = new HyprMXProxyActivity(mediationRequest.getRequestingActivity(), adWrapper);
                SettableFuture<HyprmxFetchResult> localFetch = (SettableFuture) HyprmxAdapter.this.fetchStateManager.get(mediationRequest.getAdUnit());
                HyprmxFetchResult fetchResult = null;
                if (localFetch.isDone()) {
                    try {
                        fetchResult = (HyprmxFetchResult) localFetch.get();
                    } catch (Throwable e) {
                        Logger.trace(e);
                    }
                }
                if (fetchResult == null || !fetchResult.success) {
                    adWrapper.displayEventStream.sendEvent(new DisplayResult("Ad not ready"));
                    return;
                }
                switch (mediationRequest.getAdUnit()) {
                    case INCENTIVIZED:
                        final HyprmxFetchResult finalFetchResult = fetchResult;
                        new Handler(HyprmxAdapter.this.getContextRef().getActivity().getMainLooper()).post(new Runnable() {
                            public void run() {
                                if (finalFetchResult.ad != null) {
                                    finalFetchResult.ad.show(proxyActivity);
                                }
                            }
                        });
                        break;
                    default:
                        adWrapper.displayEventStream.sendEvent(new DisplayResult("Unsupported ad unit"));
                        break;
                }
                if (localFetch.isDone()) {
                    HyprmxAdapter.this.fetchStateManager.set(mediationRequest.getAdUnit(), HyprmxAdapter.this.createFetchFuture());
                    HyprmxAdapter.this.attemptNextFetch(mediationRequest.getAdUnit());
                }
            }
        });
        return adWrapper;
    }

    public void addFetchStartedListener(final FetchStartedListener fetchStartedListener, ExecutorService executorService) {
        this.fetchStateManager.addFetchStartedListener(new FetchStateManager.FetchStartedListener<SettableFuture<HyprmxFetchResult>>() {
            public void onFetchStarted(AdUnit adUnit, SettableFuture<HyprmxFetchResult> future) {
                fetchStartedListener.onFetchStarted(adUnit, future);
            }
        }, executorService);
    }

    public EnumSet<AdUnit> getAllAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INCENTIVIZED);
    }

    public EnumSet<AdUnit> getConfiguredAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INCENTIVIZED);
    }

    public EnumSet<AdUnit> getAdUnitsForCreativeType(CreativeType creativeType) {
        switch (creativeType) {
            case INCENTIVIZED:
                return EnumSet.of(AdUnit.INCENTIVIZED);
            default:
                return EnumSet.noneOf(AdUnit.class);
        }
    }

    public boolean onBackPressed() {
        return false;
    }
}
