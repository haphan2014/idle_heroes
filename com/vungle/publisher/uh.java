package com.vungle.publisher;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.telephony.TelephonyManager;
import com.vungle.publisher.inject.Injector;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class uh implements un {
    @Inject
    ConnectivityManager f3337a;
    @Inject
    Provider<uo> f3338b;
    @Inject
    TelephonyManager f3339c;

    @Inject
    uh() {
        Injector.m1974b().mo4534a(this);
    }

    public final uk mo4546a() {
        try {
            NetworkInfo activeNetworkInfo = this.f3337a.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            int type = activeNetworkInfo.getType();
            switch (type) {
                case 0:
                    return uk.mobile;
                case 1:
                case 6:
                    return uk.wifi;
                default:
                    so.m2470a(3, "VungleNetwork", "unknown connectivity type: " + type, null);
                    return null;
            }
        } catch (Throwable e) {
            so.m2470a(3, "VungleNetwork", "error getting connectivity type", e);
            return null;
        }
    }

    public final String mo4547b() {
        String str = null;
        try {
            str = this.f3339c.getNetworkOperatorName();
        } catch (Throwable e) {
            so.m2470a(3, "VungleNetwork", "error getting network operator", e);
        }
        return str;
    }

    @RequiresApi(api = 16)
    public final um mo4548c() {
        um umVar = um.not_applicable;
        if (VERSION.SDK_INT < 24 || this.f3337a == null || !this.f3337a.isActiveNetworkMetered()) {
            return umVar;
        }
        switch (this.f3337a.getRestrictBackgroundStatus()) {
            case 1:
                return um.disabled;
            case 2:
                return um.whitelisted;
            case 3:
                return um.enabled;
            default:
                return um.unknown;
        }
    }

    @RequiresApi(api = 16)
    public final boolean mo4549d() {
        return this.f3337a != null && this.f3337a.isActiveNetworkMetered();
    }

    public final ul mo4550e() {
        try {
            NetworkInfo activeNetworkInfo = this.f3337a != null ? this.f3337a.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                int subtype = activeNetworkInfo.getSubtype();
                if (type == 1 || type == 6) {
                    return ul.wifi;
                }
                if (type == 0) {
                    if (VERSION.SDK_INT >= 13 && subtype == 15) {
                        return ul.hspap;
                    }
                    switch (subtype) {
                        case 1:
                            return ul.gprs;
                        case 2:
                            return ul.edge;
                        case 3:
                            return ul.umts;
                        case 4:
                            return ul.cdma;
                        case 5:
                            return ul.evdo0;
                        case 6:
                            return ul.evdoA;
                        case 7:
                            return ul.rtt1x;
                        case 8:
                            return ul.hsdpa;
                        case 9:
                            return ul.hsupa;
                        case 10:
                            return ul.hspa;
                        case 11:
                            return ul.iden;
                        case 12:
                            return ul.evdoB;
                        case 13:
                            return ul.lte;
                        case 14:
                            return ul.ehrpd;
                        default:
                            return ul.unknown;
                    }
                }
            }
        } catch (Throwable e) {
            so.m2470a(3, "VungleNetwork", "error getting connectivity details", e);
        }
        return ul.unknown;
    }
}
