package com.exam.api.boot;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author:HuoYaJing
 * @Description:springboot 启动
 * @Date: Create in 14:37 2018/5/18
 */
@SpringBootApplication(scanBasePackages = {"com.exam.api"})
@PropertySource({"classpath:application.properties"})
@ComponentScan(basePackages = {"com.exam.api"})
//表示开启AOP代理自动配
@EnableAspectJAutoProxy
//启用MVC Java config
@EnableWebMvc
//自动开启动态代理配置
@EnableCaching(proxyTargetClass = true)
//通过@EnableScheduling注解开启对计划任务的支持
@EnableScheduling
@EnableConfigurationProperties
@EnableTransactionManagement
@EnableAsync(proxyTargetClass = true)
//ApplicationContextAware 获取它所在的Spring容器
public class Bootstrap extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


}
