package org.cocos2dx.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v4.view.MotionEventCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.FloatMath;
import android.util.Log;
import com.google.android.gms.cast.TextTrackStyle;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

public class Cocos2dxBitmap {
    private static final int HORIZONTALALIGN_CENTER = 3;
    private static final int HORIZONTALALIGN_LEFT = 1;
    private static final int HORIZONTALALIGN_RIGHT = 2;
    private static final int VERTICALALIGN_BOTTOM = 2;
    private static final int VERTICALALIGN_CENTER = 3;
    private static final int VERTICALALIGN_TOP = 1;
    private static Context sContext;

    private static class TextProperty {
        private final int mHeightPerLine;
        private final String[] mLines;
        private final int mMaxWidth;
        private final int mTotalHeight;

        TextProperty(int pMaxWidth, int pHeightPerLine, String[] pLines) {
            this.mMaxWidth = pMaxWidth;
            this.mHeightPerLine = pHeightPerLine;
            this.mTotalHeight = pLines.length * pHeightPerLine;
            this.mLines = pLines;
        }
    }

    private static native void nativeInitBitmapDC(int i, int i2, byte[] bArr);

    public static void setContext(Context pContext) {
        sContext = pContext;
    }

    public static void createTextBitmap(String pString, String pFontName, int pFontSize, int pAlignment, int pWidth, int pHeight) {
        createTextBitmapShadowStroke(pString, pFontName, pFontSize, TextTrackStyle.DEFAULT_FONT_SCALE, TextTrackStyle.DEFAULT_FONT_SCALE, TextTrackStyle.DEFAULT_FONT_SCALE, pAlignment, pWidth, pHeight, false, 0.0f, 0.0f, 0.0f, false, TextTrackStyle.DEFAULT_FONT_SCALE, TextTrackStyle.DEFAULT_FONT_SCALE, TextTrackStyle.DEFAULT_FONT_SCALE, TextTrackStyle.DEFAULT_FONT_SCALE);
    }

    public static void createTextBitmapShadowStroke(String pString, String pFontName, int pFontSize, float fontTintR, float fontTintG, float fontTintB, int pAlignment, int pWidth, int pHeight, boolean shadow, float shadowDX, float shadowDY, float shadowBlur, boolean stroke, float strokeR, float strokeG, float strokeB, float strokeSize) {
        int bitmapTotalHeight;
        int horizontalAlignment = pAlignment & 15;
        int verticalAlignment = (pAlignment >> 4) & 15;
        pString = refactorString(pString);
        Paint paint = newPaint(pFontName, pFontSize, horizontalAlignment);
        paint.setARGB(MotionEventCompat.ACTION_MASK, (int) (255.0d * ((double) fontTintR)), (int) (255.0d * ((double) fontTintG)), (int) (255.0d * ((double) fontTintB)));
        TextProperty textProperty = computeTextProperty(pString, pWidth, pHeight, paint);
        if (pHeight == 0) {
            bitmapTotalHeight = textProperty.mTotalHeight;
        } else {
            bitmapTotalHeight = pHeight;
        }
        float bitmapPaddingX = 0.0f;
        float bitmapPaddingY = 0.0f;
        float renderTextDeltaX = 0.0f;
        float renderTextDeltaY = 0.0f;
        if (shadow) {
            paint.setShadowLayer(shadowBlur, shadowDX, shadowDY, -8553091);
            bitmapPaddingX = Math.abs(shadowDX);
            bitmapPaddingY = Math.abs(shadowDY);
            if (((double) shadowDX) < 0.0d) {
                renderTextDeltaX = bitmapPaddingX;
            }
            if (((double) shadowDY) < 0.0d) {
                renderTextDeltaY = bitmapPaddingY;
            }
        }
        if (textProperty.mMaxWidth + ((int) bitmapPaddingX) <= 0 || ((int) bitmapPaddingY) + bitmapTotalHeight <= 0) {
            nativeInitBitmapDC(0, 0, new byte[0]);
            return;
        }
        Bitmap bitmap = Bitmap.createBitmap(textProperty.mMaxWidth + ((int) bitmapPaddingX), ((int) bitmapPaddingY) + bitmapTotalHeight, Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int y = computeY(fontMetricsInt, pHeight, textProperty.mTotalHeight, verticalAlignment);
        for (String line : textProperty.mLines) {
            canvas.drawText(line, ((float) computeX(line, textProperty.mMaxWidth, horizontalAlignment)) + renderTextDeltaX, ((float) y) + renderTextDeltaY, paint);
            y += textProperty.mHeightPerLine;
        }
        if (stroke) {
            Paint paintStroke = newPaint(pFontName, pFontSize, horizontalAlignment);
            paintStroke.setStyle(Style.STROKE);
            paintStroke.setStrokeWidth(0.5f * strokeSize);
            paintStroke.setARGB(MotionEventCompat.ACTION_MASK, ((int) strokeR) * MotionEventCompat.ACTION_MASK, ((int) strokeG) * MotionEventCompat.ACTION_MASK, ((int) strokeB) * MotionEventCompat.ACTION_MASK);
            y = computeY(fontMetricsInt, pHeight, textProperty.mTotalHeight, verticalAlignment);
            for (String line2 : textProperty.mLines) {
                canvas.drawText(line2, ((float) computeX(line2, textProperty.mMaxWidth, horizontalAlignment)) + renderTextDeltaX, ((float) y) + renderTextDeltaY, paintStroke);
                y += textProperty.mHeightPerLine;
            }
        }
        initNativeObject(bitmap);
    }

    private static Paint newPaint(String pFontName, int pFontSize, int pHorizontalAlignment) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setTextSize((float) pFontSize);
        paint.setAntiAlias(true);
        if (pFontName.endsWith(".ttf")) {
            try {
                paint.setTypeface(Cocos2dxTypefaces.get(sContext, pFontName));
            } catch (Exception e) {
                Log.e("Cocos2dxBitmap", "error to create ttf type face: " + pFontName);
                paint.setTypeface(Typeface.create(pFontName, 0));
            }
        } else {
            paint.setTypeface(Typeface.create(pFontName, 0));
        }
        switch (pHorizontalAlignment) {
            case 2:
                paint.setTextAlign(Align.RIGHT);
                break;
            case 3:
                paint.setTextAlign(Align.CENTER);
                break;
            default:
                paint.setTextAlign(Align.LEFT);
                break;
        }
        return paint;
    }

