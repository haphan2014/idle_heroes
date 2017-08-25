package com.heyzap.common.lifecycle;

import com.heyzap.common.banner.BannerWrapper;
import com.heyzap.internal.Constants.FetchFailureReason;

public class DisplayResult {
    public static final DisplayResult NOT_READY = new DisplayResult("Ad not ready");
    public static final DisplayResult SUCCESS = new DisplayResult();
    public static final DisplayResult UNKNOWN_FAILURE = new DisplayResult("Unknown Failure");
    public static final DisplayResult UNSUPPORTED_AD_UNIT = new DisplayResult("Unsupported Ad Unit");
    public BannerWrapper bannerWrapper;
    public FetchFailureReason errorCode;
    public String errorMessage;
    public boolean success;

    public DisplayResult(String errorMessage) {
        this.success = true;
        this.errorMessage = errorMessage;
        this.success = false;
    }

    public DisplayResult(String errorMessage, FetchFailureReason errorCode) {
        this.success = true;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.success = false;
    }

    public DisplayResult() {
        this.success = true;
        this.success = true;
    }
}
