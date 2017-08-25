package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceImpl.zza;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class zzr extends zzt implements Place {
    private boolean zzaAE;
    private final zzo zzaAH;
    private final String zzazK;

    public zzr(DataHolder dataHolder, int i, Context context) {
        super(dataHolder, i);
        this.zzaAH = context != null ? zzo.zzax(context) : null;
        this.zzaAE = zzh("place_is_logging_enabled", false);
        this.zzazK = zzB("place_id", "");
    }

    private void zzdp(String str) {
        if (this.zzaAE && this.zzaAH != null) {
            this.zzaAH.zzA(this.zzazK, str);
        }
    }

    public /* synthetic */ Object freeze() {
        return zzuW();
    }

    public CharSequence getAddress() {
        zzdp("getAddress");
        return zzB("place_address", "");
    }

    public String getId() {
        zzdp("getId");
        return this.zzazK;
    }

    public LatLng getLatLng() {
        zzdp("getLatLng");
        return (LatLng) zza("place_lat_lng", LatLng.CREATOR);
    }

    public Locale getLocale() {
        zzdp("getLocale");
        Object zzB = zzB("place_locale", "");
        return !TextUtils.isEmpty(zzB) ? new Locale(zzB) : Locale.getDefault();
    }

    public CharSequence getName() {
        zzdp("getName");
        return zzB("place_name", "");
    }

    public CharSequence getPhoneNumber() {
        zzdp("getPhoneNumber");
        return zzB("place_phone_number", "");
    }

    public List<Integer> getPlaceTypes() {
        zzdp("getPlaceTypes");
        return zza("place_types", Collections.emptyList());
    }

    public int getPriceLevel() {
        zzdp("getPriceLevel");
        return zzz("place_price_level", -1);
    }

    public float getRating() {
        zzdp("getRating");
        return zzb("place_rating", (float) GroundOverlayOptions.NO_DIMENSION);
    }

    public LatLngBounds getViewport() {
        zzdp("getViewport");
        return (LatLngBounds) zza("place_viewport", LatLngBounds.CREATOR);
    }

    public Uri getWebsiteUri() {
        zzdp("getWebsiteUri");
        String zzB = zzB("place_website_uri", null);
        return zzB == null ? null : Uri.parse(zzB);
    }

    public float zzuO() {
        zzdp("getLevelNumber");
        return zzb("place_level_number", 0.0f);
    }

    public boolean zzuR() {
        zzdp("isPermanentlyClosed");
        return zzh("place_is_permanently_closed", false);
    }

    public Place zzuW() {
        zza zzae = new zza().zzae(this.zzaAE);
        this.zzaAE = false;
        Place zzuX = zzae.zzds(getAddress().toString()).zzn(zzb("place_attributions", Collections.emptyList())).zzdq(getId()).zzad(zzuR()).zza(getLatLng()).zzf(zzuO()).zzdr(getName().toString()).zzdt(getPhoneNumber().toString()).zzgX(getPriceLevel()).zzg(getRating()).zzm(getPlaceTypes()).zza(getViewport()).zzk(getWebsiteUri()).zzuX();
        zzuX.setLocale(getLocale());
        zzuX.zza(this.zzaAH);
        return zzuX;
    }
}
