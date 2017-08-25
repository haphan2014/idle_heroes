package com.applovin.impl.adview;

import android.util.Log;
import android.view.View;
import android.view.View.OnLongClickListener;

class C0138q implements OnLongClickListener {
    final /* synthetic */ C0136o f205a;

    C0138q(C0136o c0136o) {
        this.f205a = c0136o;
    }

    public boolean onLongClick(View view) {
        Log.d("AdWebView", "Received a LongClick event.");
        return true;
    }
}
