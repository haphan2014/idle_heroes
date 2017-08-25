package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@zzgd
public interface zzid {
    void destroy();

    Context getContext();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getRequestedOrientation();

    WebView getWebView();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void setBackgroundColor(int i);

    void setContext(Context context);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebViewClient(WebViewClient webViewClient);

    void setWillNotDraw(boolean z);

    void stopLoading();

    boolean willNotDraw();

    void zzB(boolean z);

    void zzC(boolean z);

    void zza(Context context, AdSizeParcel adSizeParcel);

    void zza(AdSizeParcel adSizeParcel);

    void zza(zzc com_google_android_gms_ads_internal_overlay_zzc);

    void zza(String str, String str2);

    void zza(String str, JSONObject jSONObject);

    void zzaD(String str);

    AdSizeParcel zzaN();

    void zzb(zzc com_google_android_gms_ads_internal_overlay_zzc);

    void zzb(String str, JSONObject jSONObject);

    void zzc(String str, Map<String, ?> map);

    void zzew();

    void zzgA();

    Activity zzgB();

    Context zzgC();

    zzc zzgD();

    zzc zzgE();

    zzie zzgF();

    boolean zzgG();

    zzan zzgH();

    VersionInfoParcel zzgI();

    boolean zzgJ();

    void zzgK();

    void zzgL();

    void zzv(int i);
}
