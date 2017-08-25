package com.heyzap.sdk.segmentation;

import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchOptions;

public interface SegmentRule {
    DisplayOptions transform(DisplayOptions displayOptions);

    FetchOptions transform(FetchOptions fetchOptions);

    boolean transformsFetch();
}
