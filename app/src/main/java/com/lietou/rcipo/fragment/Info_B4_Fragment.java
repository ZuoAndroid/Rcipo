package com.lietou.rcipo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lietou.rcipo.R;

/**
 * 项目名称：Rcipo
 * 类描述：
 * 创建人：ZuoWenBin
 * 创建时间：2016/2/18 14:39
 * 修改人：Administrator
 * 修改时间：2016/2/18 14:39
 * 修改备注：
 */
public class Info_B4_Fragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_b4_layout, container ,false);
        return view;
    }
}
