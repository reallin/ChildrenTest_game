package com.myandroid.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ShuziyinyuMainActivity extends ActionBarActivity {

	private Button shuzijiajianBtn;
	
	private Button yingyuzimuBtn;
	private Button youxishezhi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_shuziyingyu_main);

		shuzijiajianBtn = (Button) this.findViewById(R.id.button1);

		shuzijiajianBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(ShuziyinyuMainActivity.this,
						ShuziyouxiActivity.class);
				Bundle b = new Bundle();
				b.putInt("startTime", 5);
				b.putInt("startResponse",8);
				startActivity(intent.putExtras(b));

			}
		});
		
		yingyuzimuBtn = (Button) this.findViewById(R.id.Button2);

		yingyuzimuBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(ShuziyinyuMainActivity.this,
						ZimuyouxiActivity.class);
				Bundle b = new Bundle();
				b.putInt("startTime", 5);
				b.putInt("startResponse",8);
				startActivity(intent.putExtras(b));

			}
		});
		
		youxishezhi = (Button)this.findViewById(R.id.Button3);
		youxishezhi.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ShuziyinyuMainActivity.this,
						SetTimeAcitivity.class);
				startActivity(intent);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
