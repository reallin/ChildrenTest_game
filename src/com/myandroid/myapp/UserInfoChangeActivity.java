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

public class UserInfoChangeActivity extends  ActionBarActivity {

	private Button savebtn;

	private ArrayAdapter<CharSequence> sex = null;

	private List<CharSequence> sex_data = null;

	private Spinner spinersex;

	private EditText username;

	private EditText age;

	private TextView userinfoid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		int Position = 0;

		setContentView(R.layout.activity_userinfo_change);

		username = (EditText) this.findViewById(R.id.xingming);

		age = (EditText) this.findViewById(R.id.nianling);

		userinfoid = (TextView) this.findViewById(R.id.userinfoid);

		sex_data = Arrays.asList(new CharSequence[] { "男", "女" });

		sex = new ArrayAdapter<CharSequence>(this,
				android.R.layout.simple_spinner_item, sex_data);

		sex.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinersex = (Spinner) this.findViewById(R.id.xingbie);

		spinersex.setAdapter(sex);

		UserInfoDao userinfoDAO = new UserInfoDao(UserInfoChangeActivity.this);

		UserInfo userinfo = new UserInfo();

		List<UserInfo> userinfoList = new ArrayList<UserInfo>();

		userinfoList = userinfoDAO.listUserInfo();

		if (userinfoList.size() > 0) {

			userinfo = (UserInfo) userinfoList.get(0);

			username.setText(userinfo.getUsername());

			age.setText(userinfo.getAge());

			if (userinfo.getSex().equals("男")) {
				Position = 0;
			} else {
				Position = 1;
			}
			spinersex.setSelection(Position, true);

			userinfoid.setText(String.valueOf(userinfo.getUserid()));
		}

		savebtn = (Button) this.findViewById(R.id.savebtn);

		savebtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if (username.getText().toString().length() < 1) {
					Toast.makeText(UserInfoChangeActivity.this, "姓名不能为空！",
							Toast.LENGTH_LONG).show();
					return;
				}
				if (age.getText().toString().length() < 1) {
					Toast.makeText(UserInfoChangeActivity.this, "年龄不能为空！",
							Toast.LENGTH_LONG).show();
					return;
				}

				UserInfo userinfo = new UserInfo();

				UserInfoDao userinfoDAO1 = new UserInfoDao(
						UserInfoChangeActivity.this);

				userinfo = (UserInfo) userinfoDAO1.get(Integer
						.parseInt(userinfoid.getText().toString()));

				userinfo.setUsername(username.getText().toString());

				userinfo.setSex(spinersex.getSelectedItem().toString());

				userinfo.setAge(age.getText().toString());

				UserInfoDao userinfoDAO = new UserInfoDao(
						UserInfoChangeActivity.this);

				userinfoDAO.update(userinfo);

				Toast.makeText(UserInfoChangeActivity.this, "修改成功！",
						Toast.LENGTH_LONG).show();
				return;
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
