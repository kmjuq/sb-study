package com.study.jpa.service.impl;

import com.study.jpa.domain.TaskTemplateDefine;
import com.study.jpa.repository.TaskTemplateDefineMapper;
import com.study.jpa.service.ITaskTemplateDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020-01-09 01:42
 */
@Service
public class TaskTemplateDefineServiceImpl implements ITaskTemplateDefineService {

    private final SimpleJpaRepository<TaskTemplateDefine,Long> taskTemplateDefineLongSimpleJpaRepository;
    @Autowired
    private TaskTemplateDefineMapper taskTemplateDefineMapper;

    public TaskTemplateDefineServiceImpl(@Qualifier("taskTemplateDefineLongSimpleJpaRepository") SimpleJpaRepository<TaskTemplateDefine, Long> taskTemplateDefineLongSimpleJpaRepository) {
        this.taskTemplateDefineLongSimpleJpaRepository = taskTemplateDefineLongSimpleJpaRepository;
    }

    @Override
    public TaskTemplateDefine findById(Long id) {
//        return taskTemplateDefineLongSimpleJpaRepository.findById(id).orElse(new TaskTemplateDefine());
        return taskTemplateDefineMapper.findById(id);
    }
}
