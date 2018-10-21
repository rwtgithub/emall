package com.rwt.ssm.AOP;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Time {
     private long start;
     private long end;

    @Pointcut("execution(* *com.rwt.ssm.service.CustomerService.getCustomer(..) )")
    public void time(){}

    @Before("time()")
    public void start(){
         start = System.currentTimeMillis();
    }
    @After("time()")
    public void end(){
        end=System.currentTimeMillis();
        System.out.println("执行时间"+(end-start));
    }
}
