package com.github.xiaofei_dev.wechatlayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by xiaofei on 2017/6/8.
 * desc:延迟加载数据
 */

public abstract class BaseFragment extends Fragment {

    //视图是否已创建
    protected boolean isViewInitiated;
    //视图是否已可见
    protected boolean isVisibleToUser;
    //数据是否已加载
    protected boolean isDataInitiated;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        prepareFetchData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareFetchData();
    }

    public abstract void fetchData();

    public boolean prepareFetchData(){
        return prepareFetchData(false);
    }

    public boolean prepareFetchData(boolean forceUpdate){
        if(isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)){
            fetchData();
            isDataInitiated = true;
            return true;
        }
        return false;
    }
}















