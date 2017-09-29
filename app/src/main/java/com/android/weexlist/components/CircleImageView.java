package com.android.weexlist.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.android.weexlist.glide.GlideCircleTransform;
import com.bumptech.glide.Glide;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.dom.WXDomObject;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;

/**
 * Created by liuzhao on 17/3/22.
 */

public class CircleImageView extends WXComponent<ImageView> {

    public CircleImageView(WXSDKInstance instance, WXDomObject dom, WXVContainer parent) {
        super(instance, dom, parent);
    }

    @Override
    protected ImageView initComponentHostView(@NonNull Context context) {
        ImageView view = new ImageView(context);
        return view;
    }

    @WXComponentProp(name = "setSrc")
    public void setImage(String url) {
        Glide.with(getContext()).load(url)
                .transform(new GlideCircleTransform(getContext())).into((ImageView) getHostView());
    }
}
