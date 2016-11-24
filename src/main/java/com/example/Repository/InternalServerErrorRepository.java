package com.example.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * Created by anthonyrey on 23/11/2016.
 */
@Repository
public class InternalServerErrorRepository {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void increment(){
        redisTemplate.opsForValue().increment(LocalDate.now().toString(), 1);
    }

    public String getTodayCount(){
        return redisTemplate.opsForValue().get(LocalDate.now().toString());
    }

}
