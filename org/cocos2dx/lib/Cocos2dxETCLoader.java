package org.cocos2dx.lib;

import android.content.Context;
import android.opengl.ETC1Util;
import android.opengl.ETC1Util.ETC1Texture;
import android.util.Log;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Cocos2dxETCLoader {
    private static final String ASSETS_PATH = "assets/";
    private static Context context;

    private static native void nativeSetTextureInfo(int i, int i2, byte[] bArr, int i3);

    public static boolean loadTexture(String filePath) {
        if (!ETC1Util.isETC1Supported() || filePath.length() == 0) {
            return false;
        }
        ETC1Texture texture;
        try {
            InputStream inputStream;
            if (filePath.charAt(0) == '/') {
                inputStream = new FileInputStream(filePath);
            } else {
                if (filePath.startsWith(ASSETS_PATH)) {
                    filePath = filePath.substring(ASSETS_PATH.length());
                }
                inputStream = context.getAssets().open(filePath);
            }
            texture = ETC1Util.createTexture(inputStream);
            inputStream.close();
        } catch (Exception e) {
            Log.d("Cocos2dx", "Unable to create texture for " + filePath);
            texture = null;
        }
        if (texture == null) {
            return false;
        }
        try {
            int width = texture.getWidth();
            int height = texture.getHeight();
            int length = texture.getData().remaining();
            byte[] data = new byte[length];
            ByteBuffer buf = ByteBuffer.wrap(data);
            buf.order(ByteOrder.nativeOrder());
            buf.put(texture.getData());
            nativeSetTextureInfo(width, height, data, length);
            return true;
        } catch (Exception e2) {
            Log.d("invoke native function error", e2.toString());
            return false;
        }
    }

    public static void setContext(Context context) {
        context = context;
    }
}
