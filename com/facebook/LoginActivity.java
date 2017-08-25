package com.facebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.android.C0271R;

public class LoginActivity extends Activity {
    private static final String EXTRA_REQUEST = "request";
    private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginActivity with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
    static final String RESULT_KEY = "com.facebook.LoginActivity:Result";
    private static final String SAVED_AUTH_CLIENT = "authorizationClient";
    private static final String SAVED_CALLING_PKG_KEY = "callingPackage";
    private static final String TAG = LoginActivity.class.getName();
    private AuthorizationClient authorizationClient;
    private String callingPackage;
    private AuthorizationRequest request;

    class C02401 implements OnCompletedListener {
        C02401() {
        }

        public void onCompleted(Result outcome) {
            LoginActivity.this.onAuthClientCompleted(outcome);
        }
    }

    class C02412 implements BackgroundProcessingListener {
        C02412() {
        }

        public void onBackgroundProcessingStarted() {
            LoginActivity.this.findViewById(C0271R.id.com_facebook_login_activity_progress_bar).setVisibility(0);
        }

        public void onBackgroundProcessingStopped() {
            LoginActivity.this.findViewById(C0271R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0271R.layout.com_facebook_login_activity_layout);
        if (savedInstanceState != null) {
            this.callingPackage = savedInstanceState.getString(SAVED_CALLING_PKG_KEY);
            this.authorizationClient = (AuthorizationClient) savedInstanceState.getSerializable(SAVED_AUTH_CLIENT);
        } else {
            this.callingPackage = getCallingPackage();
            this.authorizationClient = new AuthorizationClient();
            this.request = (AuthorizationRequest) getIntent().getSerializableExtra(EXTRA_REQUEST);
        }
        this.authorizationClient.setContext((Activity) this);
        this.authorizationClient.setOnCompletedListener(new C02401());
        this.authorizationClient.setBackgroundProcessingListener(new C02412());
    }

    private void onAuthClientCompleted(Result outcome) {
        this.request = null;
        int resultCode = outcome.code == Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putSerializable(RESULT_KEY, outcome);
        Intent resultIntent = new Intent();
        resultIntent.putExtras(bundle);
        setResult(resultCode, resultIntent);
        finish();
    }

    public void onResume() {
        super.onResume();
        if (this.callingPackage == null) {
            Log.e(TAG, NULL_CALLING_PKG_ERROR_MSG);
            finish();
            return;
        }
        this.authorizationClient.startOrContinueAuth(this.request);
    }

    public void onPause() {
        super.onPause();
        this.authorizationClient.cancelCurrentHandler();
        findViewById(C0271R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED_CALLING_PKG_KEY, this.callingPackage);
        outState.putSerializable(SAVED_AUTH_CLIENT, this.authorizationClient);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.authorizationClient.onActivityResult(requestCode, resultCode, data);
    }

    static Bundle populateIntentExtras(AuthorizationRequest request) {
        Bundle extras = new Bundle();
        extras.putSerializable(EXTRA_REQUEST, request);
        return extras;
    }
}
