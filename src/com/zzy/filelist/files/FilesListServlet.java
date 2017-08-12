package com.zzy.filelist.files;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zzy on 2017/7/19.
 */
public class FilesListServlet extends javax.servlet.http.HttpServlet {

    private List<String> pathList;
    String[] strs = {"jpg", "gif", "png"};
    //    String fileUrl = "http://221.222.213.162:5001/Pictures";
    String fileUrl = "http://114.245.88.60:5003/Pictures";
    String testUrl = "http://localhost:9090/Pictures";
    String windowsTestUrl = "http://localhost:8080/Pictures";


    String macPath = "/Users/zzy/image";
    String linuxPath = "/home/zzy/image";
    String windowsPath = "H:\\BaiduNetdiskDownload\\2016-02-08在家\\没少女战士\\没少女战士\\我是美少女战士JK酱 蓝";


    String url = "";
    String filePath = "/home/zzy/image/";

    private int index = 0;
    private int size = 10;

    public void init() throws ServletException {
        super.init();
        pathList = new ArrayList<String>();

        String osName = System.getProperty("os.name");
        System.out.println("init---" + osName);

        if (osName.contains("Mac")) {
            filePath = macPath;
        } else if (osName.contains("Linux")) {
            filePath = linuxPath;
        } else if (osName.contains("Windows")) {
            testUrl = windowsTestUrl;
            filePath = windowsPath;
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");


        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();
        Object is_login = session.getAttribute("is_login");
        if (is_login == null) {
            writer.print("<h1 align=\"center\">请返回重新登录</h1>");
            return;
        }
        String type = request.getParameter("type");
        writer.print("<br>");
        writer.print("<script src=\"/filelist.js\" type=\"text/jscript\"></script>");

        System.out.println(type);

        File file = new File(filePath);
        pathList.clear();
        getPath(file);

//        File file = new File("H:\\函数解析")
        writer.print("<div>");
//        writer.print("<style>" +
//                ".thumbnail" +
//                "{" +
//                "float:left;" +
//                "}" +
//                "</style>");
        for (int i = 0; i < size; i++) {
            String str = pathList.get(index);
            if ("0".equals(type)) {
                str = testUrl + str;
            } else {
                str = fileUrl + str;
            }
            writer.print(" <a onmouseout=\"hoverHiddendiv(this)\" onmousemove=\"hoverShowDiv(this)\"  target=\"_blank\" class=\"thumbnail\" href=\"" + str + "\"><img id=\"smallimg\" style=\"width: 100px; height:100px\" src=\"" + str + "\" /></a>");
            System.out.println("index:" + index + "-----" + str);
            index++;
            if (index >= pathList.size()) {
                index = 0;
                break;
            }
        }


        writer.print("</div>");
        writer.println("<br/>");
        writer.print("<button style=\"width:10em;height:5em;\" onclick=\"javascript:location.reload(true);\">下一页</button>");

//        writer.print("<br />");
//        String absolutePath = file.getAbsolutePath();
//        writer.println("absolutePath=" + absolutePath);
//        writer.print("<br />");
//
//
////        String[] list = file.list();
//        File[] files = file.listFiles(new FileSelector());
//
//        for (int i = 0; i < files.length; i++) {
//            writer.print(files[i].getName());
//            writer.print("<br />");
//        }
        writer.print("<div style=\"border:1px solide #aaccff;display:none;\" id=\"divHover\" >");
        writer.print("<img src=\"\"id=\"bigimg\" />");
        writer.print("</div>");



        System.out.println(request.getHeader("x-forwarded-for"));
        System.out.println(request.getHeader("X-Real-IP"));
        System.out.println(request.getRemoteAddr());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }

    public void getPath(File file) {
        System.out.println(file.getAbsolutePath() + "zzy");
        if (file.exists()) {
            File[] files = file.listFiles(new FileSelector());
            System.out.println(files.length);
            if (files.length == 0) {
                return;
            } else {
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        getPath(file1);
                    } else {
                        List<String> list = Arrays.asList(strs);
                        String name = file1.getName();
                        if (file1 != null && name.contains(".")) {
                            String[] split = name.split("\\.");
                            if (list.contains(split[split.length - 1])) {
                                String absolutePath = file1.getAbsolutePath();
                                String imgUrl = absolutePath.replace(filePath, "");
                                System.out.println(imgUrl);
                                pathList.add(imgUrl);
                            }
                        }

                    }
                }
            }
        }
    }

}
