package com.heyzap.http;

import com.heyzap.internal.Logger;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

public abstract class BinaryHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "BinaryHttpResponseHandler";
    private String[] mAllowedContentTypes;

    public abstract void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th);

    public abstract void onSuccess(int i, Header[] headerArr, byte[] bArr);

    public String[] getAllowedContentTypes() {
        return this.mAllowedContentTypes;
    }

    public BinaryHttpResponseHandler() {
        this.mAllowedContentTypes = new String[]{"image/jpeg", "image/png"};
    }

    public BinaryHttpResponseHandler(String[] allowedContentTypes) {
        this.mAllowedContentTypes = new String[]{"image/jpeg", "image/png"};
        if (allowedContentTypes != null) {
            this.mAllowedContentTypes = allowedContentTypes;
        } else {
            Logger.error("Constructor passed allowedContentTypes was null !");
        }
    }

    public final void sendResponseMessage(HttpResponse response) throws IOException {
        int i = 0;
        StatusLine status = response.getStatusLine();
        Header[] contentTypeHeaders = response.getHeaders("Content-Type");
        if (contentTypeHeaders.length != 1) {
            sendFailureMessage(status.getStatusCode(), response.getAllHeaders(), null, new HttpResponseException(status.getStatusCode(), "None, or more than one, Content-Type Header found!"));
            return;
        }
        Header contentTypeHeader = contentTypeHeaders[0];
        boolean foundAllowedContentType = false;
        String[] allowedContentTypes = getAllowedContentTypes();
        int length = allowedContentTypes.length;
        while (i < length) {
            String anAllowedContentType = allowedContentTypes[i];
            try {
                if (Pattern.matches(anAllowedContentType, contentTypeHeader.getValue())) {
                    foundAllowedContentType = true;
                }
            } catch (PatternSyntaxException e) {
                Logger.error("Given pattern is not valid: " + anAllowedContentType, e);
            }
            i++;
        }
        if (foundAllowedContentType) {
            super.sendResponseMessage(response);
        } else {
            sendFailureMessage(status.getStatusCode(), response.getAllHeaders(), null, new HttpResponseException(status.getStatusCode(), "Content-Type not allowed!"));
        }
    }
}
