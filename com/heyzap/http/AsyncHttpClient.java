package com.heyzap.http;

import android.content.Context;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.internal.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class AsyncHttpClient {
    public static final int DEFAULT_MAX_CONNECTIONS = 10;
    public static final int DEFAULT_MAX_RETRIES = 0;
    public static final int DEFAULT_RETRY_SLEEP_TIME_MILLIS = 1500;
    public static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    public static final int DEFAULT_SOCKET_TIMEOUT = 10000;
    public static final String ENCODING_GZIP = "gzip";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String LOG_TAG = "AsyncHttpClient";
    public static final String VERSION = "1.4.5";
    private final Map<String, String> clientHeaderMap;
    private CookieStore cookieStore;
    private final DefaultHttpClient httpClient;
    private boolean isUrlEncodingEnabled;
    private int maxConnections;
    private final Object requestLock;
    private final Map<Context, List<RequestHandle>> requestMap;
    private ExecutorService threadPool;
    private int timeout;

    class C13631 implements HttpRequestInterceptor {
        C13631() {
        }

        public void process(HttpRequest request, HttpContext context) {
            if (!request.containsHeader(AsyncHttpClient.HEADER_ACCEPT_ENCODING)) {
                request.addHeader(AsyncHttpClient.HEADER_ACCEPT_ENCODING, AsyncHttpClient.ENCODING_GZIP);
            }
            for (String header : AsyncHttpClient.this.clientHeaderMap.keySet()) {
                request.addHeader(header, (String) AsyncHttpClient.this.clientHeaderMap.get(header));
            }
        }
    }

    class C13642 implements HttpResponseInterceptor {
        C13642() {
        }

        public void process(HttpResponse response, HttpContext context) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                Header encoding = entity.getContentEncoding();
                if (encoding != null) {
                    for (HeaderElement element : encoding.getElements()) {
                        if (element.getName().equalsIgnoreCase(AsyncHttpClient.ENCODING_GZIP)) {
                            response.setEntity(new InflatingEntity(entity));
                            return;
                        }
                    }
                }
            }
        }
    }

    private static class InflatingEntity extends HttpEntityWrapper {
        private GZIPInputStream stream;

        public InflatingEntity(HttpEntity wrapped) {
            super(wrapped);
        }

        public InputStream getContent() throws IOException {
            this.stream = new GZIPInputStream(this.wrappedEntity.getContent());
            return this.stream;
        }

        public long getContentLength() {
            return -1;
        }

        public void finalize() throws Throwable {
            super.finalize();
            if (this.stream != null) {
                try {
                    this.stream.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public AsyncHttpClient() {
        this(false, 80, 443);
    }

    public AsyncHttpClient(int httpPort) {
        this(false, httpPort, 443);
    }

    public AsyncHttpClient(int httpPort, int httpsPort) {
        this(false, httpPort, httpsPort);
    }

    public AsyncHttpClient(boolean fixNoHttpResponseException, int httpPort, int httpsPort) {
        this(getDefaultSchemeRegistry(fixNoHttpResponseException, httpPort, httpsPort));
    }

    private static SchemeRegistry getDefaultSchemeRegistry(boolean fixNoHttpResponseException, int httpPort, int httpsPort) {
        SSLSocketFactory sslSocketFactory;
        if (fixNoHttpResponseException) {
            if (httpPort < 1) {
                httpPort = 80;
            }
            if (httpsPort < 1) {
                httpsPort = 443;
            }
            if (fixNoHttpResponseException) {
                sslSocketFactory = SSLSocketFactory.getSocketFactory();
            } else {
                sslSocketFactory = MySSLSocketFactory.getFixedSocketFactory();
            }
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), httpPort));
            schemeRegistry.register(new Scheme("https", sslSocketFactory, httpsPort));
            return schemeRegistry;
        }
        if (httpPort < 1) {
            httpPort = 80;
        }
        if (httpsPort < 1) {
            httpsPort = 443;
        }
        if (fixNoHttpResponseException) {
            sslSocketFactory = SSLSocketFactory.getSocketFactory();
        } else {
            sslSocketFactory = MySSLSocketFactory.getFixedSocketFactory();
        }
        SchemeRegistry schemeRegistry2 = new SchemeRegistry();
        schemeRegistry2.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), httpPort));
        schemeRegistry2.register(new Scheme("https", sslSocketFactory, httpsPort));
        return schemeRegistry2;
    }

    public AsyncHttpClient(SchemeRegistry schemeRegistry) {
        this.maxConnections = 10;
        this.timeout = 10000;
        this.isUrlEncodingEnabled = true;
        this.requestLock = new Object();
        BasicHttpParams httpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(httpParams, (long) this.timeout);
        ConnManagerParams.setMaxConnectionsPerRoute(httpParams, new ConnPerRouteBean(this.maxConnections));
        ConnManagerParams.setMaxTotalConnections(httpParams, 10);
        HttpConnectionParams.setSoTimeout(httpParams, this.timeout);
        HttpConnectionParams.setConnectionTimeout(httpParams, this.timeout);
        HttpConnectionParams.setTcpNoDelay(httpParams, true);
        HttpConnectionParams.setSocketBufferSize(httpParams, 8192);
        HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(httpParams, String.format("android-async-http/%s (http://loopj.com/android-async-http)", new Object[]{VERSION}));
        ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager(httpParams, schemeRegistry);
        this.threadPool = ExecutorPool.getInstance();
        this.requestMap = new WeakHashMap();
        this.clientHeaderMap = new HashMap();
        this.httpClient = new DefaultHttpClient(cm, httpParams);
        this.httpClient.addRequestInterceptor(new C13631());
        this.httpClient.addResponseInterceptor(new C13642());
        this.httpClient.setHttpRequestRetryHandler(new RetryHandler(0, 1500));
    }

    public static void allowRetryExceptionClass(Class<?> cls) {
        if (cls != null) {
            RetryHandler.addClassToWhitelist(cls);
        }
    }

    public static void blockRetryExceptionClass(Class<?> cls) {
        if (cls != null) {
            RetryHandler.addClassToBlacklist(cls);
        }
    }

    public DefaultHttpClient getHttpClient() {
        return this.httpClient;
    }

    public HttpContext createHttpContext() {
        SyncBasicHttpContext ctx = new SyncBasicHttpContext(new BasicHttpContext());
        ctx.setAttribute("http.cookie-store", this.cookieStore);
        return ctx;
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
    }

    public void setThreadPool(ExecutorService threadPool) {
        this.threadPool = threadPool;
    }

    public void setEnableRedirects(final boolean enableRedirects) {
        this.httpClient.setRedirectHandler(new DefaultRedirectHandler() {
            public boolean isRedirectRequested(HttpResponse response, HttpContext context) {
                if (enableRedirects) {
                    return super.isRedirectRequested(response, context);
                }
                return false;
            }
        });
    }

    public void setUserAgent(String userAgent) {
        HttpProtocolParams.setUserAgent(this.httpClient.getParams(), userAgent);
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        if (maxConnections < 1) {
            maxConnections = 10;
        }
        this.maxConnections = maxConnections;
        ConnManagerParams.setMaxConnectionsPerRoute(this.httpClient.getParams(), new ConnPerRouteBean(this.maxConnections));
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int timeout) {
        if (timeout < 1000) {
            timeout = 10000;
        }
        this.timeout = timeout;
        HttpParams httpParams = this.httpClient.getParams();
        ConnManagerParams.setTimeout(httpParams, (long) this.timeout);
        HttpConnectionParams.setSoTimeout(httpParams, this.timeout);
        HttpConnectionParams.setConnectionTimeout(httpParams, this.timeout);
    }

    public void setProxy(String hostname, int port) {
        this.httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(hostname, port));
    }

    public void setProxy(String hostname, int port, String username, String password) {
        this.httpClient.getCredentialsProvider().setCredentials(new AuthScope(hostname, port), new UsernamePasswordCredentials(username, password));
        this.httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(hostname, port));
    }

    public void setSSLSocketFactory(SSLSocketFactory sslSocketFactory) {
        this.httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", sslSocketFactory, 443));
    }

    public void setMaxRetriesAndTimeout(int retries, int timeout) {
        this.httpClient.setHttpRequestRetryHandler(new RetryHandler(retries, timeout));
    }

    public void addHeader(String header, String value) {
        this.clientHeaderMap.put(header, value);
    }

    public void removeHeader(String header) {
        this.clientHeaderMap.remove(header);
    }

    public void setBasicAuth(String username, String password) {
        setBasicAuth(username, password, AuthScope.ANY);
    }

    public void setBasicAuth(String username, String password, AuthScope scope) {
        this.httpClient.getCredentialsProvider().setCredentials(scope, new UsernamePasswordCredentials(username, password));
    }

    public void clearBasicAuth() {
        this.httpClient.getCredentialsProvider().clear();
    }

    public void cancelRequests(Context context, boolean mayInterruptIfRunning) {
        List<RequestHandle> requestList = (List) this.requestMap.get(context);
        if (requestList != null) {
            for (RequestHandle requestHandle : requestList) {
                requestHandle.cancel(mayInterruptIfRunning);
            }
            this.requestMap.remove(context);
        }
    }

    public RequestHandle head(String url, ResponseHandlerInterface responseHandler) {
        return head(null, url, null, responseHandler);
    }

    public RequestHandle head(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return head(null, url, params, responseHandler);
    }

    public RequestHandle head(Context context, String url, ResponseHandlerInterface responseHandler) {
        return head(context, url, null, responseHandler);
    }

    public RequestHandle head(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, createHttpContext(), new HttpHead(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params)), null, responseHandler, context);
    }

    public RequestHandle head(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        HttpUriRequest request = new HttpHead(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params));
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, createHttpContext(), request, null, responseHandler, context);
    }

    public RequestHandle get(String url, ResponseHandlerInterface responseHandler) {
        return get(null, url, null, responseHandler);
    }

    public RequestHandle get(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return get(null, url, params, responseHandler);
    }

    public RequestHandle get(Context context, String url, ResponseHandlerInterface responseHandler) {
        return get(context, url, null, responseHandler);
    }

    public RequestHandle get(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, createHttpContext(), new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params)), null, responseHandler, context);
    }

    public RequestHandle get(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        HttpUriRequest request = new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params));
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, createHttpContext(), request, null, responseHandler, context);
    }

    public RequestHandle post(String url, ResponseHandlerInterface responseHandler) {
        return post(null, url, null, responseHandler);
    }

    public RequestHandle post(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return post(null, url, params, responseHandler);
    }

    public RequestHandle post(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return post(context, url, paramsToEntity(params, responseHandler), null, responseHandler);
    }

    public RequestHandle post(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, createHttpContext(), addEntityToRequestBase(new HttpPost(url), entity), contentType, responseHandler, context);
    }

    public RequestHandle post(Context context, String url, Header[] headers, RequestParams params, String contentType, ResponseHandlerInterface responseHandler) {
        HttpEntityEnclosingRequestBase request = new HttpPost(url);
        if (params != null) {
            request.setEntity(paramsToEntity(params, responseHandler));
        }
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, createHttpContext(), request, contentType, responseHandler, context);
    }

    public RequestHandle post(Context context, String url, Header[] headers, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        HttpEntityEnclosingRequestBase request = addEntityToRequestBase(new HttpPost(url), entity);
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, createHttpContext(), request, contentType, responseHandler, context);
    }

    public RequestHandle put(String url, ResponseHandlerInterface responseHandler) {
        return put(null, url, null, responseHandler);
    }

    public RequestHandle put(String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return put(null, url, params, responseHandler);
    }

    public RequestHandle put(Context context, String url, RequestParams params, ResponseHandlerInterface responseHandler) {
        return put(context, url, paramsToEntity(params, responseHandler), null, responseHandler);
    }

    public RequestHandle put(Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, createHttpContext(), addEntityToRequestBase(new HttpPut(url), entity), contentType, responseHandler, context);
    }

    public RequestHandle put(Context context, String url, Header[] headers, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        HttpEntityEnclosingRequestBase request = addEntityToRequestBase(new HttpPut(url), entity);
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, createHttpContext(), request, contentType, responseHandler, context);
    }

    public RequestHandle delete(String url, ResponseHandlerInterface responseHandler) {
        return delete(null, url, responseHandler);
    }

    public RequestHandle delete(Context context, String url, ResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, createHttpContext(), new HttpDelete(url), null, responseHandler, context);
    }

    public RequestHandle delete(Context context, String url, Header[] headers, ResponseHandlerInterface responseHandler) {
        HttpDelete delete = new HttpDelete(url);
        if (headers != null) {
            delete.setHeaders(headers);
        }
        return sendRequest(this.httpClient, createHttpContext(), delete, null, responseHandler, context);
    }

    public RequestHandle delete(Context context, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        HttpDelete httpDelete = new HttpDelete(getUrlWithQueryString(this.isUrlEncodingEnabled, url, params));
        if (headers != null) {
            httpDelete.setHeaders(headers);
        }
        return sendRequest(this.httpClient, createHttpContext(), httpDelete, null, responseHandler, context);
    }

    protected RequestHandle sendRequest(DefaultHttpClient client, HttpContext httpContext, HttpUriRequest uriRequest, String contentType, ResponseHandlerInterface responseHandler, Context context) {
        if (contentType != null) {
            uriRequest.setHeader("Content-Type", contentType);
        }
        responseHandler.setRequestHeaders(uriRequest.getAllHeaders());
        responseHandler.setRequestURI(uriRequest.getURI());
        AsyncHttpRequest request = new AsyncHttpRequest(client, httpContext, uriRequest, responseHandler);
        this.threadPool.submit(request);
        RequestHandle requestHandle = new RequestHandle(request);
        if (context != null) {
            List<RequestHandle> requestList = (List) this.requestMap.get(context);
            if (requestList == null) {
                requestList = new LinkedList();
                this.requestMap.put(context, requestList);
            }
            synchronized (this.requestLock) {
                requestList.add(requestHandle);
                Iterator<RequestHandle> iterator = requestList.iterator();
                while (iterator.hasNext()) {
                    if (((RequestHandle) iterator.next()).shouldBeGarbageCollected()) {
                        iterator.remove();
                    }
                }
            }
        }
        return requestHandle;
    }

    public void setURLEncodingEnabled(boolean enabled) {
        this.isUrlEncodingEnabled = enabled;
    }

    public static String getUrlWithQueryString(boolean shouldEncodeUrl, String url, RequestParams params) {
        if (shouldEncodeUrl) {
            url = url.replace(" ", "%20");
        }
        if (params == null) {
            return url;
        }
        String paramString = params.getParamString();
        if (url.contains("?")) {
            return url + "&" + paramString;
        }
        return url + "?" + paramString;
    }

    private HttpEntity paramsToEntity(RequestParams params, ResponseHandlerInterface responseHandler) {
        HttpEntity entity = null;
        if (params != null) {
            try {
                entity = params.getEntity(responseHandler);
            } catch (Throwable t) {
                if (responseHandler != null) {
                    responseHandler.sendFailureMessage(0, null, null, t);
                } else {
                    Logger.trace(t);
                }
            }
        }
        return entity;
    }

    public boolean isUrlEncodingEnabled() {
        return this.isUrlEncodingEnabled;
    }

    private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase requestBase, HttpEntity entity) {
        if (entity != null) {
            requestBase.setEntity(entity);
        }
        return requestBase;
    }
}
