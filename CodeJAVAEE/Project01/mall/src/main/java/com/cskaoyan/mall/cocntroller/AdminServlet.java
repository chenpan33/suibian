package com.cskaoyan.mall.cocntroller;

import com.alibaba.druid.util.StringUtils;
import com.cskaoyan.mall.model.Result;
import com.cskaoyan.mall.model.bo.AdminLoginBo;
import com.cskaoyan.mall.model.vo.AdminLoginVO;
import com.cskaoyan.mall.model.vo.AllAdminsVO;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.service.AdminServiceImpl;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author panda
 * @description:后台管理模块的servlet文件
 * @date 2021/4/18 10:24
 */
@WebServlet("/api/admin/admin/*")
public class AdminServlet extends HttpServlet {


    private AdminService adminService=new AdminServiceImpl();
    //todo:省略结果为null的值
    ObjectMapper objectMapper = new ObjectMapper();
    {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取确定具体的action
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/admin/", "");
        //action为login
        if("login".equals(action)){
            login(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String action = requestURI.replace("/api/admin/admin/", "");
        //action是allAdmins
        if("allAdmins".equals(action)){
            allAdmins(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //如何去分析呢
        //System.out.println("login");
        //1.如何取请求参数？
        //不可以使用之前的request.getParameter，不是key=value型参数
        //JSON----->  Java
        //请求参数在请求体中，需要获取请求体，获取请求体的方法
        ServletInputStream inputStream = request.getInputStream();
        //输出流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //读写, 并将输出流转化为字符串
        int length=0;
        byte[] bytes = new byte[1024];
        while((length= inputStream.read(bytes))!=-1){
            outputStream.write(bytes);
        }
        String responseBody = outputStream.toString("utf-8");

        //2.字符串responseBody--->转化为java
        AdminLoginBo loginBo = objectMapper.readValue(responseBody, AdminLoginBo.class);
        if(StringUtils.isEmpty(loginBo.getEmail()) || StringUtils.isEmpty(loginBo.getPwd())){
            //表示参数不全的，没有必要往下继续走  前后端协商的结果  code 10000
            Result result = new Result(10000, null, "用户名、密码不能为空");
            // java-----json字符串
            response.getWriter().println(objectMapper.writeValueAsString(result));
            return;
        }
        //登录至少两种结果：1.成功  2.失败 用户名、密码错误    服务器繁忙
        int code = adminService.login(loginBo);
        //code其实就是controller和service层的标准，比如登录成功 200  404  500
        if(code == 200){
            // TODO
            AdminLoginVO loginVO = new AdminLoginVO();
            loginVO.setToken(loginBo.getEmail());
            loginVO.setName(loginBo.getEmail());
            Result result = new Result(0, loginVO, null);
            response.getWriter().println(objectMapper.writeValueAsString(result));
        }else if(code == 404){
            Result result = new Result(10000, null, "用户名、密码错误");
            // java-----json字符串
            response.getWriter().println(objectMapper.writeValueAsString(result));
        }else {
            Result result = new Result(10000, null, "服务器繁忙");
            // java-----json字符串
            response.getWriter().println(objectMapper.writeValueAsString(result));
        }
    }

    private void allAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取请求参数
        //2.具体业务逻辑处理
        //把admin表里面的数据全部查询出来
        List<AllAdminsVO> adminsVOS =  adminService.allAdmins();
        Result result = new Result(0, adminsVOS, null);
        //3.做出响应
        response.getWriter().println(objectMapper.writeValueAsString(result));
    }
}
