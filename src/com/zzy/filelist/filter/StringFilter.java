package com.zzy.filelist.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by zzy on 2017/7/20.
 */
public class StringFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");



        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
