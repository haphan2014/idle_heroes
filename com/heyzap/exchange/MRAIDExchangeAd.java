package com.heyzap.exchange;

import android.app.Activity;
import android.view.View;
import android.view.ViewManager;
import com.heyzap.common.banner.BannerWrapper;
import com.heyzap.common.banner.BannerWrapper.OnSizeChangeListener;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.nexage.sourcekit.mraid.MRAIDBanner;
import org.nexage.sourcekit.mraid.MRAIDNativeFeature;
import org.nexage.sourcekit.mraid.MRAIDNativeFeatureListener;
import org.nexage.sourcekit.mraid.MRAIDView;
import org.nexage.sourcekit.mraid.MRAIDViewListener;
import org.nexage.sourcekit.mraid.internal.MRAIDNativeFeatureManager;
import org.nexage.sourcekit.mraid.nativefeature.MRAIDNativeFeatureProvider;

public class MRAIDExchangeAd extends ExchangeAd implements BannerWrapper {
    protected static final String[] ALL_FEATURES = new String[]{MRAIDNativeFeature.CALENDAR, MRAIDNativeFeature.INLINE_VIDEO, MRAIDNativeFeature.SMS, MRAIDNativeFeature.STORE_PICTURE, MRAIDNativeFeature.TEL};
    MRAIDNativeFeatureProvider featureProvider;
    private final int height;
    private boolean isDestroyed = false;
    protected MRAIDView mraidView;
    private final int width;

    class C13202 implements Runnable {
        C13202() {
        }

        public void run() {
            MRAIDExchangeAd.this.mraidView = new MRAIDBanner(MRAIDExchangeAd.this.ref.getActivity(), MRAIDExchangeAd.this.url, MRAIDExchangeAd.this.markup, MRAIDExchangeAd.ALL_FEATURES, new MRAIDExchangeViewListener(), new MRAIDExchangeNativeFeatureListener());
        }
    }

    protected class MRAIDExchangeNativeFeatureListener implements MRAIDNativeFeatureListener {
        protected MRAIDExchangeNativeFeatureListener() {
        }

        public void mraidNativeFeatureCreateCalendarEvent(String eventJSON) {
            MRAIDExchangeAd.this.featureProvider.createCalendarEvent(eventJSON);
        }

        public void mraidNativeFeaturePlayVideo(String url) {
            MRAIDExchangeAd.this.featureProvider.playVideo(url);
        }

        public void mraidNativeFeatureOpenBrowser(String url) {
            MRAIDExchangeAd.this.clickEventStream.sendEvent(Boolean.valueOf(true));
            MRAIDExchangeAd.this.featureProvider.openBrowser(url);
        }

        public void mraidNativeFeatureStorePicture(String url) {
            MRAIDExchangeAd.this.featureProvider.storePicture(url);
        }

        public void mraidNativeFeatureSendSms(String url) {
            MRAIDExchangeAd.this.featureProvider.sendSms(url);
        }

        public void mraidNativeFeatureCallTel(String url) {
            MRAIDExchangeAd.this.featureProvider.callTel(url);
        }
    }

    protected class MRAIDExchangeViewListener implements MRAIDViewListener {
        protected MRAIDExchangeViewListener() {
        }

        public void mraidViewLoaded(MRAIDView mraidView) {
            MRAIDExchangeAd.this.fetchListener.set(new FetchResult());
        }

        public void mraidViewExpand(MRAIDView mraidView) {
            Logger.debug("MRAIDExchangeAd Expanded");
        }

        public void mraidViewClose(MRAIDView mraidView) {
            Logger.debug("MRAIDExchangeAd Closed");
            MRAIDExchangeAd.this.closeListener.set(Boolean.valueOf(true));
        }

        public boolean mraidViewResize(MRAIDView mraidView, int width, int height, int offsetX, int offsetY) {
            Logger.debug("MRAIDExchangeAd Resized");
            return true;
        }
    }

    public MRAIDExchangeAd(String markup, String url, String adId, String score, int height, int width, long loadTtl, long expiry, boolean refetchOnExpiry, String extraData, ExchangeRequestParams params, ContextReference ref) {
        super(markup, url, adId, score, expiry, refetchOnExpiry, extraData, params, ref);
        this.featureProvider = new MRAIDNativeFeatureProvider(ref.getActivity(), new MRAIDNativeFeatureManager(ref.getActivity(), new ArrayList(Arrays.asList(ALL_FEATURES))));
        this.width = width;
        this.height = height;
        if (loadTtl > 0) {
            final ContextReference contextReference = ref;
            ExecutorPool.getInstance().schedule(new Runnable() {

                class C13181 implements Runnable {
                    C13181() {
                    }

                    public void run() {
                        MRAIDExchangeAd.this.destroyBanner(true);
                    }
                }

                public void run() {
                    if (!MRAIDExchangeAd.this.mraidView.isLoaded() && MRAIDExchangeAd.this.fetchListener.set(new FetchResult(FetchFailureReason.TIMEOUT, "mraid_load"))) {
                        contextReference.getActivity().runOnUiThread(new C13181());
                    }
                }
            }, loadTtl, TimeUnit.SECONDS);
        }
    }

    public void show(Activity activity) {
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    public void load() {
        if (this.mraidView == null) {
            this.ref.getActivity().runOnUiThread(new C13202());
        } else {
            Logger.error("MRAIDView for MRAIDExchangeAd is already loaded!");
        }
    }

    public boolean onBackPressed() {
        return this.mraidView.onBackPressed();
    }

    public View getRealBannerView() {
        return this.mraidView;
    }

    public int getAdHeight() {
        return translateRelativeDimension(this.height);
    }

    public int getAdWidth() {
        return translateRelativeDimension(this.width);
    }

    private int translateRelativeDimension(int dimension) {
        if (dimension >= 0) {
            return Utils.dpToPx(this.ref.getApp(), dimension);
        }
        return dimension;
    }

    public boolean isExpanded() {
        return this.mraidView.isExpanded();
    }

    public boolean destroyBanner(boolean permaDeath) {
        if (!this.isDestroyed) {
            this.isDestroyed = true;
            getRealBannerView();
            if (getRealBannerView() != null) {
                ViewManager parent = (ViewManager) getRealBannerView().getParent();
                if (parent != null) {
                    parent.removeView(getRealBannerView());
                }
            }
            if (this.mraidView != null) {
                this.mraidView.destroy();
            }
        }
        return true;
    }

    public void setSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
    }
}
