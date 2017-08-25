package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest implements SafeParcelable {
    public static final Creator<GeofencingRequest> CREATOR = new zza();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final int zzCY;
    private final List<ParcelableGeofence> zzaxJ;
    private final int zzaxK;

    public static final class Builder {
        private final List<ParcelableGeofence> zzaxJ = new ArrayList();
        private int zzaxK = 5;

        public static int zzgr(int i) {
            return i & 7;
        }

        public Builder addGeofence(Geofence geofence) {
            zzu.zzb((Object) geofence, (Object) "geofence can't be null.");
            zzu.zzb(geofence instanceof ParcelableGeofence, (Object) "Geofence must be created using Geofence.Builder.");
            this.zzaxJ.add((ParcelableGeofence) geofence);
            return this;
        }

        public Builder addGeofences(List<Geofence> geofences) {
            if (!(geofences == null || geofences.isEmpty())) {
                for (Geofence geofence : geofences) {
                    if (geofence != null) {
                        addGeofence(geofence);
                    }
                }
            }
            return this;
        }

        public GeofencingRequest build() {
            zzu.zzb(!this.zzaxJ.isEmpty(), (Object) "No geofence has been added to this request.");
            return new GeofencingRequest(this.zzaxJ, this.zzaxK);
        }

        public Builder setInitialTrigger(int initialTrigger) {
            this.zzaxK = zzgr(initialTrigger);
            return this;
        }
    }

    GeofencingRequest(int version, List<ParcelableGeofence> geofences, int initialTrigger) {
        this.zzCY = version;
        this.zzaxJ = geofences;
        this.zzaxK = initialTrigger;
    }

    private GeofencingRequest(List<ParcelableGeofence> geofences, int initialTrigger) {
        this(1, (List) geofences, initialTrigger);
    }

    public int describeContents() {
        return 0;
    }

    public List<Geofence> getGeofences() {
        List<Geofence> arrayList = new ArrayList();
        arrayList.addAll(this.zzaxJ);
        return arrayList;
    }

    public int getInitialTrigger() {
        return this.zzaxK;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public List<ParcelableGeofence> zzun() {
        return this.zzaxJ;
    }
}
