package com.vungle.publisher;

import android.content.Context;

/* compiled from: vungle */
public class VunglePub extends C1620k {
    public static final String VERSION = "VungleDroid/4.1.0";
    private static final VunglePub f771n = new VunglePub();

    public static VunglePub getInstance() {
        return f771n;
    }

    VunglePub() {
    }

    public boolean init(Context context, String vungleAppId) {
        return super.init(context, vungleAppId);
    }

    public C1707b getDemographic() {
        return super.getDemographic();
    }

    public void addEventListeners(EventListener... eventListeners) {
        super.addEventListeners(eventListeners);
    }

    public void clearEventListeners() {
        super.clearEventListeners();
    }

    public void setEventListeners(EventListener... eventListeners) {
        super.setEventListeners(eventListeners);
    }

    public void removeEventListeners(EventListener... eventListeners) {
        super.removeEventListeners(eventListeners);
    }

    protected final boolean mo4336a(Context context) {
        boolean a = super.mo4336a(context);
        this.f.mo4433m();
        return a;
    }

    protected final boolean mo4335a() {
        return super.mo4335a();
    }
}
