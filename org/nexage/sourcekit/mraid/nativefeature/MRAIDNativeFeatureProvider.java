package org.nexage.sourcekit.mraid.nativefeature;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import org.nexage.sourcekit.mraid.internal.MRAIDLog;
import org.nexage.sourcekit.mraid.internal.MRAIDNativeFeatureManager;

public class MRAIDNativeFeatureProvider {
    public static final String ACTION_HANDLE_CUSTOM_EVENT = "android.provider.calendar.action.HANDLE_CUSTOM_EVENT";
    public static final String AUTHORITY = "com.android.calendar";
    public static final String DESCRIPTION = "description";
    public static final String DISPLAY_COLOR = "displayColor";
    public static final String EVENT_COLOR = "eventColor";
    public static final String EVENT_COLOR_KEY = "eventColor_index";
    public static final String EVENT_LOCATION = "eventLocation";
    public static final String EXTRA_CUSTOM_APP_URI = "customAppUri";
    public static final String EXTRA_EVENT_ALL_DAY = "allDay";
    public static final String EXTRA_EVENT_BEGIN_TIME = "beginTime";
    public static final String EXTRA_EVENT_END_TIME = "endTime";
    public static final String STATUS = "eventStatus";
    private static final String TAG = "MRAIDNativeFeatureProvider";
    public static final String TITLE = "title";
    private final Context context;
    private final MRAIDNativeFeatureManager nativeFeatureManager;

    class C19762 implements OnScanCompletedListener {
        C19762() {
        }

        public void onScanCompleted(String path, Uri uri) {
            MRAIDLog.m2729d("File saves successfully to " + path);
        }
    }

    public MRAIDNativeFeatureProvider(Context context, MRAIDNativeFeatureManager nativeFeatureManager) {
        this.context = context;
        this.nativeFeatureManager = nativeFeatureManager;
    }

    public final void callTel(String url) {
        if (this.nativeFeatureManager.isTelSupported()) {
            this.context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(url)));
        }
    }

    public void createCalendarEvent(String eventJSON) {
        if (this.nativeFeatureManager.isCalendarSupported()) {
            try {
                JSONObject jsonObject = new JSONObject(eventJSON.replace("\\", "").replace("\"{", "{").replace("}\"", "}"));
                String description = jsonObject.optString("description", "Untitled");
                String location = jsonObject.optString("location", "unknown");
                String summary = jsonObject.optString("summary");
                String[] patterns = new String[]{"yyyy-MM-dd'T'HH:mmZ", "yyyy-MM-dd'T'HH:mm:ssZ"};
                String[] dateStrings = new String[]{jsonObject.getString("start"), jsonObject.optString("end")};
                long startTime = 0;
                long endTime = 0;
                for (int i = 0; i < dateStrings.length; i++) {
                    if (!TextUtils.isEmpty(dateStrings[i])) {
                        dateStrings[i] = dateStrings[i].replaceAll("([+-]\\d\\d):(\\d\\d)$", "$1$2");
                        int length = patterns.length;
                        int i2 = 0;
                        while (i2 < length) {
                            try {
                                SimpleDateFormat sdf = new SimpleDateFormat(patterns[i2], Locale.US);
                                if (i == 0) {
                                    startTime = sdf.parse(dateStrings[i]).getTime();
                                } else {
                                    endTime = sdf.parse(dateStrings[i]).getTime();
                                }
                            } catch (ParseException e) {
                                i2++;
                            }
                        }
                    }
                }
                Intent intent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
                intent.putExtra("title", description);
                intent.putExtra("description", summary);
                intent.putExtra(EVENT_LOCATION, location);
                if (startTime > 0) {
                    intent.putExtra(EXTRA_EVENT_BEGIN_TIME, startTime);
                }
                if (endTime > 0) {
                    intent.putExtra(EXTRA_EVENT_END_TIME, endTime);
                }
                this.context.startActivity(intent);
            } catch (JSONException e2) {
                MRAIDLog.m2732e(TAG, "Error parsing JSON: " + e2.getLocalizedMessage());
            }
        }
    }

    public void playVideo(String url) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(url), "video/*");
        this.context.startActivity(intent);
    }

    public void openBrowser(String url) {
        if (url.startsWith("market:")) {
            this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        } else if (url.startsWith("http:") || url.startsWith("https:")) {
            this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        }
    }

    public void storePicture(final String url) {
        if (this.nativeFeatureManager.isStorePictureSupported()) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        MRAIDNativeFeatureProvider.this.storePictureInGallery(url);
                    } catch (Exception e) {
                        MRAIDLog.m2732e(MRAIDNativeFeatureProvider.TAG, e.getLocalizedMessage());
                    }
                }
            }).start();
        }
    }

    public void sendSms(String url) {
        if (this.nativeFeatureManager.isSmsSupported()) {
            this.context.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(url)));
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    private void storePictureInGallery(String url) {
        String s = getAlbumDir() + "/img" + new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date()) + ".png";
        MRAIDLog.m2734i(TAG, "Saving image into: " + s);
        try {
            copyStream(new URL(url).openStream(), new FileOutputStream(new File(s)));
            MediaScannerConnection.scanFile(this.context, new String[]{f.getAbsolutePath()}, null, new C19762());
            MRAIDLog.m2734i(TAG, "Saved image successfully");
        } catch (MalformedURLException e) {
            MRAIDLog.m2732e(TAG, "Not able to save image due to invalid URL: " + e.getLocalizedMessage());
        } catch (IOException e2) {
            MRAIDLog.m2732e(TAG, "Unable to save image: " + e2.getLocalizedMessage());
        }
    }

    private void copyStream(InputStream is, OutputStream os) {
        try {
            byte[] bytes = new byte[1024];
            while (true) {
                int count = is.read(bytes, 0, 1024);
                if (count != -1) {
                    os.write(bytes, 0, count);
                } else {
                    return;
                }
            }
        } catch (Exception ex) {
            MRAIDLog.m2734i(TAG, "Error saving picture: " + ex.getLocalizedMessage());
        }
    }

    private File getAlbumDir() {
        File storageDir = null;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Image");
            if (!(storageDir == null || storageDir.mkdirs() || storageDir.exists())) {
                MRAIDLog.m2734i(TAG, "Failed to create camera directory");
                return null;
            }
        }
        MRAIDLog.m2734i(TAG, "External storage is not mounted READ/WRITE.");
        return storageDir;
    }
}
