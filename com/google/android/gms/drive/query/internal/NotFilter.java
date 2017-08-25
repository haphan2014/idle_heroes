package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;

public class NotFilter extends AbstractFilter {
    public static final Creator<NotFilter> CREATOR = new zzm();
    final int zzCY;
    final FilterHolder zzaig;

    NotFilter(int versionCode, FilterHolder toNegate) {
        this.zzCY = versionCode;
        this.zzaig = toNegate;
    }

    public NotFilter(Filter toNegate) {
        this(1, new FilterHolder(toNegate));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzm.zza(this, out, flags);
    }

    public <T> T zza(zzf<T> com_google_android_gms_drive_query_internal_zzf_T) {
        return com_google_android_gms_drive_query_internal_zzf_T.zzv(this.zzaig.getFilter().zza(com_google_android_gms_drive_query_internal_zzf_T));
    }
}
