<%--
  Created by IntelliJ IDEA.
  User: Clearlight
  Date: 2020/4/7
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
        <div class="form-group">
            <label for="bName">书籍名称:</label>
            <input type="text" class="form-control" name="bookName" id="bName" required/>
        </div>
        <div class="form-group">
            <label for="bCounts">书籍数量:</label>
            <input type="text" class="form-control" name="bookCounts" id="bCounts" required/>
        </div>
        <div class="form-group">
            <label for="bDetail">书籍描述:</label>
            <input type="text" class="form-control" name="detail" id="bDetail" required/>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="添加"/>
        </div>
    </form>
</div>
</body>
</html>
