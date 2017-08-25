package com.heyzap.internal;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.Shape;
import com.google.android.gms.cast.TextTrackStyle;

public class AnnulurSegment extends Shape {
    private final Paint border = new Paint();
    private final Path path = new Path();
    private final float percent;
    private final float width;

    public AnnulurSegment(int color, float width, float percent) {
        this.percent = percent;
        this.width = width;
        this.border.setColor(color);
        this.border.setAntiAlias(true);
        this.border.setStrokeWidth(width);
        this.border.setStyle(Style.STROKE);
    }

    public void draw(Canvas canvas, Paint paint) {
        canvas.drawPath(this.path, this.border);
    }

    public void onResize(float width, float height) {
        super.onResize(width, height);
        RectF arc = new RectF((this.width / 2.0f) + 0.0f, (this.width / 2.0f) + 0.0f, width - (this.width / 2.0f), height - (this.width / 2.0f));
        this.path.reset();
        this.path.addArc(arc, -90.0f, -(360.0f * (TextTrackStyle.DEFAULT_FONT_SCALE - this.percent)));
    }
}
