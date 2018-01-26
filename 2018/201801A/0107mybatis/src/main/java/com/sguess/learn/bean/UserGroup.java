package com.sguess.learn.bean;

import java.util.List;

public class UserGroup {
	private int id;
	private String groupName;
	private List<User> userList;

	public UserGroup() {
		super();
	}

	public UserGroup(String groupName, List<User> userList) {
		super();
		this.groupName = groupName;
		this.userList = userList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "UserGroup [id=" + id + ", groupName=" + groupName + ", userList=" + userList + "]";
	}

}
