package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.cast.internal.zzb;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzu;
import java.io.IOException;

public final class Cast {
    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;
    public static final Api<CastOptions> API = new Api("Cast.API", zzNY, zzk.zzNX, new Scope[0]);
    public static final CastApi CastApi = new zza();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;
    private static final com.google.android.gms.common.api.Api.zza<zze, CastOptions> zzNY = new C04291();

    static class C04291 implements com.google.android.gms.common.api.Api.zza<zze, CastOptions> {
        C04291() {
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public zze zza(Context context, Looper looper, com.google.android.gms.common.internal.zze com_google_android_gms_common_internal_zze, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzu.zzb((Object) castOptions, (Object) "Setting the API options is required.");
            return new zze(context, looper, castOptions.zzQE, (long) castOptions.zzQG, castOptions.zzQF, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    private static abstract class zza extends zzb<ApplicationConnectionResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzl(x0);
        }

        public ApplicationConnectionResult zzl(final Status status) {
            return new ApplicationConnectionResult(this) {
                final /* synthetic */ zza zzQK;

                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    public interface CastApi {

        public static final class zza implements CastApi {
            public int getActiveInputState(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzNX)).zzlP();
            }

            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzNX)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzNX)).getApplicationStatus();
            }

            public int getStandbyState(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzNX)).zzlQ();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzNX)).zzlO();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzNX)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return client.zzb(new zza(this, client) {
                    final /* synthetic */ zza zzQB;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zzb(null, null, this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId) {
                return client.zzb(new zza(this, client) {
                    final /* synthetic */ zza zzQB;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zzb(applicationId, null, this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId, final String sessionId) {
                return client.zzb(new zza(this, client) {
                    final /* synthetic */ zza zzQB;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zzb(applicationId, sessionId, this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId) {
                return client.zzb(new zza(this, client) {
                    final /* synthetic */ zza zzQB;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zza(applicationId, false, (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId, final LaunchOptions options) {
                return client.zzb(new zza(this, client) {
                    final /* synthetic */ zza zzQB;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zza(applicationId, options, (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return launchApplication(client, applicationId, new Builder().setRelaunchIfRunning(relaunchIfRunning).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.zzb(new zzh(this, client) {
                    final /* synthetic */ zza zzQB;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zzd((com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((zze) client.zza(zzk.zzNX)).zzbC(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzNX)).zzlN();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, final String namespace, final String message) {
                return client.zzb(new zzh(this, client) {
                    final /* synthetic */ zza zzQB;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zza(namespace, message, (com.google.android.gms.common.api.zza.zzb) this);
                            return;
                        } catch (IllegalArgumentException e) {
                        } catch (IllegalStateException e2) {
                        }
                        zzaL(2001);
                    }
                });
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzNX)).zza(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzNX)).zzR(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzNX)).zzd(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.zzb(new zzh(this, client) {
                    final /* synthetic */ zza zzQB;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        try {
                            com_google_android_gms_cast_internal_zze.zza("", (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, final String sessionId) {
                return client.zzb(new zzh(this, client) {
                    final /* synthetic */ zza zzQB;

                    protected void zza(zze com_google_android_gms_cast_internal_zze) throws RemoteException {
                        if (TextUtils.isEmpty(sessionId)) {
                            zzd(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            com_google_android_gms_cast_internal_zze.zza(sessionId, (com.google.android.gms.common.api.zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }
        }

        int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException;

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static final class CastOptions implements HasOptions {
        final CastDevice zzQE;
        final Listener zzQF;
        private final int zzQG;

        public static final class Builder {
            CastDevice zzQH;
            Listener zzQI;
            private int zzQJ = 0;

            public Builder(CastDevice castDevice, Listener castListener) {
                zzu.zzb((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                zzu.zzb((Object) castListener, (Object) "CastListener parameter cannot be null");
                this.zzQH = castDevice;
                this.zzQI = castListener;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.zzQJ |= 1;
                } else {
                    this.zzQJ &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.zzQE = builder.zzQH;
            this.zzQF = builder.zzQI;
            this.zzQG = builder.zzQJ;
        }

        @Deprecated
        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castDevice, castListener);
        }
    }

    public static class Listener {
        public void onActiveInputStateChanged(int activeInputState) {
        }

        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onStandbyStateChanged(int standbyState) {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    private Cast() {
    }
}
