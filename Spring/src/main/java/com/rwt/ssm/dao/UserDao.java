package com.rwt.ssm.dao;

import com.rwt.ssm.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;



public interface UserDao {
    @Select("select * from user")
	public List<User> getAllUser();
	
	public User getUserByName(String name);
	
	public void insertUser(User user);

}
