package com.heyzap.common.video;

import java.io.Serializable;
import org.json.JSONObject;

public class VideoDisplayOptions implements Cloneable, Serializable {
    public boolean allowAdTimer = true;
    public boolean allowClick = false;
    public boolean allowHide = false;
    public boolean allowInstallButton = true;
    public boolean allowSkip = true;
    public boolean allowStreamingFallback = false;
    public boolean forceStreaming = false;
    public String installButtonText = "Install Now";
    public int lockoutTime = 0;
    public boolean postRollInterstitial = false;
    public double requiredDownloadPercent = 100.0d;
    public boolean showCountdown = true;
    public String skipLaterText = "Skip in %i";
    public String skipNowText = "Skip";

    public void setOptions(JSONObject obj) {
        this.lockoutTime = obj.optInt("lockout_time", this.lockoutTime);
        this.allowSkip = obj.optBoolean("allow_skip", this.allowSkip);
        this.allowHide = obj.optBoolean("allow_hide", this.allowHide);
        this.allowClick = obj.optBoolean("allow_click", this.allowClick);
        this.postRollInterstitial = obj.optBoolean("post_roll_interstitial", this.postRollInterstitial);
        this.allowStreamingFallback = obj.optBoolean("allow_streaming_fallback", this.allowStreamingFallback);
        this.forceStreaming = obj.optBoolean("force_streaming", this.forceStreaming);
        this.showCountdown = obj.optBoolean("show_countdown", this.showCountdown);
        this.requiredDownloadPercent = obj.optDouble("required_download_percent", this.requiredDownloadPercent);
        this.allowAdTimer = obj.optBoolean("allow_ad_timer", this.allowAdTimer);
        this.allowInstallButton = obj.optBoolean("allow_install_button", this.allowInstallButton);
        this.installButtonText = obj.optString("install_button_text", this.installButtonText);
        this.skipNowText = obj.optString("skip_now_text", this.skipNowText);
        this.skipLaterText = obj.optString("skip_later_formatted_text", this.skipLaterText);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
