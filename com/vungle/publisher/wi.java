package com.vungle.publisher;

import android.os.SystemClock;
import javax.inject.Inject;

/* compiled from: vungle */
public abstract class wi extends vm {
    protected int f802c = 10;
    protected int f803d = 5;
    int f804e;
    @Inject
    protected ce f805f;
    private int f806g = 2000;
    private int f807h = 60000;

    protected final void mo4350b(vr vrVar, vl vlVar) {
        int i;
        wx wxVar = vrVar.f3470c;
        int i2 = wxVar.f3546b;
        if (this.f802c <= 0 || i2 <= this.f802c) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            long j = wxVar.f3545a;
            if (this.f804e <= 0 || SystemClock.elapsedRealtime() - j < ((long) this.f804e)) {
                i = 0;
            } else {
                i = 1;
            }
            if (i == 0) {
                int i3 = vlVar.f3456b;
                if (vm.m832a(i3) || i3 == 601) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    i = wxVar.f3547c;
                    if (i3 == 408 || i3 == 603) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    if (i3 == 0) {
                        i = wxVar.f3547c - 1;
                        wxVar.f3547c = i;
                        if (i < 0) {
                            so.m2470a(3, "VungleNetwork", "Attempted to decrement softRetryCount < 0", null);
                            wxVar.f3547c = 0;
                        }
                        i = wxVar.f3547c;
                    }
                    if (this.f803d <= 0 || r0 <= this.f803d) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        i = agi.m1227a(i2, this.f806g, this.f807h);
                        so.m2470a(3, "VungleNetwork", "Retrying " + vrVar + " in " + (i / 1000) + " seconds", null);
                        this.f805f.m1246a(new ww(vrVar), vrVar.f3471d, (long) i);
                        return;
                    }
                }
            }
        }
        super.mo4350b(vrVar, vlVar);
    }
}
