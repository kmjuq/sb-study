package com.study.tx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TransactionalService {

    @Autowired
    private TxJapRepository txJapRepository;
    @Autowired
    private TransactionalService transactionalService;

    public void noPropagation(){
        txJapRepository.save(new TxTransaction().setName("no"));
        transactionalService.propagationRequiresNew();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void propagationRequired() {
        txJapRepository.save(new TxTransaction().setName("propagationRequired"));
        transactionalService.propagationNested();
    }


    @Transactional(propagation = Propagation.MANDATORY)
    public void propagationMandatory() {

    }

    @Transactional(propagation = Propagation.NESTED)
    public void propagationNested() {
        txJapRepository.save(new TxTransaction().setName("propagationNested"));
        System.out.println(1 / 0);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void propagationNever() {

    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void propagationNotSupported() {

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void propagationRequiresNew() {
        txJapRepository.save(new TxTransaction().setName("propagationRequiresNew"));
        System.out.println(1 / 0);
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






