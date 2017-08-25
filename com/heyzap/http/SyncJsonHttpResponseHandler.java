package com.heyzap.http;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

public class SyncJsonHttpResponseHandler extends JsonHttpResponseHandler {
    public Throwable error = null;
    public Boolean finished = Boolean.valueOf(false);
    public JSONObject responseObj = null;

    public SyncJsonHttpResponseHandler() {
        setUseSynchronousMode(true);
    }

    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        this.finished = Boolean.valueOf(true);
        this.error = new Throwable("Wrong response type");
        synchronized (this) {
            notifyAll();
        }
    }

    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        this.responseObj = response;
        this.finished = Boolean.valueOf(true);
        synchronized (this) {
            notifyAll();
        }
    }

    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        this.error = throwable;
        this.finished = Boolean.valueOf(true);
        synchronized (this) {
            notifyAll();
        }
    }

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        this.error = throwable;
        this.finished = Boolean.valueOf(true);
        synchronized (this) {
            notifyAll();
        }
    }

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
        this.error = throwable;
        this.finished = Boolean.valueOf(true);
        synchronized (this) {
            notifyAll();
        }
    }

    public JSONObject getResponse() {
        return this.responseObj;
    }

    public Throwable getError() {
        return this.error;
    }

    public Boolean hasError() {
        return Boolean.valueOf(this.error != null);
    }

    public Boolean isFinished() {
        return this.finished;
    }
}
