package com.vungle.publisher;

import android.net.Uri;
import android.net.Uri.Builder;
import com.vungle.publisher.vf.C1894b;
import com.vungle.publisher.vf.C1895c;
import com.vungle.publisher.xs.C1624a;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class aak extends xs {

    @Singleton
    /* compiled from: vungle */
    public static class C1627a extends C1624a<aak> {
        @Inject
        pj f826g;

        @Inject
        C1627a() {
        }

        public final aak m846a(long j) {
            aak com_vungle_publisher_aak = (aak) super.mo4347c();
            Builder appendQueryParameter = Uri.parse(this.d + "unfilled").buildUpon().appendQueryParameter("app_id", this.c.mo4525b());
            String a = this.f826g.mo4423a();
            if (a != null) {
                appendQueryParameter.appendQueryParameter("ifa", a);
            }
            a = this.f826g.mo4426c();
            if (a != null) {
                appendQueryParameter.appendQueryParameter("isu", a);
            }
            appendQueryParameter.appendQueryParameter("ut", String.valueOf(j));
            com_vungle_publisher_aak.f788b = appendQueryParameter.toString();
            return com_vungle_publisher_aak;
        }

        protected final /* synthetic */ vf mo4346a() {
            return new aak();
        }
    }

    protected aak() {
    }

    protected final C1895c mo4349b() {
        return C1895c.unfilledAd;
    }

    protected final C1894b mo4348a() {
        return C1894b.POST;
    }
}
