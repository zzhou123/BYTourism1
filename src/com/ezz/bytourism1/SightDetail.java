package com.ezz.bytourism1;

import java.util.List;

import com.ezz.bean.Scenic;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SightDetail extends Activity{
	private ImageView sight_view;
	private TextView sight_describe;
	private EditText sight_my_message;
	private TextView sight_all_message;
	private String sight_name;
	private String sight_price;
	private String sight_type;
	private Button back_btn;
	private TextView city_name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sight_detail);
		Bmob.initialize(SightDetail.this, "a1a4ff643e92be99bb8649e33589c596");
		Intent searchIntent = getIntent();
		
		sight_name = searchIntent.getStringExtra("sight_name");
		sight_type = searchIntent.getStringExtra("sight_type");
		sight_price = searchIntent.getStringExtra("sight_price");
		
		Toast.makeText(this, "name = "+sight_name+"type = "+sight_type+"price = "+sight_price, Toast.LENGTH_SHORT).show();
		showView();
		city_name = (TextView) findViewById(R.id.city_name);
		city_name.setText(sight_name);
		
		sight_view = (ImageView) findViewById(R.id.sight_view);
		sight_describe = (TextView) findViewById(R.id.TextView);
		sight_my_message = (EditText) findViewById(R.id.sight_my_message);
		sight_all_message = (TextView) findViewById(R.id.sight_all_message);
		back_btn = (Button) findViewById(R.id.back_btn);
		back_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
	}
	Handler handler = new Handler(){
		@Override
		public void handleMessage(android.os.Message msg) {
			// TODO 自动生成的方法存根
			switch (msg.what) {
			case 1:
			    	Toast.makeText(SightDetail.this, msg.obj.toString()+"||||||||",Toast.LENGTH_SHORT).show();
					//sight_describe.setText(msg.obj+" ");
				break;

			default:
				break;
			}
			super.handleMessage(msg);
		}
	};
	public void showView(){
		BmobQuery<Scenic> query_scenic = new BmobQuery<Scenic>();
		query_scenic.addWhereEqualTo("scenicname",sight_name);
		query_scenic.findObjects(SightDetail.this, new FindListener<Scenic>() {
			@Override
			public void onSuccess(List<Scenic> scenics) {
				// TODO 自动生成的方法存根
				for(Scenic scenic:scenics){
					Message msg = new Message();
					msg.what = 1;
					msg.obj = scenic.getDescribe();
					handler.sendMessage(msg);
				}
			}
			@Override
			public void onError(int arg0, String arg1) {
				// TODO 自动生成的方法存根
				
			}
		});
	}
}
