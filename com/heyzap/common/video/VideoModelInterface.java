package com.heyzap.common.video;

import android.net.Uri;
import com.heyzap.common.cache.Entry;
import com.heyzap.internal.Constants.AdUnit;

public interface VideoModelInterface {
    Entry getCacheEntry();

    String getCreativeUniqueIdentifier();

    Uri getStaticUri();

    Uri getStreamingUri();

    VideoDisplayOptions getVideoDisplayOptions();

    Boolean isFileCached();

    Boolean isReady();

    void setAdUnit(AdUnit adUnit);

    void setCacheEntry(Entry entry);

    void setIsReady(Boolean bool);

    void setPercentDownloaded(Integer num);

    void setSize(int i);
}
