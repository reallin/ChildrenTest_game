package com.myandroid.myapp;

import java.util.ArrayList;
import java.util.List;
 

import com.myandroid.dao.UserInfoDao;
import com.myandroid.model.UserInfo;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;

public class IndexActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		initPage();
	}

	public void initPage() {
		View view = View.inflate(this, R.layout.activity_index, null);

		setContentView(view);

		Animation animation = AnimationUtils
				.loadAnimation(this, R.anim.enlarge);

		view.startAnimation(animation);

		animation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation arg0) {
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
			}

			@Override
			public void onAnimationEnd(Animation arg0) {

				UserInfo userinfo = new UserInfo();

				List<UserInfo> userinfoList = new ArrayList<UserInfo>();

				UserInfoDao userinfoDAO = new UserInfoDao(IndexActivity.this);

				userinfoList = userinfoDAO.listUserInfo();

				if (userinfoList.size() > 0) {
					Intent intent = new Intent(IndexActivity.this,
							MainActivity.class);
					// 启动Activity
					startActivity(intent);
				} else {
					Intent intent = new Intent(IndexActivity.this,
							UserInfoActivity.class);
					// 启动Activity
					startActivity(intent);
				}

			}
		});
	}

	// 子页面关闭时调用
	@Override
	protected void onResume() {

		super.onResume();

		handler1.post(runnable);
	}

	private Runnable runnable = new Runnable() {

		public void run() {
			// 做操作
			handler1.sendEmptyMessage(1);
		}
	};

	private Handler handler1 = new Handler() {

		public void handleMessage(android.os.Message msg) {

			switch (msg.what) {

			case 1:

				initPage();

				break;
			}
		};
	};

}
