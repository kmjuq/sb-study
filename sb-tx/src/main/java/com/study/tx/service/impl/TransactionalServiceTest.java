package com.study.tx.service.impl;

import com.study.tx.service.ITransactionalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/8 17:26
 */
@Slf4j
@Service
public class TransactionalServiceTest implements ITransactionalService {

    @Autowired
    private TransactionalServiceImpl transactionalService;

    @Override
    public void propagationRequired() {
        transactionalService.propagationRequired();
        transactionalService.propagationMandatory();
    }

    @Override
    // @Transactional(propagation = Propagation.MANDATORY)
    // @Transactional(propagation = Propagation.REQUIRED)
    // 无 @Transactional
    public void propagationMandatory() {
        transactionalService.propagationMandatory();
    }

    @Override
    public void propagationNested() {

    }

    @Override
    public void propagationNever() {

    }

    @Override
    public void propagationNotSupported() {

    }

    @Override
    public void propagationRequiresNew() {

    }

    @Override
    public void propagationSupports() {

    }

    @Override
    public void isolationDefault() {

    }

    @Override
    public void isolationReadCommitted() {

    }

    @Override
    public void isolationReadUncommitted() {

    }

    @Override
    public void isolationRepeatableRead() {

    }

    @Override
    public void isolationSerializable() {

    }
}
