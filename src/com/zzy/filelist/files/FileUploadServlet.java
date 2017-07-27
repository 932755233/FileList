package com.zzy.filelist.files;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String string = req.getParameter("filename");

        InputStream inputStream = req.getInputStream();

        System.out.println(string);

        File f = new File("/1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        int i = 0;
        byte[] fileB = new byte[1024];
        while ((i = inputStream.read(fileB)) != -1) {
            fileOutputStream.write(fileB, 0, i);
        }
        fileOutputStream.close();

        System.out.println(string + "---" + f.getAbsolutePath() + "---" + i);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
