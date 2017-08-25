package com.heyzap.sdk.segmentation;

import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import java.util.Date;

public interface PastImpressionStore {
    int getPastImpressionCount(Date date, CreativeType creativeType, AuctionType auctionType, String str);

    void putImpression(CreativeType creativeType, AuctionType auctionType, String str);
}
