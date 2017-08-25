package com.vungle.publisher;

import com.vungle.publisher.cu.C1722c;
import com.vungle.publisher.db.C1730b;
import com.vungle.publisher.ei.C1747b;
import com.vungle.publisher.gx.C1778a;
import javax.inject.Inject;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/* compiled from: vungle */
public final class aev implements Func1<dy<?>, Observable<? extends dy<?>>> {
    @Inject
    C1730b f1280a;
    @Inject
    C1778a f1281b;
    @Inject
    aey f1282c;
    @Inject
    C1747b f1283d;

    /* compiled from: vungle */
    class C16872 implements Action1<Throwable> {
        final /* synthetic */ aev f1273a;

        C16872(aev com_vungle_publisher_aev) {
            this.f1273a = com_vungle_publisher_aev;
        }

        public final /* synthetic */ void call(Object obj) {
            so.m2470a(5, "VunglePrepare", "could not prepare viewable after multiple retries", null);
        }
    }

    /* compiled from: vungle */
    class C16894 implements Action1<gr<?>> {
        final /* synthetic */ aev f1276a;

        C16894(aev com_vungle_publisher_aev) {
            this.f1276a = com_vungle_publisher_aev;
        }

        public final /* synthetic */ void call(Object obj) {
            gr grVar = (gr) obj;
            so.m2470a(3, "VunglePrepare", "viewable prepared: " + grVar.mo4409t() + ", has status: " + grVar.mo4408s(), null);
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        return m1156a((dy) obj);
    }

