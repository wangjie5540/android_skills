package com.example.main;

import java.util.ArrayList;
import java.util.List;

import com.example.demo_activities.UsageForUtils;
import com.example.jni_demo.NativeCenter;
import com.example.jni_demo.NativeTest;
import com.example.mydemos.R;

import android.app.Activity;
import android.app.NativeActivity;
import android.content.Context;
import android.content.Intent;
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
	private String[] allDemos = null; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		allDemos = getResources().getStringArray(R.array.mydemos_name_array);
		ListView listView = new ListView(this);
		listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, getData()));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int index,
					long arg3) {
				Toast.makeText(mContext, "index is " + index, Toast.LENGTH_SHORT).show();
				Intent intent = new Intent();
				switch (index) {
				case 0:
					intent.setClass(MainActivity.this, UsageForUtils.class);
					break;
				case 3:
					intent.setClass(MainActivity.this, NativeTest.class);
					break;

				default:
					intent.setClass(MainActivity.this, UsageForUtils.class);
					break;
				}
				startActivity(intent);
			}
		});
		setContentView(listView);
	}
	
	private List<String> getData(){
		List<String> list = new ArrayList<String>();
		for (String s : allDemos){
			list.add(s);
		}
		
		return list;
	}
}
