package com.heyzap.exchange;

import android.app.Activity;
import android.support.annotation.Nullable;
import com.facebook.AppEventsConstants;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.internal.ContextReference;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ExchangeAd extends AdDisplay {
    protected String adId;
    private long createdAt;
    AtomicBoolean displayReportBound;
    protected long expiry;
    public final SettableFuture<Boolean> expiryListener;
    protected String extraData;
    public final SettableFuture<FetchResult> fetchListener;
    protected String markup;
    ExchangeRequestParams params;
    protected ContextReference ref;
    protected boolean refetchOnExpiry;
    protected String score;
    protected String url;

    public abstract void load();

    public abstract boolean onBackPressed();

    public abstract void show(Activity activity);

    public ExchangeAd(ContextReference ref) {
        this.extraData = "";
        this.expiry = 0;
        this.refetchOnExpiry = false;
        this.fetchListener = SettableFuture.create();
        this.expiryListener = SettableFuture.create();
        this.displayReportBound = new AtomicBoolean(false);
        this.markup = null;
        this.url = null;
        this.adId = null;
        this.score = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.extraData = null;
        this.params = null;
        this.ref = ref;
        this.expiry = -1;
        this.refetchOnExpiry = false;
        this.createdAt = System.currentTimeMillis();
    }

    public ExchangeAd(String markup, String url, String adId, String score, long expiry, boolean refetchOnExpiry, String extraData, ExchangeRequestParams params, ContextReference ref) {
        this.extraData = "";
        this.expiry = 0;
        this.refetchOnExpiry = false;
        this.fetchListener = SettableFuture.create();
        this.expiryListener = SettableFuture.create();
        this.displayReportBound = new AtomicBoolean(false);
        this.markup = markup;
        this.url = url;
        this.adId = adId;
        this.score = score;
        this.extraData = extraData;
        this.params = params;
        this.ref = ref;
        this.expiry = expiry;
        this.refetchOnExpiry = refetchOnExpiry;
        this.createdAt = System.currentTimeMillis();
    }

    public void setRequestParams(ExchangeRequestParams params) {
        this.params = params;
    }

    public ExchangeRequestParams getRequestParams() {
        return this.params;
    }

    public String getAuctionData() {
        return this.extraData;
    }

    public String getMarkup() {
        return this.markup;
    }

    public String getUrl() {
        return this.url;
    }

    public String getAdId() {
        return this.adId;
    }

    public double getScore() {
        return Double.parseDouble(this.score);
    }

    public boolean getRefetchOnExpiry() {
        return this.refetchOnExpiry;
    }

    public Long getExpiry() {
        return Long.valueOf(this.expiry);
    }

    @Nullable
    public Long getTtl() {
        if (this.expiry <= 0) {
            return null;
        }
        return Long.valueOf((this.createdAt + (this.expiry * 1000)) - System.currentTimeMillis());
    }

    public void onExpired() {
        this.expiryListener.set(Boolean.valueOf(true));
    }

    public boolean setDisplayReportBound() {
        return this.displayReportBound.compareAndSet(false, true);
    }
}
