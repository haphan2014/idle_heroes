package com.heyzap.mediation.filters;

import com.heyzap.internal.Constants.AdUnit;

class AdUnitMatcher implements Matcher {
    private AdUnit adUnit;

    public AdUnitMatcher(AdUnit adUnit) {
        this.adUnit = adUnit;
    }

    public boolean match(FilterContext context) {
        return context.adUnit == this.adUnit;
    }
}
