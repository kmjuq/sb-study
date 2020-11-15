package com.study.sbmds.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/10/23 02:26
 */
@Configuration
@ConditionalOnProperty(prefix = "persist",name = "type",havingValue = "jpa")
public class MultiJpaDataSource {

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
    @Bean("ds1EntityManager")
    public LocalContainerEntityManagerFactoryBean getDS1EntityManager(EntityManagerFactoryBuilder builder){
        return builder.dataSource(getDS1()).packages("**.entity.ds1.**").build();
    }

    @Bean("ds2EntityManager")
    public LocalContainerEntityManagerFactoryBean getDS2EntityManager(EntityManagerFactoryBuilder builder){
        return builder.dataSource(getDS2()).packages("**.entity.ds2.**").build();
    }

    @Primary
    @Bean("ds1TransactionManager")
    public TransactionManager getDS1TransactionManager(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(Objects.requireNonNull(getDS1EntityManager(builder).getObject()));
    }

    @Bean("ds2TransactionManager")
    public TransactionManager getDS2TransactionManager(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(Objects.requireNonNull(getDS2EntityManager(builder).getObject()));
    }

}

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef="ds1EntityManager",
        transactionManagerRef="ds1TransactionManager",
        basePackages= {"**.dao.ds1"})
@ConditionalOnProperty(prefix = "persist",name = "type",havingValue = "jpa")
class DS1JpaConfig {
}

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef="ds2EntityManager",
        transactionManagerRef="ds2TransactionManager",
        basePackages= {"**.dao.ds2"})
@ConditionalOnProperty(prefix = "persist",name = "type",havingValue = "jpa")
class DS2JpaConfig {
}
