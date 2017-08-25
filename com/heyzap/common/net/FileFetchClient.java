package com.heyzap.common.net;

import android.content.Context;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.http.AsyncHttpClient;
import com.heyzap.http.FileAsyncHttpResponseHandler;
import com.heyzap.http.RequestHandle;
import com.heyzap.http.ResponseHandlerInterface;

public class FileFetchClient {
    private static AsyncHttpClient client = new AsyncHttpClient();

    static {
        client.setThreadPool(ExecutorPool.getInstance());
    }

    public static RequestHandle fetch(Context context, String url, FileAsyncHttpResponseHandler handler) {
        return client.get(context, url, (ResponseHandlerInterface) handler);
    }
}
