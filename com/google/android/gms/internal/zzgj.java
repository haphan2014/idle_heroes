package com.google.android.gms.internal;

import com.facebook.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzgd
class zzgj {
    private int zzBv;
    private final String zzDK;
    private final List<String> zzEg;
    private final List<String> zzEh;
    private final String zzEi;
    private final String zzEj;
    private final String zzEk;
    private final String zzEl;
    private final boolean zzEm;
    private String zzF;

    public zzgj(int i, Map<String, String> map) {
        this.zzF = (String) map.get("url");
        this.zzEj = (String) map.get("base_uri");
        this.zzEk = (String) map.get("post_parameters");
        this.zzEm = parseBoolean((String) map.get("drt_include"));
        this.zzEi = (String) map.get("activation_overlay_url");
        this.zzEh = zzan((String) map.get("check_packages"));
        this.zzDK = (String) map.get("request_id");
        this.zzEl = (String) map.get("type");
        this.zzEg = zzan((String) map.get("errors"));
        this.zzBv = i;
    }

    private static boolean parseBoolean(String bool) {
        return bool != null && (bool.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) || bool.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
    }

    private List<String> zzan(String str) {
        return str == null ? null : Arrays.asList(str.split(","));
    }

    public int getErrorCode() {
        return this.zzBv;
    }

    public String getRequestId() {
        return this.zzDK;
    }

    public String getType() {
        return this.zzEl;
    }

    public String getUrl() {
        return this.zzF;
    }

    public void setUrl(String url) {
        this.zzF = url;
    }

    public List<String> zzfG() {
        return this.zzEg;
    }

    public String zzfH() {
        return this.zzEk;
    }

    public boolean zzfI() {
        return this.zzEm;
    }
}
