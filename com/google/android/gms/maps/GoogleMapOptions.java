package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0346R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int zzCY;
    private Boolean zzaBI;
    private Boolean zzaBJ;
    private int zzaBK;
    private CameraPosition zzaBL;
    private Boolean zzaBM;
    private Boolean zzaBN;
    private Boolean zzaBO;
    private Boolean zzaBP;
    private Boolean zzaBQ;
    private Boolean zzaBR;
    private Boolean zzaBS;
    private Boolean zzaBT;

    public GoogleMapOptions() {
        this.zzaBK = -1;
        this.zzCY = 1;
    }

    GoogleMapOptions(int versionCode, byte zOrderOnTop, byte useViewLifecycleInFragment, int mapType, CameraPosition camera, byte zoomControlsEnabled, byte compassEnabled, byte scrollGesturesEnabled, byte zoomGesturesEnabled, byte tiltGesturesEnabled, byte rotateGesturesEnabled, byte liteMode, byte mapToolbarEnabled) {
        this.zzaBK = -1;
        this.zzCY = versionCode;
        this.zzaBI = zza.zza(zOrderOnTop);
        this.zzaBJ = zza.zza(useViewLifecycleInFragment);
        this.zzaBK = mapType;
        this.zzaBL = camera;
        this.zzaBM = zza.zza(zoomControlsEnabled);
        this.zzaBN = zza.zza(compassEnabled);
        this.zzaBO = zza.zza(scrollGesturesEnabled);
        this.zzaBP = zza.zza(zoomGesturesEnabled);
        this.zzaBQ = zza.zza(tiltGesturesEnabled);
        this.zzaBR = zza.zza(rotateGesturesEnabled);
        this.zzaBS = zza.zza(liteMode);
        this.zzaBT = zza.zza(mapToolbarEnabled);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, C0346R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(C0346R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(C0346R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(C0346R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(C0346R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(C0346R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(C0346R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(C0346R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(C0346R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(C0346R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(C0346R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(C0346R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(C0346R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(C0346R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(C0346R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(C0346R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(C0346R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(C0346R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(C0346R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(C0346R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(C0346R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(C0346R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(C0346R.styleable.MapAttrs_uiMapToolbar, true));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attrs));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions camera(CameraPosition camera) {
        this.zzaBL = camera;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean enabled) {
        this.zzaBN = Boolean.valueOf(enabled);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.zzaBL;
    }

    public Boolean getCompassEnabled() {
        return this.zzaBN;
    }

    public Boolean getLiteMode() {
        return this.zzaBS;
    }

    public Boolean getMapToolbarEnabled() {
        return this.zzaBT;
    }

    public int getMapType() {
        return this.zzaBK;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.zzaBR;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.zzaBO;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.zzaBQ;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzaBJ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public Boolean getZOrderOnTop() {
        return this.zzaBI;
    }

    public Boolean getZoomControlsEnabled() {
        return this.zzaBM;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzaBP;
    }

    public GoogleMapOptions liteMode(boolean enabled) {
        this.zzaBS = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean enabled) {
        this.zzaBT = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions mapType(int mapType) {
        this.zzaBK = mapType;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean enabled) {
        this.zzaBR = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean enabled) {
        this.zzaBO = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean enabled) {
        this.zzaBQ = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.zzaBJ = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public GoogleMapOptions zOrderOnTop(boolean zOrderOnTop) {
        this.zzaBI = Boolean.valueOf(zOrderOnTop);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean enabled) {
        this.zzaBM = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean enabled) {
        this.zzaBP = Boolean.valueOf(enabled);
        return this;
    }

    byte zzvj() {
        return zza.zze(this.zzaBI);
    }

    byte zzvk() {
        return zza.zze(this.zzaBJ);
    }

    byte zzvl() {
        return zza.zze(this.zzaBM);
    }

    byte zzvm() {
        return zza.zze(this.zzaBN);
    }

    byte zzvn() {
        return zza.zze(this.zzaBO);
    }

    byte zzvo() {
        return zza.zze(this.zzaBP);
    }

    byte zzvp() {
        return zza.zze(this.zzaBQ);
    }

    byte zzvq() {
        return zza.zze(this.zzaBR);
    }

    byte zzvr() {
        return zza.zze(this.zzaBS);
    }

    byte zzvs() {
        return zza.zze(this.zzaBT);
    }
}
