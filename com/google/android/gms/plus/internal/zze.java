package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class zze extends zzi<zzd> {
    private Person zzaHl;
    private final PlusSession zzaHm;

    static final class zza implements LoadMomentsResult {
        private final Status zzOt;
        private final String zzaHn;
        private final String zzaHo;
        private final MomentBuffer zzaHp;

        public zza(Status status, DataHolder dataHolder, String str, String str2) {
            this.zzOt = status;
            this.zzaHn = str;
            this.zzaHo = str2;
            this.zzaHp = dataHolder != null ? new MomentBuffer(dataHolder) : null;
        }

        public MomentBuffer getMomentBuffer() {
            return this.zzaHp;
        }

        public String getNextPageToken() {
            return this.zzaHn;
        }

        public Status getStatus() {
            return this.zzOt;
        }

        public String getUpdated() {
            return this.zzaHo;
        }

        public void release() {
            if (this.zzaHp != null) {
                this.zzaHp.release();
            }
        }
    }

    static final class zzb implements LoadPeopleResult {
        private final Status zzOt;
        private final String zzaHn;
        private final PersonBuffer zzaHq;

        public zzb(Status status, DataHolder dataHolder, String str) {
            this.zzOt = status;
            this.zzaHn = str;
            this.zzaHq = dataHolder != null ? new PersonBuffer(dataHolder) : null;
        }

        public String getNextPageToken() {
            return this.zzaHn;
        }

        public PersonBuffer getPersonBuffer() {
            return this.zzaHq;
        }

        public Status getStatus() {
            return this.zzOt;
        }

        public void release() {
            if (this.zzaHq != null) {
                this.zzaHq.release();
            }
        }
    }

    static final class zzc extends zza {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzayZ;

        public zzc(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzayZ = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzaO(Status status) {
            this.zzayZ.zzm(status);
        }
    }

    static final class zzd extends zza {
        private final com.google.android.gms.common.api.zza.zzb<LoadMomentsResult> zzayZ;

        public zzd(com.google.android.gms.common.api.zza.zzb<LoadMomentsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) {
            this.zzayZ = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult;
        }

        public void zza(DataHolder dataHolder, String str, String str2) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zznb() != null ? (PendingIntent) dataHolder.zznb().getParcelable("pendingIntent") : null);
            if (!(status.isSuccess() || dataHolder == null)) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzayZ.zzm(new zza(status, dataHolder, str, str2));
        }
    }

    static final class zze extends zza {
        private final com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> zzayZ;

        public zze(com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult) {
            this.zzayZ = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult;
        }

        public void zza(DataHolder dataHolder, String str) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zznb() != null ? (PendingIntent) dataHolder.zznb().getParcelable("pendingIntent") : null);
            if (!(status.isSuccess() || dataHolder == null)) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzayZ.zzm(new zzb(status, dataHolder, str));
        }
    }

    static final class zzf extends zza {
        private final com.google.android.gms.common.api.zza.zzb<Status> zzayZ;

        public zzf(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            this.zzayZ = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzi(int i, Bundle bundle) {
            this.zzayZ.zzm(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zze com_google_android_gms_common_internal_zze, PlusSession plusSession, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zze);
        this.zzaHm = plusSession;
    }

    public static boolean zze(Set<Scope> set) {
        return (set == null || set.isEmpty()) ? false : (set.size() == 1 && set.contains(new Scope("plus_one_placeholder_scope"))) ? false : true;
    }

    private Bundle zzkS() {
        Bundle zzxE = this.zzaHm.zzxE();
        zzxE.putStringArray("request_visible_actions", this.zzaHm.zzxy());
        zzxE.putString("auth_package", this.zzaHm.zzxA());
        return zzxE;
    }

    public String getAccountName() {
        zznL();
        try {
            return ((zzd) zznM()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.plus.service.START";
    }

    public boolean requiresSignIn() {
        return zze(zznK().zzb(Plus.API));
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzdu(iBinder);
    }

    public ICancelToken zza(com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, int i, String str) {
        zznL();
        Object com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            return ((zzd) zznM()).zza(com_google_android_gms_plus_internal_zze_zze, 1, i, -1, str);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzbi(8), null);
            return null;
        }
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.zzaHl = PersonEntity.zzp(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<LoadMomentsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult, int i, String str, Uri uri, String str2, String str3) {
        zznL();
        Object com_google_android_gms_plus_internal_zze_zzd = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult != null ? new zzd(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) : null;
        try {
            ((zzd) zznM()).zza(com_google_android_gms_plus_internal_zze_zzd, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzd.zza(DataHolder.zzbi(8), null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, Moment moment) {
        zznL();
        zzb com_google_android_gms_plus_internal_zze_zzc = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status != null ? new zzc(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) : null;
        try {
            ((zzd) zznM()).zza(com_google_android_gms_plus_internal_zze_zzc, SafeParcelResponse.zza((MomentEntity) moment));
        } catch (Throwable e) {
            if (com_google_android_gms_plus_internal_zze_zzc == null) {
                throw new IllegalStateException(e);
            }
            com_google_android_gms_plus_internal_zze_zzc.zzaO(new Status(8, null, null));
        }
    }

    public void zza(com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, Collection<String> collection) {
        zznL();
        zzb com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            ((zzd) zznM()).zza(com_google_android_gms_plus_internal_zze_zze, new ArrayList(collection));
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzbi(8), null);
        }
    }

    public void zzd(com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, String[] strArr) {
        zza((com.google.android.gms.common.api.zza.zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, Arrays.asList(strArr));
    }

    public void zzdX(String str) {
        zznL();
        try {
            ((zzd) zznM()).zzdX(str);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected zzd zzdu(IBinder iBinder) {
        return com.google.android.gms.plus.internal.zzd.zza.zzdt(iBinder);
    }

    public void zzi(com.google.android.gms.common.api.zza.zzb<LoadMomentsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) {
        zza(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult, 20, null, null, null, "me");
    }

    public void zzj(com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult) {
        zznL();
        Object com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            ((zzd) zznM()).zza(com_google_android_gms_plus_internal_zze_zze, 2, 1, -1, null);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzbi(8), null);
        }
    }

    public void zzk(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
        zznL();
        zzxr();
        Object com_google_android_gms_plus_internal_zze_zzf = new zzf(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        try {
            ((zzd) zznM()).zzb(com_google_android_gms_plus_internal_zze_zzf);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzf.zzi(8, null);
        }
    }

    protected Bundle zzkR() {
        return zzkS();
    }

    protected Bundle zznN() {
        return zzkS();
    }

    public ICancelToken zzq(com.google.android.gms.common.api.zza.zzb<LoadPeopleResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, String str) {
        return zza(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_plus_People_LoadPeopleResult, 0, str);
    }

    public void zzxr() {
        zznL();
        try {
            this.zzaHl = null;
            ((zzd) zznM()).zzxr();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person zzxu() {
        zznL();
        return this.zzaHl;
    }
}
