import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import utils.DruidUtils;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author panda
 * @description:创建一个user表，使用BDUtils进行增删改查，并查询需要使用上课讲到的BeanHandler、BeanListHandler、ColumnListHandler、ScalarHandler
 * @date 2021/3/26 20:08
 */
public class DBUtilsWork {
    static QueryRunner queryRunner;
    static {
        //获取数据源
        DataSource dataSource = DruidUtils.getDataSource();
         queryRunner = new QueryRunner(dataSource);
    }

    //DBUtils增删改查操作

    @Test
    public void TestDBUtils() throws SQLException {
            //1.增update
            String sqlAdd="insert into  user values(null,?,?) ";
            int rowsAdd=0;
            for (int i = 0; i < 20; i++) {
                rowsAdd += queryRunner.update(sqlAdd,"樱木花道(增)"+i,i);
            }
            System.out.println("添加行数:" +rowsAdd);
    }

    @Test
    public void TestDBUtils2() throws SQLException {
        //2.删update
        String sqlDel="delete from  user where id=? ";
        int rowsDel = queryRunner.update(sqlDel,7);
        System.out.println("删除行数:" +rowsDel);
    }


    @Test
    public void TestDBUtils3() throws SQLException {
        //3.改update
        String sqlSet="update  user set name=? where id=? ";
        int rowsSet = queryRunner.update(sqlSet,"三井(换)",6);
        System.out.println("更换:" +rowsSet);
    }

    //4.查---使用ResultSetHandler的接口--BeanHandler--BeanListHandler--ColumnListHandler：--ScarlarHandler
    @Test

    public void TestDBUtils4_1() throws SQLException {
        // 4.1行--第一个--BeanHandler
        String sqlBeanH="select * from user where id=?";
        User userBeanH=queryRunner.query(sqlBeanH,new BeanHandler<User>(User.class),1);
        System.out.println("第一行:  "+userBeanH);
    }

    @Test

    public void TestDBUtils4_2() throws SQLException {
        // 4.2行--放进list--BeanListHandler
        String sqlBeanLiH="select * from user where id in (?,?,?,?)";
        List<User> userBeanLiH=queryRunner.query(sqlBeanLiH,new BeanListHandler<User>(User.class),1,2,5,4);
        System.out.println("前三行:  "+userBeanLiH);
    }


    @Test
    public void TestDBUtils4_3() throws SQLException {
        // 4.3列--放进list--ColumnListHandler
        String sqlColumnLiH="select name from user where id in (?,?,?)";
        List<User> userColumnLiH=queryRunner.query(sqlColumnLiH,new BeanListHandler<User>(User.class),1,2,3);
        System.out.println("前三列用户名:   ");
        for (User userName : userColumnLiH) {
            System.out.println(userName);
        }
    }

    @Test

    public void TestDBUtils4_4() throws SQLException {

        // 4.4某个值--例如影响行数--ScarlarHandler
        String sqlScarlarH="select count(1) from user where id in (?,?,?)";
        Long rowsScarlarH=queryRunner.query(sqlScarlarH,new ScalarHandler<Long>(),1,2,3);
        System.out.println("行数:  "+rowsScarlarH);
    }
}


// 自己实现了一个ResultSetHandler接口
class MyResultSetHandler implements ResultSetHandler<User> {

    @Override
    public User handle(ResultSet resultSet) throws SQLException {
        User user = new User();
        if (resultSet.next()) {

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            user.setId(id);
            user.setName(name);
            user.setAge(age);
        }
        return user;
    }
}