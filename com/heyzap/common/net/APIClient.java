package com.heyzap.common.net;

import android.content.Context;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.http.AsyncHttpClient;
import com.heyzap.http.AsyncHttpResponseHandler;
import com.heyzap.http.RequestHandle;
import com.heyzap.http.RequestParams;
import com.heyzap.http.SDKCookieStore;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.params.HttpParams;

public class APIClient {
    private static final String BASE_ENDPOINT = "/in_game_api/ads/";
    public static String DOMAIN = "ads.heyzap.com";
    private static final String USER_AGENT = "Heyzap Android Client";
    private static AsyncHttpClient client;
    private static SDKCookieStore cookieStore;
    public static final Object lock = new Object();

    private static class GlobalCookieSpec extends BrowserCompatSpec {
        private GlobalCookieSpec() {
        }

        public boolean match(Cookie cookie, CookieOrigin origin) {
            return true;
        }
    }

    private static class GlobalCookieSpecFactory implements CookieSpecFactory {
        private GlobalCookieSpecFactory() {
        }

        public CookieSpec newInstance(HttpParams httpParams) {
            return new GlobalCookieSpec();
        }
    }

    static {
        client = new AsyncHttpClient();
        client = new AsyncHttpClient();
        client.setThreadPool(ExecutorPool.getInstance());
        client.getHttpClient().getCookieSpecs().register("global", new GlobalCookieSpecFactory());
        client.getHttpClient().getParams().setParameter("http.protocol.cookie-policy", "global");
        client.setEnableRedirects(true);
    }

    public static synchronized void init(Context context) {
        synchronized (APIClient.class) {
            if (cookieStore == null) {
                cookieStore = new SDKCookieStore(context);
                client.setCookieStore(cookieStore);
            }
        }
    }

    public static String getBaseUrl() {
        return "https://" + DOMAIN;
    }

    public static void get(Context context, String url, AsyncHttpResponseHandler responseHandler) {
        get(context, url, null, responseHandler);
    }

    public static void get(Context context, String url, RequestParams params) {
        get(context, url, params, null);
    }

    public static void get(final Context context, final String url, final RequestParams params, final AsyncHttpResponseHandler responseHandler) {
        init(context);
        ExecutorPool.getInstance().execute(new Runnable() {
            public void run() {
                RequestParams augmentedParams = APIClient.augmentParams(params, context);
                String finalUrl = APIClient.getAbsoluteUrl(url);
                APIClient.log("GET", finalUrl, augmentedParams.toString());
                APIClient.client.get(context, finalUrl, augmentedParams, responseHandler);
            }
        });
    }

    public static RequestHandle simpleGet(Context context, String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        log("GET", url, params.toString());
        return client.get(context, url, params, responseHandler);
    }

    public static RequestHandle simplePost(Context context, String url, HttpEntity entity, String contentType, AsyncHttpResponseHandler responseHandler) {
        log("POST", url, entity != null ? entity.toString() : "");
        return client.post(context, url, entity, contentType, responseHandler);
    }

    public static RequestHandle simplePost(Context context, String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        log("POST", url, params != null ? params.toString() : "");
        return client.post(context, url, params, responseHandler);
    }

    public static void post(Context context, String url, AsyncHttpResponseHandler responseHandler) {
        post(context, url, null, responseHandler);
    }

    public static void post(Context context, String url, RequestParams params) {
        post(context, url, params, null);
    }

    public static void post(final Context context, final String url, final RequestParams params, final AsyncHttpResponseHandler responseHandler) {
        init(context);
        ExecutorPool.getInstance().execute(new Runnable() {
            public void run() {
                RequestParams augmentedParams = APIClient.augmentParams(params, context);
                String finalUrl = APIClient.getAbsoluteUrl(url);
                APIClient.signParams(finalUrl, augmentedParams);
                APIClient.log("POST", finalUrl, augmentedParams.toString());
                APIClient.client.post(context, finalUrl, augmentedParams, responseHandler);
            }
        });
    }

    private static void signParams(String url, RequestParams params) {
        params.add("extras", signature(url + "?" + params.toString()));
    }

    public static byte[] m781a(byte[] abyte0) throws NoSuchAlgorithmException {
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
        messagedigest.update(abyte0);
        return messagedigest.digest();
    }

    public static String m782b(byte[] abyte0) {
        BigInteger biginteger = new BigInteger(1, abyte0);
        return String.format(Locale.US, "%0" + (abyte0.length << 1) + "x", new Object[]{biginteger});
    }

    public static String signature(String in) {
        try {
            return m782b(m781a(in.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void cancelRequests(Context context) {
        client.cancelRequests(context, true);
    }

    public static void clearCookies(Context context) {
        cookieStore.clear();
        cookieStore = new SDKCookieStore(context);
        client.setCookieStore(cookieStore);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        if (relativeUrl == null || !relativeUrl.startsWith("/")) {
            return (relativeUrl == null || !(relativeUrl.startsWith("http://") || relativeUrl.startsWith("https://"))) ? getBaseUrl() + BASE_ENDPOINT + relativeUrl : relativeUrl;
        } else {
            return getBaseUrl() + relativeUrl;
        }
    }

    public static RequestParams augmentParams(RequestParams params, Context context) {
        synchronized (lock) {
            if (params == null) {
                params = new RequestParams();
            }
            params.merge(Utils.extraParams(context));
        }
        return params;
    }

    private static void log(String method, String finalUrl, String params) {
        Logger.debug(String.format("HTTP %s %s?%s", new Object[]{method, finalUrl, params}));
    }
}
