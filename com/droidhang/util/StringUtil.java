package com.droidhang.util;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.text.style.StyleSpan;
import com.applovin.sdk.AppLovinTargetingData;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static final Pattern NAME_ADDR_EMAIL_PATTERN = Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");
    private static final char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', AppLovinTargetingData.GENDER_FEMALE};

    private StringUtil() {
    }

    public static String extractAddrSpec(String address) {
        Matcher match = NAME_ADDR_EMAIL_PATTERN.matcher(address);
        if (match.matches()) {
            return match.group(2);
        }
        return address;
    }

    public static String getLanguageForPaypal(Context ctx) {
        String language = ctx.getResources().getConfiguration().locale.getLanguage();
        if ("zh".equals(language)) {
            return "zh_HK";
        }
        if ("ja".equals(language)) {
            return "ja_JP";
        }
        if ("de".equals(language)) {
            return "de_DE";
        }
        if ("es".equals(language)) {
            return "es_ES";
        }
        if ("fr".equals(language)) {
            return "fr_FR";
        }
        if ("it".equals(language)) {
            return "it_IT";
        }
        if ("pl".equals(language)) {
            return "pl_PL";
        }
        return "en_US";
    }

    public static StringBuilder append(StringBuilder builder, String str, String postfix) {
        if (str != null) {
            if (postfix != null) {
                builder.append(str + postfix);
            } else {
                builder.append(str);
            }
        } else if (postfix != null) {
            builder.append(postfix);
        }
        return builder;
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static boolean isNotEmpty(String s) {
        return s != null && s.length() > 0;
    }

    public static byte[] getBytes(String s) {
        try {
            return s.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    public static String newString(byte[] bytes) {
        return newString(bytes, 0, bytes.length);
    }

    public static String newString(byte[] bytes, int offset, int length) {
        try {
            return new String(bytes, offset, length, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    public static String valueOfInt(int i, int length) {
        return valueOfString(String.valueOf(i), length);
    }

    public static String valueOfLong(long i, int length) {
        return valueOfString(String.valueOf(i), length);
    }

    public static String valueOfString(String i, int length) {
        int size = i.length();
        if (size >= length) {
            return i;
        }
        char[] zeros = new char[(length - size)];
        Arrays.fill(zeros, '0');
        StringBuilder buffer = new StringBuilder();
        buffer.append(zeros);
        buffer.append(i);
        return buffer.toString();
    }

    public static String joinString(String conjunction, List<String> data) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iter = data.iterator();
        if (iter.hasNext()) {
            stringBuilder.append((String) iter.next());
        }
        while (iter.hasNext()) {
            stringBuilder.append(conjunction);
            stringBuilder.append((String) iter.next());
        }
        return stringBuilder.toString();
    }

    public static boolean equals(String str, int value) {
        try {
            if (Integer.valueOf(str).intValue() == value) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String getOmission(String content, int maxNum) {
        String omission = "";
        if (!isNotEmpty(content)) {
            return omission;
        }
        if (content.length() > maxNum) {
            return content.substring(0, maxNum) + "...";
        }
        return content;
    }

    public static String joinString(String conjunction, String... data) {
        StringBuilder stringBuilder = new StringBuilder();
        if (data == null || data.length == 0) {
            return null;
        }
        stringBuilder.append(data[0]);
        for (int i = 1; i < data.length; i++) {
            stringBuilder.append(conjunction);
            stringBuilder.append(data[i]);
        }
        return stringBuilder.toString();
    }

    public static String stringToHexString(String str) {
        int strlen = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strlen; i++) {
            stringBuilder.append(String.format("%04x", new Object[]{Integer.valueOf(str.charAt(i))}));
        }
        return stringBuilder.toString();
    }

    public static int indexOf(String str, int ch, int start, int ocurrence) {
        int from = start;
        int ret = -1;
        for (int i = 0; i < ocurrence; i++) {
            ret = str.indexOf(ch, from);
            if (ret == -1) {
                return ret;
            }
            from = ret + 1;
        }
        return ret;
    }

    public static String extractNumbers(String content) {
        if (isEmpty(content)) {
            return "";
        }
        return content.replaceAll("\\D", "");
    }

    public static String toHexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            int ub = b & MotionEventCompat.ACTION_MASK;
            builder.append(digits[ub >> 4]);
            builder.append(digits[ub & 15]);
        }
        return builder.toString();
    }

    public static final String format(String format, Object... arguments) {
        return MessageFormat.format(format, arguments);
    }

    public static CharSequence buildTickerMessage(String name, String subject, String body) {
        String str;
        String displayAddress = name;
        if (displayAddress == null) {
            str = "";
        } else {
            str = displayAddress.replace('\n', ' ').replace('\r', ' ');
        }
        StringBuilder buf = new StringBuilder(str);
        buf.append(':').append(' ');
        int offset = buf.length();
        if (!TextUtils.isEmpty(subject)) {
            buf.append(subject.replace('\n', ' ').replace('\r', ' '));
            buf.append(' ');
        }
        if (!TextUtils.isEmpty(body)) {
            buf.append(body.replace('\n', ' ').replace('\r', ' '));
        }
        SpannableString spanText = new SpannableString(buf.toString());
        spanText.setSpan(new StyleSpan(1), 0, offset, 33);
        return spanText;
    }

    public static String[] convert2Array(List<String> stringList) {
        String[] strings = new String[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
            strings[i] = (String) stringList.get(i);
        }
        return strings;
    }

    public static String getDirByPath(String path) {
        if (path == null) {
            return null;
        }
        if (path.length() == 0) {
            return "";
        }
        int pos = path.lastIndexOf(47);
        if (pos == -1) {
            return "";
        }
        return path.substring(0, pos);
    }

    public static String getDisplayNameByPath(String path) {
        if (path == null) {
            return null;
        }
        if (path.length() == 0) {
            return "";
        }
        int pos = path.lastIndexOf(47);
        if (pos == -1) {
            return "";
        }
        return path.substring(pos + 1);
    }

    public static String formatTimeStampString(Context context, long when, boolean fullFormat) {
        int format_flags;
        Time then = new Time();
        then.set(when);
        Time now = new Time();
        now.setToNow();
        if (then.year != now.year) {
            format_flags = 527104 | 20;
        } else if (then.yearDay != now.yearDay) {
            format_flags = 527104 | 16;
        } else {
            format_flags = 527104 | 1;
        }
        if (fullFormat) {
            format_flags |= 17;
        }
        return DateUtils.formatDateTime(context, when, format_flags);
    }
}
