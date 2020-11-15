package com.study.sbredis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/13 01:28
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration());
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(){
        return new StringRedisTemplate(redisConnectionFactory());
    }

    @Bean("valueOperationsForStr")
    public ValueOperations<String,String> valueOperationsForStr(){
        return stringRedisTemplate().opsForValue();
    }

    @Bean("listOperationsForStr")
    public ListOperations<String,String> listOperationsForStr(){
        return stringRedisTemplate().opsForList();
    }

    @Bean("hashOperationsForStr")
    public HashOperations<String,String,String> hashOperationsForStr(){
        return stringRedisTemplate().opsForHash();
    }

    @Bean("setOperationsForStr")
    public SetOperations<String,String> setOperationsForStr(){
        return stringRedisTemplate().opsForSet();
    }

    @Bean("zSetOperationsForStr")
    public ZSetOperations<String,String> zSetOperationsForStr(){
        return stringRedisTemplate().opsForZSet();
    }

    @Bean
    public RedisTemplate<String, Object> restTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        template.setConnectionFactory(redisConnectionFactory());

        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(RedisSerializer.json());

        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(RedisSerializer.json());

        template.afterPropertiesSet();
        return template;
    }

    @Bean("valueOperationsForObj")
    public ValueOperations<String, Object> valueOperationsForObj() {
        return restTemplate().opsForValue();
    }

    @Bean("listOperationsForObj")
    public ListOperations<String, Object> listOperationsForObj() {
        return restTemplate().opsForList();
    }

    @Bean("hashOperationsForObj")
    public HashOperations<String, String, Object> hashOperationsForObj() {
        return restTemplate().opsForHash();
    }

    @Bean("setOperationsForObj")
    public SetOperations<String, Object> setOperationsForObj() {
        return restTemplate().opsForSet();
    }

    @Bean("zSetOperationsForObj")
    public ZSetOperations<String, Object> zSetOperationsForObj() {
        return restTemplate().opsForZSet();
    }

}
