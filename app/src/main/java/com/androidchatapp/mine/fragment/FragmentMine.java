package com.androidchatapp.mine.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.androidchatapp.Login;
import com.androidchatapp.R;
import com.androidchatapp.base.BaseFragment;
import com.androidchatapp.index.activity.NewsListActivity;
import com.androidchatapp.main.MainActivity;
import com.androidchatapp.mine.activity.UserInfoActivity;
import com.androidchatapp.util.UserinfoManager;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Request;




public class FragmentMine extends BaseFragment {


    @BindView(R.id.llaboutus)
    public LinearLayout lin4;

    private String sunMall = "0";
    public static final int REQUEST_CODE_EDIT_INFO = 4;

    public UserinfoManager userinfoManager;
    private String info1, info2, info3;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView() {
        userinfoManager = userinfoManager.getInstance(FragmentMine.this.getContext());


        info1 = userinfoManager.getName();
        info3 = userinfoManager.getPhone();

    }

    @Override
    public void setListener() {

    }

    @Override
    public void onResume() {
        super.onResume();
    }



    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @OnClick({R.id.llaboutus, R.id.lin_info, R.id.lin_news})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.llaboutus:
                Intent intent1 = new Intent(context, Login.class);
                startActivity(intent1);
                break;
            case R.id.lin_info:
                Intent intent2 = new Intent(context, UserInfoActivity.class);
                startActivity(intent2);
                break;
            case R.id.lin_news:
                Intent intent3 = new Intent(context, NewsListActivity.class);
                startActivity(intent3);
                break;


        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(FragmentMine.class);
    }

}
