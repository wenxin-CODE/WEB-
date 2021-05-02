package com.kuang.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1获取文件下载路径
        //String realPath = this.getServletContext().getRealPath("img.png");
        //代表maven资源的路径E:\apache-tomcat-9.0.43\webapps\r\img.png
        String realPath = "G:\\Java_web\\kuangshenshuo\\javaweb02-servlet\\response\\src\\main\\resources\\img.png";
        System.out.println("下载路径："+realPath);
        //2下载文件名字
        //截取路径最后一个/后面的字符，即为文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //3设置浏览器支持下载的东西,注意attachment;filename:中间是;，不然下载不了
        resp.setHeader("Content-Disposition","attachment;filename:"+fileName);
        //中文名文件，要用URLEncoder.encoder(filename,"UTF-8")
        //4获取下载文件输入流
        FileInputStream in = new FileInputStream(realPath);
        //5创建缓冲区
        int len=0;
        byte[] buffer = new byte[1024];
        //6获取outputstream对象
        ServletOutputStream out = resp.getOutputStream();
        //7将fileouputstream流写入缓冲区，使用outputstream将缓冲区的数据写入客户端
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

