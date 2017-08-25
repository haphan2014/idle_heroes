package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.identity.intents.AddressConstants.ErrorCodes;
import com.google.android.gms.identity.intents.AddressConstants.Extras;
import com.google.android.gms.identity.intents.UserAddressRequest;

public class zznk extends zzi<zznm> {
    private Activity mActivity;
    private final int mTheme;
    private final String zzOx;
    private zza zzawz;

    public static final class zza extends com.google.android.gms.internal.zznl.zza {
        private Activity mActivity;
        private final int zzZY;

        public zza(int i, Activity activity) {
            this.zzZY = i;
            this.mActivity = activity;
        }

        private void setActivity(Activity activity) {
            this.mActivity = activity;
        }

        public void zzh(int i, Bundle bundle) {
            PendingIntent createPendingResult;
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                createPendingResult = this.mActivity.createPendingResult(this.zzZY, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                        return;
                    } catch (Throwable e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                        return;
                    }
                }
                return;
            }
            createPendingResult = null;
            if (bundle != null) {
                createPendingResult = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, createPendingResult);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.mActivity, this.zzZY);
                    return;
                } catch (Throwable e2) {
                    Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    return;
                }
            }
            try {
                createPendingResult = this.mActivity.createPendingResult(this.zzZY, new Intent(), 1073741824);
                if (createPendingResult != null) {
                    createPendingResult.send(1);
                }
            } catch (Throwable e22) {
                Log.w("AddressClientImpl", "Exception setting pending result", e22);
            }
        }
    }

    public zznk(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, int i) {
        super((Context) activity, looper, 12, connectionCallbacks, onConnectionFailedListener);
        this.zzOx = str;
        this.mActivity = activity;
        this.mTheme = i;
    }

    public void disconnect() {
        super.disconnect();
        if (this.zzawz != null) {
            this.zzawz.setActivity(null);
            this.zzawz = null;
        }
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.identity.service.BIND";
    }

    public boolean requiresAccount() {
        return true;
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzbO(iBinder);
    }

    public void zza(UserAddressRequest userAddressRequest, int i) {
        zzuc();
        this.zzawz = new zza(i, this.mActivity);
        Bundle bundle;
        try {
            bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.zzOx)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.zzOx, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            zzub().zza(this.zzawz, userAddressRequest, bundle);
        } catch (Throwable e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            bundle = new Bundle();
            bundle.putInt(Extras.EXTRA_ERROR_CODE, ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.zzawz.zzh(1, bundle);
        }
    }

    protected zznm zzbO(IBinder iBinder) {
        return com.google.android.gms.internal.zznm.zza.zzbQ(iBinder);
    }

    protected zznm zzub() throws DeadObjectException {
        return (zznm) super.zznM();
    }

    protected void zzuc() {
        super.zznL();
    }
}
