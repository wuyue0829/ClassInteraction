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
    private final static SysConfig getSysConfig(Context context){
        if(sysConfig == null){
            sysConfig = new SysConfig(context);
        }
        return sysConfig;
    }


}
