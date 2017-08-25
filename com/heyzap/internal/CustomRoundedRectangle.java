package com.heyzap.internal;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;

public class CustomRoundedRectangle extends ShapeDrawable {
    private final Paint fillpaint = new Paint(getPaint());
    private final int strokeWidth;
    private final Paint strokepaint;

    public CustomRoundedRectangle(Shape s, int fill, int stroke, int strokeWidth, int alpha) {
        super(s);
        this.strokeWidth = strokeWidth;
        this.fillpaint.setColor(fill);
        this.fillpaint.setAlpha(alpha);
        this.strokepaint = new Paint(this.fillpaint);
        this.strokepaint.setStyle(Style.STROKE);
        this.strokepaint.setStrokeWidth((float) strokeWidth);
        this.strokepaint.setColor(stroke);
    }

    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        shape.resize((float) canvas.getClipBounds().right, (float) canvas.getClipBounds().bottom);
        shape.draw(canvas, this.fillpaint);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, (float) canvas.getClipBounds().right, (float) canvas.getClipBounds().bottom), new RectF((float) (this.strokeWidth / 2), (float) (this.strokeWidth / 2), (float) (canvas.getClipBounds().right - (this.strokeWidth / 2)), (float) (canvas.getClipBounds().bottom - (this.strokeWidth / 2))), ScaleToFit.FILL);
        canvas.concat(matrix);
        shape.draw(canvas, this.strokepaint);
    }
}
