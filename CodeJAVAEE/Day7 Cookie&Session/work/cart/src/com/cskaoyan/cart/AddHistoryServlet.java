//package com.cskaoyan.cart;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author panda
// * @description:实现记录用户商品访问足迹
// * 使用session来存储历史足迹+ 使用ArrayList 来存放历史商品的id+ list长度为5
// *
// * ①每次访问页面, 先从服务器获取历史list
// *
// * ②然后将list添加当前页面的id
// *
// * ③将list存放到服务器
// * @date 2021/4/13 21:38
// */
////☆ 如何设置每次访问商品即执行request都会将增加商品到historyList上面--------->将这个方法放进商品详情页中(不太容易实现)
////☆  在进入商品详情前也存在点击动作--------->因此, 将这个方法放进
//@WebServlet("/addHistory")
//public class AddHistoryServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    response.setContentType("text/html; charset=UTF-8");//防止中文乱码
//
//        //需要的成员变量 id session history
//        String id=request.getParameter("id");
//        HttpSession session = request.getSession();
//        // ①每次访问页面, 先从服务器获取历史list
//        List<String> history= (List<String>) session.getAttribute("history");//使用session域来存储用户历史数据
//        if(history==null){//如果历史记录为空 就新建
//            history=new ArrayList<>();
//            session.setAttribute("history",history);
//        }
//        // ②然后将list添加当前页面的id
//        history.add(id);
//
//        // ③将list存放到服务器
//
//    }
//}
