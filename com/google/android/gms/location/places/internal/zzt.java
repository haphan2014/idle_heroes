package com.google.android.gms.location.places.internal;

import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzrd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzt extends zzc {
    private final String TAG = "SafeDataBufferRef";

    public zzt(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    protected String zzB(String str, String str2) {
        return (!zzbV(str) || zzbX(str)) ? str2 : getString(str);
    }

    protected <E extends SafeParcelable> E zza(String str, Creator<E> creator) {
        byte[] zzc = zzc(str, null);
        return zzc == null ? null : com.google.android.gms.common.internal.safeparcel.zzc.zza(zzc, creator);
    }

    protected <E extends SafeParcelable> List<E> zza(String str, Creator<E> creator, List<E> list) {
        byte[] zzc = zzc(str, null);
        if (zzc == null) {
            return list;
        }
        try {
            zzrd zzx = zzrd.zzx(zzc);
            if (zzx.zzaVG == null) {
                return list;
            }
            List<E> arrayList = new ArrayList(zzx.zzaVG.length);
            for (byte[] zza : zzx.zzaVG) {
                arrayList.add(com.google.android.gms.common.internal.safeparcel.zzc.zza(zza, creator));
            }
            return arrayList;
        } catch (Throwable e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    protected List<Integer> zza(String str, List<Integer> list) {
        byte[] zzc = zzc(str, null);
        if (zzc == null) {
            return list;
        }
        try {
            zzrd zzx = zzrd.zzx(zzc);
            if (zzx.zzaVF == null) {
                return list;
            }
            List<Integer> arrayList = new ArrayList(zzx.zzaVF.length);
            for (int valueOf : zzx.zzaVF) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            return arrayList;
        } catch (Throwable e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    protected float zzb(String str, float f) {
        return (!zzbV(str) || zzbX(str)) ? f : getFloat(str);
    }

    protected List<String> zzb(String str, List<String> list) {
        byte[] zzc = zzc(str, null);
        if (zzc != null) {
            try {
                zzrd zzx = zzrd.zzx(zzc);
                if (zzx.zzaVE != null) {
                    list = Arrays.asList(zzx.zzaVE);
                }
            } catch (Throwable e) {
                if (Log.isLoggable("SafeDataBufferRef", 6)) {
                    Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
                }
            }
        }
        return list;
    }

    protected byte[] zzc(String str, byte[] bArr) {
        return (!zzbV(str) || zzbX(str)) ? bArr : getByteArray(str);
    }

    protected boolean zzh(String str, boolean z) {
        return (!zzbV(str) || zzbX(str)) ? z : getBoolean(str);
    }

    protected int zzz(String str, int i) {
        return (!zzbV(str) || zzbX(str)) ? i : getInteger(str);
    }
}
