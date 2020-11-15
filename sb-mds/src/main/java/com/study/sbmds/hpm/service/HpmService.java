package com.study.sbmds.hpm.service;

import com.study.sbmds.config.MultiDataSourceTransactional;
import com.study.sbmds.hpm.dao.ds1.ProductJpaRepository;
import com.study.sbmds.hpm.dao.ds2.PersonJpaRepository;
import com.study.sbmds.hpm.entity.ds1.Product;
import com.study.sbmds.hpm.entity.ds2.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/10/25 16:54
 */
@Slf4j
@Service
public class HpmService {

    @Autowired
    ProductJpaRepository productJpaRepository;
    @Autowired
    PersonJpaRepository personJpaRepository;

    @MultiDataSourceTransactional(transactionManagers = {"ds1TransactionManager","ds2TransactionManager"})
    public void multiDataSourceTransactionRollBack(){
        productJpaRepository.save(new Product().setName("PS4").setPrice(new BigDecimal("2873")).setSupplier("sony"));
        personJpaRepository.save(new Person().setName("zzz").setAge((byte) 36).setIdCard("112311234412312312"));
        System.out.println(1/0);
    }

}
