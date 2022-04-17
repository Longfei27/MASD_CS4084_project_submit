package com.androidchatapp.util;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {

    private static UserManager tokenManager;
    private SharedPreferences sharedPreferences;

    private static final String NAME = "username";
    private static final String CHATWITH = "chatwith";


    public static synchronized UserManager getInstance(Context context) {
        if (tokenManager == null) {
            tokenManager = new UserManager(context);
        }
        return tokenManager;
    }

    private UserManager(Context context) {
        sharedPreferences = context.getSharedPreferences("username", Context.MODE_PRIVATE);
    }


    public String getName() {
        return sharedPreferences.getString(NAME, "");
    }

    public void setName(String tongZhiToken) {
        sharedPreferences.edit().putString(NAME, tongZhiToken).commit();
    }
    public String getChatwith() {
        return sharedPreferences.getString(CHATWITH, "");
    }

    public void setChatwith(String tongZhiToken) {
        sharedPreferences.edit().putString(CHATWITH, tongZhiToken).commit();
    }




}
