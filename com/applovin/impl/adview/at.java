package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.view.ViewCompat;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class at extends C0122u {
    private float f179c = BitmapDescriptorFactory.HUE_ORANGE;
    private float f180d = 2.0f;
    private float f181e = 10.0f;
    private float f182f = 3.0f;
    private float f183g = TextTrackStyle.DEFAULT_FONT_SCALE;

    public at(AppLovinSdk appLovinSdk, Context context) {
        super(appLovinSdk, context);
    }

    protected float m170a() {
        return this.f179c * this.f183g;
    }

    public void m171a(float f) {
        this.f183g = f;
    }

    public void mo547a(int i) {
        m171a(((float) i) / this.f179c);
    }

    protected float m173b() {
        return this.f181e * this.f183g;
    }

    protected float m174c() {
        return this.f182f * this.f183g;
    }

    protected float m175d() {
        return m170a() / 2.0f;
    }

    protected float m176e() {
        return this.f180d * this.f183g;
    }

    protected float m177f() {
        return m175d() - m176e();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float d = m175d();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(d, d, d, paint);
        Paint paint2 = new Paint(1);
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawCircle(d, d, m177f(), paint2);
        Paint paint3 = new Paint(paint);
        paint3.setStyle(Style.STROKE);
        paint3.setStrokeWidth(m174c());
        float b = m173b();
        float a = m170a() - b;
        canvas.drawLine(b, b, a, a, paint3);
        canvas.drawLine(b, a, a, b, paint3);
    }
}
