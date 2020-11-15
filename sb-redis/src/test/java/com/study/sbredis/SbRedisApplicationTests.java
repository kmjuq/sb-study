package com.study.sbredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbRedisApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {

    }

    @Test
    public void demo1() {
//        for (int i = 0; i < 50000; i++) {
//            stringRedisTemplate.opsForList().leftPush("list_test","kmj");
//        }
        for (int i = 0; i < 50000; i++) {
            System.out.println(stringRedisTemplate.opsForList().rightPop("list_test"));
        }
    }

}
