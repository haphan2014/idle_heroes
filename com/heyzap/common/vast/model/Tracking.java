package com.heyzap.common.vast.model;

public class Tracking {
    private TrackingEvent event;
    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TrackingEvent getEvent() {
        return this.event;
    }

    public void setEvent(TrackingEvent event) {
        this.event = event;
    }

    public String toString() {
        return "Tracking [event=" + this.event + ", value=" + this.value + "]";
    }
}
