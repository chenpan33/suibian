package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author panda
 * @description:使用druid建立数据库连接池
 * @date 2021/3/26 20:09
 */
public class DruidUtils {
    //变量名---数据源
    static DataSource dataSource;
    //方法名--全部是静态的 ,放在静态代码块中 或者被static修饰
    //创建数据源: 加载配置---数据源工厂---数据源
    static {
        try {
            //1.加载配置
            FileInputStream fis = new FileInputStream("druid.properties");
            Properties properties = new Properties();
            properties.load(fis);
            //2.创建数据源工厂
            DruidDataSourceFactory druidDataSourceFactory = new DruidDataSourceFactory();
            //3.创建数据源
            dataSource=druidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //外部获取连接
    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //外部获取数据源
    public static DataSource getDataSource(){
        return dataSource;
    }
}
