package com.panchen.utils;

import redis.clients.jedis.Jedis;

/**
 * @author panda
 * @description: 获取和Redis服务器之间的连接，然后创建一个Jedis客户端对象,可以进行jedis操作
 * @date 2021/4/3 16:04
 */
public class JedisUtils {
    static Jedis jedis;
    static {
        //获取和Redis服务器之间的连接，然后创建一个Jedis客户端对象
        jedis =new Jedis("127.0.0.1,6379");
    }
    public static Jedis getJedis(){
        return jedis;
    }

}

