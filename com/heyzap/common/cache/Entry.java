package com.heyzap.common.cache;

import android.net.Uri;
import com.heyzap.internal.Logger;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class Entry implements Serializable, Comparable<Entry> {
    private long createdTime;
    private Boolean dirty;
    private long expiry;
    private String fileName;
    private String identifier;
    private long lastUsedTime;
    private long lengthBytes;

    public Entry() {
        this.expiry = 0;
        this.dirty = Boolean.valueOf(true);
        this.createdTime = System.currentTimeMillis();
        touch();
    }

    public Entry(String filename, String identifier) {
        this.expiry = 0;
        this.dirty = Boolean.valueOf(true);
    }

    public final Boolean isDirty() {
        return this.dirty;
    }

    public final void setDirty(Boolean dirty) {
        this.dirty = dirty;
    }

    public final String getFilename() {
        return this.fileName;
    }

    public final void setFilename(String filename) throws IOException {
        this.fileName = filename;
        File file = new File(filename);
        if (file.exists()) {
            this.lengthBytes = file.length();
            if (this.lengthBytes == 0) {
                throw new IOException("File has zero file size");
            }
            return;
        }
        throw new IOException("File does not exist.");
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public final long getSize() {
        return this.lengthBytes;
    }

    public final void setLastUsed(long lastUsedTime) {
        this.lastUsedTime = lastUsedTime;
    }

    public final void setLastUsed() {
        this.lastUsedTime = System.currentTimeMillis();
    }

    public final long getLastUsedTime() {
        return this.lastUsedTime;
    }

    public final void touch() {
        this.lastUsedTime = System.currentTimeMillis();
    }

    public final Boolean fileExists() {
        return Boolean.valueOf(getFile().exists());
    }

    public final File getFile() {
        return new File(this.fileName);
    }

    public final Uri getUri() {
        return Uri.fromFile(getFile());
    }

    public Boolean deleteHardReference() {
        try {
            if (getFile().getCanonicalFile().delete()) {
                this.dirty = Boolean.valueOf(true);
                return Boolean.valueOf(true);
            }
        } catch (Throwable e) {
            Logger.trace(e);
        }
        return Boolean.valueOf(false);
    }

    public int compareTo(Entry in) {
        if (this.lastUsedTime == in.getLastUsedTime()) {
            return 0;
        }
        if (this.lastUsedTime > in.getLastUsedTime()) {
            return 1;
        }
        return -1;
    }

    public JSONObject asJSONObject() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("file_name", this.fileName);
        obj.put("length_bytes", this.lengthBytes);
        obj.put("last_used_time", this.lastUsedTime);
        obj.put("created_time", this.createdTime);
        obj.put("expiry", this.expiry);
        obj.put("identifier", this.identifier);
        obj.put("dirty", this.dirty);
        obj.put("klass", Entry.class.getName());
        return obj;
    }

    public static Entry fromJSONObject(JSONObject obj) throws JSONException, IOException {
        Entry entry = new Entry();
        entry.dirty = Boolean.valueOf(obj.optBoolean("dirty", false));
        entry.expiry = obj.getLong("expiry");
        entry.lastUsedTime = obj.getLong("last_used_time");
        entry.createdTime = obj.getLong("created_time");
        entry.identifier = obj.getString("identifier");
        entry.setFilename(obj.getString("file_name"));
        return entry;
    }
}
