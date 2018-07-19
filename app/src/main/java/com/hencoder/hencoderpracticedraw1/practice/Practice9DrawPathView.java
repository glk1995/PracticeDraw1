package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);

        Path path = new Path();

        RectF f = new RectF(-100, -100 , 100 ,100);
        path.arcTo(f, -225, 225);
        path.lineTo(100, 324);

        f.set(100, -100, 300, 100);
        path.arcTo(f, 180, 225, true);

        path.lineTo(100, 324);

        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
