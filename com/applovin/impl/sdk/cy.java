package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class cy {
    private final String f630a = "TaskManager";
    private final AppLovinSdkImpl f631b;
    private final AppLovinLogger f632c;
    private final ScheduledThreadPoolExecutor f633d;
    private final ScheduledThreadPoolExecutor f634e;
    private final ScheduledThreadPoolExecutor f635f;

    cy(AppLovinSdkImpl appLovinSdkImpl) {
        this.f631b = appLovinSdkImpl;
        this.f632c = appLovinSdkImpl.getLogger();
        this.f633d = m645a("main");
        this.f634e = m645a("back");
        this.f635f = m645a("postbacks");
    }

    private long m643a(cz czVar) {
        return czVar == cz.MAIN ? this.f633d.getTaskCount() - this.f633d.getCompletedTaskCount() : czVar == cz.BACKGROUND ? this.f634e.getTaskCount() - this.f634e.getCompletedTaskCount() : czVar == cz.POSTBACKS ? this.f635f.getTaskCount() - this.f635f.getCompletedTaskCount() : 0;
    }

    private ScheduledThreadPoolExecutor m645a(String str) {
        return new ScheduledThreadPoolExecutor(1, new da(this, str));
    }

    private static void m646a(Runnable runnable, long j, ScheduledExecutorService scheduledExecutorService) {
        if (j > 0) {
            scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } else {
            scheduledExecutorService.submit(runnable);
        }
    }

    void m648a(cc ccVar) {
        if (ccVar != null) {
            try {
                this.f632c.mo638i("TaskManager", "Executing " + ccVar + " immediately...");
                ccVar.run();
                this.f632c.mo638i("TaskManager", ccVar + " finished executing...");
                return;
            } catch (Throwable th) {
                this.f632c.mo637e("TaskManager", "Task failed execution", th);
                return;
            }
        }
        this.f632c.mo636e("TaskManager", "Attempted to execute null task immediately");
    }

    void m649a(cc ccVar, cz czVar) {
        m650a(ccVar, czVar, 0);
    }

    void m650a(cc ccVar, cz czVar, long j) {
        if (ccVar == null) {
            throw new IllegalArgumentException("No task specified");
        } else if (j < 0) {
            throw new IllegalArgumentException("Invalid delay specified: " + j);
        } else if (czVar == cz.MAIN || czVar == cz.BACKGROUND || czVar == cz.POSTBACKS) {
            this.f632c.mo635d("TaskManager", "Scheduling " + ccVar.f524e + " on " + czVar + " queue in " + j + "ms with new queue size " + (m643a(czVar) + 1));
            Runnable dcVar = new dc(this, ccVar, czVar);
            if (czVar == cz.MAIN) {
                m646a(dcVar, j, this.f633d);
            } else if (czVar == cz.BACKGROUND) {
                m646a(dcVar, j, this.f634e);
            } else if (czVar == cz.POSTBACKS) {
                m646a(dcVar, j, this.f635f);
            }
        } else {
            throw new IllegalArgumentException("Invalid queue specified");
        }
    }

    void m651a(cx cxVar, long j) {
        if (cxVar == null) {
            throw new IllegalArgumentException("No task specified");
        }
        m646a((Runnable) cxVar, j, this.f633d);
    }
}
