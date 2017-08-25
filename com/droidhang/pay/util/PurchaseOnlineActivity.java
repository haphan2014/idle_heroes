package com.droidhang.pay.util;

public abstract class PurchaseOnlineActivity extends PurchaseActivity {
    public PurchaseOnlineActivity(String base64EncodeKey, int purchaseRequestCode) {
        super(base64EncodeKey, purchaseRequestCode);
    }

    protected boolean isValidPurchase(Purchase purchase) {
        return true;
    }
}
