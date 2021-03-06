package com.wiwj.mapsdk.widget.mark;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.wiwj.mapsdk.utils.Colors;
import com.wiwj.mapsdk.utils.ScreenUtils;


/**
 * Created by gavin
 * Time 2017/3/1615:32
 * 当前定位点
 */

public class AnchorPointView extends View {

    private Paint mPaint;

    private String mDefaultText = "A";
    private int mDefaultTextSize = 16;
    private int mDdfaultTextColor = Colors.WHITE;
    private int mDdfaultBgColor = Colors.RED;

    private  int dd= Color.parseColor("#FFFFFF");

    private int mWidth;

    private int mHeight;
    private Rect mBound;

    private String TAG = getClass().getSimpleName();

    private static int ANGLE = 55;

    private Context context;


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
        Log.e(TAG,"颜色值："+dd);

        mPaint = new Paint();
        mPath = new Path();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        this.context = context.getApplicationContext();

        mPaint.setTextSize(ScreenUtils.dpToPx(context, mDefaultTextSize));
        mBound = new Rect();
        mPaint.getTextBounds(mDefaultText, 0, mDefaultText.length(), mBound);


    }

    private Path mPath;

    @Override
    protected void onDraw(Canvas canvas) {
        //  mPaint.setColor(Color.YELLOW);
        //canvas.drawRect(0, 0, mWidth, mHeight, mPaint);
        mPaint.setColor(mDdfaultBgColor);
        mPath.moveTo(0, mWidth / 2);
        mPath.addArc(new RectF(0, 0, mWidth, mWidth), 90 + ANGLE, (180 - ANGLE) * 2);
        mPath.lineTo(mWidth / 2, mHeight);
        mPath.close();
        canvas.drawPath(mPath, mPaint);

        mPaint.setTextSize(ScreenUtils.dpToPx(context, mDefaultTextSize));
        mPaint.setColor(mDdfaultTextColor);
        canvas.drawText(mDefaultText, mWidth / 2 - mBound.width() / 2, mWidth / 2 + mBound.height() / 2, mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mHeight = h;
        mWidth = w;

        Log.e(TAG, "onSizeChanged:" + mHeight + "  " + mWidth);
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

            width = Math.min(widthSize, heightSize);
            height = (int) ((width / 2) * (1 + 1 / Math.cos(ANGLE * Math.PI / 180)));

           /* width = widthSize;
            height = heightSize;*/
        } else {
            width = 100;
            height = (int) ((width / 2) * (1 + 1 / Math.cos(ANGLE * Math.PI / 180)));

            Log.e("TAG", Math.cos(ANGLE * Math.PI / 180) + "     " + height);
        }
        setMeasuredDimension(width, height);


    }


    public void setMarkerText(String content) {

        mBound = new Rect();
        mDefaultText = content;
        mPaint.getTextBounds(mDefaultText, 0, mDefaultText.length(), mBound);

        refresh();
    }

    public void setMarkerTextColor(int color) {

        mDdfaultTextColor = color;

    }


    public void setMarkerTextSize(int dp) {

        mDefaultTextSize = dp;

        refresh();
    }


    public void setMarkerIcon(int resId) {

    }


    public void setMarkerColor(int color) {

        mDdfaultBgColor = color;

        refresh();
    }

    /**
     * 刷新draw 方法
     */
    private void refresh() {
        invalidate();
    }
}
