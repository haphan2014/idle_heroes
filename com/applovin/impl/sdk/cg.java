package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import org.json.JSONObject;

class cg {
    private final AppLovinSdkImpl f592a;
    private final AppLovinLogger f593b;
    private final Context f594c;
    private final Object[] f595d = new Object[cd.m492b()];

    cg(AppLovinSdkImpl appLovinSdkImpl) {
        this.f592a = appLovinSdkImpl;
        this.f593b = appLovinSdkImpl.getLogger();
        this.f594c = appLovinSdkImpl.getApplicationContext();
    }

    private static cf m497a(String str) {
        for (cf cfVar : cd.m491a()) {
            if (cfVar.m495b().equals(str)) {
                return cfVar;
            }
        }
        return null;
    }

    private static Object m498a(String str, JSONObject jSONObject, Object obj) {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }

    private String m499e() {
        return "com.applovin.sdk." + dp.m696a(this.f592a.getSdkKey()) + ".";
    }

    public SharedPreferences m500a() {
        if (this.f594c != null) {
            return this.f594c.getSharedPreferences("com.applovin.sdk.1", 0);
        }
        throw new IllegalArgumentException("No context specified");
    }

    public Object m501a(cf cfVar) {
        if (cfVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        Object obj;
        synchronized (this.f595d) {
            try {
                obj = this.f595d[cfVar.m493a()];
                if (obj != null) {
                    obj = cfVar.m494a(obj);
                } else {
                    obj = cfVar.m496c();
                }
            } catch (Throwable th) {
                this.f592a.getLogger().mo636e("SettingsManager", "Unable to retrieve value for setting " + cfVar.m495b() + "; using default...");
                obj = cfVar.m496c();
            }
        }
        return obj;
    }

    public void m502a(cf cfVar, Object obj) {
        if (cfVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        } else if (obj == null) {
            throw new IllegalArgumentException("No new value specified");
        } else {
            synchronized (this.f595d) {
                this.f595d[cfVar.m493a()] = obj;
            }
            this.f593b.mo635d("SettingsManager", "Setting update: " + cfVar.m495b() + " set to \"" + obj + "\"");
        }
    }

    void m503a(AppLovinSdkSettings appLovinSdkSettings) {
        long j = 0;
        boolean z = false;
        this.f593b.mo638i("SettingsManager", "Loading user-defined settings...");
        if (appLovinSdkSettings != null) {
            synchronized (this.f595d) {
                boolean z2;
                boolean z3;
                this.f595d[cd.f570i.m493a()] = Boolean.valueOf(appLovinSdkSettings.isVerboseLoggingEnabled());
                long bannerAdRefreshSeconds = appLovinSdkSettings.getBannerAdRefreshSeconds();
                if (bannerAdRefreshSeconds >= 0) {
                    if (bannerAdRefreshSeconds > 0) {
                        j = Math.max(30, bannerAdRefreshSeconds);
                    }
                    this.f595d[cd.f582u.m493a()] = Long.valueOf(j);
                    this.f595d[cd.f581t.m493a()] = Boolean.valueOf(true);
                } else if (bannerAdRefreshSeconds == -1) {
                    this.f595d[cd.f581t.m493a()] = Boolean.valueOf(false);
                }
                String autoPreloadSizes = appLovinSdkSettings.getAutoPreloadSizes();
                if (autoPreloadSizes == null) {
                    autoPreloadSizes = "NONE";
                }
                Object[] objArr = this.f595d;
                int a = cd.f540E.m493a();
                if (autoPreloadSizes.equals("NONE")) {
                    autoPreloadSizes = "";
                }
                objArr[a] = autoPreloadSizes;
                autoPreloadSizes = appLovinSdkSettings.getAutoPreloadTypes();
                if (autoPreloadSizes == null) {
                    autoPreloadSizes = "NONE";
                }
                if (autoPreloadSizes.equals("NONE")) {
                    z2 = false;
                    z3 = false;
                } else {
                    z2 = false;
                    z3 = false;
                    for (String str : autoPreloadSizes.split(",")) {
                        if (str.equals(AppLovinAdType.REGULAR.getLabel())) {
                            z3 = true;
                        } else if (str.equals(AppLovinAdType.INCENTIVIZED.getLabel()) || str.contains("INCENT") || str.contains("REWARD")) {
                            z2 = true;
                        } else if (str.equals(NativeAdImpl.TYPE_NATIVE.getLabel())) {
                            z = true;
                        }
                    }
                }
                if (!z3) {
                    this.f595d[cd.f540E.m493a()] = "";
                }
                this.f595d[cd.f541F.m493a()] = Boolean.valueOf(z2);
                this.f595d[cd.aF.m493a()] = Boolean.valueOf(z);
                if (appLovinSdkSettings instanceof bd) {
                    for (Entry entry : ((bd) appLovinSdkSettings).m379b().entrySet()) {
                        this.f595d[((cf) entry.getKey()).m493a()] = entry.getValue();
                    }
                }
            }
        }
    }

    void m504a(JSONObject jSONObject) {
        this.f593b.mo635d("SettingsManager", "Loading settings from JSON array...");
        synchronized (this.f595d) {
            String str = "";
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                str = (String) keys.next();
                if (str != null && str.length() > 0) {
                    try {
                        cf a = m497a(str);
                        if (a != null) {
                            Object a2 = m498a(str, jSONObject, a.m496c());
                            this.f595d[a.m493a()] = a2;
                            this.f593b.mo635d("SettingsManager", "Setting update: " + a.m495b() + " set to \"" + a2 + "\"");
                        } else {
                            this.f593b.mo641w("SettingsManager", "Unknown setting recieved: " + str);
                        }
                    } catch (Throwable e) {
                        this.f593b.mo637e("SettingsManager", "Unable to parse JSON settings array", e);
                    } catch (Throwable e2) {
                        this.f593b.mo637e("SettingsManager", "Unable to convert setting object ", e2);
                    }
                }
            }
        }
    }

