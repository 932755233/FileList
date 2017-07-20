package com.zzy.filelist;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by zzy on 2017/7/20.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("zzy".equals(username) && "123".equals(password)) {
            response.sendRedirect("/fileslist");
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
        } else {
            response.sendRedirect("https://www.baidu.com");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
