package com.zzy.filelist.files;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zzy on 2017/7/19.
 */
public class FilesListServlet extends javax.servlet.http.HttpServlet {

    public void init() throws ServletException {
        super.init();
        System.out.println("init");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();

        writer.println("你好" + session.getAttribute("username"));
        writer.print("<br>");

        System.out.println(session.getAttribute("username"));

        File file = new File("/Users/zzy");
        writer.print("<br>");
        String absolutePath = file.getAbsolutePath();
        writer.println("absolutePath=" + absolutePath);
        writer.print("<br>");


//        String[] list = file.list();
        File[] files = file.listFiles(new FileSelector());

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
