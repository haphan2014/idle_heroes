package com.vungle.publisher;

import com.vungle.publisher.ce.C1713b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: vungle */
public final class uy extends ve {
    @Inject
    xb f3405a;
    @Inject
    ce f3406b;

    @Inject
    uy() {
    }

    public final void m2536a(cu cuVar, jt jtVar, List<String> list) {
        Map hashMap = new HashMap();
        hashMap.put("%timestamp%", String.valueOf(System.currentTimeMillis()));
        m2537a(cuVar, jtVar, hashMap, list);
    }

    public final void m2537a(cu cuVar, jt jtVar, Map<String, String> map, List<String> list) {
        if (list != null) {
            for (final String str : list) {
                if (str != null) {
                    final cu cuVar2 = cuVar;
                    final jt jtVar2 = jtVar;
                    final Map<String, String> map2 = map;
                    this.f3406b.m1245a(new Runnable(this) {
                        final /* synthetic */ uy f3404e;

                        public final void run() {
                            try {
                                xb xbVar = this.f3404e.f3405a;
                                cu cuVar = cuVar2;
                                jt jtVar = jtVar2;
                                String str = str;
                                Map map = map2;
                                if (map != null) {
                                    StringBuilder stringBuilder = new StringBuilder(str);
                                    for (Entry entry : map.entrySet()) {
                                        str = (String) entry.getKey();
                                        int i = -1;
                                        while (true) {
                                            int indexOf = stringBuilder.indexOf(str, i);
                                            if (indexOf > 0) {
                                                stringBuilder.replace(indexOf, str.length() + indexOf, entry.getValue() == null ? "" : (String) entry.getValue());
                                                i = indexOf;
                                            }
                                        }
                                    }
                                    str = stringBuilder.toString();
                                }
                                xbVar.m2598a(cuVar, jtVar, str).m2553a();
                            } catch (Throwable e) {
                                so.m2470a(5, "VungleNetwork", "error sending " + jtVar2 + " event", e);
                            }
                        }
                    }, C1713b.externalNetworkRequest);
                }
            }
        }
    }
}
