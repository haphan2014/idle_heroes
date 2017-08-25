package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzrn;
import com.heyzap.http.AsyncHttpResponseHandler;
import java.util.List;
import java.util.zip.CRC32;

public class UsageInfo implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    final int zzCY;
    final DocumentId zzNH;
    final long zzNI;
    int zzNJ;
    final DocumentContents zzNK;
    final boolean zzNL;
    int zzNM;
    int zzNN;
    public final String zztt;

    public static final class zza {
        private String zzHZ;
        private DocumentId zzNH;
        private long zzNI = -1;
        private int zzNJ = -1;
        private DocumentContents zzNK;
        private boolean zzNL = false;
        private int zzNM = -1;
        private int zzNN = 0;

        public zza zzL(boolean z) {
            this.zzNL = z;
            return this;
        }

        public zza zza(DocumentContents documentContents) {
            this.zzNK = documentContents;
            return this;
        }

        public zza zza(DocumentId documentId) {
            this.zzNH = documentId;
            return this;
        }

        public zza zzal(int i) {
            this.zzNJ = i;
            return this;
        }

        public zza zzam(int i) {
            this.zzNN = i;
            return this;
        }

        public UsageInfo zzkN() {
            return new UsageInfo(this.zzNH, this.zzNI, this.zzNJ, this.zzHZ, this.zzNK, this.zzNL, this.zzNM, this.zzNN);
        }

        public zza zzw(long j) {
            this.zzNI = j;
            return this;
        }
    }

    UsageInfo(int versionCode, DocumentId documentId, long timestamp, int usageType, String query, DocumentContents document, boolean isDeviceOnly, int taskPosition, int eventStatus) {
        this.zzCY = versionCode;
        this.zzNH = documentId;
        this.zzNI = timestamp;
        this.zzNJ = usageType;
        this.zztt = query;
        this.zzNK = document;
        this.zzNL = isDeviceOnly;
        this.zzNM = taskPosition;
        this.zzNN = eventStatus;
    }

    private UsageInfo(DocumentId documentId, long timestampMs, int usageType, String query, DocumentContents document, boolean isDeviceOnly, int taskPosition, int eventStatus) {
        this(1, documentId, timestampMs, usageType, query, document, isDeviceOnly, taskPosition, eventStatus);
    }

    public UsageInfo(String packageName, Intent viewIntent, String title, Uri webUrl, String schemaOrgType, List<AppIndexingLink> outLinks, int eventStatus) {
        this(1, zza(packageName, viewIntent), System.currentTimeMillis(), 0, null, zza(viewIntent, title, webUrl, schemaOrgType, outLinks).zzkJ(), false, -1, eventStatus);
    }

    public static com.google.android.gms.appdatasearch.DocumentContents.zza zza(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        com.google.android.gms.appdatasearch.DocumentContents.zza com_google_android_gms_appdatasearch_DocumentContents_zza = new com.google.android.gms.appdatasearch.DocumentContents.zza();
        com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzbt(str));
        if (uri != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzh(uri));
        }
        if (list != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzh((List) list));
        }
        String action = intent.getAction();
        if (action != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzp("intent_action", action));
        }
        action = intent.getDataString();
        if (action != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzp("intent_data", action));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzp("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            action = extras.getString("intent_extra_data_key");
            if (action != null) {
                com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzp("intent_extra_data", action));
            }
        }
        return com_google_android_gms_appdatasearch_DocumentContents_zza.zzbp(str2).zzI(true);
    }

    public static DocumentId zza(String str, Intent intent) {
        return zzo(str, zzg(intent));
    }

    private static DocumentSection zzbt(String str) {
        return new DocumentSection(str, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("title").zzaj(1).zzK(true).zzbs("name").zzkM(), "text1");
    }

    private static String zzg(Intent intent) {
        String toUri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(toUri.getBytes(AsyncHttpResponseHandler.DEFAULT_CHARSET));
            return Long.toHexString(crc32.getValue());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private static DocumentSection zzh(Uri uri) {
        return new DocumentSection(uri.toString(), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("web_url").zzaj(4).zzJ(true).zzbs("url").zzkM());
    }

    private static DocumentSection zzh(List<AppIndexingLink> list) {
        zzrn com_google_android_gms_internal_zznj_zza = new com.google.android.gms.internal.zznj.zza();
        com.google.android.gms.internal.zznj.zza.zza[] com_google_android_gms_internal_zznj_zza_zzaArr = new com.google.android.gms.internal.zznj.zza.zza[list.size()];
        for (int i = 0; i < com_google_android_gms_internal_zznj_zza_zzaArr.length; i++) {
            com_google_android_gms_internal_zznj_zza_zzaArr[i] = new com.google.android.gms.internal.zznj.zza.zza();
            AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i);
            com_google_android_gms_internal_zznj_zza_zzaArr[i].zzawm = appIndexingLink.appIndexingUrl.toString();
            com_google_android_gms_internal_zznj_zza_zzaArr[i].viewId = appIndexingLink.viewId;
            if (appIndexingLink.webUrl != null) {
                com_google_android_gms_internal_zznj_zza_zzaArr[i].zzawn = appIndexingLink.webUrl.toString();
            }
        }
        com_google_android_gms_internal_zznj_zza.zzawk = com_google_android_gms_internal_zznj_zza_zzaArr;
        return new DocumentSection(zzrn.zzf(com_google_android_gms_internal_zznj_zza), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("outlinks").zzJ(true).zzbs(".private:outLinks").zzbr("blob").zzkM());
    }

    private static DocumentId zzo(String str, String str2) {
        return new DocumentId(str, "", str2);
    }

    private static DocumentSection zzp(String str, String str2) {
        return new DocumentSection(str2, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza(str).zzJ(true).zzkM(), str);
    }

    public int describeContents() {
        zzj com_google_android_gms_appdatasearch_zzj = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[]{this.zzNH, Long.valueOf(this.zzNI), Integer.valueOf(this.zzNJ), Integer.valueOf(this.zzNN)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj com_google_android_gms_appdatasearch_zzj = CREATOR;
        zzj.zza(this, dest, flags);
    }
}
