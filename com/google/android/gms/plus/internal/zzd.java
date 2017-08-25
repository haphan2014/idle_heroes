package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.location.places.Place;
import java.util.List;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        private static class zza implements zzd {
            private IBinder zznF;

            zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            public String getAccountName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zznF.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAuthCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zznF.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICancelToken zza(zzb com_google_android_gms_plus_internal_zzb, int i, int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.zznF.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    ICancelToken zzaE = com.google.android.gms.common.internal.ICancelToken.zza.zzaE(obtain2.readStrongBinder());
                    return zzaE;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SafeParcelResponse safeParcelResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (safeParcelResponse != null) {
                        obtain.writeInt(1);
                        safeParcelResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    this.zznF.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, int i, String str, Uri uri, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zznF.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, SafeParcelResponse safeParcelResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    if (safeParcelResponse != null) {
                        obtain.writeInt(1);
                        safeParcelResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zznF.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zznF.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeStringList(list);
                    this.zznF.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, FavaDiagnosticsEntity favaDiagnosticsEntity, FavaDiagnosticsEntity favaDiagnosticsEntity2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(str);
                    if (favaDiagnosticsEntity != null) {
                        obtain.writeInt(1);
                        favaDiagnosticsEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (favaDiagnosticsEntity2 != null) {
                        obtain.writeInt(1);
                        favaDiagnosticsEntity2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzb com_google_android_gms_plus_internal_zzb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    this.zznF.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zznF.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zznF.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zznF.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzdX(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(str);
                    this.zznF.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zznF.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzxr() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zznF.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzxs() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zznF.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzxt() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zznF.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzd zzdt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new zza(iBinder) : (zzd) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            FavaDiagnosticsEntity favaDiagnosticsEntity = null;
            String accountName;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzdr(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzdr(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzb(com.google.android.gms.plus.internal.zzb.zza.zzdr(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(data.readInt() != 0 ? SafeParcelResponse.CREATOR.zzal(data) : null);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = getAccountName();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzxr();
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzdr(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzdr(data.readStrongBinder()), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzdr(data.readStrongBinder()), data.readInt(), data.readString(), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 16:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    ICancelToken zza = zza(com.google.android.gms.plus.internal.zzb.zza.zzdr(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    if (zza != null) {
                        asBinder = zza.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzdX(data.readString());
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzc(com.google.android.gms.plus.internal.zzb.zza.zzdr(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzb(com.google.android.gms.plus.internal.zzb.zza.zzdr(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ESTABLISHMENT /*34*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzdr(data.readStrongBinder()), data.createStringArrayList());
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzd(com.google.android.gms.plus.internal.zzb.zza.zzdr(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GAS_STATION /*41*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = getAuthCode();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    boolean zzxs = zzxs();
                    reply.writeNoException();
                    reply.writeInt(zzxs ? 1 : 0);
                    return true;
                case Place.TYPE_GROCERY_OR_SUPERMARKET /*43*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = zzxt();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case Place.TYPE_GYM /*44*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zze(com.google.android.gms.plus.internal.zzb.zza.zzdr(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HAIR_CARE /*45*/:
                    SafeParcelResponse zzal;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzb zzdr = com.google.android.gms.plus.internal.zzb.zza.zzdr(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        zzal = SafeParcelResponse.CREATOR.zzal(data);
                    }
                    zza(zzdr, zzal);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HARDWARE_STORE /*46*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    String readString = data.readString();
                    FavaDiagnosticsEntity zzad = data.readInt() != 0 ? FavaDiagnosticsEntity.CREATOR.zzad(data) : null;
                    if (data.readInt() != 0) {
                        favaDiagnosticsEntity = FavaDiagnosticsEntity.CREATOR.zzad(data);
                    }
                    zza(readString, zzad, favaDiagnosticsEntity);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    String getAccountName() throws RemoteException;

    String getAuthCode() throws RemoteException;

    ICancelToken zza(zzb com_google_android_gms_plus_internal_zzb, int i, int i2, int i3, String str) throws RemoteException;

    void zza(SafeParcelResponse safeParcelResponse) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb, int i, String str, Uri uri, String str2, String str3) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb, Uri uri, Bundle bundle) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb, SafeParcelResponse safeParcelResponse) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb, String str, String str2) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb, List<String> list) throws RemoteException;

    void zza(String str, FavaDiagnosticsEntity favaDiagnosticsEntity, FavaDiagnosticsEntity favaDiagnosticsEntity2) throws RemoteException;

    void zzb(zzb com_google_android_gms_plus_internal_zzb) throws RemoteException;

    void zzb(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException;

    void zzc(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException;

    void zzd(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException;

    void zzdX(String str) throws RemoteException;

    void zze(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException;

    void zzxr() throws RemoteException;

    boolean zzxs() throws RemoteException;

    String zzxt() throws RemoteException;
}
