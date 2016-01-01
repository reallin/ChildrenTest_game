package com.myandroid.myapp;
 

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private Button ceshiertongxinxiBtn;

	private Button zhuyiliceshibiaoBtn;

	private Button zhuyiliceshijieguoBtn;

	private Button zhuyilixunlianyouxiBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		ceshiertongxinxiBtn = (Button) this.findViewById(R.id.button1);

		ceshiertongxinxiBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MainActivity.this,
						UserInfoChangeActivity.class);
				startActivity(intent);

			}
		});

		zhuyiliceshibiaoBtn = (Button) this.findViewById(R.id.Button2);

		zhuyiliceshibiaoBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MainActivity.this,
						ZhuyiliceshibiaoIndexActivity.class);
				// Æô¶¯Activity
				startActivity(intent);
			}
		});

		zhuyiliceshijieguoBtn = (Button) this.findViewById(R.id.Button4);

		zhuyiliceshijieguoBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MainActivity.this,
						XunlianjieguoListActivity.class); // Æô¶¯Activity
				startActivity(intent);

			}
		});

		zhuyilixunlianyouxiBtn = (Button) this.findViewById(R.id.Button3);

		zhuyilixunlianyouxiBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MainActivity.this,
						XunlianyouxiguizeActivity.class); // Æô¶¯Activity
				startActivity(intent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		// int id = item.getItemId();
		// if (id == R.id.action_settings) {
		// return true;
		// }
		return super.onOptionsItemSelected(item);

	}
}
