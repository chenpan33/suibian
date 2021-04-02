package day04;
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
    static int num=10000;//录入次数num
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
   /* @Test
    public  void InsertBatchStation(){
        long startTime= System.currentTimeMillis();
        try {
            statement=connection.createStatement();
            for (int i = 0; i < num; i++) {
                String sql ="insert into user values(null,'流川枫'"+i+")";
                statement.addBatch(sql);
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long endTime= System.currentTimeMillis();
        System.out.println("statement 花费"+(endTime-startTime)+"毫秒");
    }*/
    //4.2 prepareStatement批处理-----------------------------------
    @Test
    public  void InsertBatchPrepareStation(){
        long startTime= System.currentTimeMillis();
        //要先指定sql

        try {
            String sql ="insert into user values(?,'流川枫',?)";
            preparedStatement=connection.prepareStatement(sql);
            for (int i = 0; i < num; i++) {
                preparedStatement.setInt(1,i);
                preparedStatement.setInt(2,i);
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
    //5 查询时间对比
    //5.1 主键查询
   /* @Test
    public void selectById() {
        long start = System.currentTimeMillis();
        try {
            preparedStatement = connection.prepareStatement("select * from testbatch where id = ?");
            preparedStatement.setInt(1, 555);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String age = resultSet.getString("age");
                System.out.println("id: " + id + ", age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("通过id查询：" + (end - start) + "毫秒");
    }*/

    //5.2 普通字段查询
    /*@Test
    public void selectByAge() {
        long start = System.currentTimeMillis();
        try {
            preparedStatement = connection.prepareStatement("select * from user where age = ?");
            preparedStatement.setInt(1, 555);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String age = resultSet.getString("age");
                System.out.println("id: " + id + ", age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("通过age查询：" + (end - start) + "毫秒");
    }*/

}
/*
运行结果
开始录入...
通过id查询：33毫秒
statement 花费13169毫秒
id: 348072, age: 555
通过age查询：6毫秒
prepareStatement 花费104毫秒
结束录入...*/
