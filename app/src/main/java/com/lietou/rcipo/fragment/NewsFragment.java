package com.lietou.rcipo.fragment;

import android.app.Fragment;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lietou.rcipo.R;
import com.lietou.rcipo.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：Rcipo
 * 类描述：
 * 创建人：ZuoWenBin
 * 创建时间：2016/1/29 10:32
 * 修改人：Administrator
 * 修改时间：2016/1/29 10:32
 * 修改备注：
 */
public class NewsFragment extends Fragment {

    private RecyclerView RecyView;
    private NewsAdapter adapter;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fg_news, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            list.add("哇塞，以后HR同胞们都能去做股评家啦！");
        }

        RecyView = ((RecyclerView) view.findViewById(R.id.news_recy));
        RecyView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NewsAdapter(getActivity(),list);
        RecyView.setAdapter(adapter);

        RecyView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(3, 3, 3, 3);
            }
        });


    }
}
