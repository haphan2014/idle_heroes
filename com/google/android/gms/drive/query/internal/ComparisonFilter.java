package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T> extends AbstractFilter {
    public static final zza CREATOR = new zza();
    final int zzCY;
    final Operator zzahQ;
    final MetadataBundle zzahR;
    final MetadataField<T> zzahS;

    ComparisonFilter(int versionCode, Operator operator, MetadataBundle value) {
        this.zzCY = versionCode;
        this.zzahQ = operator;
        this.zzahR = value;
        this.zzahS = zze.zzb(value);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> field, T value) {
        this(1, operator, MetadataBundle.zza(field, value));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.zzahR.zza(this.zzahS);
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public <F> F zza(zzf<F> com_google_android_gms_drive_query_internal_zzf_F) {
        return com_google_android_gms_drive_query_internal_zzf_F.zzb(this.zzahQ, this.zzahS, getValue());
    }
}
