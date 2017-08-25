package com.vungle.publisher;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class tb extends RelativeLayout {
    private ImageView f3248a;

    @Singleton
    /* compiled from: vungle */
    public static class C1879a {
        @Inject
        public Context f3241a;
        @Inject
        public nf f3242b;
        @Inject
        public agj f3243c;

        @Inject
        C1879a() {
        }
    }

    /* compiled from: vungle */
    public enum C1880b {
        visible,
        invisible,
        gone
    }

    private tb(Context context) {
        super(context);
    }

    public final void setCloseVisibility(C1880b visibility) {
        switch (visibility) {
            case visible:
                this.f3248a.setVisibility(0);
                setVisibility(0);
                return;
            case invisible:
                this.f3248a.setVisibility(4);
                setVisibility(0);
                return;
            case gone:
                setVisibility(8);
                return;
            default:
                return;
        }
    }
}
