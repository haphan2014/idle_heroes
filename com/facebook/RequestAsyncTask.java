package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

public class RequestAsyncTask extends AsyncTask<Void, Void, List<Response>> {
    private static final String TAG = RequestAsyncTask.class.getCanonicalName();
    private static Method executeOnExecutorMethod;
    private final HttpURLConnection connection;
    private Exception exception;
    private final RequestBatch requests;

    static {
        for (Method method : AsyncTask.class.getMethods()) {
            if ("executeOnExecutor".equals(method.getName())) {
                Class<?>[] parameters = method.getParameterTypes();
                if (parameters.length == 2 && parameters[0] == Executor.class && parameters[1].isArray()) {
                    executeOnExecutorMethod = method;
                    return;
                }
            }
        }
    }

    public RequestAsyncTask(Request... requests) {
        this(null, new RequestBatch(requests));
    }

    public RequestAsyncTask(Collection<Request> requests) {
        this(null, new RequestBatch((Collection) requests));
    }

    public RequestAsyncTask(RequestBatch requests) {
        this(null, requests);
    }

    public RequestAsyncTask(HttpURLConnection connection, Request... requests) {
        this(connection, new RequestBatch(requests));
    }

    public RequestAsyncTask(HttpURLConnection connection, Collection<Request> requests) {
        this(connection, new RequestBatch((Collection) requests));
    }

    public RequestAsyncTask(HttpURLConnection connection, RequestBatch requests) {
        this.requests = requests;
        this.connection = connection;
    }

    protected final Exception getException() {
        return this.exception;
    }

    protected final RequestBatch getRequests() {
        return this.requests;
    }

    public String toString() {
        return "{RequestAsyncTask: " + " connection: " + this.connection + ", requests: " + this.requests + "}";
    }

    protected void onPreExecute() {
        super.onPreExecute();
        if (this.requests.getCallbackHandler() == null) {
            this.requests.setCallbackHandler(new Handler());
        }
    }

    protected void onPostExecute(List<Response> result) {
        super.onPostExecute(result);
        if (this.exception != null) {
            Log.d(TAG, String.format("onPostExecute: exception encountered during request: %s", new Object[]{this.exception.getMessage()}));
        }
    }

    protected List<Response> doInBackground(Void... params) {
        try {
            if (this.connection == null) {
                return this.requests.executeAndWait();
            }
            return Request.executeConnectionAndWait(this.connection, this.requests);
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }

    RequestAsyncTask executeOnSettingsExecutor() {
        if (executeOnExecutorMethod != null) {
            try {
                executeOnExecutorMethod.invoke(this, new Object[]{Settings.getExecutor(), null});
            } catch (InvocationTargetException e) {
            } catch (IllegalAccessException e2) {
            }
        } else {
            execute(new Void[0]);
        }
        return this;
    }
}
