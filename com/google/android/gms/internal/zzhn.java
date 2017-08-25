package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Map;

@zzgd
public class zzhn {
    private final Context mContext;
    private int mState;
    private String zzGo;
    private float zzGp;
    private float zzGq;
    private float zzGr;
    private final float zzyV;

    class C09482 implements OnClickListener {
        final /* synthetic */ zzhn zzGt;

        C09482(zzhn com_google_android_gms_internal_zzhn) {
            this.zzGt = com_google_android_gms_internal_zzhn;
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    public zzhn(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.zzyV = context.getResources().getDisplayMetrics().density;
    }

    public zzhn(Context context, String str) {
        this(context);
        this.zzGo = str;
    }

    private void showDialog() {
        if (this.mContext instanceof Activity) {
            Object obj;
            if (TextUtils.isEmpty(this.zzGo)) {
                obj = "No debug information";
            } else {
                Uri build = new Builder().encodedQuery(this.zzGo).build();
                StringBuilder stringBuilder = new StringBuilder();
                Map zzd = zzo.zzbv().zzd(build);
                for (String str : zzd.keySet()) {
                    stringBuilder.append(str).append(" = ").append((String) zzd.get(str)).append("\n\n");
                }
                obj = stringBuilder.toString().trim();
                if (TextUtils.isEmpty(obj)) {
                    obj = "No debug information";
                }
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
            builder.setMessage(obj);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new OnClickListener(this) {
                final /* synthetic */ zzhn zzGt;

                public void onClick(DialogInterface dialog, int which) {
                    this.zzGt.mContext.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", obj), "Share via"));
                }
            });
            builder.setNegativeButton("Close", new C09482(this));
            builder.create().show();
            return;
        }
        zzb.zzaA("Can not create dialog without Activity Context");
    }

    void zza(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.zzGp = f;
            this.zzGq = f2;
            this.zzGr = f2;
        } else if (this.mState == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.zzGq) {
                    this.zzGq = f2;
                } else if (f2 < this.zzGr) {
                    this.zzGr = f2;
                }
                if (this.zzGq - this.zzGr > BitmapDescriptorFactory.HUE_ORANGE * this.zzyV) {
                    this.mState = -1;
                    return;
                }
                if (this.mState == 0 || this.mState == 2) {
                    if (f - this.zzGp >= 50.0f * this.zzyV) {
                        this.zzGp = f;
                        this.mState++;
                    }
                } else if ((this.mState == 1 || this.mState == 3) && f - this.zzGp <= -50.0f * this.zzyV) {
                    this.zzGp = f;
                    this.mState++;
                }
                if (this.mState == 1 || this.mState == 3) {
                    if (f > this.zzGp) {
                        this.zzGp = f;
                    }
                } else if (this.mState == 2 && f < this.zzGp) {
                    this.zzGp = f;
                }
            } else if (i == 1 && this.mState == 4) {
                showDialog();
            }
        }
    }

    public void zzaw(String str) {
        this.zzGo = str;
    }

    public void zzd(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
