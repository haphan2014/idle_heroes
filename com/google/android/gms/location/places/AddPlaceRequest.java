package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class AddPlaceRequest implements SafeParcelable {
    public static final Creator<AddPlaceRequest> CREATOR = new zzb();
    private final String mName;
    final int zzCY;
    private final String zzajO;
    private final LatLng zzazn;
    private final List<Integer> zzazo;
    private final String zzazp;
    private final Uri zzazq;

    AddPlaceRequest(int versionCode, String name, LatLng latLng, String address, List<Integer> placeTypes, String phoneNumber, Uri websiteUri) {
        this.zzCY = versionCode;
        this.mName = zzu.zzcj(name);
        this.zzazn = (LatLng) zzu.zzu(latLng);
        this.zzajO = address;
        this.zzazo = new ArrayList(placeTypes);
        boolean z = (TextUtils.isEmpty(phoneNumber) && websiteUri == null) ? false : true;
        zzu.zzb(z, (Object) "One of phone number or URI should be provided.");
        this.zzazp = phoneNumber;
        this.zzazq = websiteUri;
    }

    public AddPlaceRequest(String name, LatLng latLng, String address, List<Integer> placeTypes, Uri uri) {
        this(name, latLng, address, placeTypes, null, (Uri) zzu.zzu(uri));
    }

    public AddPlaceRequest(String name, LatLng latLng, String address, List<Integer> placeTypes, String phoneNumber) {
        this(name, latLng, address, placeTypes, zzu.zzcj(phoneNumber), null);
    }

    public AddPlaceRequest(String name, LatLng latLng, String address, List<Integer> placeTypes, String phoneNumber, Uri uri) {
        this(0, name, latLng, address, placeTypes, phoneNumber, uri);
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.zzajO;
    }

    public LatLng getLatLng() {
        return this.zzazn;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.zzazp;
    }

    public List<Integer> getPlaceTypes() {
        return this.zzazo;
    }

    public Uri getWebsiteUri() {
        return this.zzazq;
    }

    public String toString() {
        return zzt.zzt(this).zzg("name", this.mName).zzg("latLng", this.zzazn).zzg("address", this.zzajO).zzg("placeTypes", this.zzazo).zzg("phoneNumer", this.zzazp).zzg("websiteUri", this.zzazq).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
