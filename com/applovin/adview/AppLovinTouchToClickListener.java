package com.applovin.adview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public class AppLovinTouchToClickListener implements OnTouchListener {
    private long f44a;
    private float f45b;
    private float f46c;
    private Context f47d;
    private OnClickListener f48e;

    public AppLovinTouchToClickListener(Context context, OnClickListener onClickListener) {
        this.f47d = context;
        this.f48e = onClickListener;
    }

    private float m94a(float f) {
        return f / this.f47d.getResources().getDisplayMetrics().density;
    }

    private float m95a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return m94a((float) Math.sqrt((double) ((f5 * f5) + (f6 * f6))));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f44a = System.currentTimeMillis();
                this.f45b = motionEvent.getX();
                this.f46c = motionEvent.getY();
                break;
            case 1:
                if (System.currentTimeMillis() - this.f44a < 1000 && m95a(this.f45b, this.f46c, motionEvent.getX(), motionEvent.getY()) < 10.0f) {
                    this.f48e.onClick(view);
                    break;
                }
        }
        return true;
    }
}
