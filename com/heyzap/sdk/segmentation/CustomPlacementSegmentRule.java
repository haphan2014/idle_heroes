package com.heyzap.sdk.segmentation;

import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.internal.Constants.CreativeType;
import java.util.Map;

public class CustomPlacementSegmentRule implements SegmentRule {
    private Map<String, Map<CreativeType, String>> options;

    public CustomPlacementSegmentRule(Map<String, Map<CreativeType, String>> options) {
        this.options = options;
    }

    public FetchOptions transform(FetchOptions options) {
        return FetchOptions.builder(options.getNetwork(), options.getCreativeType(), options.getAuctionType()).setAdUnit(options.getAdUnits()).setCustomPlacementIdMap(this.options).setNativeAdOptions(options.getNativeAdOptions()).setTags(options.getTags()).build();
    }

    public DisplayOptions transform(DisplayOptions options) {
        return options;
    }

    public boolean transformsFetch() {
        return true;
    }
}
