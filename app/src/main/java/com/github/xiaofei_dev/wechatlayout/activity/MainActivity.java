package com.github.xiaofei_dev.wechatlayout.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.github.xiaofei_dev.wechatlayout.R;
import com.github.xiaofei_dev.wechatlayout.custom_view.TabItem;
import com.github.xiaofei_dev.wechatlayout.custom_view.TabLayout;
import com.github.xiaofei_dev.wechatlayout.fragment.ContactsFragment;
import com.github.xiaofei_dev.wechatlayout.fragment.DiscoverFragment;
import com.github.xiaofei_dev.wechatlayout.fragment.ProfileFragment;
import com.github.xiaofei_dev.wechatlayout.fragment.WeChatFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabClickListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<TabItem> tabs;
    private ActionBar actionBar;
//    BaseFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    private void initView(){
        mTabLayout = (TabLayout)findViewById(R.id.tab_layout);
        mViewPager = (ViewPager)findViewById(R.id.viewPager);
        actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle(R.string.wechat);
        }
    }

    private void initDate(){
        tabs = new ArrayList<>();
        tabs.add(new TabItem(R.drawable.selector_tab_msg,R.string.fragment_we_chat
                ,WeChatFragment.class));
        tabs.add(new TabItem(R.drawable.selector_tab_contact,R.string.fragment_contacts
                , ContactsFragment.class));
        tabs.add(new TabItem(R.drawable.selector_tab_moments,R.string.fragment_discover
                , DiscoverFragment.class));
        tabs.add(new TabItem(R.drawable.selector_tab_profile,R.string.fragment_profile
                , ProfileFragment.class));

        mTabLayout.initData(tabs,this);
        mTabLayout.setCurrentTab(0);//默认当前的选中项目为第一个

        FragAdapter adapter = new FragAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
                actionBar.setTitle(tabs.get(position).lableResId);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    @Override
    public void onTabClick(TabItem tabItem) {
        actionBar.setTitle(tabItem.lableResId);
        mViewPager.setCurrentItem(tabs.indexOf(tabItem));
    }

    public class FragAdapter extends FragmentPagerAdapter{

        public FragAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public Fragment getItem(int position) {
            try {
                return tabs.get(position).tagFragmentClz.newInstance();
            }catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tabs.size();
        }
    }
}












