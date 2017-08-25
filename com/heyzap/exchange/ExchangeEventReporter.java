package com.heyzap.exchange;

import com.heyzap.common.concurrency.FutureUtils.FutureRunnable;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.common.net.APIClient;
import com.heyzap.http.SyncJsonHttpResponseHandler;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.Logger;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class ExchangeEventReporter {
    private final ContextReference contextRef;
    private final ExecutorService executorService;

    class C13126 extends SyncJsonHttpResponseHandler {
        C13126() {
        }
    }

    class C13137 extends SyncJsonHttpResponseHandler {
        C13137() {
        }
    }

    class C13148 extends SyncJsonHttpResponseHandler {
        C13148() {
        }
    }

    class C13159 extends SyncJsonHttpResponseHandler {
        C13159() {
        }
    }

    public ExchangeEventReporter(ContextReference contextReference, ExecutorService executorService) {
        this.executorService = executorService;
        this.contextRef = contextReference;
    }

    public void bindFetch(final ExchangeAd ad, final SettableFuture<ExchangeAd> fetchFuture) {
        ad.fetchListener.addListener(new FutureRunnable<FetchResult>(ad.fetchListener) {
            public void run(FetchResult result, Exception exception) {
                if (exception != null) {
                    Logger.debug("ExchangeEventReporter - bindFetch - got exception: " + exception);
                    fetchFuture.setException(exception);
                } else if (result == null) {
                    Logger.debug("ExchangeEventReporter - bindFetch - unknown error");
                    fetchFuture.setException(new Throwable("Unknown Error"));
                } else if (result.success) {
                    Logger.debug("ExchangeEventReporter - bindFetch - success");
                    fetchFuture.set(ad);
                } else {
                    Logger.debug("ExchangeEventReporter - bindFetch - failure: " + result.getFetchFailure().getMessage());
                    fetchFuture.setException(new Throwable(result.getFetchFailure().getMessage()));
                    ExchangeEventReporter.this.onAdFailure(ad, result.getFetchFailure().getMessage());
                }
            }
        }, this.executorService);
        ad.expiryListener.addListener(new FutureRunnable<Boolean>(ad.expiryListener) {
            public void run(Boolean result, Exception exception) {
                Logger.debug("ExchangeEventReporter - bindFetch - ad expired");
                ExchangeEventReporter.this.onAdExpired(ad);
            }
        }, this.executorService);
    }

    public void bindDisplay(final ExchangeAd ad, final Map<String, String> params) {
        if (ad == null || !ad.setDisplayReportBound()) {
            Logger.debug("ExchangeEventReporter - bindDisplay - already bound: " + ad);
            return;
        }
        Logger.debug("ExchangeEventReporter - bindDisplay: " + ad);
        ad.displayEventStream.getFirstEventFuture().addListener(new FutureRunnable<DisplayResult>(ad.displayEventStream.getFirstEventFuture()) {
            public void run(DisplayResult result, Exception exception) {
                Logger.debug("ExchangeEventReporter - displayEventStream first event, reporting impression");
                if (result != null && result.success) {
                    ExchangeEventReporter.this.onImpression(ad, params);
                }
            }
        }, this.executorService);
        ad.clickEventStream.getFirstEventFuture().addListener(new FutureRunnable<Boolean>(ad.clickEventStream.getFirstEventFuture()) {
            public void run(Boolean result, Exception exception) {
                if (result.booleanValue()) {
                    ExchangeEventReporter.this.onClick(ad, params);
                }
            }
        }, this.executorService);
        ad.incentiveListener.addListener(new FutureRunnable<Boolean>(ad.incentiveListener) {
            public void run(Boolean result, Exception exception) {
                if (result.booleanValue()) {
                    ExchangeEventReporter.this.onComplete(ad, params);
                }
            }
        }, this.executorService);
    }

    private void onAdExpired(ExchangeAd ad) {
        ExchangeRequestParams params = ExchangeRequestParams.from(ad.getRequestParams());
        params.put("auction_extras", ad.getAuctionData());
        params.put("expiry_seconds", String.valueOf(ad.getExpiry()));
        APIClient.simplePost(this.contextRef.getApp(), String.format("%s/%s/expired", new Object[]{ad.getUrl(), ad.getAdId()}), params, new C13126());
    }

    private void onAdFailure(ExchangeAd ad, String failureReason) {
        ExchangeRequestParams params = ExchangeRequestParams.from(ad.getRequestParams());
        params.put("auction_extras", ad.getAuctionData());
        params.put("markup", ad.getMarkup());
        params.put("fail_reason", failureReason);
        APIClient.simplePost(this.contextRef.getApp(), String.format("%s/%s/failed", new Object[]{ad.getUrl(), ad.getAdId()}), params, new C13137());
    }

    private void onImpression(ExchangeAd ad, Map<String, String> extraParams) {
        ExchangeRequestParams params = ExchangeRequestParams.from(ad.getRequestParams());
        params.merge(extraParams);
        params.put("auction_extras", ad.getAuctionData());
        params.put("markup", ad.getMarkup());
        APIClient.simplePost(this.contextRef.getApp(), String.format("%s/%s/impression", new Object[]{ad.getUrl(), ad.getAdId()}), params, new C13148());
    }

    private void onClick(ExchangeAd ad, Map<String, String> extraParams) {
        ExchangeRequestParams params = ExchangeRequestParams.from(ad.getRequestParams());
        params.merge(extraParams);
        params.put("auction_extras", ad.getAuctionData());
        APIClient.simplePost(this.contextRef.getApp(), String.format("%s/%s/click", new Object[]{ad.getUrl(), ad.getAdId()}), params, new C13159());
    }

    private void onComplete(ExchangeAd ad, Map<String, String> extraParams) {
        ExchangeRequestParams params = ExchangeRequestParams.from(ad.getRequestParams());
        params.merge(extraParams);
        params.put("auction_extras", ad.getAuctionData());
        APIClient.simplePost(this.contextRef.getApp(), String.format("%s/%s/complete", new Object[]{ad.getUrl(), ad.getAdId()}), params, new SyncJsonHttpResponseHandler() {
        });
    }
}