    private static TextProperty computeTextProperty(String pString, int pWidth, int pHeight, Paint pPaint) {
        FontMetricsInt fm = pPaint.getFontMetricsInt();
        int h = (int) Math.ceil((double) (fm.bottom - fm.top));
        int maxContentWidth = 0;
        String[] lines = splitString(pString, pWidth, pHeight, pPaint);
        if (pWidth != 0) {
            maxContentWidth = pWidth;
        } else {
            for (String line : lines) {
                int temp = (int) FloatMath.ceil(pPaint.measureText(line, 0, line.length()));
                if (temp > maxContentWidth) {
                    maxContentWidth = temp;
                }
            }
        }
        return new TextProperty(maxContentWidth, h, lines);
    }

    private static int computeX(String pText, int pMaxWidth, int pHorizontalAlignment) {
        switch (pHorizontalAlignment) {
            case 2:
                return pMaxWidth;
            case 3:
                return pMaxWidth / 2;
            default:
                return 0;
        }
    }

    private static int computeY(FontMetricsInt pFontMetricsInt, int pConstrainHeight, int pTotalHeight, int pVerticalAlignment) {
        int y = -pFontMetricsInt.top;
        if (pConstrainHeight <= pTotalHeight) {
            return y;
        }
        switch (pVerticalAlignment) {
            case 1:
                return -pFontMetricsInt.top;
            case 2:
                return (-pFontMetricsInt.top) + (pConstrainHeight - pTotalHeight);
            case 3:
                return (-pFontMetricsInt.top) + ((pConstrainHeight - pTotalHeight) / 2);
            default:
                return y;
        }
    }

