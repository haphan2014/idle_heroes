package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import java.security.MessageDigest;

public class zzbo extends zzbl {
    private MessageDigest zzrS;

    byte[] zza(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = zzj(zzbn.zzB(strArr[i]));
        }
        return bArr;
    }

    byte zzj(int i) {
        return (byte) ((((i & MotionEventCompat.ACTION_MASK) ^ ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((ViewCompat.MEASURED_STATE_MASK & i) >> 24));
    }

    public byte[] zzy(String str) {
        byte[] zza = zza(str.split(" "));
        this.zzrS = zzcu();
        synchronized (this.zzqt) {
            if (this.zzrS == null) {
                zza = new byte[0];
            } else {
                this.zzrS.reset();
                this.zzrS.update(zza);
                Object digest = this.zzrS.digest();
                int i = 4;
                if (digest.length <= 4) {
                    i = digest.length;
                }
                zza = new byte[i];
                System.arraycopy(digest, 0, zza, 0, zza.length);
            }
        }
        return zza;
    }
}
