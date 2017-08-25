package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class zzo {
    private static final String TAG = zzo.class.getSimpleName();
    private static final long zzaAQ = TimeUnit.SECONDS.toMillis(1);
    private static zzo zzaAR;
    private final Context mContext;
    private final Handler mHandler;
    private final Runnable zzaAS;
    private ArrayList<String> zzaAT;
    private ArrayList<String> zzaAU;
    private final Object zzqt;

    private class zza implements Runnable {
        final /* synthetic */ zzo zzaAV;

        private zza(zzo com_google_android_gms_location_places_internal_zzo) {
            this.zzaAV = com_google_android_gms_location_places_internal_zzo;
        }

        public void run() {
            synchronized (this.zzaAV.zzqt) {
                Intent intent = new Intent("com.google.android.location.places.METHOD_CALL");
                intent.setPackage("com.google.android.gms");
                intent.putStringArrayListExtra("PLACE_IDS", this.zzaAV.zzaAT);
                intent.putStringArrayListExtra("METHOD_NAMES", this.zzaAV.zzaAU);
                this.zzaAV.mContext.sendBroadcast(intent);
                this.zzaAV.zzaAT = null;
                this.zzaAV.zzaAU = null;
            }
        }
    }

    private zzo(Context context) {
        this((Context) zzu.zzu(context), new Handler(Looper.getMainLooper()));
    }

    zzo(Context context, Handler handler) {
        this.zzaAS = new zza();
        this.zzqt = new Object();
        this.zzaAT = null;
        this.zzaAU = null;
        this.mContext = context;
        this.mHandler = handler;
    }

    public static synchronized zzo zzax(Context context) {
        zzo com_google_android_gms_location_places_internal_zzo;
        synchronized (zzo.class) {
            zzu.zzu(context);
            if (VERSION.SDK_INT < 14) {
                com_google_android_gms_location_places_internal_zzo = null;
            } else {
                if (zzaAR == null) {
                    zzaAR = new zzo(context.getApplicationContext());
                }
                com_google_android_gms_location_places_internal_zzo = zzaAR;
            }
        }
        return com_google_android_gms_location_places_internal_zzo;
    }

    public void zzA(String str, String str2) {
        synchronized (this.zzqt) {
            if (this.zzaAT == null) {
                this.zzaAT = new ArrayList();
                this.zzaAU = new ArrayList();
                this.mHandler.postDelayed(this.zzaAS, zzaAQ);
            }
            this.zzaAT.add(str);
            this.zzaAU.add(str2);
            if (this.zzaAT.size() >= 10000) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Event buffer full, flushing");
                }
                this.zzaAS.run();
                this.mHandler.removeCallbacks(this.zzaAS);
                return;
            }
        }
    }
}
