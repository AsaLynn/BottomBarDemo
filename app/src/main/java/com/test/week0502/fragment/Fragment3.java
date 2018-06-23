package com.test.week0502.fragment;


import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.test.week0502.R;
import com.test.week0502.base.BaseFragment;
import com.test.week0502.common.Category;
import com.test.week0502.common.CategoryItemViewBinder;
import com.test.week0502.multi.Post;
import com.test.week0502.multi.PostList;
import com.test.week0502.multi.PostViewBinder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.drakeet.multitype.MultiTypeAdapter;


/**
 * Created by think on 2017/11/27.
 * 频道.
 */

public class Fragment3 extends BaseFragment {
    @BindView(R.id.list)
    RecyclerView recyclerView;
    @BindView(R.id.activity_multi_grid)
    RelativeLayout activityMultiGrid;

    private static final int SPAN_COUNT = 4;/*5*/
    MultiTypeAdapter adapter;
    @VisibleForTesting
    List<Object> items;

    @Override
    protected void request() {

    }

    @Override
    protected void initView(View view) {
        adapter = new MultiTypeAdapter();

        adapter.register(Category.class, new CategoryItemViewBinder());
        adapter.register(Post.class, new PostViewBinder());

        JsonData data = new JsonData();
        items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
      /* You also could use Category as your CategoryItemContent directly */
            items.add(data.category0);
            items.add(data.postArray[0]);
            items.add(data.postArray[1]);
            items.add(data.postArray[2]);
            items.add(data.postArray[3]);
            items.add(data.postArray[0]);
            items.add(data.postArray[1]);
//            items.add(new PostList(data.postList));
        }

        //创建指定列数的格子列表布局管理器.
        final GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Object item = items.get(position);
                return (item instanceof PostList || item instanceof Category) ? SPAN_COUNT : 1;
            }
        };
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(layoutManager);


//        adapter.register(Square.class, new SquareViewBinder(selectedSet));


        recyclerView.setAdapter(adapter);
        adapter.setItems(items);

    }

    @Override
    protected View onCreateSuccessedView() {
        View view = LayoutInflater
                .from(getActivity())
                .inflate(R.layout.fragment_3, null);
        return view;
    }

    private static class JsonData {

        private static final String PREFIX = "*";

        private Post post00 = new Post(R.mipmap.ic_launcher_round, PREFIX + "post00");
        private Post post01 = new Post(R.mipmap.ic_launcher_round, PREFIX + "post01");
        private Post post10 = new Post(R.mipmap.ic_launcher_round, PREFIX + "post10");
        private Post post11 = new Post(R.mipmap.ic_launcher_round, PREFIX + "post11");

        Category category0 = new Category("title0");
        Post[] postArray = {post00, post01, post10, post11};

        List<Post> postList = new ArrayList<>();

        {
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
        }
    }
}
