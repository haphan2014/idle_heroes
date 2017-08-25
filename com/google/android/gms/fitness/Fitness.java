package com.google.android.gms.fitness;

import android.content.Intent;
import android.os.Build.VERSION;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zzlz;
import com.google.android.gms.internal.zzma;
import com.google.android.gms.internal.zzma.zza;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmc;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzmx;
import com.google.android.gms.internal.zzmz;
import com.google.android.gms.internal.zzna;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zznc;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.internal.zznh;
import java.util.concurrent.TimeUnit;

public class Fitness {
    public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
    public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
    public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
    @Deprecated
    public static final Void API = null;
    public static final Api<NoOptions> BLE_API = new Api("Fitness.BLE_API", new zzb(), zzajw, new Scope[0]);
    public static final BleApi BleApi = zzqo();
    public static final Api<NoOptions> CONFIG_API = new Api("Fitness.CONFIG_API", new zzly.zzb(), zzajx, new Scope[0]);
    public static final ConfigApi ConfigApi = new zzna();
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    public static final Api<NoOptions> HISTORY_API = new Api("Fitness.HISTORY_API", new zzlz.zzb(), zzajy, new Scope[0]);
    public static final HistoryApi HistoryApi = new zznb();
    public static final Api<NoOptions> RECORDING_API = new Api("Fitness.RECORDING_API", new zzmb.zzb(), zzajA, new Scope[0]);
    public static final RecordingApi RecordingApi = new zznd();
    public static final Scope SCOPE_ACTIVITY_READ = new Scope(Scopes.FITNESS_ACTIVITY_READ);
    public static final Scope SCOPE_ACTIVITY_READ_WRITE = new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE);
    public static final Scope SCOPE_BODY_READ = new Scope(Scopes.FITNESS_BODY_READ);
    public static final Scope SCOPE_BODY_READ_WRITE = new Scope(Scopes.FITNESS_BODY_READ_WRITE);
    public static final Scope SCOPE_LOCATION_READ = new Scope(Scopes.FITNESS_LOCATION_READ);
    public static final Scope SCOPE_LOCATION_READ_WRITE = new Scope(Scopes.FITNESS_LOCATION_READ_WRITE);
    public static final Scope SCOPE_NUTRITION_READ = new Scope(Scopes.FITNESS_NUTRITION_READ);
    public static final Scope SCOPE_NUTRITION_READ_WRITE = new Scope(Scopes.FITNESS_NUTRITION_READ_WRITE);
    public static final Api<NoOptions> SENSORS_API = new Api("Fitness.SENSORS_API", new zzmc.zzb(), zzajB, new Scope[0]);
    public static final Api<NoOptions> SESSIONS_API = new Api("Fitness.SESSIONS_API", new zzmd.zzb(), zzajC, new Scope[0]);
    public static final SensorsApi SensorsApi = new zzne();
    public static final SessionsApi SessionsApi = new zznf();
    public static final Api<NoOptions> zzada = new Api("Fitness.INTERNAL_API", new zza(), zzajz, new Scope[0]);
    public static final ClientKey<zzmb> zzajA = new ClientKey();
    public static final ClientKey<zzmc> zzajB = new ClientKey();
    public static final ClientKey<zzmd> zzajC = new ClientKey();
    public static final zzmx zzajD = new zznc();
    public static final ClientKey<zzlx> zzajw = new ClientKey();
    public static final ClientKey<zzly> zzajx = new ClientKey();
    public static final ClientKey<zzlz> zzajy = new ClientKey();
    public static final ClientKey<zzma> zzajz = new ClientKey();

    private Fitness() {
    }

    public static long getEndTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_END_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    public static long getStartTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_START_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    private static BleApi zzqo() {
        return VERSION.SDK_INT >= 18 ? new zzmz() : new zznh();
    }
}
