package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author panda
 * @description:JDBC工具类,使用java来执行sql操作的工具类
 * @date 2021/3/26 20:09
 */
public class JDBCUtils {
    //变量名
    static Connection connection;
    //静态代码块---必须执行的创建连接(连接connection是一切的开始^V^)
    //读取配置文件---获取配置文件中数据---通过数据创建connection
    static {
        //Ⅰ 读取配置文件
        FileInputStream fis = null;
        Properties properties = new Properties();
        try {
            fis = new FileInputStream("jdbc.properties");
            properties.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据库相关数据--url--user--password--driverClass
        String url=properties.getProperty("url");
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        String driverClass=properties.getProperty("driverClass");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //方法名 Ⅰ获得连接----Ⅱ关闭资源
    //Ⅰ获得连接
    public static Connection getConnection(){
        return connection;

    }
    //Ⅱ关闭资源
    public static void closeSource(Connection connection, Statement statement, ResultSet resultSet){
        //对三种资源进行判断从而关闭资源resultSet-->statement-->connection

            try {
                if(resultSet!=null){
                    resultSet.close();
                }
                if(statement!=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
