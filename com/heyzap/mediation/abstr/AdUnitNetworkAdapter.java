package com.heyzap.mediation.abstr;

import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchFailure;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.common.lifecycle.ImpressionOptions;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.Logger;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.request.MediationRequest;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AdUnitNetworkAdapter extends NetworkAdapter {
    private final Map<AdUnit, FetchFailure> lastFailureMap = new HashMap();

    protected abstract SettableFuture<FetchResult> awaitAvailability(AdUnit adUnit);

    public abstract boolean isAdUnitStarted(Collection<AdUnit> collection);

    public abstract boolean isInterstitialVideo();

    public abstract AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult);

    public abstract SettableFuture<FetchResult> startAdUnits(Collection<AdUnit> collection);

    public SettableFuture<FetchResult> awaitAvailability(DisplayOptions displayOptions) {
        if (isCapable(displayOptions)) {
            return awaitAvailability(displayOptions.getAdUnit());
        }
        SettableFuture<FetchResult> result = SettableFuture.create();
        result.set(new FetchResult(FetchFailureReason.SKIPPED, "Rejected by Segmentation"));
        return result;
    }

    public SettableFuture<FetchResult> start(final FetchOptions fetchOptions) {
        final SettableFuture<FetchResult> adUnitsStarted = SettableFuture.create();
        super.start(fetchOptions).addListener(new Runnable() {
            public void run() {
                FutureUtils.bind(AdUnitNetworkAdapter.this.startAdUnits(AdUnitNetworkAdapter.this.getAdUnits(fetchOptions)), adUnitsStarted, AdUnitNetworkAdapter.this.uiThreadExecutorService);
            }
        }, this.uiThreadExecutorService);
        return adUnitsStarted;
    }

    public boolean isReadyForFetch(FetchOptions fetchOptions) {
        return isAdUnitStarted(getAdUnits(fetchOptions));
    }

    private Set<AdUnit> getAdUnits(FetchOptions fetchOptions) {
        Set<AdUnit> adUnits = fetchOptions.getCreativeType().adUnits();
        adUnits.retainAll(fetchOptions.getAdUnits().intersect(EnumSet.allOf(AdUnit.class)));
        return adUnits;
    }

    public FetchFailure getLastFetchFailure(DisplayOptions displayOptions) {
        return (FetchFailure) this.lastFailureMap.get(displayOptions.getAdUnit());
    }

    protected void setLastFailure(AdUnit adUnit, FetchFailure failureReason) {
        this.lastFailureMap.put(adUnit, failureReason);
    }

    public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
        Logger.debug("AdUnitNetworkAdapter - " + getCanonicalName() + " - show called");
        AdDisplay adDisplay = show(mediationRequest, mediationResult);
        CreativeType creativeType = (CreativeType) displayOptions.getAdUnit().creativeTypes().iterator().next();
        if (displayOptions.getAdUnit() == AdUnit.INTERSTITIAL) {
            creativeType = isInterstitialVideo() ? CreativeType.VIDEO : CreativeType.STATIC;
        }
        adDisplay.impressionOptions = new ImpressionOptions(displayOptions.getAdUnit(), displayOptions.getTag(), getCanonicalName(), AuctionType.MONETIZATION, creativeType);
        return adDisplay;
    }

    public Double getScoreOverride(DisplayOptions displayOptions) {
        return Double.valueOf(0.0d);
    }
}
