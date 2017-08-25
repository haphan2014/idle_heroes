package com.droidhang.pay.util;

import android.opengl.GLSurfaceView;
import java.util.List;

public class PaymentUtil {
    public static final String STATUS_ERROR = "error";
    public static final String STATUS_OK = "ok";
    private static GLSurfaceView glSurfaceView = null;
    private static PurchaseActivity purchaseActivity = null;

    static class C02041 implements Runnable {
        C02041() {
        }

        public void run() {
            PaymentUtil.purchaseActivity.pull();
        }
    }

    static class C02096 implements Runnable {
        C02096() {
        }

        public void run() {
            PaymentUtil.nativeOnConsume();
        }
    }

    private static native void nativeOnConsume();

    private static native void nativeOnPay(String str, Purchase purchase);

    private static native void nativeOnPull(String str, Purchase[] purchaseArr);

    public static void init(PurchaseActivity purchaseActivity, GLSurfaceView glSurfaceView) {
        purchaseActivity = purchaseActivity;
        glSurfaceView = glSurfaceView;
    }

    public static void pull() {
        purchaseActivity.runOnUiThread(new C02041());
    }

    public static void onPull(final String status, final Purchase[] purchases) {
        glSurfaceView.queueEvent(new Runnable() {
            public void run() {
                PaymentUtil.nativeOnPull(status, purchases);
            }
        });
    }

    public static void pay(final String productId) {
        purchaseActivity.runOnUiThread(new Runnable() {
            public void run() {
                PaymentUtil.purchaseActivity.pay(productId, "");
            }
        });
    }

    public static void onPay(final String status, final Purchase purchase) {
        glSurfaceView.queueEvent(new Runnable() {
            public void run() {
                PaymentUtil.nativeOnPay(status, purchase);
            }
        });
    }

    public static void consume(final List<Purchase> purchases) {
        purchaseActivity.runOnUiThread(new Runnable() {
            public void run() {
                PaymentUtil.purchaseActivity.consume(purchases);
            }
        });
    }

    public static void onConsume() {
        glSurfaceView.queueEvent(new C02096());
    }
}
