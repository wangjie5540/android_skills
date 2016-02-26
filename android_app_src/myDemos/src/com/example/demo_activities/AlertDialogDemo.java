package com.example.demo_activities;

import java.util.zip.Inflater;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.mydemos.R;

public class AlertDialogDemo extends Activity{
	private Context mContext = null;
	private Button btOpen = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alertdialog_activity);
		mContext = this;
		init();
	}

	private void init() {
		btOpen = (Button) findViewById(R.id.open_dialog);
		btOpen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				LayoutInflater inflater = LayoutInflater.from(mContext);
				View view = inflater.inflate(R.layout.dialog_view, null);
				AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogDemo.this);
				dialog.setView(view);
				dialog.show();
			}
		});
	};
}
