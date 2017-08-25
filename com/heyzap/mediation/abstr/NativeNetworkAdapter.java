package com.heyzap.mediation.abstr;

import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.sdk.ads.NativeAd.NativeAdWrapper;

public interface NativeNetworkAdapter {
    NativeAdWrapper fetchNative(FetchOptions fetchOptions);
}
