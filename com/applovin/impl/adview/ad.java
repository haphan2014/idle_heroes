package com.applovin.impl.adview;

import android.view.View;
import android.view.View.OnClickListener;

class ad implements OnClickListener {
    final /* synthetic */ C0143x f126a;

    ad(C0143x c0143x) {
        this.f126a = c0143x;
    }

    public void onClick(View view) {
        if (this.f126a.f245g.isClickable()) {
            this.f126a.f245g.performClick();
        }
    }
}
