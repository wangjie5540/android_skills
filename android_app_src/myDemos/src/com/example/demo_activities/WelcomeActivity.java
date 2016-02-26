package com.example.demo_activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.main.MainActivity;
import com.example.mydemos.R;

public class WelcomeActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_activity);
		new Handler(new Handler.Callback() {
			
			@Override
			public boolean handleMessage(Message msg) {
				Intent intent = new Intent();
				intent.setClass(WelcomeActivity.this, MainActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
				finish();
				return false;
			}
		}).sendEmptyMessageDelayed(0, 2000);
	}
}
