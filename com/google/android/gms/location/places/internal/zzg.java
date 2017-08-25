package com.google.android.gms.location.places.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.PlacePhotoResult;

public interface zzg extends IInterface {

    public static abstract class zza extends Binder implements zzg {

        private static class zza implements zzg {
            private IBinder zznF;

            zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            public void zza(PlacePhotoMetadataResult placePhotoMetadataResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPhotosCallbacks");
                    if (placePhotoMetadataResult != null) {
                        obtain.writeInt(1);
                        placePhotoMetadataResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(PlacePhotoResult placePhotoResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPhotosCallbacks");
                    if (placePhotoResult != null) {
                        obtain.writeInt(1);
                        placePhotoResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzg zzcb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPhotosCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzg)) ? new zza(iBinder) : (zzg) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            PlacePhotoResult placePhotoResult = null;
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IPhotosCallbacks");
                    if (data.readInt() != 0) {
                        placePhotoResult = (PlacePhotoResult) PlacePhotoResult.CREATOR.createFromParcel(data);
                    }
                    zza(placePhotoResult);
                    return true;
                case 3:
                    PlacePhotoMetadataResult placePhotoMetadataResult;
                    data.enforceInterface("com.google.android.gms.location.places.internal.IPhotosCallbacks");
                    if (data.readInt() != 0) {
                        placePhotoMetadataResult = (PlacePhotoMetadataResult) PlacePhotoMetadataResult.CREATOR.createFromParcel(data);
                    }
                    zza(placePhotoMetadataResult);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.places.internal.IPhotosCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(PlacePhotoMetadataResult placePhotoMetadataResult) throws RemoteException;

    void zza(PlacePhotoResult placePhotoResult) throws RemoteException;
}
