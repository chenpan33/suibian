import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilsTest {
    static Connection conn = null;
    static QueryRunner queryRunner = null;

    @BeforeClass
    public static void init() {
        conn = DruidUtils.getConnection();
        queryRunner = new QueryRunner();
    }


    //增
    @Test
    public void add() throws SQLException {
        String sql = "insert into user11 values(null, ?, ?,?)";
        int rows = queryRunner.update(conn, sql, "注解", "567",21);
        System.out.println(rows);
    }

//    //查
//    @Test
//    public void query() throws SQLException {
//        String sql = "select * from user where id = ?";
//        User user = queryRunner.query(conn, sql, new BeanHandler<User>(User.class), 1);
//        System.out.println(user);
//
//    }

    //查
    // BeanHandler 可以帮助我们去封装单个bean
    @Test
    public void testBeanHandler() throws SQLException {

        // 创建QueryRunner
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        // 执行sql
        String sql = "select * from user11 where id = ?";
        User user = queryRunner.query(conn,sql, new BeanHandler<User>(User.class), 33);

        System.out.println(user);
        //User{id=33, username='注解', password1='0', age=21}

    }

    //改
    @Test
    public void up() throws SQLException {
        String sql = "update user11 set username = ? where id = ?";
        int rows = queryRunner.update(conn, sql, "反射", 32);
        System.out.println(rows);
    }

    //删
    @Test
    public void drop() throws SQLException {
        String sql = "delete from user11 where id in (24,25,26,27)";
        int rows = queryRunner.update(conn, sql);
        System.out.println(rows);

    }


    @AfterClass
    public static void release() {
        DruidUtils.release(null, conn);
    }
}
