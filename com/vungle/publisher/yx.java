package com.vungle.publisher;

import com.vungle.publisher.acw.C1664a;
import com.vungle.publisher.acw.C1665b;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Provider;
import org.json.JSONException;

/* compiled from: vungle */
public final class yx extends wd {
    @Inject
    C1664a f3725g;
    @Inject
    pr f3726h;
    @Inject
    qh f3727i;
    @Inject
    Provider<yo> f3728j;

    @Inject
    yx() {
    }

    protected final void mo4351c(vr vrVar, vl vlVar) throws IOException, JSONException {
        String str;
        acw com_vungle_publisher_acw = (acw) this.f3725g.m912a(m833a(vlVar.f3455a));
        Integer num = com_vungle_publisher_acw.f1067b;
        if (num != null && num.intValue() > 0) {
            ((yo) this.f3728j.get()).m1238a((long) (num.intValue() * 1000));
        }
        C1665b c1665b = com_vungle_publisher_acw.f1069d;
        if (c1665b != null) {
            switch (c1665b) {
                case all:
                    this.f3726h.m2343a(uk.values());
                    break;
                case wifi:
                    this.f3726h.m2343a(uk.wifi);
                    break;
                default:
                    so.m2470a(5, "VungleNetwork", "unhandled streaming connectivity type " + c1665b, null);
                    break;
            }
        }
        pr prVar = this.f3726h;
        boolean equals = Boolean.TRUE.equals(com_vungle_publisher_acw.f1066a);
        String str2 = "VungleConfig";
        StringBuilder stringBuilder = new StringBuilder();
        if (equals) {
            str = "enabling";
        } else {
            str = "disabling";
        }
        so.m2470a(3, str2, stringBuilder.append(str).append(" ad streaming").toString(), null);
        prVar.f2917b = equals;
        pr prVar2 = this.f3726h;
        boolean equals2 = Boolean.TRUE.equals(com_vungle_publisher_acw.f1070e);
        so.m2470a(3, "VungleConfig", "setting exception reporting enabled: " + equals2, null);
        prVar2.f2922g.edit().putBoolean(prVar2.f2920e, equals2).apply();
        Integer num2 = com_vungle_publisher_acw.f1068c;
        if (num2 == null) {
            so.m2470a(5, "VungleNetwork", "null request streaming ad timeout millis", null);
        } else {
            prVar2 = this.f3726h;
            int intValue = num2.intValue();
            so.m2470a(3, "VungleConfig", "setting streaming response timeout " + intValue + " ms", null);
            prVar2.f2919d = intValue;
        }
        this.f3727i.m2361a(new ur());
    }
}
