package com.fhit.test.microredis;

import com.fhit.test.microredis.config.Appconfig;
import com.fhit.test.microredis.config.Appconfig2;
import com.fhit.test.microredis.connect.ConnectRedis;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;

/**
 * @author wty
 * @create 2020-04-14 18:09
 */
public class TestRedis {
    public static void main(String[] args) throws IOException {
        // 通过springdata连接redis单机版
//        testRedisSingle_new();
        testRedisCluster_new();
//        testRedisCluster_old();
    }

    public static void testRedisSingle_new() {
        //        AnnotationConfigApplicationContext annotationConfigApplicationContext =
//                new AnnotationConfigApplicationContext();
//        annotationConfigApplicationContext.register(Appconfig.class);
//        annotationConfigApplicationContext.refresh();

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Appconfig.class);

        StringRedisTemplate redisTemplate = annotationConfigApplicationContext.getBean(StringRedisTemplate.class);
        String value = redisTemplate.opsForValue().get("wty");
        System.out.println("redis wty=" + value);
    }

    public static void testRedisCluster_new() {
        //        AnnotationConfigApplicationContext annotationConfigApplicationContext =
//                new AnnotationConfigApplicationContext();
//        annotationConfigApplicationContext.register(Appconfig2.class);
//        annotationConfigApplicationContext.refresh();

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Appconfig2.class);

        StringRedisTemplate redisTemplate = annotationConfigApplicationContext.getBean(StringRedisTemplate.class);
//        redisTemplate.opsForValue().set("wty2", "wly2");
//        redisTemplate.opsForValue().set("wty3", "wly3");
//        redisTemplate.opsForValue().set("wty4", "wly4");

        String value = redisTemplate.opsForValue().get("wty2");
        System.out.println("redis wty2=" + value);
         value = redisTemplate.opsForValue().get("wty3");
        System.out.println("redis wty3=" + value);
         value = redisTemplate.opsForValue().get("wty4");
        System.out.println("redis wty4=" + value);
    }

    public static void testRedisCluster_old() throws IOException {
        ConnectRedis connectRedis = new ConnectRedis();
        connectRedis.testRedisCluster();
    }
}
