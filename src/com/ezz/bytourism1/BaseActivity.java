package com.ezz.bytourism1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * Created by johnchen on 16/4/4.
 */
public class BaseActivity  extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO
        super.onCreate(savedInstanceState);

    }

    // 记录的电话号码
    private String phoneNum;
    /**
     * 将此次登陆的账户信息存储下来
     * */
    private void saveAccount(String phoneNum) {
        // 获取SharedPreference
        SharedPreferences preference = getSharedPreferences("login_info",
                MODE_PRIVATE);
        // 获取editor
        SharedPreferences.Editor editor = preference.edit();
        // 存入数据
        editor.putString("phoneNum", phoneNum);
        // 提交存入文件中
        editor.commit();
    }
    /**
     * 获取存入SharedPreference中的账户
     *
     * @return
     * */
    private void getAccount() {
        // 获取SharedPreference
        SharedPreferences preference = getSharedPreferences("login_info",
                MODE_PRIVATE);
        // 获取存在SharedPreference中的用户名
        phoneNum = preference.getString("phoneNum", "");

    }
}
