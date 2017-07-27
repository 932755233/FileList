<%--
  Created by IntelliJ IDEA.
  User: zzy
  Date: 2017/7/27
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form method="post" action="/fileupload" enctype="multipart/form-data">

    <input type="file" name="image"/>
    <input type="submit" value="upload"/>
</form>
</body>
</html>
