package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public interface IProjectionDelegate extends IInterface {

    public static abstract class zza extends Binder implements IProjectionDelegate {

        private static class zza implements IProjectionDelegate {
            private IBinder zznF;

            zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            public LatLng fromScreenLocation(zzd point) throws RemoteException {
                LatLng latLng = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    obtain.writeStrongBinder(point != null ? point.asBinder() : null);
                    this.zznF.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        latLng = LatLng.CREATOR.zzeP(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return latLng;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public LatLng fromScreenLocation2(Point point) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (point != null) {
                        obtain.writeInt(1);
                        point.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    LatLng zzeP = obtain2.readInt() != 0 ? LatLng.CREATOR.zzeP(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return zzeP;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public VisibleRegion getVisibleRegion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    this.zznF.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    VisibleRegion zzeZ = obtain2.readInt() != 0 ? VisibleRegion.CREATOR.zzeZ(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return zzeZ;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd toScreenLocation(LatLng location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzbg = com.google.android.gms.dynamic.zzd.zza.zzbg(obtain2.readStrongBinder());
                    return zzbg;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Point toScreenLocation2(LatLng location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    Point zzeK = obtain2.readInt() != 0 ? Point.CREATOR.zzeK(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return zzeK;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IProjectionDelegate zzcE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IProjectionDelegate)) ? new zza(iBinder) : (IProjectionDelegate) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            LatLng latLng = null;
            LatLng fromScreenLocation;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    fromScreenLocation = fromScreenLocation(com.google.android.gms.dynamic.zzd.zza.zzbg(data.readStrongBinder()));
                    reply.writeNoException();
                    if (fromScreenLocation != null) {
                        reply.writeInt(1);
                        fromScreenLocation.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 2:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    zzd toScreenLocation = toScreenLocation(data.readInt() != 0 ? LatLng.CREATOR.zzeP(data) : null);
                    reply.writeNoException();
                    if (toScreenLocation != null) {
                        asBinder = toScreenLocation.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    VisibleRegion visibleRegion = getVisibleRegion();
                    reply.writeNoException();
                    if (visibleRegion != null) {
                        reply.writeInt(1);
                        visibleRegion.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 4:
                    Point zzeK;
                    data.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (data.readInt() != 0) {
                        zzeK = Point.CREATOR.zzeK(data);
                    }
                    fromScreenLocation = fromScreenLocation2(zzeK);
                    reply.writeNoException();
                    if (fromScreenLocation != null) {
                        reply.writeInt(1);
                        fromScreenLocation.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (data.readInt() != 0) {
                        latLng = LatLng.CREATOR.zzeP(data);
                    }
                    Point toScreenLocation2 = toScreenLocation2(latLng);
                    reply.writeNoException();
                    if (toScreenLocation2 != null) {
                        reply.writeInt(1);
                        toScreenLocation2.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IProjectionDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    LatLng fromScreenLocation(zzd com_google_android_gms_dynamic_zzd) throws RemoteException;

    LatLng fromScreenLocation2(Point point) throws RemoteException;

    VisibleRegion getVisibleRegion() throws RemoteException;

    zzd toScreenLocation(LatLng latLng) throws RemoteException;

    Point toScreenLocation2(LatLng latLng) throws RemoteException;
}
