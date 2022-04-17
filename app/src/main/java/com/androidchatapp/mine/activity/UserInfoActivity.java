package com.androidchatapp.mine.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.androidchatapp.R;
import com.androidchatapp.base.BaseActivity;
import com.androidchatapp.util.UserinfoManager;

import org.json.JSONStringer;

import butterknife.BindView;
import butterknife.OnClick;


public class UserInfoActivity extends BaseActivity {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.sex)
    EditText sex;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.Country)
    EditText Country;
    @BindView(R.id.Budget)
    EditText Budget;
    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.btnFinish)
    Button btnfinish;
    private String info_name, info_sex, info_phone, info_Country, info_Budget, info_email;
    private String info1, info2, info3,info4,info5,info6;
    private JSONStringer js;

    public UserinfoManager userinfoManager;


    @Override
    public int getLayoutId() {
        return R.layout.activity_userinfo;
    }

    @Override
    public void initView() {
        userinfoManager = userinfoManager.getInstance(this.getApplicationContext());

        info1 = userinfoManager.getName();
        info2 = userinfoManager.getSex();
        info3 = userinfoManager.getPhone();
        info4 = userinfoManager.getCountry();
        info5 = userinfoManager.getBudget();
        info6 = userinfoManager.getEmail();
        if (info1 != null) {
            name.setText(info1);
        }
        if (info2 != null) {
            sex.setText(info2);
        }
        if (info3 != null) {
            phone.setText(info3);
        }
        if (info4 != null) {
            Country.setText(info4);
        }
        if (info5 != null) {
            Budget.setText(info5);
        }
        if (info6 != null) {
            email.setText(info6);
        }


    }

    @Override
    public void setListener() {

    }

    @OnClick({R.id.btnFinish})
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnFinish:
                info_name = name.getText().toString();
                info_sex = sex.getText().toString();
                info_phone = phone.getText().toString();
                info_Country = Country.getText().toString();
                info_Budget = Budget.getText().toString();
                info_email = email.getText().toString();

                if (info_name.isEmpty()) {
                    ShowToast("Please enter name");
                    return;
                }
                if (info_sex.isEmpty()) {
                    ShowToast("Please enter sex");
                    return;
                }
                if (info_phone.isEmpty()) {
                    ShowToast("Please enter phone");
                    return;
                }
                if (info_Country.isEmpty()) {
                    ShowToast("Please enter height");
                    return;
                }
                if (info_Budget.isEmpty()) {
                    ShowToast("Please enter weight");
                    return;
                }
                if (info_email.isEmpty()) {
                    ShowToast("Please enter email");
                    return;
                }
                register();
//                registerByInviteCode();
//                doRegister();
                break;
        }
    }

    private void register() {
        userinfoManager.setName(info_name);
        userinfoManager.setSex(info_sex);
        userinfoManager.setPhone(info_phone);
        userinfoManager.setCountry(info_Country);
        userinfoManager.setBudget(info_Budget);
        userinfoManager.setEmail(info_email);
        finish();
    }

}
