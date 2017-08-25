package com.vungle.publisher;

import android.location.Location;
import android.os.Build.VERSION;
import android.os.LocaleList;
import com.vungle.publisher.inject.Injector;
import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class sb implements sn {
    @Inject
    sf f3168a;

    @Inject
    sb() {
        Injector.m1974b().mo4532a(this);
    }

    public final String mo4535a() {
        String iSO3Language;
        Throwable e;
        String str = "";
        try {
            iSO3Language = Locale.getDefault().getISO3Language();
            try {
                if (VERSION.SDK_INT >= 24 && LocaleList.getDefault().size() > 0) {
                    iSO3Language = LocaleList.getDefault().get(0).toLanguageTag();
                }
            } catch (Exception e2) {
                e = e2;
                so.m2470a(5, "VungleLocation", "error getting ISO 3-letter language code", e);
                return iSO3Language;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            iSO3Language = str;
            e = th;
            so.m2470a(5, "VungleLocation", "error getting ISO 3-letter language code", e);
            return iSO3Language;
        }
        return iSO3Language;
    }

    public final Location mo4536b() {
        Location location = null;
        if (this.f3168a == null) {
            so.m2470a(3, "VungleLocation", "cannot provide detailed location - null detailed location provider", null);
        } else {
            synchronized (this) {
                location = this.f3168a.mo4538b();
            }
        }
        return location;
    }

    public final String mo4537c() {
        return TimeZone.getDefault().getID();
    }
}
