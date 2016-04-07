package com.ezz.bytourism1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 37492 on 2016/4/7.
 */
public class MyCollectActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_collect);
//        TextView username = (TextView)findViewById(R.id.nameview);
//        TextView userid = (TextView)findViewById(R.id.idview);
//        username.setText(getPreferenceName());
//        userid.setText("365354"+getPreferenceId());
    }
    public void turnToRoutes(View v){
        Intent intent = new Intent(MyCollectActivity.this,RoutesCollectActivity.class);
        startActivity(intent);
    }

}
