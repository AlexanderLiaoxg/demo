package com.example.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.domain.UserInfo;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired 
	UserDao userDao;
	
	@Autowired
    RedisTemplate redisTemplate;
	
	
	@Override
	public ArrayList getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}
	
	@Override
	public UserInfo getUserById(int uid) {
		// TODO Auto-generated method stub
		return userDao.getUserById(uid);
	}

	@Override
	public void addUser(UserInfo user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	@Override
	public void deleteUser(int uid) {
		// TODO Auto-generated method stub
		userDao.deleteUserById(uid);
	}

	@Override
	public void editUser(UserInfo user) {
		// TODO Auto-generated method stub
		userDao.editUser(user);
	}

	@Override
	public void testRedis() {
		// TODO Auto-generated method stub
		System.out.println("插入：");
		redisTemplate.opsForValue().set("LiaoXingGuang","Cool_boy~");
		
		String info = (String) redisTemplate.opsForValue().get("LiaoXingGuang");
		System.out.println("取出数据为：" + info);
	}

}
