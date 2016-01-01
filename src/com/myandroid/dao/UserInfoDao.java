package com.myandroid.dao;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.myandroid.db.DatabaseHelper;
 
import com.myandroid.model.UserInfo;

public class UserInfoDao {

	private Context context;

	private Dao<UserInfo, Integer> userinfoDaoOpe;

	private DatabaseHelper helper;

	public UserInfoDao(Context context) {

		this.context = context;
		try {

			helper = DatabaseHelper.getHelper(context);

			userinfoDaoOpe = helper.getDao(UserInfo.class);

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	/**
	 * 增加一个用户
	 * 
	 * @param user
	 */
	public void add(UserInfo userinfo) {
		try {

			userinfoDaoOpe.create(userinfo);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public UserInfo get(int id) {
		try {

			return userinfoDaoOpe.queryForId(id);

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return null;
	}

	/**
	 * 获取所有的用户
	 * 
	 * @return
	 */
	public List<UserInfo> listUserInfo() {
		try {

			return userinfoDaoOpe.queryForAll();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String update(UserInfo userinfo) {

		try {

			userinfoDaoOpe.update(userinfo);

			return "ok";

		} catch (SQLException e) {

			e.printStackTrace();

			return "err";

		}

	}

}
