package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

public class PostbackServiceImpl implements AppLovinPostbackService {
    private final AppLovinSdkImpl f365a;

    PostbackServiceImpl(AppLovinSdkImpl appLovinSdkImpl) {
        this.f365a = appLovinSdkImpl;
    }

    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackAsync(str, null, appLovinPostbackListener);
    }

    public void dispatchPostbackAsync(String str, Map map, int i, int i2, int i3, AppLovinPostbackListener appLovinPostbackListener) {
        if (AppLovinSdkUtils.isValidString(str)) {
            cc csVar = new cs(this.f365a, str, map, appLovinPostbackListener);
            csVar.m600b(i2);
            csVar.m599a(i);
            csVar.m601c(i3);
            this.f365a.m252a().m649a(csVar, cz.POSTBACKS);
            return;
        }
        this.f365a.getLogger().mo636e("PostbackService", "Requested a postback dispatch for an empty URL; nothing to do...");
        if (appLovinPostbackListener != null) {
            appLovinPostbackListener.onPostbackFailure(str, AppLovinErrorCodes.INVALID_URL);
        }
    }

    public void dispatchPostbackAsync(String str, Map map, AppLovinPostbackListener appLovinPostbackListener) {
        if (AppLovinSdkUtils.isValidString(str)) {
            this.f365a.m252a().m649a(new cs(this.f365a, str, map, new bw(this, appLovinPostbackListener)), cz.POSTBACKS);
            return;
        }
        this.f365a.getLogger().mo635d("PostbackService", "Ignoring enqueued postback request to invalid URL");
    }
}
