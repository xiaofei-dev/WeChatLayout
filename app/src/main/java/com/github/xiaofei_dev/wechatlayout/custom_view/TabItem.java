package com.github.xiaofei_dev.wechatlayout.custom_view;

import com.github.xiaofei_dev.wechatlayout.fragment.BaseFragment;

/**
 * Created by xiaofei on 2017/6/8.
 * desc:bean 类
 */

public class TabItem {
    /**
     * icon
     */
    public int imageResId;
    /**
     * 文本
     */
    public int lableResId;

    public Class<? extends BaseFragment> tagFragmentClz;

    public TabItem(int imageResId, int lableResId) {
        this.imageResId = imageResId;
        this.lableResId = lableResId;
    }

    public TabItem(int imageResId, int lableResId, Class<? extends BaseFragment> tagFragmentClz) {
        this.imageResId = imageResId;
        this.lableResId = lableResId;
        this.tagFragmentClz = tagFragmentClz;
    }
}
