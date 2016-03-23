package com.cy.classinteraction.net;

import android.content.Context;
import android.widget.Toast;

import com.cy.classinteraction.R;
import com.cy.classinteraction.entity.MyUser;
import com.cy.classinteraction.util.LogUtil;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.RequestSMSCodeListener;

/**
 * 发送验证码工具类
 * Created by wuyue on 2016/3/23.
 */
public class SendSmsNet{

    private Context mContext;

    /**
     * 向指定的手发送短信验证码
     * @param phoneNum
     * @param mContext
     */
    public static void sendSms(String phoneNum, final Context mContext){
        BmobSMS.requestSMSCode(mContext, phoneNum, "Address", new RequestSMSCodeListener() {
            @Override
            public void done(Integer arg0, BmobException arg1) {
                // TODO Auto-generated method stub
                if (null == arg1) {
                    Toast.makeText(mContext, R.string.send_sms_success,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(mContext, R.string.send_sms_erro,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public static void signOrLoginByMobilePhone(final Context mContext,String phone,String code){
        BmobUser.signOrLoginByMobilePhone(mContext,phone,code, new LogInListener<MyUser>() {
            @Override
            public void done(MyUser myUser, BmobException e) {
                if(null != myUser){
                    LogUtil.e("登录成功");
                }else{
                    LogUtil.e("登录失败");
                    Toast.makeText(mContext,"验证码有误！",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
