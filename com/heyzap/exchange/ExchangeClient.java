package com.heyzap.exchange;

import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.net.APIClient;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.Logger;
import com.heyzap.sdk.ads.HeyzapAds.BannerOptions;
import java.util.EnumSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExchangeClient {

    public static class ExchangeFetch {
        public SettableFuture<ExchangeAd> adFetchedFuture = SettableFuture.create();
        public SettableFuture<ExchangeAd> adLoadedFuture = SettableFuture.create();
    }

    public static EnumSet<CreativeType> getCreativeTypesForAdUnit(AdUnit adUnit) {
        switch (adUnit) {
            case BANNER:
                return EnumSet.of(CreativeType.BANNER);
            case INTERSTITIAL:
                return EnumSet.of(CreativeType.STATIC);
            case VIDEO:
                return EnumSet.of(CreativeType.VIDEO);
            case INCENTIVIZED:
                return EnumSet.of(CreativeType.INCENTIVIZED);
            default:
                return EnumSet.noneOf(CreativeType.class);
        }
    }

    public static ExchangeFetch fetch(ContextReference ref, ExchangeEventReporter reporter, CreativeType creativeType, String url, BannerOptions bannerOptions, int bannerOrdinal, int bannerRefreshAttempt, boolean coppaEnabled, ExecutorService executorService, ExecutorService uiThreadExecutorService) {
        final ExchangeFetch exchangeFetch = new ExchangeFetch();
        final EnumSet<CreativeType> creativeTypes = EnumSet.of(creativeType);
        final ContextReference contextReference = ref;
        final BannerOptions bannerOptions2 = bannerOptions;
        final boolean z = coppaEnabled;
        final CreativeType creativeType2 = creativeType;
        final int i = bannerOrdinal;
        final int i2 = bannerRefreshAttempt;
        final String str = url;
        final ExchangeEventReporter exchangeEventReporter = reporter;
        final ExecutorService executorService2 = uiThreadExecutorService;
        executorService.submit(new Runnable() {
            public void run() {
                Exception ex;
                try {
                    SettableFuture<ExchangeResponseHandler> future = SettableFuture.create();
                    ExchangeRequestParams params = ExchangeRequestParams.create(contextReference.getApp()).forCreativeTypes(creativeTypes, bannerOptions2, z);
                    if (creativeType2 == CreativeType.BANNER) {
                        params = params.withBannerStats(i, i2);
                    }
                    APIClient.simplePost(contextReference.getApp(), str, params, new ExchangeResponseHandler(future, contextReference, creativeTypes, str, params));
                    Logger.debug("ExchangeClient - fetching ad");
                    final ExchangeAd ad = ((ExchangeResponseHandler) future.get(10, TimeUnit.SECONDS)).getAd();
                    Logger.debug("ExchangeClient - got exchange ad " + ad);
                    exchangeFetch.adFetchedFuture.set(ad);
                    exchangeEventReporter.bindFetch(ad, exchangeFetch.adLoadedFuture);
                    executorService2.submit(new Runnable() {
                        public void run() {
                            try {
                                ad.load();
                            } catch (RuntimeException e) {
                                exchangeFetch.adLoadedFuture.setException(e);
                            }
                        }
                    });
                } catch (InterruptedException e) {
                    ex = e;
                    Logger.debug("ExchangeClient - exception fetching ad " + ex);
                    exchangeFetch.adLoadedFuture.setException(ex);
                    exchangeFetch.adFetchedFuture.setException(ex);
                } catch (ExecutionException e2) {
                    ex = e2;
                    Logger.debug("ExchangeClient - exception fetching ad " + ex);
                    exchangeFetch.adLoadedFuture.setException(ex);
                    exchangeFetch.adFetchedFuture.setException(ex);
                } catch (TimeoutException e3) {
                    ex = e3;
                    Logger.debug("ExchangeClient - exception fetching ad " + ex);
                    exchangeFetch.adLoadedFuture.setException(ex);
                    exchangeFetch.adFetchedFuture.setException(ex);
                }
            }
        });
        return exchangeFetch;
    }
}
