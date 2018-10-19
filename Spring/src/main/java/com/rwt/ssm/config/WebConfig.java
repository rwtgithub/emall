package com.rwt.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


@Configuration
@ComponentScan("com.rwt.ssm.controller")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurationSupport {

     @Bean
    public ViewResolver viewResolver(SpringTemplateEngine springTemplateEngine){
         ThymeleafViewResolver thymeleafViewResolver=new ThymeleafViewResolver();
         thymeleafViewResolver.setTemplateEngine(springTemplateEngine);
         return  thymeleafViewResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver iTemplateResolver) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver();
        return engine;
    }
    @Bean
    public ITemplateResolver iTemplateResolver(){
         ServletContextTemplateResolver servletContextTemplateResolver=new ServletContextTemplateResolver();
    }
    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
