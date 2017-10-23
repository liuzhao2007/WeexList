package com.android.weexlist.app;

import android.app.Application;

import com.android.weexlist.adapter.WeexImageAdapter;
import com.android.weexlist.components.CircleImageView;
import com.android.weexlist.components.RefreshView;
import com.android.weexlist.module.CommonModule;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.ui.SimpleComponentHolder;

/**
 * Created by liuzhao on 2017/9/28.
 */

public class WeexListApp extends Application {
    private static WeexListApp weexListApp;

    @Override
    public void onCreate() {
        super.onCreate();
        weexListApp = this;
        try {
            InitConfig config = new InitConfig.Builder().setImgAdapter(new WeexImageAdapter()).build();
            WXSDKEngine.registerComponent("circleImageView", CircleImageView.class);
            WXSDKEngine.registerComponent(new SimpleComponentHolder(RefreshView.class,
                            new RefreshView.Ceator())
                    , false, "refreshview");
            WXSDKEngine.registerModule("commonmodule", CommonModule.class);
            WXSDKEngine.initialize(this, config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WeexListApp getApp() {
        return weexListApp;
    }

}
