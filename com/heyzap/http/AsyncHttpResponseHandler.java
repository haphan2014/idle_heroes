package com.heyzap.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

public abstract class AsyncHttpResponseHandler implements ResponseHandlerInterface {
    protected static final int BUFFER_SIZE = 4096;
    protected static final int CANCEL_MESSAGE = 6;
    public static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    private static final String LOG_TAG = "AsyncHttpResponseHandler";
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    private Handler handler;
    private Header[] requestHeaders = null;
    private URI requestURI = null;
    private String responseCharset = DEFAULT_CHARSET;
    private Header[] responseHeaders = null;
    private Boolean useSynchronousMode = Boolean.valueOf(false);

    static class ResponderHandler extends Handler {
        private final WeakReference<AsyncHttpResponseHandler> mResponder;

        ResponderHandler(AsyncHttpResponseHandler service) {
            this.mResponder = new WeakReference(service);
        }

        public void handleMessage(Message msg) {
            AsyncHttpResponseHandler service = (AsyncHttpResponseHandler) this.mResponder.get();
            if (service != null) {
                service.handleMessage(msg);
            }
        }
    }

    public abstract void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th);

    public abstract void onSuccess(int i, Header[] headerArr, byte[] bArr);

    public URI getRequestURI() {
        return this.requestURI;
    }

    public Header[] getRequestHeaders() {
        return this.requestHeaders;
    }

    public void setRequestURI(URI requestURI) {
        this.requestURI = requestURI;
    }

    public void setRequestHeaders(Header[] requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public Header[] getResponseHeaders() {
        return this.responseHeaders;
    }

    public Header getResponseHeader(String name) {
        if (this.responseHeaders == null) {
            return null;
        }
        for (Header header : this.responseHeaders) {
            if (header.getName().equals(name)) {
                return header;
            }
        }
        return null;
    }

    public boolean getUseSynchronousMode() {
        return this.useSynchronousMode.booleanValue();
    }

    public void setUseSynchronousMode(boolean value) {
        this.useSynchronousMode = Boolean.valueOf(value);
    }

    public void setCharset(String charset) {
        this.responseCharset = charset;
    }

    public String getCharset() {
        return this.responseCharset == null ? DEFAULT_CHARSET : this.responseCharset;
    }

    public AsyncHttpResponseHandler() {
        postRunnable(null);
    }

    public void onProgress(int bytesWritten, int totalSize) {
    }

    public void onStart() {
    }

    public void onFinish() {
    }

    public void onRetry(int retryNo) {
    }

    public void onCancel() {
    }

    public final void sendProgressMessage(int bytesWritten, int bytesTotal) {
        sendMessage(obtainMessage(4, new Object[]{Integer.valueOf(bytesWritten), Integer.valueOf(bytesTotal)}));
    }

    public final void sendSuccessMessage(int statusCode, Header[] headers, byte[] responseBytes) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(statusCode), headers, responseBytes}));
    }

    public final void sendFailureMessage(int statusCode, Header[] headers, byte[] responseBody, Throwable throwable) {
        sendMessage(obtainMessage(1, new Object[]{Integer.valueOf(statusCode), headers, responseBody, throwable}));
    }

    public final void sendStartMessage() {
        sendMessage(obtainMessage(2, null));
    }

    public final void sendFinishMessage() {
        sendMessage(obtainMessage(3, null));
    }

    public final void sendRetryMessage(int retryNo) {
        sendMessage(obtainMessage(5, new Object[]{Integer.valueOf(retryNo)}));
    }

    public final void sendCancelMessage() {
        sendMessage(obtainMessage(6, null));
    }

    protected void handleMessage(Message message) {
        Object[] response;
        switch (message.what) {
            case 0:
                response = (Object[]) message.obj;
                if (response != null && response.length >= 3) {
                    onSuccess(((Integer) response[0]).intValue(), (Header[]) response[1], (byte[]) response[2]);
                    return;
                }
                return;
            case 1:
                response = (Object[]) message.obj;
                if (response != null && response.length >= 4) {
                    onFailure(((Integer) response[0]).intValue(), (Header[]) response[1], (byte[]) response[2], (Throwable) response[3]);
                    return;
                }
                return;
            case 2:
                onStart();
                return;
            case 3:
                onFinish();
                return;
            case 4:
                response = (Object[]) message.obj;
                if (response != null && response.length >= 2) {
                    try {
                        onProgress(((Integer) response[0]).intValue(), ((Integer) response[1]).intValue());
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                }
                return;
            case 5:
                response = (Object[]) message.obj;
                if (response != null && response.length == 1) {
                    onRetry(((Integer) response[0]).intValue());
                    return;
                }
                return;
            case 6:
                onCancel();
                return;
            default:
                return;
        }
    }

    protected void sendMessage(Message msg) {
        if (getUseSynchronousMode() || this.handler == null) {
            handleMessage(msg);
        } else if (!Thread.currentThread().isInterrupted()) {
            this.handler.sendMessage(msg);
        }
    }

    protected void postRunnable(Runnable runnable) {
        if (!(Looper.myLooper() == null)) {
            if (this.handler == null) {
                this.handler = new ResponderHandler(this);
            }
            this.handler.post(runnable);
        } else if (runnable != null) {
            runnable.run();
        }
    }

    protected Message obtainMessage(int responseMessageId, Object responseMessageData) {
        if (this.handler != null) {
            return this.handler.obtainMessage(responseMessageId, responseMessageData);
        }
        Message msg = Message.obtain();
        if (msg == null) {
            return msg;
        }
        msg.what = responseMessageId;
        msg.obj = responseMessageData;
        return msg;
    }

    public void sendResponseMessage(HttpResponse response) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine status = response.getStatusLine();
            byte[] responseBody = getResponseData(response.getEntity());
            this.responseHeaders = response.getAllHeaders();
            if (!Thread.currentThread().isInterrupted()) {
                if (status.getStatusCode() >= 300) {
                    sendFailureMessage(status.getStatusCode(), response.getAllHeaders(), responseBody, new HttpResponseException(status.getStatusCode(), status.getReasonPhrase()));
                } else {
                    sendSuccessMessage(status.getStatusCode(), response.getAllHeaders(), responseBody);
                }
            }
        }
    }

    public byte[] getResponseData(HttpEntity entity) throws IOException {
        int buffersize = 4096;
        byte[] responseBody = null;
        if (entity != null) {
            InputStream instream = entity.getContent();
            if (instream != null) {
                try {
                    long contentLength = entity.getContentLength();
                    if (contentLength > 2147483647L) {
                        throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
                    }
                    if (contentLength >= 0) {
                        buffersize = (int) contentLength;
                    }
                    ByteArrayBuffer buffer = new ByteArrayBuffer(buffersize);
                    byte[] tmp = new byte[4096];
                    int count = 0;
                    while (true) {
                        int l = instream.read(tmp);
                        if (l == -1 || Thread.currentThread().isInterrupted()) {
                            instream.close();
                            responseBody = buffer.toByteArray();
                        } else {
                            count += l;
                            buffer.append(tmp, 0, l);
                            sendProgressMessage(count, (int) contentLength);
                        }
                    }
                    instream.close();
                    responseBody = buffer.toByteArray();
                    instream.close();
                } catch (OutOfMemoryError e) {
                    System.gc();
                    throw new IOException("File too large to fit into available memory");
                } catch (Throwable th) {
                    instream.close();
                }
            }
        }
        return responseBody;
    }
}
