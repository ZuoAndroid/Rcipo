package com.lietou.rcipo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.lietou.rcipo.fragment.IndexFragment;
import com.lietou.rcipo.fragment.IpoFragmnet;
import com.lietou.rcipo.fragment.LoginFragment;
import com.lietou.rcipo.fragment.NewsFragment;

import org.apache.http.client.HttpClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //声明UI
    private TextView txt_channel;
    private TextView txt_message;
    private TextView txt_better;
    private TextView txt_setting;
    private FrameLayout ly_content;

    private FragmentManager manager;
    //声明Fragment
    private IndexFragment fg1;
    private NewsFragment fg2;
    private LoginFragment fg3;
    private IpoFragmnet fg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
        bindView();
        txt_channel.performClick();

    }

    //UI控件的初始化方法
    private void bindView() {
        txt_channel = (TextView) findViewById(R.id.text_channel);
        txt_better = ((TextView) findViewById(R.id.text_better));
        txt_message = (TextView) findViewById(R.id.text_message);
        txt_setting = (TextView) findViewById(R.id.text_setting);
        ly_content = (FrameLayout) findViewById(R.id.ly_centent);

        txt_channel.setOnClickListener(this);
        txt_better.setOnClickListener(this);
        txt_setting.setOnClickListener(this);
        txt_message.setOnClickListener(this);
    }

    //重置底部文本选中的状态
    private void setSelected() {
        txt_channel.setSelected(false);
        txt_setting.setSelected(false);
        txt_message.setSelected(false);
        txt_better.setSelected(false);
    }

    //隐藏所有的Fragment
    private void hideAllFragMent(FragmentTransaction transaction) {
        if (fg1 != null) transaction.hide(fg1);
        if (fg2 != null) transaction.hide(fg2);
        if (fg3 != null) transaction.hide(fg3);
        if (fg4 != null) transaction.hide(fg4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = manager.beginTransaction();
        hideAllFragMent(transaction);
        switch (v.getId()) {
            case R.id.text_channel:
                setSelected();
                txt_channel.setSelected(true);
                if (fg1 == null) {
                    fg1 = new IndexFragment(MainActivity.this);
                    transaction.add(R.id.ly_centent, fg1);
                } else {
                    transaction.show(fg1);
                }
                break;
            case R.id.text_message:
                setSelected();
                txt_message.setSelected(true);
                if (fg2 == null) {
                    fg2 = new NewsFragment();
                    transaction.add(R.id.ly_centent, fg2);
                } else {
                    transaction.show(fg2);
                }
                break;
            case R.id.text_better:
                setSelected();
                txt_better.setSelected(true);
                if (fg3 == null) {
                    fg3 = new LoginFragment(getApplicationContext());
                    transaction.add(R.id.ly_centent, fg3);
                } else {
                    transaction.show(fg3);
                }
                break;
            case R.id.text_setting:
                setSelected();
                txt_setting.setSelected(true);
                if (fg4 == null) {
                    fg4 = new IpoFragmnet("第四个Fragment");
                    transaction.add(R.id.ly_centent, fg4);
                } else {
                    transaction.show(fg4);
                }
                break;
        }
        transaction.commit();
    }
}
