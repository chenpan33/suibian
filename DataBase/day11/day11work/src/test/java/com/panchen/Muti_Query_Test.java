package com.panchen;

import com.panchen.dto.BallArmy;
import com.panchen.dto.User;
import com.panchen.mapper.BallArmyMapper;
import com.panchen.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author panda
 * @description:测试分次查询
 * @date 2021/4/2 20:02
 */
public class Muti_Query_Test {
    static SqlSession sqlSession;
    static UserMapper userMapper;
    static BallArmyMapper ballArmyMapper;

    @BeforeClass
    public static void init() throws IOException {
        // 需要去加载Mybatis,然后启动Mybatis,然后执行sql，获取结果

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 第二步
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 创建一个SqlSessionFactory
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        // 创建Sqlsession
        sqlSession = sessionFactory.openSession();

        userMapper = sqlSession.getMapper(UserMapper.class);
        ballArmyMapper = sqlSession.getMapper(BallArmyMapper.class);


    }

    @AfterClass
    public static void destory(){

        sqlSession.commit();
        sqlSession.close();

    }

    //user与userDetail进行一对一分次查询
    @Test
    public void TestOne2One(){
        User user=userMapper.selectUserWithDetailById(2);
        System.out.println(user);
    }



    //进行一对多查询,根据球队名字查询球队成员
    @Test
    public void TestOne2Much(){
        BallArmy ballArmy=ballArmyMapper.selectBallArmyWithPlayerByName("湘北");
        System.out.println(ballArmy);
    }

}



































