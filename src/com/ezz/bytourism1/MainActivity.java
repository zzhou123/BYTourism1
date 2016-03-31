package com.ezz.bytourism1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.R.anim;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {
	private TextView textcity;
	private Spinner spinner;
	private List<String>list;
    private ArrayAdapter<String>adapter;
	private ImageView imagefirst;
	private final static int CWJ_HEAP_SIZE = 6* 1024* 1024 ;
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
    	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose1);
		imagefirst = (ImageView) findViewById(R.id.imagefirst);
		
/*		InputStream is1 = this.getResources().openRawResource(R.drawable.home_one);
		BitmapFactory.Options options1 = new BitmapFactory.Options();
		options1.inJustDecodeBounds = false;
		options1.inSampleSize = 100;
		Bitmap btp1 = BitmapFactory.decodeStream(is1,null, options1);
		
		InputStream is2 = this.getResources().openRawResource(R.drawable.home_two);
		BitmapFactory.Options options2 = new BitmapFactory.Options();
		options2.inJustDecodeBounds = false;
		options2.inSampleSize = 10;
		Bitmap btp2 = BitmapFactory.decodeStream(is2,null, options2);
		*/
//		textcity = (TextView)findViewById(R.id.textcity);
		spinner=(Spinner)findViewById(R.id.spinner1);
		
		list=new ArrayList<String>();
		list.add("北京");
		list.add("上海");
		list.add("厦门");
		
		adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
/*		if(!btp1.isRecycled()){
			btp1.recycle();
			System.gc();
		}*/
		
	}
}
