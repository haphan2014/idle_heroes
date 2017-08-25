package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class C0140s extends View {
    private final int f208A;
    protected Paint f209a;
    protected Paint f210b;
    private Paint f211c;
    private Paint f212d;
    private RectF f213e;
    private float f214f;
    private int f215g;
    private int f216h;
    private int f217i;
    private int f218j;
    private int f219k;
    private float f220l;
    private int f221m;
    private String f222n;
    private String f223o;
    private float f224p;
    private String f225q;
    private float f226r;
    private final float f227s;
    private final int f228t;
    private final int f229u;
    private final int f230v;
    private final int f231w;
    private final int f232x;
    private final float f233y;
    private final float f234z;

    public C0140s(Context context) {
        this(context, null);
    }

    public C0140s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0140s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f213e = new RectF();
        this.f217i = 0;
        this.f222n = "";
        this.f223o = "";
        this.f225q = "";
        this.f228t = Color.rgb(66, 145, 241);
        this.f229u = Color.rgb(66, 145, 241);
        this.f230v = Color.rgb(66, 145, 241);
        this.f231w = 0;
        this.f232x = 100;
        this.f233y = C0141t.m209b(getResources(), 14.0f);
        this.f208A = (int) C0141t.m208a(getResources(), 100.0f);
        this.f227s = C0141t.m208a(getResources(), 4.0f);
        this.f234z = C0141t.m209b(getResources(), 18.0f);
        m191b();
        m188a();
    }

    private int m186e(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.f208A;
        return mode == ExploreByTouchHelper.INVALID_ID ? Math.min(i2, size) : i2;
    }

    private float m187o() {
        return (((float) m196d()) / ((float) this.f218j)) * 360.0f;
    }

    protected void m188a() {
        this.f209a = new TextPaint();
        this.f209a.setColor(this.f215g);
        this.f209a.setTextSize(this.f214f);
        this.f209a.setAntiAlias(true);
        this.f210b = new TextPaint();
        this.f210b.setColor(this.f216h);
        this.f210b.setTextSize(this.f224p);
        this.f210b.setAntiAlias(true);
        this.f211c = new Paint();
        this.f211c.setColor(this.f219k);
        this.f211c.setStyle(Style.STROKE);
        this.f211c.setAntiAlias(true);
        this.f211c.setStrokeWidth(this.f220l);
        this.f212d = new Paint();
        this.f212d.setColor(this.f221m);
        this.f212d.setAntiAlias(true);
    }

    public void m189a(float f) {
        this.f220l = f;
        invalidate();
    }

    public void m190a(int i) {
        this.f217i = i;
        if (this.f217i > m198e()) {
            this.f217i %= m198e();
        }
        invalidate();
    }

    protected void m191b() {
        this.f219k = this.f228t;
        this.f215g = this.f229u;
        this.f214f = this.f233y;
        m193b(100);
        m190a(0);
        this.f220l = this.f227s;
        this.f221m = 0;
        this.f224p = this.f234z;
        this.f216h = this.f230v;
    }

    public void m192b(float f) {
        this.f214f = f;
        invalidate();
    }

    public void m193b(int i) {
        if (i > 0) {
            this.f218j = i;
            invalidate();
        }
    }

    public float m194c() {
        return this.f220l;
    }

    public void m195c(int i) {
        this.f215g = i;
        invalidate();
    }

    public int m196d() {
        return this.f217i;
    }

    public void m197d(int i) {
        this.f219k = i;
        invalidate();
    }

    public int m198e() {
        return this.f218j;
    }

    public float m199f() {
        return this.f214f;
    }

    public int m200g() {
        return this.f215g;
    }

    public int m201h() {
        return this.f219k;
    }

    public String m202i() {
        return this.f223o;
    }

    public void invalidate() {
        m188a();
        super.invalidate();
    }

    public String m203j() {
        return this.f222n;
    }

    public int m204k() {
        return this.f221m;
    }

    public String m205l() {
        return this.f225q;
    }

    public float m206m() {
        return this.f224p;
    }

    public int m207n() {
        return this.f216h;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f220l;
        this.f213e.set(f, f, ((float) getWidth()) - f, ((float) getHeight()) - f);
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, ((((float) getWidth()) - this.f220l) + this.f220l) / 2.0f, this.f212d);
        canvas.drawArc(this.f213e, BitmapDescriptorFactory.HUE_VIOLET, -m187o(), false, this.f211c);
        String str = this.f222n + this.f217i + this.f223o;
        if (!TextUtils.isEmpty(str)) {
            canvas.drawText(str, (((float) getWidth()) - this.f209a.measureText(str)) / 2.0f, (((float) getWidth()) - (this.f209a.descent() + this.f209a.ascent())) / 2.0f, this.f209a);
        }
        if (!TextUtils.isEmpty(m205l())) {
            this.f210b.setTextSize(this.f224p);
            canvas.drawText(m205l(), (((float) getWidth()) - this.f210b.measureText(m205l())) / 2.0f, (((float) getHeight()) - this.f226r) - ((this.f209a.descent() + this.f209a.ascent()) / 2.0f), this.f210b);
        }
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(m186e(i), m186e(i2));
        this.f226r = (float) (getHeight() - ((getHeight() * 3) / 4));
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f215g = bundle.getInt("text_color");
            this.f214f = bundle.getFloat("text_size");
            this.f224p = bundle.getFloat("inner_bottom_text_size");
            this.f225q = bundle.getString("inner_bottom_text");
            this.f216h = bundle.getInt("inner_bottom_text_color");
            this.f219k = bundle.getInt("finished_stroke_color");
            this.f220l = bundle.getFloat("finished_stroke_width");
            this.f221m = bundle.getInt("inner_background_color");
            m188a();
            m193b(bundle.getInt("max"));
            m190a(bundle.getInt("progress"));
            this.f222n = bundle.getString("prefix");
            this.f223o = bundle.getString("suffix");
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", m200g());
        bundle.putFloat("text_size", m199f());
        bundle.putFloat("inner_bottom_text_size", m206m());
        bundle.putFloat("inner_bottom_text_color", (float) m207n());
        bundle.putString("inner_bottom_text", m205l());
        bundle.putInt("inner_bottom_text_color", m207n());
        bundle.putInt("finished_stroke_color", m201h());
        bundle.putInt("max", m198e());
        bundle.putInt("progress", m196d());
        bundle.putString("suffix", m202i());
        bundle.putString("prefix", m203j());
        bundle.putFloat("finished_stroke_width", m194c());
        bundle.putInt("inner_background_color", m204k());
        return bundle;
    }
}
