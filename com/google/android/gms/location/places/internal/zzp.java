package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.location.places.zzg;

public class zzp implements zzg {
    private int mIndex;
    private final String zzaAW;
    private final CharSequence zzaAX;
    private final int zzyZ;
    private final int zzza;

    public zzp(String str, int i, int i2, CharSequence charSequence, int i3) {
        this.zzaAW = str;
        this.zzyZ = i;
        this.zzza = i2;
        this.zzaAX = charSequence;
        this.mIndex = i3;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof zzp)) {
            return false;
        }
        zzp com_google_android_gms_location_places_internal_zzp = (zzp) other;
        return com_google_android_gms_location_places_internal_zzp.zzyZ == this.zzyZ && com_google_android_gms_location_places_internal_zzp.zzza == this.zzza && zzt.equal(com_google_android_gms_location_places_internal_zzp.zzaAW, this.zzaAW) && zzt.equal(com_google_android_gms_location_places_internal_zzp.zzaAX, this.zzaAX);
    }

    public /* synthetic */ Object freeze() {
        return zzuZ();
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzyZ), Integer.valueOf(this.zzza), this.zzaAW, this.zzaAX);
    }

    public boolean isDataValid() {
        return true;
    }

    public zzg zzuZ() {
        return this;
    }
}
