package com.applovin.impl.adview;

class C0131j implements Runnable {
    final /* synthetic */ AdViewControllerImpl f195a;

    private C0131j(AdViewControllerImpl adViewControllerImpl) {
        this.f195a = adViewControllerImpl;
    }

    public void run() {
        try {
            this.f195a.f94i.loadDataWithBaseURL("/", "<html></html>", "text/html", null, "");
        } catch (Exception e) {
        }
    }
}
