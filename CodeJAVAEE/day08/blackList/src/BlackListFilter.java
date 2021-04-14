import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author panda
 * @description:通过filter将指定ip地址加入黑名单啊
 * @date 2021/4/14 15:23
 */
@WebFilter("/*")
public class BlackListFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        //判断ip地址 如果在黑名单内 直接返回return  不经过filter chain
        //不在黑名单就通过
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        response.setContentType("text/html; charset=UTF-8");//设置编码
        System.out.println(request.getRemoteAddr());
        if("192.168.5.59".equals(request.getRemoteAddr())){
            response.getWriter().println("很抱歉 ,您被禁止访问该页面");
            return;
        }
        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
