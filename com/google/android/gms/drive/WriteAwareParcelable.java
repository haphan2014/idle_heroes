package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzu;

public abstract class WriteAwareParcelable implements Parcelable {
    private volatile transient boolean zzadM = false;

    public void writeToParcel(Parcel dest, int flags) {
        zzu.zzU(!zzpt());
        this.zzadM = true;
        zzI(dest, flags);
    }

    protected abstract void zzI(Parcel parcel, int i);

    public final boolean zzpt() {
        return this.zzadM;
    }
}
