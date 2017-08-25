package com.heyzap.exchange;

import android.app.Activity;
import com.heyzap.internal.ContextReference;
import org.nexage.sourcekit.mraid.MRAIDInterstitial;

public class InterstitialMRAIDExchangeAd extends MRAIDExchangeAd {

    class C13171 implements Runnable {
        C13171() {
        }

        public void run() {
            InterstitialMRAIDExchangeAd.this.mraidView = new MRAIDInterstitial(InterstitialMRAIDExchangeAd.this.ref.getActivity(), null, InterstitialMRAIDExchangeAd.this.markup, MRAIDExchangeAd.ALL_FEATURES, new MRAIDExchangeViewListener(), new MRAIDExchangeNativeFeatureListener());
        }
    }

    public InterstitialMRAIDExchangeAd(String markup, String url, String adId, String score, int height, int width, long loadTtl, long expiry, boolean refetchOnExpiry, String extraData, ExchangeRequestParams params, ContextReference ref) {
        super(markup, url, adId, score, height, width, loadTtl, expiry, refetchOnExpiry, extraData, params, ref);
    }

    public void load() {
        this.ref.getActivity().runOnUiThread(new C13171());
    }

    public void show(Activity activity) {
        ((MRAIDInterstitial) this.mraidView).show(activity);
    }

    public boolean onBackPressed() {
        return this.mraidView.onBackPressed();
    }
}
