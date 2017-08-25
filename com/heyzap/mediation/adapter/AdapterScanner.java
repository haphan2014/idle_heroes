package com.heyzap.mediation.adapter;

import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.sdk.mediation.adapter.AdcolonyAdapter;
import com.heyzap.sdk.mediation.adapter.AdmobAdapter;
import com.heyzap.sdk.mediation.adapter.ApplovinAdapter;
import com.heyzap.sdk.mediation.adapter.ChartboostAdapter;
import com.heyzap.sdk.mediation.adapter.FacebookAdapter;
import com.heyzap.sdk.mediation.adapter.HeyzapAdapter;
import com.heyzap.sdk.mediation.adapter.HeyzapCrossPromoAdapter;
import com.heyzap.sdk.mediation.adapter.HeyzapExchangeAdapter;
import com.heyzap.sdk.mediation.adapter.HyprmxAdapter;
import com.heyzap.sdk.mediation.adapter.InMobiAdapter;
import com.heyzap.sdk.mediation.adapter.LeadboltAdapter;
import com.heyzap.sdk.mediation.adapter.UnityadsAdapter;
import com.heyzap.sdk.mediation.adapter.VungleAdapter;
import java.util.Arrays;
import java.util.List;

public class AdapterScanner {
    private final List<Class<? extends NetworkAdapter>> adapterClasses = Arrays.asList(new Class[]{AdcolonyAdapter.class, AdmobAdapter.class, ApplovinAdapter.class, ChartboostAdapter.class, FacebookAdapter.class, HeyzapAdapter.class, HeyzapCrossPromoAdapter.class, HeyzapExchangeAdapter.class, HyprmxAdapter.class, InMobiAdapter.class, LeadboltAdapter.class, UnityadsAdapter.class, VungleAdapter.class});

    public List<Class<? extends NetworkAdapter>> scan() {
        return this.adapterClasses;
    }
}
