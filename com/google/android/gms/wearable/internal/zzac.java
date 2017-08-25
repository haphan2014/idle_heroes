package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzac extends zzc implements DataItem {
    private final int zzaoG;

    public zzac(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaoG = i2;
    }

    public /* synthetic */ Object freeze() {
        return zzBe();
    }

    public Map<String, DataItemAsset> getAssets() {
        Map<String, DataItemAsset> hashMap = new HashMap(this.zzaoG);
        for (int i = 0; i < this.zzaoG; i++) {
            zzz com_google_android_gms_wearable_internal_zzz = new zzz(this.zzWu, this.zzYs + i);
            if (com_google_android_gms_wearable_internal_zzz.getDataItemKey() != null) {
                hashMap.put(com_google_android_gms_wearable_internal_zzz.getDataItemKey(), com_google_android_gms_wearable_internal_zzz);
            }
        }
        return hashMap;
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        byte[] data = getData();
        Map assets = getAssets();
        StringBuilder stringBuilder = new StringBuilder("DataItemInternal{ ");
        stringBuilder.append("uri=" + getUri());
        stringBuilder.append(", dataSz=" + (data == null ? "null" : Integer.valueOf(data.length)));
        stringBuilder.append(", numAssets=" + assets.size());
        if (verbose && !assets.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            for (Entry entry : assets.entrySet()) {
                stringBuilder.append(str + ((String) entry.getKey()) + ": " + ((DataItemAsset) entry.getValue()).getId());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public DataItem zzBe() {
        return new zzaa(this);
    }
}
