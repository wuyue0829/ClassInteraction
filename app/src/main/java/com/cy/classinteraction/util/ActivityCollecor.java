package com.cy.classinteraction.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;


public class ActivityCollecor {

	//初始化Activity list
	public static List<Activity> acticities = new ArrayList<Activity>();

	//添加activity到list中
	public static void addActivity(Activity activity){
		acticities.add(activity);
	}

	//从当前list中删除activity
	public static void removeActivity(Activity activity){
		acticities.remove(activity);
	}

	/**
	 * 关闭所有的activity，用于退出程序时使用
	 */
	public static void finishAll(){
		for(Activity activity2:acticities){
			if(! activity2.isFinishing()){
				activity2.finish();
			}
		}
	}
}
