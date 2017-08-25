package com.google.android.gms.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzgd
public class zzep extends zzeu {
    static final Set<String> zzyu = new HashSet(Arrays.asList(new String[]{"top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"}));
    private int zznM = -1;
    private int zznN = -1;
    private final zzid zzoA;
    private final Object zzqt = new Object();
    private AdSizeParcel zzxT;
    private int zzyA = 0;
    private final Activity zzyB;
    private ImageView zzyC;
    private LinearLayout zzyD;
    private zzev zzyE;
    private PopupWindow zzyF;
    private RelativeLayout zzyG;
    private ViewGroup zzyH;
    private String zzyv = "top-right";
    private boolean zzyw = true;
    private int zzyx = 0;
    private int zzyy = 0;
    private int zzyz = 0;

    class C09061 implements OnClickListener {
        final /* synthetic */ zzep zzyI;

        C09061(zzep com_google_android_gms_internal_zzep) {
            this.zzyI = com_google_android_gms_internal_zzep;
        }

        public void onClick(View view) {
            this.zzyI.zzn(true);
        }
    }

    public zzep(zzid com_google_android_gms_internal_zzid, zzev com_google_android_gms_internal_zzev) {
        super(com_google_android_gms_internal_zzid, "resize");
        this.zzoA = com_google_android_gms_internal_zzid;
        this.zzyB = com_google_android_gms_internal_zzid.zzgB();
        this.zzyE = com_google_android_gms_internal_zzev;
    }

