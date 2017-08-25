package com.heyzap.common.banner;

import com.heyzap.sdk.ads.HeyzapAds.BannerError;

public interface BannerListener {
    void onAdClicked(BannerWrapper bannerWrapper);

    void onAdLoaded(BannerWrapper bannerWrapper);

    void onError(BannerError bannerError);
}
