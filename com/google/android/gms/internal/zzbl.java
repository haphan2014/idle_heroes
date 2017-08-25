package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class zzbl {
    private static MessageDigest zzrK = null;
    protected Object zzqt = new Object();

    protected MessageDigest zzcu() {
        MessageDigest messageDigest;
        synchronized (this.zzqt) {
            if (zzrK != null) {
                messageDigest = zzrK;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        zzrK = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = zzrK;
            }
        }
        return messageDigest;
    }

    abstract byte[] zzy(String str);
}
