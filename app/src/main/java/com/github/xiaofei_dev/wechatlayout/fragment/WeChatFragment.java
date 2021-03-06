package com.github.xiaofei_dev.wechatlayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.xiaofei_dev.wechatlayout.R;

/**
 * Created by xiaofei on 2017/6/8.
 */

public class WeChatFragment extends BaseFragment {
    private static final String TAG = "WeChatFragment";
    private TextView mTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout,container,false);
        mTextView = (TextView) view.findViewById(R.id.text);
        mTextView.setText(R.string.fragment_we_chat);
        return view;
    }

    @Override
    public void fetchData() {
//        mTextView.setText(R.string.fragment_we_chat);
    }
}
