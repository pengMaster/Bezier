package com.example.bezier.bezier2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * <pre>
 *     author : Wp
 *     e-mail : 1101313414@qq.com
 *     time   : 2019/5/21 3:37 PM
 *     desc   : 二阶贝塞尔曲线
 *     version: 1.0
 * </pre>
 */
public class Bezier2 extends View {

    private Paint mPaint;                                   //点线共用画笔
    private PointF mPointStart, mPointControl, mPointEnd;   //起始点，控制点，终止点

    public Bezier2(Context context) {
        super(context);
        mPaint = new Paint();
        mPointStart = new PointF(0,0);
        mPointControl = new PointF(0,0);
        mPointEnd = new PointF(0,0);
    }

    public Bezier2(Context context,@Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPointStart = new PointF(0,0);
        mPointControl = new PointF(0,0);
        mPointEnd = new PointF(0,0);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //初始化
        int centerX = w / 2;
        int centerY = h / 2;
        mPointStart.x = centerX - 200;
        mPointStart.y = centerY;
        mPointEnd.x = centerX + 200;
        mPointEnd.y = centerY;
        mPointControl.x = centerX + 100;
        mPointControl.y = centerY + 100;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //更新控制点位
        mPointControl.x = event.getX();
        mPointControl.y = event.getY();
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制起始点，控制点，终止点
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(mPointStart.x,mPointStart.y,mPaint);
        canvas.drawPoint(mPointEnd.x,mPointEnd.y,mPaint);
        canvas.drawPoint(mPointControl.x,mPointControl.y,mPaint);
        //绘制辅助线
        mPaint.setStrokeWidth(4);
        canvas.drawLine(mPointStart.x,mPointStart.y,mPointControl.x,mPointControl.y,mPaint);
        canvas.drawLine(mPointEnd.x,mPointEnd.y,mPointControl.x,mPointControl.y,mPaint);
        //绘制贝塞尔曲线
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(mPointStart.x,mPointStart.y);//起始点位
        path.quadTo(mPointControl.x,mPointControl.y,mPointEnd.x,mPointEnd.y);
        canvas.drawPath(path,mPaint);
    }
}
