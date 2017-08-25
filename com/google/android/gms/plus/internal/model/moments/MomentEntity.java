package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class MomentEntity extends FastSafeParcelableJsonResponse implements Moment {
    public static final zzb CREATOR = new zzb();
    private static final HashMap<String, Field<?, ?>> zzaHP = new HashMap();
    final int zzCY;
    String zzEl;
    String zzKI;
    final Set<Integer> zzaHQ;
    String zzaID;
    ItemScopeEntity zzaIL;
    ItemScopeEntity zzaIM;

    static {
        zzaHP.put("id", Field.zzl("id", 2));
        zzaHP.put("result", Field.zza("result", 4, ItemScopeEntity.class));
        zzaHP.put("startDate", Field.zzl("startDate", 5));
        zzaHP.put("target", Field.zza("target", 6, ItemScopeEntity.class));
        zzaHP.put("type", Field.zzl("type", 7));
    }

    public MomentEntity() {
        this.zzCY = 1;
        this.zzaHQ = new HashSet();
    }

    MomentEntity(Set<Integer> indicatorSet, int versionCode, String id, ItemScopeEntity result, String startDate, ItemScopeEntity target, String type) {
        this.zzaHQ = indicatorSet;
        this.zzCY = versionCode;
        this.zzKI = id;
        this.zzaIL = result;
        this.zzaID = startDate;
        this.zzaIM = target;
        this.zzEl = type;
    }

    public MomentEntity(Set<Integer> indicatorSet, String id, ItemScopeEntity result, String startDate, ItemScopeEntity target, String type) {
        this.zzaHQ = indicatorSet;
        this.zzCY = 1;
        this.zzKI = id;
        this.zzaIL = result;
        this.zzaID = startDate;
        this.zzaIM = target;
        this.zzEl = type;
    }

    public int describeContents() {
        zzb com_google_android_gms_plus_internal_model_moments_zzb = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MomentEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MomentEntity momentEntity = (MomentEntity) obj;
        for (Field field : zzaHP.values()) {
            if (zza(field)) {
                if (!momentEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(momentEntity.zzb(field))) {
                    return false;
                }
            } else if (momentEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzxH();
    }

    public String getId() {
        return this.zzKI;
    }

    public ItemScope getResult() {
        return this.zzaIL;
    }

    public String getStartDate() {
        return this.zzaID;
    }

    public ItemScope getTarget() {
        return this.zzaIM;
    }

    public String getType() {
        return this.zzEl;
    }

    public boolean hasId() {
        return this.zzaHQ.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.zzaHQ.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.zzaHQ.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.zzaHQ.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.zzaHQ.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        for (Field field : zzaHP.values()) {
            int hashCode;
            if (zza(field)) {
                hashCode = zzb(field).hashCode() + (i + field.zzot());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb com_google_android_gms_plus_internal_model_moments_zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    protected boolean zza(Field field) {
        return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
    }

    protected Object zzb(Field field) {
        switch (field.zzot()) {
            case 2:
                return this.zzKI;
            case 4:
                return this.zzaIL;
            case 5:
                return this.zzaID;
            case 6:
                return this.zzaIM;
            case 7:
                return this.zzEl;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
        }
    }

    public /* synthetic */ Map zzom() {
        return zzxF();
    }

    public HashMap<String, Field<?, ?>> zzxF() {
        return zzaHP;
    }

    public MomentEntity zzxH() {
        return this;
    }
}
