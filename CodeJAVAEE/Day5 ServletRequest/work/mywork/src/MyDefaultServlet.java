import java.io.IOException;
import javax.servlet.*;

/**
 * @author panda
 * @description:实现缺省servlet
 * @date 2021/4/10 23:53
 */
//配置一下缺省的触发条件
@webservlet("/")
public class MyDefaultServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置编码集
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        //获取文件名
        String

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
