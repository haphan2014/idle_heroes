package com.heyzap.common.banner;

import android.view.View;

public interface BannerWrapper {

    public interface OnSizeChangeListener {
        void onSizeChange(int i, int i2);
    }

    boolean destroyBanner(boolean z);

    int getAdHeight();

    int getAdWidth();

    View getRealBannerView();

    void setSizeChangeListener(OnSizeChangeListener onSizeChangeListener);
}
