package org.nexage.sourcekit.mraid;

public interface MRAIDNativeFeatureListener {
    void mraidNativeFeatureCallTel(String str);

    void mraidNativeFeatureCreateCalendarEvent(String str);

    void mraidNativeFeatureOpenBrowser(String str);

    void mraidNativeFeaturePlayVideo(String str);

    void mraidNativeFeatureSendSms(String str);

    void mraidNativeFeatureStorePicture(String str);
}
