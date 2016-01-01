package com.myandroid.myapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
 
import com.myandroid.dao.UserInfoDao;
 
import com.myandroid.model.UserInfo;

public class UserInfoActivity extends Activity {

	private Button savebtn;

	private ArrayAdapter<CharSequence> sex = null;

	private List<CharSequence> sex_data = null;

	private Spinner spinersex;

	private EditText username;

	private EditText age;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_userinfo);

	username = (EditText) this.findViewById(R.id.xing);

		age = (EditText) this.findViewById(R.id.nianling1);

		sex_data = Arrays.asList(new CharSequence[] { "男", "女" });

		sex = new ArrayAdapter<CharSequence>(this,
				android.R.layout.simple_spinner_item, sex_data);

		sex.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinersex = (Spinner) this.findViewById(R.id.xingbie1);

		spinersex.setAdapter(sex);

		savebtn = (Button) this.findViewById(R.id.savebtn);

		savebtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if (username.getText().toString().length() < 1) {
					Toast.makeText(UserInfoActivity.this, "姓名不能为空！",
							Toast.LENGTH_LONG).show();
					return;
				}
				if (age.getText().toString().length() < 1) {
					Toast.makeText(UserInfoActivity.this, "年龄不能为空！",
							Toast.LENGTH_LONG).show();
					return;
				}

				UserInfo userinfo = new UserInfo();

				userinfo.setUsername(username.getText().toString());
				//userinfo.setUsername("");

				userinfo.setSex(spinersex.getSelectedItem().toString());

				userinfo.setAge(age.getText().toString());

				UserInfoDao userinfoDAO = new UserInfoDao(UserInfoActivity.this);

				userinfoDAO.add(userinfo);

				Toast.makeText(UserInfoActivity.this, "添加成功！",
						Toast.LENGTH_LONG).show();
				
				Intent intent = new Intent(UserInfoActivity.this,
						MainActivity.class);
				// 启动Activity
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
