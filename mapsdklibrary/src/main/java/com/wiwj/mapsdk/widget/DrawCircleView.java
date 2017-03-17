package com.wiwj.mapsdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavin
 * Time 2017/3/17  13:00
 * Email:molu_clown@163.com
 */

public class DrawCircleView  extends View{

    private int mov_x;//声明起点坐标
    private int mov_y;
    private Paint paint;//声明画笔
    private Canvas canvas;//画布
    private Bitmap bitmap;//位图
    private int blcolor;
    private Path path;

    private PointCallBack pointCallBack;

    private List<Point> points;
    private String TAG = "DrawLineView";

    public DrawCircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCanvas();

    }

    public DrawCircleView(Context context) {
        this(context, null);
    }


    private void initCanvas() {
        paint = new Paint(Paint.DITHER_FLAG);//创建一个画笔

        canvas = new Canvas();
        path = new Path();
        paint.setStyle(Paint.Style.STROKE);//设置非填充
        paint.setStrokeWidth(5);//笔宽5像素
        paint.setColor(Color.RED);//设置为红笔
        paint.setAntiAlias(true);//锯齿不显示
    }

    public void setOnPointCallListener(PointCallBack pointCallBack) {
        this.pointCallBack = pointCallBack;
        points = new ArrayList<>();

    }


    public void clear() {

        /*Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPaint(paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
*/
        initCanvas();
        invalidate();
        points.clear();
        Log.e(TAG, "clear");
    }

    //画位图
    @Override
    protected void onDraw(Canvas canvas) {
//  super.onDraw(canvas);
        // canvas.drawBitmap(bitmap, 0, 0, null);

        canvas.drawPath(path, paint);
    }

    float startX = 0;
    float startY = 0;

    //触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Point point = new Point((int) event.getX(), (int) event.getY());

        points.add(point);

        if (event.getAction() == MotionEvent.ACTION_MOVE) {//如果拖动
            //canvas.drawLine(mov_x, mov_y, event.getX(), event.getY(), paint);//画线

            path.quadTo(mov_x, mov_y, event.getX(), event.getY());
            invalidate();
        }
        if (event.getAction() == MotionEvent.ACTION_DOWN) {//如果点击
            mov_x = (int) event.getX();
            mov_y = (int) event.getY();
            startX = event.getX();
            startY = event.getY();
            //  canvas.drawPoint(mov_x, mov_y, paint);//画点
            path.moveTo(mov_x, mov_y);
            invalidate();

        }

        if (event.getAction() == MotionEvent.ACTION_UP) {//结束

            path.lineTo(startX, startY);
            invalidate();
            pointCallBack.callback(points);
            points.clear();


        }
        mov_x = (int) event.getX();
        mov_y = (int) event.getY();


        return true;
    }

     interface PointCallBack{

        void callback(List<Point> points);
    }
}
