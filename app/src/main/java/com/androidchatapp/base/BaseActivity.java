package com.androidchatapp.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;


import com.androidchatapp.util.ToastUtil;
import com.zhy.http.okhttp.OkHttpUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends Activity {


    private Unbinder unbinder;

    private Button confirm;
    public Context context;
    public Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        activity = this;
        com.androidchatapp.base.AppManager.getAppManager().addActivity(this);
        setContentView(getLayoutId());
//        setImmerseBar();
        unbinder = ButterKnife.bind(this);
        initView();
        setListener();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.fontScale != 1) {
            getResources();
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if (res.getConfiguration().fontScale != 1) {
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();
            res.updateConfiguration(newConfig, res.getDisplayMetrics());
        }
        return res;
    }


    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void setListener();



    public void ShowToast(String msg) {
        ToastUtil.ShowToast(this, msg);
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        OkHttpUtils.getInstance().cancelTag(this);
        AppManager.getAppManager().finishActivity(this);
        unbinder.unbind();
    }
}
