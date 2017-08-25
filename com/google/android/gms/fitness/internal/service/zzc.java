package com.google.android.gms.fitness.internal.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzmu;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {
        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            FitnessUnregistrationRequest fitnessUnregistrationRequest = null;
            switch (code) {
                case 1:
                    FitnessDataSourcesRequest fitnessDataSourcesRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        fitnessDataSourcesRequest = (FitnessDataSourcesRequest) FitnessDataSourcesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(fitnessDataSourcesRequest, com.google.android.gms.internal.zzmg.zza.zzbr(data.readStrongBinder()));
                    return true;
                case 2:
                    FitnessSensorServiceRequest fitnessSensorServiceRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        fitnessSensorServiceRequest = (FitnessSensorServiceRequest) FitnessSensorServiceRequest.CREATOR.createFromParcel(data);
                    }
                    zza(fitnessSensorServiceRequest, com.google.android.gms.internal.zzmu.zza.zzbF(data.readStrongBinder()));
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        fitnessUnregistrationRequest = (FitnessUnregistrationRequest) FitnessUnregistrationRequest.CREATOR.createFromParcel(data);
                    }
                    zza(fitnessUnregistrationRequest, com.google.android.gms.internal.zzmu.zza.zzbF(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(FitnessDataSourcesRequest fitnessDataSourcesRequest, zzmg com_google_android_gms_internal_zzmg) throws RemoteException;

    void zza(FitnessUnregistrationRequest fitnessUnregistrationRequest, zzmu com_google_android_gms_internal_zzmu) throws RemoteException;

    void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zzmu com_google_android_gms_internal_zzmu) throws RemoteException;
}
