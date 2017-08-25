package com.applovin.impl.sdk;

class C0172x implements cr {
    final /* synthetic */ bz f730a;
    final /* synthetic */ EventServiceImpl f731b;

    C0172x(EventServiceImpl eventServiceImpl, bz bzVar) {
        this.f731b = eventServiceImpl;
        this.f730a = bzVar;
    }

    public void mo653a(C0168t c0168t) {
        try {
            this.f731b.f344a.getPersistentPostbackManager().m454a(this.f731b.m263a(this.f730a, c0168t).toString(), this.f730a.m467b());
        } catch (Throwable e) {
            this.f731b.f344a.getLogger().mo637e("EventServiceImpl", "Unable to track event due to failure to convert event parameters into JSONObject for event: " + this.f730a, e);
        }
    }
}
