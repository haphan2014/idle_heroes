package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;

public interface zzph extends IInterface {

    public static abstract class zza extends Binder implements zzph {

        private static class zza implements zzph {
            private IBinder zznF;

            zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            public void zza(Status status, AttestationData attestationData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (attestationData != null) {
                        obtain.writeInt(1);
                        attestationData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzdZ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    obtain.writeString(str);
                    this.zznF.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
        }

        public static zzph zzdw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzph)) ? new zza(iBinder) : (zzph) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zza(data.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (AttestationData) AttestationData.CREATOR.createFromParcel(data) : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zzdZ(data.readString());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(Status status, AttestationData attestationData) throws RemoteException;

    void zzdZ(String str) throws RemoteException;
}
