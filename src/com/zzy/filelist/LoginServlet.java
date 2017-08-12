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

        HttpSession session = request.getSession();



        if ("zzy".equals(username) && "123".equals(password)) {
            response.sendRedirect("/fileslist");
            session.setAttribute("is_login", true);

        } else if ("zzy2".equals(username) && "123".equals(password)) {
            response.sendRedirect("/fileslist?type=0");
            session.setAttribute("is_login", true);

        } else if ("zzy1".equals(username) && "123".equals(password)) {
            response.sendRedirect("/file/fileupload.jsp");
            session.setAttribute("is_login", true);
        } else {
            response.sendRedirect("https://www.baidu.com");

        }
        session.setAttribute("username", username);
        session.setAttribute("password", password);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
