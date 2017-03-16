package com.huihui.sdk.widget;

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

import com.huihui.sdk.utils.ScreenUtils;

/**
 * Created by gavin
 * Time 2017/3/1615:32
 */

public class AnchorPointView extends View {

    private Paint mPaint;

    private String mDefaultText = "A";
    private int mDefaultTextSize = 16;
    private int mDdfaultTextColor = Color.parseColor("#000000");
    private int mDdfaultBgColor = Color.parseColor("#FF00FF");

    private int mWidth;

    private int mHeight;
    private Rect mBound;


    public AnchorPointView(Context context) {
        super(context);

        init(context);
    }

    public AnchorPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public AnchorPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {

        mPaint = new Paint();

        mPath=new Path();

        mPaint.setAntiAlias(true);

        mPaint.setStyle(Paint.Style.FILL);

        mPaint.setTextSize(ScreenUtils.dpToPx(context, mDefaultTextSize));
        mBound = new Rect();
        mPaint.getTextBounds(mDefaultText, 0, mDefaultText.length(), mBound);


    }

    private Path mPath;

    @Override
    protected void onDraw(Canvas canvas) {

      //  mPaint.setColor(Color.YELLOW);
        //canvas.drawRect(0, 0, mWidth, mHeight, mPaint);





        mPaint.setColor(Color.RED);
        mPath.moveTo(0,mWidth/2);
        mPath.addArc(new RectF(0,0,mWidth,mWidth),150f,240f);

        mPath.lineTo(mWidth/2,mHeight);

        mPath.close();

        canvas.drawPath(mPath,mPaint);


        mPaint.setColor(Color.WHITE);



        canvas.drawText(mDefaultText, mWidth / 2 - mBound.width() / 2, mWidth / 2 + mBound.height() / 2, mPaint);



    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mHeight = h;
        mWidth = w;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;

        int height = 0;

        if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {

            width = widthSize;
            height = heightSize;
        } else {

            width = 100;

            height = 150;
        }


        setMeasuredDimension(width, height);


    }
}
