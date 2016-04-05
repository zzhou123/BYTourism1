package com.ezz.bytourism1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by 37492 on 2016/4/5.
 */
public class Choose1Activity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose1);
    }
    public void turnToPersonal(View view){
        Intent intent = new Intent(Choose1Activity.this,Personal_centerActivity.class);
        startActivity(intent);
    }
}
