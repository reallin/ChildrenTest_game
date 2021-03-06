package com.myandroid.myapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.myandroid.dao.TurnResultDao;
import com.myandroid.dao.UserInfoDao;
import com.myandroid.model.TurnResult;
import com.myandroid.model.UserInfo;

public class ZimuyouxiActivity extends ActionBarActivity {

	private int score;

	private int tzxhfs;

	private int index;

	private TextView indextv;

	private Button tjbtn;

	private TextView num1;

	private TextView num2;

	private TextView num3;

	private TextView num4;

	private TextView daojishitv;

	private EditText shurujieguo;

	private ImageView img1;

	private ImageView img2;

	private ImageView img3;

	private ImageView image1;

	private ImageView image2;

	private ImageView image3;

	private ImageView image4;

	private ImageView image5;

	private ImageView image6;

	private ImageView image7;

	private ImageView image8;

	private ImageView image9;

	private ImageView image10;

	private TextView textview1;

	private TextView textview2;

	private TextView textview3;

	private TextView textview4;

	private TextView textview5;

	private TextView textview6;

	private TextView textview7;

	private TextView textview8;

	private TextView textview9;

	private TextView textview10;

	private LinearLayout linerlayout;

	private int recLen ;

	private Timer timer;

	public Map<String, Integer> lhmap;

	public Map<String, Integer> lhmap1;
	
	private int stop;
	private int start;
	
