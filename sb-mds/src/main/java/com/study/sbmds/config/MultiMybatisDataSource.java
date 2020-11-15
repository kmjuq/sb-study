package com.study.sbmds.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/10/23 03:22
 */
@Configuration
@ConditionalOnProperty(prefix = "persist",name = "type",havingValue = "mybatis")
public class MultiMybatisDataSource {

    @Primary
    @Bean("dataSource1")
    @ConfigurationProperties("spring.datasource.ds1")
    public DataSource getDS1(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean("dataSource2")
    @ConfigurationProperties("spring.datasource.ds2")
    public DataSource getDS2(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Primary
    @Bean("ds1SqlSessionFactory")
    public SqlSessionFactory getDS1SqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(getDS1());
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/ds1/**/*Mapper.xml")
        );
        return bean.getObject();
    }

    @Bean("ds2SqlSessionFactory")
    public SqlSessionFactory getDS2SqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(getDS1());
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/ds2/**/*Mapper.xml")
        );
        return bean.getObject();
    }

    @Bean("ds1TransactionManger")
    public DataSourceTransactionManager ds1TransactionManger(@Qualifier("dataSource1") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("ds2TransactionManger")
    public DataSourceTransactionManager ds2TransactionManger(@Qualifier("dataSource2") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean("ds1SqlSessionTemplate")
    public SqlSessionTemplate getDS1Sqlsessiontemplate(
            @Qualifier("ds1SqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }

    @Bean("ds2SqlSessionTemplate")
    public SqlSessionTemplate getDS2Sqlsessiontemplate(
            @Qualifier("ds2SqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }

}

@Configuration
@MapperScan(
        basePackages = "**.mapper.ds1.**",
        sqlSessionFactoryRef = "ds1SqlSessionFactory",
        sqlSessionTemplateRef = "ds1SqlSessionTemplate"
)
class DS1MybatisConfig{

}

@Configuration
@MapperScan(
        basePackages = "**.mapper.ds2.**",
        sqlSessionFactoryRef = "ds2SqlSessionFactory",
        sqlSessionTemplateRef = "ds2SqlSessionTemplate"
)
class DS2MybatisConfig{

}