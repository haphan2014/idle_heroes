package com.heyzap.house.abstr;

import android.content.Context;
import com.google.android.gms.games.Games;
import com.heyzap.house.model.AdModel;
import com.heyzap.house.request.FetchRequest;
import com.heyzap.house.request.FetchRequest.OnFetchResponse;
import com.heyzap.http.JsonHttpResponseHandler;
import com.heyzap.internal.Logger;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AbstractFetchHandler extends JsonHttpResponseHandler {
    private static final OnFetchResponse DEFAULT_CALLBACK = new C13321();
    private OnFetchResponse callback;
    private Context context;
    private FetchRequest request;
    private AtomicBoolean sentResponse = new AtomicBoolean(false);

    static class C13321 implements OnFetchResponse {
        C13321() {
        }

        public void onModelsReceived(List<AdModel> list) {
        }

        public void onFetchResponse(List<AdModel> list, FetchRequest request, Throwable e) {
            if (e != null) {
                Logger.trace("No fetch callback handler registered", e);
            } else {
                Logger.warn("(FETCH) No fetch callback handler registered.");
            }
        }
    }

    public class AlreadyInstalledException extends Exception {
        private static final long serialVersionUID = -6895029172770132009L;

        public AlreadyInstalledException(String impressionId) {
            super(impressionId);
        }
    }

    public class FetchFailureException extends Exception {
        public FetchFailureException(String s) {
            super(s);
        }
    }

    protected abstract List<AdModel> onFetchSuccess(JSONObject jSONObject) throws Exception;

    public AbstractFetchHandler(Context context, FetchRequest request) {
        this.request = request;
        this.context = context;
    }

    public void setCallback(OnFetchResponse callbackResponse) {
        this.callback = callbackResponse;
    }

    public final void onFetchReceived(JSONObject response) {
        try {
            if (!response.has(Games.EXTRA_STATUS) || response.isNull(Games.EXTRA_STATUS) || response.getInt(Games.EXTRA_STATUS) > 200) {
                throw new Exception("no status");
            }
            List<AdModel> models = onFetchSuccess(response);
            if (models == null || models.size() == 0) {
                throw new Exception("no_fill");
            } else if (shouldFireCallbackOnSuccess(models).booleanValue()) {
                onSuccess(models);
            } else {
                getCallback().onModelsReceived(models);
            }
        } catch (Throwable e) {
            onFetchReceived(e);
        } catch (AlreadyInstalledException e2) {
            FetchRequest request = getFetchRequest();
            request.setRejectedImpressionId(e2.getMessage());
            request.execute(getContext());
        } catch (Throwable e3) {
            onFetchReceived(e3);
        }
    }

    public void onFetchReceived(Throwable e) {
        onFailure(e);
    }

    public FetchRequest getFetchRequest() {
        return this.request;
    }

    public Context getContext() {
        return this.context;
    }

    public Boolean shouldFireCallbackOnSuccess(List<AdModel> list) {
        return Boolean.valueOf(true);
    }

    protected void onSuccess(List<AdModel> models) {
        if (!this.sentResponse.get()) {
            Logger.format("(FETCH) %s", models);
            this.sentResponse.set(true);
            for (AdModel model : models) {
                model.setIsReady(true);
            }
            getCallback().onFetchResponse(models, getFetchRequest(), null);
        }
    }

    protected void onFailure(Throwable e) {
        if (!this.sentResponse.get()) {
            if ((e instanceof FetchFailureException) || (e instanceof AlreadyInstalledException)) {
                Logger.debug("(FETCH FAILED) Error: " + e.getMessage());
            } else {
                Logger.trace("(FETCH FAILED) Error", e);
            }
            this.sentResponse.set(true);
            getCallback().onFetchResponse(null, getFetchRequest(), e);
        }
    }

    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        onFetchReceived(response);
    }

    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        onFetchReceived(new Throwable("default onSuccess"));
    }

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        onFetchReceived(new Throwable(String.format("HTTP Status: %d", new Object[]{Integer.valueOf(statusCode)})));
    }

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
        onFetchReceived(new Throwable(String.format("HTTP Status: %d", new Object[]{Integer.valueOf(statusCode)})));
    }

    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        onFetchReceived(new Throwable(String.format("HTTP Status: %d", new Object[]{Integer.valueOf(statusCode)})));
    }

    public OnFetchResponse getCallback() {
        if (this.callback == null) {
            return DEFAULT_CALLBACK;
        }
        return this.callback;
    }
}
