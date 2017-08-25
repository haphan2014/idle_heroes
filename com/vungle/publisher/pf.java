package com.vungle.publisher;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.vungle.publisher.ce.C1713b;
import com.vungle.publisher.env.AndroidDevice;
import com.vungle.publisher.env.AndroidDevice.DeviceIdStrategy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public class pf extends DeviceIdStrategy {
    @Inject
    protected Context f2872c;
    @Inject
    protected qh f2873d;
    @Inject
    protected ce f2874e;

    @Inject
    pf() {
    }

    protected final void mo4521c(final AndroidDevice androidDevice) {
        this.f2874e.m1245a(new Runnable(this) {
            final /* synthetic */ pf f2885b;

            public final void run() {
                this.f2885b.m2322d(androidDevice);
            }
        }, C1713b.deviceId);
    }

    protected final void m2322d(AndroidDevice androidDevice) {
        Object obj = !mo4522a(androidDevice) ? 1 : null;
        if (mo4523b(androidDevice) && obj != null) {
            this.f2873d.m2361a(new px());
        }
    }

    protected boolean mo4522a(AndroidDevice androidDevice) {
        return androidDevice.m1609b();
    }

    protected boolean mo4523b(AndroidDevice androidDevice) {
        boolean z = false;
        try {
            if (androidDevice.m1610b("VungleDevice")) {
                so.m2470a(3, "VungleDevice", "fetching advertising ID and ad tracking preference", null);
                Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f2872c);
                String id = advertisingIdInfo.getId();
                boolean z2 = !advertisingIdInfo.isLimitAdTrackingEnabled() ? true : z;
                so.m2470a(3, "VungleDevice", "advertising ID " + id + "; ad tracking enabled " + z2, null);
                androidDevice.f1769d = id;
                if (androidDevice.m1609b() && AndroidDevice.m1604a(androidDevice.f1770e)) {
                    androidDevice.m1612d();
                }
                androidDevice.m1613e();
                androidDevice.f1768c = z2;
            }
        } catch (Throwable e) {
            so.m2470a(5, "VungleDevice", "error fetching advertising ID and ad tracking preference", e);
        }
        try {
            z = androidDevice.m1609b();
        } catch (Throwable e2) {
            so.m2470a(5, "VungleDevice", "error verifying advertising ID", e2);
        }
        return z;
    }
}
