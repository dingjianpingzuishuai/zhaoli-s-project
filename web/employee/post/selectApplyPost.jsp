<%@ page import="javaBean.emp_expectpostBean" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 张爷爷！！！
  Date: 2020/12/26
  Time: 16:21
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
            <td>职位名</td>
            <td>职位简介</td>
            <td>审核状态</td>
        </tr>

        <%
            List<emp_expectpostBean> list = (List<emp_expectpostBean>)request.getAttribute("list");
            for(int i=0;i<list.size();i++){
        %>
        <tr>
            <td><%=list.get(i).getpName()%></td>
            <td><%=list.get(i).getpIntro()%></td>
            <td><%=list.get(i).getExpect_state()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
