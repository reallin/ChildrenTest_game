package com.myandroid.model;

import com.j256.ormlite.field.DatabaseField;

public class UserInfo {
	@DatabaseField(generatedId = true)
	private int userid;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	@DatabaseField(columnName = "username")
	private String username;

	@DatabaseField(columnName = "sex")
	private String sex;

	@DatabaseField(columnName = "age")
	private String age;

	public UserInfo() {
	}

	public UserInfo(String _username, String _sex, String _age) {
		this.username = _username;
		this.sex = _sex;
		this.age = _age;
	}

}
