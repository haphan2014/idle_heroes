package com.heyzap.http;

import com.heyzap.internal.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class RequestParams {
    protected static final String LOG_TAG = "RequestParams";
    protected String contentEncoding;
    protected ConcurrentHashMap<String, FileWrapper> fileParams;
    protected boolean isRepeatable;
    protected ConcurrentHashMap<String, StreamWrapper> streamParams;
    protected ConcurrentHashMap<String, String> urlParams;
    protected ConcurrentHashMap<String, Object> urlParamsWithObjects;
    protected boolean useJsonStreamer;

    class C13791 extends HashMap<String, String> {
        final /* synthetic */ String val$key;
        final /* synthetic */ String val$value;

        C13791(String str, String str2) {
            this.val$key = str;
            this.val$value = str2;
            put(this.val$key, this.val$value);
        }
    }

    class C13802 implements Comparator<Entry<String, String>> {
        C13802() {
        }

        public int compare(Entry<String, String> lhs, Entry<String, String> rhs) {
            return ((String) lhs.getKey()).compareTo((String) rhs.getKey());
        }
    }

    public static class FileWrapper {
        public String contentType;
        public File file;

        public FileWrapper(File file, String contentType) {
            this.file = file;
            this.contentType = contentType;
        }
    }

    public static class StreamWrapper {
        public String contentType;
        public InputStream inputStream;
        public String name;

        public StreamWrapper(InputStream inputStream, String name, String contentType) {
            this.inputStream = inputStream;
            this.name = name;
            this.contentType = contentType;
        }
    }

    public void setContentEncoding(String encoding) {
        if (encoding != null) {
            this.contentEncoding = encoding;
        }
    }

    public RequestParams() {
        this((Map) null);
    }

    public RequestParams(Map<String, String> source) {
        this.contentEncoding = AsyncHttpResponseHandler.DEFAULT_CHARSET;
        init();
        if (source != null) {
            for (Entry<String, String> entry : source.entrySet()) {
                put((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public RequestParams(String key, String value) {
        this(new C13791(key, value));
    }

    public RequestParams(Object... keysAndValues) {
        this.contentEncoding = AsyncHttpResponseHandler.DEFAULT_CHARSET;
        init();
        int len = keysAndValues.length;
        if (len % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (int i = 0; i < len; i += 2) {
            put(String.valueOf(keysAndValues[i]), String.valueOf(keysAndValues[i + 1]));
        }
    }

    public void put(String key, String value) {
        if (key != null && value != null) {
            this.urlParams.put(key, value);
        }
    }

    public void put(String key, File file) throws FileNotFoundException {
        put(key, file, null);
    }

    public void put(String key, File file, String contentType) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        } else if (key != null) {
            this.fileParams.put(key, new FileWrapper(file, contentType));
        }
    }

    public void put(String key, InputStream stream) {
        put(key, stream, null);
    }

    public void put(String key, InputStream stream, String name) {
        put(key, stream, name, null);
    }

    public void put(String key, InputStream stream, String name, String contentType) {
        if (key != null && stream != null) {
            this.streamParams.put(key, new StreamWrapper(stream, name, contentType));
        }
    }

    public void put(String key, Object value) {
        if (key != null && value != null) {
            this.urlParamsWithObjects.put(key, value);
        }
    }

    public void put(String key, Integer value) {
        if (key != null && value != null) {
            this.urlParamsWithObjects.put(key, String.valueOf(value));
        }
    }

    public void add(String key, String value) {
        if (key != null && value != null) {
            Object obj = this.urlParamsWithObjects.get(key);
            if (obj == null) {
                obj = new HashSet();
                put(key, obj);
            }
            if (obj instanceof List) {
                ((List) obj).add(value);
            } else if (obj instanceof Set) {
                ((Set) obj).add(value);
            }
        }
    }

    public void remove(String key) {
        this.urlParams.remove(key);
        this.streamParams.remove(key);
        this.fileParams.remove(key);
        this.urlParamsWithObjects.remove(key);
    }

    public Boolean containsKey(String key) {
        boolean z = false;
        if (key == null) {
            return Boolean.valueOf(false);
        }
        if (this.urlParams.containsKey(key) || this.urlParamsWithObjects.containsKey(key)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public String get(String key) {
        if (key == null) {
            return null;
        }
        try {
            return (String) this.urlParams.get(key);
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void merge(Map<String, String> params) {
        if (params != null) {
            for (Entry<String, String> entry : params.entrySet()) {
                put((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        List<Entry<String, String>> entries = new ArrayList(this.urlParams.entrySet());
        Collections.sort(entries, new C13802());
        for (Entry<String, String> entry : entries) {
            if (result.length() > 0) {
                result.append("&");
            }
            result.append((String) entry.getKey());
            result.append("=");
            result.append((String) entry.getValue());
        }
        for (Entry<String, StreamWrapper> entry2 : this.streamParams.entrySet()) {
            if (result.length() > 0) {
                result.append("&");
            }
            result.append((String) entry2.getKey());
            result.append("=");
            result.append("STREAM");
        }
        for (Entry<String, FileWrapper> entry3 : this.fileParams.entrySet()) {
            if (result.length() > 0) {
                result.append("&");
            }
            result.append((String) entry3.getKey());
            result.append("=");
            result.append("FILE");
        }
        for (BasicNameValuePair kv : getParamsList(null, this.urlParamsWithObjects)) {
            if (result.length() > 0) {
                result.append("&");
            }
            result.append(kv.getName());
            result.append("=");
            result.append(kv.getValue());
        }
        return result.toString();
    }

    public void setHttpEntityIsRepeatable(boolean isRepeatable) {
        this.isRepeatable = isRepeatable;
    }

    public void setUseJsonStreamer(boolean useJsonStreamer) {
        this.useJsonStreamer = useJsonStreamer;
    }

    public HttpEntity getEntity(ResponseHandlerInterface progressHandler) throws IOException {
        if (this.useJsonStreamer) {
            return createJsonStreamerEntity();
        }
        if (this.streamParams.isEmpty() && this.fileParams.isEmpty()) {
            return createFormEntity();
        }
        return createMultipartEntity(progressHandler);
    }

    private HttpEntity createJsonStreamerEntity() throws IOException {
        boolean z = (this.fileParams.isEmpty() && this.streamParams.isEmpty()) ? false : true;
        JsonStreamerEntity entity = new JsonStreamerEntity(z);
        for (Entry<String, String> entry : this.urlParams.entrySet()) {
            entity.addPart((String) entry.getKey(), entry.getValue());
        }
        for (Entry<String, Object> entry2 : this.urlParamsWithObjects.entrySet()) {
            entity.addPart((String) entry2.getKey(), entry2.getValue());
        }
        for (Entry<String, FileWrapper> entry3 : this.fileParams.entrySet()) {
            FileWrapper fileWrapper = (FileWrapper) entry3.getValue();
            entity.addPart((String) entry3.getKey(), new FileInputStream(fileWrapper.file), fileWrapper.file.getName(), fileWrapper.contentType);
        }
        for (Entry<String, StreamWrapper> entry4 : this.streamParams.entrySet()) {
            StreamWrapper stream = (StreamWrapper) entry4.getValue();
            if (stream.inputStream != null) {
                entity.addPart((String) entry4.getKey(), stream.inputStream, stream.name, stream.contentType);
            }
        }
        return entity;
    }

    private HttpEntity createFormEntity() {
        try {
            return new UrlEncodedFormEntity(getParamsList(), this.contentEncoding);
        } catch (UnsupportedEncodingException e) {
            Logger.error("createFormEntity failed", e);
            return null;
        }
    }

    private HttpEntity createMultipartEntity(ResponseHandlerInterface progressHandler) throws IOException {
        SimpleMultipartEntity entity = new SimpleMultipartEntity(progressHandler);
        entity.setIsRepeatable(this.isRepeatable);
        for (Entry<String, String> entry : this.urlParams.entrySet()) {
            entity.addPart((String) entry.getKey(), (String) entry.getValue());
        }
        for (BasicNameValuePair kv : getParamsList(null, this.urlParamsWithObjects)) {
            entity.addPart(kv.getName(), kv.getValue());
        }
        for (Entry<String, StreamWrapper> entry2 : this.streamParams.entrySet()) {
            StreamWrapper stream = (StreamWrapper) entry2.getValue();
            if (stream.inputStream != null) {
                entity.addPart((String) entry2.getKey(), stream.name, stream.inputStream, stream.contentType);
            }
        }
        for (Entry<String, FileWrapper> entry3 : this.fileParams.entrySet()) {
            FileWrapper fileWrapper = (FileWrapper) entry3.getValue();
            entity.addPart((String) entry3.getKey(), fileWrapper.file, fileWrapper.contentType);
        }
        return entity;
    }

    private void init() {
        this.urlParams = new ConcurrentHashMap();
        this.streamParams = new ConcurrentHashMap();
        this.fileParams = new ConcurrentHashMap();
        this.urlParamsWithObjects = new ConcurrentHashMap();
    }

    protected List<BasicNameValuePair> getParamsList() {
        List<BasicNameValuePair> lparams = new LinkedList();
        for (Entry<String, String> entry : this.urlParams.entrySet()) {
            lparams.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        lparams.addAll(getParamsList(null, this.urlParamsWithObjects));
        return lparams;
    }

    private List<BasicNameValuePair> getParamsList(String key, Object value) {
        List<BasicNameValuePair> params = new LinkedList();
        Object nestedValue;
        if (value instanceof Map) {
            Map<String, Object> map = (Map) value;
            List<String> list = new ArrayList(map.keySet());
            Collections.sort(list);
            for (String nestedKey : list) {
                String nestedKey2;
                nestedValue = map.get(nestedKey2);
                if (nestedValue != null) {
                    if (key != null) {
                        nestedKey2 = String.format("%s[%s]", new Object[]{key, nestedKey2});
                    }
                    params.addAll(getParamsList(nestedKey2, nestedValue));
                }
            }
        } else if (value instanceof List) {
            for (Object nestedValue2 : (List) value) {
                params.addAll(getParamsList(String.format("%s[]", new Object[]{key}), nestedValue2));
            }
        } else if (value instanceof Object[]) {
            for (Object nestedValue22 : (Object[]) value) {
                params.addAll(getParamsList(String.format("%s[]", new Object[]{key}), nestedValue22));
            }
        } else if (value instanceof Set) {
            for (Object nestedValue222 : (Set) value) {
                params.addAll(getParamsList(key, nestedValue222));
            }
        } else if (value instanceof String) {
            params.add(new BasicNameValuePair(key, (String) value));
        }
        return params;
    }

    protected String getParamString() {
        return URLEncodedUtils.format(getParamsList(), this.contentEncoding);
    }
}
