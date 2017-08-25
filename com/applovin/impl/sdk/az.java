package com.applovin.impl.sdk;

class az implements Runnable {
    final /* synthetic */ ay f442a;

    az(ay ayVar) {
        this.f442a = ayVar;
    }

    public void run() {
        if (this.f442a.f441c != null) {
            this.f442a.f441c.dismiss();
        }
    }
}
