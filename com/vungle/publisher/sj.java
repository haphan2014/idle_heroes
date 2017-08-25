package com.vungle.publisher;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationClient;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class sj extends se<LocationClient> implements ConnectionCallbacks, OnConnectionFailedListener, sl {
    Context f3188b;

    protected final /* synthetic */ boolean mo4540a(Object obj) {
        return ((LocationClient) obj).isConnected();
    }

    public final /* bridge */ /* synthetic */ Location mo4538b() {
        return super.mo4538b();
    }

    protected final /* synthetic */ void mo4541b(Object obj) {
        ((LocationClient) obj).connect();
    }

    protected final /* synthetic */ Location mo4542c(Object obj) {
        return ((LocationClient) obj).getLastLocation();
    }

    protected final /* synthetic */ void mo4544d(Object obj) {
        ((LocationClient) obj).disconnect();
    }

    public sj(Context context) {
        this.f3188b = context;
    }

    protected final String mo4539a() {
        return "Google Play Services LocationClient";
    }

    public final void onConnected(Bundle bundle) {
        super.m2451d();
    }

    public final void onDisconnected() {
        so.m2470a(2, "VungleLocation", "disconnected from Google Play Services LocationClient " + this.f3173a, null);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
    }

    protected final /* synthetic */ Object mo4543c() {
        return new LocationClient(this.f3188b, this, this);
    }
}
