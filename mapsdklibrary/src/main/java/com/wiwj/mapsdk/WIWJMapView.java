package com.wiwj.mapsdk;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.wiwj.mapsdk.widget.mark.AnchorPointView;

/**
 * Created by gavin on 2017/3/15.
 * 5i5j 封装的MapView
 */

public class WIWJMapView extends FrameLayout {


    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private Context context;

    public WIWJMapView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public WIWJMapView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public WIWJMapView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);
    }

    private void initView(Context context) {

        mMapView = new MapView(context);
        addView(mMapView,
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        mBaiduMap = mMapView.getMap();

        this.context = context;

    }

    /**
     *
     * @param
     */
    public void addTextMarker() {

        LatLng latLng = new LatLng(39.963175, 116.400244);

        AnchorPointView view = new AnchorPointView(context);



        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromView(view);

        OverlayOptions options = new MarkerOptions().icon(bitmap).position(latLng);

        mBaiduMap.addOverlay(options);
    }


    public void addIconMarker() {


    }
}
