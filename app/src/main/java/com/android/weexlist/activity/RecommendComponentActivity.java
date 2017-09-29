package com.android.weexlist.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.android.weexlist.R;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;
import com.taobao.weex.utils.WXLogUtils;

/**
 * Created by liuzhao on 2017/9/28.
 */

public class RecommendComponentActivity extends Activity implements IWXRenderListener {
    private LinearLayout linearLayout;
    private WXSDKInstance mWxsdkInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommendcomponent);
        linearLayout = (LinearLayout) findViewById(R.id.ll_container);
        mWxsdkInstance = new WXSDKInstance(this);
        mWxsdkInstance.registerRenderListener(this);
        mWxsdkInstance.render("WeexListApp", WXFileUtils.loadAsset("recommendcomponent.js", this), null, null, WXRenderStrategy.APPEND_ASYNC);
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
        linearLayout.addView(view);
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
        WXLogUtils.i("lz", "success");
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
        WXLogUtils.i("lz", "onException");
    }
}
