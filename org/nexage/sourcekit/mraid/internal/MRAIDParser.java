package org.nexage.sourcekit.mraid.internal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.nexage.sourcekit.mraid.MRAIDNativeFeature;

public class MRAIDParser {
    private static final String TAG = "MRAIDParser";

    public Map<String, String> parseCommandUrl(String commandUrl) {
        String command;
        MRAIDLog.m2730d(TAG, "parseCommandUrl " + commandUrl);
        String s = commandUrl.substring(8);
        Map<String, String> params = new HashMap();
        int idx = s.indexOf(63);
        if (idx != -1) {
            command = s.substring(0, idx);
            for (String param : s.substring(idx + 1).split("&")) {
                idx = param.indexOf(61);
                params.put(param.substring(0, idx), param.substring(idx + 1));
            }
        } else {
            command = s;
        }
        if (!isValidCommand(command)) {
            MRAIDLog.m2737w("command " + command + " is unknown");
            return null;
        } else if (checkParamsForCommand(command, params)) {
            Map<String, String> commandMap = new HashMap();
            commandMap.put("command", command);
            commandMap.putAll(params);
            return commandMap;
        } else {
            MRAIDLog.m2737w("command URL " + commandUrl + " is missing parameters");
            return null;
        }
    }

    private boolean isValidCommand(String command) {
        return Arrays.asList(new String[]{"close", "createCalendarEvent", "expand", "open", "playVideo", "resize", "setOrientationProperties", "setResizeProperties", MRAIDNativeFeature.STORE_PICTURE, "useCustomClose"}).contains(command);
    }

    private boolean checkParamsForCommand(String command, Map<String, String> params) {
        if (command.equals("createCalendarEvent")) {
            return params.containsKey("eventJSON");
        }
        if (command.equals("open") || command.equals("playVideo") || command.equals(MRAIDNativeFeature.STORE_PICTURE)) {
            return params.containsKey("url");
        }
        if (command.equals("setOrientationProperties")) {
            if (params.containsKey("allowOrientationChange") && params.containsKey("forceOrientation")) {
                return true;
            }
            return false;
        } else if (command.equals("setResizeProperties")) {
            if (params.containsKey("width") && params.containsKey("height") && params.containsKey("offsetX") && params.containsKey("offsetY") && params.containsKey("customClosePosition") && params.containsKey("allowOffscreen")) {
                return true;
            }
            return false;
        } else if (command.equals("useCustomClose")) {
            return params.containsKey("useCustomClose");
        } else {
            return true;
        }
    }
}
