package com.heyzap.http;

import com.heyzap.internal.Logger;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

class AsyncHttpRequest implements Runnable {
    private boolean cancelIsNotified = false;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount;
    private boolean isCancelled = false;
    private boolean isFinished = false;
    private final HttpUriRequest request;
    private final ResponseHandlerInterface responseHandler;

    public AsyncHttpRequest(AbstractHttpClient client, HttpContext context, HttpUriRequest request, ResponseHandlerInterface responseHandler) {
        this.client = client;
        this.context = context;
        this.request = request;
        this.responseHandler = responseHandler;
    }

    public void run() {
        if (!isCancelled()) {
            if (this.responseHandler != null) {
                this.responseHandler.sendStartMessage();
            }
            if (!isCancelled()) {
                try {
                    makeRequestWithRetries();
                } catch (IOException e) {
                    if (isCancelled() || this.responseHandler == null) {
                        Logger.error("makeRequestWithRetries returned error, but handler is null", e);
                    } else {
                        this.responseHandler.sendFailureMessage(0, null, null, e);
                    }
                }
                if (!isCancelled()) {
                    if (this.responseHandler != null) {
                        this.responseHandler.sendFinishMessage();
                    }
                    this.isFinished = true;
                }
            }
        }
    }

    private void makeRequest() throws IOException {
        if (!isCancelled()) {
            if (this.request.getURI().getScheme() == null) {
                throw new MalformedURLException("No valid URI scheme was provided");
            }
            HttpResponse response = this.client.execute(this.request, this.context);
            if (!isCancelled() && this.responseHandler != null) {
                this.responseHandler.sendResponseMessage(response);
            }
        }
    }

    private void makeRequestWithRetries() throws IOException {
        IOException cause;
        int i;
        Exception e;
        boolean retry = true;
        HttpRequestRetryHandler retryHandler = this.client.getHttpRequestRetryHandler();
        IOException cause2 = null;
        while (retry) {
            try {
                makeRequest();
                return;
            } catch (UnknownHostException e2) {
                cause = new IOException("UnknownHostException exception: " + e2.getMessage());
                if (this.executionCount > 0) {
                    i = this.executionCount + 1;
                    this.executionCount = i;
                    if (retryHandler.retryRequest(cause, i, this.context)) {
                        retry = true;
                        if (retry || this.responseHandler == null) {
                            cause2 = cause;
                        } else {
                            this.responseHandler.sendRetryMessage(this.executionCount);
                            cause2 = cause;
                        }
                    }
                }
                retry = false;
                if (retry) {
                }
                cause2 = cause;
            } catch (NullPointerException e3) {
                Logger.trace("AsyncHttp NPE: ", e3);
                cause = new IOException("NPE in HttpClient: " + e3.getMessage());
                i = this.executionCount + 1;
                this.executionCount = i;
                retry = retryHandler.retryRequest(cause, i, this.context);
                if (retry) {
                }
                cause2 = cause;
            } catch (HttpResponseException e4) {
                try {
                    if (!isCancelled()) {
                        cause = new IOException("Failed to load " + this.request.getURI(), e4);
                        if (e4.getStatusCode() != 302) {
                            i = this.executionCount + 1;
                            this.executionCount = i;
                            retry = retryHandler.retryRequest(cause, i, this.context);
                        } else {
                            retry = false;
                        }
                        if (retry) {
                        }
                        cause2 = cause;
                    } else {
                        return;
                    }
                } catch (Exception e5) {
                    e = e5;
                    cause = cause2;
                }
            } catch (IOException e6) {
                if (!isCancelled()) {
                    cause = new IOException("Failed to load " + this.request.getURI(), e6);
                    try {
                        i = this.executionCount + 1;
                        this.executionCount = i;
                        retry = retryHandler.retryRequest(cause, i, this.context);
                        if (retry) {
                        }
                        cause2 = cause;
                    } catch (Exception e7) {
                        e = e7;
                    }
                } else {
                    return;
                }
            }
        }
        cause = cause2;
        throw cause;
        Logger.error("Unhandled exception origin cause", e);
        cause = new IOException("Unhandled exception: " + e.getMessage());
        throw cause;
    }

    public boolean isCancelled() {
        if (this.isCancelled) {
            sendCancelNotification();
        }
        return this.isCancelled;
    }

    private synchronized void sendCancelNotification() {
        if (!(this.isFinished || !this.isCancelled || this.cancelIsNotified)) {
            this.cancelIsNotified = true;
            if (this.responseHandler != null) {
                this.responseHandler.sendCancelMessage();
            }
        }
    }

    public boolean isDone() {
        return isCancelled() || this.isFinished;
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        this.isCancelled = true;
        if (!(!mayInterruptIfRunning || this.request == null || this.request.isAborted())) {
            this.request.abort();
        }
        return isCancelled();
    }
}
