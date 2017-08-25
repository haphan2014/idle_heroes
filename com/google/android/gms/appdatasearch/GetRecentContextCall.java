package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GetRecentContextCall {

    public static class Request implements SafeParcelable {
        public static final zzf CREATOR = new zzf();
        final int zzCY;
        public final Account zzNj;
        public final boolean zzNk;
        public final boolean zzNl;
        public final boolean zzNm;

        public Request() {
            this(null, false, false, false);
        }

        Request(int versionCode, Account filterAccount, boolean includeDeviceOnlyData, boolean includeThirdPartyContext, boolean includeUsageEnded) {
            this.zzCY = versionCode;
            this.zzNj = filterAccount;
            this.zzNk = includeDeviceOnlyData;
            this.zzNl = includeThirdPartyContext;
            this.zzNm = includeUsageEnded;
        }

        public Request(Account filterAccount, boolean includeDeviceOnlyData, boolean includeThirdPartyContext, boolean includeUsageEnded) {
            this(1, filterAccount, includeDeviceOnlyData, includeThirdPartyContext, includeUsageEnded);
        }

        public int describeContents() {
            zzf com_google_android_gms_appdatasearch_zzf = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzf com_google_android_gms_appdatasearch_zzf = CREATOR;
            zzf.zza(this, out, flags);
        }
    }

    public static class Response implements Result, SafeParcelable {
        public static final zzg CREATOR = new zzg();
        final int zzCY;
        public Status zzNn;
        public List<UsageInfo> zzNo;
        public String[] zzNp;

        public Response() {
            this.zzCY = 1;
        }

        Response(int versionCode, Status status, List<UsageInfo> usageInfo, String[] topRunningPackages) {
            this.zzCY = versionCode;
            this.zzNn = status;
            this.zzNo = usageInfo;
            this.zzNp = topRunningPackages;
        }

        public int describeContents() {
            zzg com_google_android_gms_appdatasearch_zzg = CREATOR;
            return 0;
        }

        public Status getStatus() {
            return this.zzNn;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzg com_google_android_gms_appdatasearch_zzg = CREATOR;
            zzg.zza(this, out, flags);
        }
    }
}
