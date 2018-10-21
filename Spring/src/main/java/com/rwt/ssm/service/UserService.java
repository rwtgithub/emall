package com.rwt.ssm.service;

import com.rwt.ssm.dao.UserDao;
import com.rwt.ssm.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private  UserDao userDao;

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;


    public List<User> getAllUser(){
        return  userDao.getAllUser();
    }

}
