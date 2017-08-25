package org.cocos2dx.lib;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class Cocos2dxHandler extends Handler {
    public static final int HANDLER_SHOW_DIALOG = 1;
    public static final int HANDLER_SHOW_EDITBOX_DIALOG = 2;
    private WeakReference<Cocos2dxActivity> mActivity;

    class C19441 implements OnClickListener {
        C19441() {
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    public static class DialogMessage {
        public String message;
        public String titile;

        public DialogMessage(String title, String message) {
            this.titile = title;
            this.message = message;
        }
    }

    public static class EditBoxMessage {
        public String content;
        public int inputFlag;
        public int inputMode;
        public int maxLength;
        public int returnType;
        public String title;

        public EditBoxMessage(String title, String content, int inputMode, int inputFlag, int returnType, int maxLength) {
            this.content = content;
            this.title = title;
            this.inputMode = inputMode;
            this.inputFlag = inputFlag;
            this.returnType = returnType;
            this.maxLength = maxLength;
        }
    }

    public Cocos2dxHandler(Cocos2dxActivity activity) {
        this.mActivity = new WeakReference(activity);
    }

    public void handleMessage(Message msg) {
        switch (msg.what) {
            case 1:
                showDialog(msg);
                return;
            case 2:
                showEditBoxDialog(msg);
                return;
            default:
                return;
        }
    }

    private void showDialog(Message msg) {
        DialogMessage dialogMessage = msg.obj;
        new Builder((Cocos2dxActivity) this.mActivity.get()).setTitle(dialogMessage.titile).setMessage(dialogMessage.message).setPositiveButton("Ok", new C19441()).create().show();
    }

    private void showEditBoxDialog(Message msg) {
        EditBoxMessage editBoxMessage = msg.obj;
        new Cocos2dxEditBoxDialog((Context) this.mActivity.get(), editBoxMessage.title, editBoxMessage.content, editBoxMessage.inputMode, editBoxMessage.inputFlag, editBoxMessage.returnType, editBoxMessage.maxLength).show();
    }
}
