import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author panda
 * @description:登陆界面servlet
 * @date 2021/4/14 18:34
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter = new PrintWriter(new FileWriter(new File("C:/desktop/post.txt")));
        printWriter.println("=============请求行==============");
        printWriter.println(request.getMethod()+" "+request.getRequestURI()+" "+request.getProtocol());

        printWriter.println("=============请求头==============");
        //使用getHeaderNames来进行使用--->value=getHeader(key)
        Enumeration<String> headerNames=request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            printWriter.println(key+": "+value);

        }

        printWriter.println("=============请求参数============");
        //使用request.getParameterMap
        //获得请求参数的键值对map
        Map<String, String[]> parameterMap = request.getParameterMap();
        //使用foreach遍历map
        // parameterMap.entrySet())
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            printWriter.print(entry.getKey()+":\t");
            String[] values =entry.getValue();
            for (String value : values) {
                printWriter.print(value+" ");
            }
            printWriter.println();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
