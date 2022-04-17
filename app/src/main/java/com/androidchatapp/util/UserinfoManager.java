package com.androidchatapp.util;

import android.content.Context;
import android.content.SharedPreferences;

public class UserinfoManager {

    private static UserinfoManager tokenManager;
    private SharedPreferences sharedPreferences;

    private static final String USERID = "userid";
    private static final String NAME = "name";
    private static final String SEX = "sex";
    private static final String PHONE = "phone";
    private static final String COUNTRY = "Country";
    private static final String BUDGET = "Budget";
    private static final String EMAIL = "email";


    public static synchronized UserinfoManager getInstance(Context context) {
        if (tokenManager == null) {
            tokenManager = new UserinfoManager(context);
        }
        return tokenManager;
    }

    private UserinfoManager(Context context) {
        sharedPreferences = context.getSharedPreferences("userid", Context.MODE_PRIVATE);
    }


    public String getUserid() {
        return sharedPreferences.getString(USERID, "");
    }

    public void setUserid(String tongZhiToken) {
        sharedPreferences.edit().putString(USERID, tongZhiToken).commit();
    }
    public String getName() {
        return sharedPreferences.getString(NAME, "");
    }

    public void setName(String tongZhiToken) {
        sharedPreferences.edit().putString(NAME, tongZhiToken).commit();
    }
    public String getSex() {
        return sharedPreferences.getString(SEX, "");
    }

    public void setSex(String tongZhiToken) {
        sharedPreferences.edit().putString(SEX, tongZhiToken).commit();
    }
    public String getPhone() {
        return sharedPreferences.getString(PHONE, "");
    }

    public void setPhone(String tongZhiToken) {
        sharedPreferences.edit().putString(PHONE, tongZhiToken).commit();
    }
    public String getCountry() {
        return sharedPreferences.getString(COUNTRY, "");
    }

    public void setCountry(String tongZhiToken) {
        sharedPreferences.edit().putString(COUNTRY, tongZhiToken).commit();
    }
    public String getBudget() {
        return sharedPreferences.getString(BUDGET, "");
    }

    public void setBudget(String tongZhiToken) {
        sharedPreferences.edit().putString(BUDGET, tongZhiToken).commit();
    }
    public String getEmail() {
        return sharedPreferences.getString(EMAIL, "");
    }

    public void setEmail(String tongZhiToken) {
        sharedPreferences.edit().putString(EMAIL, tongZhiToken).commit();
    }


}
