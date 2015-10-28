package com.example.main;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Context mContext = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		//获取ListView对象
		ListView listView = new ListView(this);
		//设置数据、布局、context
		listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, getData()));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int index,
					long arg3) {
				Toast.makeText(mContext, "index is " + index, Toast.LENGTH_SHORT).show();
				switch (index) {
				case 1:
					
					break;

				default:
					break;
				}
			}
		});
		setContentView(listView);
	}
	
	private List<String> getData(){
		List<String> list = new ArrayList<String>();
		list.add("Utils类的使用"); //1
		list.add("数据2");
		list.add("数据3");
		list.add("数据4");
		list.add("数据5");
		list.add("数据6");
		list.add("数据6");
		list.add("数据6");
		list.add("数据6");
		list.add("数据6");
		
		return list;
	}
}
