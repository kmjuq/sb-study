package com.study.jpa.provider;

import api.jpa.dto.TaskTemplateService;
import api.jpa.dto.TaskTemplateCol;
import cn.hutool.core.bean.BeanUtil;
import com.study.jpa.repository.TaskTemplateColRepository;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@DubboService(version = "1")
public class TaskTemplateProviderService implements TaskTemplateService {

    private final TaskTemplateColRepository taskTemplateColRepository;

    public TaskTemplateProviderService(TaskTemplateColRepository taskTemplateColRepository) {
        this.taskTemplateColRepository = taskTemplateColRepository;
    }

    @Override
    public TaskTemplateCol findOneByTemplateColId(Long id) {
        final com.study.jpa.domain.TaskTemplateCol source = taskTemplateColRepository
                .findByTemplateColId(id)
                .orElse(new com.study.jpa.domain.TaskTemplateCol());
        final TaskTemplateCol target = new TaskTemplateCol();
        BeanUtil.copyProperties(source, target);
        return target;
    }

    @Override
    public List<TaskTemplateCol> findAllByTemplateId(Long id) {
        return taskTemplateColRepository
                .findByTemplateId(id)
                .orElse(Collections.emptyList())
                .stream()
                .map(source -> {
                    final TaskTemplateCol target = new TaskTemplateCol();
                    BeanUtil.copyProperties(source, target);
                    return target;
                })
                .collect(Collectors.toList());
    }

    @Override
    public TaskTemplateCol save(TaskTemplateCol source) {
        final com.study.jpa.domain.TaskTemplateCol target = new com.study.jpa.domain.TaskTemplateCol();
        BeanUtil.copyProperties(source, target);
        taskTemplateColRepository.save(target);
        return source;
    }

    @Override
    public void deleteByTemplateColId(Long id) {
        taskTemplateColRepository.deleteByTemplateColId(id);
    }

    @Override
    public String dubboHello(String name) {
        return "dubbo,hello,my name is " + name;
    }


}
