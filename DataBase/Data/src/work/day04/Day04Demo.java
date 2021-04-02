package work.day04;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;
/**
 * @author panda
 * @description:
 * @date 2021/3/25 19:57
 */
public class Day04Demo {
    //1.全局使用的静态变量 connection statement resultSet
    static Connection connection;
    static Statement statement;
    static PreparedStatement preparedStatement;
    static ResultSet resultSet;
    //2.在开始前 beforeClass 加载数据库内容 获取connection(通过utils)
    @BeforeClass
    public static void init(){
        try {
            connection= JDBCUtils.getConnection();
            System.out.println("开始录入...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //3.在结束后afterClass 要关闭资源 close(通过utils)
    @AfterClass
    public  static void destory(){
        JDBCUtils.closeSource(connection,statement,resultSet);
        JDBCUtils.closeSource(connection,preparedStatement,resultSet);
        System.out.println("结束录入...");
    }
    //4.测试过程使用两个两个test 分别测试两种录入数据
        //每种测试中,分别测试主键id查找 与通过年龄i来查找两种模式的查询速度
    //4.1 statement批处理
    @Test
    public  void InsertBatchStation(){
        long startTime= System.currentTimeMillis();
        try {
            statement=connection.createStatement();
            for (int i = 0; i < 100000; i++) {
                String sql ="insert into testbatch values(null,"+i+")";
                statement.addBatch(sql);
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long endTime= System.currentTimeMillis();
        System.out.println("statement 花费"+(endTime-startTime)+"毫秒");
    }
    //4.2 prepareStatement批处理-----------------------------------
    @Test
    public  void InsertBatchPrepareStation(){
        long startTime= System.currentTimeMillis();
        //要先指定sql

        try {
            String sql ="insert into testbatch values(null,?)";
            preparedStatement=connection.prepareStatement(sql);
            for (int i = 0; i < 100000; i++) {
                preparedStatement.setInt(1,i);
                preparedStatement.addBatch();
                preparedStatement.clearParameters();
            }
            preparedStatement.executeBatch();//写成update
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long endTime= System.currentTimeMillis();
        System.out.println("prepareStatement 花费"+(endTime-startTime)+"毫秒");
    }

}
