package com.heyzap.common.lifecycle;

import com.heyzap.internal.Constants;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.LargeSet;

public class DisplayOptions {
    final AdUnit adUnit;
    final LargeSet<AuctionType> auctionTypes;
    final LargeSet<CreativeType> creativeTypes;
    final LargeSet<String> networks;
    final String tag;

    public static class Builder {
        private AdUnit adUnit;
        private LargeSet<AuctionType> auctionTypes = LargeSet.ofEverything();
        private LargeSet<CreativeType> creativeTypes = LargeSet.ofEverything();
        private LargeSet<String> networks = LargeSet.ofEverything();
        private String tag = Constants.DEFAULT_TAG;

        Builder(AdUnit adUnit) {
            this.adUnit = adUnit;
        }

        public DisplayOptions build() {
            return new DisplayOptions(this.adUnit, this.tag, this.auctionTypes, this.networks, this.creativeTypes);
        }

        public Builder setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder setNetworks(LargeSet<String> networks) {
            this.networks = networks;
            return this;
        }

        public Builder setAuctionTypes(LargeSet<AuctionType> auctionTypes) {
            this.auctionTypes = auctionTypes;
            return this;
        }

        public Builder setCreativeTypes(LargeSet<CreativeType> creativeTypes) {
            this.creativeTypes = creativeTypes;
            return this;
        }
    }

    public DisplayOptions(AdUnit adUnit, String tag, LargeSet<AuctionType> auctionTypes, LargeSet<String> networks, LargeSet<CreativeType> creativeTypes) {
        this.auctionTypes = auctionTypes;
        this.adUnit = adUnit;
        this.tag = tag;
        this.networks = networks;
        this.creativeTypes = creativeTypes;
    }

    public AdUnit getAdUnit() {
        return this.adUnit;
    }

    public String getTag() {
        return this.tag;
    }

    public LargeSet<String> getNetworks() {
        return this.networks;
    }

    public LargeSet<CreativeType> getCreativeTypes() {
        return this.creativeTypes;
    }

    public LargeSet<AuctionType> getAuctionTypes() {
        return this.auctionTypes;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
        r5 = this;
        r1 = 1;
        r2 = 0;
        if (r5 != r6) goto L_0x0006;
    L_0x0004:
        r2 = r1;
    L_0x0005:
        return r2;
    L_0x0006:
        if (r6 == 0) goto L_0x0005;
    L_0x0008:
        r3 = r5.getClass();
        r4 = r6.getClass();
        if (r3 != r4) goto L_0x0005;
    L_0x0012:
        r0 = r6;
        r0 = (com.heyzap.common.lifecycle.DisplayOptions) r0;
        r3 = r5.adUnit;
        r4 = r0.adUnit;
        if (r3 != r4) goto L_0x0005;
    L_0x001b:
        r3 = r5.tag;
        if (r3 == 0) goto L_0x0056;
    L_0x001f:
        r3 = r5.tag;
        r4 = r0.tag;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0005;
    L_0x0029:
        r3 = r5.networks;
        if (r3 == 0) goto L_0x005b;
    L_0x002d:
        r3 = r5.networks;
        r4 = r0.networks;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0005;
    L_0x0037:
        r3 = r5.auctionTypes;
        if (r3 == 0) goto L_0x0060;
    L_0x003b:
        r3 = r5.auctionTypes;
        r4 = r0.auctionTypes;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0005;
    L_0x0045:
        r3 = r5.creativeTypes;
        if (r3 == 0) goto L_0x0065;
    L_0x0049:
        r3 = r5.creativeTypes;
        r4 = r0.creativeTypes;
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x0054;
    L_0x0053:
        r1 = r2;
    L_0x0054:
        r2 = r1;
        goto L_0x0005;
    L_0x0056:
        r3 = r0.tag;
        if (r3 == 0) goto L_0x0029;
    L_0x005a:
        goto L_0x0005;
    L_0x005b:
        r3 = r0.networks;
        if (r3 == 0) goto L_0x0037;
    L_0x005f:
        goto L_0x0005;
    L_0x0060:
        r3 = r0.auctionTypes;
        if (r3 == 0) goto L_0x0045;
    L_0x0064:
        goto L_0x0005;
    L_0x0065:
        r3 = r0.creativeTypes;
        if (r3 != 0) goto L_0x0053;
    L_0x0069:
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heyzap.common.lifecycle.DisplayOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int result;
        int hashCode;
        int i = 0;
        if (this.adUnit != null) {
            result = this.adUnit.hashCode();
        } else {
            result = 0;
        }
        int i2 = result * 31;
        if (this.tag != null) {
            hashCode = this.tag.hashCode();
        } else {
            hashCode = 0;
        }
        i2 = (i2 + hashCode) * 31;
        if (this.networks != null) {
            hashCode = this.networks.hashCode();
        } else {
            hashCode = 0;
        }
        i2 = (i2 + hashCode) * 31;
        if (this.auctionTypes != null) {
            hashCode = this.auctionTypes.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (i2 + hashCode) * 31;
        if (this.creativeTypes != null) {
            i = this.creativeTypes.hashCode();
        }
        return hashCode + i;
    }

    public static Builder builder(AdUnit adUnit) {
        return new Builder(adUnit);
    }
}
