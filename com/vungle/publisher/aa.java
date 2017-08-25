package com.vungle.publisher;

/* compiled from: vungle */
public abstract class aa<R> {
    public abstract R mo4372a();

    public abstract R mo4373b();

    public abstract R mo4374c();

    public abstract R mo4375d();

    public final R m811a(C1893v c1893v) {
        switch (c1893v) {
            case vungle_local:
                return mo4372a();
            case vungle_streaming:
                return mo4373b();
            case vungle_mraid:
                return mo4374c();
            case third_party_mraid:
                return mo4375d();
            default:
                throw new IllegalArgumentException("unknown ad type " + c1893v);
        }
    }

    public final R m810a(cu cuVar) {
        return m811a(cuVar.m1333f());
    }
}
