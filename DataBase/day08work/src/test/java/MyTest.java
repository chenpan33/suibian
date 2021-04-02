import dto.User;
import mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author panda
 * @description:测试mapper接口
 * @date 2021/3/30 20:53
 */
public class MyTest {
    static SqlSession sqlSession;
    static UserMapper userMapper;

    @BeforeClass
    public static void init() throws IOException {
        // 需要去加载Mybatis,然后启动Mybatis,然后执行sql，获取结果

        //加载Mybatis
        InputStream ips=Resources.getResourceAsStream("mybatis-config.xml");

        //builder--factory--session(关键对象)
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(ips);
        sqlSession =sqlSessionFactory.openSession();

        //获得userMapper
        userMapper=sqlSession.getMapper(UserMapper.class);

    }

    @AfterClass
    public static void destory(){
        //sql要commit才能得到结果 ,因为每句都要加一句 因此直接在afterclass内添加
        sqlSession.commit();
        sqlSession.close();
    }

    //----------------------上面为必须执行的,下面为测试测试内容-------------------

   //查找id
    @Test
    public void selectUserTest(){
        User  user= userMapper.selectUser(3);
        System.out.println(user);
    }

    //查找id
    @Test
    public void selectUserTest1(){
        User  user= userMapper.selectUser2(3);
        System.out.println(user);
    }



    //插入 对象原名
    @Test
    public void insertUser1Test(){
        //创建user对象
        User user =new User();
        user.setUsername("小魔仙");
        user.setPassword("caifumima");
        user.setAge(13);
        user.setGender("女");
        //测试程序
        int affRow=userMapper.insertUser1(user);
        System.out.println(affRow);
    }


    //插入 对象别名-------------------------------出错在xml文件中username拼写错误
    @Test
    public void insertUser2Test(){
        //创建user对象
        User user =new User();
        user.setUsername("五条悟");
        user.setPassword("5t5");
        user.setAge(20);
        user.setGender("男");

        //测试程序
        int affRow=userMapper.insertUser2(user);
        System.out.println(affRow);

    }

    // 多简单类型原名-------------------------------------有使用arg接收, xml文件中parameterType,写错了
    @Test
    public void insertUser3Test(){
        //提供数据
        String username = "虎子";
        String password = "hahahhah";
        int age = 18;
        String gender = "男";
        int affRow = userMapper.insertUser3(username, password, age, gender);
        System.out.println(affRow);

    }

    //多简单类型别名-------------------xml文件忘记改成别名了
    @Test
    public void insertUser4Test(){
        //提供数据
        String username = "dio";
        String password = "我不做人了";
        int age = 999;
        String gender = "男";
        int affected = userMapper.insertUser4(username, password, age, gender);
        System.out.println(affected);

    }









}
