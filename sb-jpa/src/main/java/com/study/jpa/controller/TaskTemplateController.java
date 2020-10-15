package com.study.jpa.controller;

import com.study.jpa.domain.TaskTemplateDefine;
import com.study.jpa.service.ITaskTemplateDefineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020-01-09 01:56
 */
@RestController
@RequestMapping("/task/template")
public class TaskTemplateController {

    private final ITaskTemplateDefineService taskTemplateDefineService;

    public TaskTemplateController(ITaskTemplateDefineService taskTemplateDefineService) {
        this.taskTemplateDefineService = taskTemplateDefineService;
    }

    @RequestMapping("/define/{id}")
    public ResponseEntity<TaskTemplateDefine> findTaskTemplateDefineById(@PathVariable("id") Long id){
        return ResponseEntity.ok(taskTemplateDefineService.findById(id));
    }

}
