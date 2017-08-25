package com.google.android.gms.appinvite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.plus.PlusShare;
import com.heyzap.http.AsyncHttpResponseHandler;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class AppInviteReferral {
    private AppInviteReferral() {
    }

    public static Intent addPlayStoreReferrerToIntent(Intent playStoreReferrerIntent, Intent referralIntent) {
        Bundle zzh = zzh(playStoreReferrerIntent);
        if (!(zzh == null || referralIntent == null)) {
            referralIntent.putExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE", zzh);
        }
        return referralIntent;
    }

    public static Intent addReferralDataToIntent(String invitationId, String deepLink, Intent referralIntent) {
        return referralIntent == null ? null : referralIntent.putExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE", zza(invitationId, deepLink, false));
    }

    public static String getDeepLink(Intent referralIntent) {
        if (referralIntent != null) {
            Bundle bundleExtra = referralIntent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE");
            if (bundleExtra != null) {
                return bundleExtra.getString("com.google.android.gms.appinvite.DEEP_LINK");
            }
        }
        return null;
    }

    public static String getInvitationId(Intent referralIntent) {
        if (referralIntent != null) {
            Bundle bundleExtra = referralIntent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE");
            if (bundleExtra != null) {
                return bundleExtra.getString("com.google.android.gms.appinvite.INVITATION_ID");
            }
        }
        return null;
    }

    public static boolean hasReferral(Intent referralIntent) {
        return (referralIntent == null || referralIntent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE") == null) ? false : true;
    }

    public static boolean isOpenedFromPlayStore(Intent referralIntent) {
        return hasReferral(referralIntent) && referralIntent.getBundleExtra("com.google.android.gms.appinvite.REFERRAL_BUNDLE").getBoolean("com.google.android.gms.appinvite.OPENED_FROM_PLAY_STORE", false);
    }

    private static Bundle zza(String str, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("com.google.android.gms.appinvite.INVITATION_ID", str);
        bundle.putString("com.google.android.gms.appinvite.DEEP_LINK", str2);
        bundle.putBoolean("com.google.android.gms.appinvite.OPENED_FROM_PLAY_STORE", z);
        return bundle;
    }

    private static Bundle zzh(Intent intent) {
        if (intent == null || !intent.getAction().equals("com.android.vending.INSTALL_REFERRER") || intent.getStringExtra("referrer") == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("referrer");
        try {
            stringExtra = URLDecoder.decode(stringExtra, AsyncHttpResponseHandler.DEFAULT_CHARSET);
            Uri parse = Uri.parse("s://a.b.c?" + stringExtra);
            String queryParameter = parse.getQueryParameter("invitation_id");
            String queryParameter2 = parse.getQueryParameter(PlusShare.PARAM_CONTENT_DEEP_LINK_ID);
            if (queryParameter != null || queryParameter2 != null) {
                return zza(queryParameter, queryParameter2, true);
            }
            Log.w("AppInviteReferral", "Missing  Referrer query params: " + stringExtra);
            return null;
        } catch (UnsupportedEncodingException e) {
            Log.e("AppInviteReferral", "Error parsing Play Store referrer URL: " + stringExtra);
            return null;
        }
    }
}
