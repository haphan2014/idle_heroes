package com.heyzap.common.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Gzip {
    public static byte[] compress(String srcTxt) throws IOException {
        ByteArrayOutputStream rstBao = new ByteArrayOutputStream();
        GZIPOutputStream zos = new GZIPOutputStream(rstBao);
        zos.write(srcTxt.getBytes());
        zos.finish();
        zos.close();
        return rstBao.toByteArray();
    }
}
