package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0346R;

public final class zzy extends Button {
    public zzy(Context context) {
        this(context, null);
    }

    public zzy(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private void zza(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    private int zzb(int i, int i2, int i3) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    private void zzb(Resources resources, int i, int i2) {
        int zzb;
        switch (i) {
            case 0:
            case 1:
                zzb = zzb(i2, C0346R.drawable.common_signin_btn_text_dark, C0346R.drawable.common_signin_btn_text_light);
                break;
            case 2:
                zzb = zzb(i2, C0346R.drawable.common_signin_btn_icon_dark, C0346R.drawable.common_signin_btn_icon_light);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        if (zzb == -1) {
            throw new IllegalStateException("Could not find background resource!");
        }
        setBackgroundDrawable(resources.getDrawable(zzb));
    }

    private void zzc(Resources resources, int i, int i2) {
        setTextColor(resources.getColorStateList(zzb(i2, C0346R.color.common_signin_btn_text_dark, C0346R.color.common_signin_btn_text_light)));
        switch (i) {
            case 0:
                setText(resources.getString(C0346R.string.common_signin_button_text));
                return;
            case 1:
                setText(resources.getString(C0346R.string.common_signin_button_text_long));
                return;
            case 2:
                setText(null);
                return;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    public void zza(Resources resources, int i, int i2) {
        boolean z = i >= 0 && i < 3;
        zzu.zza(z, "Unknown button size %d", Integer.valueOf(i));
        z = i2 >= 0 && i2 < 2;
        zzu.zza(z, "Unknown color scheme %s", Integer.valueOf(i2));
        zza(resources);
        zzb(resources, i, i2);
        zzc(resources, i, i2);
    }
}
