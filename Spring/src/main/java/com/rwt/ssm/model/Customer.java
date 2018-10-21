package com.rwt.ssm.model;

import org.springframework.stereotype.Component;

/**
 * @author
 * @date
 *
 */

public class Customer {
    static {
        System.out.println("Customer 加载");
    }
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer() {
        System.out.println("Customer 对象构建");
        System.out.println("Customer"+this.toString());
    }
}
