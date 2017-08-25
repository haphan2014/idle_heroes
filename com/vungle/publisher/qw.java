package com.vungle.publisher;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: vungle */
public final class qw {

    /* compiled from: vungle */
    public interface C1754a {
        void mo4438a(File file, String str, long j);
    }

    public static void m2377a(File file, File file2, C1754a... c1754aArr) throws IOException {
        so.m2470a(3, "VungleFile", "extracting " + file + " to " + file2, null);
        if (file2.isDirectory() || file2.mkdirs()) {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
            byte[] bArr = new byte[8192];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    try {
                        zipInputStream.close();
                        return;
                    } catch (IOException e) {
                        so.m2470a(5, "VungleFile", "error closing zip input stream " + file, null);
                        return;
                    }
                } else if (!nextEntry.isDirectory()) {
                    String name = nextEntry.getName();
                    if (qt.m2374b(name)) {
                        File canonicalFile = new File(file2, name).getCanonicalFile();
                        if (qt.m2371a(file2, canonicalFile)) {
                            so.m2470a(2, "VungleFile", "verified " + canonicalFile + " is nested within " + file2, null);
                            if (qt.m2370a(canonicalFile.getParentFile())) {
                                OutputStream fileOutputStream;
                                try {
                                    so.m2470a(2, "VungleFile", "extracting " + canonicalFile, null);
                                    fileOutputStream = new FileOutputStream(canonicalFile);
                                    long j = 0;
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        long j2 = ((long) read) + j;
                                        fileOutputStream.write(bArr, 0, read);
                                        j = j2;
                                    }
                                    for (int i = 0; i <= 0; i++) {
                                        c1754aArr[i].mo4438a(canonicalFile, name, j);
                                    }
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                    so.m2470a(5, "VungleFile", "error closing file output stream " + file2, null);
                                } catch (Throwable th) {
                                    try {
                                        zipInputStream.close();
                                    } catch (IOException e3) {
                                        so.m2470a(5, "VungleFile", "error closing zip input stream " + file, null);
                                    }
                                }
                            } else {
                                so.m2470a(5, "VungleFile", "could not ensure directory", null);
                            }
                        } else {
                            throw new qv("aborting zip extraction - child " + name + " escapes destination directory " + file2);
                        }
                    }
                    throw new qu("Unsafe path " + name);
                }
            }
        } else {
            throw new IOException("failed to create directories " + file2);
        }
    }
}
