package com.deng.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 邓霖
 * @Date 2022/10/29 14:37
 * @注解
 */
public class BaseTest {
    @Test
    public void test2() throws Exception{
        //连接池配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxWaitMillis(1000);
        config.setMaxTotal(20);
        //获取连接池对象
        JedisPool pool = new JedisPool(config, "localhost", 6379, 200, "123456");
        //从连接池中取得连接
        Jedis jedis = pool.getResource();
        //设置
        jedis.set("address","九眼桥");
        System.out.println(jedis.get("address"));

        jedis.close();

    }
    @Test
    public void test1() throws Exception{
        //获取Jedis对象 = 连接对象，需要提供主机地址，端口号，超时时间
        //其中port和timeout可以不写，默认就是6379和2s钟
        Jedis jedis = new Jedis("localhost",6379);
        jedis.auth("123456");
        jedis.set("name","24");
        System.out.println(jedis.get("name"));
        jedis.close();
    }
}
