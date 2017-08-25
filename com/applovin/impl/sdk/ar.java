package com.applovin.impl.sdk;

import android.content.Intent;
import com.applovin.adview.AppLovinConfirmationActivity;

class ar implements Runnable {
    final /* synthetic */ aq f425a;

    ar(aq aqVar) {
        this.f425a = aqVar;
    }

    public void run() {
        String str = (String) this.f425a.f422a.m253a(cd.f551P);
        String b = this.f425a.m325b();
        String str2 = (String) this.f425a.f422a.m253a(cd.f556U);
        if (C0163n.m732a(AppLovinConfirmationActivity.class, this.f425a.f424c)) {
            try {
                Intent intent = new Intent(this.f425a.f424c, AppLovinConfirmationActivity.class);
                intent.putExtra("dialog_title", str);
                intent.putExtra("dialog_body", b);
                intent.putExtra("dialog_button_text", str2);
                this.f425a.f424c.startActivity(intent);
                return;
            } catch (Throwable th) {
                this.f425a.m324a(b, th);
                return;
            }
        }
        this.f425a.m324a(b, null);
    }
}
