package com.heyzap.mediation.filters;

class AnyMatcher implements Matcher {
    AnyMatcher() {
    }

    public boolean match(FilterContext context) {
        return true;
    }
}
