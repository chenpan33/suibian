package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.model.Result;
import com.cskaoyan.mall.model.vo.AllUsersVO;
import com.cskaoyan.mall.service.UserService;
import com.cskaoyan.mall.service.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.RepositoryIdHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import java.io.IOException;
import java.util.List;

/**
 * @author panda
 * @description:
 * @date 2021/4/20 10:39
 */
@WebServlet("/api/admin/user/*")
public class UserServlet extends HttpServlet {
    private  UserService userService=new UserServiceImpl();
    ObjectMapper objectMapper = new ObjectMapper();
    //把值为null的值忽略掉
    { objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/user/", "");
        if("allUser".equals(action)){allUser(request,response);}
        if("deleteUser".equals(action)){deleteUser(request,response);}
        if("searchUser".equals(action)){searchUser(request,response);}

    }

    private void allUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AllUsersVO> allUsersVOS = userService.allUser();
        Result result = new Result(0, allUsersVOS, null);
        response.getWriter().println(objectMapper.writeValueAsString(result));
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        userService.deleteUser(id);
        response.getWriter().println(objectMapper.writeValueAsString(Result.ok()));
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nickname = request.getParameter("word");
        System.out.println(nickname);
        List<AllUsersVO> allUsersVOS = userService.searchUser(nickname);
        Result result = new Result(0, allUsersVOS, null);
        response.getWriter().println(objectMapper.writeValueAsString(result));
    }
}
