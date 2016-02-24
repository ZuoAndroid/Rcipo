package com.lietou.rcipo.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.lietou.rcipo.R;
import com.lietou.rcipo.activity.RegisterActivity;
import com.lietou.rcipo.utils.Utils;

/**
 * 项目名称：Rcipo
 * 类描述：登录的FragMent
 * 创建人：ZuoWenBin
 * 创建时间：2016/2/1 9:39
 * 修改人：Administrator
 * 修改时间：2016/2/1 9:39
 * 修改备注：
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText userName;
    private EditText passWord;
    private Button login_Btn;
    private ImageView iv_weChat;
    private ImageView iv_QQ;
    private ImageView iv_Sina;
    private TextView creat_User;
    private TextView forget_Password;

    private Context context;

    public LoginFragment(Context context) {
        super();
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userName = ((EditText) view.findViewById(R.id.et_email_phone));
        passWord = ((EditText) view.findViewById(R.id.et_password));
        login_Btn = ((Button) view.findViewById(R.id.btn_login));
        iv_weChat = ((ImageView) view.findViewById(R.id.iv_wechat));
        iv_QQ = ((ImageView) view.findViewById(R.id.iv_qq));
        iv_Sina = ((ImageView) view.findViewById(R.id.iv_sina));
        creat_User = ((TextView) view.findViewById(R.id.tv_create_account));
        forget_Password = ((TextView) view.findViewById(R.id.tv_forget_password));
        login_Btn.setOnClickListener(this);
        iv_QQ.setOnClickListener(this);
        iv_Sina.setOnClickListener(this);
        iv_weChat.setOnClickListener(this);
        creat_User.setOnClickListener(this);
        forget_Password.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_qq:
                boolean b = Utils.isQQAvilible(context);
                if (b == true) {
                    Toast.makeText(context, "QQ登录正在开发中...", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.iv_wechat:
                boolean bb = Utils.isWeixinAvilible(context);
                if (bb = true) {
                    Toast.makeText(context, "微信登录正在开发中...", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.iv_sina:
                boolean bbb = Utils.isXLWeiBoAvilible(context);
                if (bbb = true) {
                    Toast.makeText(context, "微博登录正在开发中...", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_create_account:
                startActivity(new Intent(context, RegisterActivity.class));
                break;
        }
    }
}