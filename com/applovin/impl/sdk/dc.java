package com.applovin.impl.sdk;

class dc implements Runnable {
    final /* synthetic */ cy f643a;
    private final String f644b;
    private final cc f645c;
    private final cz f646d;

    dc(cy cyVar, cc ccVar, cz czVar) {
        this.f643a = cyVar;
        this.f644b = ccVar.m471a();
        this.f645c = ccVar;
        this.f646d = czVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r10 = this;
        r8 = 1;
        r2 = java.lang.System.currentTimeMillis();
        com.applovin.impl.sdk.C0163n.m730a();	 Catch:{ Throwable -> 0x010f }
        r0 = r10.f643a;	 Catch:{ Throwable -> 0x010f }
        r0 = r0.f631b;	 Catch:{ Throwable -> 0x010f }
        r0 = r0.m258e();	 Catch:{ Throwable -> 0x010f }
        if (r0 != 0) goto L_0x01c6;
    L_0x0015:
        r0 = r10.f643a;	 Catch:{ Throwable -> 0x010f }
        r0 = r0.f631b;	 Catch:{ Throwable -> 0x010f }
        r0 = r0.isEnabled();	 Catch:{ Throwable -> 0x010f }
        if (r0 == 0) goto L_0x00f4;
    L_0x0021:
        r0 = r10.f643a;	 Catch:{ Throwable -> 0x010f }
        r0 = r0.f632c;	 Catch:{ Throwable -> 0x010f }
        r1 = r10.f644b;	 Catch:{ Throwable -> 0x010f }
        r4 = "Task started execution...";
        r0.mo638i(r1, r4);	 Catch:{ Throwable -> 0x010f }
        r0 = r10.f645c;	 Catch:{ Throwable -> 0x010f }
        r0.run();	 Catch:{ Throwable -> 0x010f }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x010f }
        r4 = r0 - r2;
        r0 = r10.f645c;	 Catch:{ Throwable -> 0x010f }
        r0 = r0 instanceof com.applovin.impl.sdk.C0152do;	 Catch:{ Throwable -> 0x010f }
        if (r0 == 0) goto L_0x0058;
    L_0x003f:
        r0 = r10.f645c;	 Catch:{ Throwable -> 0x010f }
        r0 = (com.applovin.impl.sdk.C0152do) r0;	 Catch:{ Throwable -> 0x010f }
        r1 = com.applovin.impl.sdk.dj.m670a();	 Catch:{ Throwable -> 0x010f }
        r0 = r0.mo629e();	 Catch:{ Throwable -> 0x010f }
        r6 = r10.f643a;	 Catch:{ Throwable -> 0x010f }
        r6 = r6.f631b;	 Catch:{ Throwable -> 0x010f }
        r6 = com.applovin.impl.sdk.C0165q.m750a(r6);	 Catch:{ Throwable -> 0x010f }
        r1.m672a(r0, r4, r6);	 Catch:{ Throwable -> 0x010f }
    L_0x0058:
        r0 = r10.f643a;	 Catch:{ Throwable -> 0x010f }
        r0 = r0.f632c;	 Catch:{ Throwable -> 0x010f }
        r1 = r10.f644b;	 Catch:{ Throwable -> 0x010f }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010f }
        r6.<init>();	 Catch:{ Throwable -> 0x010f }
        r7 = "Task executed successfully in ";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x010f }
        r6 = r6.append(r4);	 Catch:{ Throwable -> 0x010f }
        r7 = "ms.";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x010f }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x010f }
        r0.mo638i(r1, r6);	 Catch:{ Throwable -> 0x010f }
        r0 = r10.f643a;	 Catch:{ Throwable -> 0x010f }
        r0 = r0.f631b;	 Catch:{ Throwable -> 0x010f }
        r0 = r0.m255b();	 Catch:{ Throwable -> 0x010f }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010f }
        r1.<init>();	 Catch:{ Throwable -> 0x010f }
        r6 = r10.f644b;	 Catch:{ Throwable -> 0x010f }
        r1 = r1.append(r6);	 Catch:{ Throwable -> 0x010f }
        r6 = "_count";
        r1 = r1.append(r6);	 Catch:{ Throwable -> 0x010f }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x010f }
        r0.m555a(r1);	 Catch:{ Throwable -> 0x010f }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x010f }
        r1.<init>();	 Catch:{ Throwable -> 0x010f }
        r6 = r10.f644b;	 Catch:{ Throwable -> 0x010f }
        r1 = r1.append(r6);	 Catch:{ Throwable -> 0x010f }
        r6 = "_time";
        r1 = r1.append(r6);	 Catch:{ Throwable -> 0x010f }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x010f }
        r0.m556a(r1, r4);	 Catch:{ Throwable -> 0x010f }
    L_0x00b6:
        r0 = r10.f643a;
        r1 = r10.f646d;
        r0 = r0.m643a(r1);
        r0 = r0 - r8;
        r2 = r10.f643a;
        r2 = r2.f632c;
        r3 = "TaskManager";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r10.f646d;
        r4 = r4.append(r5);
        r5 = " queue finished task ";
        r4 = r4.append(r5);
        r5 = r10.f645c;
        r5 = r5.m471a();
        r4 = r4.append(r5);
        r5 = " with queue size ";
        r4 = r4.append(r5);
        r0 = r4.append(r0);
        r0 = r0.toString();
        r2.mo638i(r3, r0);
    L_0x00f3:
        return;
    L_0x00f4:
        r0 = r10.f643a;	 Catch:{ Throwable -> 0x010f }
        r0 = r0.f631b;	 Catch:{ Throwable -> 0x010f }
        r0 = r0.m259f();	 Catch:{ Throwable -> 0x010f }
        if (r0 == 0) goto L_0x0179;
    L_0x0100:
        r0 = r10.f643a;	 Catch:{ Throwable -> 0x010f }
        r0 = r0.f631b;	 Catch:{ Throwable -> 0x010f }
        r0.m260g();	 Catch:{ Throwable -> 0x010f }
    L_0x0109:
        r0 = r10.f645c;	 Catch:{ Throwable -> 0x010f }
        r0.mo628b();	 Catch:{ Throwable -> 0x010f }
        goto L_0x00b6;
    L_0x010f:
        r0 = move-exception;
        r1 = r10.f643a;	 Catch:{ all -> 0x0187 }
        r1 = r1.f632c;	 Catch:{ all -> 0x0187 }
        r4 = r10.f644b;	 Catch:{ all -> 0x0187 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0187 }
        r5.<init>();	 Catch:{ all -> 0x0187 }
        r6 = "Task failed execution in ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0187 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0187 }
        r2 = r6 - r2;
        r2 = r5.append(r2);	 Catch:{ all -> 0x0187 }
        r3 = "ms.";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0187 }
        r2 = r2.toString();	 Catch:{ all -> 0x0187 }
        r1.mo637e(r4, r2, r0);	 Catch:{ all -> 0x0187 }
        r0 = r10.f643a;
        r1 = r10.f646d;
        r0 = r0.m643a(r1);
        r0 = r0 - r8;
        r2 = r10.f643a;
        r2 = r2.f632c;
        r3 = "TaskManager";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r10.f646d;
        r4 = r4.append(r5);
        r5 = " queue finished task ";
        r4 = r4.append(r5);
        r5 = r10.f645c;
        r5 = r5.m471a();
        r4 = r4.append(r5);
        r5 = " with queue size ";
        r4 = r4.append(r5);
        r0 = r4.append(r0);
        r0 = r0.toString();
        r2.mo638i(r3, r0);
        goto L_0x00f3;
    L_0x0179:
        r0 = r10.f643a;	 Catch:{ Throwable -> 0x010f }
        r0 = r0.f632c;	 Catch:{ Throwable -> 0x010f }
        r1 = r10.f644b;	 Catch:{ Throwable -> 0x010f }
        r4 = "Task not executed, SDK is disabled";
        r0.mo641w(r1, r4);	 Catch:{ Throwable -> 0x010f }
        goto L_0x0109;
    L_0x0187:
        r0 = move-exception;
        r1 = r10.f643a;
        r2 = r10.f646d;
        r2 = r1.m643a(r2);
        r2 = r2 - r8;
        r1 = r10.f643a;
        r1 = r1.f632c;
        r4 = "TaskManager";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r10.f646d;
        r5 = r5.append(r6);
        r6 = " queue finished task ";
        r5 = r5.append(r6);
        r6 = r10.f645c;
        r6 = r6.m471a();
        r5 = r5.append(r6);
        r6 = " with queue size ";
        r5 = r5.append(r6);
        r2 = r5.append(r2);
        r2 = r2.toString();
        r1.mo638i(r4, r2);
        throw r0;
    L_0x01c6:
        r0 = r10.f643a;	 Catch:{ Throwable -> 0x010f }
        r0 = r0.f632c;	 Catch:{ Throwable -> 0x010f }
        r1 = r10.f644b;	 Catch:{ Throwable -> 0x010f }
        r4 = "Task re-scheduled...";
        r0.mo638i(r1, r4);	 Catch:{ Throwable -> 0x010f }
        r0 = r10.f643a;	 Catch:{ Throwable -> 0x010f }
        r1 = r10.f645c;	 Catch:{ Throwable -> 0x010f }
        r4 = r10.f646d;	 Catch:{ Throwable -> 0x010f }
        r6 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0.m650a(r1, r4, r6);	 Catch:{ Throwable -> 0x010f }
        goto L_0x00b6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.dc.run():void");
    }
}
