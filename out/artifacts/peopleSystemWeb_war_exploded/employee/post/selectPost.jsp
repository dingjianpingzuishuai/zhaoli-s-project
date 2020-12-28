<%@ page import="javaBean.postBean" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 张爷爷！！！
  Date: 2020/12/26
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link  rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
</head>
<body>
    <table border="1" width="400px" height="80px" align="center">
        <tr>
            <td>职位编号</td>
            <td>职位名字</td>
            <td>职位简介</td>
            <td>操作</td>
        </tr>
        <%
            List<postBean> list = (List<postBean>)request.getAttribute("list");
            for(int i=0;i<list.size();i++){
        %>
        <tr>
            <td id=""><%=list.get(i).getpID()%></td>
            <td><%=list.get(i).getpName()%></td>
            <td><%=list.get(i).getpIntro()%></td>
            <td><a href="/applyPostServlet?pID=<%=list.get(i).getpID()%>">申请</a>
                </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
