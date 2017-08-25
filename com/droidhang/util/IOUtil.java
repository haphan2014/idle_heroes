package com.droidhang.util;

import java.io.Closeable;
import java.io.IOException;

public class IOUtil {
    public static void closeQuiet(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
