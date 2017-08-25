package com.heyzap.common.video;

import android.content.Context;
import android.net.Uri;
import com.heyzap.common.cache.Entry;
import com.heyzap.common.net.FileFetchClient;
import com.heyzap.house.Manager;
import com.heyzap.house.model.AdModel.ModelPostFetchCompleteListener;
import com.heyzap.http.FileAsyncHttpResponseHandler;
import com.heyzap.http.RequestHandle;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import java.io.File;
import org.apache.http.Header;

public class Cacher extends FileAsyncHttpResponseHandler {
    private Entry createdCacheEntry = null;
    private boolean firedFinished = false;
    private ModelPostFetchCompleteListener listener;
    private VideoModelInterface model;
    private int percentDownloaded = 0;

    public Cacher(File file, VideoModelInterface model, ModelPostFetchCompleteListener listener) {
        super(file);
        this.model = model;
        this.listener = listener;
    }

    public static void start(Context context, VideoModelInterface model, ModelPostFetchCompleteListener listener) {
        Throwable e;
        Utils.createCacheDir(context);
        Uri uri = model.getStaticUri();
        Uri streamingUri = model.getStreamingUri();
        if (uri == null && streamingUri != null) {
            uri = streamingUri;
        } else if (uri == null) {
            Logger.log("Cacher.start null uri!");
            e = new Throwable("No video to download.");
            if (listener != null) {
                listener.onComplete(null, e);
                return;
            }
            return;
        }
        String fileName = String.format("video-%s.mp4", new Object[]{model.getCreativeUniqueIdentifier()});
        File file = new File(Utils.getCachePath(context, fileName));
        Entry entry = Manager.getInstance().getFileCache().get(fileName);
        if (entry != null) {
            entry.setLastUsed();
            model.setIsReady(Boolean.valueOf(true));
            model.setCacheEntry(entry);
            model.setPercentDownloaded(Integer.valueOf(100));
            Logger.format("(VIDEO PRE-CACHED) %s", model);
            listener.onComplete(model, null);
            return;
        }
        try {
            Cacher responseHandler;
            RequestHandle handle;
            if (file.createNewFile()) {
                responseHandler = new Cacher(file, model, listener);
                responseHandler.setUseSynchronousMode(false);
                handle = FileFetchClient.fetch(context, uri.toString(), responseHandler);
            } else {
                responseHandler = new Cacher(file, model, listener);
                responseHandler.setUseSynchronousMode(false);
                handle = FileFetchClient.fetch(context, uri.toString(), responseHandler);
            }
        } catch (Throwable e2) {
            Logger.log("Cache.start IOException");
            Logger.trace(e2);
            if (listener != null) {
                Logger.log("Cache.start IOException listener is null");
                listener.onComplete(null, e2);
            }
        }
    }

    public void onProgress(int bytesWritten, int totalSize) {
        this.percentDownloaded = (bytesWritten * 100) / totalSize;
        this.model.setSize(bytesWritten);
        this.model.setPercentDownloaded(Integer.valueOf(this.percentDownloaded));
        if (this.model.getVideoDisplayOptions().requiredDownloadPercent < 100.0d && this.model.getVideoDisplayOptions().requiredDownloadPercent < ((double) this.percentDownloaded)) {
            this.model.setIsReady(Boolean.valueOf(true));
            onSuccess(200, new Header[0], getTargetFile());
        }
    }

    public void onStart() {
        Logger.format("(DOWNLOADING) %s", this.model);
    }

    public void onFailure(int statusCode, Header[] headers, Throwable e, File file) {
        if (e.getMessage().equals("No space left on device")) {
            Logger.log("Dumping caches.");
            try {
                Manager.getInstance().clearAndCreateFileCache();
            } catch (Throwable e1) {
                Logger.trace(e1);
            }
        }
        if (file.exists()) {
            file.delete();
        }
        Logger.format("(DOWNLOAD ERROR) Error: %s %s", e.toString(), this.model);
        if (this.listener != null) {
            this.listener.onComplete(null, e);
        }
    }

    public void onSuccess(int statusCode, Header[] headers, File file) {
        if (!this.firedFinished) {
            this.firedFinished = true;
            if (file.exists()) {
                try {
                    if (this.createdCacheEntry == null) {
                        this.createdCacheEntry = new Entry();
                        this.createdCacheEntry.setFilename(file.getAbsolutePath());
                        this.createdCacheEntry.setIdentifier(file.getName());
                        Manager.getInstance().getFileCache().put(this.createdCacheEntry);
                    }
                    if (this.percentDownloaded < 100) {
                        this.createdCacheEntry.setDirty(Boolean.valueOf(true));
                    } else {
                        this.createdCacheEntry.setDirty(Boolean.valueOf(false));
                    }
                    Manager.getInstance().getFileCache().sync();
                    Logger.format("(CACHED) %s", this.model);
                    this.model.setIsReady(Boolean.valueOf(true));
                    this.model.setCacheEntry(this.createdCacheEntry);
                    if (this.listener != null) {
                        this.listener.onComplete(this.model, null);
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    Logger.trace(e);
                    onFailure(statusCode, headers, e, file);
                    return;
                }
            }
            onFailure(statusCode, headers, new Throwable("Downloaded video does not exist on filesystem."), file);
        }
    }

    public void onCancel() {
        Logger.format("(DOWNLOAD CANCELLED) %s", this.model);
        Throwable e = new Throwable("cancelled");
        if (this.listener != null) {
            this.listener.onComplete(this.model, e);
        }
    }
}
