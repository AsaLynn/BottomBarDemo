package com.test.week0502;

import com.example.demonstrate.DialogPage;
import com.example.demonstrate.FirstActivity;
import com.test.week0502.listener.PageItem1;

public class MainActivity extends FirstActivity {


    @Override
    protected void click0() {
        DialogPage
                .getInstance()
                .setOnOnDialogItemListener(new PageItem1(this));
    }
}
