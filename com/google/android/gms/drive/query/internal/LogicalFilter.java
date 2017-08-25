package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public class LogicalFilter extends AbstractFilter {
    public static final Creator<LogicalFilter> CREATOR = new zzk();
    final int zzCY;
    private List<Filter> zzahL;
    final Operator zzahQ;
    final List<FilterHolder> zzaif;

    LogicalFilter(int versionCode, Operator operator, List<FilterHolder> filterHolders) {
        this.zzCY = versionCode;
        this.zzahQ = operator;
        this.zzaif = filterHolders;
    }

    public LogicalFilter(Operator operator, Filter filter, Filter... additionalFilters) {
        this.zzCY = 1;
        this.zzahQ = operator;
        this.zzaif = new ArrayList(additionalFilters.length + 1);
        this.zzaif.add(new FilterHolder(filter));
        this.zzahL = new ArrayList(additionalFilters.length + 1);
        this.zzahL.add(filter);
        for (Filter filter2 : additionalFilters) {
            this.zzaif.add(new FilterHolder(filter2));
            this.zzahL.add(filter2);
        }
    }

    public LogicalFilter(Operator operator, Iterable<Filter> filters) {
        this.zzCY = 1;
        this.zzahQ = operator;
        this.zzahL = new ArrayList();
        this.zzaif = new ArrayList();
        for (Filter filter : filters) {
            this.zzahL.add(filter);
            this.zzaif.add(new FilterHolder(filter));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzk.zza(this, out, flags);
    }

    public <T> T zza(zzf<T> com_google_android_gms_drive_query_internal_zzf_T) {
        List arrayList = new ArrayList();
        for (FilterHolder filter : this.zzaif) {
            arrayList.add(filter.getFilter().zza(com_google_android_gms_drive_query_internal_zzf_T));
        }
        return com_google_android_gms_drive_query_internal_zzf_T.zzb(this.zzahQ, arrayList);
    }
}
