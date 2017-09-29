package com.android.weexlist.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.android.weexlist.R;
import com.android.weexlist.widgets.MaterialDesignPtrFrameLayout;
import com.android.weexlist.widgets.WeexPtrDefaultHandler;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by liuzhao on 2017/9/28.
 */

public class RecommendActivity extends FragmentActivity implements IWXRenderListener {

    private WXSDKInstance mWxsdkInstance;
    private FrameLayout frameLayout;
    private static MaterialDesignPtrFrameLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommendactivity);
        swipeRefreshLayout = (MaterialDesignPtrFrameLayout) findViewById(R.id.subscript_ptr);
        frameLayout = (FrameLayout) findViewById(R.id.fl_container);
        mWxsdkInstance = new WXSDKInstance(this);
        mWxsdkInstance.registerRenderListener(this);
        mWxsdkInstance.render("WeexListApp", WXFileUtils.loadAsset("recommend.js", this), null, null, WXRenderStrategy.APPEND_ASYNC);

        swipeRefreshLayout.setPtrHandler(new WeexPtrDefaultHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
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
        frameLayout.addView(view);
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

    }
}
