package com.heyzap.house.request;

import com.heyzap.house.model.AdModel;

public class DisplayCache {
    private AdModel model;

    public void set(AdModel adModel) {
        this.model = adModel;
    }

    public AdModel get() {
        return this.model;
    }

    public void clear() {
        this.model = null;
    }
}
