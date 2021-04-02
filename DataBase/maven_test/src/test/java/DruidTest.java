import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DruidTest {

    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    @BeforeClass
    public static void init() {
        connection = C3p0Utils.getConnection();
    }

    //查
    @Test
    public void query() throws SQLException {

        preparedStatement = connection.prepareStatement("select * from user where id = ?");

        preparedStatement.setInt(1, 3);

        resultSet = preparedStatement.executeQuery();

        User user = new User();

        if (resultSet.next()) {

            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setAge(resultSet.getInt("age"));
        }

        System.out.println("user:" + user);

    }

    //删
    @Test
    public void delete() throws SQLException {

        preparedStatement = connection.prepareStatement("delete from user where id = 31");
        int i = preparedStatement.executeUpdate();
        System.out.println(i);

    }


    //改
    @Test
    public void up() throws SQLException {

        preparedStatement = connection.prepareStatement("update user set username = 'ppp' WHERE id in (4,5,6)");
        int i = preparedStatement.executeUpdate();
        System.out.println(i);

    }


    //增
    @Test
    public void add() throws SQLException {

        preparedStatement = connection.prepareStatement("insert into user values (31,'qq',10001,20)");
        int i = preparedStatement.executeUpdate();
        System.out.println(i);

    }


//    @AfterClass
//    public static void release() {
//        C3p0Utils.close(resultSet, preparedStatement, connection);
//    }

}
