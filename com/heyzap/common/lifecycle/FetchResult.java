package com.heyzap.common.lifecycle;

import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.sdk.ads.NativeAdResult;

public class FetchResult {
    public static final FetchResult INTERNAL = new FetchResult(FetchFailureReason.INTERNAL, "Internal Exception");
    public static final FetchResult NOT_READY = new FetchResult(FetchFailureReason.TIMEOUT, "Ad Not Ready");
    public static final FetchResult NO_FILL = new FetchResult(FetchFailureReason.NO_FILL, "No Fill");
    public static final FetchResult SUCCESS = new FetchResult();
    public static final FetchResult TIMEOUT = new FetchResult(FetchFailureReason.TIMEOUT, "Timed Out");
    public static final FetchResult UNSUPPORTED_AD_UNIT = new FetchResult(FetchFailureReason.CONFIGURATION_ERROR, "Unsupported Ad Unit");
    public FetchFailure fetchFailure;
    private NativeAdResult nativeAdResult;
    public boolean success;

    public interface FetchStartedListener {
        void onFetchStarted(AdUnit adUnit, SettableFuture<? extends FetchResult> settableFuture);
    }

    public FetchFailure getFetchFailure() {
        return this.fetchFailure;
    }

    public FetchResult(FetchFailureReason errorCode, String errorMessage) {
        this.nativeAdResult = null;
        this.fetchFailure = new FetchFailure(errorCode, errorMessage);
        this.success = false;
    }

    public FetchResult(FetchFailure fetchFailure) {
        this.nativeAdResult = null;
        this.fetchFailure = fetchFailure;
        this.success = false;
    }

    public FetchResult() {
        this.nativeAdResult = null;
        this.success = true;
    }

    public NativeAdResult getNativeAdResult() {
        return this.nativeAdResult;
    }

    public void setNativeAdResult(NativeAdResult nativeAdResult) {
        this.nativeAdResult = nativeAdResult;
    }

    public String toString() {
        return "FetchResult{nativeAdResult=" + this.nativeAdResult + ", success=" + this.success + ", fetchFailure=" + this.fetchFailure + '}';
    }
}
