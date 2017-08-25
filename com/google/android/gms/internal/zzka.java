package com.google.android.gms.internal;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzka implements CastRemoteDisplayApi {
    private static final zzl zzQW = new zzl("CastRemoteDisplayApiImpl");
    private ClientKey<zzkb> zzVu;
    private VirtualDisplay zzVv;
    private final zzke zzVw = new C09731(this);

    class C09731 extends com.google.android.gms.internal.zzke.zza {
        final /* synthetic */ zzka zzVx;

        C09731(zzka com_google_android_gms_internal_zzka) {
            this.zzVx = com_google_android_gms_internal_zzka;
        }

        public void zzaR(int i) {
            zzka.zzQW.zzb("onRemoteDisplayEnded", new Object[0]);
            this.zzVx.zzmf();
        }
    }

    private abstract class zzb extends com.google.android.gms.common.api.zza.zza<CastRemoteDisplaySessionResult, zzkb> {
        final /* synthetic */ zzka zzVx;

        protected final class zza extends zza {
            final /* synthetic */ zzb zzVA;
            private final zzkb zzVz;

            public zza(zzb com_google_android_gms_internal_zzka_zzb, zzkb com_google_android_gms_internal_zzkb) {
                this.zzVA = com_google_android_gms_internal_zzka_zzb;
                super();
                this.zzVz = com_google_android_gms_internal_zzkb;
            }

            private int zzi(int i, int i2) {
                if (i >= i2) {
                    i = i2;
                }
                return (i * 320) / 1080;
            }

            public void onError(int statusCode) throws RemoteException {
                zzka.zzQW.zzb("onError: %d", Integer.valueOf(statusCode));
                this.zzVA.zzVx.zzmf();
                this.zzVA.setResult(new zzc(Status.zzXR));
            }

            public void zza(int i, int i2, Surface surface) {
                zzka.zzQW.zzb("onConnected", new Object[0]);
                DisplayManager displayManager = (DisplayManager) this.zzVz.getContext().getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
                if (displayManager == null) {
                    zzka.zzQW.zzc("Unable to get the display manager", new Object[0]);
                    this.zzVA.setResult(new zzc(Status.zzXR));
                    return;
                }
                this.zzVA.zzVx.zzmf();
                this.zzVA.zzVx.zzVv = displayManager.createVirtualDisplay("private_display", i, i2, zzi(i, i2), surface, 2);
                if (this.zzVA.zzVx.zzVv == null) {
                    zzka.zzQW.zzc("Unable to create virtual display", new Object[0]);
                    this.zzVA.setResult(new zzc(Status.zzXR));
                } else if (this.zzVA.zzVx.zzVv.getDisplay() == null) {
                    zzka.zzQW.zzc("Virtual display does not have a display", new Object[0]);
                    this.zzVA.setResult(new zzc(Status.zzXR));
                } else {
                    try {
                        this.zzVz.zza(this, this.zzVA.zzVx.zzVv.getDisplay().getDisplayId());
                    } catch (RemoteException e) {
                        this.zzVA.setResult(new zzc(Status.zzXR));
                    }
                }
            }

            public void zzmg() {
                zzka.zzQW.zzb("onConnectedWithDisplay", new Object[0]);
                Display display = this.zzVA.zzVx.zzVv.getDisplay();
                if (display != null) {
                    this.zzVA.setResult(new zzc(display));
                    return;
                }
                zzka.zzQW.zzc("Virtual display no longer has a display", new Object[0]);
                this.zzVA.setResult(new zzc(Status.zzXR));
            }
        }

        protected final class zzb extends zza {
            final /* synthetic */ zzb zzVA;

            protected zzb(zzb com_google_android_gms_internal_zzka_zzb) {
                this.zzVA = com_google_android_gms_internal_zzka_zzb;
                super();
            }

            public void onDisconnected() throws RemoteException {
                zzka.zzQW.zzb("onDisconnected", new Object[0]);
                this.zzVA.zzVx.zzmf();
                this.zzVA.setResult(new zzc(Status.zzXP));
            }

            public void onError(int statusCode) throws RemoteException {
                zzka.zzQW.zzb("onError: %d", Integer.valueOf(statusCode));
                this.zzVA.zzVx.zzmf();
                this.zzVA.setResult(new zzc(Status.zzXR));
            }
        }

        public zzb(zzka com_google_android_gms_internal_zzka, GoogleApiClient googleApiClient) {
            this.zzVx = com_google_android_gms_internal_zzka;
            super(com_google_android_gms_internal_zzka.zzVu, googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzq(x0);
        }

        protected CastRemoteDisplaySessionResult zzq(Status status) {
            return new zzc(status);
        }
    }

    private abstract class zza extends com.google.android.gms.internal.zzkc.zza {
        final /* synthetic */ zzka zzVx;

        private zza(zzka com_google_android_gms_internal_zzka) {
            this.zzVx = com_google_android_gms_internal_zzka;
        }

        public void onDisconnected() throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void onError(int statusCode) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zza(int i, int i2, Surface surface) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zzmg() throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    private static final class zzc implements CastRemoteDisplaySessionResult {
        private final Status zzOt;
        private final Display zzRi;

        public zzc(Display display) {
            this.zzOt = Status.zzXP;
            this.zzRi = display;
        }

        public zzc(Status status) {
            this.zzOt = status;
            this.zzRi = null;
        }

        public Display getPresentationDisplay() {
            return this.zzRi;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    public zzka(ClientKey<zzkb> clientKey) {
        this.zzVu = clientKey;
    }

    private void zzmf() {
        if (this.zzVv != null) {
            if (this.zzVv.getDisplay() != null) {
                zzQW.zzb("releasing virtual display: " + this.zzVv.getDisplay().getDisplayId(), new Object[0]);
            }
            this.zzVv.release();
            this.zzVv = null;
        }
    }

    public PendingResult<CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient apiClient, final String appId) {
        zzQW.zzb("startRemoteDisplay", new Object[0]);
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ zzka zzVx;

            protected void zza(zzkb com_google_android_gms_internal_zzkb) throws RemoteException {
                com_google_android_gms_internal_zzkb.zza(new zza(this, com_google_android_gms_internal_zzkb), this.zzVx.zzVw, appId);
            }
        });
    }

    public PendingResult<CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient apiClient) {
        zzQW.zzb("stopRemoteDisplay", new Object[0]);
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ zzka zzVx;

            protected void zza(zzkb com_google_android_gms_internal_zzkb) throws RemoteException {
                com_google_android_gms_internal_zzkb.zza(new zzb(this));
            }
        });
    }
}
