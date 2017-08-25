package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class zzc extends com.google.android.gms.common.data.zzc implements Moment {
    private MomentEntity zzaIN;

    public zzc(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private MomentEntity zzxI() {
        synchronized (this) {
            if (this.zzaIN == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.zzaIN = MomentEntity.CREATOR.zzfL(obtain);
                obtain.recycle();
            }
        }
        return this.zzaIN;
    }

    public /* synthetic */ Object freeze() {
        return zzxH();
    }

    public String getId() {
        return zzxI().getId();
    }

    public ItemScope getResult() {
        return zzxI().getResult();
    }

    public String getStartDate() {
        return zzxI().getStartDate();
    }

    public ItemScope getTarget() {
        return zzxI().getTarget();
    }

    public String getType() {
        return zzxI().getType();
    }

    public boolean hasId() {
        return zzxI().hasId();
    }

    public boolean hasResult() {
        return zzxI().hasResult();
    }

    public boolean hasStartDate() {
        return zzxI().hasStartDate();
    }

    public boolean hasTarget() {
        return zzxI().hasTarget();
    }

    public boolean hasType() {
        return zzxI().hasType();
    }

    public MomentEntity zzxH() {
        return zzxI();
    }
}