    private static String[] splitString(String pString, int pMaxWidth, int pMaxHeight, Paint pPaint) {
        String[] lines = pString.split("\\n");
        FontMetricsInt fm = pPaint.getFontMetricsInt();
        int maxLines = pMaxHeight / ((int) Math.ceil((double) (fm.bottom - fm.top)));
        LinkedList<String> strList;
        String[] ret;
        if (pMaxWidth != 0) {
            strList = new LinkedList();
            for (String line : lines) {
                if (((int) FloatMath.ceil(pPaint.measureText(line))) > pMaxWidth) {
                    strList.addAll(divideStringWithMaxWidth(line, pMaxWidth, pPaint));
                } else {
                    strList.add(line);
                }
                if (maxLines > 0 && strList.size() >= maxLines) {
                    break;
                }
            }
            if (maxLines > 0 && strList.size() > maxLines) {
                while (strList.size() > maxLines) {
                    strList.removeLast();
                }
            }
            ret = new String[strList.size()];
            strList.toArray(ret);
            return ret;
        } else if (pMaxHeight == 0 || lines.length <= maxLines) {
            return lines;
        } else {
            strList = new LinkedList();
            for (int i = 0; i < maxLines; i++) {
                strList.add(lines[i]);
            }
            ret = new String[strList.size()];
            strList.toArray(ret);
            return ret;
        }
    }

    private static LinkedList<String> divideStringWithMaxWidth(String pString, int pMaxWidth, Paint pPaint) {
        int charLength = pString.length();
        int start = 0;
        LinkedList<String> strList = new LinkedList();
        int i = 1;
        while (i <= charLength) {
            int tempWidth = (int) FloatMath.ceil(pPaint.measureText(pString, start, i));
            if (tempWidth >= pMaxWidth) {
                int lastIndexOfSpace = pString.substring(0, i).lastIndexOf(" ");
                if (lastIndexOfSpace != -1 && lastIndexOfSpace > start) {
                    strList.add(pString.substring(start, lastIndexOfSpace));
                    i = lastIndexOfSpace + 1;
                } else if (tempWidth > pMaxWidth) {
                    strList.add(pString.substring(start, i - 1));
                    i--;
                } else {
                    strList.add(pString.substring(start, i));
                }
                while (i < charLength && pString.charAt(i) == ' ') {
                    i++;
                }
                start = i;
            }
            i++;
        }
        if (start < charLength) {
            strList.add(pString.substring(start));
        }
        return strList;
    }

    private static String refactorString(String pString) {
        if (pString.compareTo("") == 0) {
            return " ";
        }
        StringBuilder strBuilder = new StringBuilder(pString);
        int start = 0;
        int index = strBuilder.indexOf("\n");
        while (index != -1) {
            if (index == 0 || strBuilder.charAt(index - 1) == '\n') {
                strBuilder.insert(start, " ");
                start = index + 2;
            } else {
                start = index + 1;
            }
            if (start > strBuilder.length() || index == strBuilder.length()) {
                break;
            }
            index = strBuilder.indexOf("\n", start);
        }
        return strBuilder.toString();
    }

    private static void initNativeObject(Bitmap pBitmap) {
        byte[] pixels = getPixels(pBitmap);
        if (pixels != null) {
            nativeInitBitmapDC(pBitmap.getWidth(), pBitmap.getHeight(), pixels);
        }
    }

    private static byte[] getPixels(Bitmap pBitmap) {
        if (pBitmap == null) {
            return null;
        }
        byte[] pixels = new byte[((pBitmap.getWidth() * pBitmap.getHeight()) * 4)];
        ByteBuffer buf = ByteBuffer.wrap(pixels);
        buf.order(ByteOrder.nativeOrder());
        pBitmap.copyPixelsToBuffer(buf);
        return pixels;
    }

    private static int getFontSizeAccordingHeight(int height) {
        Paint paint = new Paint();
        Rect bounds = new Rect();
        paint.setTypeface(Typeface.DEFAULT);
        int incr_text_size = 1;
        boolean found_desired_size = false;
        while (!found_desired_size) {
            paint.setTextSize((float) incr_text_size);
            String text = "SghMNy";
            paint.getTextBounds(text, 0, text.length(), bounds);
            incr_text_size++;
            if (height - bounds.height() <= 2) {
                found_desired_size = true;
            }
            Log.d("font size", "incr size:" + incr_text_size);
        }
        return incr_text_size;
    }

    private static String getStringWithEllipsis(String pString, float width, float fontSize) {
        if (TextUtils.isEmpty(pString)) {
            return "";
        }
        TextPaint paint = new TextPaint();
        paint.setTypeface(Typeface.DEFAULT);
        paint.setTextSize(fontSize);
        return TextUtils.ellipsize(pString, paint, width, TruncateAt.END).toString();
    }
}
