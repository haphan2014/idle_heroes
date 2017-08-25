package com.heyzap.mediation.filters;

import com.heyzap.common.lifecycle.AdDisplay;

interface FilterPolicy {
    boolean accept();

    void addDisplay(AdDisplay adDisplay);
}
