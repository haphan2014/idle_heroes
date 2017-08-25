package com.applovin.impl.sdk;

import android.app.AlertDialog.Builder;

class at implements Runnable {
    final /* synthetic */ as f434a;

    at(as asVar) {
        this.f434a = asVar;
    }

    public void run() {
        Builder builder = new Builder(this.f434a.f428c);
        builder.setTitle((CharSequence) this.f434a.f426a.m253a(cd.f547L));
        builder.setMessage((CharSequence) this.f434a.f426a.m253a(cd.f548M));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) this.f434a.f426a.m253a(cd.f549N), new au(this));
        builder.setNegativeButton((CharSequence) this.f434a.f426a.m253a(cd.f550O), new ax(this));
        builder.show();
    }
}
