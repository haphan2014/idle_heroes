package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

class ag implements AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {
    final /* synthetic */ ab f391a;
    private final Activity f392b;
    private final AppLovinAdDisplayListener f393c;
    private final AppLovinAdClickListener f394d;
    private final AppLovinAdVideoPlaybackListener f395e;
    private final AppLovinAdRewardListener f396f;

    private ag(ab abVar, Activity activity, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        this.f391a = abVar;
        this.f393c = appLovinAdDisplayListener;
        this.f394d = appLovinAdClickListener;
        this.f395e = appLovinAdVideoPlaybackListener;
        this.f396f = appLovinAdRewardListener;
        this.f392b = activity;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        if (this.f394d != null) {
            this.f391a.f378f.post(new aj(this, appLovinAd));
        }
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        if (this.f393c != null) {
            this.f393c.adDisplayed(appLovinAd);
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        String c = this.f391a.m314c();
        if (AppLovinSdkUtils.isValidString(c) && this.f391a.f382j) {
            this.f391a.m311a(c, this.f392b);
        } else {
            String str;
            int i;
            this.f391a.f381i.m680a(true);
            if (this.f391a.f382j) {
                str = "network_timeout";
                i = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
            } else {
                str = "user_closed_video";
                i = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
            }
            bs.m436a().m438a(appLovinAd, str);
            if (this.f391a.f382j) {
                this.f391a.m311a(c, this.f392b);
            }
            this.f391a.f378f.post(new ah(this, appLovinAd, i));
        }
        if (this.f393c != null) {
            this.f391a.f378f.post(new ai(this, appLovinAd));
        }
        this.f391a.f373a.m252a().m649a(new dh(this.f391a.f373a, appLovinAd), cz.BACKGROUND);
        this.f391a.f375c = null;
        this.f391a.f376d = null;
    }

    public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
    }

    public void userOverQuota(AppLovinAd appLovinAd, Map map) {
        this.f391a.m313b("quota_exceeded");
        if (this.f396f != null) {
            this.f391a.f378f.post(new an(this, appLovinAd, map));
        }
    }

    public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
        this.f391a.m313b("rejected");
        if (this.f396f != null) {
            this.f391a.f378f.post(new ao(this, appLovinAd, map));
        }
    }

    public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
        this.f391a.m313b("accepted");
        if (this.f396f != null) {
            this.f391a.f378f.post(new am(this, appLovinAd, map));
        }
    }

    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        this.f391a.m313b("network_timeout");
        if (this.f396f != null) {
            this.f391a.f378f.post(new ap(this, appLovinAd, i));
        }
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        if (this.f395e != null) {
            this.f391a.f378f.post(new ak(this, appLovinAd));
        }
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        if (this.f395e != null) {
            this.f391a.f378f.post(new al(this, appLovinAd, d, z));
        }
        this.f391a.f382j = z;
    }
}
