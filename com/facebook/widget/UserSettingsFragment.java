package com.facebook.widget;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.Request;
import com.facebook.Request.GraphUserCallback;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.android.C0271R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageRequest.Builder;
import com.facebook.internal.ImageRequest.Callback;
import com.facebook.internal.ImageResponse;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton.OnErrorListener;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class UserSettingsFragment extends FacebookFragment {
    private static final String FIELDS = "fields";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private static final String REQUEST_FIELDS = TextUtils.join(",", new String[]{ID, NAME, PICTURE});
    private TextView connectedStateLabel;
    private LoginButton loginButton;
    private LoginButtonProperties loginButtonProperties = new LoginButtonProperties();
    private StatusCallback sessionStatusCallback;
    private GraphUser user;
    private Session userInfoSession;
    private Drawable userProfilePic;
    private String userProfilePicID;

    class C03422 implements Callback {
        C03422() {
        }

        public void onCompleted(ImageResponse response) {
            UserSettingsFragment.this.processImageResponse(UserSettingsFragment.this.user.getId(), response);
        }
    }

    public /* bridge */ /* synthetic */ void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public /* bridge */ /* synthetic */ void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0271R.layout.com_facebook_usersettingsfragment, container, false);
        this.loginButton = (LoginButton) view.findViewById(C0271R.id.com_facebook_usersettingsfragment_login_button);
        this.loginButton.setProperties(this.loginButtonProperties);
        this.loginButton.setFragment(this);
        this.loginButton.setLoginLogoutEventName(AnalyticsEvents.EVENT_USER_SETTINGS_USAGE);
        Session session = getSession();
        if (!(session == null || session.equals(Session.getActiveSession()))) {
            this.loginButton.setSession(session);
        }
        this.connectedStateLabel = (TextView) view.findViewById(C0271R.id.com_facebook_usersettingsfragment_profile_name);
        if (view.getBackground() == null) {
            view.setBackgroundColor(getResources().getColor(C0271R.color.com_facebook_blue));
        } else {
            view.getBackground().setDither(true);
        }
        return view;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void onResume() {
        super.onResume();
        fetchUserInfo();
        updateUI();
    }

    public void setSession(Session newSession) {
        super.setSession(newSession);
        if (this.loginButton != null) {
            this.loginButton.setSession(newSession);
        }
        fetchUserInfo();
        updateUI();
    }

    public void setDefaultAudience(SessionDefaultAudience defaultAudience) {
        this.loginButtonProperties.setDefaultAudience(defaultAudience);
    }

    public SessionDefaultAudience getDefaultAudience() {
        return this.loginButtonProperties.getDefaultAudience();
    }

    public void setReadPermissions(List<String> permissions) {
        this.loginButtonProperties.setReadPermissions(permissions, getSession());
    }

    public void setReadPermissions(String... permissions) {
        this.loginButtonProperties.setReadPermissions(Arrays.asList(permissions), getSession());
    }

    public void setPublishPermissions(List<String> permissions) {
        this.loginButtonProperties.setPublishPermissions(permissions, getSession());
    }

    public void setPublishPermissions(String... permissions) {
        this.loginButtonProperties.setPublishPermissions(Arrays.asList(permissions), getSession());
    }

    public void clearPermissions() {
        this.loginButtonProperties.clearPermissions();
    }

    public void setLoginBehavior(SessionLoginBehavior loginBehavior) {
        this.loginButtonProperties.setLoginBehavior(loginBehavior);
    }

    public SessionLoginBehavior getLoginBehavior() {
        return this.loginButtonProperties.getLoginBehavior();
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.loginButtonProperties.setOnErrorListener(onErrorListener);
    }

    public OnErrorListener getOnErrorListener() {
        return this.loginButtonProperties.getOnErrorListener();
    }

    public void setSessionStatusCallback(StatusCallback callback) {
        this.sessionStatusCallback = callback;
    }

    public StatusCallback getSessionStatusCallback() {
        return this.sessionStatusCallback;
    }

    protected void onSessionStateChange(SessionState state, Exception exception) {
        fetchUserInfo();
        updateUI();
        if (this.sessionStatusCallback != null) {
            this.sessionStatusCallback.call(getSession(), state, exception);
        }
    }

    List<String> getPermissions() {
        return this.loginButtonProperties.getPermissions();
    }

    private void fetchUserInfo() {
        final Session currentSession = getSession();
        if (currentSession == null || !currentSession.isOpened()) {
            this.user = null;
        } else if (currentSession != this.userInfoSession) {
            Request request = Request.newMeRequest(currentSession, new GraphUserCallback() {
                public void onCompleted(GraphUser me, Response response) {
                    if (currentSession == UserSettingsFragment.this.getSession()) {
                        UserSettingsFragment.this.user = me;
                        UserSettingsFragment.this.updateUI();
                    }
                    if (response.getError() != null) {
                        UserSettingsFragment.this.loginButton.handleError(response.getError().getException());
                    }
                }
            });
            Bundle parameters = new Bundle();
            parameters.putString(FIELDS, REQUEST_FIELDS);
            request.setParameters(parameters);
            Request.executeBatchAsync(request);
            this.userInfoSession = currentSession;
        }
    }

    private void updateUI() {
        if (!isAdded()) {
            return;
        }
        if (isSessionOpen()) {
            this.connectedStateLabel.setTextColor(getResources().getColor(C0271R.color.com_facebook_usersettingsfragment_connected_text_color));
            this.connectedStateLabel.setShadowLayer(TextTrackStyle.DEFAULT_FONT_SCALE, 0.0f, GroundOverlayOptions.NO_DIMENSION, getResources().getColor(C0271R.color.com_facebook_usersettingsfragment_connected_shadow_color));
            if (this.user != null) {
                ImageRequest request = getImageRequest();
                if (request != null) {
                    URI requestUrl = request.getImageUri();
                    if (!requestUrl.equals(this.connectedStateLabel.getTag())) {
                        if (this.user.getId().equals(this.userProfilePicID)) {
                            this.connectedStateLabel.setCompoundDrawables(null, this.userProfilePic, null, null);
                            this.connectedStateLabel.setTag(requestUrl);
                        } else {
                            ImageDownloader.downloadAsync(request);
                        }
                    }
                }
                this.connectedStateLabel.setText(this.user.getName());
                return;
            }
            this.connectedStateLabel.setText(getResources().getString(C0271R.string.com_facebook_usersettingsfragment_logged_in));
            Drawable noProfilePic = getResources().getDrawable(C0271R.drawable.com_facebook_profile_default_icon);
            noProfilePic.setBounds(0, 0, getResources().getDimensionPixelSize(C0271R.dimen.com_facebook_usersettingsfragment_profile_picture_width), getResources().getDimensionPixelSize(C0271R.dimen.com_facebook_usersettingsfragment_profile_picture_height));
            this.connectedStateLabel.setCompoundDrawables(null, noProfilePic, null, null);
            return;
        }
        int textColor = getResources().getColor(C0271R.color.com_facebook_usersettingsfragment_not_connected_text_color);
        this.connectedStateLabel.setTextColor(textColor);
        this.connectedStateLabel.setShadowLayer(0.0f, 0.0f, 0.0f, textColor);
        this.connectedStateLabel.setText(getResources().getString(C0271R.string.com_facebook_usersettingsfragment_not_logged_in));
        this.connectedStateLabel.setCompoundDrawables(null, null, null, null);
        this.connectedStateLabel.setTag(null);
    }

    private ImageRequest getImageRequest() {
        ImageRequest request = null;
        try {
            request = new Builder(getActivity(), ImageRequest.getProfilePictureUrl(this.user.getId(), getResources().getDimensionPixelSize(C0271R.dimen.com_facebook_usersettingsfragment_profile_picture_width), getResources().getDimensionPixelSize(C0271R.dimen.com_facebook_usersettingsfragment_profile_picture_height))).setCallerTag(this).setCallback(new C03422()).build();
        } catch (URISyntaxException e) {
        }
        return request;
    }

    private void processImageResponse(String id, ImageResponse response) {
        if (response != null) {
            Bitmap bitmap = response.getBitmap();
            if (bitmap != null) {
                BitmapDrawable drawable = new BitmapDrawable(getResources(), bitmap);
                drawable.setBounds(0, 0, getResources().getDimensionPixelSize(C0271R.dimen.com_facebook_usersettingsfragment_profile_picture_width), getResources().getDimensionPixelSize(C0271R.dimen.com_facebook_usersettingsfragment_profile_picture_height));
                this.userProfilePic = drawable;
                this.userProfilePicID = id;
                this.connectedStateLabel.setCompoundDrawables(null, drawable, null, null);
                this.connectedStateLabel.setTag(response.getRequest().getImageUri());
            }
        }
    }
}
