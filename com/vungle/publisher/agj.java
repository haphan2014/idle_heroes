package com.vungle.publisher;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.qx.C1869a;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class agj {
    @Inject
    qx f1406a;
    @Inject
    C1778a f1407b;

    /* compiled from: vungle */
    public static class C17051 implements OnTouchListener {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public final void m1229a(ImageView imageView, C1869a c1869a) {
        Bitmap a = m1228a(c1869a);
        if (a != null) {
            imageView.setImageBitmap(a);
        }
    }

    public final Bitmap m1228a(C1869a c1869a) {
        qx qxVar = this.f1406a;
        byte[] decode = Base64.decode(c1869a.f3035g, 0);
        int length = decode.length;
        Context context = qxVar.f3036a;
        Options options = new Options();
        options.inDensity = 330;
        options.inTargetDensity = (int) (context.getResources().getDisplayMetrics().density * ((float) options.inDensity));
        return BitmapFactory.decodeByteArray(decode, 0, length, options);
    }
}
