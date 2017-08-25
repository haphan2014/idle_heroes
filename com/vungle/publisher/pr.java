package com.vungle.publisher;

import android.content.SharedPreferences;
import com.vungle.publisher.qb.C1868a;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class pr {
    public final Map<EventListener, qj> f2916a = new HashMap();
    public boolean f2917b;
    public final Set<uk> f2918c = EnumSet.noneOf(uk.class);
    public int f2919d;
    public String f2920e = "isExceptionReportingEnabled";
    @Inject
    C1868a f2921f;
    @Inject
    public SharedPreferences f2922g;

    @Inject
    pr() {
    }

    public final void m2342a(EventListener... eventListenerArr) {
        if (eventListenerArr != null) {
            for (EventListener eventListener : eventListenerArr) {
                if (eventListener == null) {
                    so.m2470a(3, "VungleEvent", "ignoring add null event listener", null);
                } else {
                    if ((!this.f2916a.containsKey(eventListener) ? 1 : null) != null) {
                        so.m2470a(3, "VungleEvent", "adding event listener " + eventListener, null);
                        qb qbVar = (qb) this.f2921f.f2991a.get();
                        qbVar.f2992a = eventListener;
                        this.f2916a.put(eventListener, qbVar);
                        qbVar.mo4376e();
                    } else {
                        so.m2470a(3, "VungleEvent", "already added event listener " + eventListener, null);
                    }
                }
            }
        }
    }

    public final void m2341a() {
        for (qj f : this.f2916a.values()) {
            f.mo4377f();
        }
        this.f2916a.clear();
    }

    public final void m2343a(uk... ukVarArr) {
        so.m2470a(3, "VungleConfig", "setting ad streaming connectivity types " + agf.m1220b((Object[]) ukVarArr), null);
        this.f2918c.clear();
        if (ukVarArr != null) {
            for (Object obj : ukVarArr) {
                if (obj != null) {
                    this.f2918c.add(obj);
                }
            }
        }
    }

    public final boolean m2344b() {
        so.m2470a(3, "VungleConfig", "isExceptionReportingEnabled: " + this.f2922g.getBoolean(this.f2920e, false), null);
        return this.f2922g.getBoolean(this.f2920e, false);
    }
}
