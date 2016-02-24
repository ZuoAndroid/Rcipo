package com.lietou.rcipo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.lietou.rcipo.R;

import java.util.List;

/**
 * 项目名称：Rcipo
 * 类描述：新闻列表的Adapter
 * 创建人：ZuoWenBin
 * 创建时间：2016/1/29 10:49
 * 修改人：Administrator
 * 修改时间：2016/1/29 10:49
 * 修改备注：
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private Context context;
    private List<String> list;
    private ViewHolder holder;

    public NewsAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        holder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item , parent ,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("TAG" , "---->" + list.size());
        holder.title.setText("哇塞，以后HR同胞们都能去做股评家啦！");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            title = ((TextView) itemView.findViewById(R.id.news_title));
        }
    }
}
