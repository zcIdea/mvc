package com.springmvc.dao;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Select;

import com.springmvc.entry.User;

public interface UserDao {

//	@Select("select * from huge_mach where id=#{id}")
	User getUserById(int id);
	
	void saveUser(User user);
	
}
