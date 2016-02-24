package com.lietou.rcipo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.lietou.rcipo.MainActivity;
import com.lietou.rcipo.R;
import com.lietou.rcipo.utils.AppConstants;
import com.lietou.rcipo.utils.SpUtils;

/**
 * 项目名称：Rcipo
 * 类描述：启动屏Splash的Activity
 * 创建人：ZuoWenBin
 * 创建时间：2016/1/28 14:01
 * 修改人：Administrator
 * 修改时间：2016/1/28 14:01
 * 修改备注：
 */
public class SplashActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //判断是否第一次启动该应用
        boolean isFirstOpen = SpUtils.getBoolean(this , AppConstants.FIRST_OPEN);
        //如果是第一次启动，则先进入功能引导页
        if(!isFirstOpen){
            startActivity(new Intent(this, WelcomeGuideActivity.class));
            finish();
            return;
        }

        //如果不是第一次启动
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                enterHomeActivity();
            }
        } , 1500);
    }

    private void enterHomeActivity(){
        startActivity(new Intent(this , MainActivity.class));
        finish();
    }

}
