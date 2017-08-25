package com.applovin.impl.adview;

import android.content.Context;
import android.widget.VideoView;

public class AppLovinVideoView extends VideoView {
    private int f112a = 0;
    private int f113b = 0;
    private float f114c = 0.0f;

    public AppLovinVideoView(Context context) {
        super(context, null, 0);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f112a <= 0 || this.f113b <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int defaultSize = getDefaultSize(this.f112a, i);
        int defaultSize2 = getDefaultSize(this.f113b, i2);
        int i3 = (int) (((float) defaultSize) / this.f114c);
        if (defaultSize2 <= i3) {
            i3 = defaultSize2;
        }
        defaultSize2 = (int) (((float) i3) * this.f114c);
        if (defaultSize <= defaultSize2) {
            defaultSize2 = defaultSize;
        }
        setMeasuredDimension(defaultSize2, i3);
    }

    public void setVideoSize(int i, int i2) {
        this.f112a = i;
        this.f113b = i2;
        this.f114c = ((float) this.f112a) / ((float) this.f113b);
        try {
            getHolder().setFixedSize(i, i2);
            requestLayout();
            invalidate();
        } catch (Exception e) {
        }
    }
}
