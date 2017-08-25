package com.heyzap.sdk.ads;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewManager;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.facebook.internal.ServerProtocol;
import com.heyzap.common.banner.BannerWrapper;
import com.heyzap.common.banner.BannerWrapper.OnSizeChangeListener;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.EventStream.EventListener;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.Logger;
import com.heyzap.mediation.MediationManager;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds.BannerError;
import com.heyzap.sdk.ads.HeyzapAds.BannerListener;
import com.heyzap.sdk.ads.HeyzapAds.BannerOptions;
import com.heyzap.sdk.ads.HeyzapAds.CreativeSize;
import com.heyzap.sdk.mediation.adapter.InMobiAdapter.InMobiBannerWrapper;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BannerAdView extends FrameLayout {
    private static final String XML_ATTRIBUTE_LOAD_AD_ON_CREATE = "loadAdOnCreate";
    private static final String XML_ATTRIBUTE_ON_CLICK = "onClick";
    private static final String XML_ATTRIBUTE_ON_ERROR = "onError";
    private static final String XML_ATTRIBUTE_ON_LOAD = "onAdLoaded";
    private static final String XML_ATTRIBUTE_TAG = "tag";
    private Activity activity;
    private String activityOnClickedMethod;
    private String activityOnErrorMethod;
    private String activityOnLoadedMethod;
    private String adTag;
    private BannerListener bannerListener;
    private BannerOptions bannerOptions;
    BannerWrapper bannerWrapper;
    private boolean isDestroyed;
    AtomicBoolean loadAttempted;
    private MediationRequest mediationRequest;
    private BannerWrapper previousBannerWrapper;

    class C14612 implements EventListener<Boolean> {
        C14612() {
        }

        public void onEvent(Boolean event) {
            BannerAdView.this.onClickedHandler();
        }
    }

    class C14654 implements Runnable {
        C14654() {
        }

        public void run() {
            Throwable e;
            if (BannerAdView.this.bannerListener != null) {
                BannerAdView.this.bannerListener.onAdClicked(BannerAdView.this);
                if (BannerAdView.this.bannerListener == BannerAdView.this.activity) {
                    return;
                }
            }
            if (BannerAdView.this.activityOnClickedMethod != null) {
                try {
                    BannerAdView.this.activity.getClass().getMethod(BannerAdView.this.activityOnClickedMethod, new Class[]{BannerAdView.class}).invoke(BannerAdView.this.activity, new Object[]{BannerAdView.this});
                } catch (NoSuchMethodException e2) {
                    e = e2;
                    Logger.trace(e);
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    Logger.trace(e);
                } catch (InvocationTargetException e4) {
                    e = e4;
                    Logger.trace(e);
                } catch (IllegalAccessException e5) {
                    e = e5;
                    Logger.trace(e);
                }
            }
        }
    }

    class C14665 implements Runnable {
        C14665() {
        }

        public void run() {
            Throwable e;
            if (BannerAdView.this.bannerListener != null) {
                BannerAdView.this.bannerListener.onAdLoaded(BannerAdView.this);
                if (BannerAdView.this.bannerListener == BannerAdView.this.activity) {
                    return;
                }
            }
            if (BannerAdView.this.activityOnLoadedMethod != null) {
                try {
                    BannerAdView.this.activity.getClass().getMethod(BannerAdView.this.activityOnLoadedMethod, new Class[]{BannerAdView.class}).invoke(BannerAdView.this.activity, new Object[]{BannerAdView.this});
                } catch (NoSuchMethodException e2) {
                    e = e2;
                    Logger.trace(e);
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    Logger.trace(e);
                } catch (InvocationTargetException e4) {
                    e = e4;
                    Logger.trace(e);
                } catch (IllegalAccessException e5) {
                    e = e5;
                    Logger.trace(e);
                }
            }
        }
    }

    public BannerAdView(Activity activity) {
        this(activity, (String) null);
    }

    public BannerAdView(Activity activity, String tag) {
        super(activity);
        this.bannerListener = null;
        this.bannerOptions = new BannerOptions();
        this.adTag = null;
        this.isDestroyed = false;
        this.loadAttempted = new AtomicBoolean(false);
        this.activityOnLoadedMethod = null;
        this.activityOnErrorMethod = null;
        this.activityOnClickedMethod = null;
        this.activity = activity;
        this.adTag = tag;
    }

    public BannerAdView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    public BannerAdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.bannerListener = null;
        this.bannerOptions = new BannerOptions();
        this.adTag = null;
        this.isDestroyed = false;
        this.loadAttempted = new AtomicBoolean(false);
        this.activityOnLoadedMethod = null;
        this.activityOnErrorMethod = null;
        this.activityOnClickedMethod = null;
        this.activity = (Activity) context;
        this.activityOnLoadedMethod = attrs.getAttributeValue(null, XML_ATTRIBUTE_ON_LOAD);
        this.activityOnErrorMethod = attrs.getAttributeValue(null, XML_ATTRIBUTE_ON_ERROR);
        this.activityOnClickedMethod = attrs.getAttributeValue(null, XML_ATTRIBUTE_ON_CLICK);
        String loadAdOnCreate = attrs.getAttributeValue(null, XML_ATTRIBUTE_LOAD_AD_ON_CREATE);
        if (loadAdOnCreate != null && loadAdOnCreate.toLowerCase(Locale.US).equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            this.adTag = attrs.getAttributeValue(null, XML_ATTRIBUTE_TAG);
        }
    }

    public void load() {
        load(null);
    }

    public void load(String tag) {
        load(tag, null);
    }

    public void load(String tag, String network) {
        load(tag, network, true);
    }

    public void load(String tag, String network, final boolean attachToView) {
        this.isDestroyed = false;
        if (this.loadAttempted.compareAndSet(false, true)) {
            MediationManager manager = MediationManager.getInstance();
            if (this.adTag != null) {
                this.mediationRequest = new MediationRequest(AdUnit.BANNER, this.adTag, this.activity);
            } else {
                this.mediationRequest = new MediationRequest(AdUnit.BANNER, tag, this.activity);
            }
            this.mediationRequest.setNetwork(network);
            this.mediationRequest.setTimeoutMilli(10000);
            if (getLayoutParams() != null) {
                LayoutParams params = getLayoutParams();
                this.bannerOptions.setContainerViewSize(new CreativeSize(params.width, params.height));
            }
            this.mediationRequest.setBannerOptions(this.bannerOptions);
            manager.display(this.mediationRequest);
            this.mediationRequest.addDisplayEventListener(new EventListener<DisplayResult>() {
                public void onEvent(final DisplayResult result) {
                    if (!result.success) {
                        BannerAdView.this.onErrorHandler(new BannerError() {
                            public String getErrorMessage() {
                                return result.errorMessage;
                            }

                            public FetchFailureReason getErrorCode() {
                                return result.errorCode;
                            }
                        });
                    } else if (BannerAdView.this.isDestroyed) {
                        if (result.bannerWrapper != null) {
                            BannerAdView.this.activity.runOnUiThread(new Runnable() {
                                public void run() {
                                    result.bannerWrapper.destroyBanner(true);
                                }
                            });
                        }
                    } else if (result.bannerWrapper != null) {
                        BannerAdView.this.previousBannerWrapper = BannerAdView.this.bannerWrapper;
                        BannerAdView.this.bannerWrapper = result.bannerWrapper;
                        if (attachToView) {
                            BannerAdView.this.attachBannerWrapperToView(result.bannerWrapper);
                        }
                        if (!(result.bannerWrapper instanceof InMobiBannerWrapper)) {
                            BannerAdView.this.onLoadedHandler();
                        }
                    } else {
                        BannerAdView.this.onLoadedHandler();
                    }
                }
            });
            this.mediationRequest.addClickEventListener(new C14612());
        }
    }

    private void attachBannerWrapperToView(final BannerWrapper bannerWrapper) {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                final View realBannerView = bannerWrapper.getRealBannerView();
                if (realBannerView != null && bannerWrapper != BannerAdView.this.previousBannerWrapper) {
                    ViewParent parent = realBannerView.getParent();
                    if (parent != null) {
                        ((ViewManager) parent).removeView(realBannerView);
                    }
                    if (BannerAdView.this.previousBannerWrapper != null) {
                        BannerAdView.this.previousBannerWrapper.destroyBanner(false);
                        BannerAdView.this.previousBannerWrapper = null;
                    }
                    BannerAdView.this.removeAllViews();
                    BannerAdView.this.addView(realBannerView, new FrameLayout.LayoutParams(bannerWrapper.getAdWidth(), bannerWrapper.getAdHeight()));
                    bannerWrapper.setSizeChangeListener(new OnSizeChangeListener() {
                        public void onSizeChange(final int width, final int height) {
                            BannerAdView.this.post(new Runnable() {
                                public void run() {
                                    realBannerView.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                                }
                            });
                        }
                    });
                    BannerAdView.this.setVisibility(0);
                }
            }
        });
    }

    public void setBannerListener(BannerListener bannerListener) {
        this.bannerListener = bannerListener;
    }

    public boolean destroy() {
        boolean destroyed = false;
        this.isDestroyed = true;
        if (this.bannerWrapper != null) {
            destroyed = this.bannerWrapper.destroyBanner(true);
            this.bannerWrapper = null;
        }
        MediationRequest localRequest = this.mediationRequest;
        if (localRequest != null) {
            localRequest.setCancelled(true);
        }
        setVisibility(4);
        return destroyed;
    }

    private void onClickedHandler() {
        this.activity.runOnUiThread(new C14654());
    }

    private void onLoadedHandler() {
        this.activity.runOnUiThread(new C14665());
    }

    private void onErrorHandler(final BannerError error) {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                Throwable e;
                if (BannerAdView.this.bannerListener != null) {
                    BannerAdView.this.bannerListener.onAdError(BannerAdView.this, error);
                    if (BannerAdView.this.bannerListener == BannerAdView.this.activity) {
                        return;
                    }
                }
                if (BannerAdView.this.activityOnErrorMethod != null) {
                    try {
                        BannerAdView.this.activity.getClass().getMethod(BannerAdView.this.activityOnErrorMethod, new Class[]{BannerAdView.class, BannerError.class}).invoke(BannerAdView.this.activity, new Object[]{BannerAdView.this, error});
                    } catch (NoSuchMethodException e2) {
                        e = e2;
                        Logger.trace(e);
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        Logger.trace(e);
                    } catch (IllegalAccessException e4) {
                        e = e4;
                        Logger.trace(e);
                    } catch (InvocationTargetException e5) {
                        e = e5;
                        Logger.trace(e);
                    }
                }
            }
        });
    }

    public BannerOptions getBannerOptions() {
        return this.bannerOptions;
    }

    protected void setBannerOptions(BannerOptions options) {
        this.bannerOptions = options;
    }

    public String getAdTag() {
        return this.adTag;
    }

    public void setAdTag(String tag) {
        this.adTag = tag;
    }
}
