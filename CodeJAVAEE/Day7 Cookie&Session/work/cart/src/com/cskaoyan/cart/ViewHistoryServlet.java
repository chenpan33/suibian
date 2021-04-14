package com.cskaoyan.cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @author panda
 * @description:查看history页面
 * @date 2021/4/13 21:47
 */
//这个方法要放进index里面即放在首页
@WebServlet("/history")
public class ViewHistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //①防止中文乱码
        response.setContentType("text/html; charset=UTF-8");
        //②放返回主页面的指令index
        String index=response.encodeURL(request.getContextPath()+"/index");
        response.getWriter().println("<a href='"+index+"'>返回首页</a>");

        //③获取history
        List<String> history= (List<String>) request.getSession().getAttribute("history");
        //3.1判断是否为空
        if(history==null){
            response.getWriter().println("历史清单为空, 返回主页......");
            response.setHeader("refresh","2;url="+index);
        }
        //3.2 将history打印映射出来
        List<Product> products= (List<Product>) getServletContext().getAttribute("products");
        for (Product product : products) {
            for (String id: history) {
                if(id.equals(product.getId())){
                    String detail = response.encodeURL(request.getContextPath() + "/detail?id=" + product.getId());
                    response.getWriter().println("<div><a href='" + detail + "'>" + product.getName() + "</a></div>");
                }

            }
        }

    }
}
