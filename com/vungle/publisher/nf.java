package com.vungle.publisher;

import android.content.Context;
import android.util.TypedValue;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class nf {
    @Inject
    public Context f2629a;

    @Inject
    nf() {
    }

    public final float m2195a(int i) {
        return TypedValue.applyDimension(1, (float) i, this.f2629a.getResources().getDisplayMetrics());
    }
}
