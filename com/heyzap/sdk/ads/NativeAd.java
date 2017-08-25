package com.heyzap.sdk.ads;

import android.view.View;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.EventStream;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.internal.Annotations.UsedByExternalCallback;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.DevLogger;
import com.heyzap.internal.Logger;
import com.heyzap.mediation.MediationManager;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds.NativeError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeAd {
    Image adChoicesImage;
    String adChoicesUrl;
    String body;
    String callToAction;
    Image coverImage;
    Image icon;
    private AtomicBoolean loadAttempted;
    private NativeAdResult nativeAdResult;
    String network;
    private NativeAdOptions options;
    String socialContext;
    String title;
    AdmobListener userFacingAdmobListener;
    NativeListener userFacingListener;

    public interface Image {
        int getHeight();

        String getUrl();

        int getWidth();
    }

    public interface AdmobListener {
        void onAppInstallAdLoaded(NativeAd nativeAd, NativeAppInstallAd nativeAppInstallAd);

        void onContentAdLoaded(NativeAd nativeAd, NativeContentAd nativeContentAd);
    }

    public static class NativeAdOptions {
        private boolean adMobAppInstallAdsEnabled = true;
        private boolean adMobContentAdsEnabled = true;
        private Builder adMobNativeAdOptionsBuilder = null;

        public boolean isAdMobAppInstallAdsEnabled() {
            return this.adMobAppInstallAdsEnabled;
        }

        public void setAdMobAppInstallAdsEnabled(boolean adMobAppInstallAdsEnabled) {
            this.adMobAppInstallAdsEnabled = adMobAppInstallAdsEnabled;
        }

        public boolean isAdMobContentAdsEnabled() {
            return this.adMobContentAdsEnabled;
        }

        public void setAdMobContentAdsEnabled(boolean adMobContentAdsEnabled) {
            this.adMobContentAdsEnabled = adMobContentAdsEnabled;
        }

        public Builder getAdMobNativeAdOptionsBuilder() {
            return this.adMobNativeAdOptionsBuilder;
        }

        public void setAdMobNativeAdOptionsBuilder(Builder adMobNativeAdOptionsBuilder) {
            this.adMobNativeAdOptionsBuilder = adMobNativeAdOptionsBuilder;
        }
    }

    public static class NativeAdWrapper {
        public EventStream<Boolean> clickEventListener = EventStream.create();
        public EventStream<DisplayResult> displayEventStream = EventStream.create();
        public SettableFuture<FetchResult> fetchListener = SettableFuture.create();
        public Object nativeAdObject;
    }

    public class NativeFetchException extends Exception {
        private FetchFailureReason reason;

        public NativeFetchException(String message, FetchFailureReason reason) {
            super(message);
            this.reason = reason;
        }

        public FetchFailureReason getFetchFailureReason() {
            return this.reason;
        }
    }

    public NativeAd() {
        this(null);
    }

    public NativeAd(NativeAdOptions options) {
        this.loadAttempted = new AtomicBoolean(false);
        if (options == null) {
            this.options = new NativeAdOptions();
        } else {
            this.options = options;
        }
    }

    public void setListener(NativeListener listener) {
        this.userFacingListener = listener;
    }

    public void setAdmobListener(AdmobListener admobListener) {
        this.userFacingAdmobListener = admobListener;
    }

    @UsedByExternalCallback
    public String getNetwork() {
        return this.nativeAdResult.getNetwork();
    }

    @UsedByExternalCallback
    public String getTitle() {
        return this.nativeAdResult.getTitle();
    }

    @UsedByExternalCallback
    public Image getIcon() {
        return this.nativeAdResult.getIcon();
    }

    @UsedByExternalCallback
    public Image getCoverImage() {
        return this.nativeAdResult.getCoverImage();
    }

    @UsedByExternalCallback
    public String getBody() {
        return this.nativeAdResult.getBody();
    }

    @UsedByExternalCallback
    public String getCallToAction() {
        return this.nativeAdResult.getCallToAction();
    }

    @UsedByExternalCallback
    public String getSocialContext() {
        return this.nativeAdResult.getSocialContext();
    }

    @UsedByExternalCallback
    public Image getAdChoicesImage() {
        return this.nativeAdResult.getAdChoicesImage();
    }

    @UsedByExternalCallback
    public String getAdChoicesUrl() {
        return this.nativeAdResult.getAdChoicesUrl();
    }

    @UsedByExternalCallback
    public Object getNativeAdObject() {
        return this.nativeAdResult.getNativeAdObject();
    }

    protected void setNativeAdResult(NativeAdResult nativeAdResult) {
        this.nativeAdResult = nativeAdResult;
    }

    public void registerView(View view) {
        if (view != null && this.nativeAdResult != null) {
            this.nativeAdResult.registerView(view);
        }
    }

    public void load() {
        load(null);
    }

    public void load(String tag) {
        load(tag, null);
    }

    public void load(String tag, String network) {
        if (this.loadAttempted.compareAndSet(false, true)) {
            MediationManager manager = MediationManager.getInstance();
            MediationRequest mediationRequest = new MediationRequest(AdUnit.NATIVE, tag, null);
            mediationRequest.setNativeAdOptions(this.options);
            mediationRequest.setTimeoutMilli(30000);
            if (network != null) {
                mediationRequest.setNetwork(network);
            }
            final SettableFuture<NativeAdResult> future = manager.fetchNative(mediationRequest);
            future.addListener(new Runnable() {
                public void run() {
                    Exception e;
                    try {
                        NativeAdResult nativeAdResult = (NativeAdResult) future.get();
                        if (nativeAdResult.getFetchFailure() != null) {
                            throw new NativeFetchException(nativeAdResult.getFetchFailure().getMessage(), nativeAdResult.getFetchFailure().getErrorType());
                        }
                        NativeAd.this.setNativeAdResult(nativeAdResult);
                        Object adMobNativeAd = nativeAdResult.getNativeAdObject();
                        if ((adMobNativeAd instanceof NativeAppInstallAd) || (adMobNativeAd instanceof NativeContentAd)) {
                            if (NativeAd.this.userFacingAdmobListener == null) {
                                String message = "An Admob native ad was selected, but there is no AdmobListener. You must call setAdmobListener on your native ad.";
                                DevLogger.error("An Admob native ad was selected, but there is no AdmobListener. You must call setAdmobListener on your native ad.");
                                throw new NativeFetchException("An Admob native ad was selected, but there is no AdmobListener. You must call setAdmobListener on your native ad.", FetchFailureReason.UNKNOWN);
                            } else if (adMobNativeAd instanceof NativeAppInstallAd) {
                                NativeAd.this.userFacingAdmobListener.onAppInstallAdLoaded(NativeAd.this, (NativeAppInstallAd) adMobNativeAd);
                            } else {
                                NativeAd.this.userFacingAdmobListener.onContentAdLoaded(NativeAd.this, (NativeContentAd) adMobNativeAd);
                            }
                        } else if (NativeAd.this.userFacingListener != null) {
                            NativeAd.this.userFacingListener.onAdLoaded(NativeAd.this);
                        } else {
                            DevLogger.error("onAdLoaded not found in NativeListener");
                        }
                    } catch (InterruptedException e2) {
                        e = e2;
                        Logger.error("Trouble Fetching Native Ad", e);
                    } catch (ExecutionException e3) {
                        e = e3;
                        Logger.error("Trouble Fetching Native Ad", e);
                    } catch (final NativeFetchException e4) {
                        Logger.error("NativeAd Fetch Error: " + e4.getMessage());
                        if (NativeAd.this.userFacingListener != null) {
                            NativeAd.this.userFacingListener.onError(new NativeError() {
                                public String getErrorMessage() {
                                    return e4.getMessage();
                                }

                                public FetchFailureReason getErrorCode() {
                                    return e4.getFetchFailureReason();
                                }
                            });
                        }
                    }
                }
            }, ExecutorPool.getInstance());
        }
    }

    public boolean isLoaded() {
        return this.nativeAdResult != null && this.nativeAdResult.getFetchFailure() == null;
    }

    public void doImpression() {
        if (this.nativeAdResult != null) {
            this.nativeAdResult.displayEventStream.sendEvent(new DisplayResult());
            this.nativeAdResult.onImpression();
        }
        if (this.userFacingListener != null) {
            this.userFacingListener.onAdShown(this);
        }
    }

    public void doClick(View view) {
        if (this.nativeAdResult != null) {
            this.nativeAdResult.clickEventStream.sendEvent(Boolean.valueOf(true));
            this.nativeAdResult.onClick(view);
        }
        if (this.userFacingListener != null) {
            this.userFacingListener.onAdClicked(this);
        }
    }
}
