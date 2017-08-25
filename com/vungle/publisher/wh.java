package com.vungle.publisher;

import com.heyzap.http.AsyncHttpClient;
import com.vungle.publisher.vf.C1623a;
import com.vungle.publisher.vf.C1894b;
import javax.inject.Inject;

/* compiled from: vungle */
public abstract class wh extends vf {

    /* compiled from: vungle */
    public static abstract class C1900a<T extends wh> extends C1623a<T> {
        @Inject
        String f3507b;

        protected abstract String mo4552c();

        protected final /* synthetic */ vf mo4345b() {
            return m2574d();
        }

        protected C1900a() {
        }

        protected final T m2574d() {
            wh whVar = (wh) super.mo4345b();
            whVar.m825a("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            whVar.m825a("Content-Type", "application/json");
            whVar.f788b = this.f3507b + mo4552c();
            return whVar;
        }
    }

    protected final C1894b mo4348a() {
        return C1894b.POST;
    }
}
