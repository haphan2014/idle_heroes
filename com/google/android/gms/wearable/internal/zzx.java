package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class zzx implements DataItemAsset {
    private final String zzKI;
    private final String zztw;

    public zzx(DataItemAsset dataItemAsset) {
        this.zzKI = dataItemAsset.getId();
        this.zztw = dataItemAsset.getDataItemKey();
    }

    public /* synthetic */ Object freeze() {
        return zzBd();
    }

    public String getDataItemKey() {
        return this.zztw;
    }

    public String getId() {
        return this.zzKI;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzKI == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.zzKI);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.zztw);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public DataItemAsset zzBd() {
        return this;
    }
}
