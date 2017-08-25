package com.vungle.publisher;

import com.vungle.publisher.vf.C1623a;
import com.vungle.publisher.vf.C1894b;
import com.vungle.publisher.vf.C1895c;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import rx.functions.Func1;

/* compiled from: vungle */
public final class uv extends vf {

    @Singleton
    /* compiled from: vungle */
    public static class C1890a extends C1623a<uv> implements Func1<gr<?>, Observable<uv>> {
        public final /* synthetic */ Object call(Object obj) {
            uv uvVar = (uv) mo4345b();
            uvVar.f788b = ((gr) obj).mo4413f();
            return Observable.just(uvVar);
        }

        @Inject
        C1890a() {
        }

        protected final /* synthetic */ vf mo4346a() {
            return new uv();
        }
    }

    uv() {
    }

    protected final C1894b mo4348a() {
        return C1894b.GET;
    }

    protected final C1895c mo4349b() {
        return C1895c.download;
    }

    public final String toString() {
        return "{" + C1895c.download + ": " + this.f788b + "}";
    }
}
