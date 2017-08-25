package org.nexage.sourcekit.mraid.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MRAIDHtmlProcessor {
    public static String processRawHtml(String rawHtml) {
        StringBuffer processedHtml = new StringBuffer(rawHtml);
        Matcher matcher = Pattern.compile("<script\\s+[^>]*\\bsrc\\s*=\\s*([\\\"\\'])mraid\\.js\\1[^>]*>\\s*</script>\\n*", 2).matcher(processedHtml);
        boolean hasHtmlTag = rawHtml.contains("<html");
        boolean hasHeadTag = rawHtml.contains("<head");
        boolean hasBodyTag = rawHtml.contains("<body");
        String ls = System.getProperty("line.separator");
        if (!hasHtmlTag) {
            if (!hasBodyTag) {
                processedHtml.insert(0, "<body><div align='center'>" + ls);
                processedHtml.append("</div></body>");
            }
            if (!hasHeadTag) {
                processedHtml.insert(0, "<head>" + ls + "</head>" + ls);
            }
            processedHtml.insert(0, "<html>" + ls);
            processedHtml.append(ls + "</html>");
        } else if (!hasHeadTag) {
            matcher = Pattern.compile("<html[^>]*>", 2).matcher(processedHtml);
            for (int idx = 0; matcher.find(idx); idx = matcher.end()) {
                processedHtml.insert(matcher.end(), ls + "<head>" + ls + "</head>");
            }
        }
        matcher = Pattern.compile("<head[^>]*>", 2).matcher(processedHtml);
        if (matcher.find(0)) {
            String styleTag = "<style>" + ls + "body { margin:0; padding:0;}" + ls + "*:not(input) { -webkit-touch-callout:none; -webkit-user-select:none; -webkit-text-size-adjust:none; }" + ls + "</style>";
            processedHtml.insert(matcher.end(), ls + "<meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no' />" + ls + styleTag);
        }
        return processedHtml.toString();
    }
}
