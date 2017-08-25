package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<SessionDataSet> {
    static void zza(SessionDataSet sessionDataSet, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, sessionDataSet.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessionDataSet.zzCY);
        zzb.zza(parcel, 2, sessionDataSet.zzqK(), i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeq(x0);
    }

    public SessionDataSet zzcw(Parcel parcel) {
        DataSet dataSet = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            DataSet dataSet2;
            Session session2;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    Session session3 = (Session) zza.zza(parcel, zzaa, Session.CREATOR);
                    dataSet2 = dataSet;
                    session2 = session3;
                    break;
                case 2:
                    dataSet2 = (DataSet) zza.zza(parcel, zzaa, DataSet.CREATOR);
                    session2 = session;
                    i2 = i;
                    break;
                case 1000:
                    DataSet dataSet3 = dataSet;
                    session2 = session;
                    i2 = zza.zzg(parcel, zzaa);
                    dataSet2 = dataSet3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    dataSet2 = dataSet;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            dataSet = dataSet2;
        }
        if (parcel.dataPosition() == zzab) {
            return new SessionDataSet(i, session, dataSet);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SessionDataSet[] zzeq(int i) {
        return new SessionDataSet[i];
    }
}