    private int[] zzed() {
        if (!zzef()) {
            return null;
        }
        if (this.zzyw) {
            return new int[]{this.zzyx + this.zzyz, this.zzyy + this.zzyA};
        }
        int[] zzh = zzo.zzbv().zzh(this.zzyB);
        int[] zzj = zzo.zzbv().zzj(this.zzyB);
        int i = zzh[0];
        int i2 = this.zzyx + this.zzyz;
        int i3 = this.zzyy + this.zzyA;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.zznM + i2 > i) {
            i2 = i - this.zznM;
        }
        if (i3 < zzj[0]) {
            i3 = zzj[0];
        } else if (this.zznN + i3 > zzj[1]) {
            i3 = zzj[1] - this.zznN;
        }
        return new int[]{i2, i3};
    }

    private void zzg(Map<String, String> map) {
        if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
            this.zznM = zzo.zzbv().zzau((String) map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
            this.zznN = zzo.zzbv().zzau((String) map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
            this.zzyz = zzo.zzbv().zzau((String) map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
            this.zzyA = zzo.zzbv().zzau((String) map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
            this.zzyw = Boolean.parseBoolean((String) map.get("allowOffscreen"));
        }
        String str = (String) map.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.zzyv = str;
        }
    }

    public void zza(int i, int i2, boolean z) {
        synchronized (this.zzqt) {
            this.zzyx = i;
            this.zzyy = i2;
            if (this.zzyF != null && z) {
                int[] zzed = zzed();
                if (zzed != null) {
                    this.zzyF.update(zzk.zzcA().zzb(this.zzyB, zzed[0]), zzk.zzcA().zzb(this.zzyB, zzed[1]), this.zzyF.getWidth(), this.zzyF.getHeight());
                    zzc(zzed[0], zzed[1]);
                } else {
                    zzn(true);
                }
            }
        }
    }

    void zzb(int i, int i2) {
        if (this.zzyE != null) {
            this.zzyE.zza(i, i2, this.zznM, this.zznN);
        }
    }

    void zzc(int i, int i2) {
        zzb(i, i2 - zzo.zzbv().zzj(this.zzyB)[0], this.zznM, this.zznN);
    }

    public void zzd(int i, int i2) {
        this.zzyx = i;
        this.zzyy = i2;
    }

    boolean zzec() {
        return this.zznM > -1 && this.zznN > -1;
    }

    public boolean zzee() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzyF != null;
        }
        return z;
    }

    boolean zzef() {
        int[] zzh = zzo.zzbv().zzh(this.zzyB);
        int[] zzj = zzo.zzbv().zzj(this.zzyB);
        int i = zzh[0];
        int i2 = zzh[1];
        if (this.zznM < 50 || this.zznM > i) {
            zzb.zzaC("Width is too small or too large.");
            return false;
        } else if (this.zznN < 50 || this.zznN > i2) {
            zzb.zzaC("Height is too small or too large.");
            return false;
        } else if (this.zznN == i2 && this.zznM == i) {
            zzb.zzaC("Cannot resize to a full-screen ad.");
            return false;
        } else {
            if (this.zzyw) {
                int i3;
                String str = this.zzyv;
                boolean z = true;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            z = false;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        i3 = this.zzyz + this.zzyx;
                        i2 = this.zzyy + this.zzyA;
                        break;
                    case true:
                        i3 = ((this.zzyx + this.zzyz) + (this.zznM / 2)) - 25;
                        i2 = this.zzyy + this.zzyA;
                        break;
                    case true:
                        i3 = ((this.zzyx + this.zzyz) + (this.zznM / 2)) - 25;
                        i2 = ((this.zzyy + this.zzyA) + (this.zznN / 2)) - 25;
                        break;
                    case true:
                        i3 = this.zzyz + this.zzyx;
                        i2 = ((this.zzyy + this.zzyA) + this.zznN) - 50;
                        break;
                    case true:
                        i3 = ((this.zzyx + this.zzyz) + (this.zznM / 2)) - 25;
                        i2 = ((this.zzyy + this.zzyA) + this.zznN) - 50;
                        break;
                    case true:
                        i3 = ((this.zzyx + this.zzyz) + this.zznM) - 50;
                        i2 = ((this.zzyy + this.zzyA) + this.zznN) - 50;
                        break;
                    default:
                        i3 = ((this.zzyx + this.zzyz) + this.zznM) - 50;
                        i2 = this.zzyy + this.zzyA;
                        break;
                }
                if (i3 < 0 || i3 + 50 > i || r2 < zzj[0] || r2 + 50 > zzj[1]) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzh(java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
        r12 = this;
        r4 = -1;
        r5 = 1;
        r3 = 0;
        r6 = r12.zzqt;
        monitor-enter(r6);
        r1 = r12.zzyB;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0011;
    L_0x000a:
        r1 = "Not an activity context. Cannot resize.";
        r12.zzae(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
    L_0x0010:
        return;
    L_0x0011:
        r1 = r12.zzoA;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzaN();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0023;
    L_0x0019:
        r1 = "Webview is not yet available, size is not set.";
        r12.zzae(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0020:
        r1 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        throw r1;
    L_0x0023:
        r1 = r12.zzoA;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzaN();	 Catch:{ all -> 0x0020 }
        r1 = r1.zzsn;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0034;
    L_0x002d:
        r1 = "Is interstitial. Cannot resize an interstitial.";
        r12.zzae(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0034:
        r1 = r12.zzoA;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzgJ();	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0043;
    L_0x003c:
        r1 = "Cannot resize an expanded banner.";
        r12.zzae(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0043:
        r12.zzg(r13);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzec();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0053;
    L_0x004c:
        r1 = "Invalid width and height options. Cannot resize.";
        r12.zzae(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0053:
        r1 = r12.zzyB;	 Catch:{ all -> 0x0020 }
        r7 = r1.getWindow();	 Catch:{ all -> 0x0020 }
        if (r7 == 0) goto L_0x0061;
    L_0x005b:
        r1 = r7.getDecorView();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0068;
    L_0x0061:
        r1 = "Activity context is not ready, cannot get window or decor view.";
        r12.zzae(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0068:
        r8 = r12.zzed();	 Catch:{ all -> 0x0020 }
        if (r8 != 0) goto L_0x0075;
    L_0x006e:
        r1 = "Resize location out of screen or close button is not visible.";
        r12.zzae(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0075:
        r1 = com.google.android.gms.ads.internal.client.zzk.zzcA();	 Catch:{ all -> 0x0020 }
        r2 = r12.zzyB;	 Catch:{ all -> 0x0020 }
        r9 = r12.zznM;	 Catch:{ all -> 0x0020 }
        r9 = r1.zzb(r2, r9);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.client.zzk.zzcA();	 Catch:{ all -> 0x0020 }
        r2 = r12.zzyB;	 Catch:{ all -> 0x0020 }
        r10 = r12.zznN;	 Catch:{ all -> 0x0020 }
        r10 = r1.zzb(r2, r10);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzoA;	 Catch:{ all -> 0x0020 }
        r1 = r1.getWebView();	 Catch:{ all -> 0x0020 }
        r2 = r1.getParent();	 Catch:{ all -> 0x0020 }
        if (r2 == 0) goto L_0x01d5;
    L_0x0099:
        r1 = r2 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x01d5;
    L_0x009d:
        r0 = r2;
        r0 = (android.view.ViewGroup) r0;	 Catch:{ all -> 0x0020 }
        r1 = r0;
        r11 = r12.zzoA;	 Catch:{ all -> 0x0020 }
        r11 = r11.getWebView();	 Catch:{ all -> 0x0020 }
        r1.removeView(r11);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyF;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01ce;
    L_0x00ae:
        r2 = (android.view.ViewGroup) r2;	 Catch:{ all -> 0x0020 }
        r12.zzyH = r2;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.zzo.zzbv();	 Catch:{ all -> 0x0020 }
        r2 = r12.zzoA;	 Catch:{ all -> 0x0020 }
        r2 = r2.getWebView();	 Catch:{ all -> 0x0020 }
        r1 = r1.zzj(r2);	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.ImageView;	 Catch:{ all -> 0x0020 }
        r11 = r12.zzyB;	 Catch:{ all -> 0x0020 }
        r2.<init>(r11);	 Catch:{ all -> 0x0020 }
        r12.zzyC = r2;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzyC;	 Catch:{ all -> 0x0020 }
        r2.setImageBitmap(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzoA;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzaN();	 Catch:{ all -> 0x0020 }
        r12.zzxT = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyH;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzyC;	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
    L_0x00dd:
        r1 = new android.widget.RelativeLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzyB;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.zzyG = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyG;	 Catch:{ all -> 0x0020 }
        r2 = 0;
        r1.setBackgroundColor(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyG;	 Catch:{ all -> 0x0020 }
        r2 = new android.view.ViewGroup$LayoutParams;	 Catch:{ all -> 0x0020 }
        r2.<init>(r9, r10);	 Catch:{ all -> 0x0020 }
        r1.setLayoutParams(r2);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.zzo.zzbv();	 Catch:{ all -> 0x0020 }
        r2 = r12.zzyG;	 Catch:{ all -> 0x0020 }
        r11 = 0;
        r1 = r1.zza(r2, r9, r10, r11);	 Catch:{ all -> 0x0020 }
        r12.zzyF = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyF;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setOutsideTouchable(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyF;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setTouchable(r2);	 Catch:{ all -> 0x0020 }
        r2 = r12.zzyF;	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyw;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01dd;
    L_0x0115:
        r1 = r5;
    L_0x0116:
        r2.setClippingEnabled(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyG;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzoA;	 Catch:{ all -> 0x0020 }
        r2 = r2.getWebView();	 Catch:{ all -> 0x0020 }
        r9 = -1;
        r10 = -1;
        r1.addView(r2, r9, r10);	 Catch:{ all -> 0x0020 }
        r1 = new android.widget.LinearLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzyB;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.zzyD = r1;	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.client.zzk.zzcA();	 Catch:{ all -> 0x0020 }
        r9 = r12.zzyB;	 Catch:{ all -> 0x0020 }
        r10 = 50;
        r1 = r1.zzb(r9, r10);	 Catch:{ all -> 0x0020 }
        r9 = com.google.android.gms.ads.internal.client.zzk.zzcA();	 Catch:{ all -> 0x0020 }
        r10 = r12.zzyB;	 Catch:{ all -> 0x0020 }
        r11 = 50;
        r9 = r9.zzb(r10, r11);	 Catch:{ all -> 0x0020 }
        r2.<init>(r1, r9);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyv;	 Catch:{ all -> 0x0020 }
        r9 = r1.hashCode();	 Catch:{ all -> 0x0020 }
        switch(r9) {
            case -1364013995: goto L_0x01f6;
            case -1012429441: goto L_0x01e0;
            case -655373719: goto L_0x0201;
            case 1163912186: goto L_0x0217;
            case 1288627767: goto L_0x020c;
            case 1755462605: goto L_0x01eb;
            default: goto L_0x0155;
        };	 Catch:{ all -> 0x0020 }
    L_0x0155:
        r1 = r4;
    L_0x0156:
        switch(r1) {
            case 0: goto L_0x0222;
            case 1: goto L_0x022e;
            case 2: goto L_0x023a;
            case 3: goto L_0x0241;
            case 4: goto L_0x024d;
            case 5: goto L_0x0259;
            default: goto L_0x0159;
        };	 Catch:{ all -> 0x0020 }
    L_0x0159:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
    L_0x0163:
        r1 = r12.zzyD;	 Catch:{ all -> 0x0020 }
        r3 = new com.google.android.gms.internal.zzep$1;	 Catch:{ all -> 0x0020 }
        r3.<init>(r12);	 Catch:{ all -> 0x0020 }
        r1.setOnClickListener(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyD;	 Catch:{ all -> 0x0020 }
        r3 = "Close button";
        r1.setContentDescription(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyG;	 Catch:{ all -> 0x0020 }
        r3 = r12.zzyD;	 Catch:{ all -> 0x0020 }
        r1.addView(r3, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyF;	 Catch:{ RuntimeException -> 0x0265 }
        r2 = r7.getDecorView();	 Catch:{ RuntimeException -> 0x0265 }
        r3 = 0;
        r4 = com.google.android.gms.ads.internal.client.zzk.zzcA();	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r12.zzyB;	 Catch:{ RuntimeException -> 0x0265 }
        r7 = 0;
        r7 = r8[r7];	 Catch:{ RuntimeException -> 0x0265 }
        r4 = r4.zzb(r5, r7);	 Catch:{ RuntimeException -> 0x0265 }
        r5 = com.google.android.gms.ads.internal.client.zzk.zzcA();	 Catch:{ RuntimeException -> 0x0265 }
        r7 = r12.zzyB;	 Catch:{ RuntimeException -> 0x0265 }
        r9 = 1;
        r9 = r8[r9];	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r5.zzb(r7, r9);	 Catch:{ RuntimeException -> 0x0265 }
        r1.showAtLocation(r2, r3, r4, r5);	 Catch:{ RuntimeException -> 0x0265 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.zzb(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzoA;	 Catch:{ all -> 0x0020 }
        r2 = new com.google.android.gms.ads.internal.client.AdSizeParcel;	 Catch:{ all -> 0x0020 }
        r3 = r12.zzyB;	 Catch:{ all -> 0x0020 }
        r4 = new com.google.android.gms.ads.AdSize;	 Catch:{ all -> 0x0020 }
        r5 = r12.zznM;	 Catch:{ all -> 0x0020 }
        r7 = r12.zznN;	 Catch:{ all -> 0x0020 }
        r4.<init>(r5, r7);	 Catch:{ all -> 0x0020 }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x0020 }
        r1.zza(r2);	 Catch:{ all -> 0x0020 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.zzc(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = "resized";
        r12.zzag(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01ce:
        r1 = r12.zzyF;	 Catch:{ all -> 0x0020 }
        r1.dismiss();	 Catch:{ all -> 0x0020 }
        goto L_0x00dd;
    L_0x01d5:
        r1 = "Webview is detached, probably in the middle of a resize or expand.";
        r12.zzae(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01dd:
        r1 = r3;
        goto L_0x0116;
    L_0x01e0:
        r5 = "top-left";
        r1 = r1.equals(r5);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01e8:
        r1 = r3;
        goto L_0x0156;
    L_0x01eb:
        r3 = "top-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01f3:
        r1 = r5;
        goto L_0x0156;
    L_0x01f6:
        r3 = "center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01fe:
        r1 = 2;
        goto L_0x0156;
    L_0x0201:
        r3 = "bottom-left";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0209:
        r1 = 3;
        goto L_0x0156;
    L_0x020c:
        r3 = "bottom-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0214:
        r1 = 4;
        goto L_0x0156;
    L_0x0217:
        r3 = "bottom-right";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x021f:
        r1 = 5;
        goto L_0x0156;
    L_0x0222:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x022e:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x023a:
        r1 = 13;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0241:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x024d:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0259:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0265:
        r1 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0020 }
        r2.<init>();	 Catch:{ all -> 0x0020 }
        r3 = "Cannot show popup window: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0020 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0020 }
        r1 = r2.append(r1);	 Catch:{ all -> 0x0020 }
        r1 = r1.toString();	 Catch:{ all -> 0x0020 }
        r12.zzae(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyG;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzoA;	 Catch:{ all -> 0x0020 }
        r2 = r2.getWebView();	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyH;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x02a8;
    L_0x028f:
        r1 = r12.zzyH;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzyC;	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzyH;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzoA;	 Catch:{ all -> 0x0020 }
        r2 = r2.getWebView();	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzoA;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzxT;	 Catch:{ all -> 0x0020 }
        r1.zza(r2);	 Catch:{ all -> 0x0020 }
    L_0x02a8:
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzep.zzh(java.util.Map):void");
    }

    public void zzn(boolean z) {
        synchronized (this.zzqt) {
            if (this.zzyF != null) {
                this.zzyF.dismiss();
                this.zzyG.removeView(this.zzoA.getWebView());
                if (this.zzyH != null) {
                    this.zzyH.removeView(this.zzyC);
                    this.zzyH.addView(this.zzoA.getWebView());
                    this.zzoA.zza(this.zzxT);
                }
                if (z) {
                    zzag("default");
                    if (this.zzyE != null) {
                        this.zzyE.zzbc();
                    }
                }
                this.zzyF = null;
                this.zzyG = null;
                this.zzyH = null;
                this.zzyD = null;
            }
        }
    }
}
