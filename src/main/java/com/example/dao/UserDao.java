package com.example.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.domain.UserInfo;

@Mapper
public interface UserDao {
	@Select("select * from user_info")
	ArrayList<UserInfo> getAllUser();
	
	@Select("select * from user_info where uid = #{uid}")
	UserInfo getUserById(int uid);

	@Insert("insert into user_info(uname,usex,uphone,uaddress,uemail) values (#{uname}, #{usex},#{uphone}, #{uaddress}, #{uemail})")
	public int addUser(UserInfo user);

	@Delete("delete from user_info where uid=#{uid}")
	public int deleteUserById(int uid);

	@Update("update user_info set uname=#{uname},uphone=#{uphone},uaddress=#{uaddress},uemail=#{uemail} where uid=#{uid}")
	public int editUser(UserInfo user);
}
