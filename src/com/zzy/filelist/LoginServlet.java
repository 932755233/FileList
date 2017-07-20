package com.zzy.filelist;

import com.sun.deploy.uitoolkit.impl.text.TextUIToolkit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Utilities;
import java.io.IOException;

/**
 * Created by zzy on 2017/7/20.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("zzy".equals(username) && "123".equals(password)) {
            response.sendRedirect("/filelist.jsp");
        } else {
            response.sendRedirect("https://www.baidu.com");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
