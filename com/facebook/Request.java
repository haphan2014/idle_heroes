package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.location.Location;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.facebook.model.GraphPlace;
import com.facebook.model.GraphUser;
import com.facebook.model.OpenGraphAction;
import com.facebook.model.OpenGraphObject;
import com.facebook.model.OpenGraphObject.Factory;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.games.request.Requests;
import com.heyzap.http.AsyncHttpClient;
import com.heyzap.http.AsyncHttpResponseHandler;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Request {
    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    private static final String ACCESS_TOKEN_PARAM = "access_token";
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    private static final String BATCH_BODY_PARAM = "body";
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    private static final String BATCH_METHOD_PARAM = "method";
    private static final String BATCH_PARAM = "batch";
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String FORMAT_JSON = "json";
    private static final String FORMAT_PARAM = "format";
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    private static final String ME = "me";
    private static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
    private static final String MY_ACTION_FORMAT = "me/%s";
    private static final String MY_FEED = "me/feed";
    private static final String MY_FRIENDS = "me/friends";
    private static final String MY_OBJECTS_FORMAT = "me/objects/%s";
    private static final String MY_PHOTOS = "me/photos";
    private static final String MY_STAGING_RESOURCES = "me/staging_resources";
    private static final String MY_VIDEOS = "me/videos";
    private static final String OBJECT_PARAM = "object";
    private static final String PICTURE_PARAM = "picture";
    private static final String SDK_ANDROID = "android";
    private static final String SDK_PARAM = "sdk";
    private static final String SEARCH = "search";
    private static final String STAGING_PARAM = "file";
    public static final String TAG = Request.class.getSimpleName();
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static final String VIDEOS_SUFFIX = "/videos";
    private static String defaultBatchApplicationId;
    private static volatile String userAgent;
    private static Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    private Callback callback;
    private GraphObject graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private Session session;
    private boolean skipClientToken;
    private Object tag;
    private String version;

    public interface Callback {
        void onCompleted(Response response);
    }

    private interface KeyValueSerializer {
        void writeString(String str, String str2) throws IOException;
    }

    private static class Attachment {
        private final Request request;
        private final Object value;

        public Attachment(Request request, Object value) {
            this.request = request;
            this.value = value;
        }

        public Request getRequest() {
            return this.request;
        }

        public Object getValue() {
            return this.value;
        }
    }

    public interface GraphPlaceListCallback {
        void onCompleted(List<GraphPlace> list, Response response);
    }

    public interface GraphUserCallback {
        void onCompleted(GraphUser graphUser, Response response);
    }

    public interface GraphUserListCallback {
        void onCompleted(List<GraphUser> list, Response response);
    }

    public interface OnProgressCallback extends Callback {
        void onProgress(long j, long j2);
    }

    private static class ParcelFileDescriptorWithMimeType implements Parcelable {
        public static final Creator<ParcelFileDescriptorWithMimeType> CREATOR = new C02501();
        private final ParcelFileDescriptor fileDescriptor;
        private final String mimeType;

        static class C02501 implements Creator<ParcelFileDescriptorWithMimeType> {
            C02501() {
            }

            public ParcelFileDescriptorWithMimeType createFromParcel(Parcel in) {
                return new ParcelFileDescriptorWithMimeType(in);
            }

            public ParcelFileDescriptorWithMimeType[] newArray(int size) {
                return new ParcelFileDescriptorWithMimeType[size];
            }
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public ParcelFileDescriptor getFileDescriptor() {
            return this.fileDescriptor;
        }

        public int describeContents() {
            return 1;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeString(this.mimeType);
            out.writeFileDescriptor(this.fileDescriptor.getFileDescriptor());
        }

        public ParcelFileDescriptorWithMimeType(ParcelFileDescriptor fileDescriptor, String mimeType) {
            this.mimeType = mimeType;
            this.fileDescriptor = fileDescriptor;
        }

        private ParcelFileDescriptorWithMimeType(Parcel in) {
            this.mimeType = in.readString();
            this.fileDescriptor = in.readFileDescriptor();
        }
    }

    private static class Serializer implements KeyValueSerializer {
        private boolean firstWrite = true;
        private final Logger logger;
        private final OutputStream outputStream;
        private boolean useUrlEncode = false;

        public Serializer(OutputStream outputStream, Logger logger, boolean useUrlEncode) {
            this.outputStream = outputStream;
            this.logger = logger;
            this.useUrlEncode = useUrlEncode;
        }

        public void writeObject(String key, Object value, Request request) throws IOException {
            if (this.outputStream instanceof RequestOutputStream) {
                ((RequestOutputStream) this.outputStream).setCurrentRequest(request);
            }
            if (Request.isSupportedParameterType(value)) {
                writeString(key, Request.parameterToString(value));
            } else if (value instanceof Bitmap) {
                writeBitmap(key, (Bitmap) value);
            } else if (value instanceof byte[]) {
                writeBytes(key, (byte[]) value);
            } else if (value instanceof ParcelFileDescriptor) {
                writeFile(key, (ParcelFileDescriptor) value, null);
            } else if (value instanceof ParcelFileDescriptorWithMimeType) {
                writeFile(key, (ParcelFileDescriptorWithMimeType) value);
            } else {
                throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
            }
        }

        public void writeRequestsAsJson(String key, JSONArray requestJsonArray, Collection<Request> requests) throws IOException, JSONException {
            if (this.outputStream instanceof RequestOutputStream) {
                RequestOutputStream requestOutputStream = this.outputStream;
                writeContentDisposition(key, null, null);
                write("[", new Object[0]);
                int i = 0;
                for (Request request : requests) {
                    JSONObject requestJson = requestJsonArray.getJSONObject(i);
                    requestOutputStream.setCurrentRequest(request);
                    if (i > 0) {
                        write(",%s", requestJson.toString());
                    } else {
                        write("%s", requestJson.toString());
                    }
                    i++;
                }
                write("]", new Object[0]);
                if (this.logger != null) {
                    this.logger.appendKeyValue("    " + key, requestJsonArray.toString());
                    return;
                }
                return;
            }
            writeString(key, requestJsonArray.toString());
        }

        public void writeString(String key, String value) throws IOException {
            writeContentDisposition(key, null, null);
            writeLine("%s", value);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + key, value);
            }
        }

        public void writeBitmap(String key, Bitmap bitmap) throws IOException {
            writeContentDisposition(key, key, "image/png");
            bitmap.compress(CompressFormat.PNG, 100, this.outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + key, "<Image>");
            }
        }

        public void writeBytes(String key, byte[] bytes) throws IOException {
            writeContentDisposition(key, key, "content/unknown");
            this.outputStream.write(bytes);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + key, String.format("<Data: %d>", new Object[]{Integer.valueOf(bytes.length)}));
            }
        }

        public void writeFile(String key, ParcelFileDescriptorWithMimeType descriptorWithMimeType) throws IOException {
            writeFile(key, descriptorWithMimeType.getFileDescriptor(), descriptorWithMimeType.getMimeType());
        }

        public void writeFile(String key, ParcelFileDescriptor descriptor, String mimeType) throws IOException {
            BufferedInputStream bufferedInputStream;
            Throwable th;
            if (mimeType == null) {
                mimeType = "content/unknown";
            }
            writeContentDisposition(key, key, mimeType);
            int totalBytes = 0;
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.outputStream).addProgress(descriptor.getStatSize());
            } else {
                AutoCloseInputStream inputStream = null;
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    AutoCloseInputStream inputStream2 = new AutoCloseInputStream(descriptor);
                    try {
                        bufferedInputStream = new BufferedInputStream(inputStream2);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                    try {
                        byte[] buffer = new byte[8192];
                        while (true) {
                            int bytesRead = bufferedInputStream.read(buffer);
                            if (bytesRead == -1) {
                                break;
                            }
                            this.outputStream.write(buffer, 0, bytesRead);
                            totalBytes += bytesRead;
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream2 = bufferedInputStream;
                        inputStream = inputStream2;
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    " + key, String.format("<Data: %d>", new Object[]{Integer.valueOf(totalBytes)}));
            }
        }

        public void writeRecordBoundary() throws IOException {
            if (this.useUrlEncode) {
                this.outputStream.write("&".getBytes());
                return;
            }
            writeLine("--%s", Request.MIME_BOUNDARY);
        }

        public void writeContentDisposition(String name, String filename, String contentType) throws IOException {
            if (this.useUrlEncode) {
                this.outputStream.write(String.format("%s=", new Object[]{name}).getBytes());
                return;
            }
            write("Content-Disposition: form-data; name=\"%s\"", name);
            if (filename != null) {
                write("; filename=\"%s\"", filename);
            }
            writeLine("", new Object[0]);
            if (contentType != null) {
                writeLine("%s: %s", Request.CONTENT_TYPE_HEADER, contentType);
            }
            writeLine("", new Object[0]);
        }

        public void write(String format, Object... args) throws IOException {
            if (this.useUrlEncode) {
                this.outputStream.write(URLEncoder.encode(String.format(format, args), AsyncHttpResponseHandler.DEFAULT_CHARSET).getBytes());
                return;
            }
            if (this.firstWrite) {
                this.outputStream.write("--".getBytes());
                this.outputStream.write(Request.MIME_BOUNDARY.getBytes());
                this.outputStream.write("\r\n".getBytes());
                this.firstWrite = false;
            }
            this.outputStream.write(String.format(format, args).getBytes());
        }

        public void writeLine(String format, Object... args) throws IOException {
            write(format, args);
            if (!this.useUrlEncode) {
                write("\r\n", new Object[0]);
            }
        }
    }

    public Request() {
        this(null, null, null, null, null);
    }

    public Request(Session session, String graphPath) {
        this(session, graphPath, null, null, null);
    }

    public Request(Session session, String graphPath, Bundle parameters, HttpMethod httpMethod) {
        this(session, graphPath, parameters, httpMethod, null);
    }

    public Request(Session session, String graphPath, Bundle parameters, HttpMethod httpMethod, Callback callback) {
        this(session, graphPath, parameters, httpMethod, callback, null);
    }

    public Request(Session session, String graphPath, Bundle parameters, HttpMethod httpMethod, Callback callback, String version) {
        this.batchEntryOmitResultOnSuccess = true;
        this.skipClientToken = false;
        this.session = session;
        this.graphPath = graphPath;
        this.callback = callback;
        this.version = version;
        setHttpMethod(httpMethod);
        if (parameters != null) {
            this.parameters = new Bundle(parameters);
        } else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            this.version = ServerProtocol.getAPIVersion();
        }
    }

    Request(Session session, URL overriddenURL) {
        this.batchEntryOmitResultOnSuccess = true;
        this.skipClientToken = false;
        this.session = session;
        this.overriddenURL = overriddenURL.toString();
        setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
    }

    public static Request newPostRequest(Session session, String graphPath, GraphObject graphObject, Callback callback) {
        Request request = new Request(session, graphPath, null, HttpMethod.POST, callback);
        request.setGraphObject(graphObject);
        return request;
    }

    public static Request newMeRequest(Session session, final GraphUserCallback callback) {
        return new Request(session, ME, null, null, new Callback() {
            public void onCompleted(Response response) {
                if (callback != null) {
                    callback.onCompleted((GraphUser) response.getGraphObjectAs(GraphUser.class), response);
                }
            }
        });
    }

    public static Request newMyFriendsRequest(Session session, final GraphUserListCallback callback) {
        return new Request(session, MY_FRIENDS, null, null, new Callback() {
            public void onCompleted(Response response) {
                if (callback != null) {
                    callback.onCompleted(Request.typedListFromResponse(response, GraphUser.class), response);
                }
            }
        });
    }

    public static Request newUploadPhotoRequest(Session session, Bitmap image, Callback callback) {
        Bundle parameters = new Bundle(1);
        parameters.putParcelable(PICTURE_PARAM, image);
        return new Request(session, MY_PHOTOS, parameters, HttpMethod.POST, callback);
    }

    public static Request newUploadPhotoRequest(Session session, File file, Callback callback) throws FileNotFoundException {
        ParcelFileDescriptor descriptor = ParcelFileDescriptor.open(file, DriveFile.MODE_READ_ONLY);
        Bundle parameters = new Bundle(1);
        parameters.putParcelable(PICTURE_PARAM, descriptor);
        return new Request(session, MY_PHOTOS, parameters, HttpMethod.POST, callback);
    }

    public static Request newUploadVideoRequest(Session session, File file, Callback callback) throws FileNotFoundException {
        ParcelFileDescriptor descriptor = ParcelFileDescriptor.open(file, DriveFile.MODE_READ_ONLY);
        Bundle parameters = new Bundle(1);
        parameters.putParcelable(file.getName(), descriptor);
        return new Request(session, MY_VIDEOS, parameters, HttpMethod.POST, callback);
    }

    public static Request newGraphPathRequest(Session session, String graphPath, Callback callback) {
        return new Request(session, graphPath, null, null, callback);
    }

    public static Request newPlacesSearchRequest(Session session, Location location, int radiusInMeters, int resultsLimit, String searchText, final GraphPlaceListCallback callback) {
        if (location == null && Utility.isNullOrEmpty(searchText)) {
            throw new FacebookException("Either location or searchText must be specified.");
        }
        Bundle parameters = new Bundle(5);
        parameters.putString("type", "place");
        parameters.putInt("limit", resultsLimit);
        if (location != null) {
            parameters.putString("center", String.format(Locale.US, "%f,%f", new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())}));
            parameters.putInt("distance", radiusInMeters);
        }
        if (!Utility.isNullOrEmpty(searchText)) {
            parameters.putString("q", searchText);
        }
        return new Request(session, "search", parameters, HttpMethod.GET, new Callback() {
            public void onCompleted(Response response) {
                if (callback != null) {
                    callback.onCompleted(Request.typedListFromResponse(response, GraphPlace.class), response);
                }
            }
        });
    }

    public static Request newStatusUpdateRequest(Session session, String message, Callback callback) {
        return newStatusUpdateRequest(session, message, (String) null, null, callback);
    }

    private static Request newStatusUpdateRequest(Session session, String message, String placeId, List<String> tagIds, Callback callback) {
        Bundle parameters = new Bundle();
        parameters.putString("message", message);
        if (placeId != null) {
            parameters.putString("place", placeId);
        }
        if (tagIds != null && tagIds.size() > 0) {
            parameters.putString("tags", TextUtils.join(",", tagIds));
        }
        return new Request(session, MY_FEED, parameters, HttpMethod.POST, callback);
    }

    public static Request newStatusUpdateRequest(Session session, String message, GraphPlace place, List<GraphUser> tags, Callback callback) {
        List tagIds = null;
        if (tags != null) {
            tagIds = new ArrayList(tags.size());
            for (GraphUser tag : tags) {
                tagIds.add(tag.getId());
            }
        }
        return newStatusUpdateRequest(session, message, place == null ? null : place.getId(), tagIds, callback);
    }

    public static Request newCustomAudienceThirdPartyIdRequest(Session session, Context context, Callback callback) {
        return newCustomAudienceThirdPartyIdRequest(session, context, null, callback);
    }

    public static Request newCustomAudienceThirdPartyIdRequest(Session session, Context context, String applicationId, Callback callback) {
        if (session == null) {
            session = Session.getActiveSession();
        }
        if (!(session == null || session.isOpened())) {
            session = null;
        }
        if (applicationId == null) {
            if (session != null) {
                applicationId = session.getApplicationId();
            } else {
                applicationId = Utility.getMetadataApplicationId(context);
            }
        }
        if (applicationId == null) {
            throw new FacebookException("Facebook App ID cannot be determined");
        }
        String endpoint = applicationId + "/custom_audience_third_party_id";
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        Bundle parameters = new Bundle();
        if (session == null) {
            String udid;
            if (attributionIdentifiers.getAttributionId() != null) {
                udid = attributionIdentifiers.getAttributionId();
            } else {
                udid = attributionIdentifiers.getAndroidAdvertiserId();
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                parameters.putString("udid", udid);
            }
        }
        if (Settings.getLimitEventAndDataUsage(context) || attributionIdentifiers.isTrackingLimited()) {
            parameters.putString("limit_event_usage", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        return new Request(session, endpoint, parameters, HttpMethod.GET, callback);
    }

    public static Request newUploadStagingResourceWithImageRequest(Session session, Bitmap image, Callback callback) {
        Bundle parameters = new Bundle(1);
        parameters.putParcelable("file", image);
        return new Request(session, MY_STAGING_RESOURCES, parameters, HttpMethod.POST, callback);
    }

    public static Request newUploadStagingResourceWithImageRequest(Session session, File file, Callback callback) throws FileNotFoundException {
        ParcelFileDescriptorWithMimeType descriptorWithMimeType = new ParcelFileDescriptorWithMimeType(ParcelFileDescriptor.open(file, DriveFile.MODE_READ_ONLY), "image/png");
        Bundle parameters = new Bundle(1);
        parameters.putParcelable("file", descriptorWithMimeType);
        return new Request(session, MY_STAGING_RESOURCES, parameters, HttpMethod.POST, callback);
    }

    public static Request newPostOpenGraphObjectRequest(Session session, OpenGraphObject openGraphObject, Callback callback) {
        if (openGraphObject == null) {
            throw new FacebookException("openGraphObject cannot be null");
        } else if (Utility.isNullOrEmpty(openGraphObject.getType())) {
            throw new FacebookException("openGraphObject must have non-null 'type' property");
        } else if (Utility.isNullOrEmpty(openGraphObject.getTitle())) {
            throw new FacebookException("openGraphObject must have non-null 'title' property");
        } else {
            String path = String.format(MY_OBJECTS_FORMAT, new Object[]{openGraphObject.getType()});
            Bundle bundle = new Bundle();
            bundle.putString(OBJECT_PARAM, openGraphObject.getInnerJSONObject().toString());
            return new Request(session, path, bundle, HttpMethod.POST, callback);
        }
    }

    public static Request newPostOpenGraphObjectRequest(Session session, String type, String title, String imageUrl, String url, String description, GraphObject objectProperties, Callback callback) {
        OpenGraphObject openGraphObject = Factory.createForPost(OpenGraphObject.class, type, title, imageUrl, url, description);
        if (objectProperties != null) {
            openGraphObject.setData(objectProperties);
        }
        return newPostOpenGraphObjectRequest(session, openGraphObject, callback);
    }

    public static Request newPostOpenGraphActionRequest(Session session, OpenGraphAction openGraphAction, Callback callback) {
        if (openGraphAction == null) {
            throw new FacebookException("openGraphAction cannot be null");
        } else if (Utility.isNullOrEmpty(openGraphAction.getType())) {
            throw new FacebookException("openGraphAction must have non-null 'type' property");
        } else {
            return newPostRequest(session, String.format(MY_ACTION_FORMAT, new Object[]{openGraphAction.getType()}), openGraphAction, callback);
        }
    }

    public static Request newDeleteObjectRequest(Session session, String id, Callback callback) {
        return new Request(session, id, null, HttpMethod.DELETE, callback);
    }

    public static Request newUpdateOpenGraphObjectRequest(Session session, OpenGraphObject openGraphObject, Callback callback) {
        if (openGraphObject == null) {
            throw new FacebookException("openGraphObject cannot be null");
        }
        String path = openGraphObject.getId();
        if (path == null) {
            throw new FacebookException("openGraphObject must have an id");
        }
        Bundle bundle = new Bundle();
        bundle.putString(OBJECT_PARAM, openGraphObject.getInnerJSONObject().toString());
        return new Request(session, path, bundle, HttpMethod.POST, callback);
    }

    public static Request newUpdateOpenGraphObjectRequest(Session session, String id, String title, String imageUrl, String url, String description, GraphObject objectProperties, Callback callback) {
        OpenGraphObject openGraphObject = Factory.createForPost(OpenGraphObject.class, null, title, imageUrl, url, description);
        openGraphObject.setId(id);
        openGraphObject.setData(objectProperties);
        return newUpdateOpenGraphObjectRequest(session, openGraphObject, callback);
    }

    public final GraphObject getGraphObject() {
        return this.graphObject;
    }

    public final void setGraphObject(GraphObject graphObject) {
        this.graphObject = graphObject;
    }

    public final String getGraphPath() {
        return this.graphPath;
    }

    public final void setGraphPath(String graphPath) {
        this.graphPath = graphPath;
    }

    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public final void setHttpMethod(HttpMethod httpMethod) {
        if (this.overriddenURL == null || httpMethod == HttpMethod.GET) {
            if (httpMethod == null) {
                httpMethod = HttpMethod.GET;
            }
            this.httpMethod = httpMethod;
            return;
        }
        throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String version) {
        this.version = version;
    }

    public final void setSkipClientToken(boolean skipClientToken) {
        this.skipClientToken = skipClientToken;
    }

    public final Bundle getParameters() {
        return this.parameters;
    }

    public final void setParameters(Bundle parameters) {
        this.parameters = parameters;
    }

    public final Session getSession() {
        return this.session;
    }

    public final void setSession(Session session) {
        this.session = session;
    }

    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final void setBatchEntryName(String batchEntryName) {
        this.batchEntryName = batchEntryName;
    }

    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    public final void setBatchEntryDependsOn(String batchEntryDependsOn) {
        this.batchEntryDependsOn = batchEntryDependsOn;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean batchEntryOmitResultOnSuccess) {
        this.batchEntryOmitResultOnSuccess = batchEntryOmitResultOnSuccess;
    }

    public static final String getDefaultBatchApplicationId() {
        return defaultBatchApplicationId;
    }

    public static final void setDefaultBatchApplicationId(String applicationId) {
        defaultBatchApplicationId = applicationId;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback) {
        this.callback = callback;
    }

    public final void setTag(Object tag) {
        this.tag = tag;
    }

    public final Object getTag() {
        return this.tag;
    }

    @Deprecated
    public static RequestAsyncTask executePostRequestAsync(Session session, String graphPath, GraphObject graphObject, Callback callback) {
        return newPostRequest(session, graphPath, graphObject, callback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executeMeRequestAsync(Session session, GraphUserCallback callback) {
        return newMeRequest(session, callback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executeMyFriendsRequestAsync(Session session, GraphUserListCallback callback) {
        return newMyFriendsRequest(session, callback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executeUploadPhotoRequestAsync(Session session, Bitmap image, Callback callback) {
        return newUploadPhotoRequest(session, image, callback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executeUploadPhotoRequestAsync(Session session, File file, Callback callback) throws FileNotFoundException {
        return newUploadPhotoRequest(session, file, callback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executeGraphPathRequestAsync(Session session, String graphPath, Callback callback) {
        return newGraphPathRequest(session, graphPath, callback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executePlacesSearchRequestAsync(Session session, Location location, int radiusInMeters, int resultsLimit, String searchText, GraphPlaceListCallback callback) {
        return newPlacesSearchRequest(session, location, radiusInMeters, resultsLimit, searchText, callback).executeAsync();
    }

    @Deprecated
    public static RequestAsyncTask executeStatusUpdateRequestAsync(Session session, String message, Callback callback) {
        return newStatusUpdateRequest(session, message, callback).executeAsync();
    }

    public final Response executeAndWait() {
        return executeAndWait(this);
    }

    public final RequestAsyncTask executeAsync() {
        return executeBatchAsync(this);
    }

    public static HttpURLConnection toHttpConnection(Request... requests) {
        return toHttpConnection(Arrays.asList(requests));
    }

    public static HttpURLConnection toHttpConnection(Collection<Request> requests) {
        Validate.notEmptyAndContainsNoNulls(requests, Requests.EXTRA_REQUESTS);
        return toHttpConnection(new RequestBatch((Collection) requests));
    }

    public static HttpURLConnection toHttpConnection(RequestBatch requests) {
        try {
            URL url;
            if (requests.size() == 1) {
                url = new URL(requests.get(0).getUrlForSingleRequest());
            } else {
                url = new URL(ServerProtocol.getGraphUrlBase());
            }
            try {
                HttpURLConnection connection = createConnection(url);
                serializeToUrlConnection(requests, connection);
                return connection;
            } catch (IOException e) {
                throw new FacebookException("could not construct request body", e);
            } catch (JSONException e2) {
                throw new FacebookException("could not construct request body", e2);
            }
        } catch (MalformedURLException e3) {
            throw new FacebookException("could not construct URL for request", e3);
        }
    }

    public static Response executeAndWait(Request request) {
        List<Response> responses = executeBatchAndWait(request);
        if (responses != null && responses.size() == 1) {
            return (Response) responses.get(0);
        }
        throw new FacebookException("invalid state: expected a single response");
    }

    public static List<Response> executeBatchAndWait(Request... requests) {
        Validate.notNull(requests, Requests.EXTRA_REQUESTS);
        return executeBatchAndWait(Arrays.asList(requests));
    }

    public static List<Response> executeBatchAndWait(Collection<Request> requests) {
        return executeBatchAndWait(new RequestBatch((Collection) requests));
    }

    public static List<Response> executeBatchAndWait(RequestBatch requests) {
        Validate.notEmptyAndContainsNoNulls(requests, Requests.EXTRA_REQUESTS);
        try {
            return executeConnectionAndWait(toHttpConnection(requests), requests);
        } catch (Throwable ex) {
            List<Response> responses = Response.constructErrorResponses(requests.getRequests(), null, new FacebookException(ex));
            runCallbacks(requests, responses);
            return responses;
        }
    }

    public static RequestAsyncTask executeBatchAsync(Request... requests) {
        Validate.notNull(requests, Requests.EXTRA_REQUESTS);
        return executeBatchAsync(Arrays.asList(requests));
    }

    public static RequestAsyncTask executeBatchAsync(Collection<Request> requests) {
        return executeBatchAsync(new RequestBatch((Collection) requests));
    }

    public static RequestAsyncTask executeBatchAsync(RequestBatch requests) {
        Validate.notEmptyAndContainsNoNulls(requests, Requests.EXTRA_REQUESTS);
        RequestAsyncTask asyncTask = new RequestAsyncTask(requests);
        asyncTask.executeOnSettingsExecutor();
        return asyncTask;
    }

    public static List<Response> executeConnectionAndWait(HttpURLConnection connection, Collection<Request> requests) {
        return executeConnectionAndWait(connection, new RequestBatch((Collection) requests));
    }

    public static List<Response> executeConnectionAndWait(HttpURLConnection connection, RequestBatch requests) {
        List<Response> responses = Response.fromHttpConnection(connection, requests);
        Utility.disconnectQuietly(connection);
        if (requests.size() != responses.size()) {
            throw new FacebookException(String.format("Received %d responses while expecting %d", new Object[]{Integer.valueOf(responses.size()), Integer.valueOf(requests.size())}));
        }
        runCallbacks(requests, responses);
        HashSet<Session> sessions = new HashSet();
        Iterator it = requests.iterator();
        while (it.hasNext()) {
            Request request = (Request) it.next();
            if (request.session != null) {
                sessions.add(request.session);
            }
        }
        it = sessions.iterator();
        while (it.hasNext()) {
            ((Session) it.next()).extendAccessTokenIfNeeded();
        }
        return responses;
    }

    public static RequestAsyncTask executeConnectionAsync(HttpURLConnection connection, RequestBatch requests) {
        return executeConnectionAsync(null, connection, requests);
    }

    public static RequestAsyncTask executeConnectionAsync(Handler callbackHandler, HttpURLConnection connection, RequestBatch requests) {
        Validate.notNull(connection, "connection");
        RequestAsyncTask asyncTask = new RequestAsyncTask(connection, requests);
        requests.setCallbackHandler(callbackHandler);
        asyncTask.executeOnSettingsExecutor();
        return asyncTask;
    }

    public String toString() {
        return "{Request: " + " session: " + this.session + ", graphPath: " + this.graphPath + ", graphObject: " + this.graphObject + ", httpMethod: " + this.httpMethod + ", parameters: " + this.parameters + "}";
    }

    static void runCallbacks(final RequestBatch requests, List<Response> responses) {
        int numRequests = requests.size();
        final ArrayList<Pair<Callback, Response>> callbacks = new ArrayList();
        for (int i = 0; i < numRequests; i++) {
            Request request = requests.get(i);
            if (request.callback != null) {
                callbacks.add(new Pair(request.callback, responses.get(i)));
            }
        }
        if (callbacks.size() > 0) {
            Runnable runnable = new Runnable() {
                public void run() {
                    Iterator it = callbacks.iterator();
                    while (it.hasNext()) {
                        Pair<Callback, Response> pair = (Pair) it.next();
                        ((Callback) pair.first).onCompleted((Response) pair.second);
                    }
                    for (com.facebook.RequestBatch.Callback batchCallback : requests.getCallbacks()) {
                        batchCallback.onBatchCompleted(requests);
                    }
                }
            };
            Handler callbackHandler = requests.getCallbackHandler();
            if (callbackHandler == null) {
                runnable.run();
            } else {
                callbackHandler.post(runnable);
            }
        }
    }

    private static HttpURLConnection createConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty(USER_AGENT_HEADER, getUserAgent());
        connection.setRequestProperty(ACCEPT_LANGUAGE_HEADER, Locale.getDefault().toString());
        connection.setChunkedStreamingMode(0);
        return connection;
    }

    private void addCommonParameters() {
        if (this.session != null) {
            if (!this.session.isOpened()) {
                throw new FacebookException("Session provided to a Request in un-opened state.");
            } else if (!this.parameters.containsKey("access_token")) {
                String accessToken = this.session.getAccessToken();
                Logger.registerAccessToken(accessToken);
                this.parameters.putString("access_token", accessToken);
            }
        } else if (!(this.skipClientToken || this.parameters.containsKey("access_token"))) {
            String appID = Settings.getApplicationId();
            String clientToken = Settings.getClientToken();
            if (Utility.isNullOrEmpty(appID) || Utility.isNullOrEmpty(clientToken)) {
                Log.d(TAG, "Warning: Sessionless Request needs token but missing either application ID or client token.");
            } else {
                this.parameters.putString("access_token", appID + "|" + clientToken);
            }
        }
        this.parameters.putString(SDK_PARAM, SDK_ANDROID);
        this.parameters.putString(FORMAT_PARAM, FORMAT_JSON);
    }

    private String appendParametersToBaseUrl(String baseUrl) {
        Builder uriBuilder = new Builder().encodedPath(baseUrl);
        for (String key : this.parameters.keySet()) {
            Object value = this.parameters.get(key);
            if (value == null) {
                value = "";
            }
            if (isSupportedParameterType(value)) {
                uriBuilder.appendQueryParameter(key, parameterToString(value).toString());
            } else if (this.httpMethod == HttpMethod.GET) {
                throw new IllegalArgumentException(String.format("Unsupported parameter type for GET request: %s", new Object[]{value.getClass().getSimpleName()}));
            }
        }
        return uriBuilder.toString();
    }

    final String getUrlForBatchedRequest() {
        if (this.overriddenURL != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String baseUrl = getGraphPathWithVersion();
        addCommonParameters();
        return appendParametersToBaseUrl(baseUrl);
    }

    final String getUrlForSingleRequest() {
        if (this.overriddenURL != null) {
            return this.overriddenURL.toString();
        }
        String graphBaseUrlBase;
        if (getHttpMethod() == HttpMethod.POST && this.graphPath != null && this.graphPath.endsWith(VIDEOS_SUFFIX)) {
            graphBaseUrlBase = ServerProtocol.getGraphVideoUrlBase();
        } else {
            graphBaseUrlBase = ServerProtocol.getGraphUrlBase();
        }
        String baseUrl = String.format("%s/%s", new Object[]{graphBaseUrlBase, getGraphPathWithVersion()});
        addCommonParameters();
        return appendParametersToBaseUrl(baseUrl);
    }

    private String getGraphPathWithVersion() {
        if (versionPattern.matcher(this.graphPath).matches()) {
            return this.graphPath;
        }
        return String.format("%s/%s", new Object[]{this.version, this.graphPath});
    }

    private void serializeToBatch(JSONArray batch, Map<String, Attachment> attachments) throws JSONException, IOException {
        JSONObject batchEntry = new JSONObject();
        if (this.batchEntryName != null) {
            batchEntry.put(BATCH_ENTRY_NAME_PARAM, this.batchEntryName);
            batchEntry.put(BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM, this.batchEntryOmitResultOnSuccess);
        }
        if (this.batchEntryDependsOn != null) {
            batchEntry.put(BATCH_ENTRY_DEPENDS_ON_PARAM, this.batchEntryDependsOn);
        }
        String relativeURL = getUrlForBatchedRequest();
        batchEntry.put(BATCH_RELATIVE_URL_PARAM, relativeURL);
        batchEntry.put(BATCH_METHOD_PARAM, this.httpMethod);
        if (this.session != null) {
            Logger.registerAccessToken(this.session.getAccessToken());
        }
        ArrayList<String> attachmentNames = new ArrayList();
        for (String key : this.parameters.keySet()) {
            Object value = this.parameters.get(key);
            if (isSupportedAttachmentType(value)) {
                String name = String.format("%s%d", new Object[]{"file", Integer.valueOf(attachments.size())});
                attachmentNames.add(name);
                attachments.put(name, new Attachment(this, value));
            }
        }
        if (!attachmentNames.isEmpty()) {
            batchEntry.put(ATTACHED_FILES_PARAM, TextUtils.join(",", attachmentNames));
        }
        if (this.graphObject != null) {
            final ArrayList<String> keysAndValues = new ArrayList();
            processGraphObject(this.graphObject, relativeURL, new KeyValueSerializer() {
                public void writeString(String key, String value) throws IOException {
                    keysAndValues.add(String.format("%s=%s", new Object[]{key, URLEncoder.encode(value, AsyncHttpResponseHandler.DEFAULT_CHARSET)}));
                }
            });
            batchEntry.put(BATCH_BODY_PARAM, TextUtils.join("&", keysAndValues));
        }
        batch.put(batchEntry);
    }

    private static boolean hasOnProgressCallbacks(RequestBatch requests) {
        for (com.facebook.RequestBatch.Callback callback : requests.getCallbacks()) {
            if (callback instanceof com.facebook.RequestBatch.OnProgressCallback) {
                return true;
            }
        }
        Iterator it = requests.iterator();
        while (it.hasNext()) {
            if (((Request) it.next()).getCallback() instanceof OnProgressCallback) {
                return true;
            }
        }
        return false;
    }

    private static void setConnectionContentType(HttpURLConnection connection, boolean shouldUseGzip) {
        if (shouldUseGzip) {
            connection.setRequestProperty(CONTENT_TYPE_HEADER, "application/x-www-form-urlencoded");
            connection.setRequestProperty(CONTENT_ENCODING_HEADER, AsyncHttpClient.ENCODING_GZIP);
            return;
        }
        connection.setRequestProperty(CONTENT_TYPE_HEADER, getMimeContentType());
    }

    private static boolean isGzipCompressible(RequestBatch requests) {
        Iterator it = requests.iterator();
        while (it.hasNext()) {
            Request request = (Request) it.next();
            for (String key : request.parameters.keySet()) {
                if (isSupportedAttachmentType(request.parameters.get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

    static final void serializeToUrlConnection(RequestBatch requests, HttpURLConnection connection) throws IOException, JSONException {
        Throwable th;
        Logger logger = new Logger(LoggingBehavior.REQUESTS, "Request");
        int numRequests = requests.size();
        boolean shouldUseGzip = isGzipCompressible(requests);
        HttpMethod connectionHttpMethod = numRequests == 1 ? requests.get(0).httpMethod : HttpMethod.POST;
        connection.setRequestMethod(connectionHttpMethod.name());
        setConnectionContentType(connection, shouldUseGzip);
        URL url = connection.getURL();
        logger.append("Request:\n");
        logger.appendKeyValue("Id", requests.getId());
        logger.appendKeyValue("URL", url);
        logger.appendKeyValue("Method", connection.getRequestMethod());
        logger.appendKeyValue(USER_AGENT_HEADER, connection.getRequestProperty(USER_AGENT_HEADER));
        logger.appendKeyValue(CONTENT_TYPE_HEADER, connection.getRequestProperty(CONTENT_TYPE_HEADER));
        connection.setConnectTimeout(requests.getTimeout());
        connection.setReadTimeout(requests.getTimeout());
        if (connectionHttpMethod == HttpMethod.POST) {
            connection.setDoOutput(true);
            OutputStream outputStream = null;
            try {
                OutputStream outputStream2 = new BufferedOutputStream(connection.getOutputStream());
                if (shouldUseGzip) {
                    try {
                        outputStream2 = new GZIPOutputStream(outputStream2);
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th;
                    }
                }
                if (hasOnProgressCallbacks(requests)) {
                    ProgressNoopOutputStream countingStream = new ProgressNoopOutputStream(requests.getCallbackHandler());
                    processRequest(requests, null, numRequests, url, countingStream, shouldUseGzip);
                    outputStream = new ProgressOutputStream(outputStream2, requests, countingStream.getProgressMap(), (long) countingStream.getMaxProgress());
                } else {
                    outputStream = outputStream2;
                }
                processRequest(requests, logger, numRequests, url, outputStream, shouldUseGzip);
                if (outputStream != null) {
                    outputStream.close();
                }
                logger.log();
                return;
            } catch (Throwable th3) {
                th = th3;
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        }
        logger.log();
    }

    private static void processRequest(RequestBatch requests, Logger logger, int numRequests, URL url, OutputStream outputStream, boolean shouldUseGzip) throws IOException, JSONException {
        Serializer serializer = new Serializer(outputStream, logger, shouldUseGzip);
        Map<String, Attachment> attachments;
        if (numRequests == 1) {
            Request request = requests.get(0);
            attachments = new HashMap();
            for (String key : request.parameters.keySet()) {
                Object value = request.parameters.get(key);
                if (isSupportedAttachmentType(value)) {
                    attachments.put(key, new Attachment(request, value));
                }
            }
            if (logger != null) {
                logger.append("  Parameters:\n");
            }
            serializeParameters(request.parameters, serializer, request);
            if (logger != null) {
                logger.append("  Attachments:\n");
            }
            serializeAttachments(attachments, serializer);
            if (request.graphObject != null) {
                processGraphObject(request.graphObject, url.getPath(), serializer);
                return;
            }
            return;
        }
        String batchAppID = getBatchAppId(requests);
        if (Utility.isNullOrEmpty(batchAppID)) {
            throw new FacebookException("At least one request in a batch must have an open Session, or a default app ID must be specified.");
        }
        serializer.writeString(BATCH_APP_ID_PARAM, batchAppID);
        attachments = new HashMap();
        serializeRequestsAsJSON(serializer, requests, attachments);
        if (logger != null) {
            logger.append("  Attachments:\n");
        }
        serializeAttachments(attachments, serializer);
    }

    private static boolean isMeRequest(String path) {
        Matcher matcher = versionPattern.matcher(path);
        if (matcher.matches()) {
            path = matcher.group(1);
        }
        if (path.startsWith("me/") || path.startsWith("/me/")) {
            return true;
        }
        return false;
    }

    private static void processGraphObject(GraphObject graphObject, String path, KeyValueSerializer serializer) throws IOException {
        boolean isOGAction = false;
        if (isMeRequest(path)) {
            int colonLocation = path.indexOf(":");
            int questionMarkLocation = path.indexOf("?");
            if (colonLocation <= 3 || (questionMarkLocation != -1 && colonLocation >= questionMarkLocation)) {
                isOGAction = false;
            } else {
                isOGAction = true;
            }
        }
        for (Entry<String, Object> entry : graphObject.asMap().entrySet()) {
            boolean passByValue;
            if (isOGAction && ((String) entry.getKey()).equalsIgnoreCase("image")) {
                passByValue = true;
            } else {
                passByValue = false;
            }
            processGraphObjectProperty((String) entry.getKey(), entry.getValue(), serializer, passByValue);
        }
    }

    private static void processGraphObjectProperty(String key, Object value, KeyValueSerializer serializer, boolean passByValue) throws IOException {
        JSONObject value2;
        Class<?> valueClass = value.getClass();
        if (GraphObject.class.isAssignableFrom(valueClass)) {
            value2 = ((GraphObject) value).getInnerJSONObject();
            valueClass = value2.getClass();
        } else if (GraphObjectList.class.isAssignableFrom(valueClass)) {
            value2 = ((GraphObjectList) value).getInnerJSONArray();
            valueClass = value2.getClass();
        }
        if (JSONObject.class.isAssignableFrom(valueClass)) {
            JSONObject jsonObject = value2;
            if (passByValue) {
                Iterator<String> keys = jsonObject.keys();
                while (keys.hasNext()) {
                    Object[] objArr = new Object[]{key, (String) keys.next()};
                    processGraphObjectProperty(String.format("%s[%s]", objArr), jsonObject.opt((String) keys.next()), serializer, passByValue);
                }
            } else if (jsonObject.has("id")) {
                processGraphObjectProperty(key, jsonObject.optString("id"), serializer, passByValue);
            } else if (jsonObject.has("url")) {
                processGraphObjectProperty(key, jsonObject.optString("url"), serializer, passByValue);
            } else if (jsonObject.has(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                processGraphObjectProperty(key, jsonObject.toString(), serializer, passByValue);
            }
        } else if (JSONArray.class.isAssignableFrom(valueClass)) {
            JSONArray jsonArray = (JSONArray) value2;
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                processGraphObjectProperty(String.format("%s[%d]", new Object[]{key, Integer.valueOf(i)}), jsonArray.opt(i), serializer, passByValue);
            }
        } else if (String.class.isAssignableFrom(valueClass) || Number.class.isAssignableFrom(valueClass) || Boolean.class.isAssignableFrom(valueClass)) {
            serializer.writeString(key, value2.toString());
        } else if (Date.class.isAssignableFrom(valueClass)) {
            KeyValueSerializer keyValueSerializer = serializer;
            String str = key;
            keyValueSerializer.writeString(str, new SimpleDateFormat(ISO_8601_FORMAT_STRING, Locale.US).format((Date) value2));
        }
    }

    private static void serializeParameters(Bundle bundle, Serializer serializer, Request request) throws IOException {
        for (String key : bundle.keySet()) {
            Object value = bundle.get(key);
            if (isSupportedParameterType(value)) {
                serializer.writeObject(key, value, request);
            }
        }
    }

    private static void serializeAttachments(Map<String, Attachment> attachments, Serializer serializer) throws IOException {
        for (String key : attachments.keySet()) {
            Attachment attachment = (Attachment) attachments.get(key);
            if (isSupportedAttachmentType(attachment.getValue())) {
                serializer.writeObject(key, attachment.getValue(), attachment.getRequest());
            }
        }
    }

    private static void serializeRequestsAsJSON(Serializer serializer, Collection<Request> requests, Map<String, Attachment> attachments) throws JSONException, IOException {
        JSONArray batch = new JSONArray();
        for (Request request : requests) {
            request.serializeToBatch(batch, attachments);
        }
        serializer.writeRequestsAsJson(BATCH_PARAM, batch, requests);
    }

    private static String getMimeContentType() {
        return String.format("multipart/form-data; boundary=%s", new Object[]{MIME_BOUNDARY});
    }

    private static String getUserAgent() {
        if (userAgent == null) {
            userAgent = String.format("%s.%s", new Object[]{USER_AGENT_BASE, FacebookSdkVersion.BUILD});
        }
        return userAgent;
    }

    private static String getBatchAppId(RequestBatch batch) {
        if (!Utility.isNullOrEmpty(batch.getBatchApplicationId())) {
            return batch.getBatchApplicationId();
        }
        Iterator it = batch.iterator();
        while (it.hasNext()) {
            Session session = ((Request) it.next()).session;
            if (session != null) {
                return session.getApplicationId();
            }
        }
        return defaultBatchApplicationId;
    }

    private static <T extends GraphObject> List<T> typedListFromResponse(Response response, Class<T> clazz) {
        GraphMultiResult multiResult = (GraphMultiResult) response.getGraphObjectAs(GraphMultiResult.class);
        if (multiResult == null) {
            return null;
        }
        GraphObjectList<GraphObject> data = multiResult.getData();
        if (data != null) {
            return data.castToListOf(clazz);
        }
        return null;
    }

    private static boolean isSupportedAttachmentType(Object value) {
        return (value instanceof Bitmap) || (value instanceof byte[]) || (value instanceof ParcelFileDescriptor) || (value instanceof ParcelFileDescriptorWithMimeType);
    }

    private static boolean isSupportedParameterType(Object value) {
        return (value instanceof String) || (value instanceof Boolean) || (value instanceof Number) || (value instanceof Date);
    }

    private static String parameterToString(Object value) {
        if (value instanceof String) {
            return (String) value;
        }
        if ((value instanceof Boolean) || (value instanceof Number)) {
            return value.toString();
        }
        if (value instanceof Date) {
            return new SimpleDateFormat(ISO_8601_FORMAT_STRING, Locale.US).format(value);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }
}
