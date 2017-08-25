package com.heyzap.common.lifecycle;

import com.heyzap.internal.Constants.FetchFailureReason;

public class FetchFailure {
    private final FetchFailureReason errorType;
    private final String message;

    public FetchFailure(FetchFailureReason errorType, String message) {
        this.errorType = errorType;
        this.message = message;
    }

    public FetchFailureReason getErrorType() {
        return this.errorType;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return "FetchFailure{errorType=" + this.errorType + ", message='" + this.message + '\'' + '}';
    }
}
