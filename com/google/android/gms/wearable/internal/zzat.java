package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;

public interface zzat extends IInterface {

    public static abstract class zza extends Binder implements zzat {

        private static class zza implements zzat {
            private IBinder zznF;

            zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznF.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zznF.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, Asset asset) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (asset != null) {
                        obtain.writeInt(1);
                        asset.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, PutDataRequest putDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (putDataRequest != null) {
                        obtain.writeInt(1);
                        putDataRequest.writeToParcel(obtain, 0);
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

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, AddListenerRequest addListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (addListenerRequest != null) {
                        obtain.writeInt(1);
                        addListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (ancsNotificationParcelable != null) {
                        obtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, RemoveListenerRequest removeListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (removeListenerRequest != null) {
                        obtain.writeInt(1);
                        removeListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, zzaq com_google_android_gms_wearable_internal_zzaq, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzaq != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzaq.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zznF.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeString(str);
                    this.zznF.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zznF.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zznF.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zznF.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    this.zznF.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_wearable_internal_zzar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznF.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzar com_google_android_gms_wearable_internal_zzar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznF.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzar com_google_android_gms_wearable_internal_zzar, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
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

            public void zzb(zzar com_google_android_gms_wearable_internal_zzar, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zznF.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzar com_google_android_gms_wearable_internal_zzar, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzar com_google_android_gms_wearable_internal_zzar, zzaq com_google_android_gms_wearable_internal_zzaq, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (com_google_android_gms_wearable_internal_zzaq != null) {
                        iBinder = com_google_android_gms_wearable_internal_zzaq.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zznF.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzar com_google_android_gms_wearable_internal_zzar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeString(str);
                    this.zznF.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzar com_google_android_gms_wearable_internal_zzar, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zznF.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzar com_google_android_gms_wearable_internal_zzar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznF.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzar com_google_android_gms_wearable_internal_zzar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznF.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzar com_google_android_gms_wearable_internal_zzar, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzar com_google_android_gms_wearable_internal_zzar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeString(str);
                    this.zznF.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzar com_google_android_gms_wearable_internal_zzar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeString(str);
                    this.zznF.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzar com_google_android_gms_wearable_internal_zzar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeString(str);
                    this.zznF.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzar com_google_android_gms_wearable_internal_zzar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    obtain.writeString(str);
                    this.zznF.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzm(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzn(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(com_google_android_gms_wearable_internal_zzar != null ? com_google_android_gms_wearable_internal_zzar.asBinder() : null);
                    this.zznF.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzat zzdQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzat)) ? new zza(iBinder) : (zzat) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            ConnectionConfiguration connectionConfiguration = null;
            zzar zzdO;
            Uri uri;
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdO = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(data);
                    }
                    zzb(zzdO, connectionConfiguration);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzm(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzn(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzo(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 6:
                    PutDataRequest putDataRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdO = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        putDataRequest = (PutDataRequest) PutDataRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzdO, putDataRequest);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdO = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zza(zzdO, uri);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdO = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzb(zzdO, uri);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdO = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzc(zzdO, uri);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readString(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 13:
                    Asset asset;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdO = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        asset = (Asset) Asset.CREATOR.createFromParcel(data);
                    }
                    zza(zzdO, asset);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    AddListenerRequest addListenerRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdO = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        addListenerRequest = (AddListenerRequest) AddListenerRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzdO, addListenerRequest);
                    reply.writeNoException();
                    return true;
                case 17:
                    RemoveListenerRequest removeListenerRequest;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdO = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        removeListenerRequest = (RemoveListenerRequest) RemoveListenerRequest.CREATOR.createFromParcel(data);
                    }
                    zza(zzdO, removeListenerRequest);
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CAR_WASH /*20*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdO = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(data);
                    }
                    zza(zzdO, connectionConfiguration);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CASINO /*21*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CEMETERY /*22*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CHURCH /*23*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CITY_HALL /*24*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CLOTHING_STORE /*25*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzg(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CONVENIENCE_STORE /*26*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzh(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_COURTHOUSE /*27*/:
                    AncsNotificationParcelable ancsNotificationParcelable;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdO = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        ancsNotificationParcelable = (AncsNotificationParcelable) AncsNotificationParcelable.CREATOR.createFromParcel(data);
                    }
                    zza(zzdO, ancsNotificationParcelable);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_DENTIST /*28*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_DEPARTMENT_STORE /*29*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 30:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzi(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 31:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_EMBASSY /*33*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ESTABLISHMENT /*34*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), com.google.android.gms.wearable.internal.zzaq.zza.zzdN(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FINANCE /*35*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), com.google.android.gms.wearable.internal.zzaq.zza.zzdN(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FLORIST /*37*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzj(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FOOD /*38*/:
                    ParcelFileDescriptor parcelFileDescriptor;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdO = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data);
                    }
                    zza(zzdO, readString, parcelFileDescriptor);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FUNERAL_HOME /*39*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readString(), data.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data) : null, data.readLong(), data.readLong());
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdO = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zza(zzdO, uri, data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GAS_STATION /*41*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzdO = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    zzb(zzdO, uri, data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GROCERY_OR_SUPERMARKET /*43*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HARDWARE_STORE /*46*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HEALTH /*47*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HINDU_TEMPLE /*48*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HOME_GOODS_STORE /*49*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzk(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 50:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzar zzdO2 = com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzb(zzdO2, z);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_INSURANCE_AGENCY /*51*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzl(com.google.android.gms.wearable.internal.zzar.zza.zzdO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, int i) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, Uri uri) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, Uri uri, int i) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, Asset asset) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, PutDataRequest putDataRequest) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, AddListenerRequest addListenerRequest) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, RemoveListenerRequest removeListenerRequest) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, zzaq com_google_android_gms_wearable_internal_zzaq, String str) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, String str) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, String str, int i) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, String str, String str2) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, String str, String str2, byte[] bArr) throws RemoteException;

    void zza(zzar com_google_android_gms_wearable_internal_zzar, boolean z) throws RemoteException;

    void zzb(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zzb(zzar com_google_android_gms_wearable_internal_zzar, int i) throws RemoteException;

    void zzb(zzar com_google_android_gms_wearable_internal_zzar, Uri uri) throws RemoteException;

    void zzb(zzar com_google_android_gms_wearable_internal_zzar, Uri uri, int i) throws RemoteException;

    void zzb(zzar com_google_android_gms_wearable_internal_zzar, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zzb(zzar com_google_android_gms_wearable_internal_zzar, zzaq com_google_android_gms_wearable_internal_zzaq, String str) throws RemoteException;

    void zzb(zzar com_google_android_gms_wearable_internal_zzar, String str) throws RemoteException;

    void zzb(zzar com_google_android_gms_wearable_internal_zzar, String str, int i) throws RemoteException;

    void zzb(zzar com_google_android_gms_wearable_internal_zzar, boolean z) throws RemoteException;

    void zzc(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zzc(zzar com_google_android_gms_wearable_internal_zzar, int i) throws RemoteException;

    void zzc(zzar com_google_android_gms_wearable_internal_zzar, Uri uri) throws RemoteException;

    void zzc(zzar com_google_android_gms_wearable_internal_zzar, String str) throws RemoteException;

    void zzd(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zzd(zzar com_google_android_gms_wearable_internal_zzar, String str) throws RemoteException;

    void zze(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zze(zzar com_google_android_gms_wearable_internal_zzar, String str) throws RemoteException;

    void zzf(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zzf(zzar com_google_android_gms_wearable_internal_zzar, String str) throws RemoteException;

    void zzg(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zzh(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zzi(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zzj(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zzk(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zzl(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zzm(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zzn(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;

    void zzo(zzar com_google_android_gms_wearable_internal_zzar) throws RemoteException;
}
