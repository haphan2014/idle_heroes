package com.vungle.publisher;

/* compiled from: vungle */
public enum ul {
    wifi("WIFI", uk.wifi),
    gprs("GPRS"),
    cdma("CDMA"),
    edge("EDGE"),
    rtt1x("1xRTT"),
    iden("IDEN"),
    umts("UMTS"),
    evdo0("EVDO_0"),
    evdoA("EVDO_A"),
    hsdpa("HSDPA"),
    hspa("HSPA"),
    hspap("HSPAP"),
    hsupa("HSUPA"),
    evdoB("EVDO_B"),
    ehrpd("EHRPD"),
    lte("LTE"),
    unknown("UNKNOWN", uk.unknown);
    
    public final String f3368r;
    public final uk f3369s;

    private ul(String str, uk ukVar) {
        this.f3368r = str;
        this.f3369s = ukVar;
    }

    private ul(String str) {
        this(r2, r3, str, uk.mobile);
    }
}
