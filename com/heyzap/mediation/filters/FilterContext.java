package com.heyzap.mediation.filters;

import com.heyzap.internal.Constants.AdUnit;

public class FilterContext {
    public final AdUnit adUnit;
    public final String tag;

    public FilterContext(AdUnit adUnit, String tag) {
        this.adUnit = adUnit;
        this.tag = tag;
    }
}
