package com.study.tx.controller;

import api.jpa.dto.TaskTemplateService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/18 22:03
 */
@RestController
@RequestMapping("/dubbo/consumer")
public class DubboConsumerController {

    @DubboReference(version = "1")
    public TaskTemplateService taskTemplateService;

    @RequestMapping("/{name}")
    public String dubboHello(@PathVariable("name") String name){
        return taskTemplateService.dubboHello(name);
    }

}
