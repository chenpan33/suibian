import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author panda
 * @description:
 * @date 2021/4/9 21:16
 */
@WebServlet("/login/*")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //因为是post表单 所以写在这里

        //设置中文编码集
        request.setCharacterEncoding("utf-8");

        //新建输出流
        PrintWriter printWriter = new PrintWriter(new FileWriter("C:/test/postOut.txt"));


        //将数据写进postOut.txt文件


        //①请求行
        String  requestLine=request.getMethod()+" "+request.getRequestURI()+" "+request.getProtocol();
        System.out.println(requestLine);
        printWriter.write(requestLine+ "\r\n");

        //②请求头

        Enumeration<String> hederNames=request.getHeaderNames();
        while (hederNames.hasMoreElements()){
            String key =hederNames.nextElement();
            String value = request.getHeader(key);
            String requestHead=key+ ":"+value;
            System.out.println(requestHead);
            printWriter.write(requestHead+ "\r\n");
        }

        //③请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        printWriter.write(username+ "\r\n");
        System.out.println(password);
        printWriter.write(password+ "\r\n");

        //关闭流
        printWriter.flush();
        printWriter.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //访问当前servlet请求地址 应用名是/app
        //输入地址/app/login

    }
}
