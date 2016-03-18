package com.cy.classinteraction;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyue on 2016/3/18.
 */
public class ActivityWelcome extends Activity implements View.OnClickListener{

    private List<View> viewList;
    private ViewPager welcome_viewpager;
    private Button but_welcome_guide;
    private static int[] pageID = {R.mipmap.guide_01,R.mipmap.guide_01,R.mipmap.guide_01};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
        initViewPage();
    }

    /**
     * 初始化空间和内容
     */
    public void initViewPage(){
        welcome_viewpager = (ViewPager) findViewById(R.id.welcome_viewpager);
        but_welcome_guide = (Button) findViewById(R.id.but_welcome_guide);
        viewList = new ArrayList<View>();
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(pageID[0]);
        viewList.add(imageView);
        ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(pageID[1]);
        viewList.add(imageView1);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(pageID[2]);
        viewList.add(imageView2);

        but_welcome_guide.setOnClickListener(this);

        //设置viewpage适配器
        welcome_viewpager.setAdapter(new MypagerAdapter());
        //设置监听
        welcome_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 2){
                    but_welcome_guide.setVisibility(View.VISIBLE);
                }else{
                    but_welcome_guide.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.but_welcome_guide:
                Toast.makeText(this,"进入下一页",Toast.LENGTH_LONG).show();
                break;
        }
    }

    //Apater适配器
    class MypagerAdapter extends PagerAdapter {
        //计算需要多少个item
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        //销毁页卡
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            container.removeView(viewList.get(position));
        }
    }
}
