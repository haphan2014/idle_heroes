package com.vungle.publisher;

import com.vungle.publisher.ew.C1752a;
import com.vungle.publisher.ew.C1753b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import rx.exceptions.Exceptions;
import rx.functions.Func2;

/* compiled from: vungle */
public final class xe implements Func2<vl, gr<?>, gr<?>> {
    public final /* synthetic */ Object call(Object obj, Object obj2) {
        return m2601a((vl) obj, (gr) obj2);
    }

    private static gr<?> m2601a(vl vlVar, gr<?> grVar) {
        try {
            return m2602b(vlVar, grVar);
        } catch (Throwable e) {
            throw Exceptions.propagate(e);
        }
    }

    private static gr<?> m2602b(vl vlVar, gr<?> grVar) throws IOException {
        InputStream inputStream;
        Throwable th;
        int i = 0;
        OutputStream outputStream = null;
        String g = grVar.mo4414g();
        OutputStream fileOutputStream;
        try {
            HttpURLConnection httpURLConnection = vlVar.f3455a;
            inputStream = httpURLConnection.getInputStream();
            try {
                File file = new File(g);
                if (qt.m2373b(file)) {
                    so.m2470a(3, "VunglePrepare", "downloading to: " + g, null);
                    byte[] bArr = new byte[8192];
                    fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            i += read;
                            fileOutputStream.write(bArr, 0, read);
                        } catch (IOException e) {
                            throw new qp("could not write ad to disk");
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e2) {
                                    so.m2470a(3, "VunglePrepare", "error closing input stream", e2);
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable e3) {
                                    so.m2470a(3, "VunglePrepare", "error closing output stream", e3);
                                }
                            }
                            throw th;
                        }
                    }
                    fileOutputStream.flush();
                    int contentLength = httpURLConnection.getContentLength();
                    so.m2470a(2, "VunglePrepare", "response ContentLength = " + contentLength, null);
                    if (contentLength <= i) {
                        so.m2470a(3, "VunglePrepare", "download complete: " + g + ", size: " + i, null);
                        C1753b t = grVar.mo4409t();
                        switch (t) {
                            case postRoll:
                            case template:
                            case asset:
                                grVar.mo4411a(Integer.valueOf(i));
                                break;
                        }
                        so.m2470a(3, "VunglePrepare", t + " downloaded for ad " + grVar.mo4407l(), null);
                        grVar.mo4404a(C1752a.downloaded);
                        grVar.b_();
                        outputStream = fileOutputStream;
                    } else {
                        so.m2470a(5, "VunglePrepare", "download size mismatch: " + g + ", expected size: " + contentLength + ", actual size: " + i, null);
                        grVar.mo4404a(C1752a.failed);
                        grVar.b_();
                        grVar = null;
                        outputStream = fileOutputStream;
                    }
                } else {
                    so.m2470a(5, "VunglePrepare", "could not create or directory not writeable: " + file, null);
                    grVar = null;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e32) {
                        so.m2470a(3, "VunglePrepare", "error closing input stream", e32);
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        so.m2470a(3, "VunglePrepare", "error closing output stream", th3);
                    }
                }
                return grVar;
            } catch (Throwable e322) {
                Throwable th4 = e322;
                fileOutputStream = null;
                th3 = th4;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th3;
            }
        } catch (Throwable e3222) {
            inputStream = null;
            th3 = e3222;
            fileOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th3;
        }
    }
}
