package com.fhit.test.microredis.connect;

import com.fhit.test.microredis.config.Appconfig;
import com.fhit.test.microredis.config.Appconfig2;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wty
 * @create 2020-03-14 18:26
 */
public class ConnectRedis {
    /**
     * 单机版默认端口，免密
     * 连接单个Redis服务器
     */
    public void testRedis() throws Exception {

        //和Redis服务器创建连接，参数为Redis服务器所在电脑Ip和Redis的端口号
//        Jedis jedis = new Jedis(Appconfig.hostName, Appconfig.port_7001);
        Jedis jedis = new Jedis(Appconfig.hostName);

        //设值，Redis中的集合命令对应Jedis的方法名称
        jedis.set("linKey", "linValue");
        String result = jedis.get("linKey");

        System.out.println(result);

        //用完关闭连接
        jedis.close();
    }

    /**
     * 单机版默认端口，免密
     * 用连接池连接单个Redis服务器
     */
    public void testRedisPool() {
        //创建连接池，连接池为单例的，参数为Redis服务器所在linux系统ip和端口号
//        JedisPool jedisPool = new JedisPool(Appconfig.hostName, Appconfig.port_7001);
        JedisPool jedisPool = new JedisPool(Appconfig.hostName);

        //从连接池中获取一个连接
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.get("linKey"));

        //关闭连接，被连接池回收
        jedis.close();

        //关闭连接池
        jedisPool.close();
    }

    /**
     * 连接Redis集群
     */
    public void testRedisCluster() throws IOException {
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(new HostAndPort(Appconfig2.hostName, Appconfig2.port_7001));
        nodes.add(new HostAndPort(Appconfig2.hostName2, Appconfig2.port_7002));
        nodes.add(new HostAndPort(Appconfig2.hostName3, Appconfig2.port_7003));
        nodes.add(new HostAndPort(Appconfig2.hostName, Appconfig2.port_7004));
        nodes.add(new HostAndPort(Appconfig2.hostName2, Appconfig2.port_7005));
        nodes.add(new HostAndPort(Appconfig2.hostName3, Appconfig2.port_7005));

//        JedisCluster jedisCluster = new JedisCluster(nodes);  // 连接不需要密码
        JedisCluster jedisCluster = new JedisCluster(nodes, 10000,
                1000, 1,
                "fhit123", new GenericObjectPoolConfig());// 连接需要密码

        jedisCluster.set("wty5", "yy");

        System.out.println(jedisCluster.get("wty1"));
        System.out.println(jedisCluster.get("wty2"));
        System.out.println(jedisCluster.get("wty5"));
        System.out.println(jedisCluster.get("wty"));
        System.out.println(jedisCluster.get("wty8"));

        //关闭连接
        jedisCluster.close();
    }
}
