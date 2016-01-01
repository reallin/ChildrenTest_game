package com.myandroid.myapp;

import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myandroid.adapter.XunlianjieguoAdapter;
import com.myandroid.adapter.XunlianjieguoAdapter.ViewHolder;
import com.myandroid.dao.TurnResultDao;
import com.myandroid.model.TurnResult;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map.Entry;

public class XunlianjieguoListActivity extends ActionBarActivity {

	private TextView t1;

	private TextView t2;

	private TextView t3;

	ListView listView;

	List<TurnResult> turnlist1;

	private XunlianjieguoAdapter adapter;

	private String[] opr = new String[] { "删除" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_xunlianjieguo_list);

		listView = (ListView) findViewById(R.id.xljglv);

		turnlist1 = new ArrayList<TurnResult>();

		adapter = new XunlianjieguoAdapter(this, turnlist1);

		listView.setAdapter(adapter);

		initList();

		listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					final int position, long id) {

				ViewHolder vHollder = (ViewHolder) view.getTag();

				// Toast.makeText(getApplicationContext(),
				// vHollder.title.getText(), Toast.LENGTH_SHORT).show();

				showOprDialog(vHollder.id.getText().toString());

				return true;

			}
		});

	}

	private void showOprDialog(String id) {

		final String _id = id;

		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("请选择操作:");

		builder.setItems(opr, new DialogInterface.OnClickListener()

		{
			@Override
			public void onClick(DialogInterface dialog, int which) {

				if (which == 0) {

					TurnResultDao xljgDAO = new TurnResultDao(
							XunlianjieguoListActivity.this);

					xljgDAO.deleteTurnResultById(_id);

					initList();
				}

				/*
				 * final AlertDialog oprDlg = new AlertDialog.Builder(
				 * 
				 * NoteListActivity.this).setMessage(
				 * 
				 * "你选择的是：" + which + ": " + opr[which]).show();
				 * 
				 * Handler handler = new Handler();
				 * 
				 * Runnable runnable = new Runnable() {
				 * 
				 * @Override public void run() { //
				 * 调用AlertDialog类的dismiss()方法关闭对话框，也可以调用cancel()方法。
				 * oprDlg.dismiss(); } }; // 5秒后运行run()方法。
				 * handler.postDelayed(runnable, 2 * 1000);
				 */
			}
		});

		builder.create().show();
	}

	public void initList() {

		TurnResultDao xljgDAO = new TurnResultDao(
				XunlianjieguoListActivity.this);

		List<TurnResult> turnResultlist = new ArrayList<TurnResult>();

		turnResultlist = xljgDAO.listTurnResult();

		turnlist1.clear();

		turnlist1.addAll(turnResultlist);

		adapter.notifyDataSetChanged();
	}

	 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.add_del_menu, menu);

		return true;
	}

	// 子页面关闭时调用
	@Override
	protected void onResume() {

		super.onResume();

		handler.post(runnable);
	}

	private Runnable runnable = new Runnable() {

		public void run() {
			// 做操作
			handler.sendEmptyMessage(1);
		}
	};

	private Handler handler = new Handler() {

		public void handleMessage(android.os.Message msg) {

			switch (msg.what) {

			case 1:
				// 更新UI
				initList();

				break;
			}
		};
	};

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
 

		return super.onOptionsItemSelected(item);

	}
}
