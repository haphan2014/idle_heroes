package com.heyzap.mediation.config;

import com.heyzap.common.concurrency.ListenableFuture;

public interface ConfigLoader {

    public interface MediationConfigListener {
        void onConfigLoaded(MediationConfig mediationConfig);
    }

    void get(MediationConfigListener mediationConfigListener);

    ListenableFuture<MediationConfig> getFuture();

    void start();
}
