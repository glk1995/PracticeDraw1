package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    String[] names = new String[]{"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};

    public Practice10HistogramView(Context context) {
        this(context, null);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.WHITE);
        Path path = new Path();
        canvas.save();
        canvas.translate(100, 100);
        canvas.save();
        path.rLineTo(0, 600);
        canvas.restore();
        path.rLineTo(800, 0);
        canvas.drawPath(path, paint);
//        canvas.drawLine(100, 100, 100, 700, paint);
//        canvas.drawLine(100, 700, 900, 700, paint);
        canvas.restoreToCount(1);

        final int padding = 20;
        final int rectWidth = 75;

        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(28);
        for(int i = 0; i < 7; i++) {
            int startX =  200 + padding * i + rectWidth * (i - 1);
            int startY = 700;
            paint.setColor(Color.parseColor("#72b916"));
            int stopX = startX + rectWidth;
            canvas.drawRect(startX, startY, stopX, (float) (startY - (500) * Math.random()), paint);
            paint.setColor(Color.WHITE);
            Rect rectF = new Rect();
            paint.getTextBounds(names[i], 0, names[i].length(), rectF);
            int middlePoint = (startX + stopX) / 2;
            canvas.drawText(names[i], middlePoint - rectF.width() / 2 , startY + paint.getTextSize(), paint);
        }
    }
}