	private SharedPreferences sp;
	private SharedPreferences.Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_zimuyouxi);
		sp = getSharedPreferences("settime", 1);
		
		editor = sp.edit();
		if(sp != null){
			stop = sp.getInt("startTime", 9);
			start = sp.getInt("startResponse", 6);
			
		}
		
		
		lhmap = new LinkedHashMap<String, Integer>();

		lhmap1 = new LinkedHashMap<String, Integer>();

		lhmap.put("A", R.drawable.a);

		lhmap.put("B", R.drawable.b);

		lhmap.put("C", R.drawable.c);

		lhmap.put("D", R.drawable.d);

		lhmap.put("E", R.drawable.e);

		lhmap.put("F", R.drawable.f);

		lhmap.put("G", R.drawable.g);

		lhmap.put("H", R.drawable.h);

		lhmap.put("I", R.drawable.i);

		lhmap.put("J", R.drawable.j);

		lhmap.put("K", R.drawable.k);

		lhmap.put("L", R.drawable.l);

		lhmap.put("M", R.drawable.m);

		lhmap.put("N", R.drawable.n);

		lhmap.put("O", R.drawable.o);

		lhmap.put("P", R.drawable.p);

		lhmap.put("Q", R.drawable.q);

		lhmap.put("R", R.drawable.r);

		lhmap.put("S", R.drawable.s);

		lhmap.put("T", R.drawable.t);

		lhmap.put("U", R.drawable.u);

		lhmap.put("V", R.drawable.v);

		lhmap.put("W", R.drawable.w);

		lhmap.put("X", R.drawable.x);

		lhmap.put("Y", R.drawable.y);

		lhmap.put("Z", R.drawable.z);

		index = 1;

		score = 0;

		tzxhfs = 0;

		num1 = (TextView) this.findViewById(R.id.num1);

		num2 = (TextView) this.findViewById(R.id.num2);

		num3 = (TextView) this.findViewById(R.id.num3);

		num4 = (TextView) this.findViewById(R.id.num4);

		daojishitv = (TextView) this.findViewById(R.id.daojishitv);

		indextv = (TextView) this.findViewById(R.id.indextv);
		daojishitv.setText("停止信号倒计时:" + String.valueOf(stop)
				+ "S");
		shurujieguo = (EditText) this.findViewById(R.id.shurujieguo);

		shurujieguo
				.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

					@Override
					public void onFocusChange(View v, boolean hasFocus) {

						if (hasFocus) {
							if (stop > 0) {
								tijiaolistener.onClick(tjbtn);
							}

						} else {

							// 此处为失去焦点时的处理内容

						}

					}

				});

		img1 = (ImageView) this.findViewById(R.id.img1);

		img2 = (ImageView) this.findViewById(R.id.img2);

		img3 = (ImageView) this.findViewById(R.id.img3);

		image1 = (ImageView) this.findViewById(R.id.imageView1);

		image2 = (ImageView) this.findViewById(R.id.imageView2);

		image3 = (ImageView) this.findViewById(R.id.imageView3);

		image4 = (ImageView) this.findViewById(R.id.imageView4);

		image5 = (ImageView) this.findViewById(R.id.imageView5);

		image6 = (ImageView) this.findViewById(R.id.imageView6);

		image7 = (ImageView) this.findViewById(R.id.imageView7);

		image8 = (ImageView) this.findViewById(R.id.imageView8);

		image9 = (ImageView) this.findViewById(R.id.imageView9);

		image10 = (ImageView) this.findViewById(R.id.imageView10);

		textview1 = (TextView) this.findViewById(R.id.textView1);

		textview2 = (TextView) this.findViewById(R.id.textView2);

		textview3 = (TextView) this.findViewById(R.id.textView3);

		textview4 = (TextView) this.findViewById(R.id.textView4);

		textview5 = (TextView) this.findViewById(R.id.textView5);

		textview6 = (TextView) this.findViewById(R.id.textView6);

		textview7 = (TextView) this.findViewById(R.id.textView7);

		textview8 = (TextView) this.findViewById(R.id.textView8);

		textview9 = (TextView) this.findViewById(R.id.textView9);

		textview10 = (TextView) this.findViewById(R.id.textView10);

		linerlayout = (LinearLayout) this.findViewById(R.id.LinearLayout11);

		tjbtn = (Button) this.findViewById(R.id.tjbtn);

		tjbtn.setOnClickListener(tijiaolistener);

		chouqusuiji();

		timer = new Timer();

		timer.schedule(task, 1000, 1000);
	}

	TimerTask task = new TimerTask() {
		@Override
		public void run() {
			runOnUiThread(new Runnable() { // UI thread
				@Override
				public void run() {
					//int i = stop;
					
					//Log.e("eeeeeeeeeeeeeeeeeeeeeeee", stop+"");
					if (stop == 0) {
						daojishitv.setText("停止信号倒计时结束");
						int daojishi = start ;
						
						String tijiao = "提  交(" + String.valueOf(daojishi)
								+ "S)";

						tjbtn.setText(tijiao);
						//start--;
						if (start-- == 0) {

							tjbtn.setText("提  交");

							tijiaolistener.onClick(tjbtn);
						}
					} else {
						daojishitv.setText("停止信号倒计时:" + String.valueOf(stop)
								+ "S");
						stop--;
					}
				}
			});
		}
	};

	// 设置监听
	// .setOnClickListener(listener);//设置监听
	Button.OnClickListener tijiaolistener = new Button.OnClickListener() {
		public void onClick(View v) {

			tjbtn.setText("提  交");

			linerlayout.requestFocus();

			String ceshijieguo = "";

			String shuru = shurujieguo.getText().toString();

			String num44 = num4.getText().toString();

			if (shuru.equals(num44)) {

				score = score + 1;
			}
			if (stop == 0 && shuru.length() > 0) {
				tzxhfs = tzxhfs + 1;
			}

			/*Toast.makeText(
					ZimuyouxiActivity.this,
					"答题正确率=" + String.valueOf(score) + ";正确使用停止信号="
							+ String.valueOf(tzxhfs), Toast.LENGTH_LONG).show();*/
			index = index + 1;

			if (index == 11) {
				timer.cancel();
				if (score < 7) {
					ceshijieguo = "答题正确率低于70%，训练结果无效，请重来!";
					addResult(ceshijieguo);
					new AlertDialog.Builder(ZimuyouxiActivity.this)
							.setTitle("训练结果")
							.setMessage("答题正确率低于70%，训练结果无效，请重来!")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog, int i) {
											ZimuyouxiActivity.this.finish();
										}
									}).show();
				} else if (score >= 7 && tzxhfs == 0) {
					ceshijieguo = "正确使用停止信号0%；非正常使用停止信号100%；评价：请指导儿童正确使用停止信号!";
					addResult(ceshijieguo);
					new AlertDialog.Builder(ZimuyouxiActivity.this)
							.setTitle("训练结果")
							.setMessage(
									"正确使用停止信号0%；非正常使用停止信号100%；评价：请指导儿童正确使用停止信号!")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog, int i) {
											ZimuyouxiActivity.this.finish();
										}
									}).show();
				} else if (score >= 7 && tzxhfs >= 1 && tzxhfs <= 4) {
					ceshijieguo = "正确使用停止信号" + String.valueOf(tzxhfs)
							+ "0%，非正常使用停止信号" + String.valueOf(10 - tzxhfs)
							+ "0%；评价：继续努力!";
					addResult(ceshijieguo);
					new AlertDialog.Builder(ZimuyouxiActivity.this)
							.setTitle("训练结果")
							.setMessage(
									"正确使用停止信号" + String.valueOf(tzxhfs)
											+ "0%，非正常使用停止信号"
											+ String.valueOf(10 - tzxhfs)
											+ "0%；评价：继续努力!")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog, int i) {
											ZimuyouxiActivity.this.finish();
										}
									}).show();
				} else if (score >= 7 && tzxhfs >= 5 && tzxhfs <= 7) {

					ceshijieguo = "正确使用停止信号" + String.valueOf(tzxhfs)
							+ "0%，非正常使用停止信号" + String.valueOf(10 - tzxhfs)
							+ "0%；评价：再接再厉!";
					addResult(ceshijieguo);
					new AlertDialog.Builder(ZimuyouxiActivity.this)
							.setTitle("训练结果")
							.setMessage(
									"正确使用停止信号" + String.valueOf(tzxhfs)
											+ "0%，非正常使用停止信号"
											+ String.valueOf(10 - tzxhfs)
											+ "0%；评价：再接再厉!")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog, int i) {
											ZimuyouxiActivity.this.finish();
										}
									}).show();
				} else if (score >= 7 && tzxhfs >= 8 && tzxhfs <= 9) {
					ceshijieguo = "正确使用停止信号" + String.valueOf(tzxhfs)
							+ "0%，非正常使用停止信号" + String.valueOf(10 - tzxhfs)
							+ "0%；评价：离完美只差一步!";
					addResult(ceshijieguo);
					new AlertDialog.Builder(ZimuyouxiActivity.this)
							.setTitle("训练结果")
							.setMessage(
									"正确使用停止信号" + String.valueOf(tzxhfs)
											+ "0%，非正常使用停止信号"
											+ String.valueOf(10 - tzxhfs)
											+ "0%；评价：离完美只差一步!")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog, int i) {
											ZimuyouxiActivity.this.finish();
										}
									}).show();
				} else if (score >= 7 && tzxhfs == 10) {
					ceshijieguo = "正确使用停止信号" + String.valueOf(tzxhfs)
							+ "0%，非正常使用停止信号" + String.valueOf(10 - tzxhfs)
							+ "0%；评价：完美!";
					addResult(ceshijieguo);
					new AlertDialog.Builder(ZimuyouxiActivity.this)
							.setTitle("训练结果")
							.setMessage(
									"正确使用停止信号" + String.valueOf(tzxhfs)
											+ "0%，非正常使用停止信号"
											+ String.valueOf(10 - tzxhfs)
											+ "0%；评价：完美!")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog, int i) {
											ZimuyouxiActivity.this.finish();
										}
									}).show();
				}

			}
			if (index < 11) {
				chouqusuiji();
			}
			stop = sp.getInt("startTime", 8);
			start = sp.getInt("startResponse", 5);
		}

	};

	public void addResult(String result) {
		UserInfoDao userinfoDAO = new UserInfoDao(ZimuyouxiActivity.this);

		TurnResultDao turnDAO = new TurnResultDao(ZimuyouxiActivity.this);

		UserInfo userinfo = new UserInfo();

		TurnResult turnResult = new TurnResult();

		List<UserInfo> userinfoList = new ArrayList<UserInfo>();

		userinfoList = userinfoDAO.listUserInfo();

		if (userinfoList.size() > 0) {

			userinfo = (UserInfo) userinfoList.get(0);

			turnResult.setAge(userinfo.getAge());

			turnResult.setUsername(userinfo.getUsername());

			turnResult.setSex(userinfo.getSex());

			turnResult.setResult(result);

			turnResult.setTurntype("英文字母");

			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date date = new Date();

			turnResult.setTurntime(f.format(date));

			turnDAO.add(turnResult);

		}
	}

	// 抽取随机10个图片显示
	public void chouqusuiji() {

		int a = 0;

		int b = 0;

		int c = 0;

		int d = 0;

		int e = 0;

		int f = 0;

		int g = 0;

		int h = 0;

		int i = 0;

		int j = 0;

		a = this.CreateRandom(0, 25);

		b = this.CreateRandom(0, 25);

		c = this.CreateRandom(0, 25);

		d = this.CreateRandom(0, 25);

		e = this.CreateRandom(0, 25);

		f = this.CreateRandom(0, 25);

		g = this.CreateRandom(0, 25);

		h = this.CreateRandom(0, 25);

		i = this.CreateRandom(0, 25);

		j = this.CreateRandom(0, 25);

		System.out.print("第" + String.valueOf(index) + "组 10个随机数---"
				+ String.valueOf(a) + "," + String.valueOf(b) + ","
				+ String.valueOf(c) + "," + String.valueOf(d) + ","
				+ String.valueOf(e) + "," + String.valueOf(f) + ","
				+ String.valueOf(g) + "," + String.valueOf(h) + ","
				+ String.valueOf(i) + "," + String.valueOf(j));

		int ii = 0;

		ListIterator<Map.Entry<String, Integer>> li = new ArrayList<Map.Entry<String, Integer>>(
				lhmap.entrySet()).listIterator(lhmap.size());

		List<HashMap<String, Integer>> suijiList = new ArrayList<HashMap<String, Integer>>();

		while (li.hasPrevious()) {

			Map.Entry<String, Integer> entry = li.previous();

			System.out.println(entry.getKey() + ":" + entry.getValue());

			if (ii == a) {
				image1.setImageResource(entry.getValue());

				textview1.setText(entry.getKey());

				HashMap<String, Integer> map1 = new HashMap<String, Integer>();

				map1.put(entry.getKey(), entry.getValue());

				suijiList.add(map1);

			}

			if (ii == b) {
				image2.setImageResource(entry.getValue());

				textview2.setText(entry.getKey());

				HashMap<String, Integer> map1 = new HashMap<String, Integer>();

				map1.put(entry.getKey(), entry.getValue());

				suijiList.add(map1);
			}

			if (ii == c) {
				image3.setImageResource(entry.getValue());

				textview3.setText(entry.getKey());

				HashMap<String, Integer> map1 = new HashMap<String, Integer>();

				map1.put(entry.getKey(), entry.getValue());

				suijiList.add(map1);
			}

			if (ii == d) {
				image4.setImageResource(entry.getValue());

				textview4.setText(entry.getKey());

				HashMap<String, Integer> map1 = new HashMap<String, Integer>();

				map1.put(entry.getKey(), entry.getValue());

				suijiList.add(map1);
			}

			if (ii == e) {
				image5.setImageResource(entry.getValue());

				textview5.setText(entry.getKey());

				HashMap<String, Integer> map1 = new HashMap<String, Integer>();

				map1.put(entry.getKey(), entry.getValue());

				suijiList.add(map1);
			}

			if (ii == f) {
				image6.setImageResource(entry.getValue());

				textview6.setText(entry.getKey());

				HashMap<String, Integer> map1 = new HashMap<String, Integer>();

				map1.put(entry.getKey(), entry.getValue());

				suijiList.add(map1);
			}

			if (ii == g) {
				image7.setImageResource(entry.getValue());

				textview7.setText(entry.getKey());

				HashMap<String, Integer> map1 = new HashMap<String, Integer>();

				map1.put(entry.getKey(), entry.getValue());

				suijiList.add(map1);
			}

			if (ii == h) {
				image8.setImageResource(entry.getValue());

				textview8.setText(entry.getKey());

				HashMap<String, Integer> map1 = new HashMap<String, Integer>();

				map1.put(entry.getKey(), entry.getValue());

				suijiList.add(map1);
			}

			if (ii == i) {
				image9.setImageResource(entry.getValue());

				textview9.setText(entry.getKey());

				HashMap<String, Integer> map1 = new HashMap<String, Integer>();

				map1.put(entry.getKey(), entry.getValue());

				suijiList.add(map1);
			}

			if (ii == j) {
				image10.setImageResource(entry.getValue());

				textview10.setText(entry.getKey());

				HashMap<String, Integer> map1 = new HashMap<String, Integer>();

				map1.put(entry.getKey(), entry.getValue());

				suijiList.add(map1);
			}

			ii = ii + 1;
		}
		System.out.print("-------------------------------------取了"
				+ String.valueOf(suijiList.size()) + "个数字!!");

		MakePic(suijiList);
	}

	// 更新图片
	public void MakePic(List<HashMap<String, Integer>> shigesuiji) {
		int a = 0;

		int b = 0;

		int c = 0;

		a = this.CreateRandom(0, 9);

		b = this.CreateRandom(0, 9);

		c = this.CreateRandom(0, 9);

		String a1 = "";

		String a2 = "";

		String a3 = "";

		int ii = 0;

		for (int a11 = 0; a11 < shigesuiji.size(); a11++) {
			if (a11 == a) {

				String key = "";

				int value = 0;

				HashMap<String, Integer> hm = shigesuiji.get(a11);

				for (Entry<String, Integer> entry : hm.entrySet()) {
					key = entry.getKey();

					value = entry.getValue();
				}

				img1.setImageResource(value);

				a1 = key;
			}

			if (ii == b) {

				String key = "";

				int value = 0;

				HashMap<String, Integer> hm = shigesuiji.get(a11);

				for (Entry<String, Integer> entry : hm.entrySet()) {
					key = entry.getKey();

					value = entry.getValue();
				}

				img2.setImageResource(value);

				a2 = key;
			}

			if (ii == c) {

				String key = "";

				int value = 0;

				HashMap<String, Integer> hm = shigesuiji.get(a11);

				for (Entry<String, Integer> entry : hm.entrySet()) {
					key = entry.getKey();

					value = entry.getValue();
				}

				img3.setImageResource(value);

				a3 = key;
			}

			ii = ii + 1;
		}

		num4.setText(a1 + a2 + a3);

		indextv.setText(String.valueOf(index));

		shurujieguo.setText("");
	}

	// 产生随机数
	public int CreateRandom(int min, int max) {
		Random random = new Random();

		int s = random.nextInt(max) % (max - min + 1) + min;

		return s;
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
