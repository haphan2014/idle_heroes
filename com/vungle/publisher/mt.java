package com.vungle.publisher;

import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: vungle */
public final class mt extends aar {
    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    public final JSONObject mo4355a() throws JSONException {
        JSONObject a = super.mo4355a();
        a.put("privacyPolicyEnabled", true);
        return a;
    }
}
