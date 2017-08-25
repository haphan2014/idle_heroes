package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzlg;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

public final class LargeParcelTeleporter implements SafeParcelable {
    public static final Creator<LargeParcelTeleporter> CREATOR = new zzk();
    final int zzCY;
    ParcelFileDescriptor zzCZ;
    private Parcelable zzDa;
    private boolean zzDb;

    LargeParcelTeleporter(int versionCode, ParcelFileDescriptor parcelFileDescriptor) {
        this.zzCY = versionCode;
        this.zzCZ = parcelFileDescriptor;
        this.zzDa = null;
        this.zzDb = true;
    }

    public LargeParcelTeleporter(SafeParcelable teleportee) {
        this.zzCY = 1;
        this.zzCZ = null;
        this.zzDa = teleportee;
        this.zzDb = false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (this.zzCZ == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzDa.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                this.zzCZ = zzf(marshall);
            } finally {
                obtain.recycle();
            }
        }
        zzk.zza(this, dest, flags);
    }

    public <T extends SafeParcelable> T zza(Creator<T> creator) {
        if (this.zzDb) {
            if (this.zzCZ == null) {
                zzb.zzaz("File descriptor is empty, returning null.");
                return null;
            }
            Closeable dataInputStream = new DataInputStream(new AutoCloseInputStream(this.zzCZ));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                zzlg.zzb(dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.zzDa = (SafeParcelable) creator.createFromParcel(obtain);
                    this.zzDb = false;
                } finally {
                    obtain.recycle();
                }
            } catch (Throwable e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                zzlg.zzb(dataInputStream);
            }
        }
        return (SafeParcelable) this.zzDa;
    }

    protected <T> ParcelFileDescriptor zzf(final byte[] bArr) {
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            final OutputStream autoCloseOutputStream = new AutoCloseOutputStream(createPipe[1]);
            new Thread(new Runnable(this) {
                final /* synthetic */ LargeParcelTeleporter zzDe;

                public void run() {
                    Closeable dataOutputStream = new DataOutputStream(autoCloseOutputStream);
                    try {
                        dataOutputStream.writeInt(bArr.length);
                        dataOutputStream.write(bArr);
                    } catch (Throwable e) {
                        zzb.zzb("Error transporting the ad response", e);
                        zzo.zzby().zzc(e, true);
                    } finally {
                        zzlg.zzb(dataOutputStream);
                    }
                }
            }).start();
            return createPipe[0];
        } catch (Throwable e) {
            zzb.zzb("Error transporting the ad response", e);
            zzo.zzby().zzc(e, true);
            return null;
        }
    }
}
