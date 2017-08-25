package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;

public final class Application implements SafeParcelable {
    public static final Creator<Application> CREATOR = new zza();
    public static final Application zzajM = new Application("com.google.android.gms", String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
    private final int zzCY;
    private final String zzMZ;
    private final String zzTQ;
    private final String zzajN;

    Application(int versionCode, String packageName, String version, String domainName) {
        this.zzCY = versionCode;
        this.zzMZ = (String) zzu.zzu(packageName);
        this.zzTQ = "";
        this.zzajN = domainName;
    }

    public Application(String packageName, String version, String domainName) {
        this(1, packageName, "", domainName);
    }

    private boolean zza(Application application) {
        return this.zzMZ.equals(application.zzMZ) && zzt.equal(this.zzTQ, application.zzTQ) && zzt.equal(this.zzajN, application.zzajN);
    }

    public static Application zzcG(String str) {
        return zze(str, null, null);
    }

    public static Application zze(String str, String str2, String str3) {
        return "com.google.android.gms".equals(str) ? zzajM : new Application(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Application) && zza((Application) that));
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    public String getVersion() {
        return this.zzTQ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzMZ, this.zzTQ, this.zzajN);
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.zzMZ, this.zzTQ, this.zzajN});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }

    public String zzqp() {
        return this.zzajN;
    }
}
