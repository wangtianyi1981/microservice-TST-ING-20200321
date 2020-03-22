package com.fhit.test.microredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisClusterNode;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author wty
 * @create 2020-03-14 17:48
 */
@Configuration
public class Appconfig2 {
    public static final String hostName = "192.168.2.128";
    public static final int port_7001 = 7001;
    public static final int port_7004 = 7004;
    public static final String hostName2 = "192.168.2.129";
    public static final int port_7002 = 7002;
    public static final int port_7005 = 7005;
    public static final String hostName3 = "192.168.2.130";
    public static final int port_7003 = 7003;
    public static final int port_7006 = 7006;

    /**
     * 集群指定端口，密码登录
     *
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        redisClusterConfiguration.addClusterNode(new RedisClusterNode(hostName, port_7001));
        redisClusterConfiguration.addClusterNode(new RedisClusterNode(hostName2, port_7002));
        redisClusterConfiguration.addClusterNode(new RedisClusterNode(hostName3, port_7003));
        redisClusterConfiguration.addClusterNode(new RedisClusterNode(hostName, port_7004));
        redisClusterConfiguration.addClusterNode(new RedisClusterNode(hostName2, port_7005));
        redisClusterConfiguration.addClusterNode(new RedisClusterNode(hostName3, port_7006));
        JedisConnectionFactory factory = new JedisConnectionFactory(redisClusterConfiguration);
        redisClusterConfiguration.setPassword("fhit123");

        return factory;
    }

    @Bean
    public StringRedisTemplate stringRdisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);

        return stringRedisTemplate;
    }

    @Bean
    public RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);

        return redisTemplate;
    }
}
