package com.heyzap.mediation.abstr;

import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.sdk.ads.HeyzapAds.BannerOptions;

public interface BannerNetworkAdapter {
    AdDisplay fetchAndShowBanner(BannerOptions bannerOptions);
}
