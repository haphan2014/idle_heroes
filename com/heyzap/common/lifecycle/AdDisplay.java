package com.heyzap.common.lifecycle;

import com.heyzap.common.concurrency.SettableFuture;

public class AdDisplay {
    private boolean cancelled;
    public EventStream<Boolean> clickEventStream;
    public SettableFuture<Boolean> closeListener;
    public EventStream<DisplayResult> displayEventStream;
    public ImpressionOptions impressionOptions;
    public SettableFuture<Boolean> impressionRegisteredListener;
    public SettableFuture<Boolean> incentiveListener;
    private int refetchDelay;

    public AdDisplay() {
        this(true);
    }

    public AdDisplay(boolean autoRegisterImpression) {
        this.displayEventStream = EventStream.create();
        this.clickEventStream = EventStream.create();
        this.closeListener = SettableFuture.create();
        this.incentiveListener = SettableFuture.create();
        this.impressionRegisteredListener = SettableFuture.create();
        this.refetchDelay = 0;
        this.cancelled = false;
        if (autoRegisterImpression) {
            this.impressionRegisteredListener.set(Boolean.valueOf(true));
        }
    }

    public int getRefetchDelay() {
        return this.refetchDelay;
    }

    public void setRefetchDelay(int refetchDelay) {
        this.refetchDelay = refetchDelay;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }
}
