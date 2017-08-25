package com.heyzap.common.lifecycle;

import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.LargeSet;
import com.heyzap.sdk.ads.NativeAd.NativeAdOptions;
import java.util.Collections;
import java.util.Map;

public class FetchOptions {
    final LargeSet<AdUnit> adUnits;
    final AuctionType auctionType;
    final CreativeType creativeType;
    final String customPlacementId;
    final NativeAdOptions nativeAdOptions;
    final String network;
    final LargeSet<String> tags;

    public static class Builder {
        private LargeSet<AdUnit> adUnits = LargeSet.ofEverything();
        private AuctionType auctionType;
        private CreativeType creativeType;
        private Map<String, Map<CreativeType, String>> customPlacementId = Collections.emptyMap();
        private NativeAdOptions nativeAdOptions = new NativeAdOptions();
        private String network;
        private LargeSet<String> tags = LargeSet.ofEverything();

        public Builder(String network, CreativeType creativeType, AuctionType auctionType) {
            this.network = network;
            this.creativeType = creativeType;
            this.auctionType = auctionType;
        }

        public Builder setAdUnit(LargeSet<AdUnit> adUnits) {
            this.adUnits = adUnits;
            return this;
        }

        public Builder setTags(LargeSet<String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder setCustomPlacementIdMap(Map<String, Map<CreativeType, String>> customPlacementId) {
            this.customPlacementId = customPlacementId;
            return this;
        }

        public Builder setNativeAdOptions(NativeAdOptions nativeAdOptions) {
            this.nativeAdOptions = nativeAdOptions;
            return this;
        }

        public FetchOptions build() {
            return new FetchOptions(this.network, this.creativeType, this.auctionType, this.adUnits, this.tags, this.customPlacementId, this.nativeAdOptions);
        }
    }

    public FetchOptions(String network, CreativeType creativeType, AuctionType auctionType, LargeSet<AdUnit> adUnits, LargeSet<String> tags, Map<String, Map<CreativeType, String>> customPlacementId, NativeAdOptions nativeAdOptions) {
        this.adUnits = adUnits;
        this.auctionType = auctionType;
        this.tags = tags;
        this.network = network;
        this.creativeType = creativeType;
        if (customPlacementId.get(getNetwork()) != null) {
            this.customPlacementId = (String) ((Map) customPlacementId.get(getNetwork())).get(getCreativeType());
        } else {
            this.customPlacementId = null;
        }
        this.nativeAdOptions = nativeAdOptions;
    }

    public LargeSet<AdUnit> getAdUnits() {
        return this.adUnits;
    }

    public LargeSet<String> getTags() {
        return this.tags;
    }

    public String getNetwork() {
        return this.network;
    }

    public CreativeType getCreativeType() {
        return this.creativeType;
    }

    public AuctionType getAuctionType() {
        return this.auctionType;
    }

    public String getCustomPlacementId() {
        return this.customPlacementId;
    }

    public NativeAdOptions getNativeAdOptions() {
        return this.nativeAdOptions;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FetchOptions that = (FetchOptions) o;
        if (this.adUnits != null) {
            if (!this.adUnits.equals(that.adUnits)) {
                return false;
            }
        } else if (that.adUnits != null) {
            return false;
        }
        if (this.auctionType != that.auctionType) {
            return false;
        }
        if (this.tags != null) {
            if (!this.tags.equals(that.tags)) {
                return false;
            }
        } else if (that.tags != null) {
            return false;
        }
        if (this.network != null) {
            if (!this.network.equals(that.network)) {
                return false;
            }
        } else if (that.network != null) {
            return false;
        }
        if (this.creativeType != that.creativeType) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int result;
        int hashCode;
        int i = 0;
        if (this.adUnits != null) {
            result = this.adUnits.hashCode();
        } else {
            result = 0;
        }
        int i2 = result * 31;
        if (this.auctionType != null) {
            hashCode = this.auctionType.hashCode();
        } else {
            hashCode = 0;
        }
        i2 = (i2 + hashCode) * 31;
        if (this.tags != null) {
            hashCode = this.tags.hashCode();
        } else {
            hashCode = 0;
        }
        i2 = (i2 + hashCode) * 31;
        if (this.network != null) {
            hashCode = this.network.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (i2 + hashCode) * 31;
        if (this.creativeType != null) {
            i = this.creativeType.hashCode();
        }
        return hashCode + i;
    }

    public static Builder builder(String network, CreativeType creativeType, AuctionType auctionType) {
        return new Builder(network, creativeType, auctionType);
    }
}
