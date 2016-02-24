package com.lietou.rcipo.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lietou.rcipo.R;
import com.lietou.rcipo.activity.ApplyIpoActivity;
import com.lietou.rcipo.activity.InfoActivity;

/**
 * 项目名称：Rcipo
 * 类描述：
 * 创建人：ZuoWenBin
 * 创建时间：2016/1/28 15:25
 * 修改人：Administrator
 * 修改时间：2016/1/28 15:25
 * 修改备注：
 */
public class IndexFragment extends Fragment implements View.OnClickListener {

    private Context context;

    public IndexFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_index , container , false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.applyipo_btn).setOnClickListener(this);
        view.findViewById(R.id.btn1).setOnClickListener(this);
        view.findViewById(R.id.btn2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn1:

                Intent intent = new Intent();
                intent.putExtra("ZHANGFEI" , 1);
                intent.setClass(context , InfoActivity.class);
                startActivity(intent);
                break;

            case R.id.btn2:
                startActivity(new Intent(context , InfoActivity.class));
                break;
            case R.id.applyipo_btn:
                startActivity(new Intent(context , ApplyIpoActivity.class));
                break;
        }
    }
}
