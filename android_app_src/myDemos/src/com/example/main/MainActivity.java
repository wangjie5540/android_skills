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
	private String[] allDemosArray = null; 
	private String[] allClassArray = null;
	private ArrayList<String> mListName = new ArrayList<String>();
	private ArrayList<String> mListClass = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		allDemosArray = getResources().getStringArray(R.array.mydemos_name_array);
		allClassArray = getResources().getStringArray(R.array.mydemos_class_array);
		ListView listView = new ListView(this);
		getData();
		listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, mListName));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int index,
					long arg3) {
				Toast.makeText(mContext, "index is " + index, Toast.LENGTH_SHORT).show();
				Intent intent = new Intent();
				Class<?> targetClass = null;
				try {
					targetClass = Class.forName(mListClass.get(index));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				intent.setClass(MainActivity.this, targetClass);
				startActivity(intent);
				overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
			}
		});
		setContentView(listView);
	}
	
	private void getData(){
		mListName.clear();
		mListClass.clear();
		for (String s : allDemosArray){
			mListName.add(s);
		}
		for (String c : allClassArray){
			mListClass.add(c);
		}
	}
}
