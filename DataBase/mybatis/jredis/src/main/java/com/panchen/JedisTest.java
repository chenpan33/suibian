package com.panchen;

import com.panchen.utils.JedisUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @author panda
 * @description:测试五种数据结构 string hash list set sortSet
 * @date 2021/4/3 21:32
 */
public class JedisTest {
    private static Jedis jedis= JedisUtils.getJedis();
    @Before
    public void before() {
        jedis.flushAll();
    }

//1测试string 增删改查
    @Test
    public void TestString(){
        //set get
        jedis.set("name1", "Rick");
        jedis.set("age1", "54");
        String name1 = jedis.get("name1");
        System.out.println(name1);
        //incr 增加1
        Long age1 = jedis.incr("age1");
        System.out.println(age1);
    }

//2测试hash增删改查--存放对象
    @Test
    public void TestHash(){
        jedis.hset("yingmu","age","18");
        jedis.hset("yingmu","hobby","basketball");
        System.out.println(jedis.hgetAll("yingmu"));
    }


//3测试list增删改查
    @Test
    public void TestList(){
        //push添加
        jedis.lpush("myList","1","2","2","3","4","5");
        System.out.println(jedis.lrange("myList", 0, 100));
        //pop
        System.out.println(jedis.lpop("myList"));
        //len
        System.out.println(jedis.llen("myList"));
    }

//4测试set增删改查
    @Test
    public void TestSet(){
        //sadd
        jedis.sadd("teacher","changfeng","jingtian","tianming","ciggar");
        jedis.sadd("people","gong","rick","jack","ciggar");
        //smembers
        Set<String> teacher = jedis.smembers("teacher");
        System.out.println("techer"+teacher);

        //scard key
        Long teacher1 = jedis.scard("teacher");
        System.out.println(teacher1);

        //sinter交集
        Set<String> sinter = jedis.sinter("teacher", "people");
        System.out.println(sinter);

        //sunion并集
        Set<String> sunion = jedis.sunion("teacher", "people");
        System.out.println(sunion);

        //smove元素移动
        Long smove = jedis.smove("teacher", "people","ciggar");
        System.out.println(smove);

    }


//5测试sortSet增删改查
    @Test
    public void TestSortSet(){
        //zadd
        jedis.zadd("agetable",99,"mizhitian");
        //zcard
        Long ageTable = jedis.zcard("ageTable");
        System.out.println(ageTable);

        //zcount
        Long agetable = jedis.zcount("agetable",0,1);
        System.out.println(ageTable);
        //zincrby
        Double zincrby = jedis.zincrby("ageTable", 99, "mizhitian");
        System.out.println(zincrby);
        //zrank
        Long zrank = jedis.zrank("agetable", "mizhitian");
        System.out.println(zrank);

    }
}