package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
    public static final Creator<CommonWalletObject> CREATOR = new zza();
    String name;
    int state;
    private final int zzCY;
    String zzaQN;
    String zzaQP;
    String zzaQQ;
    String zzaQR;
    String zzaQS;
    String zzaQT;
    ArrayList<WalletObjectMessage> zzaQU;
    TimeInterval zzaQV;
    ArrayList<LatLng> zzaQW;
    String zzaQX;
    String zzaQY;
    ArrayList<LabelValueRow> zzaQZ;
    boolean zzaRa;
    ArrayList<UriData> zzaRb;
    ArrayList<TextModuleData> zzaRc;
    ArrayList<UriData> zzaRd;
    String zzhI;

    public final class zza {
        final /* synthetic */ CommonWalletObject zzaSw;

        private zza(CommonWalletObject commonWalletObject) {
            this.zzaSw = commonWalletObject;
        }

        public CommonWalletObject zzAO() {
            return this.zzaSw;
        }

        public zza zzff(String str) {
            this.zzaSw.zzhI = str;
            return this;
        }
    }

    CommonWalletObject() {
        this.zzCY = 1;
        this.zzaQU = zzkx.zzoP();
        this.zzaQW = zzkx.zzoP();
        this.zzaQZ = zzkx.zzoP();
        this.zzaRb = zzkx.zzoP();
        this.zzaRc = zzkx.zzoP();
        this.zzaRd = zzkx.zzoP();
    }

    CommonWalletObject(int versionCode, String id, String classId, String name, String issuerName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, int state, ArrayList<WalletObjectMessage> messages, TimeInterval validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<LabelValueRow> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<UriData> imageModuleDataMainImageUris, ArrayList<TextModuleData> textModulesData, ArrayList<UriData> linksModuleDataUris) {
        this.zzCY = versionCode;
        this.zzhI = id;
        this.zzaQT = classId;
        this.name = name;
        this.zzaQN = issuerName;
        this.zzaQP = barcodeAlternateText;
        this.zzaQQ = barcodeType;
        this.zzaQR = barcodeValue;
        this.zzaQS = barcodeLabel;
        this.state = state;
        this.zzaQU = messages;
        this.zzaQV = validTimeInterval;
        this.zzaQW = locations;
        this.zzaQX = infoModuleDataHexFontColor;
        this.zzaQY = infoModuleDataHexBackgroundColor;
        this.zzaQZ = infoModuleDataLabelValueRows;
        this.zzaRa = infoModuleDataShowLastUpdateTime;
        this.zzaRb = imageModuleDataMainImageUris;
        this.zzaRc = textModulesData;
        this.zzaRd = linksModuleDataUris;
    }

    public static zza zzAN() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new zza();
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzhI;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
