package com.yanis.yc_ui_fragment_menu;

import com.yanis.yc_ui_fragment_menu.ViewIndicator.OnIndicateListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MainActivity extends FragmentActivity {
	 public static Fragment[] mFragments;  
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setFragmentIndicator(0);  
	}
	
	 /** 
     * 初始化fragment 
     */  
    private void setFragmentIndicator(int whichIsDefault) { 
    	//实例化 Fragment 集合
    	 mFragments = new Fragment[5];  
         mFragments[0] = getSupportFragmentManager().findFragmentById(R.id.fragment_home);  
         mFragments[1] = getSupportFragmentManager().findFragmentById(R.id.fragment_category);  
         mFragments[2] = getSupportFragmentManager().findFragmentById(R.id.fragment_down);  
         mFragments[3] = getSupportFragmentManager().findFragmentById(R.id.fragment_user);  
         mFragments[4] = getSupportFragmentManager().findFragmentById(R.id.fragment_setting);  
         //显示默认的Fragment
         getSupportFragmentManager().beginTransaction().hide(mFragments[0])  
                 .hide(mFragments[1]).hide(mFragments[2]).hide(mFragments[3]).hide(mFragments[4]).show(mFragments[whichIsDefault]).commit(); 
         //绑定自定义的菜单栏组件
    	ViewIndicator mIndicator = (ViewIndicator) findViewById(R.id.indicator);  
    	ViewIndicator.setIndicator(whichIsDefault);  
        mIndicator.setOnIndicateListener(new OnIndicateListener() {  
            @Override  
            public void onIndicate(View v, int which) {  
            	//显示指定的Fragment
            	  getSupportFragmentManager().beginTransaction()  
                  .hide(mFragments[0]).hide(mFragments[1])  
                  .hide(mFragments[2]).hide(mFragments[3]).hide(mFragments[4]).show(mFragments[which]).commit(); 
            }  
        });  
    }  
}
