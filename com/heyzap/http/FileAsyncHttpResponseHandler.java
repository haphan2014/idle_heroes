package com.heyzap.http;

import android.content.Context;
import com.heyzap.internal.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.conn.EofSensorInputStream;

public abstract class FileAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
    static final /* synthetic */ boolean $assertionsDisabled = (!FileAsyncHttpResponseHandler.class.desiredAssertionStatus());
    private static final String LOG_TAG = "FileAsyncHttpResponseHandler";
    private File mFile;

    public abstract void onFailure(int i, Header[] headerArr, Throwable th, File file);

    public abstract void onSuccess(int i, Header[] headerArr, File file);

    public FileAsyncHttpResponseHandler(File file) {
        if ($assertionsDisabled || file != null) {
            this.mFile = file;
            return;
        }
        throw new AssertionError();
    }

    public FileAsyncHttpResponseHandler(Context context) {
        this.mFile = getTemporaryFile(context);
    }

    public boolean deleteTargetFile() {
        return getTargetFile() != null && getTargetFile().delete();
    }

    protected File getTemporaryFile(Context context) {
        if ($assertionsDisabled || context != null) {
            try {
                return File.createTempFile("temp_", "_handled", context.getCacheDir());
            } catch (Throwable t) {
                Logger.error("Cannot create temporary file", t);
                return null;
            }
        }
        throw new AssertionError();
    }

    protected File getTargetFile() {
        if ($assertionsDisabled || this.mFile != null) {
            return this.mFile;
        }
        throw new AssertionError();
    }

    public final void onFailure(int statusCode, Header[] headers, byte[] responseBytes, Throwable throwable) {
        onFailure(statusCode, headers, throwable, getTargetFile());
    }

    public final void onSuccess(int statusCode, Header[] headers, byte[] responseBytes) {
        onSuccess(statusCode, headers, getTargetFile());
    }

    public byte[] getResponseData(HttpEntity entity) throws IOException {
        if (entity != null) {
            InputStream instream = entity.getContent();
            long contentLength = entity.getContentLength();
            FileOutputStream buffer = new FileOutputStream(getTargetFile());
            if (instream != null) {
                try {
                    byte[] tmp = new byte[4096];
                    int count = 0;
                    while (true) {
                        int l = instream.read(tmp);
                        if (l != -1 && !Thread.currentThread().isInterrupted()) {
                            count += l;
                            buffer.write(tmp, 0, l);
                            sendProgressMessage(count, (int) contentLength);
                        }
                    }
                    if (instream instanceof EofSensorInputStream) {
                        ((EofSensorInputStream) instream).abortConnection();
                    } else {
                        instream.close();
                    }
                    buffer.flush();
                    buffer.close();
                } catch (Throwable th) {
                    if (instream instanceof EofSensorInputStream) {
                        ((EofSensorInputStream) instream).abortConnection();
                    } else {
                        instream.close();
                    }
                    buffer.flush();
                    buffer.close();
                }
            }
        }
        return null;
    }
}
