package com.heyzap.common.lifecycle;

import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;

public class ImpressionOptions {
    final AdUnit adUnit;
    final AuctionType auctionType;
    final CreativeType creativeType;
    final String network;
    final String tag;

    public ImpressionOptions(AdUnit adUnit, String tag, String network, AuctionType auctionType, CreativeType creativeType) {
        this.adUnit = adUnit;
        this.tag = tag;
        this.network = network;
        this.auctionType = auctionType;
        this.creativeType = creativeType;
    }

    public AdUnit getAdUnit() {
        return this.adUnit;
    }

    public String getTag() {
        return this.tag;
    }

    public String getNetwork() {
        return this.network;
    }

    public AuctionType getAuctionType() {
        return this.auctionType;
    }

    public CreativeType getCreativeType() {
        return this.creativeType;
    }
}
