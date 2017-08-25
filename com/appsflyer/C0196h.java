package com.appsflyer;

class C0196h {
    private static String devKey;
    private static String replacedKey;

    public static void setDevKey(String aDevKey) {
        devKey = aDevKey;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < aDevKey.length()) {
            if (i == 0 || i == 1 || i > aDevKey.length() - 5) {
                stringBuilder.append(aDevKey.charAt(i));
            } else {
                stringBuilder.append("*");
            }
            i++;
        }
        replacedKey = stringBuilder.toString();
    }

    public static void logMessageMaskKey(String str) {
        if (devKey == null) {
            C0196h.setDevKey(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
        } else if (devKey != null && str.contains(devKey)) {
            C0188a.afLog(str.replace(devKey, replacedKey));
        }
    }
}
