package com.example.msdb.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
public class SqlConfig {
 
    @Resource(name = "sqlDataSource")
    private DataSource sqlDataSource;
 
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setDataSource(sqlDataSource);
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*/*.xml"));
        Objects.requireNonNull(sqlSessionFactoryBean.getObject()).getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(sqlDataSource);
    }
 
}