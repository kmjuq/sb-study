package com.study.tx.controller;

import api.jpa.dto.TaskTemplateService;
import com.study.tx.service.impl.TransactionalServiceTest;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/7/5 18:38
 */
@RestController
@RequestMapping("/tx")
public class TransactionalController {

    @Autowired
    public TransactionalServiceTest transactionalService;

    @RequestMapping("/propagation/required")
    public void propagationRequired() {
        transactionalService.propagationRequired();
    }

    @RequestMapping("/propagation/mandatory")
    public void propagationMandatory() {
        transactionalService.propagationMandatory();
    }

    @RequestMapping("/propagation/nested")
    public void propagationNested() {
        transactionalService.propagationNested();
    }

    @RequestMapping("/propagation/never")
    public void propagationNever() {
        transactionalService.propagationNever();
    }

    @RequestMapping("/propagation/not/supported")
    public void propagationNotSupported() {
        transactionalService.propagationNotSupported();
    }

    @RequestMapping("/propagation/required/new")
    public void propagationRequiresNew() {
        transactionalService.propagationRequiresNew();
    }

    @RequestMapping("/propagation/supports")
    public void propagationSupports() {
        transactionalService.propagationSupports();
    }

    @RequestMapping("/isolation/default")
    public void isolationDefault() {
        transactionalService.isolationDefault();
    }

    @RequestMapping("/isolation/read/committed")
    public void isolationReadCommitted() {
        transactionalService.isolationReadCommitted();
    }

    @RequestMapping("/isolation/read/uncommitted")
    public void isolationReadUncommitted() {
        transactionalService.isolationReadUncommitted();
    }

    @RequestMapping("/isolation/repeatable/read")
    public void isolationRepeatableRead() {
        transactionalService.isolationRepeatableRead();
    }

    @RequestMapping("/isolation/serializable")
    public void isolationSerializable() {
        transactionalService.isolationSerializable();
    }

}