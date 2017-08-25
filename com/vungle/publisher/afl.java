package com.vungle.publisher;

import com.vungle.publisher.db.C1730b;
import com.vungle.publisher.db.C1731c;
import com.vungle.publisher.fu.C1771a;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.ho.C1783a;
import com.vungle.publisher.iq.C1792a;
import com.vungle.publisher.ky.C1806a;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class afl {
    @Inject
    qh f1349a;
    @Inject
    public C1730b f1350b;
    @Inject
    public C1771a f1351c;
    @Inject
    C1806a f1352d;
    @Inject
    C1783a f1353e;
    @Inject
    public xp f1354f;
    @Inject
    public pu f1355g;
    @Inject
    C1792a f1356h;
    @Inject
    C1778a f1357i;

    @Inject
    afl() {
    }

    public final void m1191a() {
        String z;
        try {
            List<db> a = this.f1350b.m1398a();
            so.m2470a(4, "VungleReport", "sending " + a.size() + " ad reports", null);
            for (db dbVar : a) {
                z = dbVar.mo4389z();
                so.m2470a(3, "VungleReport", "sending " + z, null);
                this.f1354f.m2615a(dbVar);
            }
            this.f1349a.m2361a(new aq());
        } catch (Throwable e) {
            this.f1357i.m1865a("VungleReport", "error sending " + z, e);
            dbVar.m1403a(C1731c.failed);
            dbVar.b_();
        } catch (Throwable th) {
            this.f1349a.m2361a(new aq());
        }
    }
}
