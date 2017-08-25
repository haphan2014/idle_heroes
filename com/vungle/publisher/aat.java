package com.vungle.publisher;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.games.Games;
import com.vungle.publisher.C1707b.C1706a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public abstract class aat extends aar {
    protected String f891a;
    protected String f892b;
    protected C1631a f893c;
    protected C1636b f894d;
    protected Boolean f895e;
    protected String f896f;

    /* compiled from: vungle */
    public static class C1631a extends aar {
        protected Integer f853a;
        protected C1706a f854b;
        protected C1630b f855c;

        @Singleton
        /* compiled from: vungle */
        public static class C1628a extends abj<C1631a> {
            @Inject
            Context f844a;
            @Inject
            protected C1707b f845b;
            @Inject
            protected C1629a f846c;

            @javax.inject.Inject
            C1628a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.a.<init>():void");
            }

            protected final com.vungle.publisher.aat.C1631a m864a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f845b;
                r1 = new com.vungle.publisher.aat$a;
                r1.<init>();
                r2 = r0.f1425a;
                r1.f853a = r2;
                r0 = r0.f1426b;
                r1.f854b = r0;
                r0 = r3.f844a;
                r2 = "android.permission.ACCESS_FINE_LOCATION";
                r0 = r0.checkCallingOrSelfPermission(r2);
                if (r0 != 0) goto L_0x0025;
            L_0x0019:
                r0 = 1;
            L_0x001a:
                if (r0 == 0) goto L_0x0024;
            L_0x001c:
                r0 = r3.f846c;
                r0 = r0.m867a();
                r1.f855c = r0;
            L_0x0024:
                return r1;
            L_0x0025:
                r0 = 0;
                goto L_0x001a;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.a.a():com.vungle.publisher.aat$a");
            }

            protected final /* synthetic */ java.lang.Object mo4354b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = new com.vungle.publisher.aat$a;
                r0.<init>();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.a.b():java.lang.Object");
            }

            protected final /* bridge */ /* synthetic */ java.lang.Object[] mo4353a(int r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = new com.vungle.publisher.aat.C1631a[r2];
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.a.a(int):java.lang.Object[]");
            }
        }

        /* compiled from: vungle */
        public static class C1630b extends aar {
            protected Float f848a;
            protected Double f849b;
            protected Double f850c;
            protected Float f851d;
            protected Long f852e;

            @Singleton
            /* compiled from: vungle */
            public static class C1629a extends abj<C1630b> {
                @Inject
                sn f847a;

                @javax.inject.Inject
                C1629a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.b.a.<init>():void");
                }

                protected final com.vungle.publisher.aat.C1631a.C1630b m867a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r0 = 0;
                    r1 = r4.f847a;
                    r1 = r1.mo4536b();
                    if (r1 != 0) goto L_0x0012;
                L_0x0009:
                    r1 = "VungleProtocol";
                    r2 = "detailed location not available";
                    r3 = 3;
                    com.vungle.publisher.so.m2470a(r3, r1, r2, r0);
                L_0x0011:
                    return r0;
                L_0x0012:
                    r0 = new com.vungle.publisher.aat$a$b;
                    r0.<init>();
                    r2 = r1.getAccuracy();
                    r2 = java.lang.Float.valueOf(r2);
                    r0.f848a = r2;
                    r2 = r1.getLatitude();
                    r2 = java.lang.Double.valueOf(r2);
                    r0.f849b = r2;
                    r2 = r1.getLongitude();
                    r2 = java.lang.Double.valueOf(r2);
                    r0.f850c = r2;
                    r2 = r1.getSpeed();
                    r2 = java.lang.Float.valueOf(r2);
                    r0.f851d = r2;
                    r2 = r1.getTime();
                    r1 = java.lang.Long.valueOf(r2);
                    r0.f852e = r1;
                    goto L_0x0011;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.b.a.a():com.vungle.publisher.aat$a$b");
                }

                protected final /* synthetic */ java.lang.Object mo4354b() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = new com.vungle.publisher.aat$a$b;
                    r0.<init>();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.b.a.b():java.lang.Object");
                }

                protected final /* bridge */ /* synthetic */ java.lang.Object[] mo4353a(int r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = new com.vungle.publisher.aat.C1631a.C1630b[r2];
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.b.a.a(int):java.lang.Object[]");
                }
            }

            public final /* synthetic */ java.lang.Object mo4352b() throws org.json.JSONException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.mo4355a();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.b.b():java.lang.Object");
            }

            protected C1630b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.b.<init>():void");
            }

            public final org.json.JSONObject mo4355a() throws org.json.JSONException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = super.mo4355a();
                r1 = "accuracyMeters";
                r2 = r3.f848a;
                r0.putOpt(r1, r2);
                r1 = "lat";
                r2 = r3.f849b;
                r0.putOpt(r1, r2);
                r1 = "long";
                r2 = r3.f850c;
                r0.putOpt(r1, r2);
                r1 = "speedMetersPerSecond";
                r2 = r3.f851d;
                r0.putOpt(r1, r2);
                r1 = "timestampMillis";
                r2 = r3.f852e;
                r0.putOpt(r1, r2);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.b.a():org.json.JSONObject");
            }
        }

        public final /* synthetic */ java.lang.Object mo4352b() throws org.json.JSONException {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.mo4355a();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.b():java.lang.Object");
        }

        protected C1631a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r0.<init>();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.<init>():void");
        }

        public final org.json.JSONObject mo4355a() throws org.json.JSONException {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = super.mo4355a();
            r1 = "age";
            r2 = r3.f853a;
            r0.putOpt(r1, r2);
            r1 = "gender";
            r2 = r3.f854b;
            r0.putOpt(r1, r2);
            r1 = "location";
            r2 = r3.f855c;
            r2 = com.vungle.publisher.sa.m2427a(r2);
            r0.putOpt(r1, r2);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.a.a():org.json.JSONObject");
        }
    }

    /* compiled from: vungle */
    public static class C1636b extends aar {
        protected uk f869a;
        protected String f870b;
        protected String f871c;
        protected Float f872d;
        protected String f873e;
        protected Boolean f874f;
        protected Boolean f875g;
        protected C1633a f876h;
        protected Boolean f877i;
        protected Boolean f878j;
        protected String f879k;
        protected String f880l;
        protected String f881m;
        protected C1635c f882n;
        protected Float f883o;
        protected String f884p;
        protected Long f885q;

        /* compiled from: vungle */
        public static class C1633a extends aar {
            protected Integer f857a;
            protected Integer f858b;

            @Singleton
            /* compiled from: vungle */
            public static class C1632a extends abj<C1633a> {
                @Inject
                protected pj f856a;

                @javax.inject.Inject
                C1632a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.aat.b.a.a.<init>():void");
                }

                protected final C1633a m874a() {
                    DisplayMetrics h = this.f856a.mo4428h();
                    if (h.heightPixels <= 0 && h.widthPixels <= 0) {
                        return null;
                    }
                    C1633a c1633a = new C1633a();
                    c1633a.f857a = Integer.valueOf(h.heightPixels);
                    c1633a.f858b = Integer.valueOf(h.widthPixels);
                    return c1633a;
                }

                protected final /* synthetic */ Object mo4354b() {
                    return new C1633a();
                }

                protected final /* bridge */ /* synthetic */ Object[] mo4353a(int i) {
                    return new C1633a[r2];
                }
            }

            public final /* synthetic */ Object mo4352b() throws JSONException {
                return mo4355a();
            }

            protected C1633a() {
            }

            public final JSONObject mo4355a() throws JSONException {
                JSONObject a = super.mo4355a();
                a.putOpt("height", this.f857a);
                a.putOpt("width", this.f858b);
                return a;
            }
        }

        @Singleton
        /* compiled from: vungle */
        public static class C1634b extends abj<C1636b> {
            @Inject
            Context f859a;
            @Inject
            protected AdConfig f860b;
            @Inject
            protected pj f861c;
            @Inject
            protected C1632a f862d;
            @Inject
            protected un f863e;
            @Inject
            protected pq f864f;
            private PowerManager f865g;
            private Intent f866h;

            @Inject
            C1634b() {
            }

            protected final C1636b m879a() {
                C1636b c1636b = new C1636b();
                ul e = this.f863e.mo4550e();
                c1636b.f869a = e.f3369s;
                c1636b.f870b = e.f3368r;
                c1636b.f876h = this.f862d.m874a();
                c1636b.f877i = Boolean.valueOf(this.f861c.mo4432l());
                c1636b.f878j = Boolean.valueOf(this.f860b.isSoundEnabled());
                c1636b.f879k = this.f861c.mo4430j();
                c1636b.f880l = this.f863e.mo4547b();
                c1636b.f881m = this.f861c.mo4427g();
                c1636b.f882n = C1635c.f867a;
                c1636b.f883o = this.f861c.mo4431k();
                c1636b.f884p = this.f861c.mo4436p();
                c1636b.f885q = this.f861c.mo4437q();
                if (VERSION.SDK_INT >= 16) {
                    c1636b.f875g = Boolean.valueOf(this.f863e.mo4549d());
                    c1636b.f871c = this.f863e.mo4548c().f3376f;
                }
                try {
                    if (this.f859a != null) {
                        if (VERSION.SDK_INT >= 21) {
                            this.f865g = (PowerManager) this.f859a.getSystemService("power");
                            c1636b.f874f = Boolean.valueOf(this.f865g.isPowerSaveMode());
                        }
                        if (this.f866h == null) {
                            this.f866h = this.f859a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                        }
                        if (this.f866h != null) {
                            mf mfVar;
                            int intExtra = this.f866h.getIntExtra(Games.EXTRA_STATUS, -1);
                            if (intExtra == 2 || intExtra == 5) {
                                switch (this.f866h.getIntExtra("plugged", -1)) {
                                    case 1:
                                        mfVar = mf.f2563d;
                                        break;
                                    case 2:
                                        mfVar = mf.f2562c;
                                        break;
                                    case 4:
                                        mfVar = mf.f2564e;
                                        break;
                                    default:
                                        mfVar = mf.f2565f;
                                        break;
                                }
                            }
                            mfVar = mf.f2561b;
                            c1636b.f873e = mfVar.toString();
                            intExtra = this.f866h.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1);
                            int intExtra2 = this.f866h.getIntExtra("scale", -1);
                            if (intExtra > 0 && intExtra2 > 0) {
                                c1636b.f872d = Float.valueOf(((float) intExtra) / ((float) intExtra2));
                            }
                        }
                    }
                } catch (
/*
Method generation error in method: com.vungle.publisher.aat.b.b.a():com.vungle.publisher.aat$b
java.lang.NullPointerException
	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:126)
	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:310)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:288)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:241)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:241)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)

*/

                protected final /* synthetic */ Object mo4354b() {
                    return new C1636b();
                }

                protected final /* bridge */ /* synthetic */ Object[] mo4353a(int i) {
                    return new C1636b[r2];
                }
            }

            /* compiled from: vungle */
            public enum C1635c {
                ;

                private C1635c(String str) {
                }
            }

            public final /* synthetic */ Object mo4352b() throws JSONException {
                return mo4355a();
            }

            protected C1636b() {
            }

            public final JSONObject mo4355a() throws JSONException {
                Object obj;
                JSONObject a = super.mo4355a();
                a.putOpt("connection", this.f869a);
                a.putOpt("connectionDetail", this.f870b);
                a.putOpt("dataSaverStatus", this.f871c);
                a.putOpt("isNetworkMetered", this.f875g);
                a.putOpt("batteryLevel", this.f872d);
                a.putOpt("batteryState", this.f873e);
                a.putOpt("isBatterySaverEnabled", this.f874f);
                a.putOpt("dim", sa.m2427a(this.f876h));
                String str = "isSdCardAvailable";
                Boolean bool = this.f877i;
                if (bool == null) {
                    obj = null;
                } else {
                    obj = Integer.valueOf(bool.booleanValue() ? 1 : 0);
                }
                a.putOpt(str, obj);
                a.putOpt("soundEnabled", this.f878j);
                a.putOpt("model", this.f879k);
                a.putOpt("networkOperator", this.f880l);
                a.putOpt("osVersion", this.f881m);
                a.putOpt("platform", this.f882n);
                a.putOpt("volume", this.f883o);
                a.putOpt("userAgent", this.f884p);
                a.putOpt("bytesAvailable", this.f885q);
                return a;
            }
        }

        /* compiled from: vungle */
        public static abstract class C1637c<T extends aat> extends abj<T> {
            @Inject
            protected C1628a f886a;
            @Inject
            pj f887b;
            @Inject
            pr f888c;
            @Inject
            protected C1634b f889d;
            @Inject
            protected pq f890e;

            protected T mo4362a() {
                aat com_vungle_publisher_aat = (aat) mo4354b();
                com_vungle_publisher_aat.f891a = this.f887b.mo4426c();
                com_vungle_publisher_aat.f892b = this.f887b.mo4423a();
                com_vungle_publisher_aat.f893c = this.f886a.m864a();
                com_vungle_publisher_aat.f894d = this.f889d.m879a();
                com_vungle_publisher_aat.f895e = Boolean.valueOf(this.f887b.mo4429i());
                com_vungle_publisher_aat.f896f = this.f890e.mo4525b();
                return com_vungle_publisher_aat;
            }
        }

        public /* synthetic */ Object mo4352b() throws JSONException {
            return mo4355a();
        }

        public JSONObject mo4355a() throws JSONException {
            JSONObject a = super.mo4355a();
            a.putOpt("isu", this.f891a);
            a.putOpt("ifa", this.f892b);
            a.putOpt("demo", sa.m2427a(this.f893c));
            a.putOpt("deviceInfo", sa.m2427a(this.f894d));
            a.putOpt("adTrackingEnabled", this.f895e);
            a.putOpt("pubAppId", this.f896f);
            return a;
        }
    }
