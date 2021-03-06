import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3p0Test {

    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;


    @BeforeClass
    public static void init() {
        connection = C3p0Utils.getConnection();
    }


    //增
    @Test
    public void add() throws SQLException {
        String sql = "insert into user values (28,?,?,?)";

        preparedStatement=connection.prepareStatement(sql);


        preparedStatement.setString(1,"zs");
        preparedStatement.setInt(2,20);
        preparedStatement.setInt(3,23);

        System.out.println(1);

        int affectedRows = preparedStatement.executeUpdate();
        System.out.println(affectedRows);
        System.out.println();
    }

    //查
    @Test
    public void query() throws SQLException {

        preparedStatement = connection.prepareStatement("select * from user where id = 1");
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

        preparedStatement = connection.prepareStatement("delete from user where id = 30");
        int i = preparedStatement.executeUpdate();
        System.out.println(i);

    }

    //改
    @Test
    public void up() throws SQLException {

        preparedStatement = connection.prepareStatement("update user set username = 'ppp' WHERE id in (1,2,3)");
        int i = preparedStatement.executeUpdate();
        System.out.println(i);

    }



//    @AfterClass
//    public static void release() {
//        C3p0Utils.close(resultSet, preparedStatement, connection);
//    }


}
