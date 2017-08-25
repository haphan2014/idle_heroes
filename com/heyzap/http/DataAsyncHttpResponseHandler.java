package com.heyzap.http;

import android.os.Message;
import com.heyzap.internal.Logger;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.util.ByteArrayBuffer;

public abstract class DataAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "DataAsyncHttpResponseHandler";
    protected static final int PROGRESS_DATA_MESSAGE = 6;

    public void onProgressData(byte[] responseBody) {
    }

    public final void sendProgressDataMessage(byte[] responseBytes) {
        sendMessage(obtainMessage(6, new Object[]{responseBytes}));
    }

    protected void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 6:
                Object[] response = (Object[]) message.obj;
                if (response == null || response.length < 1) {
                    Logger.error("PROGRESS_DATA_MESSAGE didn't got enough params");
                    return;
                }
                try {
                    onProgressData((byte[]) response[0]);
                    return;
                } catch (Throwable t) {
                    Logger.error("custom onProgressData contains an error", t);
                    return;
                }
            default:
                return;
        }
    }

    public byte[] getResponseData(HttpEntity entity) throws IOException {
        byte[] responseBody = null;
        if (entity != null) {
            InputStream instream = entity.getContent();
            if (instream != null) {
                try {
                    long contentLength = entity.getContentLength();
                    if (contentLength > 2147483647L) {
                        throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
                    }
                    if (contentLength < 0) {
                        contentLength = 4096;
                    }
                    ByteArrayBuffer buffer = new ByteArrayBuffer((int) contentLength);
                    byte[] tmp = new byte[4096];
                    while (true) {
                        int l = instream.read(tmp);
                        if (l == -1 || Thread.currentThread().isInterrupted()) {
                            responseBody = buffer.toByteArray();
                        } else {
                            buffer.append(tmp, 0, l);
                            sendProgressDataMessage(copyOfRange(tmp, 0, l));
                        }
                    }
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

    public static byte[] copyOfRange(byte[] original, int start, int end) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NullPointerException {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        int originalLength = original.length;
        if (start < 0 || start > originalLength) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int resultLength = end - start;
        byte[] result = new byte[resultLength];
        System.arraycopy(original, start, result, 0, Math.min(resultLength, originalLength - start));
        return result;
    }
}
