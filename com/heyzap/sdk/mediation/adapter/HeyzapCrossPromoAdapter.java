package com.heyzap.sdk.mediation.adapter;

import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import java.util.EnumSet;

public class HeyzapCrossPromoAdapter extends HeyzapAdapter {
    private static AuctionType AUCTION_TYPE = AuctionType.CROSS_PROMO;
    private static EnumSet<CreativeType> CREATIVE_TYPES = EnumSet.of(CreativeType.STATIC, CreativeType.VIDEO);

    public String getMarketingName() {
        return "Heyzap Cross Promo";
    }

    public String getCanonicalName() {
        return "heyzap_cross_promo";
    }

    public AuctionType getAuctionType() {
        return AUCTION_TYPE;
    }
}
