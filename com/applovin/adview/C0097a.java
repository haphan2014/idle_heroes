package com.applovin.adview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class C0097a implements OnClickListener {
    final /* synthetic */ AppLovinConfirmationActivity f49a;

    C0097a(AppLovinConfirmationActivity appLovinConfirmationActivity) {
        this.f49a = appLovinConfirmationActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f49a.finish();
    }
}
