package com.vungle.publisher;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.vungle.publisher.gx.C1778a;
import dagger.Lazy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class ce {
    final C1715c f1478a;
    final C1715c f1479b;
    @Inject
    Lazy<C1778a> f1480c;
    @Inject
    agg f1481d;
    private final C1712a f1482e;
    private final C1715c f1483f;
    private final BlockingQueue<Runnable> f1484g = new PriorityBlockingQueue();

    /* compiled from: vungle */
    class C1712a extends Handler {
        final /* synthetic */ ce f1451a;

        /* compiled from: vungle */
        class C1711a implements Comparable<C1711a>, Runnable {
            final /* synthetic */ C1712a f1447a;
            private final Runnable f1448b;
            private final long f1449c;
            private final C1713b f1450d;

            public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
                return this.f1450d.compareTo(((C1711a) obj).f1450d);
            }

            C1711a(C1712a c1712a, Runnable runnable, C1713b c1713b) {
                this(c1712a, runnable, c1713b, (byte) 0);
            }

            private C1711a(C1712a c1712a, Runnable runnable, C1713b c1713b, byte b) {
                this.f1447a = c1712a;
                this.f1448b = runnable;
                this.f1449c = -1;
                this.f1450d = c1713b;
            }

            public final void run() {
                try {
                    this.f1448b.run();
                    try {
                        if (this.f1449c > 0) {
                            this.f1447a.postDelayed(this, this.f1449c);
                        }
                    } catch (Throwable e) {
                        ((C1778a) this.f1447a.f1451a.f1480c.get()).m1865a("VungleAsync", "error rescheduling " + this, e);
                    }
                } catch (Throwable e2) {
                    ((C1778a) this.f1447a.f1451a.f1480c.get()).m1865a("VungleAsync", "error executing " + this, e2);
                    try {
                        if (this.f1449c > 0) {
                            this.f1447a.postDelayed(this, this.f1449c);
                        }
                    } catch (Throwable e22) {
                        ((C1778a) this.f1447a.f1451a.f1480c.get()).m1865a("VungleAsync", "error rescheduling " + this, e22);
                    }
                } catch (Throwable e222) {
                    Throwable th = e222;
                    try {
                        if (this.f1449c > 0) {
                            this.f1447a.postDelayed(this, this.f1449c);
                        }
                    } catch (Throwable e2222) {
                        ((C1778a) this.f1447a.f1451a.f1480c.get()).m1865a("VungleAsync", "error rescheduling " + this, e2222);
                    }
                }
            }

            public final boolean equals(Object object) {
                if (object != null && (object instanceof C1711a)) {
                    if (this.f1448b.equals(((C1711a) object).f1448b)) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return this.f1448b.hashCode();
            }

            public final String toString() {
                return "{PriorityRunnable:: taskType: " + this.f1450d + ", repeatMillis: " + this.f1449c + "}";
            }
        }

        C1712a(ce ceVar, Looper looper) {
            this.f1451a = ceVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            Object obj = message.obj;
            if (obj == null || !(obj instanceof C1711a)) {
                so.m2470a(5, "VungleAsync", "unhandled message " + message, null);
                return;
            }
            C1715c c1715c;
            C1713b a = ((C1711a) obj).f1450d;
            if (a != null) {
                switch (a) {
                    case clientEvent:
                        c1715c = this.f1451a.f1478a;
                        break;
                }
            }
            c1715c = this.f1451a.f1479b;
            so.m2470a(3, "VungleAsync", "processing " + obj, null);
            so.m2470a(2, "VungleAsync", c1715c + ", max pool size " + c1715c.getMaximumPoolSize() + ", largest pool size " + c1715c.getLargestPoolSize(), null);
            c1715c.execute((Runnable) obj);
        }
    }

    /* compiled from: vungle */
    public enum C1713b {
        deviceId,
        databaseWrite,
        requestStreamingAd,
        reportAd,
        reportInstall,
        requestLocalAd,
        prepareLocalAd,
        prepareLocalViewable,
        downloadLocalAd,
        requestConfig,
        sessionEndTimer,
        sessionEnd,
        sessionStart,
        unfilledAd,
        deleteExpiredAds,
        otherTask,
        externalNetworkRequest,
        clientEvent,
        appFingerprint,
        reportExceptions,
        sleepWakeup
    }

    /* compiled from: vungle */
    class C1715c extends ThreadPoolExecutor {
        final /* synthetic */ ce f1477a;

        /* compiled from: vungle */
        class C17141 implements ThreadFactory {
            int f1474a = 0;
            final /* synthetic */ ce f1475b;
            final /* synthetic */ String f1476c;

            C17141(ce ceVar, String str) {
                this.f1475b = ceVar;
                this.f1476c = str;
            }

            public final Thread newThread(Runnable runnable) {
                StringBuilder append = new StringBuilder().append(this.f1476c);
                int i = this.f1474a;
                this.f1474a = i + 1;
                String stringBuilder = append.append(i).toString();
                so.m2470a(2, "VungleAsync", "starting " + stringBuilder, null);
                return new Thread(runnable, stringBuilder);
            }
        }

        C1715c(ce ceVar, int i, String str) {
            this.f1477a = ceVar;
            super(2, 2, 30, TimeUnit.SECONDS, i, new C17141(ceVar, str));
            allowCoreThreadTimeOut(true);
        }

        protected final void afterExecute(Runnable runnable, Throwable throwable) {
            super.afterExecute(runnable, throwable);
            if (throwable != null) {
                ((C1778a) this.f1477a.f1480c.get()).m1865a("VungleAsync", "error after executing runnable", throwable);
            }
        }
    }

    @Inject
    ce() {
        HandlerThread handlerThread = new HandlerThread("VungleAsyncMasterThread");
        handlerThread.start();
        this.f1478a = new C1715c(this, new LinkedBlockingQueue(), "VungleAsyncClientEventThread-");
        this.f1478a.allowCoreThreadTimeOut(true);
        this.f1483f = new C1715c(this, new LinkedBlockingQueue(), "VungleAsyncExternalNetworkRequestThread-");
        this.f1483f.allowCoreThreadTimeOut(true);
        this.f1482e = new C1712a(this, handlerThread.getLooper());
        this.f1479b = new C1715c(this, this.f1484g, "VungleAsyncMainThread-");
        this.f1479b.allowCoreThreadTimeOut(true);
    }

    public final void m1245a(Runnable runnable, C1713b c1713b) {
        this.f1482e.sendMessage(m1242b(runnable, c1713b));
    }

    public final void m1244a(Runnable runnable, long j) {
        m1246a(runnable, C1713b.otherTask, j);
    }

    public final void m1246a(Runnable runnable, C1713b c1713b, long j) {
        so.m2470a(3, "VungleAsync", "scheduling " + c1713b + " delayed " + j + " ms", null);
        this.f1482e.sendMessageDelayed(m1242b(runnable, c1713b), j);
    }

    private Message m1242b(Runnable runnable, C1713b c1713b) {
        C1712a c1712a = this.f1482e;
        int ordinal = c1713b.ordinal();
        c1712a.getClass();
        return c1712a.obtainMessage(ordinal, new C1711a(c1712a, runnable, c1713b));
    }

    public final void m1243a(C1713b c1713b) {
        this.f1482e.removeMessages(c1713b.ordinal());
    }
}
