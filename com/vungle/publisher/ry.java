package com.vungle.publisher;

import com.vungle.publisher.env.AndroidDevice;
import com.vungle.publisher.inject.EndpointModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {ra.class, EndpointModule.class, rv.class})
/* compiled from: vungle */
public interface ry {
    void mo4526a(C1618d c1618d);

    void mo4527a(AndroidDevice androidDevice);

    void mo4528a(C1620k c1620k);

    void mo4529a(nl nlVar);

    void mo4530a(oc ocVar);

    void mo4531a(oq oqVar);

    void mo4532a(sb sbVar);

    void mo4533a(sg sgVar);

    void mo4534a(uh uhVar);
}
