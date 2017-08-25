package com.vungle.publisher;

import com.vungle.publisher.db.C1730b;
import com.vungle.publisher.db.C1731c;
import com.vungle.publisher.gx.C1778a;
import javax.inject.Inject;

/* compiled from: vungle */
public abstract class afk<A extends cu> extends qa {
    protected A f1342a;
    protected da<?, ?, ?> f1343b;
    protected db<?, ?, ?, A> f1344c;
    @Inject
    C1730b f1345d;
    @Inject
    C1778a f1346e;
    @Inject
    afl f1347f;
    @Inject
    uy f1348g;

    protected abstract void mo4378a();

    protected final void m1187a(ak<A> akVar) {
        m1188a(akVar.mo4380a());
    }

    public final void m1188a(A a) {
        if (this.f1342a == null || !this.f1342a.m1328a((cu) a)) {
            so.m2470a(4, "VungleReport", "new ad " + a.mo4389z(), null);
            this.f1342a = a;
            this.f1344c = this.f1345d.m1396a((cu) a);
            this.f1343b = this.f1344c.m1427s();
            so.m2470a(3, "VungleReport", "current play: " + this.f1343b.toString(), null);
            mo4378a();
            return;
        }
        so.m2470a(2, "VungleReport", "same ad " + a.mo4389z(), null);
    }

    public void onEvent(bb<A> startPlayAdEvent) {
        try {
            so.m2470a(3, "VungleReport", "received play ad start", null);
            C1617z c1617z = startPlayAdEvent.f1427a;
            db dbVar = this.f1344c;
            dbVar.m1403a(C1731c.playing);
            dbVar.m1407a(c1617z.getExtras());
            boolean isIncentivized = c1617z.isIncentivized();
            dbVar.m1411b(isIncentivized);
            if (isIncentivized) {
                dbVar.m1410b(c1617z.getIncentivizedUserId());
            }
            String placement = c1617z.getPlacement();
            if (agf.m1219a(placement)) {
                dbVar.m1414c(placement);
            }
            dbVar.m1413c(Long.valueOf(startPlayAdEvent.f1301d));
            dbVar.m1322y();
        } catch (Throwable e) {
            this.f1346e.m1865a("VungleReport", "error processing ad start event", e);
        }
    }

    public void onEvent(by destroyedErrorEndPlayEvent) {
        try {
            so.m2470a(3, "VungleReport", "received destroyed ad end", null);
            m1186a(destroyedErrorEndPlayEvent.f1301d);
        } catch (Exception e) {
            so.m2470a(5, "VungleReport", "error processing destroyed ad end", null);
        }
    }

    protected final void m1189a(jt jtVar) {
        m1190a(jtVar, null);
    }

    protected final void m1190a(jt jtVar, Object obj) {
        try {
            this.f1343b.m1366a(jtVar, obj);
        } catch (Throwable e) {
            this.f1346e.m1865a("VungleReport", "error reporting event", e);
        }
    }

    protected final void m1186a(long j) {
        mo4377f();
        db dbVar = this.f1344c;
        if (dbVar == null) {
            so.m2470a(3, "VungleReport", "no current ad report", null);
        } else {
            dbVar.m1403a(C1731c.reportable);
            dbVar.m1405a(Long.valueOf(j));
            dbVar.m1322y();
        }
        this.f1347f.m1191a();
        this.f1342a = null;
        this.f1344c = null;
        this.f1343b = null;
        mo4378a();
    }
}
