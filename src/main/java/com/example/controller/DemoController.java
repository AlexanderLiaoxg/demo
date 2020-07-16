package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.UserInfo;
import com.example.service.UserService;

@Controller
public class DemoController {
	@Autowired 
	UserService userService;
	
	@RequestMapping("/hello")
	public String hello(Model model)  {
		System.out.println("进入到helloController");
	
		model.addAttribute("test",userService.getUserById(1).getUname());
		System.out.println(userService.getUserById(1).toString());
		 
		return "hello";
	}
	
	@RequestMapping("/getAllUser")
	public String getAllUser(Model model)  {
		System.out.println("进入到getAllUser");
	
		model.addAttribute("users",userService.getAllUser());
		 
		return "hello";
	}
	
	@RequestMapping("/demo")
	public String demo(Model model)  {
		System.out.println("查看所有用户");
		System.out.println(userService.getAllUser() + "\n\n\n");
		
		System.out.println("增加一个新用户LiaoXingGuang");
		UserInfo lxg = new UserInfo();
		lxg.setUname("LiaoXingGuang");
		lxg.setUsex("男");
		lxg.setUphone("15274438497");
		lxg.setUaddress("吉首大学");
		lxg.setUemail("12345678910@qq.com");
		
		userService.addUser(lxg);
		
		System.out.println("修改名字为廖兴广");
		lxg.setUname("廖兴广");
		lxg.setUid(5);
		userService.editUser(lxg);
		
		System.out.println("通过id查看用户");
		System.out.println(userService.getUserById(5).toString() + "\n\n\n");
		
		System.out.println("删除它");
		userService.deleteUser(5);
		
		
		System.out.println("查看所有用户");
		System.out.println(userService.getAllUser());
		 return "hello";
	}
	

	@RequestMapping("/redisTest")
	public String redis()  {
		userService.testRedis();
		 return "hello";
	}
	
}
