package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class PutDataRequest implements SafeParcelable {
    public static final Creator<PutDataRequest> CREATOR = new zzf();
    public static final String WEAR_URI_SCHEME = "wear";
    private static final Random zzaSX = new SecureRandom();
    private final Uri mUri;
    final int zzCY;
    private final Bundle zzaSY;
    private byte[] zzauL;

    private PutDataRequest(int versionCode, Uri uri) {
        this(versionCode, uri, new Bundle(), null);
    }

    PutDataRequest(int versionCode, Uri uri, Bundle assets, byte[] data) {
        this.zzCY = versionCode;
        this.mUri = uri;
        this.zzaSY = assets;
        this.zzaSY.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.zzauL = data;
    }

    public static PutDataRequest create(String path) {
        return zzn(zzfg(path));
    }

    public static PutDataRequest createFromDataItem(DataItem source) {
        PutDataRequest zzn = zzn(source.getUri());
        for (Entry entry : source.getAssets().entrySet()) {
            if (((DataItemAsset) entry.getValue()).getId() == null) {
                throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + ((String) entry.getKey()));
            }
            zzn.putAsset((String) entry.getKey(), Asset.createFromRef(((DataItemAsset) entry.getValue()).getId()));
        }
        zzn.setData(source.getData());
        return zzn;
    }

    public static PutDataRequest createWithAutoAppendedId(String pathPrefix) {
        StringBuilder stringBuilder = new StringBuilder(pathPrefix);
        if (!pathPrefix.endsWith("/")) {
            stringBuilder.append("/");
        }
        stringBuilder.append("PN").append(zzaSX.nextLong());
        return new PutDataRequest(1, zzfg(stringBuilder.toString()));
    }

    private static Uri zzfg(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        } else if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        } else if (!str.startsWith("//")) {
            return new Builder().scheme(WEAR_URI_SCHEME).path(str).build();
        } else {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
    }

    public static PutDataRequest zzn(Uri uri) {
        return new PutDataRequest(1, uri);
    }

    public int describeContents() {
        return 0;
    }

    public Asset getAsset(String key) {
        return (Asset) this.zzaSY.getParcelable(key);
    }

    public Map<String, Asset> getAssets() {
        Map hashMap = new HashMap();
        for (String str : this.zzaSY.keySet()) {
            hashMap.put(str, (Asset) this.zzaSY.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public byte[] getData() {
        return this.zzauL;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean hasAsset(String key) {
        return this.zzaSY.containsKey(key);
    }

    public PutDataRequest putAsset(String key, Asset value) {
        zzu.zzu(key);
        zzu.zzu(value);
        this.zzaSY.putParcelable(key, value);
        return this;
    }

    public PutDataRequest removeAsset(String key) {
        this.zzaSY.remove(key);
        return this;
    }

    public PutDataRequest setData(byte[] data) {
        this.zzauL = data;
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable(DataMap.TAG, 3));
    }

    public String toString(boolean verbose) {
        StringBuilder stringBuilder = new StringBuilder("PutDataRequest[");
        stringBuilder.append("dataSz=" + (this.zzauL == null ? "null" : Integer.valueOf(this.zzauL.length)));
        stringBuilder.append(", numAssets=" + this.zzaSY.size());
        stringBuilder.append(", uri=" + this.mUri);
        if (verbose) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.zzaSY.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.zzaSY.getParcelable(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public Bundle zzAR() {
        return this.zzaSY;
    }
}
