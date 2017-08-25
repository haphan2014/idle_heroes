package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.Api.ClientKey;
import com.heyzap.http.AsyncHttpResponseHandler;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public final class zzk {
    public static final ClientKey<zze> zzNX = new ClientKey();
    public static final String zzUQ = zzf.zzbE("com.google.cast.receiver");
    public static final String zzUR = zzf.zzbE("com.google.cast.tp.connection");
    public static final Charset zzUS;

    static {
        Charset charset = null;
        try {
            charset = Charset.forName(AsyncHttpResponseHandler.DEFAULT_CHARSET);
        } catch (IllegalCharsetNameException e) {
        } catch (UnsupportedCharsetException e2) {
        }
        zzUS = charset;
    }
}
