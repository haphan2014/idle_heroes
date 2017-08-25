package com.vungle.publisher;

import android.os.Bundle;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.vf.C1623a;
import javax.inject.Inject;

/* compiled from: vungle */
public abstract class xs extends vf {

    /* compiled from: vungle */
    public static abstract class C1624a<T extends xs> extends C1623a<T> {
        @Inject
        sn f780b;
        @Inject
        pq f781c;
        @Inject
        String f782d;
        @Inject
        protected WrapperFramework f783e;
        @Inject
        protected String f784f;
        private String f785g;

        protected C1624a() {
        }

        protected /* synthetic */ vf mo4345b() {
            return mo4347c();
        }

        protected T mo4347c() {
            xs xsVar = (xs) super.mo4345b();
            Bundle bundle = xsVar.f789c;
            bundle.putString("X-VUNGLE-BUNDLE-ID", this.f781c.mo4524a());
            bundle.putString("X-VUNGLE-LANGUAGE", this.f780b.mo4535a());
            bundle.putString("X-VUNGLE-TIMEZONE", this.f780b.mo4537c());
            String str = "User-Agent";
            String str2 = this.f785g;
            if (str2 == null) {
                Object obj;
                StringBuilder stringBuilder = new StringBuilder("VungleDroid/4.1.0");
                WrapperFramework wrapperFramework = this.f783e;
                String str3 = this.f784f;
                Object obj2 = (wrapperFramework == null || wrapperFramework.equals(WrapperFramework.none)) ? null : 1;
                if (str3 == null || "".equals(str3)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (!(obj2 == null && obj == null)) {
                    stringBuilder.append(';');
                    if (obj2 != null) {
                        stringBuilder.append(wrapperFramework);
                    }
                    if (obj != null) {
                        stringBuilder.append('/');
                        stringBuilder.append(str3);
                    }
                }
                str2 = stringBuilder.toString();
                this.f785g = str2;
            }
            bundle.putString(str, str2);
            if (xs.m827a(xsVar)) {
                bundle.putLong("X-VUNG-DATE", System.currentTimeMillis());
            }
            return xsVar;
        }
    }

    protected xs() {
    }

    static /* synthetic */ boolean m827a(xs xsVar) {
        return xsVar.f788b != null && vf.f787a.matcher(xsVar.f788b).find();
    }
}
