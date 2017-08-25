package com.applovin.impl.adview;

import android.app.Activity;

class aj implements Runnable {
    final /* synthetic */ Activity f147a;
    final /* synthetic */ boolean f148b;
    final /* synthetic */ boolean f149c;
    final /* synthetic */ ah f150d;

    aj(ah ahVar, Activity activity, boolean z, boolean z2) {
        this.f150d = ahVar;
        this.f147a = activity;
        this.f148b = z;
        this.f149c = z2;
    }

    public void run() {
        this.f150d.m128a(this.f147a, this.f148b, this.f149c);
    }
}
