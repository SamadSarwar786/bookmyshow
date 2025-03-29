package com.example.BMS.services;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService implements CacheService{

    private final StringRedisTemplate stringRedisTemplate;

    public RedisService(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value, 2, TimeUnit.MINUTES);
    }

    @Override
    public String get(String key) {

        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void delete(String key) {
     stringRedisTemplate.delete(key);
    }

    @Override
    public void getAllKeysAndValues() {

    }

    @Override
    public void deleteAll() {
        stringRedisTemplate.delete(stringRedisTemplate.keys("*"));
    }
}
