package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.internal.zzaq;
import com.google.android.gms.internal.zzrn;

public class ChangeSequenceNumber implements SafeParcelable {
    public static final Creator<ChangeSequenceNumber> CREATOR = new zza();
    final int zzCY;
    final long zzacN;
    final long zzacO;
    final long zzacP;
    private volatile String zzacQ = null;

    ChangeSequenceNumber(int versionCode, long sequenceNumber, long databaseInstanceId, long accountId) {
        boolean z = true;
        zzu.zzV(sequenceNumber != -1);
        zzu.zzV(databaseInstanceId != -1);
        if (accountId == -1) {
            z = false;
        }
        zzu.zzV(z);
        this.zzCY = versionCode;
        this.zzacN = sequenceNumber;
        this.zzacO = databaseInstanceId;
        this.zzacP = accountId;
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzacQ == null) {
            this.zzacQ = "ChangeSequenceNumber:" + Base64.encodeToString(zzpb(), 10);
        }
        return this.zzacQ;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChangeSequenceNumber)) {
            return false;
        }
        ChangeSequenceNumber changeSequenceNumber = (ChangeSequenceNumber) obj;
        return changeSequenceNumber.zzacO == this.zzacO && changeSequenceNumber.zzacP == this.zzacP && changeSequenceNumber.zzacN == this.zzacN;
    }

    public int hashCode() {
        return (String.valueOf(this.zzacN) + String.valueOf(this.zzacO) + String.valueOf(this.zzacP)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    final byte[] zzpb() {
        zzrn com_google_android_gms_drive_internal_zzaq = new zzaq();
        com_google_android_gms_drive_internal_zzaq.versionCode = this.zzCY;
        com_google_android_gms_drive_internal_zzaq.zzafU = this.zzacN;
        com_google_android_gms_drive_internal_zzaq.zzafV = this.zzacO;
        com_google_android_gms_drive_internal_zzaq.zzafW = this.zzacP;
        return zzrn.zzf(com_google_android_gms_drive_internal_zzaq);
    }
}
