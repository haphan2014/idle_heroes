package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.plus.internal.zzg;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private int mSize;
    private String zzF;
    private View zzaHd;
    private int zzaHe;
    private int zzaHf;
    private OnPlusOneClickListener zzaHg;

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    protected class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener zzaHh;
        final /* synthetic */ PlusOneButton zzaHi;

        public DefaultOnPlusOneClickListener(PlusOneButton plusOneButton, OnPlusOneClickListener proxy) {
            this.zzaHi = plusOneButton;
            this.zzaHh = proxy;
        }

        public void onClick(View view) {
            Intent intent = (Intent) this.zzaHi.zzaHd.getTag();
            if (this.zzaHh != null) {
                this.zzaHh.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = this.zzaHi.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, this.zzaHi.zzaHf);
            }
        }
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = getSize(context, attrs);
        this.zzaHe = getAnnotation(context, attrs);
        this.zzaHf = -1;
        zzaf(getContext());
        if (!isInEditMode()) {
        }
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String zza = zzab.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        return "INLINE".equalsIgnoreCase(zza) ? 2 : !"NONE".equalsIgnoreCase(zza) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String zza = zzab.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        return "SMALL".equalsIgnoreCase(zza) ? 0 : "MEDIUM".equalsIgnoreCase(zza) ? 1 : "TALL".equalsIgnoreCase(zza) ? 2 : 3;
    }

    private void zzaf(Context context) {
        if (this.zzaHd != null) {
            removeView(this.zzaHd);
        }
        this.zzaHd = zzg.zza(context, this.mSize, this.zzaHe, this.zzF, this.zzaHf);
        setOnPlusOneClickListener(this.zzaHg);
        addView(this.zzaHd);
    }

    public void initialize(String url, int activityRequestCode) {
        zzu.zza(getContext() instanceof Activity, (Object) "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.zzF = url;
        this.zzaHf = activityRequestCode;
        zzaf(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.zzF = url;
        this.zzaHf = 0;
        zzaf(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.zzaHd.layout(0, 0, right - left, bottom - top);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.zzaHd;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void plusOneClick() {
        this.zzaHd.performClick();
    }

    public void setAnnotation(int annotation) {
        this.zzaHe = annotation;
        zzaf(getContext());
    }

    public void setIntent(Intent intent) {
        this.zzaHd.setTag(intent);
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.zzaHg = listener;
        this.zzaHd.setOnClickListener(new DefaultOnPlusOneClickListener(this, listener));
    }

    public void setSize(int size) {
        this.mSize = size;
        zzaf(getContext());
    }
}
