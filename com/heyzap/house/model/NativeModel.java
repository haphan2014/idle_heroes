package com.heyzap.house.model;

import android.content.Context;
import com.heyzap.house.model.AdModel.ModelPostFetchCompleteListener;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeModel extends AdModel implements Serializable {
    public static String FORMAT = "native";
    public JSONObject data;

    public NativeModel(JSONObject response) throws Exception, JSONException {
        super(response);
        this.creativeType = FORMAT;
        if (!response.has("data") || response.isNull("data")) {
            throw new Exception("no_data");
        }
        this.data = response.getJSONObject("data");
    }

    public void cleanup(Context context) throws Exception {
    }

    public void doPostFetchActions(Context context, ModelPostFetchCompleteListener listener) {
        if (listener != null) {
            listener.onComplete(this, null);
        }
    }
}
