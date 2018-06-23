package com.test.week0502.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by think on 2017/11/27.
 */

public abstract class BaseFragment extends Fragment {
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return BaseFragment.this.onCreateSuccessedView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        request();
    }

    protected void request() {

    }

    //view创建成功后进行初始化.
    protected abstract void initView(View view);

    //BaseFragment中依然是不知道子界面的展示效果,所以抽象,让其放到子类中去处理
    protected abstract View onCreateSuccessedView();

    @Override
    public void setMenuVisibility(boolean menuVisible) {

        //如果当前view是可见的,则menuVisible就是true
        //每一个子类fragment对应view是否存在的操作
        if (getView() != null) {
            getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
        }
        super.setMenuVisibility(menuVisible);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
