package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import java.util.Collection;
import java.util.Locale;

public final class CastMediaControlIntent {
    public static final String ACTION_SYNC_STATUS = "com.google.android.gms.cast.ACTION_SYNC_STATUS";
    @Deprecated
    public static final String CATEGORY_CAST = "com.google.android.gms.cast.CATEGORY_CAST";
    public static final String DEFAULT_MEDIA_RECEIVER_APPLICATION_ID = "CC1AD845";
    public static final int ERROR_CODE_REQUEST_FAILED = 1;
    public static final int ERROR_CODE_SESSION_START_FAILED = 2;
    public static final int ERROR_CODE_TEMPORARILY_DISCONNECTED = 3;
    public static final String EXTRA_CAST_APPLICATION_ID = "com.google.android.gms.cast.EXTRA_CAST_APPLICATION_ID";
    public static final String EXTRA_CAST_LANGUAGE_CODE = "com.google.android.gms.cast.EXTRA_CAST_LANGUAGE_CODE";
    public static final String EXTRA_CAST_RELAUNCH_APPLICATION = "com.google.android.gms.cast.EXTRA_CAST_RELAUNCH_APPLICATION";
    public static final String EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS = "com.google.android.gms.cast.EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS";
    public static final String EXTRA_CUSTOM_DATA = "com.google.android.gms.cast.EXTRA_CUSTOM_DATA";
    public static final String EXTRA_DEBUG_LOGGING_ENABLED = "com.google.android.gms.cast.EXTRA_DEBUG_LOGGING_ENABLED";
    public static final String EXTRA_ERROR_CODE = "com.google.android.gms.cast.EXTRA_ERROR_CODE";

    private CastMediaControlIntent() {
    }

    public static String categoryForCast(String applicationId) throws IllegalArgumentException {
        if (applicationId != null) {
            return zza(CATEGORY_CAST, applicationId, null);
        }
        throw new IllegalArgumentException("applicationId cannot be null");
    }

    public static String categoryForCast(String applicationId, Collection<String> namespaces) {
        if (applicationId == null) {
            throw new IllegalArgumentException("applicationId cannot be null");
        } else if (namespaces != null) {
            return zza(CATEGORY_CAST, applicationId, namespaces);
        } else {
            throw new IllegalArgumentException("namespaces cannot be null");
        }
    }

    public static String categoryForCast(Collection<String> namespaces) throws IllegalArgumentException {
        if (namespaces != null) {
            return zza(CATEGORY_CAST, null, namespaces);
        }
        throw new IllegalArgumentException("namespaces cannot be null");
    }

    public static String categoryForRemotePlayback() {
        return zza("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", null, null);
    }

    public static String categoryForRemotePlayback(String applicationId) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(applicationId)) {
            return zza("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", applicationId, null);
        }
        throw new IllegalArgumentException("applicationId cannot be null or empty");
    }

    public static String languageTagForLocale(Locale locale) {
        return zzf.zzb(locale);
    }

    private static String zza(String str, String str2, Collection<String> collection) throws IllegalArgumentException {
        String toUpperCase;
        StringBuilder stringBuilder = new StringBuilder(str);
        if (str2 != null) {
            toUpperCase = str2.toUpperCase();
            if (toUpperCase.matches("[A-F0-9]+")) {
                stringBuilder.append("/").append(toUpperCase);
            } else {
                throw new IllegalArgumentException("Invalid application ID: " + str2);
            }
        }
        if (collection != null) {
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("Must specify at least one namespace");
            }
            if (str2 == null) {
                stringBuilder.append("/");
            }
            stringBuilder.append("/");
            Object obj = 1;
            for (String toUpperCase2 : collection) {
                zzf.zzbD(toUpperCase2);
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append(zzf.zzbF(toUpperCase2));
            }
        }
        return stringBuilder.toString();
    }
}
