package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

public final class zzn extends OutputStream {
    private volatile zzj zzaTY;
    private final OutputStream zzaUa;

    class C12151 implements zzr {
        final /* synthetic */ zzn zzaUb;

        C12151(zzn com_google_android_gms_wearable_internal_zzn) {
            this.zzaUb = com_google_android_gms_wearable_internal_zzn;
        }

        public void zzb(zzj com_google_android_gms_wearable_internal_zzj) {
            this.zzaUb.zzc(com_google_android_gms_wearable_internal_zzj);
        }
    }

    public zzn(OutputStream outputStream) {
        this.zzaUa = (OutputStream) zzu.zzu(outputStream);
    }

    private IOException zza(IOException iOException) {
        zzj com_google_android_gms_wearable_internal_zzj = this.zzaTY;
        if (com_google_android_gms_wearable_internal_zzj == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new ChannelIOException("Channel closed unexpectedly before stream was finished", com_google_android_gms_wearable_internal_zzj.zzaTN, com_google_android_gms_wearable_internal_zzj.zzaTO);
    }

    public void close() throws IOException {
        try {
            this.zzaUa.close();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void flush() throws IOException {
        try {
            this.zzaUa.flush();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(int i) throws IOException {
        try {
            this.zzaUa.write(i);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] buffer) throws IOException {
        try {
            this.zzaUa.write(buffer);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] buffer, int offset, int count) throws IOException {
        try {
            this.zzaUa.write(buffer, offset, count);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    zzr zzBb() {
        return new C12151(this);
    }

    void zzc(zzj com_google_android_gms_wearable_internal_zzj) {
        this.zzaTY = com_google_android_gms_wearable_internal_zzj;
    }
}
