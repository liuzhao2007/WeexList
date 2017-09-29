package com.android.weexlist;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.android.weexlist.widgets.MaterialDesignPtrFrameLayout;
import com.android.weexlist.widgets.WeexPtrDefaultHandler;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;

import java.util.HashMap;
import java.util.Map;

import in.srain.cube.views.ptr.PtrFrameLayout;

public class NewRecommendActivity extends FragmentActivity implements IWXRenderListener {
    private WXSDKInstance mWxsdkInstance;
    private long time;
    private FrameLayout frameLayout;
    private static MaterialDesignPtrFrameLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity_main);
        swipeRefreshLayout = (MaterialDesignPtrFrameLayout) findViewById(R.id.subscript_ptr);
        frameLayout = (FrameLayout)findViewById(R.id.innerfl);
        time = System.currentTimeMillis();
        mWxsdkInstance = new WXSDKInstance(this);
        mWxsdkInstance.registerRenderListener(this);
//        mWxsdkInstance.render("WXSample", WXFileUtils.loadAsset("mycomponent.js", this), null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);

        Map<String, Object> options = new HashMap<>();
        options.put("aakey", 9876);                     // 传递自定义参数 bb
        mWxsdkInstance.render("MyApplication", WXFileUtils.loadAsset("recommend.js", this), null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);
//        mWxsdkInstance.render("MyApplication", WXFileUtils.loadAsset("richtext.js", this), null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);

//        Map<String,Object> params=new HashMap<>();
//        params.put("key","value11");
//        mWxsdkInstance.fireGlobalEventCallback("geolocation",params);

        swipeRefreshLayout.setPtrHandler(new WeexPtrDefaultHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                Log.i("lz","check");

                return !WeexPtrDefaultHandler.canChildScrollUp(content);
            }
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.refreshComplete();
                    }
                },1000);
            }

        });

//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        swipeRefreshLayout.setRefreshing(false);
//                    }
//                },2000);
//            }
//        });
//
//        swipeRefreshLayout.setOnChildScrollUpCallback(new SwipeRefreshLayout.OnChildScrollUpCallback() {
//            @Override
//            public boolean canChildScrollUp(SwipeRefreshLayout parent, @Nullable View child) {
//                return true;
//            }
//        });


    }

    /**
     * Report exception occurred when weex instance is running. Exception <strong>may not</strong>
     * cause user-noticeable failure of weex.
     *
     * @param instance
     * @param errCode
     * @param msg
     */
    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {
        Log.i("lz", "onException" + msg);
    }

    /**
     * If {@link WXRenderStrategy#APPEND_ASYNC} is applied, this method
     * will be invoked when the rendering of first view is finish.
     * If {@link WXRenderStrategy#APPEND_ONCE} is applied, this method will
     * be invoked when the rendering of the view tree is finished.
     *
     * @param instance
     * @param view
     */
    @Override
    public void onViewCreated(WXSDKInstance instance, View view) {
        Log.i("lz", "onViewCreated" + (System.currentTimeMillis() - time));

        frameLayout.addView(view);

//        ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) view.getLayoutParams();
////        layoutParams.width = 800;
////        layoutParams.height = 800;
////        view.setLayoutParams(layoutParams);
//        Log.i("lz","view:"+view.getLayoutParams()+"::"+view.getHeight());
//        setContentView(view);
//        Log.i("lz","view:"+view.getLayoutParams()+"::"+view.getHeight());


//        setContentView(view);
//        Log.i("lz","Height:"+view.getHeight());
//        Log.i("lz","Weight:"+view.getWidth());

//        FrameLayout wxfl = (FrameLayout) view;
//        View listview = wxfl.getChildAt(0);
//        wxfl.removeView(listview);
//
//
//        swipeRefreshLayout.addView(listview);
//        Log.i("lz","count:"+swipeRefreshLayout.getChildCount());
//        for (int i = 0; i < swipeRefreshLayout.getChildCount();i++){
//            View view1 = swipeRefreshLayout.getChildAt(i);
//            Log.i("lz","view1:"+view1.getLayoutParams());
//
//        }

    }

    /**
     * Called when the render view phase of weex has finished.
     * It can be invoked at most once in the entire life of a {@link WXSDKInstance}
     *
     * @param instance
     * @param width
     * @param height
     */
    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {
        Log.i("lz", "onRenderSuccess"+ (System.currentTimeMillis() - time));

//        Map<String,Object> params=new HashMap<>();
//        params.put("key","呵呵");
//        mWxsdkInstance.fireGlobalEventCallback("geolocation",params);
    }

    /**
     * Callback method, called when refresh is finished
     *
     * @param instance
     * @param width
     * @param height
     */
    @Override
    public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {
        Log.i("lz", "onRefreshSuccess");
    }
}
