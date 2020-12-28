<%@ page import="javaBean.deptBean" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 张爷爷！！！
  Date: 2020/12/25
  Time: 18:13
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
            <td>部门号</td>
            <td>部门名</td>
            <td>部门简介</td>
        </tr>
        <%
            List<deptBean> list = (List<deptBean>)request.getAttribute("list");
            for(int i=0;i<list.size();i++){
        %>
        <tr>
            <td><%=list.get(i).getDeptID()%></td>
            <td><%=list.get(i).getDeptName()%></td>
            <td><%=list.get(i).getDeptIntro()%></td>
        </tr>
        <%
            }
        %>
    </table>

</body>
</html>
