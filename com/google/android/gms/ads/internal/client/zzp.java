package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;

public interface zzp extends IInterface {

    public static abstract class zza extends Binder implements zzp {

        private static class zza implements zzp {
            private IBinder zznF;

            zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    if (nativeAdOptionsParcel != null) {
                        obtain.writeInt(1);
                        nativeAdOptionsParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzcu com_google_android_gms_internal_zzcu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzcu != null ? com_google_android_gms_internal_zzcu.asBinder() : null);
                    this.zznF.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzcv com_google_android_gms_internal_zzcv) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzcv != null ? com_google_android_gms_internal_zzcv.asBinder() : null);
                    this.zznF.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzcx com_google_android_gms_internal_zzcx, zzcw com_google_android_gms_internal_zzcw) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzcx != null ? com_google_android_gms_internal_zzcx.asBinder() : null);
                    if (com_google_android_gms_internal_zzcw != null) {
                        iBinder = com_google_android_gms_internal_zzcw.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznF.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzn com_google_android_gms_ads_internal_client_zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(com_google_android_gms_ads_internal_client_zzn != null ? com_google_android_gms_ads_internal_client_zzn.asBinder() : null);
                    this.zznF.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzo zzbi() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    this.zznF.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzo zzh = com.google.android.gms.ads.internal.client.zzo.zza.zzh(obtain2.readStrongBinder());
                    return zzh;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        }

        public static zzp zzi(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzp)) ? new zza(iBinder) : (zzp) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            NativeAdOptionsParcel nativeAdOptionsParcel = null;
            switch (code) {
                case 1:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zzo zzbi = zzbi();
                    reply.writeNoException();
                    if (zzbi != null) {
                        asBinder = zzbi.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zzb(com.google.android.gms.ads.internal.client.zzn.zza.zzg(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zza(com.google.android.gms.internal.zzcu.zza.zzz(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zza(com.google.android.gms.internal.zzcv.zza.zzA(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    zza(data.readString(), com.google.android.gms.internal.zzcx.zza.zzC(data.readStrongBinder()), com.google.android.gms.internal.zzcw.zza.zzB(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    if (data.readInt() != 0) {
                        nativeAdOptionsParcel = NativeAdOptionsParcel.CREATOR.zzf(data);
                    }
                    zza(nativeAdOptionsParcel);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException;

    void zza(zzcu com_google_android_gms_internal_zzcu) throws RemoteException;

    void zza(zzcv com_google_android_gms_internal_zzcv) throws RemoteException;

    void zza(String str, zzcx com_google_android_gms_internal_zzcx, zzcw com_google_android_gms_internal_zzcw) throws RemoteException;

    void zzb(zzn com_google_android_gms_ads_internal_client_zzn) throws RemoteException;

    zzo zzbi() throws RemoteException;
}
