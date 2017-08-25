package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.droidhang.pay.util.IabHelper;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import com.google.android.gms.internal.zzgd;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzi {
    public void zza(Context context, boolean z, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Intent intent = new Intent();
        intent.setClassName(context, InAppPurchaseActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        GInAppPurchaseManagerInfoParcel.zza(intent, gInAppPurchaseManagerInfoParcel);
        context.startActivity(intent);
    }

    public String zzai(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("developerPayload");
            } catch (JSONException e) {
                zzb.zzaC("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public String zzaj(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("purchaseToken");
            } catch (JSONException e) {
                zzb.zzaC("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public int zzb(Bundle bundle) {
        Object obj = bundle.get(IabHelper.RESPONSE_CODE);
        if (obj == null) {
            zzb.zzaC("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            zzb.zzaC("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public int zzd(Intent intent) {
        Object obj = intent.getExtras().get(IabHelper.RESPONSE_CODE);
        if (obj == null) {
            zzb.zzaC("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            zzb.zzaC("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public String zze(Intent intent) {
        return intent == null ? null : intent.getStringExtra(IabHelper.RESPONSE_INAPP_PURCHASE_DATA);
    }

    public String zzf(Intent intent) {
        return intent == null ? null : intent.getStringExtra(IabHelper.RESPONSE_INAPP_SIGNATURE);
    }
}
