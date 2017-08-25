package com.vungle.publisher;

import com.vungle.publisher.ade.C1670a;
import com.vungle.publisher.adh.C1671a;
import com.vungle.publisher.ads.C1676a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONObject;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

/* compiled from: vungle */
public final class afg {

    @Singleton
    /* compiled from: vungle */
    public static class C1700a implements Func1<Object, Boolean> {
        @Inject
        C1700a() {
        }

        public final /* synthetic */ Object call(Object obj) {
            boolean z;
            if (obj != null) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    @Singleton
    /* compiled from: vungle */
    public static class C1702b implements Func1<acs, Observable<acr>> {
        @Inject
        C1670a f1329a;
        @Inject
        C1671a f1330b;
        @Inject
        C1676a f1331c;

        public final /* synthetic */ Object call(Object obj) {
            Object obj2 = null;
            acs com_vungle_publisher_acs = (acs) obj;
            boolean z = com_vungle_publisher_acs.f1054k;
            C1893v c1893v = com_vungle_publisher_acs.f1046e;
            if (z) {
                Object obj3;
                if (com_vungle_publisher_acs.f1044c.longValue() * 1000 < System.currentTimeMillis()) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (obj3 != null) {
                    so.m2470a(4, "VunglePrepare", "received expired ad from server, tossing it and getting a new one", null);
                    throw new RuntimeException("ad is expired");
                } else if (c1893v == null) {
                    so.m2470a(5, "VunglePrepare", "received null adType from server, tossing it and getting a new one", null);
                    throw new RuntimeException("adType is null");
                } else {
                    so.m2470a(2, "VunglePrepare", "received a valid ad, continue processing ad with type: " + c1893v, null);
                    final JSONObject jSONObject = com_vungle_publisher_acs.f1055l;
                    obj2 = (acr) new aa<acr>(this) {
                        final /* synthetic */ C1702b f1328b;

                        protected final /* synthetic */ Object mo4372a() {
                            return m1169e();
                        }

                        protected final /* synthetic */ Object mo4374c() {
                            return m1170f();
                        }

                        protected final /* synthetic */ Object mo4375d() {
                            return m1171g();
                        }

                        private acr m1169e() {
                            try {
                                return this.f1328b.f1329a.m1048b(jSONObject);
                            } catch (Throwable e) {
                                throw Exceptions.propagate(e);
                            }
                        }

                        private acr m1170f() {
                            try {
                                return this.f1328b.f1331c.m1101b(jSONObject);
                            } catch (Throwable e) {
                                throw Exceptions.propagate(e);
                            }
                        }

                        private acr m1171g() {
                            try {
                                return this.f1328b.f1330b.m1065b(jSONObject);
                            } catch (Throwable e) {
                                throw Exceptions.propagate(e);
                            }
                        }

                        protected final /* synthetic */ Object mo4373b() {
                            so.m2470a(4, "VunglePrepare", "received invalid ad from server, tossing it and getting a new one", null);
                            throw new RuntimeException("received invalid ad from server, tossing it and getting a new one");
                        }
                    }.m811a(c1893v);
                }
            }
            return Observable.just(obj2);
        }

        @Inject
        C1702b() {
        }
    }
}
