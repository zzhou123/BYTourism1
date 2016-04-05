package com.ezz.test;

import java.io.File;

import com.ezz.bytourism1.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class Test extends Activity{
	ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timage);
		imageView = (ImageView) findViewById(R.id.imageView);
		Object data = "./image/xiamen_three.jpg";
		String str = data.toString();
		File file = new File(str);
		Log.i("aaa",file.exists()+"");
		
	}
}
