package com.github.xiaofei_dev.wechatlayout.custom_view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by xiaofei on 2017/6/8.
 * desc:底栏容器
 */

public class TabLayout extends LinearLayout implements View.OnClickListener {

    private ArrayList<TabItem> tabs;
    private OnTabClickListener listener;
    private View selectView;
    private int tabCount;

    public TabLayout(Context context) {
        super(context);
        initView();
    }

    public TabLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TabLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }
    private void initView(){
        setOrientation(HORIZONTAL);
    }

    //设置当前被选中的 Tab
    public void setCurrentTab(int i){
        if(i < tabCount && i >= 0){
            View view = getChildAt(i);
            if(selectView != view){
                view.setSelected(true);
                if(selectView != null){
                    selectView.setSelected(false);
                }
                selectView = view;
            }
        }
    }

    public void onDataChanged(int i,int badgeCount){
        if(i < tabCount && i >= 0){
            TabItemView view = (TabItemView)getChildAt(i);
            view.onDataChanged(badgeCount);
        }
    }

    public void initData(ArrayList<TabItem> tabs,OnTabClickListener listener){
        this.tabs = tabs;
        this.listener = listener;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        if(tabs != null && tabs.size() > 0){
            tabCount = tabs.size();
            TabItemView tabItemView = null;
            for(int i = 0;i < tabs.size();i++){
                tabItemView = new TabItemView(getContext());
                tabItemView.setTag(tabs.get(i));
                tabItemView.initDate(tabs.get(i));
                tabItemView.setOnClickListener(this);
                addView(tabItemView,params);
            }
        }else {
            throw new IllegalArgumentException("tabs can not be empty");
        }
    }


    @Override
    public void onClick(View v) {
        listener.onTabClick((TabItem)(v.getTag()));
    }

    public interface OnTabClickListener{
        void onTabClick(TabItem tabItem);
    }
}
