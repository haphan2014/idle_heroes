package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class ao extends C0122u {
    private float f160c = BitmapDescriptorFactory.HUE_ORANGE;
    private float f161d = 2.0f;
    private float f162e = 8.0f;
    private float f163f = 2.0f;
    private float f164g = TextTrackStyle.DEFAULT_FONT_SCALE;

    public ao(AppLovinSdk appLovinSdk, Context context) {
        super(appLovinSdk, context);
    }

    protected float m151a() {
        return this.f160c * this.f164g;
    }

    public void m152a(float f) {
        this.f164g = f;
    }

    public void mo547a(int i) {
        m152a(((float) i) / this.f160c);
    }

    protected float m154b() {
        return this.f162e * this.f164g;
    }

    protected float m155c() {
        return this.f163f * this.f164g;
    }

    protected float m156d() {
        return m151a() / 2.0f;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float d = m156d();
        Paint paint = new Paint(1);
        paint.setARGB(80, 0, 0, 0);
        canvas.drawCircle(d, d, d, paint);
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        paint2.setStyle(Style.STROKE);
        paint2.setStrokeWidth(m155c());
        float b = m154b();
        float a = m151a() - b;
        canvas.drawLine(b, b, a, a, paint2);
        canvas.drawLine(b, a, a, b, paint2);
    }
}
