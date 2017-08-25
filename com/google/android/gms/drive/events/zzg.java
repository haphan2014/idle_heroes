package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

public class zzg {
    public static boolean zza(int i, DriveId driveId) {
        switch (i) {
            case 1:
                return driveId != null;
            case 4:
                return driveId == null;
            case 5:
            case 6:
                return driveId != null;
            default:
                return false;
        }
    }
}
