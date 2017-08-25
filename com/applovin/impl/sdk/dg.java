package com.applovin.impl.sdk;

import android.util.Log;
import com.applovin.sdk.AppLovinErrorCodes;
import org.json.JSONObject;

class dg implements C0151p {
    final /* synthetic */ AppLovinSdkImpl f652a;
    final /* synthetic */ String f653b;
    final /* synthetic */ df f654c;

    dg(df dfVar, AppLovinSdkImpl appLovinSdkImpl, String str) {
        this.f654c = dfVar;
        this.f652a = appLovinSdkImpl;
        this.f653b = str;
    }

    public void mo622a(int i) {
        int i2 = 0;
        int i3 = (i < 200 || i >= 500) ? 1 : 0;
        if (i != AppLovinErrorCodes.NO_NETWORK) {
            i2 = 1;
        }
        if (i3 == 0 || r0 == 0 || this.f654c.f528a <= 0) {
            this.f654c.mo622a(i);
            return;
        }
        long longValue = this.f654c.f529b < 0 ? ((Long) this.f652a.m253a(cd.f573l)).longValue() : this.f654c.f529b;
        Log.w(this.f653b, "Unable to send request due to server failure (code " + i + "). " + this.f654c.f528a + " attempts left, retrying in " + (((double) longValue) / 1000.0d) + " seconds...");
        df.m478b(this.f654c, 1);
        if (this.f654c.f528a == 0) {
            this.f654c.m480c();
        }
        this.f652a.m252a().m650a(this.f654c, cz.BACKGROUND, longValue);
    }

    public void mo623a(JSONObject jSONObject, int i) {
        this.f654c.f528a = 0;
        this.f654c.mo623a(jSONObject, i);
    }
}
