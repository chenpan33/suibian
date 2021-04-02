import dto.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.MybatisUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author panda
 * @description:测试mybatis的动态sql功能
 * 今天作业
 *
 * 作业1 整理回顾今天的内容，把代码自己敲一遍
 * 作业2 使用今天学过的sql标签 实现一个批量输入user对象的方法和一个updateSelectiveUser的方法
 * int insertUsers(List<User> users)
 * int insertUsers(@Param("users")List<User> users)
 * int updateSelectiveUser(@Param("user")User user)
 * @date 2021/4/1 9:21
 */
public class UserTest {

    private  static SqlSession sqlSession=null;
    private  static UserMapper userMapper=null;

    @BeforeClass
    public static void init() throws IOException {
        sqlSession = MybatisUtils.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);


    }

    @AfterClass
    public static void destory(){
        sqlSession.commit();
        sqlSession.close();
    }

//第一题    int insertUsers1(List<User> users);
    @Test
    public void insertUsers1Test(){
        List<User> users = new ArrayList<User>();
        //user1
        User user1 = new User();
        user1.setId(7);
        user1.setName("伊尔迷");
        user1.setAge(22);
        //user2
        User user2 = new User();
        user2.setId(8);
        user2.setName("奇犽");
        user2.setAge(14);
        users.add(user1);
        users.add(user2);
        int afRows1 = userMapper.insertUsers1( users);
        System.out.println(afRows1);

    }
//第二题    int insertUsers2(@Param("users")List<User> users);
    @Test
    public void insertUsers2Test(){

        //user1
        User user1 = new User();
        user1.setId(9);
        user1.setName("伊尔迷2");
        user1.setAge(22);
        //user2
        User user2 = new User();
        user2.setId(10);
        user2.setName("奇犽2");
        user2.setAge(14);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        int afRows2 = userMapper.insertUsers2( users);
        //注意上面要添加userMapper
        System.out.println(afRows2);

    }
//第三题    int updateSelectiveUser3(@Param("user")User user);

    @Test
    public void updateSelectiveUser3Test(){
        //user3
        User user3 = new User();
        user3.setName("樱木花道");
        user3.setAge(18);
        int afRows3 = userMapper.updateSelectiveUser3( user3);
        System.out.println(afRows3);

    }



}
