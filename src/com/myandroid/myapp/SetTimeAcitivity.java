package com.myandroid.myapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetTimeAcitivity extends Activity {
	Button saveBtn;
	EditText stopTime;
	EditText startTime;
	SharedPreferences sp;
	SharedPreferences.Editor edit;
	private int start;
	private int stop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settime);
		sp = getSharedPreferences("settime", 1);
		findView();
		saveBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(start > 100|| start<0||stop>100||stop<0){
					Toast.makeText(SetTimeAcitivity.this, "设置 时间不在范围内", Toast.LENGTH_SHORT).show();
					return;
				}
				Intent intent = new Intent(SetTimeAcitivity.this,
						ShuziyinyuMainActivity.class);
				start = Integer.parseInt(startTime.getText().toString());
				 stop = Integer.parseInt(stopTime.getText().toString());
				
				edit = sp.edit();
				edit.putInt("startTime", stop);
				edit.putInt("startResponse", start);
				edit.commit();
				Bundle b = new Bundle();
				b.putInt("startTime", stop);
				b.putInt("startResponse",start);
				startActivity(intent.putExtras(b));
			}
			
		});
	}
	public  void findView(){
		saveBtn = (Button)super.findViewById(R.id.timebtn);
		startTime = (EditText)super.findViewById(R.id.startTime);
		 stopTime = (EditText)super.findViewById(R.id.stopTime);
		stopTime.setText(sp.getInt("startTime", 8)+"");
		startTime.setText(sp.getInt("startResponse", 5)+"");
		 
	}
	
}
