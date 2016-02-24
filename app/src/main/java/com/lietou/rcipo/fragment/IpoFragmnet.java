package com.lietou.rcipo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lietou.rcipo.R;

/**
 * 项目名称：Rcipo
 * 类描述：
 * 创建人：ZuoWenBin
 * 创建时间：2016/1/28 15:09
 * 修改人：Administrator
 * 修改时间：2016/1/28 15:09
 * 修改备注：
 */
public class IpoFragmnet extends Fragment {

    private String content;

    public IpoFragmnet(String content) {
        this.content = content;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fg_centent , container , false);
        TextView tv = ((TextView) view.findViewById(R.id.text_centent));
        Log.d("TAG", "----->" + content);
        tv.setText(content);
        return view;
    }
}
