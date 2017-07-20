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
    String mPath = "http://221.222.186.145:5004/";
    String testPath = "http://localhost:8081/";

    private int index = 0;
    private int size = 10;

    public void init() throws ServletException {
        super.init();
        pathList = new ArrayList<String>();
        System.out.println("init");

        File file = new File("H:\\函数解析\\素材");
        getPath(file);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");


        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();
        String type = request.getParameter("type");
        writer.println("类型" + type);
        writer.print("<br>");

        System.out.println(type);

//        File file = new File("H:\\函数解析");
        writer.print("<style>\n" +
                ".thumbnail \n" +
                "{\n" +
                "\tfloat:left;\n" +
                "}\n" +
                "</style>");
        for (int i = 0; i < size; i++) {
            String str = pathList.get(index);
            if ("0".equals(type)) {
                str = testPath + str;
            } else {
                str = mPath + str;
            }
            writer.print(" <img class=\"thumbnail\" src=\"" + str + "\" />");
            writer.print("<br />");
            System.out.println(str);
            index++;
        }


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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }

    public void getPath(File file) {
        if (file.exists()) {
            File[] files = file.listFiles();
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
                            if (list.contains(split[1])) {
                                String absolutePath = file1.getAbsolutePath();
                                String imgUrl = absolutePath.replace("H:\\", "");
                                pathList.add(imgUrl);
                            }
                        }

                    }
                }
            }
        }
    }

}
