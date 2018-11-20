package com.exam.api.jdbc;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author:HuoYaJing
 * @Description:
 * @Date: Create in 18:55 2018/5/21
 */
@Configuration
public class SQLManagerConfig {

    @Bean(name = "sqlManagerFactoryBean")
    @Primary
    public SqlManagerFactoryBean getSqlManagerFactoryBean(@Qualifier("datasource")DataSource master){
        SqlManagerFactoryBean factoryBean=new SqlManagerFactoryBean();
        BeetlSqlDataSource source=new BeetlSqlDataSource();
        source.setMasterSource(master);
        factoryBean.setCs(source);
        factoryBean.setDbStyle(new MySqlStyle());
        //最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
        factoryBean.setInterceptors(new Interceptor[]{new SqlPrintInterceptor()});
        //开启驼峰
        factoryBean.setNc(new UnderlinedNameConversion());
        //sql文件路径
        factoryBean.setSqlLoader(new ClasspathLoader("/sql"));
        return factoryBean;
    }

    /**
     * 配置包扫描
     * @return
     */
    @Bean(name = "beetlSqlScannerConfigurer")
    public BeetlSqlScannerConfigurer getBeetlSqlScannerConfigurer() {
        BeetlSqlScannerConfigurer conf = new BeetlSqlScannerConfigurer();
        conf.setBasePackage("com.exam.api.dao");
        conf.setDaoSuffix("Dao");
        conf.setSqlManagerFactoryBeanName("sqlManagerFactoryBean");
        return conf;
    }
}
