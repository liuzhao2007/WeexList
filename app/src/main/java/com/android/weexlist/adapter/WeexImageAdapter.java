package com.android.weexlist.adapter;

import android.widget.ImageView;

import com.android.weexlist.R;
import com.bumptech.glide.Glide;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;

/**
 * Created by liuzhao on 17/3/8.
 */

public class WeexImageAdapter implements IWXImgLoaderAdapter {

    @Override
    public void setImage(String url, ImageView view, WXImageQuality quality, WXImageStrategy strategy) {
        Glide.with(view.getContext())
                .load(url)
                .error(R.mipmap.me_image_man)
                .into(view);
    }
}
