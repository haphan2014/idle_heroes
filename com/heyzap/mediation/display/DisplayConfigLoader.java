package com.heyzap.mediation.display;

import com.heyzap.common.concurrency.SettableFuture;

public interface DisplayConfigLoader {
    SettableFuture<DisplayConfig> consume();

    SettableFuture<DisplayConfig> peek();
}
