package com.facebook.widget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.Session;
import com.facebook.Session.Builder;
import com.facebook.Session.OpenRequest;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.SessionTracker;
import java.util.Date;
import java.util.List;

class FacebookFragment extends Fragment {
    private SessionTracker sessionTracker;

    private class DefaultSessionStatusCallback implements StatusCallback {
        private DefaultSessionStatusCallback() {
        }

        public void call(Session session, SessionState state, Exception exception) {
            FacebookFragment.this.onSessionStateChange(state, exception);
        }
    }

    FacebookFragment() {
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.sessionTracker = new SessionTracker(getActivity(), new DefaultSessionStatusCallback());
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.sessionTracker.getSession().onActivityResult(getActivity(), requestCode, resultCode, data);
    }

    public void onDestroy() {
        super.onDestroy();
        this.sessionTracker.stopTracking();
    }

    public void setSession(Session newSession) {
        if (this.sessionTracker != null) {
            this.sessionTracker.setSession(newSession);
        }
    }

    protected void onSessionStateChange(SessionState state, Exception exception) {
    }

    protected final Session getSession() {
        if (this.sessionTracker != null) {
            return this.sessionTracker.getSession();
        }
        return null;
    }

    protected final boolean isSessionOpen() {
        if (this.sessionTracker == null || this.sessionTracker.getOpenSession() == null) {
            return false;
        }
        return true;
    }

    protected final SessionState getSessionState() {
        if (this.sessionTracker == null) {
            return null;
        }
        Session currentSession = this.sessionTracker.getSession();
        if (currentSession != null) {
            return currentSession.getState();
        }
        return null;
    }

    protected final String getAccessToken() {
        if (this.sessionTracker == null) {
            return null;
        }
        Session currentSession = this.sessionTracker.getOpenSession();
        if (currentSession != null) {
            return currentSession.getAccessToken();
        }
        return null;
    }

    protected final Date getExpirationDate() {
        if (this.sessionTracker == null) {
            return null;
        }
        Session currentSession = this.sessionTracker.getOpenSession();
        if (currentSession != null) {
            return currentSession.getExpirationDate();
        }
        return null;
    }

    protected final void closeSession() {
        if (this.sessionTracker != null) {
            Session currentSession = this.sessionTracker.getOpenSession();
            if (currentSession != null) {
                currentSession.close();
            }
        }
    }

    protected final void closeSessionAndClearTokenInformation() {
        if (this.sessionTracker != null) {
            Session currentSession = this.sessionTracker.getOpenSession();
            if (currentSession != null) {
                currentSession.closeAndClearTokenInformation();
            }
        }
    }

    protected final List<String> getSessionPermissions() {
        if (this.sessionTracker == null) {
            return null;
        }
        Session currentSession = this.sessionTracker.getSession();
        if (currentSession != null) {
            return currentSession.getPermissions();
        }
        return null;
    }

    protected final void openSession() {
        openSessionForRead(null, null);
    }

    protected final void openSessionForRead(String applicationId, List<String> permissions) {
        openSessionForRead(applicationId, permissions, SessionLoginBehavior.SSO_WITH_FALLBACK, Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE);
    }

    protected final void openSessionForRead(String applicationId, List<String> permissions, SessionLoginBehavior behavior, int activityCode) {
        openSession(applicationId, permissions, behavior, activityCode, SessionAuthorizationType.READ);
    }

    protected final void openSessionForPublish(String applicationId, List<String> permissions) {
        openSessionForPublish(applicationId, permissions, SessionLoginBehavior.SSO_WITH_FALLBACK, Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE);
    }

    protected final void openSessionForPublish(String applicationId, List<String> permissions, SessionLoginBehavior behavior, int activityCode) {
        openSession(applicationId, permissions, behavior, activityCode, SessionAuthorizationType.PUBLISH);
    }

    private void openSession(String applicationId, List<String> permissions, SessionLoginBehavior behavior, int activityCode, SessionAuthorizationType authType) {
        if (this.sessionTracker != null) {
            Session currentSession = this.sessionTracker.getSession();
            if (currentSession == null || currentSession.getState().isClosed()) {
                Session session = new Builder(getActivity()).setApplicationId(applicationId).build();
                Session.setActiveSession(session);
                currentSession = session;
            }
            if (!currentSession.isOpened()) {
                OpenRequest openRequest = new OpenRequest((Fragment) this).setPermissions((List) permissions).setLoginBehavior(behavior).setRequestCode(activityCode);
                if (SessionAuthorizationType.PUBLISH.equals(authType)) {
                    currentSession.openForPublish(openRequest);
                } else {
                    currentSession.openForRead(openRequest);
                }
            }
        }
    }
}
