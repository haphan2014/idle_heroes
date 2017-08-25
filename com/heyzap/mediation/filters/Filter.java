package com.heyzap.mediation.filters;

class Filter {
    public final Matcher matcher;
    public final FilterPolicy policy;

    public Filter(Matcher matcher, FilterPolicy policy) {
        this.matcher = matcher;
        this.policy = policy;
    }
}
