package work.day02work_JDBC;

import java.sql.*;

/**
 * @author panda
 * @description:JDBC---通过java操作MYSQL
 * @date 2021/3/24 16:21
 */
public class workday02 {
    public static void main(String[] args) {
        //①声明变量---url user  password 放到放到mysql 账户配置文件
        //connection 数据库 statement 表的  resultSet通过对表的查询得到的返回值
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        //②执行过程
        try {
            //注册驱动----省略
            //获取链接-----获取database
            connection =JDBCUtils.getConnection();
            //获取statement-----获取table
            statement=connection.createStatement();
            //获取结果集resultSet--从table中进行操作,获取数据
            //--------------------------------------------------------------

            //1.请查出每个导师所带研究生的姓名。
            System.out.println("每个导师所带研究生的姓名-----------------------------");
            resultSet=statement.executeQuery("select professor.name ,student2.name " +
                    "from professor inner join student2  " +
                    "on student2.teacher_id=professor.id ");
            //解析结果集----数据[结果集是类似游标的]
            //resultSet.next();返回的是Boolean值
            while(resultSet.next()){
                String nameP=resultSet.getString("professor.name");
                String nameS=resultSet.getString("student2.name");
//            System.out.println(name_professor+name_stu);
                System.out.println(nameP+"---"+nameS);
            }

            //2.清查出特定姓名的导师所带研究生的姓名。
            System.out.println("特定姓名的导师所带研究生的姓名-----------------------------");
            //int idP=resultSet.getInt(0);
            //resultSet=statement.executeQuery("select student2.name from professor inner join student2   on student2.teacher_id=professor.id where professor.id="+idP);
            resultSet=statement.executeQuery("select professor.name, student2.name " +
                    "from professor inner join student2   " +
                    "on student2.teacher_id=professor.id " +
                    "and professor.id =1");
            while(resultSet.next()){
                String nameP=resultSet.getString("professor.name");
                String nameS=resultSet.getString("student2.name");
//            System.out.println(name_professor+name_stu);
                System.out.println(nameP+"---"+nameS);
            }

            //3.请查出每个导师所带研究生的数量。
            System.out.println("每个导师所带研究生的数量。--------------------------------------");
            resultSet=statement.executeQuery("select professor.name ,count(1)  " +
                    "from professor  inner join student2  " +
                    "on student2.teacher_id=professor.id " +
                    "group by professor.id");
            while( resultSet.next()){
                String nameP=resultSet.getString("professor.name");
                String count=resultSet.getString("count(1)");

                System.out.println(nameP+"  "+count);

            }
            //4.请查出每个导师所带男研究生的数量。
            System.out.println("每个导师所带男性研究生的数量。--------------------------------------");
            resultSet=statement.executeQuery("select professor.name ,count(1)  " +
                    "from professor  inner join student2  " +
                    "on student2.teacher_id=professor.id " +
                    "where student2.gender=\"male\"  group by professor.id");
            while( resultSet.next()){
                String nameP=resultSet.getString("professor.name");
                String countMale=resultSet.getString("count(1)");

                System.out.println(nameP+"  "+countMale);

            }
            //5.请找出选择哪个研究方向的导师最多。
            System.out.println("导师最多的研究方向----------------------------------------------");
            resultSet=statement.executeQuery("select filed  from professor group by filed order by count(1) desc limit 1");
            while(resultSet.next()){
                String filed=resultSet.getString("filed");
                System.out.println(filed);
            }

            //6.请统计不同职称的导师的个数。
            System.out.println("不同职称的导师的个数--------------------------------------------");
            resultSet=statement.executeQuery("select title , count(1)  from professor group by title");
            while (resultSet.next()){
                String title=resultSet.getString("title");
                String countP=resultSet.getString("count(1)");
                System.out.println(title+"   "+countP);
            }
            //--------------------------------------------------------------

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            JDBCUtils.closeSource(connection,statement,resultSet);
        }

        //
    }
}
