package com.vungle.publisher;

import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import rx.Scheduler;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

@Singleton
/* compiled from: vungle */
public final class afb {
    Scheduler f1312a = Schedulers.io();

    @Inject
    afb() {
    }

    public final Func1<Observable<? extends Throwable>, Observable<?>> m1165a(int i, final String str) {
        final int i2 = i + 1;
        return new Func1<Observable<? extends Throwable>, Observable<?>>(this) {
            final /* synthetic */ afb f1311c;

            /* compiled from: vungle */
            class C16951 implements Func1<Integer, Observable<Long>> {
                final /* synthetic */ C16971 f1307a;

                C16951(C16971 c16971) {
                    this.f1307a = c16971;
                }

                public final /* synthetic */ Object call(Object obj) {
                    int a = agi.m1227a(((Integer) obj).intValue(), 2000, 300000);
                    so.m2470a(3, "VunglePrepare", "retry in " + a + " millis - " + str, null);
                    return Observable.timer((long) a, TimeUnit.MILLISECONDS, this.f1307a.f1311c.f1312a);
                }
            }

            /* compiled from: vungle */
            class C16962 implements Func2<Throwable, Integer, Integer> {
                final /* synthetic */ C16971 f1308a;

                C16962(C16971 c16971) {
                    this.f1308a = c16971;
                }

                public final /* synthetic */ Object call(Object obj, Object obj2) {
                    Throwable th = (Throwable) obj;
                    Integer num = (Integer) obj2;
                    if (num.intValue() < i2) {
                        return num;
                    }
                    throw Exceptions.propagate(th);
                }
            }

            public final /* synthetic */ Object call(Object obj) {
                return ((Observable) obj).zipWith(Observable.range(1, i2), new C16962(this)).flatMap(new C16951(this));
            }
        };
    }
}
