<%--
  Created by IntelliJ IDEA.
  User: Rebas
  Date: 2020/10/22
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <style type="text/css">
    a {
      text-decoration: none;
      color: palevioletred;
      font-size: 18px;
    }
    h3 {
      width: 180px;
      height: 38px;
      margin: 100px auto;
      text-align: center;
      line-height: 38px;
      background: deepskyblue;
      border-radius: 4px;
    }
  </style>
  <body>
  <a href="${pageContext.request.contextPath}/book/allBook">点击进入书籍列表</a>
  </body>
</html>
