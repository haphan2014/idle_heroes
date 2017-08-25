package com.vungle.publisher;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vungle.publisher.qx.C1869a;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class oh extends LinearLayout implements OnClickListener {
    private qh f2748a;
    private boolean f2749b = false;
    private TextView f2750c;

    @Singleton
    /* compiled from: vungle */
    public static class C1845a {
        @Inject
        agj f2746a;
        @Inject
        qh f2747b;

        @Inject
        C1845a() {
        }

        public final oh m2261a(Context context, boolean z) {
            oh ohVar = new oh(context);
            ohVar.setGravity(16);
            View obVar = new ob(context);
            this.f2746a.m1229a(obVar, C1869a.privacy);
            TextView textView = new TextView(context);
            textView.setText("privacy");
            textView.setTextSize(16.0f);
            textView.setTextColor(-1);
            textView.setVisibility(8);
            textView.setPadding(10, 0, 10, 0);
            if (z) {
                ohVar.addView(obVar);
                ohVar.addView(textView);
            } else {
                ohVar.addView(textView);
                ohVar.addView(obVar);
            }
            ohVar.f2748a = this.f2747b;
            ohVar.f2750c = textView;
            ohVar.setVisibility(8);
            return ohVar;
        }
    }

    public oh(Context context) {
        super(context);
        setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (this.f2749b) {
            this.f2748a.m2361a(new av());
            return;
        }
        this.f2749b = true;
        setBackgroundColor(Color.parseColor("#000000"));
        this.f2750c.setVisibility(0);
    }
}
