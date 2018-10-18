package com.rwt.ssm.controller;

import com.rwt.ssm.model.Customer;
import com.rwt.ssm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @author
* @date
 */

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    public CustomerController(){
        System.out.println("CustomerController 对象构建");
        System.out.println("CustomerController"+this.toString());
    }
    static {
        System.out.println("Customer load");
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

}
