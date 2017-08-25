package com.vungle.publisher;

import android.location.Location;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: vungle */
abstract class se<T> implements sf {
    T f3173a;
    private int f3174b;
    private final Object f3175c = new Object();
    private boolean f3176d;

    protected abstract String mo4539a();

    protected abstract boolean mo4540a(T t);

    protected abstract void mo4541b(T t);

    protected abstract Location mo4542c(T t);

    protected abstract T mo4543c();

    protected abstract void mo4544d(T t);

    se() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.location.Location mo4538b() {
        /*
        r7 = this;
        r0 = 0;
        r2 = r7.f3175c;
        monitor-enter(r2);
        r1 = r7.m2441e();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0110 }
        if (r1 == 0) goto L_0x002c;
    L_0x000a:
        r1 = r7.f3173a;	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0110 }
        r0 = r7.mo4542c(r1);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0110 }
        if (r0 != 0) goto L_0x0031;
    L_0x0012:
        r1 = "VungleLocation";
        r3 = new java.lang.StringBuilder;	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = "no location returned from ";
        r3.<init>(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = r7.mo4539a();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.append(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.toString();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = 3;
        r5 = 0;
        com.vungle.publisher.so.m2470a(r4, r1, r3, r5);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
    L_0x002c:
        r7.m2444g();	 Catch:{ all -> 0x010d }
    L_0x002f:
        monitor-exit(r2);	 Catch:{ all -> 0x010d }
        return r0;
    L_0x0031:
        r1 = "VungleLocation";
        r3 = new java.lang.StringBuilder;	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = "provider: ";
        r3.<init>(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = r0.getProvider();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.append(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.toString();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = 2;
        r5 = 0;
        com.vungle.publisher.so.m2470a(r4, r1, r3, r5);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r1 = "VungleLocation";
        r3 = new java.lang.StringBuilder;	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = "latitude: ";
        r3.<init>(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = r0.getLatitude();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.append(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = "°";
        r3 = r3.append(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.toString();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = 2;
        r5 = 0;
        com.vungle.publisher.so.m2470a(r4, r1, r3, r5);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r1 = "VungleLocation";
        r3 = new java.lang.StringBuilder;	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = "longitude: ";
        r3.<init>(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = r0.getLongitude();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.append(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = "°";
        r3 = r3.append(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.toString();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = 2;
        r5 = 0;
        com.vungle.publisher.so.m2470a(r4, r1, r3, r5);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r1 = "VungleLocation";
        r3 = new java.lang.StringBuilder;	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = "accuracy: ";
        r3.<init>(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = r0.getAccuracy();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.append(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = " m";
        r3 = r3.append(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.toString();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = 2;
        r5 = 0;
        com.vungle.publisher.so.m2470a(r4, r1, r3, r5);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r1 = "VungleLocation";
        r3 = new java.lang.StringBuilder;	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = "speed: ";
        r3.<init>(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = r0.getSpeed();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.append(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = " m/s";
        r3 = r3.append(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.toString();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = 2;
        r5 = 0;
        com.vungle.publisher.so.m2470a(r4, r1, r3, r5);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r1 = "VungleLocation";
        r3 = new java.lang.StringBuilder;	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = "time: ";
        r3.<init>(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = r0.getTime();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.append(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = " ms";
        r3 = r3.append(r4);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r3 = r3.toString();	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        r4 = 2;
        r5 = 0;
        com.vungle.publisher.so.m2470a(r4, r1, r3, r5);	 Catch:{ SecurityException -> 0x00ed, Exception -> 0x0138 }
        goto L_0x002c;
    L_0x00ed:
        r1 = move-exception;
        r1 = "VungleLocation";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0133 }
        r4 = "no location permissions using ";
        r3.<init>(r4);	 Catch:{ all -> 0x0133 }
        r4 = r7.mo4539a();	 Catch:{ all -> 0x0133 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0133 }
        r3 = r3.toString();	 Catch:{ all -> 0x0133 }
        r4 = 3;
        r5 = 0;
        com.vungle.publisher.so.m2470a(r4, r1, r3, r5);	 Catch:{ all -> 0x0133 }
        r7.m2444g();	 Catch:{ all -> 0x010d }
        goto L_0x002f;
    L_0x010d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x010d }
        throw r0;
    L_0x0110:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x0114:
        r3 = "VungleLocation";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0133 }
        r5 = "error obtaining detailed location using ";
        r4.<init>(r5);	 Catch:{ all -> 0x0133 }
        r5 = r7.mo4539a();	 Catch:{ all -> 0x0133 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0133 }
        r4 = r4.toString();	 Catch:{ all -> 0x0133 }
        r5 = 5;
        com.vungle.publisher.so.m2470a(r5, r3, r4, r0);	 Catch:{ all -> 0x0133 }
        r7.m2444g();	 Catch:{ all -> 0x010d }
        r0 = r1;
        goto L_0x002f;
    L_0x0133:
        r0 = move-exception;
        r7.m2444g();	 Catch:{ all -> 0x010d }
        throw r0;	 Catch:{ all -> 0x010d }
    L_0x0138:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x0114;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.se.b():android.location.Location");
    }

    private boolean m2441e() {
        Throwable th;
        Throwable th2;
        Throwable th3;
        boolean z = false;
        Object obj = null;
        Object obj2;
        boolean z2;
        try {
            synchronized (this.f3175c) {
                try {
                    obj = this.f3173a;
                    boolean e = m2442e(obj);
                    if (e) {
                        so.m2470a(3, "VungleLocation", Thread.currentThread().getName() + " already connected to " + mo4539a() + " " + obj, null);
                        obj2 = obj;
                        z2 = e;
                    } else {
                        if (obj == null) {
                            obj2 = mo4543c();
                            this.f3173a = obj2;
                            try {
                                this.f3176d = false;
                                mo4541b(obj2);
                                obj = obj2;
                            } catch (Throwable th4) {
                                th = th4;
                                obj = obj2;
                                z = e;
                                try {
                                    throw th;
                                } catch (Throwable th5) {
                                    th2 = th5;
                                    z2 = z;
                                    obj2 = obj;
                                    th3 = th2;
                                }
                            }
                        }
                        while (!this.f3176d) {
                            try {
                                so.m2470a(3, "VungleLocation", Thread.currentThread().getName() + " waiting for " + mo4539a() + " to connect " + obj, null);
                                this.f3175c.wait();
                            } catch (InterruptedException e2) {
                                so.m2470a(3, "VungleLocation", Thread.currentThread().getName() + " interrupted while waiting for " + mo4539a() + " to connect " + obj, null);
                            } catch (Throwable th6) {
                                th5 = th6;
                                z = e;
                            }
                        }
                        z2 = m2442e(obj);
                        obj2 = obj;
                    }
                    if (z2) {
                        try {
                            this.f3174b++;
                        } catch (Throwable th32) {
                            th2 = th32;
                            obj = obj2;
                            z = z2;
                            th5 = th2;
                            throw th5;
                        }
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    throw th5;
                }
            }
        } catch (Throwable th52) {
            th2 = th52;
            z2 = false;
            obj2 = null;
            th32 = th2;
            so.m2470a(5, "VungleLocation", Thread.currentThread().getName() + " error connecting to " + mo4539a() + " " + obj2, th32);
            return z2;
        }
    }

    private boolean m2442e(T t) {
        return t != null && mo4540a(t);
    }

    protected final void m2451d() {
        so.m2470a(3, "VungleLocation", "connected to " + mo4539a() + " " + this.f3173a, null);
        m2443f();
    }

    protected void onConnectionFailed(ConnectionResult connectionResult) {
        so.m2470a(4, "VungleLocation", "failed to connect " + mo4539a() + " " + this.f3173a + "; connection result " + connectionResult, null);
        m2443f();
    }

    private void m2443f() {
        synchronized (this.f3175c) {
            this.f3176d = true;
            this.f3175c.notifyAll();
        }
    }

    private void m2444g() {
        synchronized (this.f3175c) {
            int i = this.f3174b - 1;
            this.f3174b = i;
            if (i > 0) {
                so.m2470a(2, "VungleLocation", Thread.currentThread().getName() + " not disconnecting from " + mo4539a() + " because " + i + " clients still connected " + this.f3173a, null);
            } else {
                so.m2470a(3, "VungleLocation", Thread.currentThread().getName() + " disconnecting from " + mo4539a() + " " + this.f3173a, null);
                Object obj = this.f3173a;
                if (m2442e(obj)) {
                    mo4544d(obj);
                    this.f3173a = null;
                }
            }
        }
    }
}
