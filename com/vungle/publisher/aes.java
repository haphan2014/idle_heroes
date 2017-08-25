package com.vungle.publisher;

import com.vungle.publisher.afd.C1699a;
import com.vungle.publisher.afg.C1700a;
import com.vungle.publisher.afg.C1702b;
import com.vungle.publisher.zd.C1923a;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

/* compiled from: vungle */
public final class aes {
    Scheduler f1245a = Schedulers.computation();
    @Inject
    C1923a f1246b;
    @Inject
    public xm f1247c;
    @Inject
    public aev f1248d;
    @Inject
    public xj f1249e;
    @Inject
    public xg f1250f;
    @Inject
    public C1699a f1251g;
    @Inject
    public C1702b f1252h;
    @Inject
    public C1700a f1253i;
    @Inject
    public aep f1254j;
    @Inject
    pu f1255k;
    @Inject
    public afb f1256l;

    /* compiled from: vungle */
    public class C16851 implements Func0<Observable<zd>> {
        final /* synthetic */ aes f1244a;

        public C16851(aes com_vungle_publisher_aes) {
            this.f1244a = com_vungle_publisher_aes;
        }

        public final /* synthetic */ Object call() {
            long max = Math.max(0, this.f1244a.f1255k.f2943l.getLong("VgSleepWakeupTime", 0) - System.currentTimeMillis());
            so.m2470a(3, "VunglePrepare", "request ad after sleep delay: " + max, null);
            return Observable.just(this.f1244a.f1246b.m2684d()).delay(max, TimeUnit.MILLISECONDS, this.f1244a.f1245a);
        }
    }
}
