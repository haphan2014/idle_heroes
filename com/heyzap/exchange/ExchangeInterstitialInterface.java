package com.heyzap.exchange;

import android.app.Activity;
import com.heyzap.internal.Constants.AdUnit;

public interface ExchangeInterstitialInterface {
    boolean close();

    void load() throws Exception;

    void show(Activity activity, AdUnit adUnit);
}