    @Inject
    aev() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private rx.Observable<? extends com.vungle.publisher.dy<?>> m1156a(final com.vungle.publisher.dy<?> r10) {
        /*
        r9 = this;
        r7 = 0;
        r6 = 3;
        if (r10 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "no ad to prepare ";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r1 = r10.mo4459d();
        r0 = r10.m1546f();
        r2 = r10.m1547g();
        r3 = "VunglePrepare";
        r4 = new java.lang.StringBuilder;
        r5 = "run PrepareAdRunnable. adId = ";
        r4.<init>(r5);
        r4 = r4.append(r1);
        r5 = ", adType = ";
        r4 = r4.append(r5);
        r0 = r4.append(r0);
        r0 = r0.toString();
        com.vungle.publisher.so.m2470a(r6, r3, r0, r7);
        r0 = "VunglePrepare";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ab }
        r4 = "local ad not prepared. has status: ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00ab }
        r3 = r3.append(r2);	 Catch:{ Exception -> 0x00ab }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00ab }
        r4 = 3;
        r5 = 0;
        com.vungle.publisher.so.m2470a(r4, r0, r3, r5);	 Catch:{ Exception -> 0x00ab }
        r0 = com.vungle.publisher.aev.C16916.f1279a;	 Catch:{ Exception -> 0x00ab }
        r3 = r2.ordinal();	 Catch:{ Exception -> 0x00ab }
        r0 = r0[r3];	 Catch:{ Exception -> 0x00ab }
        switch(r0) {
            case 1: goto L_0x0096;
            case 2: goto L_0x0096;
            case 3: goto L_0x00cd;
            case 4: goto L_0x00f2;
            case 5: goto L_0x011a;
            default: goto L_0x0057;
        };	 Catch:{ Exception -> 0x00ab }
    L_0x0057:
        r0 = r9.f1280a;	 Catch:{ Exception -> 0x00ab }
        r0.m1397a(r10);	 Catch:{ Exception -> 0x00ab }
        r0 = com.vungle.publisher.cu.C1722c.preparing;	 Catch:{ Exception -> 0x00ab }
        r10.mo4457a(r0);	 Catch:{ Exception -> 0x00ab }
        r10.b_();	 Catch:{ Exception -> 0x00ab }
        m1158c(r10);	 Catch:{ Exception -> 0x00ab }
        r0 = r10.f_();	 Catch:{ Exception -> 0x00ab }
        r2 = r0.size();	 Catch:{ Exception -> 0x00ab }
        if (r2 > 0) goto L_0x01bf;
    L_0x0071:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00ab }
        r0.<init>();	 Catch:{ Exception -> 0x00ab }
        r0 = rx.Observable.just(r0);	 Catch:{ Exception -> 0x00ab }
    L_0x007a:
        r2 = new com.vungle.publisher.aev$5;	 Catch:{ Exception -> 0x00ab }
        r2.<init>(r9, r10);	 Catch:{ Exception -> 0x00ab }
        r0 = r0.doOnNext(r2);	 Catch:{ Exception -> 0x00ab }
        r2 = new com.vungle.publisher.aev$3;	 Catch:{ Exception -> 0x00ab }
        r2.<init>(r9, r10);	 Catch:{ Exception -> 0x00ab }
        r0 = r0.doOnError(r2);	 Catch:{ Exception -> 0x00ab }
        r2 = new com.vungle.publisher.aev$1;	 Catch:{ Exception -> 0x00ab }
        r2.<init>(r9, r10);	 Catch:{ Exception -> 0x00ab }
        r0 = r0.flatMap(r2);	 Catch:{ Exception -> 0x00ab }
    L_0x0095:
        return r0;
    L_0x0096:
        r0 = new java.lang.RuntimeException;	 Catch:{ Exception -> 0x00ab }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ab }
        r4 = "ad status: ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00ab }
        r2 = r3.append(r2);	 Catch:{ Exception -> 0x00ab }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00ab }
        r0.<init>(r2);	 Catch:{ Exception -> 0x00ab }
        throw r0;	 Catch:{ Exception -> 0x00ab }
    L_0x00ab:
        r0 = move-exception;
        r2 = r9.f1281b;
        r3 = "VunglePrepare";
        r4 = new java.lang.StringBuilder;
        r5 = "error processing ad.id: ";
        r4.<init>(r5);
        r1 = r4.append(r1);
        r1 = r1.toString();
        r2.m1865a(r3, r1, r0);
        rx.exceptions.Exceptions.propagate(r0);
        r0 = new java.lang.RuntimeException;
        r1 = "could not prepare ad";
        r0.<init>(r1);
        throw r0;
    L_0x00cd:
        r0 = "VunglePrepare";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ab }
        r3 = "ad already ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x00ab }
        r3 = com.vungle.publisher.cu.C1722c.viewed;	 Catch:{ Exception -> 0x00ab }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00ab }
        r3 = ", recycling: ";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00ab }
        r2 = r2.append(r1);	 Catch:{ Exception -> 0x00ab }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00ab }
        r3 = 3;
        r4 = 0;
        com.vungle.publisher.so.m2470a(r3, r0, r2, r4);	 Catch:{ Exception -> 0x00ab }
        r9.m1157b(r10);	 Catch:{ Exception -> 0x00ab }
    L_0x00f2:
        r0 = "VunglePrepare";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ab }
        r3 = "ad already ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x00ab }
        r3 = com.vungle.publisher.cu.C1722c.ready;	 Catch:{ Exception -> 0x00ab }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00ab }
        r3 = ": ";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00ab }
        r2 = r2.append(r1);	 Catch:{ Exception -> 0x00ab }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00ab }
        r3 = 3;
        r4 = 0;
        com.vungle.publisher.so.m2470a(r3, r0, r2, r4);	 Catch:{ Exception -> 0x00ab }
        r0 = rx.Observable.just(r10);	 Catch:{ Exception -> 0x00ab }
        goto L_0x0095;
    L_0x011a:
        r0 = r10.mo4459d();	 Catch:{ Exception -> 0x00ab }
        r2 = r10.m1547g();	 Catch:{ Exception -> 0x00ab }
        r3 = com.vungle.publisher.cu.C1722c.failed;	 Catch:{ Exception -> 0x00ab }
        if (r2 != r3) goto L_0x0161;
    L_0x0126:
        r3 = com.vungle.publisher.cu.C1722c.preparing;	 Catch:{ Exception -> 0x00ab }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00ab }
        r6 = r10.m1550k();	 Catch:{ Exception -> 0x00ab }
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 >= 0) goto L_0x0168;
    L_0x0134:
        r4 = "VunglePrepare";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ab }
        r6 = "clock change detected; updating ad.id ";
        r5.<init>(r6);	 Catch:{ Exception -> 0x00ab }
        r0 = r5.append(r0);	 Catch:{ Exception -> 0x00ab }
        r5 = " status from ";
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x00ab }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x00ab }
        r2 = " to ";
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x00ab }
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x00ab }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00ab }
        r2 = 3;
        r5 = 0;
        com.vungle.publisher.so.m2470a(r2, r4, r0, r5);	 Catch:{ Exception -> 0x00ab }
        r10.mo4457a(r3);	 Catch:{ Exception -> 0x00ab }
    L_0x0161:
        r10.b_();	 Catch:{ Exception -> 0x00ab }
        r0 = com.vungle.publisher.cu.C1722c.failed;	 Catch:{ Exception -> 0x00ab }
        goto L_0x0057;
    L_0x0168:
        r4 = r4 - r6;
        r6 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r4 = r4 / r6;
        r6 = 1440; // 0x5a0 float:2.018E-42 double:7.115E-321;
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 < 0) goto L_0x01b7;
    L_0x0173:
        r6 = "VunglePrepare";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ab }
        r8 = "retrying ";
        r7.<init>(r8);	 Catch:{ Exception -> 0x00ab }
        r8 = com.vungle.publisher.cu.C1722c.failed;	 Catch:{ Exception -> 0x00ab }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x00ab }
        r8 = " ad.id ";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x00ab }
        r0 = r7.append(r0);	 Catch:{ Exception -> 0x00ab }
        r7 = " after ";
        r0 = r0.append(r7);	 Catch:{ Exception -> 0x00ab }
        r0 = r0.append(r4);	 Catch:{ Exception -> 0x00ab }
        r4 = "/1440 minutes; updating status from ";
        r0 = r0.append(r4);	 Catch:{ Exception -> 0x00ab }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x00ab }
        r2 = " to ";
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x00ab }
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x00ab }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00ab }
        r2 = 3;
        r4 = 0;
        com.vungle.publisher.so.m2470a(r2, r6, r0, r4);	 Catch:{ Exception -> 0x00ab }
        r10.mo4457a(r3);	 Catch:{ Exception -> 0x00ab }
        goto L_0x0161;
    L_0x01b7:
        r0 = new java.lang.RuntimeException;	 Catch:{ Exception -> 0x00ab }
        r2 = "could not update failed status";
        r0.<init>(r2);	 Catch:{ Exception -> 0x00ab }
        throw r0;	 Catch:{ Exception -> 0x00ab }
    L_0x01bf:
        r2 = rx.Observable.from(r0);	 Catch:{ Exception -> 0x00ab }
        r3 = rx.schedulers.Schedulers.io();	 Catch:{ Exception -> 0x00ab }
        r2 = r2.observeOn(r3);	 Catch:{ Exception -> 0x00ab }
        r3 = r9.f1282c;	 Catch:{ Exception -> 0x00ab }
        r2 = r2.flatMap(r3);	 Catch:{ Exception -> 0x00ab }
        r3 = new com.vungle.publisher.aev$2;	 Catch:{ Exception -> 0x00ab }
        r3.<init>(r9);	 Catch:{ Exception -> 0x00ab }
        r2 = r2.doOnError(r3);	 Catch:{ Exception -> 0x00ab }
        r3 = new com.vungle.publisher.aev$4;	 Catch:{ Exception -> 0x00ab }
        r3.<init>(r9);	 Catch:{ Exception -> 0x00ab }
        r2 = r2.doOnNext(r3);	 Catch:{ Exception -> 0x00ab }
        r0 = r0.size();	 Catch:{ Exception -> 0x00ab }
        r0 = r2.buffer(r0);	 Catch:{ Exception -> 0x00ab }
        goto L_0x007a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aev.a(com.vungle.publisher.dy):rx.Observable<? extends com.vungle.publisher.dy<?>>");
    }

    private void m1157b(dy<?> dyVar) {
        String d = dyVar.mo4459d();
        so.m2470a(3, "VunglePrepare", "re-verify prepare_retry_count " + dyVar.m1548i() + " for ad " + d, null);
        m1158c(dyVar);
        for (gr grVar : dyVar.f_()) {
            if (!grVar.mo4416i()) {
                throw new RuntimeException(grVar.mo4409t() + " re-verification failed for ad_id " + grVar.mo4407l());
            }
        }
        C1722c c1722c = C1722c.ready;
        so.m2470a(4, "VunglePrepare", "re-verified ad and set to " + c1722c + ": " + d, null);
        this.f1280a.m1397a((dy) dyVar).a_(Long.valueOf(-1));
        dyVar.mo4457a(c1722c);
        dyVar.b_();
    }

    private static void m1158c(dy<?> dyVar) {
        if (!dyVar.g_()) {
            throw new RuntimeException("invalid ad structure");
        }
    }
}
