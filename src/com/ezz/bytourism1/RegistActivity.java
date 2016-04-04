package com.ezz.bytourism1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by 37492 on 2016/4/4.
 */
public class RegistActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO ??????????????
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist);


        String userId = getPreference(USER_ID);
        if(userId.isEmpty()){
            Toast.makeText(RegistActivity.this, "没有获取到USER_ID", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(RegistActivity.this, userId, Toast.LENGTH_SHORT).show();
        }
    }
}
