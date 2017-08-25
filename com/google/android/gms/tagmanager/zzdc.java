package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

class zzdc {
    private Context mContext;
    private Tracker zzIq;
    private GoogleAnalytics zzIs;

    static class zza implements Logger {
        zza() {
        }

        private static int zzja(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            zzbg.zzb("", exception);
        }

        public void error(String message) {
            zzbg.zzaz(message);
        }

        public int getLogLevel() {
            return zzja(zzbg.getLogLevel());
        }

        public void info(String message) {
            zzbg.zzaA(message);
        }

        public void setLogLevel(int logLevel) {
            zzbg.zzaC("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String message) {
            zzbg.zzaB(message);
        }

        public void warn(String message) {
            zzbg.zzaC(message);
        }
    }

    zzdc(Context context) {
        this.mContext = context;
    }

    private synchronized void zzeH(String str) {
        if (this.zzIs == null) {
            this.zzIs = GoogleAnalytics.getInstance(this.mContext);
            this.zzIs.setLogger(new zza());
            this.zzIq = this.zzIs.newTracker(str);
        }
    }

    public Tracker zzeG(String str) {
        zzeH(str);
        return this.zzIq;
    }
}
