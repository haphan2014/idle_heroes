package com.heyzap.http;

import com.applovin.sdk.AppLovinErrorCodes;
import com.heyzap.internal.Logger;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonHttpResponseHandler extends TextHttpResponseHandler {
    private static final String LOG_TAG = "JsonHttpResponseHandler";

    public JsonHttpResponseHandler() {
        super(AsyncHttpResponseHandler.DEFAULT_CHARSET);
    }

    public JsonHttpResponseHandler(String encoding) {
        super(encoding);
    }

    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
    }

    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
    }

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
    }

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
    }

    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
    }

    public void onSuccess(int statusCode, Header[] headers, String responseString) {
    }

    public final void onSuccess(final int statusCode, final Header[] headers, final byte[] responseBytes) {
        if (statusCode != AppLovinErrorCodes.NO_FILL) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        final Object jsonResponse = JsonHttpResponseHandler.this.parseResponse(responseBytes);
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                if (jsonResponse instanceof JSONObject) {
                                    JsonHttpResponseHandler.this.onSuccess(statusCode, headers, (JSONObject) jsonResponse);
                                } else if (jsonResponse instanceof JSONArray) {
                                    JsonHttpResponseHandler.this.onSuccess(statusCode, headers, (JSONArray) jsonResponse);
                                } else {
                                    JsonHttpResponseHandler.this.onFailure(statusCode, headers, new JSONException("Unexpected response type " + jsonResponse.getClass().getName()), (JSONObject) null);
                                }
                            }
                        });
                    } catch (final JSONException ex) {
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                JsonHttpResponseHandler.this.onFailure(statusCode, headers, ex, (JSONObject) null);
                            }
                        });
                    }
                }
            }).start();
        } else {
            onSuccess(statusCode, headers, new JSONObject());
        }
    }

    public void onFailure(int statusCode, Header[] headers, byte[] responseBytes, Throwable throwable) {
        if (responseBytes != null) {
            final byte[] bArr = responseBytes;
            final int i = statusCode;
            final Header[] headerArr = headers;
            final Throwable th = throwable;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        final Object jsonResponse = JsonHttpResponseHandler.this.parseResponse(bArr);
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                if (jsonResponse instanceof JSONObject) {
                                    JsonHttpResponseHandler.this.onFailure(i, headerArr, th, (JSONObject) jsonResponse);
                                } else if (jsonResponse instanceof JSONArray) {
                                    JsonHttpResponseHandler.this.onFailure(i, headerArr, th, (JSONArray) jsonResponse);
                                } else if (jsonResponse instanceof String) {
                                    JsonHttpResponseHandler.this.onFailure(i, headerArr, (String) jsonResponse, th);
                                } else {
                                    JsonHttpResponseHandler.this.onFailure(i, headerArr, new JSONException("Unexpected response type " + jsonResponse.getClass().getName()), (JSONObject) null);
                                }
                            }
                        });
                    } catch (final JSONException ex) {
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                JsonHttpResponseHandler.this.onFailure(i, headerArr, ex, (JSONObject) null);
                            }
                        });
                    }
                }
            }).start();
            return;
        }
        Logger.debug("response body is null, calling onFailure(Throwable, JSONObject)  url: " + getRequestURI());
        onFailure(statusCode, headers, throwable, (JSONObject) null);
    }

    protected Object parseResponse(byte[] responseBody) throws JSONException {
        if (responseBody == null) {
            return null;
        }
        Object result = null;
        String jsonString = TextHttpResponseHandler.getResponseString(responseBody, getCharset());
        if (jsonString != null) {
            jsonString = jsonString.trim();
            if (jsonString.startsWith("{") || jsonString.startsWith("[")) {
                result = new JSONTokener(jsonString).nextValue();
            }
        }
        if (result == null) {
            return jsonString;
        }
        return result;
    }
}
