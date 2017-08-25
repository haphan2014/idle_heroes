package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class dm extends ca {
    private final AppLovinAdImpl f663a;
    private final AppLovinAdRewardListener f664b;
    private final Object f665c = new Object();
    private volatile boolean f666d = false;

    public dm(AppLovinSdkImpl appLovinSdkImpl, AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener) {
        super("TaskValidateReward", appLovinSdkImpl);
        this.f663a = (AppLovinAdImpl) appLovinAd;
        this.f664b = appLovinAdRewardListener;
    }

    private void m675a(int i) {
        if (!m681c()) {
            String str = "network_timeout";
            if (i < 400 || i > 500) {
                this.f664b.validationRequestFailed(this.f663a, i);
            } else {
                this.f664b.userRewardRejected(this.f663a, new HashMap(0));
                str = "rejected";
            }
            bs.m436a().m438a(this.f663a, str);
        }
    }

    private void m678a(String str, Map map) {
        if (!m681c()) {
            bs a = bs.m436a();
            a.m438a(this.f663a, str);
            a.m439a(this.f663a, map);
            if (str.equals("accepted")) {
                this.f664b.userRewardVerified(this.f663a, map);
            } else if (str.equals("quota_exceeded")) {
                this.f664b.userOverQuota(this.f663a, map);
            } else if (str.equals("rejected")) {
                this.f664b.userRewardRejected(this.f663a, map);
            } else {
                this.f664b.validationRequestFailed(this.f663a, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m679a(org.json.JSONObject r5) {
        /*
        r4 = this;
        r0 = r4.m681c();
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r2 = com.applovin.impl.sdk.C0165q.m754a(r5);	 Catch:{ JSONException -> 0x0027 }
        r0 = r4.f;	 Catch:{ JSONException -> 0x0027 }
        com.applovin.impl.sdk.C0165q.m756a(r2, r0);	 Catch:{ JSONException -> 0x0027 }
        r0 = "params";
        r0 = r2.get(r0);	 Catch:{ Throwable -> 0x0032 }
        r0 = (org.json.JSONObject) r0;	 Catch:{ Throwable -> 0x0032 }
        r0 = com.applovin.impl.sdk.be.m385a(r0);	 Catch:{ Throwable -> 0x0032 }
        r1 = r0;
    L_0x001d:
        r0 = "result";
        r0 = r2.getString(r0);	 Catch:{ Throwable -> 0x003b }
    L_0x0023:
        r4.m678a(r0, r1);	 Catch:{ JSONException -> 0x0027 }
        goto L_0x0006;
    L_0x0027:
        r0 = move-exception;
        r1 = r4.g;
        r2 = r4.e;
        r3 = "Unable to parse API response";
        r1.mo637e(r2, r3, r0);
        goto L_0x0006;
    L_0x0032:
        r0 = move-exception;
        r0 = new java.util.HashMap;	 Catch:{ JSONException -> 0x0027 }
        r1 = 0;
        r0.<init>(r1);	 Catch:{ JSONException -> 0x0027 }
        r1 = r0;
        goto L_0x001d;
    L_0x003b:
        r0 = move-exception;
        r0 = "network_timeout";
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.dm.a(org.json.JSONObject):void");
    }

    public void m680a(boolean z) {
        synchronized (this.f665c) {
            this.f666d = z;
        }
    }

    boolean m681c() {
        boolean z;
        synchronized (this.f665c) {
            z = this.f666d;
        }
        return z;
    }

    public void run() {
        String b = ab.m301b();
        String clCode = this.f663a.getClCode();
        Map hashMap = new HashMap(2);
        if (AppLovinSdkUtils.isValidString(clCode)) {
            hashMap.put("clcode", clCode);
        } else {
            hashMap.put("clcode", "NO_CLCODE");
        }
        if (b != null) {
            hashMap.put("user_id", b);
        }
        m473a("vr", new JSONObject(hashMap), new dn(this));
    }
}
