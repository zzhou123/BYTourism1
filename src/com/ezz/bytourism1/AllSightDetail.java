package com.ezz.bytourism1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;

import com.ezz.bean.Scenic;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class AllSightDetail extends Activity{
	private Button btn_back;
	private AutoCompleteTextView edit_Search1;
	private List<String> city_list;
 	private ArrayAdapter<String> adapter;
 	private ListView city_listview;
 	private SimpleAdapter sadapter;
 	private List<Map<String,Object>> dataList;
 	private Map<integer, Map<String,Object>> a;
	@Override
 	protected void onCreate(Bundle savedInstanceState) {
 		// TODO 自动生成的方法存根
 		super.onCreate(savedInstanceState);
 		setContentView(R.layout.allsightdetail);
 		btn_back = (Button) findViewById(R.id.btn_back);
 		edit_Search1 = (AutoCompleteTextView) findViewById(R.id.edit_Search1);
 		city_listview = (ListView) findViewById(R.id.city_listview);
 		city_list = new ArrayList<String>();
 		dataList = new ArrayList<Map<String,Object>>();
 		Map<String,Object> map = new HashMap<String,Object>();
 		map.put("name1", "lucy");
 		map.put("name2", "dawei");
 		map.put("name3", "lucy");
 		map.put("name4", 3);
 		map.put("name4",city_list);
 		map.get("name1");
 		city_list.add("北京");
 		city_list.add("上海");
 		city_list.add("厦门");
 		city_list.add("广州");
 		city_list.add("云南");
 		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, city_list);
 	//	sadapter = new SimpleAdapter(this, getData(), resource, from, to);
 		edit_Search1.setAdapter(adapter);
 		edit_Search1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				// TODO 自动生成的方法存根
				if(actionId==EditorInfo.IME_ACTION_SEND||(event!=null&&event.getKeyCode()==KeyEvent.KEYCODE_ENTER)){
					Toast.makeText(AllSightDetail.this, "开始搜索", Toast.LENGTH_SHORT).show();
					getData();
					return true;
				}
				return false;
			}

			private void query() {
				// TODO 自动生成的方法存根
				
			}
			
		});
 		btn_back.setOnClickListener(new OnClickListener() {  
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(AllSightDetail.this,MainActivity.class);
				startActivity(intent);
			}
		});
 		
 	}
	private List<Map<String,Object>> getData() {
		
		// TODO 自动生成的方法存根
/*		for(int i = 0;i<20;i++){
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("pic", R.drawable.ic_launcher);
			map.put("text", "慕课网"+i);
			dataList.add(map);
			
		}
		return dataList;*/
		//BmobQuery<Scenic> 
		return dataList;
	}
	
}
