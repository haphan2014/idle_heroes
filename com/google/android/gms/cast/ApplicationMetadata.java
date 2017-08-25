package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
    public static final Creator<ApplicationMetadata> CREATOR = new zza();
    String mName;
    private final int zzCY;
    String zzQv;
    List<String> zzQw;
    String zzQx;
    Uri zzQy;
    List<WebImage> zzvi;

    private ApplicationMetadata() {
        this.zzCY = 1;
        this.zzvi = new ArrayList();
        this.zzQw = new ArrayList();
    }

    ApplicationMetadata(int versionCode, String applicationId, String name, List<WebImage> images, List<String> namespaces, String senderAppIdentifier, Uri senderAppLaunchUrl) {
        this.zzCY = versionCode;
        this.zzQv = applicationId;
        this.mName = name;
        this.zzvi = images;
        this.zzQw = namespaces;
        this.zzQx = senderAppIdentifier;
        this.zzQy = senderAppLaunchUrl;
    }

    public boolean areNamespacesSupported(List<String> namespaces) {
        return this.zzQw != null && this.zzQw.containsAll(namespaces);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return zzf.zza(this.zzQv, applicationMetadata.zzQv) && zzf.zza(this.zzvi, applicationMetadata.zzvi) && zzf.zza(this.mName, applicationMetadata.mName) && zzf.zza(this.zzQw, applicationMetadata.zzQw) && zzf.zza(this.zzQx, applicationMetadata.zzQx) && zzf.zza(this.zzQy, applicationMetadata.zzQy);
    }

    public String getApplicationId() {
        return this.zzQv;
    }

    public List<WebImage> getImages() {
        return this.zzvi;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.zzQx;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzCY), this.zzQv, this.mName, this.zzvi, this.zzQw, this.zzQx, this.zzQy);
    }

    public boolean isNamespaceSupported(String namespace) {
        return this.zzQw != null && this.zzQw.contains(namespace);
    }

    public String toString() {
        int i = 0;
        StringBuilder append = new StringBuilder().append("applicationId: ").append(this.zzQv).append(", name: ").append(this.mName).append(", images.count: ").append(this.zzvi == null ? 0 : this.zzvi.size()).append(", namespaces.count: ");
        if (this.zzQw != null) {
            i = this.zzQw.size();
        }
        return append.append(i).append(", senderAppIdentifier: ").append(this.zzQx).append(", senderAppLaunchUrl: ").append(this.zzQy).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public Uri zzle() {
        return this.zzQy;
    }
}
