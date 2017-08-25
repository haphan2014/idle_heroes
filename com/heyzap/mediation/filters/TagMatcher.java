package com.heyzap.mediation.filters;

import java.util.Collection;

class TagMatcher implements Matcher {
    private final Collection<String> tags;

    public TagMatcher(Collection<String> tags) {
        this.tags = tags;
    }

    public boolean match(FilterContext context) {
        return this.tags.contains(context.tag);
    }
}
