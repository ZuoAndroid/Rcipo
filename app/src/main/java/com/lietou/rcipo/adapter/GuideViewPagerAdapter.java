package com.lietou.rcipo.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 项目名称：Rcipo
 * 类描述：引导页的Adapter
 * 创建人：ZuoWenBin
 * 创建时间：2016/1/28 14:00
 * 修改人：Administrator
 * 修改时间：2016/1/28 14:00
 * 修改备注：
 */
public class GuideViewPagerAdapter extends PagerAdapter {

    private List<View> views;

    public GuideViewPagerAdapter(List<View> views) {
        super();
        this.views = views;
    }

    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }
        return 0;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(views.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(views.get(position), 0);
        return views.get(position);
    }

}
