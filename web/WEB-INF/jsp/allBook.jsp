<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container">
        <div class="col-md-12 column">
            <div class="page-header">
            <h1>
                <small>书籍列表 ———— 显示所有书籍</small>
            </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <%--新增，查询显示所有--%>
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示所有书籍</a>
        </div>
        <%--搜索功能--%>
        <span style="color: red;font-weight: bold;float: left" class="form-line">${errors}</span>
        <div class="col-md-4 column">
            <form class="form-line" action="${pageContext.request.contextPath}/book/queryBook" style="float: left" method="post" >
                <span><input type="text" name="bookName" class="form-control form-line" placeholder="请输入要查询的书籍"></span>
                <span><input type="submit" value="查询" class="btn btn-primary form-line"></span>
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>书籍编号</th>
                        <th>书籍名称</th>
                        <th>书籍数量</th>
                        <th>书籍详情</th>
                        <th>更多操作</th>
                    </tr>
                </thead>
                <%-- 书籍从数据库中查询出来，从list集合里中遍历出来：foreach--%>
                <tbody>
                    <c:forEach var="book" items="${msg}">
                        <tr>
                            <td>${book.bookCode}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCounts}</td>
                            <td>${book.detail}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.bookID}">修改</a> |
                                <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                            </td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>




</body>
</html>
