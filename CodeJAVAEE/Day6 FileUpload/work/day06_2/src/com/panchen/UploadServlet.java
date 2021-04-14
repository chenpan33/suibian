package com.panchen;

import com.panchen.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author panda
 * @description:将之前的个人页面加上文件上传功能（其实就是将课堂的代码敲一遍）
 * @date 2021/4/12 22:30
 */
@WebServlet("/d6work")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        User user = new User();
        Map<String, Object> map=FileUploadUtils.parseRequest(request);
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        getServletContext().setAttribute("user", user);
        response.getWriter().println("上传成功，....");
        response.setHeader("refresh", "5;url=" + request.getContextPath() + "/view");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
