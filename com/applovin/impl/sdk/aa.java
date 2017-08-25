package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class aa {
    private final AppLovinLogger f368a;
    private final AppLovinSdkImpl f369b;
    private final String f370c = "FileManager";
    private final Object f371d;

    aa(AppLovinSdk appLovinSdk) {
        this.f369b = (AppLovinSdkImpl) appLovinSdk;
        this.f368a = appLovinSdk.getLogger();
        this.f371d = new Object();
    }

    long m275a(long j) {
        return j / 1048576;
    }

    public File m276a(String str, Context context, boolean z) {
        if (AppLovinSdkUtils.isValidString(str)) {
            this.f368a.mo635d("FileManager", "Looking up cached resource: " + str);
            if (!m281a(context) && !z) {
                return null;
            }
            File file;
            if (str.contains("icon")) {
                str = str.replace("/", "_").replace(".", "_");
            }
            synchronized (this.f371d) {
                File b = m287b(context);
                file = new File(b, str);
                try {
                    b.mkdirs();
                } catch (Exception e) {
                    return null;
                }
            }
            return file;
        }
        this.f369b.getLogger().mo635d("FileManager", "Nothing to look up, skipping...");
        return null;
    }

    String m277a(Context context, String str) {
        return m278a(context, str, false);
    }

    String m278a(Context context, String str, boolean z) {
        if (str == null || str.equals("")) {
            this.f369b.getLogger().mo635d("FileManager", "Nothing to cache, skipping...");
            return null;
        } else if (dp.m704a(this.f369b, str)) {
            this.f369b.getLogger().mo635d("FileManager", "Starting caching of resource " + str);
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            File a = m276a(lastPathSegment, context, false);
            return (a == null || !a.exists()) ? m284a(a, str) ? z ? Uri.fromFile(a).toString() : lastPathSegment : null : z ? Uri.fromFile(a).toString() : lastPathSegment;
        } else {
            this.f369b.getLogger().mo635d("FileManager", "Domain is not whitelisted, skipping precache for URL " + str);
            return null;
        }
    }

    void m279a(long j, Context context) {
        long c = (long) m289c();
        if (c == -1) {
            this.f368a.mo635d("FileManager", "Cache has no maximum size set; skipping drop...");
        } else if (m275a(j) > c) {
            this.f368a.mo635d("FileManager", "Cache has exceeded maximum size; dropping...");
            m294g(context);
            this.f369b.m255b().m555a("cache_drop_count");
        } else {
            this.f368a.mo635d("FileManager", "Cache is present but under size limit; not dropping...");
        }
    }

    boolean m280a() {
        return ((Boolean) this.f369b.m253a(cd.at)).booleanValue();
    }

    protected boolean m281a(Context context) {
        if (C0163n.m733a("android.permission.WRITE_EXTERNAL_STORAGE", context)) {
            return true;
        }
        if (C0163n.m737c() && !((Boolean) this.f369b.m253a(cd.bq)).booleanValue()) {
            return true;
        }
        this.f369b.getLogger().mo641w("FileManager", "Application lacks required WRITE_EXTERNAL_STORAGE manifest permission.");
        return false;
    }

    boolean m282a(ByteArrayOutputStream byteArrayOutputStream, File file) {
        boolean z;
        Throwable e;
        this.f368a.mo635d("FileManager", "Writing resource to filesystem: " + file.getName());
        synchronized (this.f371d) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    z = true;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        this.f368a.mo637e("FileManager", "Unable to write data to file", e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                                z = false;
                            }
                        }
                        z = false;
                        return z;
                    } catch (Throwable th) {
                        e = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                fileOutputStream = null;
                this.f368a.mo637e("FileManager", "Unable to write data to file", e);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                z = false;
                return z;
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        }
        return z;
    }

    boolean m283a(File file) {
        boolean delete;
        this.f368a.mo635d("FileManager", "Removing file " + file.getName() + " from filesystem...");
        synchronized (this.f371d) {
            try {
                delete = file.delete();
            } catch (Throwable e) {
                this.f368a.mo637e("FileManager", "Failed to remove file " + file.getName() + " from filesystem!", e);
                delete = false;
            }
        }
        return delete;
    }

    boolean m284a(File file, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable e;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream2;
        InputStream inputStream = null;
        this.f368a.mo635d("FileManager", "Starting caching of " + str + " into " + file.getAbsoluteFile());
        if (((Boolean) this.f369b.m253a(cd.bf)).booleanValue() && !str.contains("https://")) {
            this.f369b.getLogger().mo641w("FileManager", "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
            str = str.replace("http://", "https://");
        }
        InputStream inputStream2 = null;
        try {
            HttpURLConnection httpURLConnection2;
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            } catch (IOException e2) {
                e = e2;
                httpURLConnection = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
                try {
                    this.f368a.mo637e("FileManager", "Failed to cache \"" + str + "\" into \"" + file.getAbsolutePath() + "\"", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e5) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e8) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                httpURLConnection = null;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw e;
            }
            try {
                httpURLConnection2.setConnectTimeout(((Integer) this.f369b.m253a(cd.f576o)).intValue());
                httpURLConnection2.setReadTimeout(((Integer) this.f369b.m253a(cd.f578q)).intValue());
                httpURLConnection2.setDefaultUseCaches(true);
                httpURLConnection2.setUseCaches(true);
                httpURLConnection2.setAllowUserInteraction(false);
                httpURLConnection2.setInstanceFollowRedirects(true);
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    if (null != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e9) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e10) {
                        }
                    }
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception e11) {
                        }
                    }
                    return false;
                }
                inputStream = httpURLConnection2.getInputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, bArr.length);
                    if (read < 0) {
                        break;
                    }
                    try {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Exception e12) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e13) {
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e14) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e15) {
                            }
                        }
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception e16) {
                            }
                        }
                        return false;
                    }
                }
                if (m282a(byteArrayOutputStream, file)) {
                    this.f368a.mo635d("FileManager", "Caching completed for " + file);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e17) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e18) {
                        }
                    }
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception e19) {
                        }
                    }
                    return true;
                }
                this.f368a.mo636e("FileManager", "Failed to cache \"" + str + "\" into \"" + file.getAbsolutePath() + "\"");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e20) {
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e21) {
                    }
                }
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e22) {
                    }
                }
                return false;
            } catch (Throwable e23) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                HttpURLConnection httpURLConnection3 = httpURLConnection2;
                e = e23;
                httpURLConnection = httpURLConnection3;
                this.f368a.mo637e("FileManager", "Failed to cache \"" + str + "\" into \"" + file.getAbsolutePath() + "\"", e);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            } catch (Throwable e232) {
                Throwable th3 = e232;
                httpURLConnection = httpURLConnection2;
                e = th3;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw e;
            }
        } catch (IOException e24) {
            e = e24;
            httpURLConnection = null;
            byteArrayOutputStream2 = null;
            this.f368a.mo637e("FileManager", "Failed to cache \"" + str + "\" into \"" + file.getAbsolutePath() + "\"", e);
            if (inputStream != null) {
                inputStream.close();
            }
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return false;
        } catch (Throwable th4) {
            e = th4;
            httpURLConnection = null;
            byteArrayOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
    }

    public boolean m285a(String str, Context context) {
        boolean b;
        synchronized (this.f371d) {
            b = m288b(str, context, false);
        }
        return b;
    }

    long m286b() {
        long longValue = ((Long) this.f369b.m253a(cd.au)).longValue();
        return (longValue < 0 || !m280a()) ? -1 : longValue;
    }

    File m287b(Context context) {
        return m281a(context) ? new File(context.getExternalFilesDir(null), "al") : new File(context.getCacheDir(), "al");
    }

    public boolean m288b(String str, Context context, boolean z) {
        boolean z2;
        synchronized (this.f371d) {
            File a = m276a(str, context, z);
            z2 = (a == null || !a.exists() || a.isDirectory()) ? false : true;
        }
        return z2;
    }

    int m289c() {
        int intValue = ((Integer) this.f369b.m253a(cd.av)).intValue();
        return (intValue < 0 || !m280a()) ? -1 : intValue;
    }

    public List m290c(Context context) {
        File b = m287b(context);
        if (!b.isDirectory()) {
            return new ArrayList(0);
        }
        List asList;
        synchronized (this.f371d) {
            asList = Arrays.asList(b.listFiles());
        }
        return asList;
    }

    public boolean m291d(Context context) {
        if (((Boolean) this.f369b.m253a(cd.br)).booleanValue()) {
            try {
                m276a(".nomedia", context, false);
                File file = new File(m287b(context), ".nomedia");
                if (file != null) {
                    if (file.exists()) {
                        return true;
                    }
                    this.f369b.getLogger().mo635d("FileManager", "Dropping .nomedia file at " + file.getAbsolutePath());
                    return file.createNewFile();
                }
            } catch (Throwable e) {
                this.f369b.getLogger().mo642w("FileManager", "Failed to create nomedia file", e);
            }
        }
        return false;
    }

    void m292e(Context context) {
        try {
            if (!m280a()) {
                return;
            }
            if (this.f369b.isEnabled()) {
                this.f368a.mo636e("FileManager", "Cannot empty file cache after SDK has completed initialization and ad loads are in progress!");
                return;
            }
            this.f368a.mo635d("FileManager", "Compacting cache...");
            synchronized (this.f371d) {
                m279a(m293f(context), context);
            }
        } catch (Throwable e) {
            this.f368a.mo637e("FileManager", "Caught exception while compacting cache!", e);
            this.f369b.getSettingsManager().m502a(cd.at, Boolean.valueOf(false));
            this.f369b.getSettingsManager().m505b();
        }
    }

    long m293f(Context context) {
        long j = 0;
        long b = m286b();
        Object obj = b != -1 ? 1 : null;
        long toSeconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        synchronized (this.f371d) {
            for (File file : m290c(context)) {
                Object obj2 = null;
                if (obj != null && toSeconds - TimeUnit.MILLISECONDS.toSeconds(file.lastModified()) > b) {
                    this.f368a.mo635d("FileManager", "File " + file.getName() + " has expired, removing...");
                    m283a(file);
                    obj2 = 1;
                }
                if (obj2 != null) {
                    this.f369b.m255b().m555a("cached_files_expired");
                } else {
                    j += file.length();
                }
            }
        }
        return j;
    }

    void m294g(Context context) {
        synchronized (this.f371d) {
            for (File a : m290c(context)) {
                m283a(a);
            }
        }
    }
}
