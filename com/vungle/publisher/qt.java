package com.vungle.publisher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: vungle */
public final class qt {
    static final Pattern f3027a = Pattern.compile("[|\\\\?*<\":>'&\\[\\]]");

    public static String m2369a(Object... objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < 2) {
            Object obj = objArr[i];
            if (obj == null) {
                throw new IllegalArgumentException("null path element at index " + i);
            }
            stringBuilder.append(obj);
            int length = stringBuilder.length();
            if (length > 0 && i + 1 < 2 && stringBuilder.charAt(length - 1) != File.separatorChar) {
                stringBuilder.append(File.separatorChar);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public static boolean m2372a(String str) {
        File file = new File(str);
        boolean c = m2376c(file);
        if (c) {
            so.m2470a(3, "VungleFile", "successfully deleted: " + file, null);
        } else {
            so.m2470a(5, "VungleFile", "could not delete: " + file, null);
        }
        return c;
    }

    private static boolean m2376c(File file) {
        Deque arrayDeque = new ArrayDeque();
        arrayDeque.push(file);
        File file2 = (File) arrayDeque.peek();
        boolean z = true;
        while (file2 != null) {
            boolean z2;
            boolean z3;
            if (file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (Object push : listFiles) {
                        arrayDeque.push(push);
                    }
                    z2 = z;
                    z3 = z2;
                    file2 = (File) arrayDeque.peek();
                    z = z3;
                }
            }
            arrayDeque.pop();
            z = z && (!file2.exists() || file2.delete());
            z2 = z;
            z3 = z2;
            file2 = (File) arrayDeque.peek();
            z = z3;
        }
        return z;
    }

    public static boolean m2370a(File file) {
        if (file == null) {
            so.m2470a(5, "VungleFile", "null directory path", null);
            return false;
        } else if (file.mkdirs()) {
            so.m2470a(3, "VungleFile", "created directory: " + file, null);
            return true;
        } else if (file.isDirectory()) {
            so.m2470a(2, "VungleFile", "directory exists: " + file, null);
            return true;
        } else {
            so.m2470a(3, "VungleFile", "unable to create directory: " + file, null);
            return false;
        }
    }

    public static boolean m2373b(File file) {
        boolean z = false;
        File parentFile = file.getParentFile();
        if (m2370a(parentFile)) {
            z = parentFile.canWrite();
            if (z) {
                so.m2470a(2, "VungleFile", "directory is writeable: " + parentFile, null);
            } else {
                so.m2470a(3, "VungleFile", "directory not writeable: " + parentFile, null);
            }
        }
        return z;
    }

    public static boolean m2374b(String str) {
        return !f3027a.matcher(str).find();
    }

    public static String m2375c(String str) {
        Matcher matcher = f3027a.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        String replaceAll = matcher.replaceAll("_");
        so.m2470a(4, "VungleFile", "Unsafe character(s) found / replaced in filepath: " + str + " --> " + replaceAll, null);
        return replaceAll;
    }

    public static boolean m2371a(File file, File file2) throws IOException {
        String canonicalPath = file2.getCanonicalPath();
        String canonicalPath2 = file.getCanonicalPath();
        return (canonicalPath == null || canonicalPath.equals(canonicalPath2) || !canonicalPath.startsWith(canonicalPath2)) ? false : true;
    }
}
