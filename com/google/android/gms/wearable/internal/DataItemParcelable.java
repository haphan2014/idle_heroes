package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DataItemParcelable implements SafeParcelable, DataItem {
    public static final Creator<DataItemParcelable> CREATOR = new zzab();
    private final Uri mUri;
    final int zzCY;
    private final Map<String, DataItemAsset> zzaUo;
    private byte[] zzauL;

    DataItemParcelable(int versionCode, Uri uri, Bundle assetBundle, byte[] data) {
        this.zzCY = versionCode;
        this.mUri = uri;
        Map hashMap = new HashMap();
        assetBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : assetBundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) assetBundle.getParcelable(str));
        }
        this.zzaUo = hashMap;
        this.zzauL = data;
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return zzBf();
    }

    public Map<String, DataItemAsset> getAssets() {
        return this.zzaUo;
    }

    public byte[] getData() {
        return this.zzauL;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDataValid() {
        return true;
    }

    public /* synthetic */ DataItem setData(byte[] x0) {
        return zzv(x0);
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder stringBuilder = new StringBuilder("DataItemParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(",dataSz=" + (this.zzauL == null ? "null" : Integer.valueOf(this.zzauL.length)));
        stringBuilder.append(", numAssets=" + this.zzaUo.size());
        stringBuilder.append(", uri=" + this.mUri);
        if (verbose) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.zzaUo.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.zzaUo.get(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzab.zza(this, dest, flags);
    }

    public Bundle zzAR() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Entry entry : this.zzaUo.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), new DataItemAssetParcelable((DataItemAsset) entry.getValue()));
        }
        return bundle;
    }

    public DataItemParcelable zzBf() {
        return this;
    }

    public DataItemParcelable zzv(byte[] bArr) {
        this.zzauL = bArr;
        return this;
    }
}
