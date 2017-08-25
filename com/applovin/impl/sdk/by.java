package com.applovin.impl.sdk;

import java.util.LinkedList;
import java.util.Queue;

class by {
    private final int f515a;
    private final Queue f516b;
    private final Object f517c;

    by(int i) {
        if (i > 10) {
            i = 10;
        }
        this.f515a = i;
        this.f516b = new LinkedList();
        this.f517c = new Object();
    }

    int m460a() {
        int size;
        synchronized (this.f517c) {
            size = this.f516b.size();
        }
        return size;
    }

    void m461a(bf bfVar) {
        synchronized (this.f517c) {
            if (!m463c()) {
                this.f516b.offer(bfVar);
            }
        }
    }

    int m462b() {
        return this.f515a;
    }

    boolean m463c() {
        boolean z;
        synchronized (this.f517c) {
            z = m460a() >= this.f515a;
        }
        return z;
    }

    boolean m464d() {
        boolean z;
        synchronized (this.f517c) {
            z = m460a() == 0;
        }
        return z;
    }

    bf m465e() {
        try {
            bf bfVar;
            synchronized (this.f517c) {
                bfVar = !m464d() ? (bf) this.f516b.poll() : null;
            }
            return bfVar;
        } catch (Exception e) {
            return null;
        }
    }
}
