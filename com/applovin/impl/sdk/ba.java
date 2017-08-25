package com.applovin.impl.sdk;

import android.app.AlertDialog.Builder;

class ba implements Runnable {
    final /* synthetic */ ay f449a;

    ba(ay ayVar) {
        this.f449a = ayVar;
    }

    public void run() {
        Builder builder = new Builder(this.f449a.f440b);
        builder.setTitle((CharSequence) this.f449a.f439a.m253a(cd.f558W));
        builder.setMessage((CharSequence) this.f449a.f439a.m253a(cd.f559X));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) this.f449a.f439a.m253a(cd.f561Z), new bb(this));
        builder.setNegativeButton((CharSequence) this.f449a.f439a.m253a(cd.f560Y), new bc(this));
        this.f449a.f441c = builder.show();
    }
}
