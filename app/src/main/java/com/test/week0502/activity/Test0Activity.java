package com.test.week0502.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.demonstrate.DemonstrateUtil;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.roughike.bottombar.TabSelectionInterceptor;
import com.test.week0502.R;
import com.test.week0502.factory.FragmentFactory;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Test0Activity extends AppCompatActivity {

    @BindView(R.id.contentContainer)
    FrameLayout contentContainer;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottmo_bar1);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("华为视频.优酷版");

        //设置会员tab的消息数量
        bottomBar.getTabWithId(R.id.tab2).setBadgeCount(1);
        //设置频道tab的消息数量
        bottomBar.getTabWithId(R.id.tab3).setBadgeCount(2);

        //BottomBar,设置选项标签选中状态的监听
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {


            @Override
            public void onTabSelected(int tabId) {
                int index = bottomBar.findPositionForTabWithId(tabId);
                switch (tabId) {
                    case R.id.tab0://首页
                        Toast.makeText(Test0Activity.this, "首页", Toast.LENGTH_SHORT).show();
                        index = 0;
                        bottomBar.findPositionForTabWithId(tabId);
                        break;
                    case R.id.tab1://热点
                        Toast.makeText(Test0Activity.this, "热点", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tab2://会员
                        Toast.makeText(Test0Activity.this, "会员", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tab3://频道
                        Toast.makeText(Test0Activity.this, "频道", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tab4://我的
                        Toast.makeText(Test0Activity.this, "我的", Toast.LENGTH_SHORT).show();
                        break;
                }

                //获取当前选中的Tab位置索引
//                index = bottomBar.getCurrentTabPosition();
                DemonstrateUtil.showLogResult("index:"+String.valueOf(index));

                //获取Fragment
                Fragment fragment = (Fragment) fragmentStatePagerAdapter.instantiateItem(contentContainer, index);
                //替换方法3,需要去替换的fragment对象
                fragmentStatePagerAdapter.setPrimaryItem(null, 0, fragment);
                //提交操作
                fragmentStatePagerAdapter.finishUpdate(null);

            }
        });

        //重写监听,即,选中的时候再次去选中.事件监听.
        // 已经选择了这个标签，又点击一次。即重选。
//        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
//            @Override
//            public void onTabReSelected(@IdRes int tabId) {
//                if (tabId == R.id.tab_favorites) {
//                    移除标记.
//                    barTab1.removeBadge();
//                }
//            }
//        });

        //被选中者,拦截机,
        // //TabSelectionInterceptor,被选中的BottomBarTab的拦截监听器.
        //设置被选择的BottomBarTab是否被选中的监听
        //设置某个BottomBarTab,点击是否生效.
        bottomBar.setTabSelectionInterceptor(new TabSelectionInterceptor() {
            @Override
            public boolean shouldInterceptTabSelection(@IdRes int oldTabId, @IdRes int newTabId) {
                // 点击无效
                /*if (newTabId == R.id.tab_restaurants ) {
                    // ......
                    // 返回 true 。代表：这里我处理了，你不用管了。
                    BottomBarTab bottomBarTab = bottomBar.getTabWithId(oldTabId);
                    bottomBarTab.setBadgeCount(2);
                    return true;
                }*/
                return false;
            }
        });
    }

    //创建fragment的数据适配器
    FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {

        @Override
        public int getCount() {
            return bottomBar.getTabCount();
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }
    };

}
