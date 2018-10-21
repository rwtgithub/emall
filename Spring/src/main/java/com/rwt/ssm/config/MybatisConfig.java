package com.rwt.ssm.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration

public class MybatisConfig {
    /*@Bean
    public SqlSessionFactory sqlSessionFactory(org.apache.ibatis.session.Configuration configuration){
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(configuration);
        return build;
    }*/
    @Bean
    public DataSource dataSource() {
        Properties properties = new Properties();
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("dbcp.properties");


        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            return BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManage(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource resource=new ClassPathResource("mybatis/mybatis_conf.xml");
        Resource []resource1={new ClassPathResource("mybatis/mappers/User.xml")};
        Resource[] resources = new Resource[0];
        try {
            resources = new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mappers/User.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //sqlSessionFactoryBean.setConfigLocation(resource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.rwt.ssm.model");
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean;
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage("com.rwt.ssm.dao");
        return mapperScannerConfigurer;
    }
    /*@Bean
    public org.apache.ibatis.session.Configuration configuration(Environment environment){
        org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration(environment);
        configuration.addMappers("com.rwt.ssm.mybatismapper");
        return configuration;*//*
    }*/
    /*@Bean
    public Environment environment(DataSource dataSource){
        TransactionFactory transactionFactory=new JdbcTransactionFactory();
        Environment environment=new Environment("develpment",transactionFactory,dataSource);
        return environment;
    }*/





}

