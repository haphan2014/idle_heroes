package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zza.zza;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzmu;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
    public static final Creator<StartBleScanRequest> CREATOR = new zzaa();
    private final int zzCY;
    private final String zzMZ;
    private final List<DataType> zzajQ;
    private final zzmu zzalN;
    private final zzn zzamK;
    private final int zzamL;

    public static class Builder {
        private zzn zzamK;
        private int zzamL = 10;
        private DataType[] zzami = new DataType[0];

        public StartBleScanRequest build() {
            zzu.zza(this.zzamK != null, (Object) "Must set BleScanCallback");
            return new StartBleScanRequest();
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            zza(zza.zzqS().zza(bleScanCallback));
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.zzami = dataTypes;
            return this;
        }

        public Builder setTimeoutSecs(int stopTimeSecs) {
            boolean z = true;
            zzu.zzb(stopTimeSecs > 0, (Object) "Stop time must be greater than zero");
            if (stopTimeSecs > 60) {
                z = false;
            }
            zzu.zzb(z, (Object) "Stop time must be less than 1 minute");
            this.zzamL = stopTimeSecs;
            return this;
        }

        public Builder zza(zzn com_google_android_gms_fitness_request_zzn) {
            this.zzamK = com_google_android_gms_fitness_request_zzn;
            return this;
        }
    }

    StartBleScanRequest(int versionCode, List<DataType> dataTypes, IBinder bleScanCallback, int timeoutSecs, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.zzajQ = dataTypes;
        this.zzamK = zzn.zza.zzbI(bleScanCallback);
        this.zzamL = timeoutSecs;
        this.zzalN = callback == null ? null : zzmu.zza.zzbF(callback);
        this.zzMZ = packageName;
    }

    private StartBleScanRequest(Builder builder) {
        this(zzkx.zzb(builder.zzami), builder.zzamK, builder.zzamL, null, null);
    }

    public StartBleScanRequest(StartBleScanRequest request, zzmu callback, String packageName) {
        this(request.zzajQ, request.zzamK, request.zzamL, callback, packageName);
    }

    public StartBleScanRequest(List<DataType> dataTypes, zzn bleScanCallback, int timeoutSecs, zzmu callback, String packageName) {
        this.zzCY = 3;
        this.zzajQ = dataTypes;
        this.zzamK = bleScanCallback;
        this.zzamL = timeoutSecs;
        this.zzalN = callback;
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

    public int getTimeoutSecs() {
        return this.zzamL;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return zzt.zzt(this).zzg("dataTypes", this.zzajQ).zzg("timeoutSecs", Integer.valueOf(this.zzamL)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzaa.zza(this, parcel, flags);
    }

    public IBinder zzqU() {
        return this.zzalN == null ? null : this.zzalN.asBinder();
    }

    public IBinder zzrq() {
        return this.zzamK.asBinder();
    }
}
