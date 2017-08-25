package com.heyzap.house.handler;

import android.content.Context;
import com.heyzap.house.abstr.AbstractActivity;
import com.heyzap.house.abstr.AbstractFetchHandler;
import com.heyzap.house.abstr.AbstractFetchHandler.AlreadyInstalledException;
import com.heyzap.house.model.AdModel;
import com.heyzap.house.model.NativeModel;
import com.heyzap.house.request.FetchRequest;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class NativeFetchHandler extends AbstractFetchHandler {
    public NativeFetchHandler(Context context, FetchRequest request) {
        super(context, request);
    }

    public List<AdModel> onFetchSuccess(JSONObject response) throws Exception {
        if (response.has("ads")) {
            JSONArray ads = response.getJSONArray("ads");
            int successes = 0;
            ArrayList<AdModel> models = new ArrayList();
            ArrayList<String> alreadyInstalledImpressions = new ArrayList();
            int i = 0;
            while (i < ads.length()) {
                try {
                    JSONObject obj = ads.getJSONObject(i);
                    if (!obj.has("promoted_game_package") || obj.isNull("promoted_game_package") || obj.getString("promoted_game_package").equals("")) {
                        throw new Exception("no promoted_game_package");
                    } else if (Utils.packageIsInstalled(obj.getString("promoted_game_package"), getContext())) {
                        throw new AlreadyInstalledException(obj.optString(AbstractActivity.ACTIVITY_INTENT_IMPRESSION_KEY));
                    } else {
                        NativeModel model = new NativeModel(obj);
                        model.setTag(getFetchRequest().getTag());
                        model.doPostFetchActions(getContext(), null);
                        model.setAdUnit(AdUnit.NATIVE);
                        models.add(model);
                        successes++;
                        i++;
                    }
                } catch (AlreadyInstalledException e) {
                    alreadyInstalledImpressions.add(e.getMessage());
                } catch (Throwable e2) {
                    Logger.trace(e2);
                }
            }
            if (alreadyInstalledImpressions.size() > 0) {
                AttributionHandler.getInstance().didInstall(getContext(), alreadyInstalledImpressions, Boolean.valueOf(true));
            }
            if (successes != 0) {
                return models;
            }
            throw new Exception("no_fill");
        }
        throw new Exception("no ads");
    }
}
