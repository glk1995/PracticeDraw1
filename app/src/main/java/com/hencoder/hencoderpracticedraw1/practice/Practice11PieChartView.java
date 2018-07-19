package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {
    private Paint paintPie = new Paint(Paint.ANTI_ALIAS_FLAG);

    private Paint paintLine = new Paint(Paint.ANTI_ALIAS_FLAG);

    private Paint paintText = new Paint(Paint.ANTI_ALIAS_FLAG);

    private String[] s = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};

    private Integer[] percent = {2, 8, 10, 50, 80, 160, 50};

    private Integer[] color = {Color.BLACK, Color.BLUE, Color.GRAY, Color.GREEN, Color.RED, Color.LTGRAY, Color.YELLOW};


    private RectF rectFCommon;
    private RectF rectFMove;

    public Practice11PieChartView(Context context) {
        this(context, null);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        rectFCommon = new RectF(-300, -300, 300, 300);
        rectFMove = new RectF(-320, - 320, 280, 280);
        paintLine.setColor(Color.WHITE);
        paintLine.setStrokeWidth(2);
        paintText.setTextSize(24);
        paintText.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        //移到画布中心
        canvas.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);

        float startAngle = 0;
        float sweepAngle = 0;

        for(int i = 0; i < 7; i++) {
            //画饼图
            paintPie.setColor(color[i]);

            sweepAngle = percent[i];

            if(i == 5) {
                canvas.drawArc(rectFMove, startAngle + 1, sweepAngle - 1, true, paintPie);
            } else {
                canvas.drawArc(rectFCommon, startAngle + 1, sweepAngle - 1, true, paintPie);
            }

            float textAngel = startAngle + sweepAngle / 2;
            //画斜线
            float pointY1 = (float) Math.sin(textAngel / 180 * Math.PI) * 300;
            float pointX1 = (float) Math.cos(textAngel / 180 * Math.PI) * 300;

            float pointY2 = (float) Math.sin(textAngel / 180 * Math.PI) * 350;
            float pointX2 = (float) Math.cos(textAngel / 180 * Math.PI) * 350;

            if(i == 5) {
                canvas.save();
                canvas.translate(-20, -20);
                canvas.drawLine(pointX1, pointY1, pointX2, pointY2, paintLine);

                canvas.restore();
            } else {
                canvas.drawLine(pointX1, pointY1, pointX2, pointY2, paintLine);
            }


            Rect rectF = new Rect();
            paintText.getTextBounds(s[i], 0, s[i].length(), rectF);

            int lineStop;
            int textStop;
            if(pointX2 > 0) {
                lineStop = 350;
                textStop = lineStop;
            } else {
                lineStop = -350;
                textStop = lineStop - rectF.width();
            }

            //画直线
            if(i == 5) {
                canvas.save();
                canvas.translate(-20, -20);

                canvas.drawLine(pointX2, pointY2, lineStop, pointY2, paintLine);

                canvas.restore();
            } else {
                canvas.drawLine(pointX2, pointY2, lineStop, pointY2, paintLine);
            }

            //字
            canvas.drawText(s[i], textStop, pointY2 , paintText);


            startAngle += sweepAngle;
        }
    }
}
