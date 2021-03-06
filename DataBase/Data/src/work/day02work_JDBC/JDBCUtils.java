package work.day02work_JDBC;
//将重复部分放进工具类中, 具有获取连接的方法
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {


    // 获取连接对象方法①---------------------------------
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        // 创建properties配置文件
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            // 读取文件
            fileInputStream = new FileInputStream("jdbc.properties");

            // 装载
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        String url= properties.getProperty("url");
        String user = properties.getProperty("username");
        String password = properties.getProperty("password");
        String driverClass = properties.getProperty("driverClass");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        // 加载
        Class.forName(driverClass);

        // 获取连接
        connection = DriverManager.getConnection(url,user,password);


        return connection;

    }


    // 关闭资源------------------------------------------------------------
    public static void closeSource(Connection connection,Statement statement, ResultSet resultSet){

        // 关闭资源 statement resultSet connection
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
