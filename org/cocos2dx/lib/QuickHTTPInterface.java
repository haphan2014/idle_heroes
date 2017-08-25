package org.cocos2dx.lib;

import android.util.Log;
import com.heyzap.http.AsyncHttpClient;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QuickHTTPInterface {
    static String BOUNDARY = "----------------------------78631b43218d";
    static String NEWLINE = "\r\n";

    static HttpURLConnection createURLConnect(String strURL) {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(strURL).openConnection();
            urlConnection.setRequestProperty(AsyncHttpClient.HEADER_ACCEPT_ENCODING, "identity");
            urlConnection.setDoInput(true);
            return urlConnection;
        } catch (Exception e) {
            Log.e("QuickHTTPInterface", e.toString());
            return null;
        }
    }

    static void setRequestMethod(HttpURLConnection http, String strMedthod) {
        try {
            if ("POST".equalsIgnoreCase(strMedthod)) {
                http.setDoOutput(true);
            }
            http.setRequestMethod(strMedthod);
        } catch (ProtocolException e) {
            Log.e("QuickHTTPInterface", e.toString());
        }
    }

    static void addRequestHeader(HttpURLConnection http, String strkey, String strValue, boolean bNeedBoundary) {
        if ("Content-Type".equalsIgnoreCase(strkey.trim()) && bNeedBoundary) {
            strValue = strValue + "; boundary=" + BOUNDARY;
        }
        http.setRequestProperty(strkey, strValue);
    }

    static void setTimeout(HttpURLConnection http, int msTime) {
        http.setConnectTimeout(msTime);
        http.setReadTimeout(msTime);
    }

    static int connect(HttpURLConnection http) {
        try {
            http.connect();
            return 0;
        } catch (IOException e) {
            Log.e("QuickHTTPInterface", e.toString());
            return 1;
        }
    }

    static void postContent(HttpURLConnection http, String name, String value, boolean bNeedConnectSym) {
        try {
            String content;
            DataOutputStream out = new DataOutputStream(http.getOutputStream());
            if (name == null || name.length() == 0) {
                content = value;
            } else {
                content = name + "=" + value;
            }
            if (bNeedConnectSym) {
                content = "&" + content;
            }
            out.write(content.getBytes());
            out.flush();
        } catch (IOException e) {
            Log.e("QuickHTTPInterface", e.toString());
        }
    }

    static void postContentByteArray(HttpURLConnection http, byte[] byteArray) {
        try {
            OutputStream out = http.getOutputStream();
            out.write(byteArray);
            out.flush();
        } catch (IOException e) {
            Log.e("QuickHTTPInterface", e.toString());
        }
    }

    static void postFormContent(HttpURLConnection http, String key, String val) {
        try {
            OutputStream out = http.getOutputStream();
            out.write(getBoundaryContentHeader(key, val).getBytes());
            out.flush();
        } catch (IOException e) {
            Log.e("QuickHTTPInterface", e.toString());
        }
    }

    static void postFormFile(HttpURLConnection http, String name, String filePath) {
        try {
            FileInputStream fin = new FileInputStream(filePath);
            OutputStream out = http.getOutputStream();
            out.write(getBoundaryFileHeader(name, filePath).getBytes());
            byte[] buffer = new byte[1024];
            while (true) {
                int len = fin.read(buffer);
                if (len != -1) {
                    out.write(buffer, 0, len);
                } else {
                    out.write(NEWLINE.getBytes());
                    out.flush();
                    fin.close();
                    return;
                }
            }
        } catch (IOException e) {
            Log.e("QuickHTTPInterface", e.toString());
        }
    }

    static void postFormEnd(HttpURLConnection http, boolean bBoundary) {
        if (!"GET".equalsIgnoreCase(http.getRequestMethod())) {
            try {
                OutputStream out = http.getOutputStream();
                if (bBoundary) {
                    out.write(getBoundaryEnd().getBytes());
                    out.flush();
                }
                out.close();
            } catch (IOException e) {
                Log.e("QuickHTTPInterface", e.toString());
            }
        }
    }

    static String getBoundaryFileHeader(String key, String filePath) {
        File file = new File(filePath);
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(BOUNDARY);
        sb.append(NEWLINE);
        sb.append("Content-Disposition: form-data; ");
        sb.append("name=\"");
        sb.append(key);
        sb.append("\"; ");
        sb.append("filename=\"");
        sb.append(file.getName());
        sb.append("\"");
        sb.append(NEWLINE);
        sb.append("Content-Type: application/octet-stream");
        sb.append(NEWLINE);
        sb.append(NEWLINE);
        return sb.toString();
    }

    static String getBoundaryContentHeader(String key, String val) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(BOUNDARY);
        sb.append(NEWLINE);
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(key);
        sb.append("\"");
        sb.append(NEWLINE);
        sb.append(NEWLINE);
        sb.append(val);
        sb.append(NEWLINE);
        return sb.toString();
    }

    static String getBoundaryEnd() {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(BOUNDARY);
        sb.append("--");
        sb.append(NEWLINE);
        return sb.toString();
    }

    static int getResponedCode(HttpURLConnection http) {
        int code = 0;
        try {
            code = http.getResponseCode();
        } catch (IOException e) {
            Log.e("QuickHTTPInterface", e.toString());
        }
        return code;
    }

    static String getResponedErr(HttpURLConnection http) {
        try {
            return http.getResponseMessage();
        } catch (IOException e) {
            String msg = e.toString();
            Log.e("QuickHTTPInterface", msg);
            return msg;
        }
    }

    static String getResponedHeader(HttpURLConnection http) {
        Map<String, List<String>> headers = http.getHeaderFields();
        JSONObject json = new JSONObject();
        try {
            for (Entry<String, List<String>> entry : headers.entrySet()) {
                String key = (String) entry.getKey();
                if (key == null) {
                    key = "";
                }
                List<String> value = (List) entry.getValue();
                JSONArray jsonArray = new JSONArray();
                for (String strVal : value) {
                    jsonArray.put(strVal);
                }
                json.put(key, jsonArray);
            }
        } catch (JSONException e) {
            Log.e("QuickHTTPInterface", e.toString());
        }
        return json.toString();
    }

    static String getResponedHeaderByIdx(HttpURLConnection http, int idx) {
        Map<String, List<String>> headers = http.getHeaderFields();
        if (headers == null) {
            return null;
        }
        int counter = 0;
        for (Entry<String, List<String>> entry : headers.entrySet()) {
            if (counter == idx) {
                String key = (String) entry.getKey();
                if (key == null) {
                    return listToString((List) entry.getValue(), ",") + "\n";
                }
                return key + ":" + listToString((List) entry.getValue(), ",") + "\n";
            }
            counter++;
        }
        return null;
    }

    static String getResponedHeaderByKey(HttpURLConnection http, String key) {
        if (key == null) {
            return null;
        }
        Map<String, List<String>> headers = http.getHeaderFields();
        if (headers == null) {
            return null;
        }
        for (Entry<String, List<String>> entry : headers.entrySet()) {
            if (key.equalsIgnoreCase((String) entry.getKey())) {
                if ("set-cookie".equalsIgnoreCase(key)) {
                    return combinCookies((List) entry.getValue(), http.getURL().getHost());
                }
                return listToString((List) entry.getValue(), ",");
            }
        }
        return null;
    }

    static int getResponedHeaderByKeyInt(HttpURLConnection http, String key) {
        String value = http.getHeaderField(key);
        if (value == null) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    static int getContentLeng(HttpURLConnection http) {
        return http.getContentLength();
    }

    static byte[] getResponedString(HttpURLConnection http) {
        try {
            byte[] buffer = new byte[1024];
            int len = new DataInputStream(http.getInputStream()).read(buffer);
            if (-1 == len) {
                return new byte[]{(byte) 0};
            }
            byte[] retBuf = new byte[(len + 1)];
            retBuf[0] = (byte) 1;
            System.arraycopy(buffer, 0, retBuf, 1, len);
            return retBuf;
        } catch (IOException e) {
            Log.e("QuickHTTPInterface", e.toString());
            return null;
        }
    }

    static void close(HttpURLConnection http) {
        try {
            http.getInputStream().close();
        } catch (IOException e) {
            Log.e("QuickHTTPInterface", e.toString());
        }
    }

    public static String listToString(List<String> list, String strInterVal) {
        if (list == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String str : list) {
            String str2;
            if (flag) {
                result.append(strInterVal);
            }
            if (str2 == null) {
                str2 = "";
            }
            result.append(str2);
            flag = true;
        }
        return result.toString();
    }

    public static String combinCookies(List<String> list, String strDomain) {
        StringBuilder sbCookies = new StringBuilder();
        String strKey = null;
        String strValue = null;
        String strExpire = null;
        for (String str : list) {
            boolean bSecure = false;
            boolean bFirst = true;
            for (String part : str.split(";")) {
                String[] item = part.split("=");
                if (bFirst) {
                    if (2 == item.length) {
                        strKey = item[0];
                        strValue = item[1];
                    } else {
                        strKey = "";
                        strValue = "";
                    }
                    bFirst = false;
                }
                if ("expires".equalsIgnoreCase(item[0].trim())) {
                    strExpire = str2Seconds(item[1].trim());
                } else if ("secure".equalsIgnoreCase(item[0].trim())) {
                    bSecure = true;
                } else if ("domain".equalsIgnoreCase(item[0].trim())) {
                    strDomain = item[1];
                }
            }
            if (strDomain == null) {
                strDomain = "none";
            }
            sbCookies.append(strDomain);
            sbCookies.append('\t');
            sbCookies.append("FALSE\t");
            sbCookies.append("/\t");
            if (bSecure) {
                sbCookies.append("TRUE\t");
            } else {
                sbCookies.append("FALSE\t");
            }
            sbCookies.append(strExpire);
            sbCookies.append("\t");
            sbCookies.append(strKey);
            sbCookies.append("\t");
            sbCookies.append(strValue);
            sbCookies.append('\n');
        }
        return sbCookies.toString();
    }

    private static String str2Seconds(String strTime) {
        long millisSecond;
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(new SimpleDateFormat("EEE, dd-MMM-yyyy hh:mm:ss zzz", Locale.US).parse(strTime));
            millisSecond = c.getTimeInMillis() / 1000;
        } catch (ParseException e) {
            millisSecond = -1;
        }
        return -1 == millisSecond ? strTime : Long.toString(millisSecond);
    }
}
