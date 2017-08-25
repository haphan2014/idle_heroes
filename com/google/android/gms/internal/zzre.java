package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;

public class zzre {
    private final byte[] zzaVH = new byte[256];
    private int zzaVI;
    private int zzaVJ;

    public zzre(byte[] bArr) {
        int i;
        for (i = 0; i < 256; i++) {
            this.zzaVH[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            i = ((i + this.zzaVH[i2]) + bArr[i2 % bArr.length]) & MotionEventCompat.ACTION_MASK;
            byte b = this.zzaVH[i2];
            this.zzaVH[i2] = this.zzaVH[i];
            this.zzaVH[i] = b;
        }
        this.zzaVI = 0;
        this.zzaVJ = 0;
    }

    public void zzy(byte[] bArr) {
        int i = this.zzaVI;
        int i2 = this.zzaVJ;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.zzaVH[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.zzaVH[i];
            this.zzaVH[i] = this.zzaVH[i2];
            this.zzaVH[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.zzaVH[(this.zzaVH[i] + this.zzaVH[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.zzaVI = i;
        this.zzaVJ = i2;
    }
}
