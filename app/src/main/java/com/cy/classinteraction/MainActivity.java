package com.cy.classinteraction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import com.cy.classinteraction.util.LogUtil;
import com.cy.classinteraction.util.SysConfig;
import com.cy.classinteraction.util.constant.ConfigConstant;

import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.v3.BmobUser;

/**
 * 应用起始页面
 * 将在这个页面完成以下的操作
 * 1、设置点击进入页面时白屏几秒钟的画面；（好多的应用并没有处理开始界面白屏的问题，故这个地方可以先不考虑）
 * 2、判断是否第一次进入程序，做相对应的操作；
 * 3、获取屏幕的宽和高写入到配置文件
 */
public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private SysConfig sysConfig;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        sysConfig = SysConfig.getSysConfig(context);
        //开始定时器（可以设置在多久后执行下一步操作）
        Timer timer = new Timer();
        timer.schedule(new Task(),3000);
        finish();
    }

    /**
     * 写一个定时器在几秒后执行跳转操作
     */
    class Task extends TimerTask{

        @Override
        public void run() {
            DisplayMetrics metric = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metric);
            //在系统配置文件中写入屏幕宽度
            sysConfig.setScreenWidth(metric.widthPixels);

            BmobUser user = BmobUser.getCurrentUser(context);
            if(null != user){
                //当前有用户登录
                startActivity(new Intent(context,ActivityHome.class));
                LogUtil.e(TAG,"HAVE USER");
            }else{
                //当前没有用户登录
                if("1".equals(sysConfig.getCustomConfig(ConfigConstant.IS_SHOW_WELCOME_PAGE, "0"))){
                    //显示过登录画面
                    startActivity(new Intent(context,ActivityLogin.class));
                    LogUtil.e(TAG, "NULL USER AND SHOWED WELCOME");
                }else{
                    startActivity(new Intent(context,ActivityWelcome.class));//没有显示过欢迎界面
                    sysConfig.setCustomConfig(ConfigConstant.IS_SHOW_WELCOME_PAGE, "1");
                    LogUtil.e(TAG, "NULL USER AND NULL SHOW");
                }
            }
        }
    }
}
