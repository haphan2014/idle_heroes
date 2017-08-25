package com.vungle.publisher;

/* compiled from: vungle */
public final class agi {
    public static int m1227a(int i, int i2, int i3) {
        if (i < 0) {
            throw new IllegalArgumentException("retryCount must not be negative, retryCount = " + i);
        } else if (i == 0) {
            return 0;
        } else {
            double d = (double) (i - 1);
            double d2 = (double) i2;
            double d3 = (double) i3;
            double abs = d3 / Math.abs(d2);
            if (abs <= 0.0d) {
                throw new IllegalArgumentException("base and number must be greater than 0");
            }
            if (d < Math.log(abs) / Math.log(2.0d)) {
                d3 = Math.pow(2.0d, d) * d2;
            }
            return (int) d3;
        }
    }
}
