package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzgd
public final class zzhp extends zzhh {
    private final Context mContext;
    private final String zzF;
    private String zzFP = null;
    private final String zzqr;

    public zzhp(Context context, String str, String str2) {
        this.mContext = context;
        this.zzqr = str;
        this.zzF = str2;
    }

    public zzhp(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.zzqr = str;
        this.zzF = str2;
        this.zzFP = str3;
    }

    public void onStop() {
    }

    public void zzdP() {
        HttpURLConnection httpURLConnection;
        try {
            zzb.zzaB("Pinging URL: " + this.zzF);
            httpURLConnection = (HttpURLConnection) new URL(this.zzF).openConnection();
            if (TextUtils.isEmpty(this.zzFP)) {
                zzo.zzbv().zza(this.mContext, this.zzqr, true, httpURLConnection);
            } else {
                zzo.zzbv().zza(this.mContext, this.zzqr, true, httpURLConnection, this.zzFP);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                zzb.zzaC("Received non-success response code " + responseCode + " from pinging URL: " + this.zzF);
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            zzb.zzaC("Error while parsing ping URL: " + this.zzF + ". " + e.getMessage());
        } catch (IOException e2) {
            zzb.zzaC("Error while pinging URL: " + this.zzF + ". " + e2.getMessage());
        } catch (RuntimeException e3) {
            zzb.zzaC("Error while pinging URL: " + this.zzF + ". " + e3.getMessage());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
