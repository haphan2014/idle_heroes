package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import com.applovin.sdk.AppLovinSdk;

public abstract class C0122u extends View {
    protected final AppLovinSdk f156a;
    protected final Context f157b;

    C0122u(AppLovinSdk appLovinSdk, Context context) {
        super(context);
        this.f157b = context;
        this.f156a = appLovinSdk;
    }

    public static C0122u m147a(AppLovinSdk appLovinSdk, Context context, C0142v c0142v) {
        return c0142v.equals(C0142v.Invisible) ? new an(appLovinSdk, context) : c0142v.equals(C0142v.WhiteXOnTransparentGrey) ? new ao(appLovinSdk, context) : new at(appLovinSdk, context);
    }

    public abstract void mo547a(int i);
}
