package com.vungle.publisher;

import com.vungle.publisher.abr.C1649a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public abstract class acm extends abr {
    protected String f980s;

    /* compiled from: vungle */
    public static abstract class C1654a<O extends acm, T extends db<T, P, E, A>, P extends da<T, P, E>, E extends dc<P>, A extends jv<A, ?, ?>> extends C1649a<P, O, T, A> {
    }

    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    protected acm() {
    }

    public final JSONObject mo4355a() throws JSONException {
        JSONObject a = super.mo4355a();
        a.putOpt("url", this.f980s);
        return a;
    }
}
