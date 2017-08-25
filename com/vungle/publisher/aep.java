package com.vungle.publisher;

import com.vungle.publisher.cu.C1721b;
import com.vungle.publisher.cu.C1722c;
import com.vungle.publisher.ei.C1747b;
import com.vungle.publisher.ei.C1747b.C17452;
import com.vungle.publisher.gx.C1778a;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

@Singleton
/* compiled from: vungle */
public final class aep implements Func1<acr, Observable<dy<cu>>> {
    @Inject
    C1721b f1235a;
    @Inject
    C1747b f1236b;
    @Inject
    C1778a f1237c;

    public final /* synthetic */ Object call(Object obj) {
        return m1151a((acr) obj);
    }

    @Inject
    aep() {
    }

    private Observable<dy<cu>> m1151a(acr com_vungle_publisher_acr) {
        Object obj;
        Throwable e;
        eh a = this.f1235a.m1310a(com_vungle_publisher_acr.f1046e);
        String str = com_vungle_publisher_acr.f1047f;
        dy a2 = a.mo4448a(str);
        if (a2 != null) {
            try {
                a.mo4447b(a2.h_(), com_vungle_publisher_acr);
            } catch (Throwable e2) {
                so.m2470a(5, "VunglePrepare", "error updating ad " + str, e2);
            }
            C1722c g = a2.m1547g();
            str = "received " + a2.m1551z() + " in status " + g;
            dy dyVar;
            switch (g) {
                case aware:
                case failed:
                case preparing:
                case viewed:
                    so.m2470a(4, "VunglePrepare", str, null);
                    dyVar = a2;
                    break;
                case invalid:
                case deleting:
                    so.m2470a(5, "VunglePrepare", str + " - retrying", null);
                    throw new RuntimeException("received invalid ad in status: " + g);
                default:
                    so.m2470a(4, "VunglePrepare", str + " - ignoring", null);
                    dyVar = a2;
                    break;
            }
        }
        try {
            new C17452(this.f1236b).m1570a();
            obj = (dy) a.mo4444a(com_vungle_publisher_acr);
            try {
                so.m2470a(4, "VunglePrepare", "received new " + obj.m1551z(), null);
                obj.h_().mo4400v();
            } catch (Exception e3) {
                e = e3;
                this.f1237c.m1865a("VunglePrepare", "error preparing ad " + str + ", retrying", e);
                Exceptions.propagate(e);
                return Observable.just(obj);
            }
        } catch (Throwable e22) {
            Throwable th = e22;
            obj = a2;
            e = th;
            this.f1237c.m1865a("VunglePrepare", "error preparing ad " + str + ", retrying", e);
            Exceptions.propagate(e);
            return Observable.just(obj);
        }
        return Observable.just(obj);
    }
}
