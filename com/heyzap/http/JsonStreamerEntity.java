package com.heyzap.http;

import com.facebook.internal.ServerProtocol;
import com.google.android.gms.location.places.Place;
import com.heyzap.http.RequestParams.StreamWrapper;
import com.heyzap.internal.Logger;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class JsonStreamerEntity implements HttpEntity {
    private static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    private static final int BUFFER_SIZE = 2048;
    private static final StringBuilder BUILDER = new StringBuilder(2764);
    private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final Header HEADER_GZIP_ENCODING = new BasicHeader("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
    private static final Header HEADER_JSON_CONTENT = new BasicHeader("Content-Type", "application/json");
    private static final byte[] JSON_FALSE = "false".getBytes();
    private static final byte[] JSON_NULL = "null".getBytes();
    private static final byte[] JSON_TRUE = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.getBytes();
    private static final String LOG_TAG = "JsonStreamerEntity";
    private static final byte[] STREAM_CONTENTS = escape("contents");
    private static final byte[] STREAM_ELAPSED = escape("_elapsed");
    private static final byte[] STREAM_NAME = escape("name");
    private static final byte[] STREAM_TYPE = escape("type");
    private final Header contentEncoding;
    private final Map<String, Object> kvParams = new HashMap();
    private final Map<String, StreamWrapper> streamParams = new HashMap();

    public JsonStreamerEntity(boolean contentEncoding) {
        this.contentEncoding = contentEncoding ? HEADER_GZIP_ENCODING : null;
    }

    public void addPart(String key, Object value) {
        this.kvParams.put(key, value);
    }

    public void addPart(String key, InputStream inputStream, String name, String type) {
        if (type == null) {
            type = APPLICATION_OCTET_STREAM;
        }
        this.streamParams.put(key, new StreamWrapper(inputStream, name, type));
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isStreaming() {
        return false;
    }

    public long getContentLength() {
        return -1;
    }

    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    public Header getContentType() {
        return HEADER_JSON_CONTENT;
    }

    public void consumeContent() throws IOException, UnsupportedOperationException {
    }

    public InputStream getContent() throws IOException, UnsupportedOperationException {
        throw ERR_UNSUPPORTED;
    }

    public void writeTo(OutputStream outstream) throws IOException {
        if (outstream == null) {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        OutputStream upload;
        long now = System.currentTimeMillis();
        if (this.contentEncoding != null) {
            upload = new GZIPOutputStream(new BufferedOutputStream(outstream), 2048);
        } else {
            upload = new BufferedOutputStream(outstream);
        }
        upload.write(123);
        for (String key : this.kvParams.keySet()) {
            upload.write(escape(key));
            upload.write(58);
            Object value = this.kvParams.get(key);
            if (value instanceof Boolean) {
                byte[] bArr;
                if (((Boolean) value).booleanValue()) {
                    bArr = JSON_TRUE;
                } else {
                    bArr = JSON_FALSE;
                }
                upload.write(bArr);
            } else if (value instanceof Long) {
                upload.write((((Number) value).longValue() + "").getBytes());
            } else if (value instanceof Double) {
                upload.write((((Number) value).doubleValue() + "").getBytes());
            } else if (value instanceof Float) {
                upload.write((((Number) value).floatValue() + "").getBytes());
            } else if (value instanceof Integer) {
                upload.write((((Number) value).intValue() + "").getBytes());
            } else {
                upload.write(value.toString().getBytes());
            }
            upload.write(44);
        }
        byte[] buffer = new byte[2048];
        for (String key2 : this.streamParams.keySet()) {
            StreamWrapper entry = (StreamWrapper) this.streamParams.get(key2);
            upload.write(escape(key2));
            upload.write(58);
            upload.write(123);
            upload.write(STREAM_NAME);
            upload.write(58);
            upload.write(escape(entry.name));
            upload.write(44);
            upload.write(STREAM_TYPE);
            upload.write(58);
            upload.write(escape(entry.contentType));
            upload.write(44);
            upload.write(STREAM_CONTENTS);
            upload.write(58);
            upload.write(34);
            Base64OutputStream outputStream = new Base64OutputStream(upload, 18);
            while (true) {
                int bytesRead = entry.inputStream.read(buffer);
                if (bytesRead == -1) {
                    break;
                }
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            upload.write(34);
            upload.write(125);
            upload.write(44);
        }
        upload.write(STREAM_ELAPSED);
        upload.write(58);
        long elapsedTime = System.currentTimeMillis() - now;
        upload.write((elapsedTime + "}").getBytes());
        Logger.debug("Uploaded JSON in " + Math.floor((double) (elapsedTime / 1000)) + " seconds");
        upload.flush();
        upload.close();
    }

    static byte[] escape(String string) {
        if (string == null) {
            return JSON_NULL;
        }
        BUILDER.append('\"');
        int length = string.length();
        int pos = -1;
        while (true) {
            pos++;
            if (pos < length) {
                char ch = string.charAt(pos);
                switch (ch) {
                    case '\b':
                        BUILDER.append("\\b");
                        break;
                    case '\t':
                        BUILDER.append("\\t");
                        break;
                    case '\n':
                        BUILDER.append("\\n");
                        break;
                    case '\f':
                        BUILDER.append("\\f");
                        break;
                    case '\r':
                        BUILDER.append("\\r");
                        break;
                    case Place.TYPE_ESTABLISHMENT /*34*/:
                        BUILDER.append("\\\"");
                        break;
                    case Place.TYPE_TRAIN_STATION /*92*/:
                        BUILDER.append("\\\\");
                        break;
                    default:
                        if ((ch >= '\u0000' && ch <= '\u001f') || ((ch >= '' && ch <= '') || (ch >= ' ' && ch <= '⃿'))) {
                            String intString = Integer.toHexString(ch);
                            BUILDER.append("\\u");
                            int intLength = 4 - intString.length();
                            for (int zero = 0; zero < intLength; zero++) {
                                BUILDER.append('0');
                            }
                            BUILDER.append(intString.toUpperCase(Locale.US));
                            break;
                        }
                        BUILDER.append(ch);
                        break;
                }
            }
            BUILDER.append('\"');
            try {
                byte[] bytes = BUILDER.toString().getBytes();
                return bytes;
            } finally {
                BUILDER.setLength(0);
            }
        }
    }
}
