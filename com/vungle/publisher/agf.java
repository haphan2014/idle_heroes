package com.vungle.publisher;

import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Base64;
import com.facebook.internal.ServerProtocol;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: vungle */
public final class agf {
    private static final char[] f1403a = "0123456789abcdef".toCharArray();

    public static boolean m1219a(String str) {
        return (str == null || str.trim().isEmpty()) ? false : true;
    }

    public static <T> String m1217a(T... tArr) {
        return m1216a(", ", (Object[]) tArr);
    }

    public static String m1214a(Iterable<?> iterable) {
        return m1215a(", ", (Iterable) iterable);
    }

    public static <T> String m1216a(String str, T... tArr) {
        return m1215a(str, tArr == null ? null : Arrays.asList(tArr));
    }

    public static String m1215a(String str, Iterable<?> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Object next : iterable) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(str);
            }
            stringBuilder.append(next);
        }
        return stringBuilder.toString();
    }

    public static String m1213a(Enum<?> enumR) {
        return enumR == null ? null : enumR.name();
    }

    public static String m1220b(Object[] objArr) {
        return "[" + m1217a(objArr) + "]";
    }

    private static Uri m1225f(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("input text cannot be null");
        }
        try {
            return Uri.parse(str);
        } catch (Exception e) {
            throw new IllegalArgumentException("invalid url parameter: " + str);
        }
    }

    public static Uri m1212a(String str, String str2) throws IllegalArgumentException {
        if (str == null) {
            return m1225f(str2);
        }
        return m1225f(str);
    }

    public static boolean m1221b(String str) throws IllegalArgumentException {
        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str)) {
            return true;
        }
        if ("false".equals(str)) {
            return false;
        }
        throw new IllegalArgumentException("invalid boolean parameter: " + str);
    }

    public static String m1222c(String str) {
        if (str == null) {
            return str;
        }
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception e) {
            throw new IllegalArgumentException("error decoding base64 string: " + str);
        }
    }

    public static Set<String> m1218a(Uri uri) {
        Set<String> hashSet = new HashSet();
        try {
            if (VERSION.SDK_INT >= 11) {
                return uri.getQueryParameterNames();
            }
            String query = uri.getQuery();
            if (query == null) {
                return hashSet;
            }
            for (String split : query.split("&")) {
                hashSet.add(split.split("=")[0]);
            }
            return hashSet;
        } catch (Exception e) {
            throw new IllegalArgumentException("error getting query param names");
        }
    }

    public static tl m1223d(String str) throws IllegalArgumentException {
        if ("portrait".equals(str)) {
            return tl.PORTRAIT;
        }
        if ("landscape".equals(str)) {
            return tl.LANDSCAPE;
        }
        if ("none".equals(str)) {
            return tl.NONE;
        }
        throw new IllegalArgumentException("invalid orientation: " + str);
    }

    public static boolean m1224e(String str) {
        return str == null || str.length() <= 0;
    }
}
