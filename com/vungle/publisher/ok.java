package com.vungle.publisher;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.view.View.MeasureSpec;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ok extends ob {
    private ShapeDrawable f2758a;
    private int f2759b;
    private int f2760c;
    private int f2761d;
    private int f2762e;

    @Singleton
    /* compiled from: vungle */
    public static class C1846a {
        @Inject
        Context f2756a;
        @Inject
        nf f2757b;

        @Inject
        C1846a() {
        }
    }

    private ok(Context context) {
        super(context);
        this.f2758a = new ShapeDrawable();
        this.f2759b = -1;
        this.f2758a.getPaint().setColor(-13659954);
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2758a.draw(canvas);
    }

    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.f2759b = MeasureSpec.getSize(widthMeasureSpec);
    }

    private void setProgressBarWidth(float percent) {
        this.f2758a.setBounds(0, 0, (int) (((float) this.f2759b) * percent), this.f2761d);
    }

    public final void setMaxTimeMillis(int maxTimeMillis) {
        this.f2760c = maxTimeMillis;
    }

    public final void setCurrentTimeMillis(int currentTimeMillis) {
        setProgressBarWidth(((float) currentTimeMillis) / ((float) this.f2760c));
        invalidate();
    }

    public final int getProgressBarHeight() {
        return this.f2761d;
    }

    public final int getId() {
        return this.f2762e;
    }
}
