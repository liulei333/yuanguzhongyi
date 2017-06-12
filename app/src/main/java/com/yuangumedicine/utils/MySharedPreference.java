package com.yuangumedicine.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 *
 * Created by starwrap on 2017/4/11.
 */

public class MySharedPreference {

    private SharedPreferences sp;
    private static MySharedPreference preManager;

    public MySharedPreference(Context context){
        sp=context.getSharedPreferences("CITY", MODE_PRIVATE);
    }


    public static synchronized MySharedPreference instance(Context context) {
        if (preManager == null)
            preManager = new MySharedPreference(context);
        return preManager;
    }

    public String getUserName() {
       return sp.getString("userName","");
    }

    public void setUserName(String userName) {
        sp.edit().putString("userName", userName).commit();
    }

    public void  setUserToken(String userToken){
        sp.edit().putString("userToken", userToken).commit();
    }
    public String getUserToken() {

        return sp.getString("userToken","");
    }
}
