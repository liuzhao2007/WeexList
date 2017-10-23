package com.android.weexlist.module;

import android.widget.Toast;

import com.android.weexlist.app.WeexListApp;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;

/**
 * Created by liuzhao on 2017/10/23.
 *
 * 展示自定义Module使用
 *
 */
public class CommonModule extends WXModule {

    @JSMethod(uiThread = true)
    public void toast(String message) {
        Toast.makeText(WeexListApp.getApp(), "" + message, 0).show();
    }

}
