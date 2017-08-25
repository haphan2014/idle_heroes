package com.applovin.impl.sdk;

import org.json.JSONObject;

class di implements C0151p {
    final /* synthetic */ dh f656a;

    di(dh dhVar) {
        this.f656a = dhVar;
    }

    public void mo622a(int i) {
        this.f656a.g.mo635d("TaskReportReward", "Failed to report reward for ad: " + this.f656a.f655a.getAdIdNumber() + " - error code: " + i);
    }

    public void mo623a(JSONObject jSONObject, int i) {
        this.f656a.g.mo635d("TaskReportReward", "Reported reward successfully for ad: " + this.f656a.f655a.getAdIdNumber());
    }
}
