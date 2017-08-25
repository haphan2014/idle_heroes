package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {
    private GoogleMap zzaBV;
    private final zzb zzaCb;

    static class zza implements MapLifecycleDelegate {
        private final ViewGroup zzaCc;
        private final IMapViewDelegate zzaCd;
        private View zzaCe;

        public zza(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.zzaCd = (IMapViewDelegate) zzu.zzu(iMapViewDelegate);
            this.zzaCc = (ViewGroup) zzu.zzu(viewGroup);
        }

        public void getMapAsync(final OnMapReadyCallback callback) {
            try {
                this.zzaCd.getMapAsync(new com.google.android.gms.maps.internal.zzm.zza(this) {
                    final /* synthetic */ zza zzaCf;

                    public void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                        callback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzaCd.onCreate(savedInstanceState);
                this.zzaCe = (View) zze.zzn(this.zzaCd.getView());
                this.zzaCc.removeAllViews();
                this.zzaCc.addView(this.zzaCe);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.zzaCd.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.zzaCd.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaCd.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaCd.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaCd.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IMapViewDelegate zzvv() {
            return this.zzaCd;
        }
    }

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private final Context mContext;
        protected zzf<zza> zzaBZ;
        private final List<OnMapReadyCallback> zzaCa = new ArrayList();
        private final ViewGroup zzaCg;
        private final GoogleMapOptions zzaCh;

        zzb(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.zzaCg = viewGroup;
            this.mContext = context;
            this.zzaCh = googleMapOptions;
        }

        public void getMapAsync(OnMapReadyCallback callback) {
            if (zzqj() != null) {
                ((zza) zzqj()).getMapAsync(callback);
            } else {
                this.zzaCa.add(callback);
            }
        }

        protected void zza(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapView_zza) {
            this.zzaBZ = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapView_zza;
            zzvu();
        }

        public void zzvu() {
            if (this.zzaBZ != null && zzqj() == null) {
                try {
                    MapsInitializer.initialize(this.mContext);
                    IMapViewDelegate zza = zzy.zzay(this.mContext).zza(zze.zzw(this.mContext), this.zzaCh);
                    if (zza != null) {
                        this.zzaBZ.zza(new zza(this.zzaCg, zza));
                        for (OnMapReadyCallback mapAsync : this.zzaCa) {
                            ((zza) zzqj()).getMapAsync(mapAsync);
                        }
                        this.zzaCa.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.zzaCb = new zzb(this, context, null);
        init();
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.zzaCb = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
        init();
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.zzaCb = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
        init();
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context);
        this.zzaCb = new zzb(this, context, options);
        init();
    }

    private void init() {
        setClickable(true);
    }

    @Deprecated
    public final GoogleMap getMap() {
        if (this.zzaBV != null) {
            return this.zzaBV;
        }
        this.zzaCb.zzvu();
        if (this.zzaCb.zzqj() == null) {
            return null;
        }
        try {
            this.zzaBV = new GoogleMap(((zza) this.zzaCb.zzqj()).zzvv().getMap());
            return this.zzaBV;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback callback) {
        zzu.zzbY("getMapAsync() must be called on the main thread");
        this.zzaCb.getMapAsync(callback);
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.zzaCb.onCreate(savedInstanceState);
        if (this.zzaCb.zzqj() == null) {
            com.google.android.gms.dynamic.zza.zzb((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.zzaCb.onDestroy();
    }

    public final void onLowMemory() {
        this.zzaCb.onLowMemory();
    }

    public final void onPause() {
        this.zzaCb.onPause();
    }

    public final void onResume() {
        this.zzaCb.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.zzaCb.onSaveInstanceState(outState);
    }
}
