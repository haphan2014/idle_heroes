package com.heyzap.house.handler;

import android.content.Context;
import com.heyzap.house.abstr.AbstractActivity;
import com.heyzap.house.abstr.AbstractFetchHandler;
import com.heyzap.house.abstr.AbstractFetchHandler.AlreadyInstalledException;
import com.heyzap.house.abstr.AbstractFetchHandler.FetchFailureException;
import com.heyzap.house.model.AdModel;
import com.heyzap.house.model.AdModel.ModelPostFetchCompleteListener;
import com.heyzap.house.model.InterstitialModel;
import com.heyzap.house.model.VideoModel;
import com.heyzap.house.request.FetchRequest;
import com.heyzap.internal.Utils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class InterstitialFetchHandler extends AbstractFetchHandler {

    class C13431 implements ModelPostFetchCompleteListener {
        C13431() {
        }

        public void onComplete(Object model, Throwable e) {
            if (e != null) {
                InterstitialFetchHandler.this.onFailure(e);
                return;
            }
            ArrayList<AdModel> models = new ArrayList();
            models.add((AdModel) model);
            InterstitialFetchHandler.this.onSuccess(models);
        }
    }

    public InterstitialFetchHandler(Context context, FetchRequest request) {
        super(context, request);
    }

    public List<AdModel> onFetchSuccess(JSONObject response) throws Exception {
        if (!response.has(AbstractActivity.ACTIVITY_INTENT_IMPRESSION_KEY) || response.isNull(AbstractActivity.ACTIVITY_INTENT_IMPRESSION_KEY)) {
            throw new FetchFailureException("no_fill");
        } else if (!response.has("promoted_game_package") || response.isNull("promoted_game_package") || response.getString("promoted_game_package").equals("")) {
            throw new FetchFailureException("no promoted_game_package");
        } else if (Utils.packageIsInstalled(response.getString("promoted_game_package"), getContext())) {
            throw new AlreadyInstalledException(response.optString(AbstractActivity.ACTIVITY_INTENT_IMPRESSION_KEY));
        } else {
            AdModel model;
            if (response.optString("creative_type", InterstitialModel.FORMAT).equals(VideoModel.FORMAT)) {
                model = new VideoModel(response);
            } else {
                model = new InterstitialModel(response);
            }
            model.setTag(getFetchRequest().getTag());
            model.doPostFetchActions(getContext(), new C13431());
            ArrayList<AdModel> models = new ArrayList();
            models.add(model);
            return models;
        }
    }

    public Boolean shouldFireCallbackOnSuccess(List<AdModel> models) {
        if (models == null || models.size() < 1) {
            return Boolean.valueOf(true);
        }
        AdModel model = (AdModel) models.get(0);
        if (model.showOnlyAfterContentLoaded()) {
            return Boolean.valueOf(false);
        }
        if (model.shouldRefetchIfNotReady()) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }
}
