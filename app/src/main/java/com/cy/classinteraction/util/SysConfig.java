package com.cy.classinteraction.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wuyue on 2016/3/17.
 * 存放各种系统参数
 */
public class SysConfig {

    private final static String SYS_PAMS = "";
    private SharedPreferences config;
    private static SysConfig sysConfig = null;

    private SysConfig(Context context){
        config = context.getSharedPreferences(SYS_PAMS,0);
    }

    /**
     * 单例模式
     * @param context
     * @return
     */
    public final static SysConfig getSysConfig(Context context){
        if(sysConfig == null){
            sysConfig = new SysConfig(context);
        }
        return sysConfig;
    }

    /***
     * 设置自定义配置信息
     * @param custom_action
     * @param info  配置内容
     * @return
     */
    public void setCustomConfig(String custom_action,String info){
        config.edit().putString(custom_action, info).commit();
    }
    /***
     * 获取自定义配置信息
     * @return
     */
    public String getCustomConfig(String custom_action,String defaultStr){
        return config.getString(custom_action, defaultStr);
    }

    /***
     * 写入屏幕的宽度
     * @return
     */
    public void setScreenWidth(int windth){
        config.edit().putInt("screenWidth", windth).commit();
    }

}
