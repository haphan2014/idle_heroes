package com.vungle.publisher;

import org.json.JSONException;

/* compiled from: vungle */
public abstract class aas<T> {
    public abstract T mo4352b() throws JSONException;

    public final String m857d() throws JSONException {
        Object b = mo4352b();
        return b == null ? null : b.toString();
    }

    protected static void m855a(String str, Object obj) {
        if (obj == null) {
            so.m2470a(3, "VungleProtocol", "null " + str + " is required output", null);
        }
    }
}
