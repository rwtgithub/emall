package com.rwt.ssm.controller;

import com.rwt.ssm.dao.UserDao;
import com.rwt.ssm.model.Customer;
import com.rwt.ssm.model.User;
import com.rwt.ssm.service.CustomerService;
import com.rwt.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
* @author
* @date
 */

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;
    public CustomerController(){
        System.out.println("CustomerController 对象构建");
        System.out.println("CustomerController 对象"+this.toString());
    }
    static {
        System.out.println("CustomerController 加载");
        System.out.println(System.currentTimeMillis());
    }


    @RequestMapping(value="/customer",method = RequestMethod.GET)
    @ResponseBody
    public String getCustomer(){
        return "Customer";
    }


    @RequestMapping("/first_customer")
    @ResponseBody
    public Customer getFirstCustomer(){

        return customerService.getCustomer();
    }

    @RequestMapping("/hello")
    public  String hello(){
        return "hello";
    }

    @RequestMapping("/user")
    @ResponseBody
    public  List<User> getUser(){
        List<User> allUser =userService.getAllUser();
        return allUser;
    }

}
