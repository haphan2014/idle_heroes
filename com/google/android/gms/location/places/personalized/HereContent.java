package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.List;

public class HereContent implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int zzCY;
    private final String zzaBe;
    private final List<Action> zzaBf;

    public static final class Action implements SafeParcelable {
        public static final zza CREATOR = new zza();
        final int zzCY;
        private final String zzNb;
        private final String zzadv;

        Action(int versionCode, String title, String uri) {
            this.zzCY = versionCode;
            this.zzadv = title;
            this.zzNb = uri;
        }

        public int describeContents() {
            zza com_google_android_gms_location_places_personalized_zza = CREATOR;
            return 0;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Action)) {
                return false;
            }
            Action action = (Action) object;
            return zzt.equal(this.zzadv, action.zzadv) && zzt.equal(this.zzNb, action.zzNb);
        }

        public String getTitle() {
            return this.zzadv;
        }

        public String getUri() {
            return this.zzNb;
        }

        public int hashCode() {
            return zzt.hashCode(this.zzadv, this.zzNb);
        }

        public String toString() {
            return zzt.zzt(this).zzg("title", this.zzadv).zzg("uri", this.zzNb).toString();
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zza com_google_android_gms_location_places_personalized_zza = CREATOR;
            zza.zza(this, parcel, flags);
        }
    }

    HereContent(int versionCode, String data, List<Action> actions) {
        this.zzCY = versionCode;
        this.zzaBe = data;
        this.zzaBf = actions;
    }

    public int describeContents() {
        zzb com_google_android_gms_location_places_personalized_zzb = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof HereContent)) {
            return false;
        }
        HereContent hereContent = (HereContent) object;
        return zzt.equal(this.zzaBe, hereContent.zzaBe) && zzt.equal(this.zzaBf, hereContent.zzaBf);
    }

    public List<Action> getActions() {
        return this.zzaBf;
    }

    public String getData() {
        return this.zzaBe;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaBe, this.zzaBf);
    }

    public String toString() {
        return zzt.zzt(this).zzg("data", this.zzaBe).zzg("actions", this.zzaBf).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb com_google_android_gms_location_places_personalized_zzb = CREATOR;
        zzb.zza(this, parcel, flags);
    }
}
