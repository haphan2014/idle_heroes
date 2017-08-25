package com.droidhang.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: UIThreadExcutor */
class UIThreadExecutor implements Executor {
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    UIThreadExecutor() {
    }

    public void execute(Runnable command) {
        this.mHandler.post(command);
    }
}
