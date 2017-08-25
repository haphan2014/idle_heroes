package com.google.android.gms.nearby.sharing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

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

            public void zza(ProvideContentRequest provideContentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (provideContentRequest != null) {
                        obtain.writeInt(1);
                        provideContentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ReceiveContentRequest receiveContentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (receiveContentRequest != null) {
                        obtain.writeInt(1);
                        receiveContentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(StopProvidingContentRequest stopProvidingContentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (stopProvidingContentRequest != null) {
                        obtain.writeInt(1);
                        stopProvidingContentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(TrustedDevicesRequest trustedDevicesRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (trustedDevicesRequest != null) {
                        obtain.writeInt(1);
                        trustedDevicesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzc com_google_android_gms_nearby_sharing_internal_zzc) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (com_google_android_gms_nearby_sharing_internal_zzc != null) {
                        iBinder = com_google_android_gms_nearby_sharing_internal_zzc.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznF.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzd zzdk(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new zza(iBinder) : (zzd) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ReceiveContentRequest receiveContentRequest = null;
            switch (code) {
                case 1:
                    ProvideContentRequest provideContentRequest;
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (data.readInt() != 0) {
                        provideContentRequest = (ProvideContentRequest) ProvideContentRequest.CREATOR.createFromParcel(data);
                    }
                    zza(provideContentRequest);
                    return true;
                case 2:
                    StopProvidingContentRequest stopProvidingContentRequest;
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (data.readInt() != 0) {
                        stopProvidingContentRequest = (StopProvidingContentRequest) StopProvidingContentRequest.CREATOR.createFromParcel(data);
                    }
                    zza(stopProvidingContentRequest);
                    return true;
                case 3:
                    TrustedDevicesRequest trustedDevicesRequest;
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (data.readInt() != 0) {
                        trustedDevicesRequest = (TrustedDevicesRequest) TrustedDevicesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(trustedDevicesRequest);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (data.readInt() != 0) {
                        receiveContentRequest = (ReceiveContentRequest) ReceiveContentRequest.CREATOR.createFromParcel(data);
                    }
                    zza(receiveContentRequest);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    zza(com.google.android.gms.nearby.sharing.internal.zzc.zza.zzdj(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(ProvideContentRequest provideContentRequest) throws RemoteException;

    void zza(ReceiveContentRequest receiveContentRequest) throws RemoteException;

    void zza(StopProvidingContentRequest stopProvidingContentRequest) throws RemoteException;

    void zza(TrustedDevicesRequest trustedDevicesRequest) throws RemoteException;

    void zza(zzc com_google_android_gms_nearby_sharing_internal_zzc) throws RemoteException;
}
