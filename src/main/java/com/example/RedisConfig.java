package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by anthonyrey on 23/11/2016.
 */
@Configuration
public class RedisConfig {

    //ATTENTION IL FAUT ALLER SUR LE SERV ET MODIFIER REDIS.CONF (/jet/etc/redis)

    @Value("${hostname}")
    private String hostname;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("52.213.171.121");
        jedisConnectionFactory.setPort(6379);

        return jedisConnectionFactory;
    }




    @Bean
    public RedisTemplate<String, String> redisTemplate(){

        RedisTemplate<String, String> stringIntegerRedisTemplate = new RedisTemplate<>();
        stringIntegerRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        stringIntegerRedisTemplate.setDefaultSerializer(new StringRedisSerializer());
        return stringIntegerRedisTemplate;
    }
}
