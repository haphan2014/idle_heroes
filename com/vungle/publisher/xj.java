package com.vungle.publisher;

import javax.inject.Inject;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

/* compiled from: vungle */
public final class xj implements Func1<vl, Observable<String>> {
    @Inject
    wa f3574a;

    public final /* synthetic */ Object call(Object obj) {
        return m2607a((vl) obj);
    }

    private Observable<String> m2607a(vl vlVar) {
        try {
            return Observable.just(this.f3574a.m2566a(vlVar.f3455a));
        } catch (Throwable e) {
            throw Exceptions.propagate(e);
        }
    }
}
