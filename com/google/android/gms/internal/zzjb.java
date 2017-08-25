package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import java.util.Set;

public final class zzjb extends zzi<zzjd> {

    private static final class zza extends zzja {
        private final com.google.android.gms.common.api.zza.zzb<StateDeletedResult> zzOs;

        public zza(com.google.android.gms.common.api.zza.zzb<StateDeletedResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateDeletedResult) {
            this.zzOs = (com.google.android.gms.common.api.zza.zzb) zzu.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateDeletedResult, (Object) "Result holder must not be null");
        }

        public void zzg(int i, int i2) {
            this.zzOs.zzm(new zzb(new Status(i), i2));
        }
    }

    private static final class zzb implements StateDeletedResult {
        private final Status zzOt;
        private final int zzOu;

        public zzb(Status status, int i) {
            this.zzOt = status;
            this.zzOu = i;
        }

        public int getStateKey() {
            return this.zzOu;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class zzc extends zzja {
        private final com.google.android.gms.common.api.zza.zzb<StateListResult> zzOs;

        public zzc(com.google.android.gms.common.api.zza.zzb<StateListResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateListResult) {
            this.zzOs = (com.google.android.gms.common.api.zza.zzb) zzu.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateListResult, (Object) "Result holder must not be null");
        }

        public void zza(DataHolder dataHolder) {
            this.zzOs.zzm(new zzd(dataHolder));
        }
    }

    private static final class zzd extends com.google.android.gms.common.api.zzc implements StateListResult {
        private final AppStateBuffer zzOv;

        public zzd(DataHolder dataHolder) {
            super(dataHolder);
            this.zzOv = new AppStateBuffer(dataHolder);
        }

        public AppStateBuffer getStateBuffer() {
            return this.zzOv;
        }
    }

    private static final class zze extends zzja {
        private final com.google.android.gms.common.api.zza.zzb<StateResult> zzOs;

        public zze(com.google.android.gms.common.api.zza.zzb<StateResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult) {
            this.zzOs = (com.google.android.gms.common.api.zza.zzb) zzu.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult, (Object) "Result holder must not be null");
        }

        public void zza(int i, DataHolder dataHolder) {
            this.zzOs.zzm(new zzf(i, dataHolder));
        }
    }

    private static final class zzf extends com.google.android.gms.common.api.zzc implements StateConflictResult, StateLoadedResult, StateResult {
        private final int zzOu;
        private final AppStateBuffer zzOv;

        public zzf(int i, DataHolder dataHolder) {
            super(dataHolder);
            this.zzOu = i;
            this.zzOv = new AppStateBuffer(dataHolder);
        }

        private boolean zzkX() {
            return this.zzOt.getStatusCode() == 2000;
        }

        public StateConflictResult getConflictResult() {
            return zzkX() ? this : null;
        }

        public StateLoadedResult getLoadedResult() {
            return zzkX() ? null : this;
        }

        public byte[] getLocalData() {
            return this.zzOv.getCount() == 0 ? null : this.zzOv.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.zzOv.getCount() == 0 ? null : this.zzOv.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.zzOv.getCount() == 0 ? null : this.zzOv.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.zzOu;
        }

        public void release() {
            this.zzOv.release();
        }
    }

    private static final class zzg extends zzja {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzOs;

        public zzg(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzOs = (com.google.android.gms.common.api.zza.zzb) zzu.zzb((Object) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zzkU() {
            this.zzOs.zzm(new Status(0));
        }
    }

    public zzjb(Context context, Looper looper, com.google.android.gms.common.internal.zze com_google_android_gms_common_internal_zze, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 7, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.appstate.service.START";
    }

    public boolean requiresSignIn() {
        return true;
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzaj(iBinder);
    }

    protected Set<Scope> zza(Set<Scope> set) {
        zzu.zza(set.contains(new Scope(Scopes.APP_STATE)), String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
        return set;
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StateListResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateListResult) throws RemoteException {
        ((zzjd) zznM()).zza(new zzc(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateListResult));
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StateDeletedResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateDeletedResult, int i) throws RemoteException {
        ((zzjd) zznM()).zzb(new zza(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateDeletedResult), i);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StateResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult, int i, String str, byte[] bArr) throws RemoteException {
        ((zzjd) zznM()).zza(new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult), i, str, bArr);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<StateResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult, int i, byte[] bArr) throws RemoteException {
        zzjc com_google_android_gms_internal_zzjc;
        if (com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult == null) {
            com_google_android_gms_internal_zzjc = null;
        } else {
            Object com_google_android_gms_internal_zzjb_zze = new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult);
        }
        ((zzjd) zznM()).zza(com_google_android_gms_internal_zzjc, i, bArr);
    }

    protected zzjd zzaj(IBinder iBinder) {
        return com.google.android.gms.internal.zzjd.zza.zzal(iBinder);
    }

    public void zzb(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        ((zzjd) zznM()).zzb(new zzg(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status));
    }

    public void zzb(com.google.android.gms.common.api.zza.zzb<StateResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult, int i) throws RemoteException {
        ((zzjd) zznM()).zza(new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_appstate_AppStateManager_StateResult), i);
    }

    public int zzkV() {
        try {
            return ((zzjd) zznM()).zzkV();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int zzkW() {
        try {
            return ((zzjd) zznM()).zzkW();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }
}
