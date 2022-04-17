package com.androidchatapp.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.zhy.http.okhttp.OkHttpUtils;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    public Context context;
    public Activity curActivity;
    private Dialog singleOnDialog;
    private Button confirm;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttachContext(context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        curActivity = activity;
        onAttachContext(activity);

    }

    private void onAttachContext(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        ButterKnife.bind(this, view);

        initView();
        setListener();
        return view;
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void setListener();

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(this);
    }
}
