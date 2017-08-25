package com.vungle.publisher;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import com.vungle.publisher.env.AndroidDevice;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class pc extends pf {
    @Inject
    Context f2875a;
    @Inject
    WifiManager f2876b;

    @Inject
    pc() {
    }

    protected final boolean mo4522a(AndroidDevice androidDevice) {
        return androidDevice.m1614f();
    }

    protected final boolean mo4523b(AndroidDevice androidDevice) {
        try {
            boolean b = super.mo4523b(androidDevice);
            if (b) {
                so.m2470a(2, "VungleDevice", "have advertising ID - not fetching fallback device IDs", null);
                return b;
            }
            so.m2470a(3, "VungleDevice", "ensuring fallback device IDs", null);
            if (AndroidDevice.m1604a(androidDevice.f1770e)) {
                so.m2470a(2, "VungleDevice", "existing android ID " + androidDevice.mo4426c(), null);
            } else {
                String string = Secure.getString(this.f2875a.getContentResolver(), "android_id");
                so.m2470a(3, "VungleDevice", "fetched android ID " + string, null);
                if (androidDevice.m1609b()) {
                    so.m2470a(5, "VungleDevice", "have advertising id - not setting androidId", null);
                } else {
                    so.m2470a(3, "VungleDevice", "setting android ID " + string, null);
                    androidDevice.f1770e = string;
                    androidDevice.m1613e();
                }
            }
            return true;
        } catch (Throwable e) {
            so.m2470a(5, "VungleDevice", null, e);
            return androidDevice.m1614f();
        }
    }
}
