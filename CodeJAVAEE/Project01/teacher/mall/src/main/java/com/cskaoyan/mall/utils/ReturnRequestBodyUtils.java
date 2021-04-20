//package com.cskaoyan.mall.utils;
//
//import javax.servlet.ServletInputStream;
//import javax.servlet.http.HttpServletRequest;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//
///**
// * @author panda
// * @description:将获取request内容的方法聚集起来,实现代码复用
// * @date 2021/4/19 17:10
// */
//public class ReturnRequestBodyUtils {
//    /**
//     * @description:获取request相应体内容
//     * @param request
//     * @return requestBody
//     * @throws IOException
//     */
//    private static String returnRequestBody(HttpServletRequest request) throws IOException {
//        ServletInputStream inputStream = request.getInputStream();
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        int length = 0;
//        byte[] bytes = new byte[1024];
//        while ((length = inputStream.read(bytes)) != -1){
//            outputStream.write(bytes, 0, length);
//        }
//        String requestBody = outputStream.toString("utf-8");
//        return requestBody;
//    }
//}
