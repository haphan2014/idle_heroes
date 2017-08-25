package com.heyzap.house.handler;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.drive.DriveFile;
import java.io.File;
import java.io.FileNotFoundException;

public class ImageCacheProvider extends ContentProvider {
    private static final String URI_PREFIX = "content://com.heyzap.imagecache";

    public static String constructUri(String url) {
        return Uri.parse(url).isAbsolute() ? url : URI_PREFIX + url;
    }

    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        return ParcelFileDescriptor.open(new File(uri.getPath()), DriveFile.MODE_READ_ONLY);
    }

    public boolean onCreate() {
        return true;
    }

    public int delete(Uri uri, String s, String[] as) {
        throw new UnsupportedOperationException("Not supported by this provider");
    }

    public String getType(Uri uri) {
        throw new UnsupportedOperationException("Not supported by this provider");
    }

    public Uri insert(Uri uri, ContentValues contentvalues) {
        throw new UnsupportedOperationException("Not supported by this provider");
    }

    public Cursor query(Uri uri, String[] as, String s, String[] as1, String s1) {
        throw new UnsupportedOperationException("Not supported by this provider");
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String[] as) {
        throw new UnsupportedOperationException("Not supported by this provider");
    }
}
