package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzfg;
import com.google.android.gms.internal.zzfl;

public class InAppPurchaseActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
    public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
    private zzfg zzHM;

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (this.zzHM != null) {
                this.zzHM.onActivityResult(requestCode, resultCode, data);
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zzHM = zzfl.zze(this);
        if (this.zzHM == null) {
            zzb.zzaC("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.zzHM.onCreate();
        } catch (Throwable e) {
            zzb.zzd("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.zzHM != null) {
                this.zzHM.onDestroy();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
