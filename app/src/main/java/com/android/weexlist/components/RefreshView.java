package com.android.weexlist.components;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;

import com.android.weexlist.widgets.MaterialDesignPtrFrameLayout;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.dom.WXDomObject;
import com.taobao.weex.ui.ComponentCreator;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView;

import java.lang.reflect.InvocationTargetException;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by liuzhao on 17/3/21.
 */

public class RefreshView extends WXVContainer<MaterialDesignPtrFrameLayout> {
    public RefreshView(WXSDKInstance instance, WXDomObject dom, WXVContainer parent) {
        super(instance, dom, parent);
    }

    public static class Ceator implements ComponentCreator {
        public WXComponent createInstance(WXSDKInstance instance, WXDomObject node, WXVContainer parent) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return new RefreshView(instance, node, parent);
        }
    }

    @Override
    protected MaterialDesignPtrFrameLayout initComponentHostView(@NonNull Context context) {
        final MaterialDesignPtrFrameLayout materialDesignPtrFrameLayout = new MaterialDesignPtrFrameLayout(context);
        materialDesignPtrFrameLayout.setPinContent(true);//设置内容不动。
        materialDesignPtrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                View realView = content;
                if (realView instanceof ViewGroup) {
                    FrameLayout frameLayout = (FrameLayout) realView;
                    realView = ((BounceRecyclerView)frameLayout.getChildAt(0)).getInnerView();
                }
                if (android.os.Build.VERSION.SDK_INT < 14) {
                    if (realView instanceof AbsListView) {
                        final AbsListView absListView = (AbsListView) realView;
                        return !(absListView.getChildCount() > 0
                                && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0)
                                .getTop() < absListView.getPaddingTop()));
                    } else {
                        return !(realView.getScrollY() > 0);
                    }
                } else {
                    return !ViewCompat.canScrollVertically(realView, -1);
                }
            }
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialDesignPtrFrameLayout.refreshComplete();
                    }
                },1000);
            }
        });

        return materialDesignPtrFrameLayout;
    }

    @WXComponentProp(name = "diaplay")
    public void setRefreshStatus(String refreshStatus) {
        if (TextUtils.equals("show", refreshStatus)) {
            ((MaterialDesignPtrFrameLayout) getHostView()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    ((MaterialDesignPtrFrameLayout) getHostView()).autoRefresh(true);
                }
            }, 100);
        } else if (TextUtils.equals("hide", refreshStatus)) {
            ((MaterialDesignPtrFrameLayout) getHostView()).refreshComplete();
        }
    }

}