package com.droidhang.pay.util;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.droidhang.ad.C0197R;
import com.droidhang.pay.util.IabHelper.OnConsumeMultiFinishedListener;
import com.droidhang.pay.util.IabHelper.OnIabPurchaseFinishedListener;
import com.droidhang.pay.util.IabHelper.OnIabSetupFinishedListener;
import com.droidhang.pay.util.IabHelper.QueryInventoryFinishedListener;
import java.util.List;
import java.util.Locale;
import org.cocos2dx.lib.Cocos2dxActivity;

public abstract class PurchaseActivity extends Cocos2dxActivity {
    private final String base64EncodedPublicKey;
    private OnConsumeMultiFinishedListener consumeFinishedListener = new C02134();
    private IabHelper iabHelper;
    private OnIabPurchaseFinishedListener purchaseFinishedListener = new C02123();
    private final int purchaseRequestCode;
    private QueryInventoryFinishedListener queryInventoryListener = new C02112();
    private boolean supportPurchase = false;

    class C02101 implements OnIabSetupFinishedListener {
        C02101() {
        }

        public void onIabSetupFinished(IabResult result) {
            if (result.isSuccess()) {
                PurchaseActivity.this.supportPurchase = true;
            }
        }
    }

    class C02112 implements QueryInventoryFinishedListener {
        C02112() {
        }

        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            if (result.isSuccess()) {
                Purchase[] purchases = new Purchase[inventory.getAllPurchases().size()];
                inventory.getAllPurchases().toArray(purchases);
                PaymentUtil.onPull(PaymentUtil.STATUS_OK, purchases);
                return;
            }
            PaymentUtil.onPull("error", null);
        }
    }

    class C02123 implements OnIabPurchaseFinishedListener {
        C02123() {
        }

        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            if (result.isSuccess()) {
                PaymentUtil.onPay(PaymentUtil.STATUS_OK, purchase);
            } else {
                PaymentUtil.onPay("error", null);
            }
        }
    }

    class C02134 implements OnConsumeMultiFinishedListener {
        C02134() {
        }

        public void onConsumeMultiFinished(List<Purchase> list, List<IabResult> list2) {
            PaymentUtil.onConsume();
        }
    }

    protected abstract boolean isValidPurchase(Purchase purchase);

    public PurchaseActivity(String base64EncodeKey, int requestCode) {
        this.base64EncodedPublicKey = base64EncodeKey;
        this.purchaseRequestCode = requestCode;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataProvider.init(this);
        PaymentUtil.init(this, this.mGLSurfaceView);
        initPurchase();
    }

    protected void onDestroy() {
        if (this.iabHelper != null) {
            this.iabHelper.dispose();
            this.iabHelper = null;
        }
        super.onDestroy();
    }

    private void initPurchase() {
        this.iabHelper = new IabHelper(this, this.base64EncodedPublicKey);
        this.iabHelper.startSetup(new C02101());
    }

    public void pull() {
        if (this.supportPurchase) {
            this.iabHelper.queryInventoryAsync(false, null, this.queryInventoryListener);
        } else {
            PaymentUtil.onPull("error", null);
        }
    }

    public void pay(String productId, String developerPayload) {
        if (this.supportPurchase) {
            this.iabHelper.launchPurchaseFlow(this, productId, this.purchaseRequestCode, this.purchaseFinishedListener, developerPayload);
            return;
        }
        PaymentUtil.onPay("error", null);
        alertBillingNotSupport();
    }

    public void consume(List<Purchase> purchases) {
        if (this.supportPurchase) {
            this.iabHelper.consumeAsync((List) purchases, this.consumeFinishedListener);
        }
    }

    private void alertBillingNotSupport() {
        final Uri helpUri = Uri.parse(replaceLanguageAndRegion(getString(C0197R.string.help_url)));
        Builder bld = new Builder(this);
        bld.setTitle(C0197R.string.billing_not_supported_title);
        bld.setMessage(C0197R.string.billing_not_supported_message);
        bld.setCancelable(false);
        bld.setPositiveButton(17039370, null);
        bld.setNegativeButton(C0197R.string.learn_more, new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                PurchaseActivity.this.startActivity(new Intent("android.intent.action.VIEW", helpUri));
            }
        });
        bld.create().show();
    }

    private String replaceLanguageAndRegion(String str) {
        if (!str.contains("%lang%") && !str.contains("%region%")) {
            return str;
        }
        Locale locale = Locale.getDefault();
        return str.replace("%lang%", locale.getLanguage().toLowerCase(locale)).replace("%region%", locale.getCountry().toLowerCase(locale));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!this.iabHelper.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
