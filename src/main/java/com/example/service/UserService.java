package com.example.service;

import java.util.ArrayList;

import com.example.domain.UserInfo;

public interface UserService {
	ArrayList<UserInfo> getAllUser();
	UserInfo getUserById(int uid);
	void addUser(UserInfo user);
	void deleteUser(int uid);
	void editUser(UserInfo user);
	void testRedis();
}
