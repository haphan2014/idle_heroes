package com.heyzap.http;

import com.heyzap.internal.Logger;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;

public abstract class TextHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "TextHttpResponseHandler";

    public abstract void onFailure(int i, Header[] headerArr, String str, Throwable th);

    public abstract void onSuccess(int i, Header[] headerArr, String str);

    public TextHttpResponseHandler() {
        this(AsyncHttpResponseHandler.DEFAULT_CHARSET);
    }

    public TextHttpResponseHandler(String encoding) {
        setCharset(encoding);
    }

    public void onSuccess(int statusCode, Header[] headers, byte[] responseBytes) {
        onSuccess(statusCode, headers, getResponseString(responseBytes, getCharset()));
    }

    public void onFailure(int statusCode, Header[] headers, byte[] responseBytes, Throwable throwable) {
        onFailure(statusCode, headers, getResponseString(responseBytes, getCharset()), throwable);
    }

    public static String getResponseString(byte[] stringBytes, String charset) {
        if (stringBytes == null) {
            return null;
        }
        try {
            return new String(stringBytes, charset);
        } catch (UnsupportedEncodingException e) {
            Logger.error("Encoding response into string failed", e);
            return null;
        }
    }
}
