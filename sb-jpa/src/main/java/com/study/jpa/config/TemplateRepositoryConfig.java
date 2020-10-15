package com.study.jpa.config;

import com.study.jpa.domain.TaskTemplateDefine;
import com.study.jpa.repository.TaskTemplateDefineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

/**
 * <p>
 * Bean配置
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020-01-09 01:27
 */
@Configuration
@Slf4j
public class TemplateRepositoryConfig {

    @Autowired
    private TaskTemplateDefineMapper taskTemplateDefineMapper;

    @Bean("taskTemplateDefineLongSimpleJpaRepository")
    public SimpleJpaRepository<TaskTemplateDefine,Long> taskTemplateDefineLongSimpleJpaRepository(EntityManager em){
        log.info("mapper bean 注入 {}",taskTemplateDefineMapper);
        return new SimpleJpaRepository<>(TaskTemplateDefine.class, em);
    }

//    @Bean("taskTemplateColLongSimpleJpaRepository")
//    public SimpleJpaRepository<TaskTemplateCol,Long> taskTemplateColLongSimpleJpaRepository(EntityManager em){
//        return new SimpleJpaRepository<>(TaskTemplateCol.class, em);
//    }

}
