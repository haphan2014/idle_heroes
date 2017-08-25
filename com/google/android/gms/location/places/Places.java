package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.location.places.internal.zzc;
import com.google.android.gms.location.places.internal.zzd;
import com.google.android.gms.location.places.internal.zzd.zza;
import com.google.android.gms.location.places.internal.zzi;
import com.google.android.gms.location.places.internal.zzj;

public class Places {
    public static final Api<PlacesOptions> GEO_DATA_API = new Api("Places.GEO_DATA_API", new zza(null, null), zzazQ, new Scope[0]);
    public static final GeoDataApi GeoDataApi = new zzc();
    public static final Api<PlacesOptions> PLACE_DETECTION_API = new Api("Places.PLACE_DETECTION_API", new zzj.zza(null, null), zzazR, new Scope[0]);
    public static final PlaceDetectionApi PlaceDetectionApi = new zzi();
    public static final ClientKey<zzd> zzazQ = new ClientKey();
    public static final ClientKey<zzj> zzazR = new ClientKey();

    private Places() {
    }
}
