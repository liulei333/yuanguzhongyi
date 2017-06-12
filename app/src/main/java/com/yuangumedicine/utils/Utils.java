package com.yuangumedicine.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;

import com.yuangumedicine.cn.R;
import com.yuangumedicine.view.SwipeRefreshLayout;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * Created by starwrap on 2017-05-31.
 */

public class Utils {


    /**
     * 初始化滑动刷新
     *
     * @param swipeRefreshLayout 当前界面的滑动组件变量名
     * @param refreshListener    使用刷新  传this  否则传null
     * @param loadListener       使用加载 传this
     */
    public static void initRefresh(SwipeRefreshLayout swipeRefreshLayout, SwipeRefreshLayout.OnRefreshListener refreshListener,
                                   SwipeRefreshLayout.OnLoadListener loadListener) {
        if (null != refreshListener) {
            swipeRefreshLayout.setOnRefreshListener(refreshListener);
        }
        if (null != loadListener) {
            swipeRefreshLayout.setOnLoadListener(loadListener);
        }
        /*先处理监听有无，再处理滑动方式*/
        if (null != refreshListener && null != loadListener) {
            swipeRefreshLayout.setMode(SwipeRefreshLayout.Mode.BOTH);
        } else if (null != refreshListener) {
            swipeRefreshLayout.setMode(SwipeRefreshLayout.Mode.PULL_FROM_START);
        } else if (null != loadListener) {
            swipeRefreshLayout.setMode(SwipeRefreshLayout.Mode.PULL_FROM_END);
        }
        swipeRefreshLayout.setColor(R.color.colorPrimary, R.color.colorPrimary,
                R.color.colorPrimary, R.color.colorPrimary);
    }





}
