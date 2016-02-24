package com.lietou.rcipo.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.*;

import com.lietou.rcipo.R;
import com.lietou.rcipo.fragment.Info_B1_Fragment;
import com.lietou.rcipo.fragment.Info_B2_Fragment;
import com.lietou.rcipo.fragment.Info_B3_Fragment;
import com.lietou.rcipo.fragment.Info_B4_Fragment;
import com.lietou.rcipo.fragment.Info_B5_Fragment;
import com.lietou.rcipo.fragment.Info_B6_Fragment;

/**
 * 项目名称：Rcipo
 * 类描述：被投资人详情界面
 * 创建人：ZuoWenBin
 * 创建时间：2016/2/15 14:23
 * 修改人：Administrator
 * 修改时间：2016/2/15 14:23
 * 修改备注：
 */
public class InfoActivity extends ApplyIpoActivity implements View.OnClickListener {
    private VideoView videoView;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    //http://yuntv.letv.com/bcloud.html?uu=1fab7a485b&vu=635ab00abe&auto_play=0&gpcflag=1&width=100%&height=100%&

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_layout);

        Uri uri = Uri.parse("http://v1.mukewang.com/de9dc493-147b-4671-9b4f-17c01bc55fe5/L.mp4");
        videoView = ((VideoView) this.findViewById(R.id.vv_id));
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.info_frag , new Info_B1_Fragment());
        transaction.commit();
        bindView();
    }

    private void bindView() {
        findViewById(R.id.b1).setOnClickListener(this);
        findViewById(R.id.b2).setOnClickListener(this);
        findViewById(R.id.b3).setOnClickListener(this);
        findViewById(R.id.b4).setOnClickListener(this);
        findViewById(R.id.b5).setOnClickListener(this);
        findViewById(R.id.b6).setOnClickListener(this);
        findViewById(R.id.b7).setOnClickListener(this);
        findViewById(R.id.b8).setOnClickListener(this);
        findViewById(R.id.b9).setOnClickListener(this);
        findViewById(R.id.b10).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        manager = getFragmentManager();
        transaction = manager.beginTransaction();

        switch (id) {
            case R.id.b1:
                transaction.replace(R.id.info_frag, new Info_B1_Fragment());
                break;
            case R.id.b2:
                transaction.replace(R.id.info_frag ,new Info_B2_Fragment());
                break;
            case R.id.b3:
                transaction.replace(R.id.info_frag , new Info_B3_Fragment());
                break;
            case R.id.b4:
                transaction.replace(R.id.info_frag , new Info_B4_Fragment());
                break;
            case R.id.b5:
                transaction.replace(R.id.info_frag , new Info_B5_Fragment());
                break;
            case R.id.b6:
                transaction.replace(R.id.info_frag , new Info_B6_Fragment());
                break;

        }
        transaction.commit();
    }
}
