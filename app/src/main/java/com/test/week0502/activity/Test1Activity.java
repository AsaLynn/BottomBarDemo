package com.test.week0502.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.test.week0502.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zxn on 2019-1-7 15:14:31.
 */
public class Test1Activity extends AppCompatActivity {

    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.bb_home)
    BottomBar bbHome;
    private String mParam1;

    public static void jumpTo(Context context, String param1) {
        Intent intent = new Intent(context, Test1Activity.class);
        intent.putExtra(ARG_PARAM1, param1);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        ButterKnife.bind(this);
        mParam1 = getIntent().getStringExtra(ARG_PARAM1);
    }


}
