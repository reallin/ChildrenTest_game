package com.myandroid.dao;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.myandroid.db.DatabaseHelper;
 
import com.myandroid.model.TurnResult;

public class TurnResultDao {
	private Context context;

	private Dao<TurnResult, Integer> turnDaoOpe;

	private DatabaseHelper helper;

	public TurnResultDao(Context context) {

		this.context = context;

		try {
			helper = DatabaseHelper.getHelper(context);

			turnDaoOpe = helper.getDao(TurnResult.class);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void add(TurnResult turnResult) {
		try {

			turnDaoOpe.create(turnResult);

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public TurnResult get(int id) {
		try {

			return turnDaoOpe.queryForId(id);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	
	public List<TurnResult> listTurnResult() {
		try {

			QueryBuilder builder = turnDaoOpe.queryBuilder().orderBy(
					"turntime", false);

			return builder.query();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return null;
	}

	
	public String deleteTurnResultById(String id) {

		try {

			turnDaoOpe.deleteById(Integer.valueOf(id));

			return "ok";

		} catch (SQLException e) {

			e.printStackTrace();

			return "err";

		}

	}

}
