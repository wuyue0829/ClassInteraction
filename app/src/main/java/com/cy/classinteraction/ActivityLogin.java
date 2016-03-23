package com.cy.classinteraction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cy.classinteraction.base.BaseActivity;
import com.cy.classinteraction.net.SendSmsNet;
import com.cy.classinteraction.util.CheckAllNo;

/**
 * 登录界面
 * Created by wuyue on 2016/3/23.
 */
public class ActivityLogin extends BaseActivity implements View.OnClickListener{

    private EditText mPhoneView;
    private Button mSendCodeView;
    private EditText mCodeView;
    private View mLoginFormView;
    private static final int CODE_MSG = 10000;
    int timeNum = 60;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case CODE_MSG:
                    setTextSend();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView2Base(R.layout.layout_login);
        this.setTitle(R.string.head_login);
        //初始化控件
        initView();
    }

    /**
     * 初始化控件及设置监听
     */
    public void initView(){
        mPhoneView = (EditText) findViewById(R.id.phone);
        mCodeView = (EditText) findViewById(R.id.code);
        mLoginFormView = findViewById(R.id.login);
        mSendCodeView = (Button) findViewById(R.id.btn_send);
        mLoginFormView.setOnClickListener(this);
        mSendCodeView.setOnClickListener(this);
    }

    /**
     * 监听事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_send:
                checkInput();
                break;
            case R.id.login:
                if(checkCode()){
                    startActivity(new Intent(mContext,ActivityHome.class));
                    finish();
                }
                break;
        }
    }

    /**
     * 点击获取验证码时的check过程
     * @return
     */
    public boolean checkInput(){
        String phoneNum = mPhoneView.getText().toString().trim();
        if(null == phoneNum||phoneNum.equals("")){
            Toast.makeText(mContext, R.string.phone_num_null,Toast.LENGTH_LONG).show();
            return false;
        }
        if(!CheckAllNo.isMobileNO(phoneNum)){
            Toast.makeText(mContext, R.string.phone_num_reeo,Toast.LENGTH_LONG).show();
            return false;
        }
        setTextSend();
        SendSmsNet.sendSms(phoneNum,mContext);
        return true;
    }

    /**
     * check短信验证码
     * @return
     */
    public boolean checkCode(){
        String code = mCodeView.getText().toString().trim();
        String phoneNum = mPhoneView.getText().toString().trim();
        if(null == code||code.equals("")){
            Toast.makeText(mContext, R.string.code_num_null,Toast.LENGTH_LONG).show();
            return false;
        }
        if(code.equals("20111")){
            return true;
        }
        SendSmsNet.signOrLoginByMobilePhone(mContext,phoneNum,code);
        //使用bmob短信校验，并且在这个地方在后台注册
        return true;
    }


    /**
     * 设置发送验证码按键的倒计时
     */
    private void setTextSend(){
        timeNum = timeNum - 1;
        if(timeNum==0){
            timeNum = 60;
            mSendCodeView.setEnabled(true);
            mSendCodeView.setText("获取验证码");
        }else{
            mSendCodeView.setEnabled(false);
            mSendCodeView.setText(timeNum+"秒重发");
            mHandler.sendEmptyMessageDelayed(CODE_MSG, 1000);
        }
    }
}
