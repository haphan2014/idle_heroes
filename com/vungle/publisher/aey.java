package com.vungle.publisher;

import com.vungle.publisher.ew.C1752a;
import com.vungle.publisher.ew.C1753b;
import com.vungle.publisher.uv.C1890a;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

@Singleton
/* compiled from: vungle */
public final class aey implements Func1<gr<?>, Observable<? extends gr<?>>> {
    @Inject
    C1890a f1295a;
    @Inject
    xe f1296b;
    @Inject
    xm f1297c;
    @Inject
    afb f1298d;

    /* compiled from: vungle */
    class C16932 implements Func1<gr<?>, Observable<? extends gr<?>>> {
        final /* synthetic */ aey f1293a;

        C16932(aey com_vungle_publisher_aey) {
            this.f1293a = com_vungle_publisher_aey;
        }

        public final /* synthetic */ Object call(Object obj) {
            gr grVar = (gr) obj;
            if (grVar.mo4415h()) {
                return Observable.just(grVar);
            }
            throw new RuntimeException(grVar.mo4409t() + " post processing failed for ad_id " + grVar.mo4407l());
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        final gr grVar = (gr) obj;
        C1753b t = grVar.mo4409t();
        C1752a s = grVar.mo4408s();
        String l = grVar.mo4407l();
        so.m2470a(3, "VunglePrepare", "preparing viewable: " + grVar, null);
        Observable just = Observable.just(grVar);
        switch (s) {
            case ready:
                return just;
            case downloaded:
                break;
            case aware:
            case failed:
                so.m2470a(3, "VunglePrepare", t + " will begin downloading for ad_id " + l, null);
                just = just.flatMap(this.f1295a).flatMap(this.f1297c).zipWith(Observable.just(grVar), this.f1296b);
                break;
            default:
                throw new IllegalStateException("unexpected " + t + " status: " + s);
        }
        return just.flatMap(new C16932(this)).doOnError(new Action1<Throwable>(this) {
            final /* synthetic */ aey f1292b;

            public final /* synthetic */ void call(Object obj) {
                so.m2470a(4, "VunglePrepare", "viewable prep error, update status to failed for " + grVar, null);
                grVar.mo4405b(C1752a.failed);
            }
        }).retryWhen(this.f1298d.m1165a(3, "viewable prep failed"));
    }

    @Inject
    aey() {
    }
}
