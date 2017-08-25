package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzl;
import com.google.android.gms.maps.model.internal.zzl.zza;

public final class TileOverlayOptions implements SafeParcelable {
    public static final zzn CREATOR = new zzn();
    private final int zzCY;
    private zzl zzaDG;
    private TileProvider zzaDH;
    private boolean zzaDI;
    private float zzaDa;
    private boolean zzaDb;

    class C11251 implements TileProvider {
        private final zzl zzaDJ = this.zzaDK.zzaDG;
        final /* synthetic */ TileOverlayOptions zzaDK;

        C11251(TileOverlayOptions tileOverlayOptions) {
            this.zzaDK = tileOverlayOptions;
        }

        public Tile getTile(int x, int y, int zoom) {
            try {
                return this.zzaDJ.getTile(x, y, zoom);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    public TileOverlayOptions() {
        this.zzaDb = true;
        this.zzaDI = true;
        this.zzCY = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.zzaDb = true;
        this.zzaDI = true;
        this.zzCY = versionCode;
        this.zzaDG = zza.zzcT(delegate);
        this.zzaDH = this.zzaDG == null ? null : new C11251(this);
        this.zzaDb = visible;
        this.zzaDa = zIndex;
        this.zzaDI = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.zzaDI = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.zzaDI;
    }

    public TileProvider getTileProvider() {
        return this.zzaDH;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public float getZIndex() {
        return this.zzaDa;
    }

    public boolean isVisible() {
        return this.zzaDb;
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.zzaDH = tileProvider;
        this.zzaDG = this.zzaDH == null ? null : new zza(this) {
            final /* synthetic */ TileOverlayOptions zzaDK;

            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.zzaDb = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzn.zza(this, out, flags);
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.zzaDa = zIndex;
        return this;
    }

    IBinder zzvL() {
        return this.zzaDG.asBinder();
    }
}
