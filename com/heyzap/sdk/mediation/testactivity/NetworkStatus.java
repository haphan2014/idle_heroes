package com.heyzap.sdk.mediation.testactivity;

import android.app.Activity;
import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.heyzap.internal.Logger;
import com.heyzap.mediation.FetchRequestStore;
import com.heyzap.mediation.abstr.NetworkAdapter;

public class NetworkStatus {
    public FetchRequestStore fetchRequestStore;
    private int localStatus;
    private String name;
    private NetworkAdapter networkAdapter;
    private int remoteStatus;

    public NetworkStatus(String name) {
        this.name = name;
    }

    public NetworkStatus(String name, NetworkAdapter adapter) {
        this.name = name;
        setNetworkAdapter(adapter);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocalStatus() {
        return this.localStatus;
    }

    public int getRemoteStatus() {
        return this.remoteStatus;
    }

    public void setRemoteStatus(int remoteStatus) {
        this.remoteStatus = remoteStatus;
    }

    public View getLocalTextView(Context c) {
        CheckBox output = new CheckBox(c);
        output.setTextSize(22.0f);
        output.setClickable(false);
        switch (this.localStatus) {
            case 0:
                output.setText("No SDK Detected");
                output.setBackgroundColor(SupportMenu.CATEGORY_MASK);
                break;
            case 1:
                output.setText("SDK Detected");
                output.setChecked(true);
                output.setBackgroundColor(-16711936);
                break;
        }
        return output;
    }

    public View getManifestTextView(Activity c) {
        LinearLayout output = new LinearLayout(c);
        output.setOrientation(1);
        CheckBox permissions = new CheckBox(c);
        permissions.setTextSize(20.0f);
        permissions.setClickable(false);
        CheckBox activities = new CheckBox(c);
        activities.setTextSize(20.0f);
        activities.setClickable(false);
        Logger.log(this.networkAdapter);
        if (this.networkAdapter.checkActivities(c)) {
            activities.setBackgroundColor(-16711936);
            activities.setText("All Activities Found");
            activities.setChecked(true);
        } else {
            activities.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            activities.setText("Manifest Missing Activities");
        }
        if (this.networkAdapter.checkPermissions(c)) {
            permissions.setBackgroundColor(-16711936);
            permissions.setText("All Permissions Found");
            permissions.setChecked(true);
        } else {
            permissions.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            permissions.setText("Missing Permissions");
        }
        output.addView(permissions);
        output.addView(activities);
        return output;
    }

    public View getRemoteTextView(Context c) {
        LinearLayout output = new LinearLayout(c);
        output.setOrientation(1);
        CheckBox credentials = new CheckBox(c);
        credentials.setTextSize(20.0f);
        credentials.setClickable(false);
        CheckBox enabled = new CheckBox(c);
        enabled.setTextSize(20.0f);
        enabled.setClickable(false);
        switch (this.remoteStatus) {
            case 0:
                credentials.setText("No Credentials Found");
                enabled.setText("Network Not Enabled");
                credentials.setBackgroundColor(SupportMenu.CATEGORY_MASK);
                enabled.setBackgroundColor(SupportMenu.CATEGORY_MASK);
                break;
            case 1:
                credentials.setText("Credentials Found");
                credentials.setBackgroundColor(-16711936);
                credentials.setChecked(true);
                enabled.setText("Network Enabled");
                enabled.setBackgroundColor(-16711936);
                enabled.setChecked(true);
                break;
            case 2:
                credentials.setText("Credentials Found");
                credentials.setBackgroundColor(-16711936);
                credentials.setChecked(true);
                enabled.setText("Network Not Enabled");
                enabled.setBackgroundColor(SupportMenu.CATEGORY_MASK);
                break;
            case 3:
                credentials.setText("Network Error");
                credentials.setBackgroundColor(-7829368);
                enabled.setText("Network Error");
                enabled.setBackgroundColor(-7829368);
                break;
        }
        output.addView(credentials);
        output.addView(enabled);
        return output;
    }

    public boolean getNetworkStatus() {
        return this.localStatus == 1 && this.remoteStatus == 1;
    }

    public NetworkAdapter getNetworkAdapter() {
        return this.networkAdapter;
    }

    public void setNetworkAdapter(NetworkAdapter networkAdapter) {
        this.networkAdapter = networkAdapter;
        refreshLocalStatus(networkAdapter);
        this.fetchRequestStore = getNetworkAdapter().getFetchStore();
    }

    public void refreshLocalStatus(NetworkAdapter networkAdapter) {
        int i = 0;
        if (networkAdapter == null) {
            this.localStatus = 0;
            return;
        }
        if (networkAdapter.isOnBoard().booleanValue()) {
            i = 1;
        }
        this.localStatus = i;
    }

    public FetchRequestStore getFetchRequestStore() {
        return this.fetchRequestStore;
    }
}
