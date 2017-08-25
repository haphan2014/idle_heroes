package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzx;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportMapFragment extends Fragment {
    private GoogleMap zzaBV;
    private final zzb zzaCH = new zzb(this);

    static class zza implements MapLifecycleDelegate {
        private final Fragment zzZX;
        private final IMapFragmentDelegate zzaBW;

        public zza(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.zzaBW = (IMapFragmentDelegate) zzu.zzu(iMapFragmentDelegate);
            this.zzZX = (Fragment) zzu.zzu(fragment);
        }

        public void getMapAsync(final OnMapReadyCallback callback) {
            try {
                this.zzaBW.getMapAsync(new com.google.android.gms.maps.internal.zzm.zza(this) {
                    final /* synthetic */ zza zzaCI;

                    public void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                        callback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.zzZX.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                zzx.zza(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.zzaBW.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzn(this.zzaBW.onCreateView(zze.zzw(inflater), zze.zzw(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.zzaBW.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.zzaBW.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzaBW.onInflate(zze.zzw(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.zzaBW.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaBW.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaBW.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaBW.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IMapFragmentDelegate zzvt() {
            return this.zzaBW;
        }
    }

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private Activity mActivity;
        private final Fragment zzZX;
        protected zzf<zza> zzaBZ;
        private final List<OnMapReadyCallback> zzaCa = new ArrayList();

        zzb(Fragment fragment) {
            this.zzZX = fragment;
        }

        private void setActivity(Activity activity) {
            this.mActivity = activity;
            zzvu();
        }

        public void getMapAsync(OnMapReadyCallback callback) {
            if (zzqj() != null) {
                ((zza) zzqj()).getMapAsync(callback);
            } else {
                this.zzaCa.add(callback);
            }
        }

        protected void zza(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_SupportMapFragment_zza) {
            this.zzaBZ = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_SupportMapFragment_zza;
            zzvu();
        }

        public void zzvu() {
            if (this.mActivity != null && this.zzaBZ != null && zzqj() == null) {
                try {
                    MapsInitializer.initialize(this.mActivity);
                    IMapFragmentDelegate zzr = zzy.zzay(this.mActivity).zzr(zze.zzw(this.mActivity));
                    if (zzr != null) {
                        this.zzaBZ.zza(new zza(this.zzZX, zzr));
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

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions options) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    @Deprecated
    public final GoogleMap getMap() {
        IMapFragmentDelegate zzvt = zzvt();
        if (zzvt == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = zzvt.getMap();
            if (map == null) {
                return null;
            }
            if (this.zzaBV == null || this.zzaBV.zzvi().asBinder() != map.asBinder()) {
                this.zzaBV = new GoogleMap(map);
            }
            return this.zzaBV;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback callback) {
        zzu.zzbY("getMapAsync must be called on the main thread.");
        this.zzaCH.getMapAsync(callback);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.zzaCH.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zzaCH.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View onCreateView = this.zzaCH.onCreateView(inflater, container, savedInstanceState);
        onCreateView.setClickable(true);
        return onCreateView;
    }

    public void onDestroy() {
        this.zzaCH.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzaCH.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.zzaCH.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.zzaCH.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.zzaCH.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzaCH.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaCH.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.zzaCH.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    protected IMapFragmentDelegate zzvt() {
        this.zzaCH.zzvu();
        return this.zzaCH.zzqj() == null ? null : ((zza) this.zzaCH.zzqj()).zzvt();
    }
}
