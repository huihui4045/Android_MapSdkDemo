package com.wiwj.mapsdk.widget;

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
 * Created by gavin
 * Time 2017/3/17  16:09
 * Email:molu_clown@163.com
 */

public class TestMapView extends FrameLayout {

    private MapView mMapView;

    public TestMapView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public TestMapView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initView(context);
    }

    public TestMapView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);
    }


    private void initView(Context context) {

        mMapView = new MapView(context);
        addView(mMapView,
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        FrameLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);


        Button child = new Button(context);


        child.setText("这个是我的按钮");
        addView(child, params);


    }
}
