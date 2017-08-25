package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.AppEventsConstants;
import com.facebook.Response;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zze;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzfy implements Callable<zzha> {
    private static final long zzBF = TimeUnit.SECONDS.toMillis(60);
    private final Context mContext;
    private final zzho zzBG;
    private final zzm zzBH;
    private final zzbc zzBI;
    private boolean zzBJ;
    private List<String> zzBK;
    private final com.google.android.gms.internal.zzha.zza zzBs;
    private int zzBv;
    private final Object zzqt = new Object();
    private final zzan zzvA;

    public interface zza<T extends com.google.android.gms.ads.internal.formats.zzg.zza> {
        T zza(zzfy com_google_android_gms_internal_zzfy, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    class zzb {
        final /* synthetic */ zzfy zzBO;
        public zzdg zzBX;

        zzb(zzfy com_google_android_gms_internal_zzfy) {
            this.zzBO = com_google_android_gms_internal_zzfy;
        }
    }

    public zzfy(Context context, zzm com_google_android_gms_ads_internal_zzm, zzbc com_google_android_gms_internal_zzbc, zzho com_google_android_gms_internal_zzho, zzan com_google_android_gms_internal_zzan, com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza) {
        this.mContext = context;
        this.zzBH = com_google_android_gms_ads_internal_zzm;
        this.zzBG = com_google_android_gms_internal_zzho;
        this.zzBI = com_google_android_gms_internal_zzbc;
        this.zzBs = com_google_android_gms_internal_zzha_zza;
        this.zzvA = com_google_android_gms_internal_zzan;
        this.zzBJ = false;
        this.zzBv = -2;
        this.zzBK = null;
    }

    private com.google.android.gms.ads.internal.formats.zzg.zza zza(zzbb com_google_android_gms_internal_zzbb, zza com_google_android_gms_internal_zzfy_zza, JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException {
        if (zzfr()) {
            return null;
        }
        String[] zzc = zzc(jSONObject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
        this.zzBK = zzc == null ? null : Arrays.asList(zzc);
        com.google.android.gms.ads.internal.formats.zzg.zza zza = com_google_android_gms_internal_zzfy_zza.zza(this, jSONObject);
        if (zza == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaz("Failed to retrieve ad assets.");
            return null;
        }
        zza.zza(new zzg(this.mContext, this.zzBH, com_google_android_gms_internal_zzbb, this.zzvA, jSONObject, zza));
        return zza;
    }

    private zzha zza(com.google.android.gms.ads.internal.formats.zzg.zza com_google_android_gms_ads_internal_formats_zzg_zza) {
        int i;
        synchronized (this.zzqt) {
            i = this.zzBv;
            if (com_google_android_gms_ads_internal_formats_zzg_zza == null && this.zzBv == -2) {
                i = 0;
            }
        }
        return new zzha(this.zzBs.zzFr.zzCm, null, this.zzBs.zzFs.zzxF, i, this.zzBs.zzFs.zzxG, this.zzBK, this.zzBs.zzFs.orientation, this.zzBs.zzFs.zzxJ, this.zzBs.zzFr.zzCp, false, null, null, null, null, null, 0, this.zzBs.zzpN, this.zzBs.zzFs.zzCJ, this.zzBs.zzFo, this.zzBs.zzFp, this.zzBs.zzFs.zzCP, this.zzBs.zzFl, i != -2 ? null : com_google_android_gms_ads_internal_formats_zzg_zza, this.zzBs.zzFr.zzCC);
    }

    private zzhv<zzc> zza(JSONObject jSONObject, final boolean z, boolean z2) throws JSONException {
        final String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        if (!TextUtils.isEmpty(string)) {
            return z2 ? new zzht(new zzc(null, Uri.parse(string))) : this.zzBG.zza(string, new com.google.android.gms.internal.zzho.zza<zzc>(this) {
                final /* synthetic */ zzfy zzBO;

                public zzc zzfs() {
                    this.zzBO.zza(2, z);
                    return null;
                }

                public /* synthetic */ Object zzft() {
                    return zzfs();
                }

                public zzc zzg(InputStream inputStream) {
                    byte[] zzk;
                    try {
                        zzk = zzlg.zzk(inputStream);
                    } catch (IOException e) {
                        zzk = null;
                    }
                    if (zzk == null) {
                        this.zzBO.zza(2, z);
                        return null;
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(zzk, 0, zzk.length);
                    if (decodeByteArray != null) {
                        return new zzc(new BitmapDrawable(Resources.getSystem(), decodeByteArray), Uri.parse(string));
                    }
                    this.zzBO.zza(2, z);
                    return null;
                }

                public /* synthetic */ Object zzh(InputStream inputStream) {
                    return zzg(inputStream);
                }
            });
        } else {
            zza(0, z);
            return new zzht(null);
        }
    }

    private void zza(com.google.android.gms.ads.internal.formats.zzg.zza com_google_android_gms_ads_internal_formats_zzg_zza, zzbb com_google_android_gms_internal_zzbb) {
        if (com_google_android_gms_ads_internal_formats_zzg_zza instanceof zzf) {
            final zzf com_google_android_gms_ads_internal_formats_zzf = (zzf) com_google_android_gms_ads_internal_formats_zzg_zza;
            zzb com_google_android_gms_internal_zzfy_zzb = new zzb(this);
            zzdg c09193 = new zzdg(this) {
                final /* synthetic */ zzfy zzBO;

                public void zza(zzid com_google_android_gms_internal_zzid, Map<String, String> map) {
                    this.zzBO.zzb(com_google_android_gms_ads_internal_formats_zzf, (String) map.get("asset"));
                }
            };
            com_google_android_gms_internal_zzfy_zzb.zzBX = c09193;
            com_google_android_gms_internal_zzbb.zza("/nativeAdCustomClick", c09193);
        }
    }

    private Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private JSONObject zzb(final zzbb com_google_android_gms_internal_zzbb) throws TimeoutException, JSONException {
        if (zzfr()) {
            return null;
        }
        final zzhs com_google_android_gms_internal_zzhs = new zzhs();
        final zzb com_google_android_gms_internal_zzfy_zzb = new zzb(this);
        zzdg c09171 = new zzdg(this) {
            final /* synthetic */ zzfy zzBO;

            public void zza(zzid com_google_android_gms_internal_zzid, Map<String, String> map) {
                com_google_android_gms_internal_zzbb.zzb("/nativeAdPreProcess", com_google_android_gms_internal_zzfy_zzb.zzBX);
                try {
                    String str = (String) map.get(Response.SUCCESS_KEY);
                    if (!TextUtils.isEmpty(str)) {
                        com_google_android_gms_internal_zzhs.zzf(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                        return;
                    }
                } catch (Throwable e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzb("Malformed native JSON response.", e);
                }
                this.zzBO.zzB(0);
                zzu.zza(this.zzBO.zzfr(), (Object) "Unable to set the ad state error!");
                com_google_android_gms_internal_zzhs.zzf(null);
            }
        };
        com_google_android_gms_internal_zzfy_zzb.zzBX = c09171;
        com_google_android_gms_internal_zzbb.zza("/nativeAdPreProcess", c09171);
        com_google_android_gms_internal_zzbb.zza("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.zzBs.zzFs.zzCI));
        return (JSONObject) com_google_android_gms_internal_zzhs.get(zzBF, TimeUnit.MILLISECONDS);
    }

    private void zzb(zzcs com_google_android_gms_internal_zzcs, String str) {
        try {
            zzcw zzq = this.zzBH.zzq(com_google_android_gms_internal_zzcs.getCustomTemplateId());
            if (zzq != null) {
                zzq.zza(com_google_android_gms_internal_zzcs, str);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    private String[] zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private zzbb zzfq() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        if (zzfr()) {
            return null;
        }
        zzbb com_google_android_gms_internal_zzbb = (zzbb) this.zzBI.zza(this.mContext, this.zzBs.zzFr.zzpJ, (this.zzBs.zzFs.zzzG.indexOf("https") == 0 ? "https:" : "http:") + ((String) zzbz.zzur.get())).get(zzBF, TimeUnit.MILLISECONDS);
        com_google_android_gms_internal_zzbb.zza(this.zzBH, this.zzBH, this.zzBH, this.zzBH, false, null, null, null, null);
        return com_google_android_gms_internal_zzbb;
    }

    public /* synthetic */ Object call() throws Exception {
        return zzfp();
    }

    public void zzB(int i) {
        synchronized (this.zzqt) {
            this.zzBJ = true;
            this.zzBv = i;
        }
    }

    public zzhv<zzc> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public List<zzhv<zzc>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        List<zzhv<zzc>> arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            zza(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<zzc> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzB(i);
        }
    }

    protected zza zzd(JSONObject jSONObject) throws JSONException, TimeoutException {
        if (zzfr()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.zzBs.zzFr.zzqb != null ? this.zzBs.zzFr.zzqb.zzvC : false;
        boolean z2 = this.zzBs.zzFr.zzqb != null ? this.zzBs.zzFr.zzqb.zzvE : false;
        if ("2".equals(string)) {
            return new zzfz(z, z2);
        }
        if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(string)) {
            return new zzga(z, z2);
        }
        if ("3".equals(string)) {
            final String string2 = jSONObject.getString("custom_template_id");
            final zzhs com_google_android_gms_internal_zzhs = new zzhs();
            zzhl.zzGk.post(new Runnable(this) {
                final /* synthetic */ zzfy zzBO;

                public void run() {
                    com_google_android_gms_internal_zzhs.zzf(this.zzBO.zzBH.zzbo().get(string2));
                }
            });
            if (com_google_android_gms_internal_zzhs.get(zzBF, TimeUnit.MILLISECONDS) != null) {
                return new zzgb(z);
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaz("No handler for custom template: " + jSONObject.getString("custom_template_id"));
        } else {
            zzB(0);
        }
        return null;
    }

    public zzhv<com.google.android.gms.ads.internal.formats.zza> zze(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new zzht(null);
        }
        final String optString = optJSONObject.optString("text");
        final int optInt = optJSONObject.optInt("text_size", -1);
        final Integer zzb = zzb(optJSONObject, "text_color");
        final Integer zzb2 = zzb(optJSONObject, "bg_color");
        return zzhu.zza(zza(optJSONObject, "image", false, false), new com.google.android.gms.internal.zzhu.zza<zzc, com.google.android.gms.ads.internal.formats.zza>(this) {
            final /* synthetic */ zzfy zzBO;

            public com.google.android.gms.ads.internal.formats.zza zza(zzc com_google_android_gms_ads_internal_formats_zzc) {
                com.google.android.gms.ads.internal.formats.zza com_google_android_gms_ads_internal_formats_zza;
                if (com_google_android_gms_ads_internal_formats_zzc != null) {
                    try {
                        if (!TextUtils.isEmpty(optString)) {
                            com_google_android_gms_ads_internal_formats_zza = new com.google.android.gms.ads.internal.formats.zza(optString, (Drawable) zze.zzn(com_google_android_gms_ads_internal_formats_zzc.zzdw()), zzb2, zzb, optInt > 0 ? Integer.valueOf(optInt) : null);
                            return com_google_android_gms_ads_internal_formats_zza;
                        }
                    } catch (Throwable e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzb("Could not get attribution icon", e);
                        return null;
                    }
                }
                com_google_android_gms_ads_internal_formats_zza = null;
                return com_google_android_gms_ads_internal_formats_zza;
            }

            public /* synthetic */ Object zze(Object obj) {
                return zza((zzc) obj);
            }
        });
    }

    public zzha zzfp() {
        try {
            zzbb zzfq = zzfq();
            JSONObject zzb = zzb(zzfq);
            com.google.android.gms.ads.internal.formats.zzg.zza zza = zza(zzfq, zzd(zzb), zzb);
            zza(zza, zzfq);
            return zza(zza);
        } catch (CancellationException e) {
            if (!this.zzBJ) {
                zzB(0);
            }
            return zza(null);
        } catch (ExecutionException e2) {
            if (this.zzBJ) {
                zzB(0);
            }
            return zza(null);
        } catch (InterruptedException e3) {
            if (this.zzBJ) {
                zzB(0);
            }
            return zza(null);
        } catch (Throwable e4) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Malformed native JSON response.", e4);
            if (this.zzBJ) {
                zzB(0);
            }
            return zza(null);
        } catch (Throwable e42) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Timeout when loading native ad.", e42);
            if (this.zzBJ) {
                zzB(0);
            }
            return zza(null);
        }
    }

    public boolean zzfr() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzBJ;
        }
        return z;
    }
}
