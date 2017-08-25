package com.heyzap.sdk.ads;

import com.heyzap.sdk.ads.HeyzapAds.NativeError;

public interface NativeListener {
    void onAdClicked(NativeAd nativeAd);

    void onAdLoaded(NativeAd nativeAd);

    void onAdShown(NativeAd nativeAd);

    void onError(NativeError nativeError);
}
