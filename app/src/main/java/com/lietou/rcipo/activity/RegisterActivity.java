package com.lietou.rcipo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

import com.lietou.rcipo.R;
import com.lietou.rcipo.utils.AppConstants;
import com.lietou.rcipo.views.CleanEditText;

import org.json.JSONObject;

import java.io.ObjectInput;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;

/**
 * 项目名称：MyLoginDemo
 * 类描述：
 * 创建人：ZuoWenBin
 * 创建时间：2016/1/26 14:17
 * 修改人：Administrator
 * 修改时间：2016/1/26 14:17
 * 修改备注：
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private CleanEditText et_phone;
    private Button btn_send_verifi_code;
    private RelativeLayout layout_phone;
    private CleanEditText et_password;
    private CleanEditText et_verifiCode;
    private CleanEditText et_nickname;
    private Button btn_create_account;
    private TextView tv_user_rule;
    private RelativeLayout layout_root;
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        SMSSDK.initSDK(getApplicationContext(), AppConstants.SMSAPPKEY, AppConstants.SMSAPPSECRET);
        initView();
        EventHandler eventHandler = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                Message message = new Message();
                message.arg1 = event;
                message.arg2 = result;
                message.obj = data;
                handler.sendMessage(message);
            }
        };
        SMSSDK.registerEventHandler(eventHandler);

    }

    private void initView() {
        et_phone = (CleanEditText) findViewById(R.id.et_phone);
        btn_send_verifi_code = (Button) findViewById(R.id.btn_send_verifi_code);
        layout_phone = (RelativeLayout) findViewById(R.id.layout_phone);
        et_password = (CleanEditText) findViewById(R.id.et_password);
        et_verifiCode = (CleanEditText) findViewById(R.id.et_verifiCode);
        et_nickname = (CleanEditText) findViewById(R.id.et_nickname);
        btn_create_account = (Button) findViewById(R.id.btn_create_account);
        tv_user_rule = (TextView) findViewById(R.id.tv_user_rule);
        layout_root = (RelativeLayout) findViewById(R.id.layout_root);

        btn_send_verifi_code.setOnClickListener(this);
        btn_create_account.setOnClickListener(this);
        tv_user_rule.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_verifi_code:
                if (!TextUtils.isEmpty(et_phone.getText().toString())) {
                    SMSSDK.getVerificationCode("86", et_phone.getText().toString());
                    phoneNumber = et_phone.getText().toString();
                }else {
                    Toast.makeText(RegisterActivity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_create_account:
                SMSSDK.submitVerificationCode("86" , phoneNumber , et_verifiCode.getText().toString());
                break;
            case R.id.tv_user_rule:

                break;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            int event = msg.arg1;
            int result = msg.arg2;
            Object data = msg.obj;

            if (result == SMSSDK.RESULT_COMPLETE) {
                System.out.println("--------result" + event);
                //短信注册成功后，返回MainActivity,然后提示新好友
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {//提交验证码成功
                    Toast.makeText(getApplicationContext(), "提交验证码成功", Toast.LENGTH_SHORT).show();

                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    //已经验证
                    Toast.makeText(getApplicationContext(), "验证码已经发送", Toast.LENGTH_SHORT).show();
                }

            } else {
//				((Throwable) data).printStackTrace();
//				Toast.makeText(MainActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
//					Toast.makeText(MainActivity.this, "123", Toast.LENGTH_SHORT).show();
                int status = 0;
                try {
                    ((Throwable) data).printStackTrace();
                    Throwable throwable = (Throwable) data;

                    JSONObject object = new JSONObject(throwable.getMessage());
                    String des = object.optString("detail");
                    status = object.optInt("status");
                    if (!TextUtils.isEmpty(des)) {
                        Toast.makeText(RegisterActivity.this, des, Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    SMSLog.getInstance().w(e);
                }
            }
        }
    };

    @Override
    protected void onDestroy() {
        SMSSDK.unregisterAllEventHandler();
    }
}
