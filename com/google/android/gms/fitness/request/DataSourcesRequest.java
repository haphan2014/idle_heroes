package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzmg.zza;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSourcesRequest implements SafeParcelable {
    public static final Creator<DataSourcesRequest> CREATOR = new zzh();
    private final int zzCY;
    private final String zzMZ;
    private final List<DataType> zzajQ;
    private final List<Integer> zzamf;
    private final boolean zzamg;
    private final zzmg zzamh;

    public static class Builder {
        private boolean zzamg = false;
        private DataType[] zzami = new DataType[0];
        private int[] zzamj = new int[]{0, 1};

        public DataSourcesRequest build() {
            boolean z = true;
            zzu.zza(this.zzami.length > 0, (Object) "Must add at least one data type");
            if (this.zzamj.length <= 0) {
                z = false;
            }
            zzu.zza(z, (Object) "Must add at least one data source type");
            return new DataSourcesRequest();
        }

        public Builder setDataSourceTypes(int... dataSourceTypes) {
            this.zzamj = dataSourceTypes;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.zzami = dataTypes;
            return this;
        }
    }

    DataSourcesRequest(int versionCode, List<DataType> dataTypes, List<Integer> dataSourceTypes, boolean includeDbOnlySources, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.zzajQ = dataTypes;
        this.zzamf = dataSourceTypes;
        this.zzamg = includeDbOnlySources;
        this.zzamh = callback == null ? null : zza.zzbr(callback);
        this.zzMZ = packageName;
    }

    private DataSourcesRequest(Builder builder) {
        this(zzkx.zzb(builder.zzami), Arrays.asList(zzkx.zza(builder.zzamj)), builder.zzamg, null, null);
    }

    public DataSourcesRequest(DataSourcesRequest request, zzmg callback, String packageName) {
        this(request.zzajQ, request.zzamf, request.zzamg, callback, packageName);
    }

    public DataSourcesRequest(List<DataType> dataTypes, List<Integer> dataSourceTypes, boolean includeDbOnlySources, zzmg callback, String packageName) {
        this.zzCY = 3;
        this.zzajQ = dataTypes;
        this.zzamf = dataSourceTypes;
        this.zzamg = includeDbOnlySources;
        this.zzamh = callback;
        this.zzMZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzajQ);
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        zzt.zza zzg = zzt.zzt(this).zzg("dataTypes", this.zzajQ).zzg("sourceTypes", this.zzamf);
        if (this.zzamg) {
            zzg.zzg("includeDbOnlySources", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
        return zzg.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzh.zza(this, parcel, flags);
    }

    public IBinder zzqU() {
        return this.zzamh == null ? null : this.zzamh.asBinder();
    }

    public List<Integer> zzrd() {
        return this.zzamf;
    }

    public boolean zzre() {
        return this.zzamg;
    }
}
