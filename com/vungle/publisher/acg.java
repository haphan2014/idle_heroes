package com.vungle.publisher;

import com.vungle.publisher.abo.C1645a;
import com.vungle.publisher.abo.C1647b.C1643a;
import com.vungle.publisher.acm.C1654a;
import com.vungle.publisher.adk.C1672a;
import com.vungle.publisher.aef.C1652a;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class acg extends acm {

    @Singleton
    /* compiled from: vungle */
    public static class C1659a extends C1654a<acg, iq, il, ir, C1789if> {
        @Inject
        C1658a f1010g;
        @Inject
        C1672a f1011h;

        @Singleton
        /* compiled from: vungle */
        static class C1658a extends C1652a<il, ir> {
            @Inject
            C1657a f1009a;

            @Singleton
            /* compiled from: vungle */
            static class C1657a extends C1643a<ir> {
                @Inject
                C1657a() {
                }
            }

            @Inject
            C1658a() {
            }
        }

        public final /* synthetic */ abr mo4360a(db dbVar) {
            iq iqVar = (iq) dbVar;
            acg com_vungle_publisher_acg = (acg) super.mo4360a(iqVar);
            if (com_vungle_publisher_acg != null) {
                com_vungle_publisher_acg.s = ((ie) ((C1789if) iqVar.m1418h()).m1751u()).f2154c;
            }
            return com_vungle_publisher_acg;
        }

        @Inject
        C1659a() {
        }

        protected final /* bridge */ /* synthetic */ C1645a mo4361c() {
            return this.f1010g;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new acg();
        }
    }
}
