package org.cocos2dx.lib;

import android.content.Intent;
import android.net.Uri;

public class Cocos2dxExtra {
    public static void openURL(String url) {
        Cocos2dxActivity.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.com")));
    }
}
