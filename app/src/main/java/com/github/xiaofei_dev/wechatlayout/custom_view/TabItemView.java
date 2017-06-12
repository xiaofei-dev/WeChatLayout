package com.github.xiaofei_dev.wechatlayout.custom_view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.xiaofei_dev.wechatlayout.R;

/**
 * Created by xiaofei on 2017/6/8.
 */

public class TabItemView extends LinearLayout implements View.OnClickListener {

    private ImageView mTabImage;
    private TextView mTabLable;

    public TabItemView(Context context) {
        super(context);
        initView(context);
    }

    public TabItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TabItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){

        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);

        LayoutInflater.from(context).inflate(R.layout.tab_item,this,true);

        mTabImage = (ImageView)findViewById(R.id.tab_image);
        mTabLable = (TextView)findViewById(R.id.tab_lable);
    }

    @Override
    public void onClick(View v) {

    }

    public void initDate(TabItem tabItem){
        mTabImage.setImageResource(tabItem.imageResId);
        mTabLable.setText(tabItem.lableResId);
    }

    public void onDataChanged(int badgeCount){
        //  TODO notify new message, change the badgeView
    }



}
