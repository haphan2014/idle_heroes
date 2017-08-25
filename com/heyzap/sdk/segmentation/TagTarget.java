package com.heyzap.sdk.segmentation;

import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchOptions;
import java.util.Collection;

public class TagTarget implements SegmentTarget {
    private final Collection<String> allowedTags;

    public TagTarget(Collection<String> allowedTags) {
        this.allowedTags = allowedTags;
    }

    public boolean check(FetchOptions options) {
        boolean containsTag = false;
        for (String tag : this.allowedTags) {
            if (options.getTags().contains(tag)) {
                containsTag = true;
            }
        }
        return containsTag;
    }

    public boolean check(DisplayOptions options) {
        return this.allowedTags.contains(options.getTag());
    }

    public Collection<String> getTags() {
        return this.allowedTags;
    }
}
