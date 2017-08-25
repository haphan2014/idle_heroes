package com.heyzap.sdk.segmentation;

import com.heyzap.internal.Constants.CreativeType;

public class FrequencyRulePart {
    private final CreativeType creativeType;
    private final int limit;
    private final int limitSeconds;

    public FrequencyRulePart(CreativeType creativeType, int limit, int limitSeconds) {
        this.creativeType = creativeType;
        this.limit = limit;
        this.limitSeconds = limitSeconds;
    }

    public CreativeType getCreativeType() {
        return this.creativeType;
    }

    public int getLimit() {
        return this.limit;
    }

    public int getLimitSeconds() {
        return this.limitSeconds;
    }
}
