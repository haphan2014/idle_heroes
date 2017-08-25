package com.applovin.impl.sdk;

import java.util.concurrent.ThreadFactory;

class da implements ThreadFactory {
    final /* synthetic */ cy f640a;
    private final String f641b;

    public da(cy cyVar, String str) {
        this.f640a = cyVar;
        this.f641b = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AppLovinSdk:" + this.f641b + ":" + dp.m696a(this.f640a.f631b.getSdkKey()));
        thread.setDaemon(true);
        thread.setPriority(10);
        thread.setUncaughtExceptionHandler(new db(this));
        return thread;
    }
}
