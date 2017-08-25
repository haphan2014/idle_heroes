package com.heyzap.sdk.segmentation;

import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchOptions;

public interface SegmentTarget {
    boolean check(DisplayOptions displayOptions);

    boolean check(FetchOptions fetchOptions);
}
