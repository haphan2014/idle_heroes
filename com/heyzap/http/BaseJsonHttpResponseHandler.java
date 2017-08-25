package com.heyzap.http;

import com.applovin.sdk.AppLovinErrorCodes;
import org.apache.http.Header;

public abstract class BaseJsonHttpResponseHandler<JSON_TYPE> extends TextHttpResponseHandler {
    private static final String LOG_TAG = "BaseJsonHttpResponseHandler";

    public abstract void onFailure(int i, Header[] headerArr, Throwable th, String str, JSON_TYPE json_type);

    public abstract void onSuccess(int i, Header[] headerArr, String str, JSON_TYPE json_type);

    protected abstract JSON_TYPE parseResponse(String str, boolean z) throws Throwable;

    public BaseJsonHttpResponseHandler() {
        this(AsyncHttpResponseHandler.DEFAULT_CHARSET);
    }

    public BaseJsonHttpResponseHandler(String encoding) {
        super(encoding);
    }

    public final void onSuccess(final int statusCode, final Header[] headers, final String responseString) {
        if (statusCode != AppLovinErrorCodes.NO_FILL) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        final JSON_TYPE jsonResponse = BaseJsonHttpResponseHandler.this.parseResponse(responseString, false);
                        BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                BaseJsonHttpResponseHandler.this.onSuccess(statusCode, headers, responseString, jsonResponse);
                            }
                        });
                    } catch (final Throwable t) {
                        BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                BaseJsonHttpResponseHandler.this.onFailure(statusCode, headers, t, responseString, null);
                            }
                        });
                    }
                }
            }).start();
        } else {
            onSuccess(statusCode, headers, null, null);
        }
    }

    public final void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        if (responseString != null) {
            final String str = responseString;
            final int i = statusCode;
            final Header[] headerArr = headers;
            final Throwable th = throwable;
            new Thread(new Runnable() {

                class C13702 implements Runnable {
                    C13702() {
                    }

                    public void run() {
                        BaseJsonHttpResponseHandler.this.onFailure(i, headerArr, th, str, null);
                    }
                }

                public void run() {
                    try {
                        final JSON_TYPE jsonResponse = BaseJsonHttpResponseHandler.this.parseResponse(str, true);
                        BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                BaseJsonHttpResponseHandler.this.onFailure(i, headerArr, th, str, jsonResponse);
                            }
                        });
                    } catch (Throwable th) {
                        BaseJsonHttpResponseHandler.this.postRunnable(new C13702());
                    }
                }
            }).start();
            return;
        }
        onFailure(statusCode, headers, throwable, null, null);
    }
}
