package com.vungle.publisher.inject;

import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.ra;
import com.vungle.publisher.rv;
import com.vungle.publisher.ry;
import com.vungle.publisher.so;

/* compiled from: vungle */
public class Injector {
    private static Injector f2180d;
    public EndpointModule f2181a;
    public rv f2182b;
    public ry f2183c;
    private ra f2184e;

    public static synchronized Injector getInstance() {
        Injector injector;
        synchronized (Injector.class) {
            if (f2180d == null) {
                f2180d = new Injector();
            }
            injector = f2180d;
        }
        return injector;
    }

    private Injector() {
    }

    public void setWrapperFramework(WrapperFramework wrapperFramework) {
        try {
            if (m1976c()) {
                so.m2470a(3, "VungleInject", "wrapper framework in injector NOT set - already initialized", null);
                return;
            }
            so.m2470a(3, "VungleInject", "setting wrapper framework in injector: " + wrapperFramework, null);
            ra a = m1975a();
            if (a.f3049g) {
                so.m2470a(3, "VungleInject", "wrapper framework in publisher module NOT set - already initialized", null);
                return;
            }
            so.m2470a(3, "VungleInject", "setting framework in publisher module: " + wrapperFramework, null);
            a.f3047e = wrapperFramework;
        } catch (Throwable e) {
            so.m2470a(6, "VungleInject", null, e);
        }
    }

    public void setWrapperFrameworkVersion(String wrapperFrameworkVersion) {
        try {
            if (m1976c()) {
                so.m2470a(3, "VungleInject", "wrapper framework version in injector NOT set - already initialized", null);
                return;
            }
            so.m2470a(3, "VungleInject", "setting wrapper framework version in injector: " + wrapperFrameworkVersion, null);
            ra a = m1975a();
            if (a.f3049g) {
                so.m2470a(3, "VungleInject", "wrapper framework version in publisher module NOT set - already initialized", null);
                return;
            }
            so.m2470a(3, "VungleInject", "setting framework in publisher module: " + wrapperFrameworkVersion, null);
            a.f3048f = wrapperFrameworkVersion;
        } catch (Throwable e) {
            so.m2470a(6, "VungleInject", null, e);
        }
    }

    public final ra m1975a() {
        if (this.f2184e == null) {
            this.f2184e = new ra();
        }
        return this.f2184e;
    }

    public Injector setEndpointModule(EndpointModule endpointModule) {
        this.f2181a = endpointModule;
        return this;
    }

    public static ry m1974b() {
        return getInstance().f2183c;
    }

    public final boolean m1976c() {
        return getInstance().f2183c != null && m1975a().f3049g;
    }
}
