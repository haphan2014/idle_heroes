package com.vungle.publisher;

import com.heyzap.house.abstr.AbstractActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public class abo extends aar {
    protected Integer f935a;
    protected Long f936b;
    protected C1647b[] f937c;

    /* compiled from: vungle */
    public static abstract class C1645a<P extends da<?, P, E>, E extends dc<P>, L extends abo> extends abj<L> {
        protected C1645a() {
        }

        protected final L[] m939a(P[] pArr) {
            int i = 0;
            L[] lArr = null;
            int length = pArr == null ? 0 : pArr.length;
            if (length > 0) {
                lArr = (abo[]) mo4353a(length);
                int length2 = pArr.length;
                length = 0;
                while (i < length2) {
                    int i2 = length + 1;
                    lArr[length] = mo4359a(pArr[i]);
                    i++;
                    length = i2;
                }
            }
            return lArr;
        }

        protected L mo4359a(P p) {
            if (p == null) {
                return null;
            }
            abo com_vungle_publisher_abo = (abo) mo4354b();
            com_vungle_publisher_abo.f937c = C1643a.m935a(p.m1369e());
            com_vungle_publisher_abo.f936b = p.f1586c;
            return com_vungle_publisher_abo;
        }
    }

    /* compiled from: vungle */
    public static class C1647b extends aar {
        protected String f944a;
        protected Long f945b;
        protected String f946c;

        /* compiled from: vungle */
        public static abstract class C1643a<E extends dc<?>> extends abj<C1647b> {
            protected C1643a() {
            }

            protected static C1647b[] m935a(E[] eArr) {
                int length = eArr == null ? 0 : eArr.length;
                if (length <= 0) {
                    return null;
                }
                C1647b[] c1647bArr = new C1647b[length];
                int length2 = eArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length2) {
                    C1647b c1647b;
                    dc dcVar = eArr[i];
                    int i3 = i2 + 1;
                    if (dcVar != null) {
                        c1647b = new C1647b();
                        c1647b.f944a = String.valueOf(dcVar.f1625b);
                        c1647b.f945b = Long.valueOf(dcVar.f1626c);
                        c1647b.f946c = dcVar.f1627d;
                    } else {
                        c1647b = null;
                    }
                    c1647bArr[i2] = c1647b;
                    i++;
                    i2 = i3;
                }
                return c1647bArr;
            }

            protected final /* synthetic */ Object mo4354b() {
                return new C1647b();
            }
        }

        protected C1647b() {
        }

        public final /* synthetic */ Object mo4352b() throws JSONException {
            return mo4355a();
        }

        public final JSONObject mo4355a() throws JSONException {
            JSONObject a = super.mo4355a();
            a.putOpt(AbstractActivity.ACTIVITY_INTENT_ACTION_KEY, this.f944a);
            a.putOpt("timestamp_millis", this.f945b);
            a.putOpt("value", this.f946c);
            return a;
        }
    }

    public /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    public JSONObject mo4355a() throws JSONException {
        JSONObject a = super.mo4355a();
        a.putOpt("userActions", sa.m2426a(this.f937c));
        a.putOpt("startTime", this.f936b);
        return a;
    }
}
