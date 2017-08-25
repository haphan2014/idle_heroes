package com.droidhang.util;

import android.util.Log;
import com.heyzap.http.AsyncHttpResponseHandler;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class SimpleHttpThread extends Thread {
    private static final int BYTES_BLOCK = 1024;
    public static final String LOG_TAG = "SimpleHttpThread";
    private LinkedBlockingQueue<HttpTask> tasksQueue = new LinkedBlockingQueue();
    private UIThreadExecutor uiThreadExecutor = new UIThreadExecutor();

    public void init() {
        setDaemon(true);
        start();
    }

    public void postAsyncRequest(String url, String param, SimpleHttpObserver observer, boolean stopThreadWhenFinished) {
        HttpTask task = new HttpTask();
        task.setUrl(url);
        task.setParam(param);
        task.setObserver(observer);
        task.setStopThreadWhenFinished(stopThreadWhenFinished);
        try {
            this.tasksQueue.put(task);
        } catch (InterruptedException e) {
            Log.e(LOG_TAG, "put http post task failed");
        }
    }

    public void run() {
        HttpPost httpPost;
        Throwable th;
        while (true) {
            InputStream is = null;
            try {
                HttpTask task = (HttpTask) this.tasksQueue.take();
                BasicHttpParams params = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(params, 10000);
                HttpConnectionParams.setSoTimeout(params, 10000);
                DefaultHttpClient httpClient = new DefaultHttpClient(params);
                HttpPost post = new HttpPost(task.getUrl());
                try {
                    post.setEntity(new ByteArrayEntity(task.getParam().getBytes(AsyncHttpResponseHandler.DEFAULT_CHARSET)));
                    HttpResponse response = httpClient.execute(post);
                    int statusCode = response.getStatusLine().getStatusCode();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    boolean succeed = statusCode == 200;
                    if (succeed) {
                        byte[] bytes = new byte[1024];
                        is = response.getEntity().getContent();
                        while (true) {
                            int readCount = is.read(bytes, 0, 1024);
                            if (readCount <= 0) {
                                break;
                            }
                            baos.write(bytes, 0, readCount);
                        }
                    } else {
                        Log.e(LOG_TAG, "http post failed with status code " + statusCode);
                    }
                    final HttpTask finalTask = task;
                    final boolean finalSucceed = succeed;
                    final byte[] data = baos.toByteArray();
                    this.uiThreadExecutor.execute(new Runnable() {
                        public void run() {
                            if (finalTask.getObserver() != null) {
                                finalTask.getObserver().onAsyncHttpComplete(finalSucceed, data);
                            }
                        }
                    });
                    if (task.isStopThreadWhenFinished()) {
                        IOUtil.closeQuiet(is);
                        return;
                    } else {
                        IOUtil.closeQuiet(is);
                        httpPost = post;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpPost = post;
                }
            } catch (Throwable th3) {
                Log.w(LOG_TAG, "http post task failed");
                IOUtil.closeQuiet(null);
            }
        }
        IOUtil.closeQuiet(null);
        throw th;
    }
}
