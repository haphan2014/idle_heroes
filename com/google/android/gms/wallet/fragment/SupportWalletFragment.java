package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C0346R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqy;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment extends Fragment {
    private boolean mCreated = false;
    private final Fragment zzZX = this;
    private zzb zzaRO;
    private final zzh zzaRP = zzh.zza(this);
    private final zzc zzaRQ = new zzc();
    private zza zzaRR = new zza(this);
    private WalletFragmentOptions zzaRS;
    private WalletFragmentInitParams zzaRT;
    private MaskedWalletRequest zzaRU;
    private MaskedWallet zzaRV;
    private Boolean zzaRW;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    static class zza extends com.google.android.gms.internal.zzqr.zza {
        private OnStateChangedListener zzaRX;
        private final SupportWalletFragment zzaRY;

        zza(SupportWalletFragment supportWalletFragment) {
            this.zzaRY = supportWalletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzaRX != null) {
                this.zzaRX.onStateChanged(this.zzaRY, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzaRX = onStateChangedListener;
        }
    }

    private static class zzb implements LifecycleDelegate {
        private final zzqq zzaRZ;

        private zzb(zzqq com_google_android_gms_internal_zzqq) {
            this.zzaRZ = com_google_android_gms_internal_zzqq;
        }

        private int getState() {
            try {
                return this.zzaRZ.getState();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void initialize(WalletFragmentInitParams startParams) {
            try {
                this.zzaRZ.initialize(startParams);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.zzaRZ.onActivityResult(requestCode, resultCode, data);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void setEnabled(boolean enabled) {
            try {
                this.zzaRZ.setEnabled(enabled);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.zzaRZ.updateMaskedWallet(maskedWallet);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.zzaRZ.updateMaskedWalletRequest(request);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzaRZ.onCreate(savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzn(this.zzaRZ.onCreateView(zze.zzw(inflater), zze.zzw(container), savedInstanceState));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzaRZ.zza(zze.zzw(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.zzaRZ.onPause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaRZ.onResume();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaRZ.onSaveInstanceState(outState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.zzaRZ.onStart();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.zzaRZ.onStop();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class zzc extends com.google.android.gms.dynamic.zza<zzb> implements OnClickListener {
        final /* synthetic */ SupportWalletFragment zzaSa;

        private zzc(SupportWalletFragment supportWalletFragment) {
            this.zzaSa = supportWalletFragment;
        }

        public void onClick(View view) {
            Context activity = this.zzaSa.zzZX.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        protected void zza(FrameLayout frameLayout) {
            View button = new Button(this.zzaSa.zzZX.getActivity());
            button.setText(C0346R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.zzaSa.zzaRS != null) {
                WalletFragmentStyle fragmentStyle = this.zzaSa.zzaRS.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.zzaSa.zzZX.getResources().getDisplayMetrics();
                    i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void zza(zzf<zzb> com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_SupportWalletFragment_zzb) {
            Activity activity = this.zzaSa.zzZX.getActivity();
            if (this.zzaSa.zzaRO == null && this.zzaSa.mCreated && activity != null) {
                try {
                    this.zzaSa.zzaRO = new zzb(zzqy.zza(activity, this.zzaSa.zzaRP, this.zzaSa.zzaRS, this.zzaSa.zzaRR));
                    this.zzaSa.zzaRS = null;
                    com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_SupportWalletFragment_zzb.zza(this.zzaSa.zzaRO);
                    if (this.zzaSa.zzaRT != null) {
                        this.zzaSa.zzaRO.initialize(this.zzaSa.zzaRT);
                        this.zzaSa.zzaRT = null;
                    }
                    if (this.zzaSa.zzaRU != null) {
                        this.zzaSa.zzaRO.updateMaskedWalletRequest(this.zzaSa.zzaRU);
                        this.zzaSa.zzaRU = null;
                    }
                    if (this.zzaSa.zzaRV != null) {
                        this.zzaSa.zzaRO.updateMaskedWallet(this.zzaSa.zzaRV);
                        this.zzaSa.zzaRV = null;
                    }
                    if (this.zzaSa.zzaRW != null) {
                        this.zzaSa.zzaRO.setEnabled(this.zzaSa.zzaRW.booleanValue());
                        this.zzaSa.zzaRW = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions options) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        supportWalletFragment.zzZX.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        return this.zzaRO != null ? this.zzaRO.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzaRO != null) {
            this.zzaRO.initialize(initParams);
            this.zzaRT = null;
        } else if (this.zzaRT == null) {
            this.zzaRT = initParams;
            if (this.zzaRU != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzaRV != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzaRO != null) {
            this.zzaRO.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzaRT != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.zzaRT = walletFragmentInitParams;
            }
            if (this.zzaRU == null) {
                this.zzaRU = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (this.zzaRV == null) {
                this.zzaRV = (MaskedWallet) savedInstanceState.getParcelable("maskedWallet");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.zzaRS = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.zzaRW = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (this.zzZX.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.zzZX.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.zzaL(this.zzZX.getActivity());
                this.zzaRS = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.zzaRQ.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzaRQ.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.zzaRS == null) {
            this.zzaRS = WalletFragmentOptions.zza((Context) activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.zzaRS);
        this.zzaRQ.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.zzaRQ.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaRQ.onResume();
        FragmentManager supportFragmentManager = this.zzZX.getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzZX.getActivity()), this.zzZX.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzaRQ.onSaveInstanceState(outState);
        if (this.zzaRT != null) {
            outState.putParcelable("walletFragmentInitParams", this.zzaRT);
            this.zzaRT = null;
        }
        if (this.zzaRU != null) {
            outState.putParcelable("maskedWalletRequest", this.zzaRU);
            this.zzaRU = null;
        }
        if (this.zzaRV != null) {
            outState.putParcelable("maskedWallet", this.zzaRV);
            this.zzaRV = null;
        }
        if (this.zzaRS != null) {
            outState.putParcelable("walletFragmentOptions", this.zzaRS);
            this.zzaRS = null;
        }
        if (this.zzaRW != null) {
            outState.putBoolean("enabled", this.zzaRW.booleanValue());
            this.zzaRW = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.zzaRQ.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzaRQ.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzaRO != null) {
            this.zzaRO.setEnabled(enabled);
            this.zzaRW = null;
            return;
        }
        this.zzaRW = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzaRR.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzaRO != null) {
            this.zzaRO.updateMaskedWallet(maskedWallet);
            this.zzaRV = null;
            return;
        }
        this.zzaRV = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzaRO != null) {
            this.zzaRO.updateMaskedWalletRequest(request);
            this.zzaRU = null;
            return;
        }
        this.zzaRU = request;
    }
}
