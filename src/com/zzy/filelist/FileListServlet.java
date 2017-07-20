package com.zzy.filelist;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zzy on 2017/7/19.
 */
public class FileListServlet extends javax.servlet.http.HttpServlet {

    public void init() throws ServletException {
        super.init();
        System.out.println("init");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.println("你好");
        writer.println("<br>");

        String zhou = request.getParameter("zhou");

        writer.println(zhou);
        writer.print("<br>");

        System.out.println(zhou);

        File file = new File("/home/zzy");
        String absolutePath = file.getAbsolutePath();
        writer.println("absolutePath=" + absolutePath);
        writer.print("<br>");


//        String[] list = file.list();
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            writer.print(files[i].getPath());
            writer.print("<br>");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }

}
