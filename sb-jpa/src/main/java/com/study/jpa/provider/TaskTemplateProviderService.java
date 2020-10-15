package com.study.jpa.provider.impl;

import com.study.jpa.domain.TaskTemplateCol;
import com.study.jpa.provider.TaskTemplateProviderService;
import com.study.jpa.repository.TaskTemplateColRepository;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collections;
import java.util.List;

@DubboService(version = "1")
public class TaskTemplateProviderServiceImpl implements TaskTemplateProviderService {

    private final TaskTemplateColRepository taskTemplateColRepository;

    public TaskTemplateProviderServiceImpl(TaskTemplateColRepository taskTemplateColRepository) {
        this.taskTemplateColRepository = taskTemplateColRepository;
    }

    @Override
    public TaskTemplateCol findOneByTemplateColId(Long id) {
        return taskTemplateColRepository
                .findByTemplateColId(id)
                .orElse(new TaskTemplateCol());
    }

    @Override
    public List<TaskTemplateCol> findAllByTemplateId(Long id) {
        return taskTemplateColRepository
                .findByTemplateId(id)
                .orElse(Collections.emptyList());
    }

    @Override
    public TaskTemplateCol save(TaskTemplateCol ttlc) {
        return taskTemplateColRepository.save(ttlc);
    }

    @Override
    public void deleteByTemplateColId(Long id) {
        taskTemplateColRepository.deleteByTemplateColId(id);
    }
}
