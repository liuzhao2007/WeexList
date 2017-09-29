package com.android.weexlist.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.android.weexlist.R;
import com.taobao.weex.ui.view.gesture.WXGesture;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by liuzhao on 16/6/4.
 */
public class MaterialDesignPtrFrameLayout extends PtrFrameLayout {

    private PtrFrameLayout mPtrFrameLayout;

    private WXGesture wxGesture;
    /**
     * @param context
     */
    public MaterialDesignPtrFrameLayout(Context context) {
        this(context, null);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.i("lz","onFinishInflate");
    }

    public MaterialDesignPtrFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPtrFrameLayout = this;
        // header
        final WeexMaterialHeader header = new WeexMaterialHeader(getContext());
        int[] colors = getResources().getIntArray(R.array.google_colors);
        header.setColorSchemeColors(colors);
        header.setLayoutParams(new LayoutParams(-1, -2));
        header.setPadding(0, 20, 0, 20);
        header.setPtrFrameLayout(mPtrFrameLayout);

        mPtrFrameLayout.setLoadingMinTime(700);
        mPtrFrameLayout.setDurationToCloseHeader(300);
        mPtrFrameLayout.setHeaderView(header);
        mPtrFrameLayout.addPtrUIHandler(header);
        mPtrFrameLayout.setPinContent(true);

        //页面加载时候自动刷新
//        mPtrFrameLayout.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mPtrFrameLayout.autoRefresh(true);
//            }
//        }, 100);
        mPtrFrameLayout.setResistance(1.5f);//阻尼系数 默认: 1.7f，越大，感觉下拉时越吃力。
        disableWhenHorizontalMove(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(mContent == null){
            getContentViewOut();
        }else{
            Log.i("lz","已经有了");
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
//
//    @Override
//    protected void onLayout(boolean flag, int i, int j, int k, int l) {
//        super.onLayout(flag, i, j, k, l);
//        if (mContent != null) {
//            MarginLayoutParams lp = (MarginLayoutParams) mContent.getLayoutParams();
//            final int left = 0;
//            final int top = 0;
//            final int right = left + 720;
//            final int bottom = top + 1080;
//            mContent.layout(left, top, right, bottom);
//        }
//    }
//
    private void getContentViewOut(){
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (!child.equals(getHeaderView())) {
                mContent = child;
                Log.i("lz","成功获取到了mContent");
                break;
            }
        }
    }

}
