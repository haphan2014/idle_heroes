package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;

public final class zzm extends InputStream {
    private final InputStream zzaTX;
    private volatile zzj zzaTY;

    class C12141 implements zzr {
        final /* synthetic */ zzm zzaTZ;

        C12141(zzm com_google_android_gms_wearable_internal_zzm) {
            this.zzaTZ = com_google_android_gms_wearable_internal_zzm;
        }

        public void zzb(zzj com_google_android_gms_wearable_internal_zzj) {
            this.zzaTZ.zza(com_google_android_gms_wearable_internal_zzj);
        }
    }

    public zzm(InputStream inputStream) {
        this.zzaTX = (InputStream) zzu.zzu(inputStream);
    }

    private int zzjX(int i) throws ChannelIOException {
        if (i == -1) {
            zzj com_google_android_gms_wearable_internal_zzj = this.zzaTY;
            if (com_google_android_gms_wearable_internal_zzj != null) {
                throw new ChannelIOException("Channel closed unexpectedly before stream was finished", com_google_android_gms_wearable_internal_zzj.zzaTN, com_google_android_gms_wearable_internal_zzj.zzaTO);
            }
        }
        return i;
    }

    public int available() throws IOException {
        return this.zzaTX.available();
    }

    public void close() throws IOException {
        this.zzaTX.close();
    }

    public void mark(int readlimit) {
        this.zzaTX.mark(readlimit);
    }

    public boolean markSupported() {
        return this.zzaTX.markSupported();
    }

    public int read() throws IOException {
        return zzjX(this.zzaTX.read());
    }

    public int read(byte[] buffer) throws IOException {
        return zzjX(this.zzaTX.read(buffer));
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        return zzjX(this.zzaTX.read(buffer, byteOffset, byteCount));
    }

    public void reset() throws IOException {
        this.zzaTX.reset();
    }

    public long skip(long byteCount) throws IOException {
        return this.zzaTX.skip(byteCount);
    }

    zzr zzBb() {
        return new C12141(this);
    }

    void zza(zzj com_google_android_gms_wearable_internal_zzj) {
        this.zzaTY = (zzj) zzu.zzu(com_google_android_gms_wearable_internal_zzj);
    }
}
