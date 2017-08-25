package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.AppMetadata;

public interface zzos extends IInterface {

    public static abstract class zza extends Binder implements zzos {

        private static class zza implements zzos {
            private IBinder zznF;

            zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            public void zzE(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zznF.transact(Place.TYPE_POST_BOX, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzN(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zznF.transact(1002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzO(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zznF.transact(Place.TYPE_FLOOR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzP(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zznF.transact(Place.TYPE_POINT_OF_INTEREST, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzQ(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeLong(j);
                    this.zznF.transact(Place.TYPE_POSTAL_CODE, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzor com_google_android_gms_internal_zzor, int i, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzor != null ? com_google_android_gms_internal_zzor.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zznF.transact(Place.TYPE_COUNTRY, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzor com_google_android_gms_internal_zzor, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzor != null ? com_google_android_gms_internal_zzor.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.zznF.transact(Place.TYPE_LOCALITY, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzor com_google_android_gms_internal_zzor, String str, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzor != null ? com_google_android_gms_internal_zzor.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zznF.transact(Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzor com_google_android_gms_internal_zzor, String str, AppMetadata appMetadata, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzor != null ? com_google_android_gms_internal_zzor.asBinder() : null);
                    obtain.writeString(str);
                    if (appMetadata != null) {
                        obtain.writeInt(1);
                        appMetadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zznF.transact(1001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzor com_google_android_gms_internal_zzor, String str, String str2, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzor != null ? com_google_android_gms_internal_zzor.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.zznF.transact(Place.TYPE_GEOCODE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzor com_google_android_gms_internal_zzor, String str, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzor != null ? com_google_android_gms_internal_zzor.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.zznF.transact(Place.TYPE_INTERSECTION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String[] strArr, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStringArray(strArr);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.zznF.transact(Place.TYPE_NATURAL_FEATURE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String[] strArr, byte[] bArr, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeStringArray(strArr);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j);
                    this.zznF.transact(Place.TYPE_NEIGHBORHOOD, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.zznF.transact(Place.TYPE_COLLOQUIAL_AREA, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.zznF.transact(Place.TYPE_POLITICAL, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzwS() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    this.zznF.transact(Place.TYPE_POSTAL_CODE_PREFIX, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzos zzdc(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzos)) ? new zza(iBinder) : (zzos) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String zzQ;
            switch (code) {
                case 1001:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzor.zza.zzdb(data.readStrongBinder()), data.readString(), data.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(data) : null, data.readLong(), data.readLong());
                    reply.writeNoException();
                    return true;
                case 1002:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzN(data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3 /*1003*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzor.zza.zzdb(data.readStrongBinder()), data.readString(), data.readLong(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_COLLOQUIAL_AREA /*1004*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzf(data.readString(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_COUNTRY /*1005*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzor.zza.zzdb(data.readStrongBinder()), data.readInt(), data.readLong(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FLOOR /*1006*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzO(data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GEOCODE /*1007*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzor.zza.zzdb(data.readStrongBinder()), data.readString(), data.readString(), data.createByteArray(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_INTERSECTION /*1008*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzor.zza.zzdb(data.readStrongBinder()), data.readString(), data.createByteArray(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_LOCALITY /*1009*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(com.google.android.gms.internal.zzor.zza.zzdb(data.readStrongBinder()), data.readString(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_NATURAL_FEATURE /*1010*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(data.createStringArray(), data.createByteArray(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_NEIGHBORHOOD /*1011*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzb(data.createStringArray(), data.createByteArray(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POLITICAL /*1012*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzg(data.readString(), data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POINT_OF_INTEREST /*1013*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzP(data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POST_BOX /*1014*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzE(data.readLong());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_POSTAL_CODE /*1015*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzQ = zzQ(data.readLong());
                    reply.writeNoException();
                    reply.writeString(zzQ);
                    return true;
                case Place.TYPE_POSTAL_CODE_PREFIX /*1016*/:
                    data.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzQ = zzwS();
                    reply.writeNoException();
                    reply.writeString(zzQ);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzE(long j) throws RemoteException;

    void zzN(long j) throws RemoteException;

    void zzO(long j) throws RemoteException;

    void zzP(long j) throws RemoteException;

    String zzQ(long j) throws RemoteException;

    void zza(zzor com_google_android_gms_internal_zzor, int i, long j, long j2) throws RemoteException;

    void zza(zzor com_google_android_gms_internal_zzor, String str, long j) throws RemoteException;

    void zza(zzor com_google_android_gms_internal_zzor, String str, long j, long j2) throws RemoteException;

    void zza(zzor com_google_android_gms_internal_zzor, String str, AppMetadata appMetadata, long j, long j2) throws RemoteException;

    void zza(zzor com_google_android_gms_internal_zzor, String str, String str2, byte[] bArr, long j) throws RemoteException;

    void zza(zzor com_google_android_gms_internal_zzor, String str, byte[] bArr, long j) throws RemoteException;

    void zza(String[] strArr, byte[] bArr, long j) throws RemoteException;

    void zzb(String[] strArr, byte[] bArr, long j) throws RemoteException;

    void zzf(String str, long j) throws RemoteException;

    void zzg(String str, long j) throws RemoteException;

    String zzwS() throws RemoteException;
}
