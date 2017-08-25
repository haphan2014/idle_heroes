package com.applovin.impl.sdk;

import java.lang.Thread.UncaughtExceptionHandler;

class db implements UncaughtExceptionHandler {
    final /* synthetic */ da f642a;

    db(da daVar) {
        this.f642a = daVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.f642a.f640a.f632c.mo637e("TaskManager", "Caught unhandled exception", th);
    }
}
