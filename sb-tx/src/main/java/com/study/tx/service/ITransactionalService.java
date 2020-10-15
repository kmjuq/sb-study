package com.study.tx.service;

public interface ITransactionalService {

    void propagationRequired();

    void propagationMandatory();

    void propagationNested();

    void propagationNever();

    void propagationNotSupported();

    void propagationRequiresNew();

    void propagationSupports();

    void isolationDefault();

    void isolationReadCommitted();

    void isolationReadUncommitted();

    void isolationRepeatableRead();

    void isolationSerializable();

}
