package com.applovin.impl.adview;

import android.content.res.Resources;

class C0141t {
    public static float m208a(Resources resources, float f) {
        return (resources.getDisplayMetrics().density * f) + 0.5f;
    }

    public static float m209b(Resources resources, float f) {
        return resources.getDisplayMetrics().scaledDensity * f;
    }
}
