package com.study.jpa.service.impl;

import com.study.jpa.domain.TaskTemplateCol;
import com.study.jpa.repository.TaskTemplateColRepository;
import com.study.jpa.service.ITaskTemplateColService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020-01-09 01:45
 */
@Service
public class TaskTemplateColServiceImpl implements ITaskTemplateColService {

    private final TaskTemplateColRepository taskTemplateColRepository;

    public TaskTemplateColServiceImpl(TaskTemplateColRepository taskTemplateColRepository) {
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
