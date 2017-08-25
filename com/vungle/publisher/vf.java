package com.vungle.publisher;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.regex.Pattern;
import javax.inject.Inject;

/* compiled from: vungle */
public abstract class vf {
    protected static final Pattern f787a = Pattern.compile("^https://");
    public String f788b;
    public Bundle f789c;
    public String f790d;

    /* compiled from: vungle */
    public static abstract class C1623a<T extends vf> {
        @Inject
        protected pj f779a;

        public abstract T mo4346a();

        protected C1623a() {
        }

        public T mo4345b() {
            T a = mo4346a();
            Bundle bundle = new Bundle();
            Object p = this.f779a.mo4436p();
            if (!TextUtils.isEmpty(p)) {
                bundle.putString("User-Agent", p);
            }
            a.f789c = bundle;
            return a;
        }
    }

    /* compiled from: vungle */
    public enum C1894b {
        GET,
        HEAD,
        POST
    }

    /* compiled from: vungle */
    public enum C1895c {
        download,
        reportAd,
        requestConfig,
        requestLocalAd,
        requestStreamingAd,
        sessionEnd,
        sessionStart,
        trackEvent,
        trackInstall,
        unfilledAd,
        reportExceptions,
        appFingerprint
    }

    public abstract C1894b mo4348a();

    public abstract C1895c mo4349b();

    protected vf() {
    }

    public String toString() {
        return "{" + mo4349b() + "}";
    }

    public final void m825a(String str, String str2) {
        this.f789c.putString(str, str2);
    }
}
