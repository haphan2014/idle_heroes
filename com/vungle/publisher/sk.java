package com.vungle.publisher;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class sk extends se<GoogleApiClient> implements ConnectionCallbacks, OnConnectionFailedListener, sm {
    Context f3189b;

    protected final /* synthetic */ boolean mo4540a(Object obj) {
        return ((GoogleApiClient) obj).isConnected();
    }

    public final /* bridge */ /* synthetic */ Location mo4538b() {
        return super.mo4538b();
    }

    protected final /* synthetic */ void mo4541b(Object obj) {
        ((GoogleApiClient) obj).connect();
    }

    protected final /* synthetic */ Location mo4542c(Object obj) {
        return LocationServices.FusedLocationApi.getLastLocation((GoogleApiClient) obj);
    }

    protected final /* synthetic */ void mo4544d(Object obj) {
        ((GoogleApiClient) obj).disconnect();
    }

    public sk(Context context) {
        this.f3189b = context;
    }

    protected final String mo4539a() {
        return "Google Play Services LocationServices";
    }

    public final void onConnected(Bundle bundle) {
        super.m2451d();
    }

    public final void onConnectionSuspended(int i) {
        so.m2470a(2, "VungleLocation", "connection suspended for Google Play Services LocationServices " + this.f3173a, null);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
    }

    protected final /* synthetic */ Object mo4543c() {
        Context context = this.f3189b;
        return new Builder(context).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
    }
}
