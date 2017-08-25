package com.heyzap.mediation.filters;

import com.heyzap.common.lifecycle.AdDisplay;

class RejectFilterPolicy implements FilterPolicy {
    public boolean accept() {
        return false;
    }

    public void addDisplay(AdDisplay adDisplay) {
    }
}
