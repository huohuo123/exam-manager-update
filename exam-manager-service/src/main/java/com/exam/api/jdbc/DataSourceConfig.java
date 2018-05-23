package com.exam.api.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @Author:HuoYaJing
 * @Description:
 * @Date: Create in 18:15 2018/5/21
 */
@Configuration
@PropertySource({"classpath:dev/application-db.properties"})
public class DataSourceConfig {


    @Value("${datasource.exam.url}")
    private String examUrl;
    @Value("${datasource.exam.username}")
    private String examUserName;
    @Value("${datasource.exam.password}")
    private String examPassword;


    @Bean(value = "examDB")
    @Primary
    public DataSource getExamDataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setName("examDB");
        druidDataSource.setUrl(examUrl);
        druidDataSource.setUsername(examUserName);
        druidDataSource.setPassword(examPassword);

        return druidDataSource;

    }
}
