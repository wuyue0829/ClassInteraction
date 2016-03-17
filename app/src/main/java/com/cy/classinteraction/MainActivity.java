package com.cy.classinteraction;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.TimerTask;

/**
 * 应用起始页面
 * 将在这个页面完成以下的操作
 * 1、设置点击进入页面时白屏几秒钟的画面；（好多的应用并没有处理开始界面白屏的问题，故这个地方可以先不考虑）
 * 2、判断是否第一次进入程序，做相对应的操作；
 * 3、获取屏幕的宽和高写入到配置文件
 */
public class MainActivity extends AppCompatActivity {


    private ViewPager vp_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 写一个定时器在几秒后执行跳转操作
     */
    class Task extends TimerTask{

        @Override
        public void run() {
            DisplayMetrics metric = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metric);


        }
    }
}
