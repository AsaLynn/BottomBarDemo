package com.test.week0502.fragment;

import android.view.View;
import android.widget.TextView;

import com.test.week0502.base.BaseFragment;


/**
 * Created by think on 2017/11/27.
 */

public class Fragment2 extends BaseFragment {
    @Override
    protected void initView(View view) {

    }

    @Override
    protected View onCreateSuccessedView() {
        TextView view = new TextView(this.getActivity());
        view.setText("会员");
        return view;
    }
}
