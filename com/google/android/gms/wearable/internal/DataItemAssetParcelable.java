package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Creator<DataItemAssetParcelable> CREATOR = new zzy();
    final int zzCY;
    private final String zzKI;
    private final String zztw;

    DataItemAssetParcelable(int versionCode, String id, String key) {
        this.zzCY = versionCode;
        this.zzKI = id;
        this.zztw = key;
    }

    public DataItemAssetParcelable(DataItemAsset value) {
        this.zzCY = 1;
        this.zzKI = (String) zzu.zzu(value.getId());
        this.zztw = (String) zzu.zzu(value.getDataItemKey());
    }

    public int describeContents() {
        return 0;
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
        stringBuilder.append("DataItemAssetParcelable[");
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

    public void writeToParcel(Parcel dest, int flags) {
        zzy.zza(this, dest, flags);
    }

    public DataItemAsset zzBd() {
        return this;
    }
}
