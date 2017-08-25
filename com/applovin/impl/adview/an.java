package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class an extends C0122u {
    private float f158c = BitmapDescriptorFactory.HUE_ORANGE;
    private float f159d = TextTrackStyle.DEFAULT_FONT_SCALE;

    public an(AppLovinSdk appLovinSdk, Context context) {
        super(appLovinSdk, context);
    }

    public void m149a(float f) {
        this.f159d = f;
    }

    public void mo547a(int i) {
        m149a(((float) i) / this.f158c);
    }
}
