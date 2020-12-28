<%@ page import="javaBean.attendanceBean" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 张爷爷！！！
  Date: 2020/12/25
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" width="400px" height="80px" align="center">
        <tr>
            <td>日期</td>
            <td>签到时间</td>
            <td>是否迟到</td>
            <td>签退时间</td>
            <td>是否迟到</td>
        </tr>
        <%
            String date = request.getParameter("date");
            String whetherlate = request.getParameter("whetherlate");
            String whetherleave = request.getParameter("whetherleave");
        %>
        <span><%=date%><%=whetherlate%><%=whetherleave%></span>
    </table>
</body>
</html>
