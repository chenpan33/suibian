package com.panchen;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author panda
 * @description:3.将之前的个人页面加上文件上传功能（其实就是将课堂的代码敲一遍）
 * @date 2021/4/12 20:08
 */
@WebServlet("/day06work")
public class WorkFileUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.读取请求上传的文件输入流 sis
        ServletInputStream sis = request.getInputStream();

        //2.新建需要输出的文件file并部署到根目录下面
        String realPath = getServletContext().getRealPath("image/1.jpg");
        File file = new File(realPath);

        //---判断file的父级目录是否存在, 不存在的话需要创建目录
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        //3.创建文件file的输出流fos
        FileOutputStream fos = new FileOutputStream(file);
        int length=0;
        byte[] bytes=new byte[1024];
        //4.使用bytes方法将sis输到fos中
        while ((length=sis.read(bytes))!=-1){
            fos.write(bytes,0,length);
        }
        //5.关闭流
        fos.close();
        sis.close();//sis可关可不关

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
