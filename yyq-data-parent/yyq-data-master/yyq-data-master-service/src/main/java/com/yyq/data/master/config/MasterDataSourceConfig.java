package com.yyq.data.master.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by yangyunqi on 2017/5/11.
 */
@Configuration
@MapperScan(basePackages = MasterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

    static final String PACKAGE = "com.yyq.data.master.repository.master";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Value("${master.datasource.url}")
    private String url;
    @Value("${master.datasource.username}")
    private String username;
    @Value("${master.datasource.password}")
    private String password;
    @Value("${master.datasource.driverClassName}")
    private String driverClassName;
    @Value("${master.datasource.initialSize}")
    private int initialSize;
    @Value("${master.datasource.minIdle}")
    private int minIdle;
    @Value("${master.datasource.maxActive}")
    private int maxActive;
    @Value("${master.datasource.maxWait}")
    private long maxWait;
    @Value("${master.datasource.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    @Value("${master.datasource.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {

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
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;

    }

    @Primary
    @Bean
    public DataSource masterDataSource() {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);

        try {
            dataSource.setFilters("stat, wall, log4j");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataSource;
    }

    @Primary
    @Bean
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Primary
    @Bean
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception {

        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MasterDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}