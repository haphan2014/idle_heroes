package com.heyzap.sdk.segmentation;

import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchOptions;
import java.util.List;

public class Segment {
    private final String name;
    private final List<SegmentRule> rules;
    private final List<SegmentTarget> targets;

    public Segment(List<SegmentRule> rules, List<SegmentTarget> targets, String name) {
        this.rules = rules;
        this.targets = targets;
        this.name = name;
    }

    public List<SegmentRule> getRules() {
        return this.rules;
    }

    public List<SegmentTarget> getTargets() {
        return this.targets;
    }

    public String getName() {
        return this.name;
    }

    public DisplayOptions transform(DisplayOptions in) {
        boolean targetingApplies = true;
        for (SegmentTarget target : this.targets) {
            targetingApplies &= target.check(in);
        }
        if (!targetingApplies) {
            return in;
        }
        DisplayOptions options = in;
        for (SegmentRule rule : this.rules) {
            if (options != null) {
                options = rule.transform(options);
            }
        }
        return options;
    }

    public FetchOptions transform(FetchOptions in) {
        boolean targetingApplies = true;
        for (SegmentTarget target : this.targets) {
            targetingApplies &= target.check(in);
        }
        if (!targetingApplies) {
            return in;
        }
        FetchOptions options = in;
        for (SegmentRule rule : this.rules) {
            if (options != null) {
                options = rule.transform(options);
            }
        }
        return options;
    }
}
