package com.droidhang.pay.util;

public abstract class PurchaseOfflineActivity extends PurchaseActivity {
    public PurchaseOfflineActivity(String base64EncodeKey, int purchaseRequestCode) {
        super(base64EncodeKey, purchaseRequestCode);
    }

    protected boolean isValidPurchase(Purchase purchase) {
        return DataProvider.getDP().checkBillID(purchase.getOrderId());
    }
}
