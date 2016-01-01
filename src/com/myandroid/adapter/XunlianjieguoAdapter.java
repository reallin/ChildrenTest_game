package com.myandroid.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import com.myandroid.model.TurnResult;
import com.myandroid.myapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class XunlianjieguoAdapter extends BaseAdapter {

	private List<TurnResult> mData;

	private LayoutInflater mInflater;

	private Context context;// 用于接收传递过来的Context对象

	public XunlianjieguoAdapter(Context context, List<TurnResult> mData) {

		this.context = context;

		mInflater = LayoutInflater.from(context);

		this.mData = mData;

	}

	@Override
	public int getCount() {
		System.out.print("mData.size()=" + mData.size());
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;

		// convertView为null的时候初始化convertView。
		if (convertView == null) {

			holder = new ViewHolder();

			convertView = mInflater.inflate(
					R.layout.activity_xunlianjieguo_item, null);

			holder.id = (TextView) convertView.findViewById(R.id.id);

			holder.id.setVisibility(View.GONE);

			holder.turntime = (TextView) convertView.findViewById(R.id.shijian);

			holder.username = (TextView) convertView
					.findViewById(R.id.xingming);

			holder.age = (TextView) convertView
					.findViewById(R.id.nianling);

			holder.sex = (TextView) convertView.findViewById(R.id.xingbie);

			holder.turntype = (TextView) convertView
					.findViewById(R.id.ceshileixing);

			holder.result = (TextView) convertView
					.findViewById(R.id.ceshijieguo);

			convertView.setTag(holder);

		} else {

			holder = (ViewHolder) convertView.getTag();

		}

		holder.username.setText(mData.get(position).getUsername());

		holder.id.setText(String.valueOf(mData.get(position).getTurnid()));

		holder.turntime.setText(mData.get(position).getTurntime());

		holder.age.setText(mData.get(position).getAge());

		holder.sex.setText(mData.get(position).getSex());

		holder.turntype.setText(mData.get(position).getTurntype());

		holder.result.setText(mData.get(position).getResult());

		return convertView;
	}

	public final class ViewHolder {

		public TextView id;

		public TextView turntime;

		public TextView username;

		public TextView sex;

		public TextView age;

		public TextView turntype;

		public TextView result;

	}
}
