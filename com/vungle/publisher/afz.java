package com.vungle.publisher;

/* compiled from: vungle */
public final class afz {
    public static String[] m1206a(Object[] objArr) {
        int i = 0;
        if (objArr == null) {
            return new String[0];
        }
        String[] strArr = new String[objArr.length];
        while (i < objArr.length) {
            strArr[i] = String.valueOf(objArr[i]);
            i++;
        }
        return strArr;
    }
}
