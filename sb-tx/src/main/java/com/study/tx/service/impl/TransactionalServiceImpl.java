package com.study.tx.service.impl;

import api.jpa.dto.TaskTemplateCol;
import api.jpa.dto.TaskTemplateService;
import com.study.tx.service.ITransactionalService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/7/5 18:31
 */
@Slf4j
@Service
public class TransactionalServiceImpl implements ITransactionalService {

    @DubboReference(version = "1")
    public TaskTemplateService taskTemplateColService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void propagationRequired() {
        final TaskTemplateCol taskTemplateCol = taskTemplateColService.findOneByTemplateColId(1L);
        taskTemplateColService.deleteByTemplateColId(taskTemplateCol.getTemplateColId());
//        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void propagationMandatory() {
        taskTemplateColService.save(new TaskTemplateCol()
                .setTemplateId(256L)
                .setSerialNumber(2L)
                .setColName("COL2")
                .setColDesc("Jpa Manda dubbo")
                .setFormatCode("jiujiii")
                .setRequiredFlag("Y")
        );
    }

    @Transactional(propagation = Propagation.NESTED)
    public void propagationNested() {

    }

    @Transactional(propagation = Propagation.NEVER)
    public void propagationNever() {

    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void propagationNotSupported() {

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void propagationRequiresNew() {

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void propagationSupports() {

    }

    @Transactional(isolation = Isolation.DEFAULT)
    public void isolationDefault() {

    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void isolationReadCommitted() {

    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void isolationReadUncommitted() {

    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void isolationRepeatableRead() {

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void isolationSerializable() {

    }
}






