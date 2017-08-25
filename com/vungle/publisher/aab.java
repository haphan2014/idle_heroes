package com.vungle.publisher;

import android.net.Uri;
import android.net.Uri.Builder;
import com.vungle.publisher.vf.C1894b;
import com.vungle.publisher.vf.C1895c;
import com.vungle.publisher.xs.C1624a;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class aab extends xs {

    @Singleton
    /* compiled from: vungle */
    public static class C1625a extends C1624a<aab> {
        @Inject
        pj f786g;

        public final /* synthetic */ vf mo4345b() {
            return m823d();
        }

        public final /* synthetic */ xs mo4347c() {
            return m823d();
        }

        @Inject
        C1625a() {
        }

        public final aab m823d() {
            aab com_vungle_publisher_aab = (aab) super.mo4347c();
            Builder appendQueryParameter = Uri.parse(this.d + "new").buildUpon().appendQueryParameter("app_id", this.c.mo4525b());
            String a = this.f786g.mo4423a();
            if (a != null) {
                appendQueryParameter.appendQueryParameter("ifa", a);
            }
            a = this.f786g.mo4426c();
            if (a != null) {
                appendQueryParameter.appendQueryParameter("isu", a);
            }
            com_vungle_publisher_aab.f788b = appendQueryParameter.toString();
            return com_vungle_publisher_aab;
        }

        protected final /* synthetic */ vf mo4346a() {
            return new aab();
        }
    }

    protected aab() {
    }

    protected final C1895c mo4349b() {
        return C1895c.trackInstall;
    }

    protected final C1894b mo4348a() {
        return C1894b.POST;
    }
}
