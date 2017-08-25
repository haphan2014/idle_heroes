package com.applovin.impl.sdk;

import android.webkit.WebView;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

class C0167s implements Runnable {
    final /* synthetic */ AtomicReference f702a;
    final /* synthetic */ CountDownLatch f703b;
    final /* synthetic */ C0166r f704c;

    C0167s(C0166r c0166r, AtomicReference atomicReference, CountDownLatch countDownLatch) {
        this.f704c = c0166r;
        this.f702a = atomicReference;
        this.f703b = countDownLatch;
    }

    public void run() {
        try {
            this.f702a.set(new WebView(this.f704c.f699b).getSettings().getUserAgentString());
        } catch (Throwable th) {
            this.f704c.f700c.mo637e("DataCollector", "Unable to collect user agent string", th);
        } finally {
            this.f703b.countDown();
        }
    }
}
