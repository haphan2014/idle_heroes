package com.vungle.publisher;

import com.vungle.publisher.abs.C1650a;
import com.vungle.publisher.vf.C1895c;
import com.vungle.publisher.wh.C1900a;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONException;

/* compiled from: vungle */
public final class wk extends wh {

    @Singleton
    /* compiled from: vungle */
    public static class C1901a extends C1900a<wk> {
        @Inject
        C1650a f3512c;
        @Inject
        Provider<wk> f3513d;

        @Inject
        C1901a() {
        }

        public final wk m2578a(List<gx> list) throws JSONException {
            wk wkVar = (wk) m2574d();
            abs com_vungle_publisher_abs = (abs) this.f3512c.f964a.get();
            com_vungle_publisher_abs.f965a = list;
            wkVar.f790d = com_vungle_publisher_abs.m857d();
            return wkVar;
        }

        protected final String mo4552c() {
            return "api/v1/sdkErrors";
        }

        protected final /* synthetic */ vf mo4346a() {
            return (wk) this.f3513d.get();
        }
    }

    @Inject
    wk() {
    }

    protected final C1895c mo4349b() {
        return C1895c.reportExceptions;
    }
}
