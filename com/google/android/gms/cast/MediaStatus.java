package com.google.android.gms.cast;

import android.util.SparseArray;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.cast.internal.zzf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_BACKWARD = 32;
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int REPEAT_MODE_REPEAT_ALL = 1;
    public static final int REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE = 3;
    public static final int REPEAT_MODE_REPEAT_OFF = 0;
    public static final int REPEAT_MODE_REPEAT_SINGLE = 2;
    private JSONObject zzRJ;
    private MediaInfo zzRK;
    private long[] zzRY;
    private int zzSa = 0;
    private long zzSb;
    private double zzSc;
    private int zzSd;
    private int zzSe;
    private long zzSf;
    private long zzSg;
    private double zzSh;
    private boolean zzSi;
    private int zzSj = 0;
    private int zzSk = 0;
    private final zza zzSl = new zza(this);

    private class zza {
        private int zzSm = 0;
        private List<MediaQueueItem> zzSn = new ArrayList();
        private SparseArray<Integer> zzSo = new SparseArray();
        final /* synthetic */ MediaStatus zzSp;

        zza(MediaStatus mediaStatus) {
            this.zzSp = mediaStatus;
        }

        private void clear() {
            this.zzSm = 0;
            this.zzSn.clear();
            this.zzSo.clear();
        }

        private void zza(MediaQueueItem[] mediaQueueItemArr) {
            this.zzSn.clear();
            this.zzSo.clear();
            for (int i = 0; i < mediaQueueItemArr.length; i++) {
                MediaQueueItem mediaQueueItem = mediaQueueItemArr[i];
                this.zzSn.add(mediaQueueItem);
                this.zzSo.put(mediaQueueItem.getItemId(), Integer.valueOf(i));
            }
        }

        private Integer zzaF(int i) {
            return (Integer) this.zzSo.get(i);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean zzg(org.json.JSONObject r11) throws org.json.JSONException {
            /*
            r10 = this;
            r3 = 3;
            r0 = 2;
            r1 = 0;
            r2 = 1;
            r4 = "repeatMode";
            r4 = r11.has(r4);
            if (r4 == 0) goto L_0x00f7;
        L_0x000c:
            r4 = r10.zzSm;
            r5 = "repeatMode";
            r6 = r11.getString(r5);
            r5 = -1;
            r7 = r6.hashCode();
            switch(r7) {
                case -1118317585: goto L_0x0073;
                case -962896020: goto L_0x0069;
                case 1645938909: goto L_0x005f;
                case 1645952171: goto L_0x0055;
                default: goto L_0x001c;
            };
        L_0x001c:
            switch(r5) {
                case 0: goto L_0x007d;
                case 1: goto L_0x007f;
                case 2: goto L_0x0020;
                case 3: goto L_0x0081;
                default: goto L_0x001f;
            };
        L_0x001f:
            r0 = r4;
        L_0x0020:
            r3 = r10.zzSm;
            if (r3 == r0) goto L_0x00f7;
        L_0x0024:
            r10.zzSm = r0;
            r0 = r2;
        L_0x0027:
            r3 = "items";
            r3 = r11.has(r3);
            if (r3 == 0) goto L_0x00f5;
        L_0x002f:
            r3 = "items";
            r4 = r11.getJSONArray(r3);
            r5 = r4.length();
            r6 = new android.util.SparseArray;
            r6.<init>();
            r3 = r1;
        L_0x003f:
            if (r3 >= r5) goto L_0x0083;
        L_0x0041:
            r7 = r4.getJSONObject(r3);
            r8 = "itemId";
            r7 = r7.getInt(r8);
            r7 = java.lang.Integer.valueOf(r7);
            r6.put(r3, r7);
            r3 = r3 + 1;
            goto L_0x003f;
        L_0x0055:
            r7 = "REPEAT_OFF";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x005d:
            r5 = r1;
            goto L_0x001c;
        L_0x005f:
            r7 = "REPEAT_ALL";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x0067:
            r5 = r2;
            goto L_0x001c;
        L_0x0069:
            r7 = "REPEAT_SINGLE";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x0071:
            r5 = r0;
            goto L_0x001c;
        L_0x0073:
            r7 = "REPEAT_ALL_AND_SHUFFLE";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x007b:
            r5 = r3;
            goto L_0x001c;
        L_0x007d:
            r0 = r1;
            goto L_0x0020;
        L_0x007f:
            r0 = r2;
            goto L_0x0020;
        L_0x0081:
            r0 = r3;
            goto L_0x0020;
        L_0x0083:
            r7 = new com.google.android.gms.cast.MediaQueueItem[r5];
            r3 = r1;
            r1 = r0;
        L_0x0087:
            if (r3 >= r5) goto L_0x00e5;
        L_0x0089:
            r0 = r6.get(r3);
            r0 = (java.lang.Integer) r0;
            r8 = r4.getJSONObject(r3);
            r9 = r0.intValue();
            r9 = r10.zzaD(r9);
            if (r9 == 0) goto L_0x00b8;
        L_0x009d:
            r8 = r9.zzg(r8);
            r1 = r1 | r8;
            r7[r3] = r9;
            r0 = r0.intValue();
            r0 = r10.zzaF(r0);
            r0 = r0.intValue();
            if (r3 == r0) goto L_0x00f3;
        L_0x00b2:
            r0 = r2;
        L_0x00b3:
            r1 = r3 + 1;
            r3 = r1;
            r1 = r0;
            goto L_0x0087;
        L_0x00b8:
            r0 = r0.intValue();
            r1 = r10.zzSp;
            r1 = r1.zzSa;
            if (r0 != r1) goto L_0x00dc;
        L_0x00c4:
            r0 = new com.google.android.gms.cast.MediaQueueItem$Builder;
            r1 = r10.zzSp;
            r1 = r1.zzRK;
            r0.<init>(r1);
            r0 = r0.build();
            r7[r3] = r0;
            r0 = r7[r3];
            r0.zzg(r8);
            r0 = r2;
            goto L_0x00b3;
        L_0x00dc:
            r0 = new com.google.android.gms.cast.MediaQueueItem;
            r0.<init>(r8);
            r7[r3] = r0;
            r0 = r2;
            goto L_0x00b3;
        L_0x00e5:
            r0 = r10.zzSn;
            r0 = r0.size();
            if (r0 == r5) goto L_0x00f1;
        L_0x00ed:
            r10.zza(r7);
        L_0x00f0:
            return r2;
        L_0x00f1:
            r2 = r1;
            goto L_0x00ed;
        L_0x00f3:
            r0 = r1;
            goto L_0x00b3;
        L_0x00f5:
            r2 = r0;
            goto L_0x00f0;
        L_0x00f7:
            r0 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaStatus.zza.zzg(org.json.JSONObject):boolean");
        }

        public int getItemCount() {
            return this.zzSn.size();
        }

        public int getRepeatMode() {
            return this.zzSm;
        }

        public MediaQueueItem zzaD(int i) {
            Integer num = (Integer) this.zzSo.get(i);
            return num == null ? null : (MediaQueueItem) this.zzSn.get(num.intValue());
        }

        public MediaQueueItem zzaE(int i) {
            return (i < 0 || i >= this.zzSn.size()) ? null : (MediaQueueItem) this.zzSn.get(i);
        }

        public List<MediaQueueItem> zzlt() {
            return Collections.unmodifiableList(this.zzSn);
        }
    }

    public MediaStatus(JSONObject json) throws JSONException {
        zza(json, 0);
    }

    private boolean zzh(int i, int i2) {
        return i == 1 && i2 == 0;
    }

    public long[] getActiveTrackIds() {
        return this.zzRY;
    }

    public int getCurrentItemId() {
        return this.zzSa;
    }

    public JSONObject getCustomData() {
        return this.zzRJ;
    }

    public int getIdleReason() {
        return this.zzSe;
    }

    public int getLoadingItemId() {
        return this.zzSj;
    }

    public MediaInfo getMediaInfo() {
        return this.zzRK;
    }

    public double getPlaybackRate() {
        return this.zzSc;
    }

    public int getPlayerState() {
        return this.zzSd;
    }

    public int getPreloadedItemId() {
        return this.zzSk;
    }

    public MediaQueueItem getQueueItem(int index) {
        return this.zzSl.zzaE(index);
    }

    public MediaQueueItem getQueueItemById(int itemId) {
        return this.zzSl.zzaD(itemId);
    }

    public int getQueueItemCount() {
        return this.zzSl.getItemCount();
    }

    public List<MediaQueueItem> getQueueItems() {
        return this.zzSl.zzlt();
    }

    public int getQueueRepeatMode() {
        return this.zzSl.getRepeatMode();
    }

    public long getStreamPosition() {
        return this.zzSf;
    }

    public double getStreamVolume() {
        return this.zzSh;
    }

    public boolean isMediaCommandSupported(long mediaCommand) {
        return (this.zzSg & mediaCommand) != 0;
    }

    public boolean isMute() {
        return this.zzSi;
    }

    public int zza(JSONObject jSONObject, int i) throws JSONException {
        int i2;
        int i3;
        double d;
        long zze;
        long[] jArr;
        int i4 = 2;
        int i5 = 1;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.zzSb) {
            this.zzSb = j;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            i3 = string.equals("IDLE") ? 1 : string.equals("PLAYING") ? 2 : string.equals("PAUSED") ? 3 : string.equals("BUFFERING") ? 4 : 0;
            if (i3 != this.zzSd) {
                this.zzSd = i3;
                i2 |= 2;
            }
            if (i3 == 1 && jSONObject.has("idleReason")) {
                string = jSONObject.getString("idleReason");
                if (!string.equals("CANCELLED")) {
                    i4 = string.equals("INTERRUPTED") ? 3 : string.equals("FINISHED") ? 1 : string.equals("ERROR") ? 4 : 0;
                }
                if (i4 != this.zzSe) {
                    this.zzSe = i4;
                    i2 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            d = jSONObject.getDouble("playbackRate");
            if (this.zzSc != d) {
                this.zzSc = d;
                i2 |= 2;
            }
        }
        if (jSONObject.has("currentTime") && (i & 2) == 0) {
            zze = zzf.zze(jSONObject.getDouble("currentTime"));
            if (zze != this.zzSf) {
                this.zzSf = zze;
                i2 |= 2;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            zze = jSONObject.getLong("supportedMediaCommands");
            if (zze != this.zzSg) {
                this.zzSg = zze;
                i2 |= 2;
            }
        }
        if (jSONObject.has("volume") && (i & 1) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("volume");
            d = jSONObject2.getDouble(AppLovinEventTypes.USER_COMPLETED_LEVEL);
            if (d != this.zzSh) {
                this.zzSh = d;
                i2 |= 2;
            }
            boolean z = jSONObject2.getBoolean("muted");
            if (z != this.zzSi) {
                this.zzSi = z;
                i2 |= 2;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (i4 = 0; i4 < length; i4++) {
                jArr2[i4] = jSONArray.getLong(i4);
            }
            if (this.zzRY != null && this.zzRY.length == length) {
                for (i4 = 0; i4 < length; i4++) {
                    if (this.zzRY[i4] != jArr2[i4]) {
                        break;
                    }
                }
                i5 = 0;
            }
            if (i5 != 0) {
                this.zzRY = jArr2;
            }
            long[] jArr3 = jArr2;
            i3 = i5;
            jArr = jArr3;
        } else if (this.zzRY != null) {
            i3 = 1;
            jArr = null;
        } else {
            jArr = null;
            i3 = 0;
        }
        if (i3 != 0) {
            this.zzRY = jArr;
            i2 |= 2;
        }
        if (jSONObject.has("customData")) {
            this.zzRJ = jSONObject.getJSONObject("customData");
            i2 |= 2;
        }
        if (jSONObject.has("media")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("media");
            this.zzRK = new MediaInfo(jSONObject3);
            i2 |= 2;
            if (jSONObject3.has("metadata")) {
                i2 |= 4;
            }
        }
        if (jSONObject.has("currentItemId")) {
            i5 = jSONObject.getInt("currentItemId");
            if (this.zzSa != i5) {
                this.zzSa = i5;
                i2 |= 2;
            }
        }
        i5 = jSONObject.optInt("preloadedItemId", 0);
        if (this.zzSk != i5) {
            this.zzSk = i5;
            i2 |= 16;
        }
        i5 = jSONObject.optInt("loadingItemId", 0);
        if (this.zzSj != i5) {
            this.zzSj = i5;
            i2 |= 2;
        }
        if (!zzh(this.zzSd, this.zzSj)) {
            return this.zzSl.zzg(jSONObject) ? i2 | 8 : i2;
        } else {
            this.zzSa = 0;
            this.zzSj = 0;
            this.zzSk = 0;
            if (this.zzSl.getItemCount() <= 0) {
                return i2;
            }
            this.zzSl.clear();
            return i2 | 8;
        }
    }

    public long zzls() {
        return this.zzSb;
    }
}