    void m505b() {
        if (this.f594c == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f593b.mo638i("SettingsManager", "Saving settings with the application...");
        String e = m499e();
        Editor edit = m500a().edit();
        synchronized (this.f595d) {
            for (cf cfVar : cd.m491a()) {
                Object obj = this.f595d[cfVar.m493a()];
                if (obj != null) {
                    String str = e + cfVar.m495b();
                    if (obj instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Float) {
                        edit.putFloat(str, ((Float) obj).floatValue());
                    } else if (obj instanceof Integer) {
                        edit.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Long) {
                        edit.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        edit.putString(str, (String) obj);
                    } else {
                        throw new RuntimeException("SDK Error: unknown value: " + obj.getClass());
                    }
                }
            }
        }
        edit.commit();
        this.f593b.mo635d("SettingsManager", "Settings saved with the application.");
    }

    void m506c() {
        if (this.f594c == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f593b.mo638i("SettingsManager", "Loading settings saved with the application...");
        String e = m499e();
        SharedPreferences a = m500a();
        synchronized (this.f595d) {
            for (cf cfVar : cd.m491a()) {
                try {
                    Boolean valueOf;
                    String str = e + cfVar.m495b();
                    Object c = cfVar.m496c();
                    if (c instanceof Boolean) {
                        valueOf = Boolean.valueOf(a.getBoolean(str, ((Boolean) c).booleanValue()));
                    } else if (c instanceof Float) {
                        valueOf = Float.valueOf(a.getFloat(str, ((Float) c).floatValue()));
                    } else if (c instanceof Integer) {
                        valueOf = Integer.valueOf(a.getInt(str, ((Integer) c).intValue()));
                    } else if (c instanceof Long) {
                        valueOf = Long.valueOf(a.getLong(str, ((Long) c).longValue()));
                    } else if (c instanceof String) {
                        valueOf = a.getString(str, (String) c);
                    } else {
                        throw new RuntimeException("SDK Error: unknown value: " + c.getClass());
                    }
                    this.f595d[cfVar.m493a()] = valueOf;
                } catch (Throwable e2) {
                    this.f593b.mo637e("SettingsManager", "Unable to load \"" + cfVar.m495b() + "\"", e2);
                }
            }
        }
    }

    void m507d() {
        synchronized (this.f595d) {
            Arrays.fill(this.f595d, null);
        }
        Editor edit = m500a().edit();
        edit.clear();
        edit.commit();
    }
}
