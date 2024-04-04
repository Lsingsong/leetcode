package com.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.dao", sqlSessionFactoryRef = "postgreSqlSessionTemplate")
public class PostgreDataSourceConfig {

    @Bean(name = "postgreDataSource")
    @Qualifier("postgreDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.postgre")
    @Primary
    public DataSource postgreDataSource() {
        System.out.println("postgre init now");
        return DataSourceBuilder.create().build();
    }

    @Bean(name="postgreDataSourceFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("postgreDataSource") DataSource postgreDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(postgreDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/pg/*.xml"));
        return bean.getObject();
    }

    @Bean(name="postgreDataSourceFactory")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("postgreDataSource") DataSource postgreDataSource) throws Exception {
        return new DataSourceTransactionManager(postgreDataSource);
    }

    @Bean(name="postgreDataSourceFactory")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("postgreDataSourceFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
