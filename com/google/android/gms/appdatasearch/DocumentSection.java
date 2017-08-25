package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class DocumentSection implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    public static final int zzNc = Integer.parseInt("-1");
    private static final RegisterSectionInfo zzNd = new zza("SsbContext").zzJ(true).zzbr("blob").zzkM();
    final int zzCY;
    public final String zzNe;
    final RegisterSectionInfo zzNf;
    public final int zzNg;
    public final byte[] zzNh;

    DocumentSection(int versionCode, String content, RegisterSectionInfo sectionInfo, int globalSearchSectionType, byte[] blobContent) {
        boolean z = globalSearchSectionType == zzNc || zzh.zzai(globalSearchSectionType) != null;
        zzu.zzb(z, "Invalid section type " + globalSearchSectionType);
        this.zzCY = versionCode;
        this.zzNe = content;
        this.zzNf = sectionInfo;
        this.zzNg = globalSearchSectionType;
        this.zzNh = blobContent;
        String zzkK = zzkK();
        if (zzkK != null) {
            throw new IllegalArgumentException(zzkK);
        }
    }

    public DocumentSection(String content, RegisterSectionInfo sectionInfo) {
        this(1, content, sectionInfo, zzNc, null);
    }

    public DocumentSection(String content, RegisterSectionInfo sectionInfo, String globalSearchSectionType) {
        this(1, content, sectionInfo, zzh.zzbq(globalSearchSectionType), null);
    }

    public DocumentSection(byte[] blobContent, RegisterSectionInfo sectionInfo) {
        this(1, null, sectionInfo, zzNc, blobContent);
    }

    public static DocumentSection zzh(byte[] bArr) {
        return new DocumentSection(bArr, zzNd);
    }

    public int describeContents() {
        zzd com_google_android_gms_appdatasearch_zzd = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd com_google_android_gms_appdatasearch_zzd = CREATOR;
        zzd.zza(this, dest, flags);
    }

    public String zzkK() {
        return (this.zzNg == zzNc || zzh.zzai(this.zzNg) != null) ? (this.zzNe == null || this.zzNh == null) ? null : "Both content and blobContent set" : "Invalid section type " + this.zzNg;
    }
}
