package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zzd.zza;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public static final float NO_DIMENSION = -1.0f;
    private final int zzCY;
    private float zzaCT;
    private float zzaDa;
    private boolean zzaDb;
    private BitmapDescriptor zzaDd;
    private LatLng zzaDe;
    private float zzaDf;
    private float zzaDg;
    private LatLngBounds zzaDh;
    private float zzaDi;
    private float zzaDj;
    private float zzaDk;

    public GroundOverlayOptions() {
        this.zzaDb = true;
        this.zzaDi = 0.0f;
        this.zzaDj = 0.5f;
        this.zzaDk = 0.5f;
        this.zzCY = 1;
    }

    GroundOverlayOptions(int versionCode, IBinder wrappedImage, LatLng location, float width, float height, LatLngBounds bounds, float bearing, float zIndex, boolean visible, float transparency, float anchorU, float anchorV) {
        this.zzaDb = true;
        this.zzaDi = 0.0f;
        this.zzaDj = 0.5f;
        this.zzaDk = 0.5f;
        this.zzCY = versionCode;
        this.zzaDd = new BitmapDescriptor(zza.zzbg(wrappedImage));
        this.zzaDe = location;
        this.zzaDf = width;
        this.zzaDg = height;
        this.zzaDh = bounds;
        this.zzaCT = bearing;
        this.zzaDa = zIndex;
        this.zzaDb = visible;
        this.zzaDi = transparency;
        this.zzaDj = anchorU;
        this.zzaDk = anchorV;
    }

    private GroundOverlayOptions zza(LatLng latLng, float f, float f2) {
        this.zzaDe = latLng;
        this.zzaDf = f;
        this.zzaDg = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float u, float v) {
        this.zzaDj = u;
        this.zzaDk = v;
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        this.zzaCT = ((bearing % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.zzaDj;
    }

    public float getAnchorV() {
        return this.zzaDk;
    }

    public float getBearing() {
        return this.zzaCT;
    }

    public LatLngBounds getBounds() {
        return this.zzaDh;
    }

    public float getHeight() {
        return this.zzaDg;
    }

    public BitmapDescriptor getImage() {
        return this.zzaDd;
    }

    public LatLng getLocation() {
        return this.zzaDe;
    }

    public float getTransparency() {
        return this.zzaDi;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public float getWidth() {
        return this.zzaDf;
    }

    public float getZIndex() {
        return this.zzaDa;
    }

    public GroundOverlayOptions image(BitmapDescriptor image) {
        this.zzaDd = image;
        return this;
    }

    public boolean isVisible() {
        return this.zzaDb;
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        boolean z = true;
        zzu.zza(this.zzaDh == null, (Object) "Position has already been set using positionFromBounds");
        zzu.zzb(location != null, (Object) "Location must be specified");
        if (width < 0.0f) {
            z = false;
        }
        zzu.zzb(z, (Object) "Width must be non-negative");
        return zza(location, width, NO_DIMENSION);
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        boolean z = true;
        zzu.zza(this.zzaDh == null, (Object) "Position has already been set using positionFromBounds");
        zzu.zzb(location != null, (Object) "Location must be specified");
        zzu.zzb(width >= 0.0f, (Object) "Width must be non-negative");
        if (height < 0.0f) {
            z = false;
        }
        zzu.zzb(z, (Object) "Height must be non-negative");
        return zza(location, width, height);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        zzu.zza(this.zzaDe == null, "Position has already been set using position: " + this.zzaDe);
        this.zzaDh = bounds;
        return this;
    }

    public GroundOverlayOptions transparency(float transparency) {
        boolean z = transparency >= 0.0f && transparency <= TextTrackStyle.DEFAULT_FONT_SCALE;
        zzu.zzb(z, (Object) "Transparency must be in the range [0..1]");
        this.zzaDi = transparency;
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        this.zzaDb = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        this.zzaDa = zIndex;
        return this;
    }

    IBinder zzvI() {
        return this.zzaDd.zzvg().asBinder();
    }
}
