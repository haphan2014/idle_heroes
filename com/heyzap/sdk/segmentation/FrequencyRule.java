package com.heyzap.sdk.segmentation;

import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FrequencyRule implements SegmentRule {
    private final AuctionType auctionType;
    private final boolean enabled;
    private final List<FrequencyRulePart> parts;
    private final PastImpressionStore store;

    public FrequencyRule(AuctionType auctionType, List<FrequencyRulePart> parts, boolean enabled, PastImpressionStore store) {
        this.parts = parts;
        this.auctionType = auctionType;
        this.enabled = enabled;
        this.store = store;
    }

    public FetchOptions transform(FetchOptions in) {
        return in;
    }

    public DisplayOptions transform(DisplayOptions in) {
        if (!in.getAuctionTypes().contains(this.auctionType)) {
            return in;
        }
        if (this.enabled) {
            DisplayOptions options = in;
            for (FrequencyRulePart part : this.parts) {
                if (this.store.getPastImpressionCount(new Date(new Date().getTime() - (((long) part.getLimitSeconds()) * 1000)), part.getCreativeType(), this.auctionType, in.getTag()) >= part.getLimit()) {
                    if (part.getCreativeType().equals(CreativeType.UNKNOWN)) {
                        options.getCreativeTypes().removeAll(Arrays.asList(CreativeType.values()));
                    } else {
                        options.getCreativeTypes().remove(part.getCreativeType());
                    }
                }
            }
            return options;
        }
        in.getAuctionTypes().remove(this.auctionType);
        return in;
    }

    public boolean transformsFetch() {
        return false;
    }
}
