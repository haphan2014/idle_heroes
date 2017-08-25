package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class MostRecentGameInfoRef extends zzc implements MostRecentGameInfo {
    private final PlayerColumnNames zzanX;

    public MostRecentGameInfoRef(DataHolder holder, int dataRow, PlayerColumnNames columnNames) {
        super(holder, dataRow);
        this.zzanX = columnNames;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztA();
    }

    public int hashCode() {
        return MostRecentGameInfoEntity.zza(this);
    }

    public String toString() {
        return MostRecentGameInfoEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((MostRecentGameInfoEntity) zztA()).writeToParcel(dest, flags);
    }

    public MostRecentGameInfo zztA() {
        return new MostRecentGameInfoEntity(this);
    }

    public String zztu() {
        return getString(this.zzanX.zzato);
    }

    public String zztv() {
        return getString(this.zzanX.zzatp);
    }

    public long zztw() {
        return getLong(this.zzanX.zzatq);
    }

    public Uri zztx() {
        return zzbW(this.zzanX.zzatr);
    }

    public Uri zzty() {
        return zzbW(this.zzanX.zzats);
    }

    public Uri zztz() {
        return zzbW(this.zzanX.zzatt);
    }
}
