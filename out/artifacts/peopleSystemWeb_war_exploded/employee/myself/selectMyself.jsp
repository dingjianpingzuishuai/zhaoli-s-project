<%@ page import="javaBean.empBean" %><%--
  Created by IntelliJ IDEA.
  User: 张爷爷！！！
  Date: 2020/12/25
  Time: 16:25
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
            <td>员工号</td>
            <td>姓名</td>
            <td>密码</td>
            <td>所处部门</td>
            <td>任职职位</td>

            <td>薪资</td>
            <td>性别</td>
            <td>居住地址</td>
            <td>email</td>
        </tr>
        <%
            empBean e = (empBean)session.getAttribute("login");
        %>
        <tr>
            <td><%=e.getEmpID()%></td>
            <td><%=e.getEmpName()%></td>
            <td><%=e.getEmpPassword()%></td>
            <td><%=e.getDeptName()%></td>
            <td><%=e.getpName()%></td>
            <td><%=e.getSalary()%></td>
            <td><%=e.getSex()%></td>
            <td><%=e.getAddress()%></td>
            <td><%=e.getEmail()%></td>

        </tr>
    </table>
</body>
</html>
