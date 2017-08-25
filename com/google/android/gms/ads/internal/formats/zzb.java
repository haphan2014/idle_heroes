package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.internal.zzu;

class zzb extends RelativeLayout {
    private static final float[] zzve = new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private final RelativeLayout zzvf;

    public zzb(Context context, zza com_google_android_gms_ads_internal_formats_zza) {
        super(context);
        zzu.zzu(com_google_android_gms_ads_internal_formats_zza);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzve, null, null));
        shapeDrawable.getPaint().setColor(com_google_android_gms_ads_internal_formats_zza.getBackgroundColor());
        this.zzvf = new RelativeLayout(context);
        this.zzvf.setLayoutParams(layoutParams);
        zzo.zzbx().zza(this.zzvf, shapeDrawable);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        View textView = new TextView(context);
        textView.setLayoutParams(layoutParams);
        textView.setId(1195835393);
        textView.setTypeface(Typeface.DEFAULT);
        textView.setText(com_google_android_gms_ads_internal_formats_zza.getText());
        textView.setTextColor(com_google_android_gms_ads_internal_formats_zza.zzdu());
        textView.setTextSize((float) com_google_android_gms_ads_internal_formats_zza.getTextSize());
        textView.setPadding(zzk.zzcA().zzb(context, 4), 0, zzk.zzcA().zzb(context, 4), 0);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, textView.getId());
        View imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setId(1195835394);
        imageView.setImageDrawable(com_google_android_gms_ads_internal_formats_zza.getIcon());
        this.zzvf.addView(textView);
        this.zzvf.addView(imageView);
        addView(this.zzvf);
    }

    public ViewGroup zzdv() {
        return this.zzvf;
    }
}
