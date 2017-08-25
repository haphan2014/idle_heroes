package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final zzm zzSt = new zzm(this, null) {
        final /* synthetic */ RemoteMediaPlayer zzSz;

        protected void onMetadataUpdated() {
            this.zzSz.onMetadataUpdated();
        }

        protected void onPreloadStatusUpdated() {
            this.zzSz.onPreloadStatusUpdated();
        }

        protected void onQueueStatusUpdated() {
            this.zzSz.onQueueStatusUpdated();
        }

        protected void onStatusUpdated() {
            this.zzSz.onStatusUpdated();
        }
    };
    private final zza zzSu = new zza(this);
    private OnPreloadStatusUpdatedListener zzSv;
    private OnQueueStatusUpdatedListener zzSw;
    private OnMetadataUpdatedListener zzSx;
    private OnStatusUpdatedListener zzSy;
    private final Object zzqt = new Object();

    private static abstract class zzb extends com.google.android.gms.cast.internal.zzb<MediaChannelResult> {
        zzo zzTa = new C04591(this);

        class C04591 implements zzo {
            final /* synthetic */ zzb zzTb;

            C04591(zzb com_google_android_gms_cast_RemoteMediaPlayer_zzb) {
                this.zzTb = com_google_android_gms_cast_RemoteMediaPlayer_zzb;
            }

            public void zza(long j, int i, Object obj) {
                this.zzTb.setResult(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
            }

            public void zzy(long j) {
                this.zzTb.setResult(this.zzTb.zzn(new Status(2103)));
            }
        }

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzn(x0);
        }

        public MediaChannelResult zzn(final Status status) {
            return new MediaChannelResult(this) {
                final /* synthetic */ zzb zzTb;

                public JSONObject getCustomData() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    private class zza implements zzn {
        private GoogleApiClient zzSW;
        private long zzSX = 0;
        final /* synthetic */ RemoteMediaPlayer zzSz;

        private final class zza implements ResultCallback<Status> {
            private final long zzSY;
            final /* synthetic */ zza zzSZ;

            zza(zza com_google_android_gms_cast_RemoteMediaPlayer_zza, long j) {
                this.zzSZ = com_google_android_gms_cast_RemoteMediaPlayer_zza;
                this.zzSY = j;
            }

            public /* synthetic */ void onResult(Result x0) {
                zzm((Status) x0);
            }

            public void zzm(Status status) {
                if (!status.isSuccess()) {
                    this.zzSZ.zzSz.zzSt.zzb(this.zzSY, status.getStatusCode());
                }
            }
        }

        public zza(RemoteMediaPlayer remoteMediaPlayer) {
            this.zzSz = remoteMediaPlayer;
        }

        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzSW == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzSW, str, str2).setResultCallback(new zza(this, j));
        }

        public void zzb(GoogleApiClient googleApiClient) {
            this.zzSW = googleApiClient;
        }

        public long zzlu() {
            long j = this.zzSX + 1;
            this.zzSX = j;
            return j;
        }
    }

    private static final class zzc implements MediaChannelResult {
        private final Status zzOt;
        private final JSONObject zzRJ;

        zzc(Status status, JSONObject jSONObject) {
            this.zzOt = status;
            this.zzRJ = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.zzRJ;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    public RemoteMediaPlayer() {
        this.zzSt.zza(this.zzSu);
    }

    private void onMetadataUpdated() {
        if (this.zzSx != null) {
            this.zzSx.onMetadataUpdated();
        }
    }

    private void onPreloadStatusUpdated() {
        if (this.zzSv != null) {
            this.zzSv.onPreloadStatusUpdated();
        }
    }

    private void onQueueStatusUpdated() {
        if (this.zzSw != null) {
            this.zzSw.onQueueStatusUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.zzSy != null) {
            this.zzSy.onStatusUpdated();
        }
    }

    private int zzaH(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        for (int i2 = 0; i2 < mediaStatus.getQueueItemCount(); i2++) {
            if (mediaStatus.getQueueItem(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zzqt) {
            approximateStreamPosition = this.zzSt.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zzqt) {
            mediaInfo = this.zzSt.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zzqt) {
            mediaStatus = this.zzSt.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzSt.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zzqt) {
            streamDuration = this.zzSt.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, customData);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, long[] activeTrackIds, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z = autoplay;
        final long j = playPosition;
        final long[] jArr = activeTrackIds;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(googleApiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, mediaInfo2, z, j, jArr, jSONObject);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.zzSt.zzbB(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(apiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, customData);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(apiClient);
                    try {
                        this.zzSz.zzSt.zzc(this.zzTa, customData);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueAppendItem(GoogleApiClient apiClient, MediaQueueItem item, JSONObject customData) throws IllegalArgumentException {
        return queueInsertItems(apiClient, new MediaQueueItem[]{item}, 0, customData);
    }

    public PendingResult<MediaChannelResult> queueInsertItems(GoogleApiClient apiClient, MediaQueueItem[] itemsToInsert, int insertBeforeItemId, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem[] mediaQueueItemArr = itemsToInsert;
        final int i = insertBeforeItemId;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(googleApiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, mediaQueueItemArr, i, jSONObject);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient apiClient, int itemId, JSONObject customData) {
        final int i = itemId;
        final GoogleApiClient googleApiClient = apiClient;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    if (this.zzSz.zzaH(i) == -1) {
                        setResult(zzn(new Status(0)));
                        return;
                    }
                    this.zzSz.zzSu.zzb(googleApiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, i, null, 0, null, jSONObject);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient apiClient, MediaQueueItem[] items, int startIndex, int repeatMode, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem[] mediaQueueItemArr = items;
        final int i = startIndex;
        final int i2 = repeatMode;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(googleApiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, mediaQueueItemArr, i, i2, jSONObject);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(GoogleApiClient apiClient, int itemId, int newIndex, JSONObject customData) {
        final int i = itemId;
        final int i2 = newIndex;
        final GoogleApiClient googleApiClient = apiClient;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                int i = 0;
                synchronized (this.zzSz.zzqt) {
                    int zza = this.zzSz.zzaH(i);
                    if (zza == -1) {
                        setResult(zzn(new Status(0)));
                    } else if (i2 < 0) {
                        setResult(zzn(new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", new Object[]{Integer.valueOf(i2)}))));
                    } else if (zza == i2) {
                        setResult(zzn(new Status(0)));
                    } else {
                        MediaQueueItem queueItem = this.zzSz.getMediaStatus().getQueueItem(i2 > zza ? i2 + 1 : i2);
                        if (queueItem != null) {
                            i = queueItem.getItemId();
                        }
                        this.zzSz.zzSu.zzb(googleApiClient);
                        try {
                            this.zzSz.zzSt.zza(this.zzTa, new int[]{i}, i, jSONObject);
                        } catch (IOException e) {
                            setResult(zzn(new Status(2100)));
                        } finally {
                            this.zzSz.zzSu.zzb(null);
                        }
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueNext(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(apiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, 0, null, 1, null, customData);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queuePrev(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(apiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, 0, null, -1, null, customData);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(GoogleApiClient apiClient, int itemId, JSONObject customData) {
        final int i = itemId;
        final GoogleApiClient googleApiClient = apiClient;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    if (this.zzSz.zzaH(i) == -1) {
                        setResult(zzn(new Status(0)));
                        return;
                    }
                    this.zzSz.zzSu.zzb(googleApiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, new int[]{i}, jSONObject);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(GoogleApiClient apiClient, int[] itemIdsToRemove, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final int[] iArr = itemIdsToRemove;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(googleApiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, iArr, jSONObject);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueReorderItems(GoogleApiClient apiClient, int[] itemIdsToReorder, int insertBeforeItemId, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final int[] iArr = itemIdsToReorder;
        final int i = insertBeforeItemId;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(googleApiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, iArr, i, jSONObject);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(GoogleApiClient apiClient, int repeatMode, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final int i = repeatMode;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(googleApiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, 0, null, 0, Integer.valueOf(i), jSONObject);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(GoogleApiClient apiClient, MediaQueueItem[] itemsToUpdate, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem[] mediaQueueItemArr = itemsToUpdate;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(googleApiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, 0, mediaQueueItemArr, 0, null, jSONObject);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(apiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final long j = position;
        final int i = resumeState;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(googleApiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, j, i, jSONObject);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient apiClient, final long[] trackIds) {
        if (trackIds != null) {
            return apiClient.zzb(new zzb(this, apiClient) {
                final /* synthetic */ RemoteMediaPlayer zzSz;

                protected void zza(zze com_google_android_gms_cast_internal_zze) {
                    synchronized (this.zzSz.zzqt) {
                        this.zzSz.zzSu.zzb(apiClient);
                        try {
                            this.zzSz.zzSt.zza(this.zzTa, trackIds);
                        } catch (IOException e) {
                            setResult(zzn(new Status(2100)));
                        } finally {
                            this.zzSz.zzSu.zzb(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.zzSx = listener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener listener) {
        this.zzSv = listener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener listener) {
        this.zzSw = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.zzSy = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final boolean z = muteState;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(googleApiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, z, jSONObject);
                        this.zzSz.zzSu.zzb(null);
                    } catch (IllegalStateException e) {
                        try {
                            setResult(zzn(new Status(2100)));
                        } finally {
                            this.zzSz.zzSu.zzb(null);
                        }
                    } catch (IOException e2) {
                        setResult(zzn(new Status(2100)));
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (Double.isInfinite(volume) || Double.isNaN(volume)) {
            throw new IllegalArgumentException("Volume cannot be " + volume);
        }
        final GoogleApiClient googleApiClient = apiClient;
        final double d = volume;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(googleApiClient);
                    try {
                        this.zzSz.zzSt.zza(this.zzTa, d, jSONObject);
                        this.zzSz.zzSu.zzb(null);
                    } catch (IllegalStateException e) {
                        try {
                            setResult(zzn(new Status(2100)));
                        } finally {
                            this.zzSz.zzSu.zzb(null);
                        }
                    } catch (IllegalArgumentException e2) {
                        setResult(zzn(new Status(2100)));
                    } catch (IOException e3) {
                        setResult(zzn(new Status(2100)));
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient apiClient, final TextTrackStyle trackStyle) {
        if (trackStyle != null) {
            return apiClient.zzb(new zzb(this, apiClient) {
                final /* synthetic */ RemoteMediaPlayer zzSz;

                protected void zza(zze com_google_android_gms_cast_internal_zze) {
                    synchronized (this.zzSz.zzqt) {
                        this.zzSz.zzSu.zzb(apiClient);
                        try {
                            this.zzSz.zzSt.zza(this.zzTa, trackStyle);
                        } catch (IOException e) {
                            setResult(zzn(new Status(2100)));
                        } finally {
                            this.zzSz.zzSu.zzb(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzSz;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzSz.zzqt) {
                    this.zzSz.zzSu.zzb(apiClient);
                    try {
                        this.zzSz.zzSt.zzb(this.zzTa, customData);
                    } catch (IOException e) {
                        setResult(zzn(new Status(2100)));
                    } finally {
                        this.zzSz.zzSu.zzb(null);
                    }
                }
            }
        });
    }
}
