package com.atguigu.redis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

import java.util.List;

/**
 * @author linhai
 * @create 2020-08-31 14:26
 */
public class AtguiguJedisTest {

    @Test
    public void testJedis(){
        String host = "192.168.1.106";
        int port = Protocol.DEFAULT_PORT;
        Jedis jedis = new Jedis(host, port);
        System.out.println(jedis.ping());
        jedis.lpush("fruit","apple","orange");
        jedis.close();
    }

    @Test
    public void testJedisPool(){
        String host = "192.168.1.106";
        int port = Protocol.DEFAULT_PORT;

        JedisPool jedisPool = new JedisPool(host, port);
        Jedis jedis = jedisPool.getResource();
        List<String> fruit = jedis.lrange("fruit", 0, -1);

        System.out.println(fruit);
        jedis.close();

    }



}
