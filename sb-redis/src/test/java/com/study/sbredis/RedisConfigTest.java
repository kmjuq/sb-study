package com.study.sbredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisConfigTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    @Qualifier("hashOperationsForStr")
    private HashOperations<String,String,String> hashOperations;

    @Test
    void stringRedisTemplate() {
    }

    @Test
    void hashOperations() {

    }

    @Test
    void valueOperations() {
    }

    @Test
    void listOperations() {
    }

    @Test
    void setOperations() {
    }

    @Test
    void zSetOperations() {
    }

    @Test
    void restTemplate() {
    }

    @Test
    void testHashOperations() {
    }

    @Test
    void testValueOperations() {
    }

    @Test
    void testListOperations() {
    }

    @Test
    void testSetOperations() {
    }

    @Test
    void testZSetOperations() {
    }
}