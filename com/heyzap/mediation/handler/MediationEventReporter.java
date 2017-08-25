package com.heyzap.mediation.handler;

import com.facebook.AppEventsConstants;
import com.facebook.Response;
import com.heyzap.common.concurrency.FutureUtils.FutureRunnable;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.EventStream.EventListener;
import com.heyzap.common.net.APIClient;
import com.heyzap.http.JsonHttpResponseHandler;
import com.heyzap.http.RequestParams;
import com.heyzap.internal.Constants;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.ContextReference;
import com.heyzap.mediation.MediationManager;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.MediationResult.NetworkResult;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.NativeAdResult;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class MediationEventReporter {
    private final ContextReference contextRef;
    private final ExecutorService executorService;

    class C14468 extends JsonHttpResponseHandler {
        C14468() {
        }
    }

    class C14479 extends JsonHttpResponseHandler {
        C14479() {
        }
    }

    public MediationEventReporter(ContextReference contextReference, ExecutorService executorService) {
        this.executorService = executorService;
        this.contextRef = contextReference;
    }

    public void sendFetchResults(MediationRequest request, MediationResult result) {
        for (NetworkResult networkResult : result.networkResults) {
            onFetch(new RequestParams(createParams(request, result, networkResult)), networkResult);
        }
    }

    public void bindNativeCallbacks(MediationRequest request, MediationResult result, NativeAdResult nativeAdResult) {
        if (request.getAdUnit() == AdUnit.NATIVE) {
            final Map<String, String> baseParams = createParams(request, result, result.selectedNetwork);
            nativeAdResult.displayEventStream.getFirstEventFuture().addListener(new Runnable() {
                public void run() {
                    MediationEventReporter.this.onImpression(new RequestParams(baseParams));
                }
            }, this.executorService);
            nativeAdResult.clickEventStream.getFirstEventFuture().addListener(new Runnable() {
                public void run() {
                    MediationEventReporter.this.onClick(new RequestParams(baseParams));
                }
            }, this.executorService);
        }
    }

    public void bindDisplayCallbacks(final MediationRequest request, MediationResult result, final AdDisplay adDisplay) {
        final Map<String, String> baseParams = createParams(request, result, result.selectedNetwork);
        if (request.getAdUnit() == AdUnit.BANNER) {
            adDisplay.displayEventStream.addListener(new EventListener<DisplayResult>() {
                public void onEvent(DisplayResult displayResult) {
                    if (displayResult != null && displayResult.success) {
                        RequestParams requestParams = new RequestParams(baseParams);
                        requestParams.put("banner_ordinal", Integer.valueOf(adDisplay.displayEventStream.getEventsCount() - 1));
                        MediationEventReporter.this.onImpression(requestParams);
                    }
                }
            }, this.executorService);
        } else {
            adDisplay.displayEventStream.getFirstEventFuture().addListener(new FutureRunnable<DisplayResult>(adDisplay.displayEventStream.getFirstEventFuture()) {
                public void run(DisplayResult displayResult, Exception e) {
                    if (displayResult != null && displayResult.success) {
                        MediationEventReporter.this.onImpression(new RequestParams(baseParams));
                        if (request.getAdUnit() != AdUnit.NATIVE && request.getAdUnit() != AdUnit.BANNER) {
                            MediationManager.getInstance().addFullscreenImpression();
                        }
                    }
                }
            }, this.executorService);
        }
        if (request.getAdUnit() == AdUnit.BANNER) {
            adDisplay.clickEventStream.addListener(new EventListener<Boolean>() {
                public void onEvent(Boolean event) {
                    RequestParams requestParams = new RequestParams(baseParams);
                    requestParams.put("banner_ordinal", String.valueOf(adDisplay.displayEventStream.getEventsCount() - 1));
                    MediationEventReporter.this.onClick(requestParams);
                }
            }, this.executorService);
        } else {
            adDisplay.clickEventStream.getFirstEventFuture().addListener(new FutureRunnable<Boolean>(adDisplay.clickEventStream.getFirstEventFuture()) {
                public void run(Boolean ran, Exception e) {
                    if (e == null) {
                        MediationEventReporter.this.onClick(new RequestParams(baseParams));
                    }
                }
            }, this.executorService);
        }
        adDisplay.incentiveListener.addListener(new FutureRunnable<Boolean>(adDisplay.incentiveListener) {
            public void run(Boolean complete, Exception e) {
                if (e == null) {
                    MediationEventReporter.this.onIncentiveComplete(new RequestParams(baseParams), complete, request.getIncentivizedInfo());
                }
            }
        }, this.executorService);
    }

    private void onImpression(RequestParams params) {
        APIClient.post(this.contextRef.getApp(), "https://med.heyzap.com/impression", params, new C14468());
    }

    private void onClick(RequestParams params) {
        APIClient.post(this.contextRef.getApp(), "https://med.heyzap.com/click", params, new C14479());
    }

    private void onFetch(RequestParams params, NetworkResult networkResult) {
        if (networkResult.fetchResult.getFetchFailure() != null) {
            params.put("failure_reason", networkResult.fetchResult.getFetchFailure().getErrorType().toString());
        }
        params.put(Response.SUCCESS_KEY, networkResult.fetchResult.success ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        APIClient.post(this.contextRef.getApp(), "https://med.heyzap.com/fetch", params, new JsonHttpResponseHandler() {
        });
    }

    private void onIncentiveComplete(RequestParams params, Boolean complete, String incentiveInfo) {
        if (complete.booleanValue()) {
            params.put("complete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        } else {
            params.put("complete", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        params.put("custom_info", incentiveInfo);
        APIClient.post(this.contextRef.getApp(), "https://med.heyzap.com/complete", params, new JsonHttpResponseHandler() {
        });
    }

    private Map<String, String> createParams(MediationRequest request, MediationResult result, NetworkResult networkResult) {
        Map<String, String> params = new HashMap();
        params.put("tracking_id", networkResult.id);
        params.put("mediation_id", result.id);
        params.put("network", networkResult.network);
        params.put("ad_unit", request.getAdUnit().toString().toLowerCase(Locale.US));
        params.put("tag", Constants.normalizeTag(request.getTag()));
        params.put("network_version", networkResult.adapter == null ? "unknown" : networkResult.adapter.getMarketingVersion());
        params.put("ordinal", String.valueOf(networkResult.ordinal));
        params.put("score", String.valueOf(networkResult.score));
        params.put("creative_type", networkResult.creativeType.toString());
        return params;
    }
}
