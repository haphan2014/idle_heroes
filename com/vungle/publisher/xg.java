package com.vungle.publisher;

import com.vungle.publisher.acs.C1663a;
import javax.inject.Inject;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

/* compiled from: vungle */
public final class xg implements Func1<String, Observable<acs>> {
    @Inject
    C1663a f3569a;

    public final /* synthetic */ Object call(Object obj) {
        return m2604a((String) obj);
    }

    @Inject
    xg() {
    }

    private Observable<acs> m2604a(String str) {
        try {
            return Observable.just(this.f3569a.m912a(str));
        } catch (Throwable e) {
            throw Exceptions.propagate(e);
        }
    }
}
