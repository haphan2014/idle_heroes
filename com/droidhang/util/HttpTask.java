package com.droidhang.util;

/* compiled from: SimpleHttpThread */
class HttpTask {
    private SimpleHttpObserver observer;
    private String param;
    private boolean stopThreadWhenFinished;
    private String url;

    HttpTask() {
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParam() {
        return this.param;
    }

    public void setParam(String json) {
        this.param = json;
    }

    public SimpleHttpObserver getObserver() {
        return this.observer;
    }

    public void setObserver(SimpleHttpObserver observer) {
        this.observer = observer;
    }

    public boolean isStopThreadWhenFinished() {
        return this.stopThreadWhenFinished;
    }

    public void setStopThreadWhenFinished(boolean stopThreadWhenFinished) {
        this.stopThreadWhenFinished = stopThreadWhenFinished;
    }
}
