package com.applovin.impl.adview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class C0137p implements OnTouchListener {
    final /* synthetic */ C0136o f204a;

    C0137p(C0136o c0136o) {
        this.f204a = c0136o;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!view.hasFocus()) {
            view.requestFocus();
        }
        return false;
    }
}
