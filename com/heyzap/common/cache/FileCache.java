package com.heyzap.common.cache;

import com.facebook.internal.ServerProtocol;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.internal.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FileCache {
    public static String ENTRIES_FILENAME = "entries.json";
    public static String KLASS_ELEMENT = "klass";
    public static String ROOT_ENTRIES_ELEMENT = "entries";
    public static String ROOT_VERSION_ELEMENT = ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION;
    public static final String SUPER_FILE_PREFIX = "hz";
    public static Long UNLIMITED_SIZE = Long.valueOf(0);
    public static Long VERSION_UID = Long.valueOf(0);
    private File cacheDir;
    private ConcurrentHashMap<String, Entry> entries;
    private File entriesFile;
    private Executor executor;
    private Long maxSizeBytes = UNLIMITED_SIZE;
    private AtomicBoolean open;

    class EntriesReader implements Runnable {
        FileCache cache;
        SettableFuture<Boolean> entriesFuture;

        public EntriesReader(FileCache cache, SettableFuture<Boolean> future) {
            this.cache = cache;
            this.entriesFuture = future;
        }

        public void run() {
            try {
                JSONArray arr = read();
                if (arr != null && arr.length() > 0) {
                    for (int i = 0; i < arr.length(); i++) {
                        Entry entry = null;
                        JSONObject obj = null;
                        try {
                            obj = arr.getJSONObject(i);
                        } catch (Object e) {
                            Logger.log(e);
                        }
                        if (obj != null) {
                            try {
                                String klassName = obj.getString(FileCache.KLASS_ELEMENT);
                                if (klassName.equals("com.heyzap.house.cache.Entry")) {
                                    klassName = "com.heyzap.common.cache.Entry";
                                }
                                entry = (Entry) Class.forName(klassName).getDeclaredMethod("fromJSONObject", new Class[]{JSONObject.class}).invoke(null, new Object[]{obj});
                                if (entry == null) {
                                    continue;
                                } else if (entry.fileExists().booleanValue() && !entry.isDirty().booleanValue()) {
                                    this.cache.put(entry);
                                }
                            } catch (Throwable e2) {
                                Logger.trace(e2);
                                try {
                                    entry = Entry.fromJSONObject(obj);
                                } catch (Object je) {
                                    Logger.log(je);
                                } catch (Object ioe) {
                                    Logger.log(ioe);
                                }
                                if (entry == null) {
                                    continue;
                                } else if (entry.fileExists().booleanValue() && !entry.isDirty().booleanValue()) {
                                    this.cache.put(entry);
                                }
                            } catch (Throwable th) {
                                if (entry != null) {
                                    if (entry.fileExists().booleanValue() && !entry.isDirty().booleanValue()) {
                                        this.cache.put(entry);
                                    }
                                }
                            }
                        }
                    }
                }
                this.cache.open.set(true);
                this.entriesFuture.set(this.cache.sync().get());
            } catch (Throwable e22) {
                Logger.trace(e22);
                this.entriesFuture.setException(e22);
            }
        }

        private JSONArray read() throws Exception {
            JSONArray arr = null;
            if ((this.cache.getDirectory() != null && this.cache.getDirectory().mkdirs()) || this.cache.getDirectory().isDirectory()) {
                InputStream inputStream;
                try {
                    inputStream = new FileInputStream(FileCache.this.getEntriesFile());
                    BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder total = new StringBuilder();
                    while (true) {
                        String line = r.readLine();
                        if (line == null) {
                            break;
                        }
                        total.append(line);
                    }
                    arr = new JSONObject(total.toString()).getJSONArray(FileCache.ROOT_ENTRIES_ELEMENT);
                    inputStream.close();
                } catch (FileNotFoundException e) {
                    return null;
                } catch (JSONException e2) {
                    return null;
                } catch (Throwable th) {
                    inputStream.close();
                }
            }
            return arr;
        }
    }

    class SyncRunnable implements Runnable {
        FileCache cache;
        SettableFuture<Boolean> entriesFuture;

        public SyncRunnable(FileCache cache, SettableFuture<Boolean> future) {
            this.cache = cache;
            this.entriesFuture = future;
        }

        public void run() {
            try {
                Long startTime = Long.valueOf(System.currentTimeMillis());
                writeEntriesFile();
                clean();
                Long totalTime = Long.valueOf(System.currentTimeMillis() - startTime.longValue());
                Logger.format("(CACHE) Sync took %dms", totalTime);
                this.entriesFuture.set(Boolean.valueOf(true));
            } catch (Throwable e) {
                Logger.trace(e);
                this.entriesFuture.setException(e);
            }
        }

        private void writeEntriesFile() throws Exception {
            JSONObject rootObject = new JSONObject();
            JSONArray entriesArr = new JSONArray();
            for (Entry entry : FileCache.this.entries.values()) {
                if (!entry.isDirty().booleanValue()) {
                    try {
                        entriesArr.put(entry.asJSONObject());
                    } catch (Throwable e) {
                        Logger.trace(e);
                    }
                }
            }
            rootObject.put(FileCache.ROOT_ENTRIES_ELEMENT, entriesArr);
            rootObject.put(FileCache.ROOT_VERSION_ELEMENT, FileCache.VERSION_UID);
            FileWriter file = new FileWriter(this.cache.getEntriesFile());
            file.write(rootObject.toString());
            file.flush();
            file.close();
        }

        private void clean() {
            ArrayList<String> managedFiles = new ArrayList();
            Iterator it = this.cache.all().iterator();
            while (it.hasNext()) {
                managedFiles.add(((Entry) it.next()).getFile().getAbsolutePath());
            }
            managedFiles.add(this.cache.getEntriesFile().getAbsolutePath());
            for (File file : this.cache.getDirectory().listFiles()) {
                if (!managedFiles.contains(file.getAbsolutePath())) {
                    file.delete();
                }
            }
        }
    }

    public FileCache(Executor executor, File cacheDir, Long maxSizeBytes) {
        this.executor = executor;
        this.cacheDir = cacheDir;
        this.maxSizeBytes = maxSizeBytes;
        this.open = new AtomicBoolean(false);
    }

    public SettableFuture<Boolean> open() {
        Logger.log("(CACHE) Open");
        SettableFuture<Boolean> success = SettableFuture.create();
        if (this.open.get()) {
            success.set(Boolean.valueOf(true));
        } else {
            this.entries = new ConcurrentHashMap();
            this.executor.execute(new EntriesReader(this, success));
        }
        return success;
    }

    public SettableFuture<Boolean> close() {
        Logger.log("(CACHE) Close");
        this.open.set(false);
        this.entries = null;
        return sync();
    }

    public void put(Entry entry) {
        if (!this.entries.contains(entry.getIdentifier())) {
            this.entries.put(entry.getIdentifier(), entry);
        }
    }

    public Entry get(String identifier) {
        if (this.open.get()) {
            Entry entry = (Entry) this.entries.get(identifier);
            if (entry != null) {
                if (entry.fileExists().booleanValue()) {
                    return entry;
                }
                remove(entry);
            }
        }
        return null;
    }

    public ArrayList<Entry> all() {
        return new ArrayList(this.entries.values());
    }

    public Boolean remove(Entry entry) {
        if (entry.deleteHardReference().booleanValue()) {
            this.entries.remove(entry);
            return Boolean.valueOf(true);
        }
        Logger.format("(CACHE) Failed to remove %s. Deletion failed.", entry.getIdentifier());
        return Boolean.valueOf(false);
    }

    public void remove(String identifier) {
        Entry entry = (Entry) this.entries.get(identifier);
        if (entry != null) {
            remove(entry);
        }
    }

    public void destroy() {
        getEntriesFile().delete();
        this.open.set(false);
        for (Entry entry : this.entries.values()) {
            entry.deleteHardReference();
        }
    }

    public SettableFuture<Boolean> flush() {
        SettableFuture<Boolean> future = SettableFuture.create();
        Long total_size = size();
        for (Entry entry : this.entries.values()) {
            Entry entry2;
            total_size = Long.valueOf(total_size.longValue() + entry2.getSize());
        }
        if (this.maxSizeBytes == UNLIMITED_SIZE) {
            future.set(Boolean.valueOf(true));
            return future;
        } else if (this.maxSizeBytes == UNLIMITED_SIZE || total_size.longValue() <= this.maxSizeBytes.longValue()) {
            Logger.format("(CACHE) No need to flush. Unlimited cache size or under max at %d bytes", total_size);
            future.set(Boolean.valueOf(true));
            return future;
        } else {
            Logger.format("(CACHE) Flushing LRU... (%d bytes for a max %d)", total_size, this.maxSizeBytes);
            LinkedList<Entry> list = new LinkedList(this.entries.values());
            Collections.sort(list);
            int removed = 0;
            long bytesSaved = 0;
            while (total_size.longValue() > this.maxSizeBytes.longValue()) {
                try {
                    entry2 = (Entry) list.removeFirst();
                    if (entry2 == null) {
                        throw new Exception("Error in popping!");
                    } else if (remove(entry2).booleanValue()) {
                        removed++;
                        bytesSaved += entry2.getSize();
                        total_size = Long.valueOf(total_size.longValue() - entry2.getSize());
                    }
                } catch (Exception e) {
                    future.setException(e);
                    Logger.format("(CACHE) Flush removed %d entries and freed %d bytes", Integer.valueOf(removed), Long.valueOf(bytesSaved));
                } catch (Throwable th) {
                    Logger.format("(CACHE) Flush removed %d entries and freed %d bytes", Integer.valueOf(removed), Long.valueOf(bytesSaved));
                }
            }
            future = sync();
            Logger.format("(CACHE) Flush removed %d entries and freed %d bytes", Integer.valueOf(removed), Long.valueOf(bytesSaved));
            return future;
        }
    }

    public SettableFuture<Boolean> sync() {
        SettableFuture<Boolean> completed = SettableFuture.create();
        this.executor.execute(new SyncRunnable(this, completed));
        return completed;
    }

    public File getDirectory() {
        return this.cacheDir;
    }

    private File getEntriesFile() {
        return new File(getDirectory() + File.separator + ENTRIES_FILENAME);
    }

    public Boolean isOpen() {
        return Boolean.valueOf(this.open.get());
    }

    public Long size() {
        long total_size = 0;
        for (Entry entry : this.entries.values()) {
            total_size += entry.getSize();
        }
        return Long.valueOf(total_size);
    }
}
