package com.heyzap.mediation.request;

import android.app.Activity;
import android.support.annotation.Nullable;
import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.EventStream;
import com.heyzap.common.lifecycle.EventStream.EventListener;
import com.heyzap.internal.Constants;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Utils;
import com.heyzap.sdk.ads.HeyzapAds.BannerOptions;
import com.heyzap.sdk.ads.NativeAd.NativeAdOptions;
import java.util.concurrent.ExecutorService;

public class MediationRequest {
    private final Integer DEFAULT_TIMEOUT;
    private BannerOptions bannerOptions;
    private boolean cancelled;
    private final EventStream<Boolean> clickEventStream;
    private final SettableFuture<Boolean> closeListener;
    private final EventStream<DisplayResult> displayEventStream;
    private ExecutorService executorService;
    private final SettableFuture<Boolean> incentiveListener;
    private String incentivizedInfo;
    private NativeAdOptions nativeAdOptions;
    private String network;
    private RequestType requestType;
    private Activity requestingActivity;
    private long startedAt;
    private Integer timeoutMilli;

    public static class RequestType {
        public final AdUnit adUnit;
        public final String tag;

        public String toString() {
            return String.format("RequestType<adUnit: %s,tag: %s>", new Object[]{this.adUnit, this.tag});
        }

        public RequestType(AdUnit adUnit, String tag) {
            this.adUnit = adUnit;
            this.tag = tag;
        }

        public String getTag() {
            return this.tag == null ? Constants.DEFAULT_TAG : this.tag;
        }

        public AdUnit getAdUnit() {
            return this.adUnit;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            RequestType fetchType = (RequestType) o;
            if (this.adUnit != fetchType.adUnit) {
                return false;
            }
            if (this.tag != null) {
                if (this.tag.equals(fetchType.tag)) {
                    return true;
                }
            } else if (fetchType.tag == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int result;
            int i = 0;
            if (this.adUnit != null) {
                result = this.adUnit.hashCode();
            } else {
                result = 0;
            }
            int i2 = result * 31;
            if (this.tag != null) {
                i = this.tag.hashCode();
            }
            return i2 + i;
        }
    }

    public MediationRequest(RequestType requestType, Activity requestingActivity, ExecutorService executorService) {
        this.DEFAULT_TIMEOUT = Integer.valueOf(1500);
        this.timeoutMilli = this.DEFAULT_TIMEOUT;
        this.startedAt = 0;
        this.displayEventStream = EventStream.create();
        this.clickEventStream = EventStream.create();
        this.closeListener = SettableFuture.create();
        this.incentiveListener = SettableFuture.create();
        this.requestType = requestType;
        this.requestingActivity = requestingActivity;
        this.startedAt = System.currentTimeMillis();
        this.incentivizedInfo = "";
    }

    public MediationRequest(AdUnit adUnit, String tag, Activity requestingActivity, ExecutorService executorService) {
        if (tag == null) {
            tag = Constants.DEFAULT_TAG;
        }
        this(new RequestType(adUnit, tag), requestingActivity, executorService);
    }

    public MediationRequest(AdUnit adUnit, String tag, Activity requestingActivity) {
        this(adUnit, tag, requestingActivity, null);
    }

    public AdUnit getAdUnit() {
        return getRequestType().getAdUnit();
    }

    public void setIncentivizedInfo(String info) {
        this.incentivizedInfo = info;
    }

    public String getIncentivizedInfo() {
        return this.incentivizedInfo;
    }

    public String getTag() {
        return getRequestType().getTag();
    }

    public RequestType getRequestType() {
        return this.requestType;
    }

    public Long getTimeStartedAt() {
        return Long.valueOf(this.startedAt);
    }

    public void setTimeoutMilli(int timeoutMilli) {
        this.timeoutMilli = Integer.valueOf(timeoutMilli);
    }

    public Boolean isTimedOut() {
        if (isStarted().booleanValue()) {
            return Utils.isExpired(Long.valueOf(this.startedAt), this.timeoutMilli);
        }
        return Boolean.valueOf(false);
    }

    public Boolean isStarted() {
        return Boolean.valueOf(this.startedAt > 0);
    }

    public long getRemainingTtl() {
        return Math.max(0, ((long) this.timeoutMilli.intValue()) - (System.currentTimeMillis() - this.startedAt));
    }

    public void addDisplay(AdDisplay display) {
        EventStream.bind(display.displayEventStream, this.displayEventStream, this.executorService);
        EventStream.bind(display.clickEventStream, this.clickEventStream, this.executorService);
        FutureUtils.bind(display.closeListener, this.closeListener, this.executorService);
        FutureUtils.bind(display.incentiveListener, this.incentiveListener, this.executorService);
    }

    public void sendDisplayFailed(String errorMessage) {
        this.displayEventStream.sendEvent(new DisplayResult(errorMessage));
    }

    public void addDisplayEventListener(EventListener<DisplayResult> listener) {
        this.displayEventStream.addListener(listener, this.executorService);
    }

    public void addClickEventListener(EventListener<Boolean> listener) {
        this.clickEventStream.addListener(listener, this.executorService);
    }

    public Activity getRequestingActivity() {
        return this.requestingActivity;
    }

    @Nullable
    public String getNetwork() {
        return this.network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return ((MediationRequest) o).equals(getRequestType());
    }

    public int hashCode() {
        return getRequestType().hashCode();
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public BannerOptions getBannerOptions() {
        return this.bannerOptions;
    }

    public void setBannerOptions(BannerOptions bannerOptions) {
        this.bannerOptions = bannerOptions;
    }

    public NativeAdOptions getNativeAdOptions() {
        return this.nativeAdOptions;
    }

    public void setNativeAdOptions(NativeAdOptions nativeAdOptions) {
        this.nativeAdOptions = nativeAdOptions;
    }
}
