package com.applovin.impl.sdk;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.applovin.impl.adview.C0142v;
import com.applovin.impl.sdk.AppLovinAdImpl.AdTarget;
import com.applovin.impl.sdk.AppLovinAdImpl.Builder;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.heyzap.http.AsyncHttpResponseHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Map.Entry;

public class dp extends AppLovinSdkUtils {
    private static final char[] f668a = "0123456789abcdef".toCharArray();
    private static final char[] f669b = "-'".toCharArray();

    public static double m690a(long j) {
        return ((double) j) / 1000.0d;
    }

    public static float m691a(float f) {
        return 1000.0f * f;
    }

    public static int m692a(Context context) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                Configuration configuration = resources.getConfiguration();
                if (configuration != null) {
                    return configuration.orientation;
                }
            }
        }
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap m693a(android.content.Context r10, int r11, int r12) {
        /*
        r1 = 1;
        r0 = 0;
        r2 = 0;
        r3 = 0;
        r4 = new android.graphics.BitmapFactory$Options;	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r4.<init>();	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r5 = 1;
        r4.inJustDecodeBounds = r5;	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r5 = r10.getResources();	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        android.graphics.BitmapFactory.decodeResource(r5, r11);	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r5 = r4.outHeight;	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        if (r5 > r12) goto L_0x001b;
    L_0x0017:
        r5 = r4.outWidth;	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        if (r5 <= r12) goto L_0x003f;
    L_0x001b:
        r6 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r8 = (double) r12;	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r1 = r4.outHeight;	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r4 = r4.outWidth;	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r1 = java.lang.Math.max(r1, r4);	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r4 = (double) r1;	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r4 = r8 / r4;
        r4 = java.lang.Math.log(r4);	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r8 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r8 = java.lang.Math.log(r8);	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r4 = r4 / r8;
        r4 = java.lang.Math.ceil(r4);	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r1 = (int) r4;	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r4 = (double) r1;	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r4 = java.lang.Math.pow(r6, r4);	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r1 = (int) r4;	 Catch:{ Exception -> 0x0055, all -> 0x005f }
    L_0x003f:
        r4 = new android.graphics.BitmapFactory$Options;	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r4.<init>();	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r4.inSampleSize = r1;	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r1 = r10.getResources();	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r0 = android.graphics.BitmapFactory.decodeResource(r1, r11);	 Catch:{ Exception -> 0x0055, all -> 0x005f }
        r2.close();	 Catch:{ Exception -> 0x0069 }
        r3.close();	 Catch:{ Exception -> 0x0069 }
    L_0x0054:
        return r0;
    L_0x0055:
        r1 = move-exception;
        r2.close();	 Catch:{ Exception -> 0x005d }
        r3.close();	 Catch:{ Exception -> 0x005d }
        goto L_0x0054;
    L_0x005d:
        r1 = move-exception;
        goto L_0x0054;
    L_0x005f:
        r0 = move-exception;
        r2.close();	 Catch:{ Exception -> 0x0067 }
        r3.close();	 Catch:{ Exception -> 0x0067 }
    L_0x0066:
        throw r0;
    L_0x0067:
        r1 = move-exception;
        goto L_0x0066;
    L_0x0069:
        r1 = move-exception;
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.dp.a(android.content.Context, int, int):android.graphics.Bitmap");
    }

    public static Bitmap m694a(File file, int i) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        Throwable th;
        int i2 = 1;
        FileInputStream fileInputStream4 = null;
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            fileInputStream = new FileInputStream(file);
            try {
                BitmapFactory.decodeStream(fileInputStream, null, options);
                fileInputStream.close();
                if (options.outHeight > i || options.outWidth > i) {
                    i2 = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log(((double) i) / ((double) Math.max(options.outHeight, options.outWidth))) / Math.log(0.5d))));
                }
                Options options2 = new Options();
                options2.inSampleSize = i2;
                InputStream fileInputStream5 = new FileInputStream(file);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream5, null, options2);
                    fileInputStream5.close();
                    try {
                        fileInputStream.close();
                        fileInputStream5.close();
                        return decodeStream;
                    } catch (Exception e) {
                        return decodeStream;
                    }
                } catch (Exception e2) {
                    InputStream inputStream = fileInputStream5;
                    fileInputStream2 = fileInputStream;
                    try {
                        fileInputStream2.close();
                        fileInputStream3.close();
                    } catch (Exception e3) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    InputStream inputStream2 = fileInputStream5;
                    try {
                        fileInputStream.close();
                        fileInputStream4.close();
                    } catch (Exception e4) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileInputStream3 = null;
                fileInputStream2 = fileInputStream;
                fileInputStream2.close();
                fileInputStream3.close();
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream.close();
                fileInputStream4.close();
                throw th;
            }
        } catch (Exception e6) {
            fileInputStream3 = null;
            fileInputStream2 = null;
            fileInputStream2.close();
            fileInputStream3.close();
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            fileInputStream.close();
            fileInputStream4.close();
            throw th;
        }
    }

    public static AppLovinAdImpl m695a() {
        return new Builder().setHtml("").setSize(AppLovinAdSize.BANNER).setType(AppLovinAdType.REGULAR).setTarget(AdTarget.DEFAULT).setCloseButtonStyle(C0142v.WhiteXOnOpaqueBlack).setVideoCloseDelay(0.0f).setCloseDelay(0.0f).setCountdownLength(0).setCurrentAdIdNumber(-1).setClCode("").build();
    }

    public static String m696a(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    public static String m697a(String str, AppLovinSdkImpl appLovinSdkImpl) {
        return m698a(str, (Integer) appLovinSdkImpl.m253a(cd.f575n), (String) appLovinSdkImpl.m253a(cd.f574m));
    }

    private static String m698a(String str, Integer num, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException("No algorithm specified");
        } else if (str == null || str.length() < 1) {
            return "";
        } else {
            if (str2.length() < 1 || "none".equals(str2)) {
                return str;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(str2);
                instance.update(str.getBytes(AsyncHttpResponseHandler.DEFAULT_CHARSET));
                str = m701a(instance.digest());
                return (str == null || num.intValue() <= 0) ? str : str.substring(0, Math.min(num.intValue(), str.length()));
            } catch (Throwable e) {
                throw new RuntimeException("Unknown algorithm \"" + str2 + "\"", e);
            } catch (Throwable e2) {
                throw new RuntimeException("Programming error: UTF-8 is not know encoding", e2);
            }
        }
    }

    public static String m699a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        return str2.replace("{PLACEMENT}", m708c(str));
    }

    static String m700a(Map map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(entry.getKey()).append('=').append(entry.getValue());
        }
        return stringBuilder.toString();
    }

    public static String m701a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("No data specified");
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            cArr[i * 2] = f668a[(bArr[i] & 240) >>> 4];
            cArr[(i * 2) + 1] = f668a[bArr[i] & 15];
        }
        return new String(cArr);
    }

    public static void m702a(AppLovinAdLoadListener appLovinAdLoadListener, C0150c c0150c, int i, AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinAdLoadListener != null) {
            try {
                if (appLovinAdLoadListener instanceof C0148y) {
                    ((C0148y) appLovinAdLoadListener).mo602a(c0150c, i);
                } else {
                    appLovinAdLoadListener.failedToReceiveAd(i);
                }
            } catch (Throwable th) {
                appLovinSdkImpl.getLogger().mo637e("AppLovinUtils", "Unable process a failure to receive an ad", th);
            }
        }
    }

    public static boolean m703a(int i, int i2) {
        return (i & i2) != 0;
    }

    public static boolean m704a(AppLovinSdk appLovinSdk, String str) {
        for (String startsWith : ((String) ((AppLovinSdkImpl) appLovinSdk).m253a(cd.f539D)).split(",")) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static long m705b(float f) {
        return (long) Math.round(f);
    }

    public static String m706b(String str) {
        return m698a(str, Integer.valueOf(-1), "SHA-1");
    }

    public static long m707c(float f) {
        return m705b(m691a(f));
    }

    static String m708c(String str) {
        if (!AppLovinSdkUtils.isValidString(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, AsyncHttpResponseHandler.DEFAULT_CHARSET);
        } catch (Throwable e) {
            throw new UnsupportedOperationException(e);
        }
    }
}
