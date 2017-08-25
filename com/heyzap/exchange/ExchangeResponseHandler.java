package com.heyzap.exchange;

import com.google.android.gms.wallet.WalletConstants;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.vast.VASTInterstitial;
import com.heyzap.exchange.ExchangeRequestParams.APIFramework;
import com.heyzap.http.TextHttpResponseHandler;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.Logger;
import java.util.EnumSet;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.json.JSONException;
import org.json.JSONObject;

public class ExchangeResponseHandler extends TextHttpResponseHandler {
    private ExchangeAd ad;
    private SettableFuture<ExchangeResponseHandler> completionFuture;
    private EnumSet<CreativeType> creativeTypes;
    private Throwable error;
    private ContextReference ref;
    private ExchangeRequestParams requestParams;
    private Header[] responseHeaders;
    private String responseStr;
    private String url;

    public static class ClientErrorException extends Exception {
        public ClientErrorException(String message) {
            super(message);
        }
    }

    public static class IllegalContentException extends Exception {
        public IllegalContentException(Exception e) {
            super(e);
        }

        public IllegalContentException(APIFramework contentType, EnumSet<CreativeType> creativeTypes) {
            super(String.format("The content type %s is not valid for the creative types %s", new Object[]{contentType.toString(), creativeTypes.toString()}));
        }
    }

    public static class NoFillException extends Exception {
        public NoFillException() {
            super("no fill");
        }
    }

    public static class ServerErrorException extends Exception {
        public ServerErrorException(Throwable t) {
            super(t);
        }
    }

    public ExchangeAd getAd() {
        return this.ad;
    }

    public ExchangeResponseHandler(SettableFuture<ExchangeResponseHandler> completionFuture, ContextReference ref, EnumSet<CreativeType> creativeTypes, String url, ExchangeRequestParams params) {
        this.completionFuture = completionFuture;
        this.ref = ref;
        this.creativeTypes = creativeTypes;
        this.url = url;
        this.requestParams = params;
        setUseSynchronousMode(true);
    }

    public void onRetry(int retryNo) {
    }

    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        this.responseStr = responseString;
        this.responseHeaders = headers;
        if (statusCode > 500) {
            try {
                throw new ServerErrorException(throwable);
            } catch (Throwable t) {
                Logger.error("ExchangeResponseHandler - Could Not Load Response: " + t.getMessage());
                this.completionFuture.setException(t);
            }
        } else if (statusCode == WalletConstants.ERROR_CODE_INVALID_PARAMETERS) {
            throw new NoFillException();
        } else if (statusCode >= 400) {
            String message = throwable.getMessage();
            if (getContentType().equals("application/json")) {
                try {
                    message = new JSONObject(this.responseStr).optString("error", message);
                } catch (JSONException e) {
                }
            }
            throw new ClientErrorException(message);
        } else if (statusCode >= 300) {
            throw new ServerErrorException(throwable);
        } else {
            throw throwable;
        }
    }

    public void onSuccess(int statusCode, Header[] headers, String responseString) {
        Throwable e;
        this.responseStr = responseString;
        this.responseHeaders = headers;
        if (statusCode > 200) {
            try {
                this.completionFuture.setException(new NoFillException());
            } catch (IllegalArgumentException e2) {
                e = e2;
                Logger.error("Could Not Load Response", e);
                this.completionFuture.setException(e);
            } catch (JSONException e3) {
                e = e3;
                Logger.error("Could Not Load Response", e);
                this.completionFuture.setException(e);
            }
        } else if (this.responseStr == null || !this.responseStr.trim().isEmpty()) {
            JSONObject jSONObject = new JSONObject(responseString);
            JSONObject adObj = jSONObject.getJSONObject("ad");
            APIFramework contentType = APIFramework.valueOf(adObj.getInt("format"));
            JSONObject auctionObj = jSONObject.getJSONObject("auction");
            String adId = auctionObj.getString("id");
            String extraData = auctionObj.optString("extras", "");
            String score = auctionObj.getString("score");
            long loadTtl = adObj.optLong("load_ttl_seconds", 0);
            long expiry = adObj.optLong("expiry_seconds", 0);
            boolean refetchOnExpiry = adObj.optBoolean("refetch_on_expiry", false);
            int height = adObj.getInt("height");
            int width = adObj.getInt("width");
            switch (contentType) {
                case MRAID_2:
                case MRAID_1:
                    if (!this.creativeTypes.contains(CreativeType.BANNER)) {
                        this.ad = new InterstitialMRAIDExchangeAd(adObj.getString("markup"), this.url, adId, score, height, width, loadTtl, expiry, refetchOnExpiry, extraData, this.requestParams, this.ref);
                        break;
                    } else {
                        this.ad = new MRAIDExchangeAd(adObj.getString("markup"), this.url, adId, score, height, width, loadTtl, expiry, refetchOnExpiry, extraData, this.requestParams, this.ref);
                        break;
                    }
                case VAST_2_0_WRAPPER:
                case VAST_2_0:
                    if (!this.creativeTypes.contains(CreativeType.BANNER)) {
                        this.ad = new VASTInterstitial(adObj.getString("markup"), this.url, adId, score, expiry, refetchOnExpiry, extraData, this.requestParams, this.ref);
                        break;
                    }
                    this.completionFuture.setException(new IllegalContentException(contentType, this.creativeTypes));
                    return;
                default:
                    this.completionFuture.setException(new IllegalContentException(contentType, this.creativeTypes));
                    return;
            }
            this.completionFuture.set(this);
        } else {
            this.completionFuture.setException(new NoFillException());
        }
    }

    public String getResponse() {
        return this.responseStr;
    }

    public Throwable getError() {
        return this.error;
    }

    public String getContentType() {
        if (this.responseHeaders == null) {
            return "";
        }
        try {
            Header contentTypeHeader = getResponseHeader("Content-Type");
            if (contentTypeHeader == null) {
                return "";
            }
            HeaderElement[] contentTypeElements = contentTypeHeader.getElements();
            if (contentTypeElements.length == 0) {
                return "";
            }
            return contentTypeElements[0].getName();
        } catch (Exception e) {
            return "";
        }
    }
}
