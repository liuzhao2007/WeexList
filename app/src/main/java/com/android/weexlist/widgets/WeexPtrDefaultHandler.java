package com.android.weexlist.widgets;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;

import com.taobao.weex.RenderContainer;
import com.taobao.weex.ui.view.WXFrameLayout;
import com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView;

import in.srain.cube.views.ptr.PtrDefaultHandler;

/**
 * Created by liuzhao on 17/3/23.
 */

public abstract class WeexPtrDefaultHandler extends PtrDefaultHandler {
    public static boolean canChildScrollUp(View view) {
        View realView = view;
        if (view instanceof ViewGroup) {
            FrameLayout frameLayout = (FrameLayout) view;
            RenderContainer renderContainer = (RenderContainer) frameLayout.getChildAt(0);
            realView = ((BounceRecyclerView) ((WXFrameLayout) renderContainer.getChildAt(0)).getChildAt(0)).getInnerView();
        }
        if (android.os.Build.VERSION.SDK_INT < 14) {
            if (realView instanceof AbsListView) {
                final AbsListView absListView = (AbsListView) realView;
                return absListView.getChildCount() > 0
                        && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0)
                        .getTop() < absListView.getPaddingTop());
            } else {
                return realView.getScrollY() > 0;
            }
        } else {
            return ViewCompat.canScrollVertically(realView, -1);
        }
    }
}
