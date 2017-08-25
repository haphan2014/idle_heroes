package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;

public class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzex zznG;

    private void zzaE() {
        if (this.zznG != null) {
            try {
                this.zznG.zzaE();
            } catch (Throwable e) {
                zzb.zzd("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    public void onBackPressed() {
        try {
            if (this.zznG != null) {
                this.zznG.onBackPressed();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onBackPressed to ad overlay:", e);
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zznG = zzew.zzb(this);
        if (this.zznG == null) {
            zzb.zzaC("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.zznG.onCreate(savedInstanceState);
        } catch (Throwable e) {
            zzb.zzd("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.zznG != null) {
                this.zznG.onDestroy();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.zznG != null) {
                this.zznG.onPause();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.zznG != null) {
                this.zznG.onRestart();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.zznG != null) {
                this.zznG.onResume();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        try {
            if (this.zznG != null) {
                this.zznG.onSaveInstanceState(outState);
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(outState);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.zznG != null) {
                this.zznG.onStart();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.zznG != null) {
                this.zznG.onStop();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        zzaE();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        zzaE();
    }

    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        zzaE();
    }
}
