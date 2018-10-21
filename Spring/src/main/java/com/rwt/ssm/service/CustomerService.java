package com.rwt.ssm.service;

import com.rwt.ssm.model.Customer;
import org.springframework.stereotype.Service;

/**
* @author
 * @date
**/
@Service
public class CustomerService {
    static {
        System.out.println("CustomerService 加载");
        System.out.println(System.currentTimeMillis());
    }
     public CustomerService(){
        System.out.println("CustomerService 对象构建");
        System.out.println("CustomerService 对象"+this.toString());
     }

    public Customer getCustomer(){
        Customer customer=new Customer();
        customer.setId("1");
        customer.setName("刘志鑫");

        return customer;
    }
}
