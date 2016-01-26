package com.example.jni_demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.mydemos.R;

public class NativeTest extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jni_demo);
		Log.d("wangjie", "" + this);
		NativeCenter.getInstance().void_call(this);
		NativeCenter.getInstance().void_call(this);
	}
}
