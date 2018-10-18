package com.rwt.emall.service;

import com.rwt.emall.model.Customer;
import com.rwt.emall.model.Customer;
import org.springframework.stereotype.Service;

/**
* @author
 * @date
**/
@Service
public class CustomerService {
    static {
        System.out.println("CustomerService load");
        System.out.println(System.currentTimeMillis());

    }
     public CustomerService(){
        System.out.println("CustomerService 对象构建");
        System.out.println("CustomerService"+this.toString());
     }

    public Customer getCustomer(){
        Customer customer=new Customer();
        customer.setId("1");
        customer.setName("刘志鑫");

        return customer;
    }
}
