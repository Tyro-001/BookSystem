<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>书籍管理首页</title>

    <style type="text/css">
      a {
        text-decoration: none;
        color: black;
        font-size: 18px;
      }
      h2 {
        width: 180px;
        height: 38px;
        margin: 100px auto;
        text-align: center;
        line-height: 38px;
        background: deepskyblue;
        border-radius: 4px;
      }
    </style>
  </head>

  <body>

  <h2>
    <a href="${pageContext.request.contextPath}/book/allBook">查看所有书籍</a>
  </h2>

  </body>
</html>
