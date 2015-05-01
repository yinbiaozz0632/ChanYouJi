package com.qianfeng.chanyouji;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qianfeng.chanyouji.fragment.DestinationFragment;
import com.qianfeng.chanyouji.fragment.SubjectFragment;
import com.qianfeng.chanyouji.fragment.TravelNotesFragment;
import com.qianfeng.chanyouji.netutils.BitmapHelper;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    private static boolean isExit=false;
    private List<Fragment> fragments;
    private ViewPager viewPager;
    private RadioGroup rg;
    private MainViewPagerAdapter adapter;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1) {
                isExit=false;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();//初始化
    }

    /**
     * 初始化fragment集合
     */
    private void init() {

        BitmapHelper.initBitmapUtils(this);//初始化BitMapUtils
        fragments = new ArrayList<Fragment>();//初始化fragment
        fragments.add(new TravelNotesFragment());
        fragments.add(new SubjectFragment());
        fragments.add(new DestinationFragment());

        viewPager = ((ViewPager) findViewById(R.id.mainViewPager));
        rg = ((RadioGroup) findViewById(R.id.main_RadioGroup));
        ((RadioButton) rg.getChildAt(0)).setChecked(true);//默认讲第一个设置为true
        adapter = new MainViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(this);

        rg.setOnCheckedChangeListener(this);//radioButton的点击监听


    }

    //viewPager的滑动监听

    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int position) {
        ((RadioButton) rg.getChildAt(position)).setChecked(true);//滑动时rb的背景图随之改变
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    //点击radioButton之后ViewPager跟着滑动
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        for (int i = 0; i < rg.getChildCount(); i++) {
            if (rg.getChildAt(i).getId() == checkedId) {
                viewPager.setCurrentItem(i);
            }
        }
    }


    /**
     * fragment的适配器
     */
    class MainViewPagerAdapter extends FragmentPagerAdapter {


        public MainViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        exit();

    }

    private void exit() {
        if (!isExit) {
            Toast.makeText(MainActivity.this,"再按一次退出应用程序",Toast.LENGTH_SHORT).show();
            isExit=true;
            handler.sendEmptyMessageDelayed(1,2000);
        }else{
            finish();
            System.exit(0);
        }
    }
}
