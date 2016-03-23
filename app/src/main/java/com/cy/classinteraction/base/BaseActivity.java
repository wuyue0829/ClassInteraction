package com.cy.classinteraction.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.cy.classinteraction.R;
import com.cy.classinteraction.util.SysConfig;

/**
 * Created by wuyue on 2016/3/17.
 */
public class BaseActivity extends Activity{


    protected Context mContext ;
    protected SysConfig sysConfig;
    protected FrameLayout mainLayout ;  //整个窗体的布局
    protected LayoutInflater mInflater ;
    protected TextView titleText ;	   //标题
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base);
        sysConfig = SysConfig.getSysConfig(this);
        mContext = this;
        mInflater = LayoutInflater.from(mContext);
        mainLayout = (FrameLayout) findViewById(R.id.main_layout);
        titleText = (TextView) findViewById(R.id.tv_head_title);
    }

    /**
     * 添加自己的布局文件
     * @param 布局文件ID
     * @return 该布局VIEW
     */
    public View setContentView2Base(int layoutID){
        View contentView = mInflater.inflate(layoutID, null);
        mainLayout.addView(contentView);
        return contentView;
    }

    /**
     * 添加自己的布局文件
     * @param contentView  自定义VIEW
     */
    public void setContentView2Base(View contentView){
        mainLayout.addView(contentView);
    }

    /*** 设置标题
     * @param title
     */
    public void setTitle(String title){
        titleText.setText(title);
    }

    /***  设置标题
     * @param stringID 资源id
     * */
    @Override
    public void setTitle(int stringID){
        titleText.setText(stringID);
    }

    /**
     * 页面跳转
     */
    protected void close(){
        this.finish();
    }
}
