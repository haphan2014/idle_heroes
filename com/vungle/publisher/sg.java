package com.vungle.publisher;

import android.content.Context;
import android.location.Location;
import com.vungle.publisher.inject.Injector;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

/* compiled from: vungle */
public final class sg implements sf {
    boolean f3177a = true;
    boolean f3178b = true;
    @Inject
    Context f3179c;
    private final AtomicBoolean f3180d = new AtomicBoolean(false);
    private Location f3181e;
    private final sf f3182f;
    private final sf f3183g;

    @Inject
    sg() {
        sj sjVar;
        sf sfVar;
        Object obj;
        Throwable th;
        sf sfVar2 = null;
        Injector.m1974b().mo4533a(this);
        try {
            sjVar = new sj(this.f3179c);
            try {
                sfVar2 = new sk(this.f3179c);
                sfVar = sjVar;
            } catch (NoClassDefFoundError e) {
                so.m2470a(4, "VungleLocation", "GoogleLocationServicesDetailedLocationProvider not found: " + e, null);
                obj = sjVar;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                obj = sjVar;
                th = th3;
                so.m2470a(4, "VungleLocation", "error initializing detailed location providers ", th);
            }
        } catch (NoClassDefFoundError e2) {
            so.m2470a(4, "VungleLocation", "GoogleLocationClientDetailedLocationProvider not found: " + e2, null);
            sjVar = null;
        } catch (Throwable th22) {
            th = th22;
            sfVar = null;
            so.m2470a(4, "VungleLocation", "error initializing detailed location providers ", th);
            this.f3182f = sfVar;
            this.f3183g = sfVar2;
        }
        this.f3182f = sfVar;
        this.f3183g = sfVar2;
    }

    public final Location mo4538b() {
        if (this.f3180d.compareAndSet(false, true)) {
            Object obj = null;
            try {
                if (this.f3178b) {
                    obj = this.f3183g;
                    if (obj != null) {
                        this.f3181e = obj.mo4538b();
                    }
                }
            } catch (Throwable e) {
                so.m2470a(4, "VungleLocation", "permanent error obtaining detailed location " + obj, e);
                this.f3178b = false;
            } catch (Throwable e2) {
                so.m2470a(4, "VungleLocation", "error obtaining detailed location " + obj, e2);
            }
            if (this.f3177a && this.f3181e == null) {
                try {
                    sf sfVar = this.f3182f;
                    if (sfVar != null) {
                        this.f3181e = sfVar.mo4538b();
                    }
                } catch (Throwable e22) {
                    so.m2470a(4, "VungleLocation", "permanent error obtaining detailed location " + obj, e22);
                    this.f3177a = false;
                } catch (Throwable e222) {
                    so.m2470a(4, "VungleLocation", "error obtaining detailed location " + obj, e222);
                }
            }
        }
        return this.f3181e;
    }
}
