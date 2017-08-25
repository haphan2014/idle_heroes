package com.appsflyer;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.InstanceIDListenerService;
import java.io.IOException;

public class InstanceIDListener extends InstanceIDListenerService {
    private String _refreshedToken;
    private long _tokenTimestamp;

    public void onTokenRefresh() {
        super.onTokenRefresh();
        C0188a.afLog("onTokenRefresh called");
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.GCM_PROJECT_NUMBER);
        try {
            this._refreshedToken = InstanceID.getInstance(this).getToken(string, GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            this._tokenTimestamp = System.currentTimeMillis();
        } catch (IOException e) {
            C0188a.afLog("Could not load registration ID");
        } catch (Throwable th) {
            C0188a.afLog("Error registering for uninstall feature");
        }
        if (this._refreshedToken != null) {
            C0188a.afLog("new token=" + this._refreshedToken);
            string = AppsFlyerProperties.getInstance().getString("gcmToken");
            String string2 = AppsFlyerProperties.getInstance().getString("gcmInstanceId");
            C0193e c0193e = new C0193e(AppsFlyerProperties.getInstance().getString("gcmTokenTimestamp"), string, string2);
            if (c0193e.update(new C0193e(this._tokenTimestamp, this._refreshedToken, string2))) {
                AppsFlyerLib.getInstance().updateServerGcmToken(c0193e, getApplicationContext());
            }
        }
    }
}
