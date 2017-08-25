package com.heyzap.mediation.filters;

import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Logger;
import com.heyzap.mediation.MediationResult.NetworkResult;
import com.heyzap.mediation.request.MediationRequest;
import java.util.concurrent.ExecutorService;

public class InterstitialVideoTracker {
    private final ExecutorService executorService;
    private long lastInterstitialVideoAt = 0;

    public InterstitialVideoTracker(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public boolean interstitialCooldownExpired(int interstitialVideoInterval) {
        return this.lastInterstitialVideoAt + ((long) interstitialVideoInterval) < System.currentTimeMillis();
    }

    public void addDisplay(MediationRequest request, NetworkResult networkResult, final AdDisplay display) {
        if (networkResult.creativeType == CreativeType.VIDEO && AdUnit.INTERSTITIAL.equals(request.getAdUnit())) {
            display.displayEventStream.getFirstEventFuture().addListener(new Runnable() {
                public void run() {
                    try {
                        if (((DisplayResult) display.displayEventStream.getFirstEventFuture().get()).success) {
                            InterstitialVideoTracker.this.lastInterstitialVideoAt = System.currentTimeMillis();
                        }
                    } catch (Throwable e) {
                        Logger.trace(e);
                    } catch (Throwable e2) {
                        Logger.trace(e2);
                    }
                }
            }, this.executorService);
        }
    }
}
