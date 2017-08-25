package com.applovin.impl.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class au implements OnClickListener {
    final /* synthetic */ at f435a;

    au(at atVar) {
        this.f435a = atVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f435a.f434a.f433h.schedule(new av(this), 200);
    }
}
