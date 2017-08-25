package com.heyzap.common.vast.processor;

import android.text.TextUtils;
import com.heyzap.common.vast.model.TrackingEvent;
import com.heyzap.common.vast.model.VASTMediaFile;
import com.heyzap.common.vast.model.VASTModel;
import com.heyzap.common.vast.util.VASTLog;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class VASTModelPostValidator {
    private static final String TAG = "VASTModelPostValidator";

    public static boolean validate(VASTModel model, VASTMediaPicker mediaPicker) {
        VASTLog.m783d(TAG, "validate");
        if (validateModel(model)) {
            boolean isValid = false;
            if (mediaPicker != null) {
                VASTMediaFile mediaFile = mediaPicker.pickVideo(model.getMediaFiles());
                if (mediaFile != null) {
                    String url = mediaFile.getValue();
                    if (!TextUtils.isEmpty(url)) {
                        isValid = true;
                        model.setPickedMediaFile(mediaFile);
                        VASTLog.m783d(TAG, "mediaPicker selected mediaFile with URL " + url);
                    }
                }
            } else {
                VASTLog.m788w(TAG, "mediaPicker: We don't have a compatible media file to play.");
            }
            VASTLog.m783d(TAG, "Validator returns: " + (isValid ? "valid" : "not valid (no media file)"));
            return isValid;
        }
        VASTLog.m783d(TAG, "Validator returns: not valid (invalid model)");
        return false;
    }

    private static boolean validateModel(VASTModel model) {
        VASTLog.m783d(TAG, "validateModel");
        boolean isValid = true;
        List<String> impressions = model.getImpressions();
        if (impressions == null || impressions.size() == 0) {
            VASTLog.m783d(TAG, "Validation Error: no impression tracking found");
            isValid = false;
        }
        isValid = isValid && validateUris(impressions);
        if (isValid && validateUris(model.getErrorUrl())) {
            isValid = true;
        } else {
            isValid = false;
        }
        if (isValid && validateTrackingUris(model.getTrackingUrls())) {
            isValid = true;
        } else {
            isValid = false;
        }
        if (isValid && validateMediaUris(model.getMediaFiles())) {
            return true;
        }
        return false;
    }

    private static boolean validateMediaUris(List<VASTMediaFile> mediaFiles) {
        if (mediaFiles == null || mediaFiles.size() == 0) {
            VASTLog.m783d(TAG, "Validator error: mediaFile list invalid");
            return false;
        }
        for (VASTMediaFile mediaFile : mediaFiles) {
            try {
                URI uri = new URI(mediaFile.getValue());
            } catch (URISyntaxException e) {
                VASTLog.m783d(TAG, "Media Validator error: uri invalid: " + mediaFile.getValue());
                return false;
            }
        }
        return true;
    }

    private static boolean validateTrackingUris(HashMap<TrackingEvent, List<String>> trackingUrls) {
        if (trackingUrls == null) {
            VASTLog.m783d(TAG, "TrackingUriValidationError: null tracking map");
            return false;
        }
        for (Entry<TrackingEvent, List<String>> entry : trackingUrls.entrySet()) {
            if (!validateUris((List) entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateUris(List<String> uris) {
        if (uris == null) {
            return true;
        }
        for (String uri : uris) {
            if (uri == null) {
                try {
                    VASTLog.m783d(TAG, "Validator error: null uri detected");
                    return false;
                } catch (URISyntaxException e) {
                    VASTLog.m783d(TAG, "Validator error: uri invalid: " + uri);
                    return false;
                }
            }
            URI uri2 = new URI(uri);
        }
        return true;
    }
}
