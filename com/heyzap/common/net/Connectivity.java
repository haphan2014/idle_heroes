package com.heyzap.common.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Connectivity {
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_LTE = 13;

    public enum OpenRtbConnectionType {
        CONNECTION_UNKNOWN(0),
        ETHERNET(1),
        WIFI(2),
        CELL_UNKNOWN(3),
        CELL_2G(4),
        CELL_3G(5),
        CELL_4G(6);
        
        private int value;

        private OpenRtbConnectionType(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public static boolean isConnected(Context context) {
        NetworkInfo info = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    public static boolean isConnectedFast(Context context) {
        NetworkInfo info = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return info != null && info.isConnected() && isConnectionFast(info.getType(), info.getSubtype());
    }

    public static boolean isConnectionFast(int type, int subType) {
        if (type == 1) {
            return true;
        }
        if (type != 0) {
            return false;
        }
        switch (subType) {
            case 1:
                return false;
            case 2:
                return false;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
                return true;
            case 4:
                return false;
            case 7:
                return false;
            case 11:
                return false;
            case 15:
                return false;
            default:
                return false;
        }
    }

    public static String connectionType(Context context) {
        NetworkInfo info = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (info == null) {
            return null;
        }
        int type = info.getType();
        int subType = info.getSubtype();
        if (type == 1) {
            return "wifi";
        }
        if (type != 0) {
            return null;
        }
        switch (subType) {
            case 1:
                return "gprs";
            case 2:
                return "edge";
            case 3:
                return "umts";
            case 4:
                return "cdma";
            case 5:
            case 6:
                return "evdo";
            case 7:
                return "rtt";
            case 8:
                return "hsdpa";
            case 9:
                return "hsupa";
            case 10:
                return "hspa";
            case 11:
                return "iden";
            case 12:
                return "evdo_b";
            case 13:
                return "lte";
            case 14:
                return "ehrpd";
            case 15:
                return "hspap";
            default:
                return null;
        }
    }

    public static OpenRtbConnectionType openRtbConnectionType(Context context) {
        NetworkInfo info = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (info == null) {
            return null;
        }
        int type = info.getType();
        int subType = info.getSubtype();
        if (type == 1) {
            return OpenRtbConnectionType.WIFI;
        }
        if (type != 0) {
            return OpenRtbConnectionType.CONNECTION_UNKNOWN;
        }
        switch (subType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return OpenRtbConnectionType.CELL_2G;
            case 3:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
                return OpenRtbConnectionType.CELL_3G;
            case 8:
            case 10:
            case 13:
            case 15:
                return OpenRtbConnectionType.CELL_4G;
            default:
                return OpenRtbConnectionType.CELL_UNKNOWN;
        }
    }
}
