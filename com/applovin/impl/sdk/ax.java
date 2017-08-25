package com.applovin.impl.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ax implements OnClickListener {
    final /* synthetic */ at f438a;

    ax(at atVar) {
        this.f438a = atVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f438a.f434a.f427b.m310a(this.f438a.f434a.f432g);
    }
}
