package org.nexage.sourcekit.mraid.properties;

import java.util.Arrays;

public final class MRAIDOrientationProperties {
    public static final int FORCE_ORIENTATION_LANDSCAPE = 1;
    public static final int FORCE_ORIENTATION_NONE = 2;
    public static final int FORCE_ORIENTATION_PORTRAIT = 0;
    public boolean allowOrientationChange;
    public int forceOrientation;

    public MRAIDOrientationProperties() {
        this(true, 2);
    }

    public MRAIDOrientationProperties(boolean allowOrientationChange, int forceOrienation) {
        this.allowOrientationChange = allowOrientationChange;
        this.forceOrientation = forceOrienation;
    }

    public static int forceOrientationFromString(String name) {
        int idx = Arrays.asList(new String[]{"portrait", "landscape", "none"}).indexOf(name);
        return idx != -1 ? idx : 2;
    }

    public String forceOrientationString() {
        switch (this.forceOrientation) {
            case 0:
                return "portrait";
            case 1:
                return "landscape";
            case 2:
                return "none";
            default:
                return "error";
        }
    }
}
