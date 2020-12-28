<%--
  Created by IntelliJ IDEA.
  User: 张爷爷！！！
  Date: 2020/12/26
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
</head>
<body>
    <form class="form-inline" target="main">
        <font>选择日期</font>
        <div class="form-group">
            <input type="date" name="date" value="" />
        </div>

        <div class="form-group">
            <font>是否迟到</font>
            <select name="whetherlate">
                <option value ="" selected="selected">--------</option>
                <option value ="早退">迟到</option>
                <option value="未迟到">未迟到</option>
            </select>
        </div>

        <div class="form-group">
            <font>是否早退</font>
            <select name="whetherleave">
                <option value ="" selected="selected">--------</option>
                <option value ="早退">早退</option>
                <option value="未早退">未早退</option>
            </select>
        </div>
        <input class="btn btn-default" type="submit">
</form>
</body>
</html>
