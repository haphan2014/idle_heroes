package com.heyzap.mediation.display;

import com.heyzap.common.concurrency.ListenableFuture;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.display.DisplayConfig.Network;
import com.heyzap.mediation.request.MediationRequest;

public interface Mediator {

    public static class NetworkWrapper {
        public final DisplayOptions displayOptions;
        public final SettableFuture<FetchResult> fetchResultFuture;
        public final NetworkAdapter networkAdapter;
        public final Network networkConfig;
        public boolean rejected = false;
        public String rejectionCause;

        NetworkWrapper(SettableFuture<FetchResult> fetchResultFuture, NetworkAdapter networkAdapter, Network networkConfig, DisplayOptions displayOptions) {
            this.fetchResultFuture = fetchResultFuture;
            this.networkAdapter = networkAdapter;
            this.networkConfig = networkConfig;
            this.displayOptions = displayOptions;
        }

        public String getRejectionCause() {
            return this.rejectionCause;
        }

        void setRejected(String cause) {
            this.rejected = true;
            this.rejectionCause = cause;
        }
    }

    ListenableFuture<MediationResult> mediate(MediationRequest mediationRequest);
}
