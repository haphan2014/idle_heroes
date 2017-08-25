package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class vn implements MembersInjector<vm> {
    static final /* synthetic */ boolean f3459a = (!vn.class.desiredAssertionStatus());
    private final Provider<C1778a> f3460b;
    private final Provider<wa> f3461c;

    public final /* synthetic */ void injectMembers(Object obj) {
        vm vmVar = (vm) obj;
        if (vmVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vmVar.f800a = (C1778a) this.f3460b.get();
        vmVar.f801b = (wa) this.f3461c.get();
    }

    public static void m2548a(vm vmVar, Provider<C1778a> provider) {
        vmVar.f800a = (C1778a) provider.get();
    }

    public static void m2549b(vm vmVar, Provider<wa> provider) {
        vmVar.f801b = (wa) provider.get();
    }
}
