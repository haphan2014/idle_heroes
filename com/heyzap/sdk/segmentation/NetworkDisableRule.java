package com.heyzap.sdk.segmentation;

import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchOptions;
import java.util.List;

public class NetworkDisableRule implements SegmentRule {
    private List<String> disabledNetworks;

    public NetworkDisableRule(List<String> disabledNetworks) {
        this.disabledNetworks = disabledNetworks;
    }

    public FetchOptions transform(FetchOptions options) {
        return options;
    }

    public DisplayOptions transform(DisplayOptions options) {
        options.getNetworks().removeAll(this.disabledNetworks);
        return options;
    }

    public boolean transformsFetch() {
        return false;
    }
}
