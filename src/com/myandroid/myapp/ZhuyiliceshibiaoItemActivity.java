package com.myandroid.myapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class ZhuyiliceshibiaoItemActivity extends ActionBarActivity {

	private Button xiayidaoBtn;

	private CheckBox ck;

	String[] items;

	private TextView tv;

	private int score;

	private int index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_zhuyiliceshi_item);

		items = getResources().getStringArray(R.array.zhuyiliceshiti);

		ck = (CheckBox) this.findViewById(R.id.checkBox1);

		xiayidaoBtn = (Button) this.findViewById(R.id.xydbtn);

		tv = (TextView) this.findViewById(R.id.textview2);

		initApp();

	}

	// 初始化app
	public void initApp() {

		ck.setChecked(false);

		score = 0;// 分数

		index = 0;// 索引

		xiayidaoBtn.setOnClickListener(xiayidaolistener);

		items = getResources().getStringArray(R.array.zhuyiliceshiti);

		tv.setText(items[0].toString());

		index = 1;

	}

	// 设置监听
	// .setOnClickListener(listener);//设置监听
	Button.OnClickListener xiayidaolistener = new Button.OnClickListener() {
		public void onClick(View v) {

			if (ck.isChecked()) {
				score = score + 1;
			}
			if (index < 19) {
				tv.setText(items[index].toString());
			}
			ck.setChecked(false);

			index = index + 1;

			if (index == 19) {
				if (score >= 0 && score <= 4) {
					new AlertDialog.Builder(ZhuyiliceshibiaoItemActivity.this)
							.setTitle("测试结果")
							.setMessage("正常!")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog, int i) {
											Intent intent = new Intent(ZhuyiliceshibiaoItemActivity.this,
													MainActivity.class);
											// 启动Activity
											startActivity(intent);
											//ZhuyiliceshibiaoItemActivity.this
												//	.finish();
										}
									}).show();
				} else if (score >= 5 && score <= 7) {
					new AlertDialog.Builder(ZhuyiliceshibiaoItemActivity.this)
							.setTitle("测试结果")
							.setMessage("您的孩子属于轻微注意力不足!")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog, int i) {
											Intent intent = new Intent(ZhuyiliceshibiaoItemActivity.this,
													MainActivity.class);
											// 启动Activity
											startActivity(intent);
											//ZhuyiliceshibiaoItemActivity.this
											//		.finish();
										}
									}).show();
				} else if (score >= 8 && score <= 10) {
					new AlertDialog.Builder(ZhuyiliceshibiaoItemActivity.this)
							.setTitle("测试结果")
							.setMessage("建议您的孩子进行适当的提升注意力能力的训练!")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog, int i) {
											Intent intent = new Intent(ZhuyiliceshibiaoItemActivity.this,
													MainActivity.class);
											// 启动Activity
											startActivity(intent);
											//ZhuyiliceshibiaoItemActivity.this
												//	.finish();
										}
									}).show();
				} else if (score > 10) {
					new AlertDialog.Builder(ZhuyiliceshibiaoItemActivity.this)
							.setTitle("测试结果")
							.setMessage("建议您的孩子马上进行提升注意力能力的训练!")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog, int i) {
											Intent intent = new Intent(ZhuyiliceshibiaoItemActivity.this,
													MainActivity.class);
											// 启动Activity
											startActivity(intent);
											//ZhuyiliceshibiaoItemActivity.this
													//.finish();
										}
									}).show();
				}
			}
		}

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.kbcx, menu);
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
