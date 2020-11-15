package com.study.sbmds.hpm.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HpmServiceTest {

    @Autowired
    HpmService hpmService;

    @Test
    void multiDataSourceTransactionRollBack() {
        hpmService.multiDataSourceTransactionRollBack();
    }
}