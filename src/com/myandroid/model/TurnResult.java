package com.myandroid.model;

import com.j256.ormlite.field.DatabaseField;

public class TurnResult {
	@DatabaseField(generatedId = true)
	private int turnid;

	@DatabaseField(columnName = "turntime")
	private String turntime;

	@DatabaseField(columnName = "username")
	private String username;

	@DatabaseField(columnName = "sex")
	private String sex;

	@DatabaseField(columnName = "age")
	private String age;

	@DatabaseField(columnName = "turntype")
	private String turntype;

	@DatabaseField(columnName = "result")
	private String result;

	public TurnResult() {
	}

	public TurnResult(String _username, String _sex, String _age,
			String _turntype, String _result) {
		this.username = _username;
		this.sex = _sex;
		this.age = _age;
		this.turntype = _turntype;
		this.result = _result;
	}

	public int getTurnid() {
		return turnid;
	}

	public void setTurnid(int turnid) {
		this.turnid = turnid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTurntype() {
		return turntype;
	}

	public void setTurntype(String turntype) {
		this.turntype = turntype;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTurntime() {
		return turntime;
	}

	public void setTurntime(String turntime) {
		this.turntime = turntime;
	}

}
