package com.huihui.sdk;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.baidu.mapapi.map.MapView;

/**
 * Created by gavin on 2017/3/15.
 */

public class WMapView extends FrameLayout {


    public WMapView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public WMapView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public WMapView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);
    }

    private void initView(Context context) {

        addView(new MapView(context),
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        Button child = new Button(context);

        child.setText("这个是自定义按钮");

        addView(child, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200, Gravity.CENTER));
    }
}
