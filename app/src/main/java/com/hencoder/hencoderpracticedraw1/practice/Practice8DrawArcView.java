package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {
    int width;
    int height;

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF rectF;

    public Practice8DrawArcView(Context context) {
        this(context, null);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        width = getWidth();
        height = getHeight();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.save();

        canvas.translate(width / 2, height / 2);

        rectF = new RectF(-300, -150, 300, 150);
        //绘制弧形，跟扇形有点不一样，扇形有角度，这个没有角度
        canvas.drawArc(rectF, 20, 140, false, paint);

        //绘制弧线
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, 180, 60, false, paint);

        //绘制扇形
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, -110, 100, true, paint);

        canvas.restore();
    }
}
