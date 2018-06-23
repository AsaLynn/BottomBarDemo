package com.test.week0502.listener;

import android.app.Activity;

import com.example.demonstrate.adapter.testname.p1.w2.BaseT5P1W2ILis;
import com.test.week0502.activity.Test0Activity;

/**
 * Created by think on 2018/3/13.
 * 项目拆解第1页面测试题----第2周
 */

public class PageItem1 extends BaseT5P1W2ILis {

    public PageItem1(Activity activity) {
        super(activity);
    }

    @Override
    public Class<?> getStartActivity(int which) {
        if (which == 0) {
            return Test0Activity.class;
        }
        return null;
    }
}
