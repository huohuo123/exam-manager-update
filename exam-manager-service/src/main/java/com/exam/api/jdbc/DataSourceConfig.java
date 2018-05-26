package com.exam.api.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
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

    @Value("${datasource.maxActive}")
    private int maxActive;
    @Value("${datasource.initialSize}")
    private int initialSize;
    @Value("${datasource.maxWaitMillis}")
    private long maxWaitMillis;
    @Value("${datasource.minIdle}")
    private int minIdle;
    @Value("${datasource.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    @Value("${datasource.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
    @Value("${datasource.validationQuery}")
    private String validationQuery;
    @Value("${datasource.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${datasource.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${datasource.testOnReturn}")
    private boolean testOnReturn;



    @Bean(value = "examDB")
    @Primary
    public DataSource getExamDataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setName("examDB");
        druidDataSource.setUrl(examUrl);
        druidDataSource.setUsername(examUserName);
        druidDataSource.setPassword(examPassword);

        //druidDataSource配置
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxWait(maxWaitMillis);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        return druidDataSource;

    }


    /**
     * 注册一个StatViewServlet
     * @return
     */
    //todo ServletRegistrationBean urlMapping不懂
   /* public ServletRegistrationBean druidStatViewServlet(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new StatViewServlet());

        //添加初始化参数：initParams
        //白名单
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny","192.168.1.73");
        //登录查看账号信息和密码
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("resetEnable","false");
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }*/

    /**
     * 注册一个：filterRegistrationBean
     * @return
     */
    /*public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico");
        return filterRegistrationBean;
    }*/
}
