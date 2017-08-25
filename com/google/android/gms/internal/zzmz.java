package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zzmz implements BleApi {

    private static class zza extends com.google.android.gms.internal.zzni.zza {
        private final zzb<BleDevicesResult> zzOs;

        private zza(zzb<BleDevicesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_BleDevicesResult) {
            this.zzOs = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_fitness_result_BleDevicesResult;
        }

        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzOs.zzm(bleDevicesResult);
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final BleDevice bleDevice) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzmz zzakY;

            protected void zza(zzlx com_google_android_gms_internal_zzlx) throws RemoteException {
                ((zzmi) com_google_android_gms_internal_zzlx.zznM()).zza(new ClaimBleDeviceRequest(bleDevice.getAddress(), bleDevice, new zzng(this), com_google_android_gms_internal_zzlx.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzmz zzakY;

            protected void zza(zzlx com_google_android_gms_internal_zzlx) throws RemoteException {
                ((zzmi) com_google_android_gms_internal_zzlx.zznM()).zza(new ClaimBleDeviceRequest(deviceAddress, null, new zzng(this), com_google_android_gms_internal_zzlx.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return client.zza(new zza<BleDevicesResult>(this, client) {
            final /* synthetic */ zzmz zzakY;

            protected /* synthetic */ Result createFailedResult(Status x0) {
                return zzB(x0);
            }

            protected BleDevicesResult zzB(Status status) {
                return BleDevicesResult.zzJ(status);
            }

            protected void zza(zzlx com_google_android_gms_internal_zzlx) throws RemoteException {
                ((zzmi) com_google_android_gms_internal_zzlx.zznM()).zza(new ListClaimedBleDevicesRequest(new zza(this), com_google_android_gms_internal_zzlx.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, final StartBleScanRequest request) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzmz zzakY;

            protected void zza(zzlx com_google_android_gms_internal_zzlx) throws RemoteException {
                ((zzmi) com_google_android_gms_internal_zzlx.zznM()).zza(new StartBleScanRequest(request, new zzng(this), com_google_android_gms_internal_zzlx.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, final BleScanCallback requestCallback) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzmz zzakY;

            protected void zza(zzlx com_google_android_gms_internal_zzlx) throws RemoteException {
                ((zzmi) com_google_android_gms_internal_zzlx.zznM()).zza(new StopBleScanRequest(requestCallback, new zzng(this), com_google_android_gms_internal_zzlx.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return unclaimBleDevice(client, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzmz zzakY;

            protected void zza(zzlx com_google_android_gms_internal_zzlx) throws RemoteException {
                ((zzmi) com_google_android_gms_internal_zzlx.zznM()).zza(new UnclaimBleDeviceRequest(deviceAddress, new zzng(this), com_google_android_gms_internal_zzlx.getContext().getPackageName()));
            }
        });
    }
}
