package com.rwt.ssm.config;

import com.rwt.ssm.AOP.Time;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.rwt.ssm"},excludeFilters = {@ComponentScan.Filter(EnableWebMvc.class)})
@EnableAspectJAutoProxy
public class RootConfig {
    @Bean
    public Time time(){
        return new Time();
    }

}
