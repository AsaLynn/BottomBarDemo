package com.test.week0502.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.test.week0502.base.BaseFragment;


/**
 * Created by think on 2017/11/27.
 */

public class Fragment0 extends BaseFragment {

    private static String TAG = "Fragment0";

    @Override
    protected void initView(View view) {

    }

    @Override
    protected View onCreateSuccessedView() {
//        View view = LayoutInflater
//                .from(getActivity())
//                .inflate(R.layout.fragment_0, null);
//        return view;
        TextView view = new TextView(this.getActivity());
        view.setText("首页");
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "--->onCreate: ");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "--->onActivityCreated: ");
    }
}
