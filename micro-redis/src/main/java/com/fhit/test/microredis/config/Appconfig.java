package com.fhit.test.microredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author wty
 * @create 2020-04-14 17:48
 */
@Configuration
public class Appconfig {
    public static final String hostName = "192.168.2.128";

    /**
     * 单机版默认端口，免密
     *
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(hostName);
        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration);

        return factory;
    }

    /**
     * 单机版默认端口，免密
     *
     * @return
     */
    @Bean
    public StringRedisTemplate stringRdisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);

        return stringRedisTemplate;
    }

    /**
     * 单机版默认端口，免密
     *
     * @return
     */
    @Bean
    public RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);

        return redisTemplate;
    }
}
