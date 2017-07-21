package com.yyq.data.secondly.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by yangyunqi on 2017/3/22.
 */
@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driverClassName}")
    private String driver;

    private static final int initialSize = 5;
    private static final int minIdle = 5;
    private static final int maxActive = 20;
    private static final long maxWait = 60000;
    private static final long timeBetweenEvictionRunsMillis = 60000;
    private static final long minEvictableIdleTimeMillis = 300000;

    @Bean
    public ServletRegistrationBean DruidStatViewServlet() {

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

//        servletRegistrationBean.addInitParameter("allow","127.0.0.1"); //白名单
//        servletRegistrationBean.addInitParameter("deny","127.0.0.1");  //黑名单，优先于白名单
        servletRegistrationBean.addInitParameter("loginUsername","root");
        servletRegistrationBean.addInitParameter("loginPassword","admin123");
        servletRegistrationBean.addInitParameter("resetEnable","false");

        return servletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean druidStatFilter(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.css,*.gif,*.jpg,*.png,*.ico,/druid/*");

        return filterRegistrationBean;

    }

    @Bean
    public DataSource druidDataSource() {

        DruidDataSource druidDataSource = new DruidDataSource();

        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);

        try {
            druidDataSource.setFilters("stat, wall, log4j");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return druidDataSource;
    }
}

