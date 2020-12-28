<%@ page import="javaBean.empBean" %><%--
  Created by IntelliJ IDEA.
  User: 张爷爷！！！
  Date: 2020/12/24
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
    <style>
        *{
            padding: 0px;
            margin: 0px;
            list-style: none;
        }
        nav{
            width: 200px;
            height: 600px;
            background-color: rgb(41, 65, 90);

        }
        .menu{ width: 200px;
            color: #fff;
            line-height: 30px;
            font-size: 14px;
        }
        .menu>li{
            cursor: pointer;
        }

        .menu p{
            padding: 10px 20px;
            background: rgb(26, 52, 80)
            url(../img/close.gif) no-repeat 150px center;
            transition: 0.5s;
        }
        .menu p:hover{ font-weight: bold;
            padding-left: 30px;
        }
        .menu ul{
            background:  rgb(7, 41, 54);
            padding-left: 30px;
            display: none;
        }
        .menu .on p{
            background-image: url(../img/open.gif);
        }
        /* .item:hover{ */
        /* background-color: darkkhaki; */
        /* } */
        .mydiv{
            width:150px;
            height:150px;
            border-radius:50%;
            overflow:hidden
        }
    </style>
    <script src="../js/jquery-1.7.2.min.js"></script>
    <script>
        $(function(){
            $('.menu p').click(function(event) {
                $(this).parent().toggleClass('on');
                $(this).siblings('ul').stop().slideToggle();
                $(this).parent().siblings().find('ul').slideUp();
                $(this).parent().siblings().removeClass('on');
            });
        });
    </script>
</head>
<body>
<%
    empBean e = (empBean)session.getAttribute("login");
    String picture = e.getHeadPicture();
    if(picture==null){
        picture = "default.PNG";
    }
%>
<div class="mydiv">
    <a href="headPicture.jsp" target="right">
        <img src="../img/<%=picture %>" width="100%" height="100%" >
    </a></div>

<nav>
    <ul class="menu">
        <li>
            <p>考勤管理</p>
            <ul>
                <a href="../attendance/attendance.jsp" target="right" > <li class="item" style="color: white;">签到</li></a>
                <a href="../attendance/selectTop.jsp" target="right"> <li class="item" style="color: white;">查看考勤信息</li></a>


            </ul>
        </li>
        <li>
            <p>个人信息管理</p>
            <ul>
                <a href="../myself/selectMyself.jsp" target="right"> <li class="item" style="color: white;">查看个人信息</li></a>
                <a href="javascript"> <li class="item" style="color: white;">修改个人信息</li></a>

            </ul>
        </li>
        <li>
            <p>部门管理</p>
            <ul>
                <a href="/selectDeptServlet" target="right"> <li class="item" style="color: white;">查看部门信息</li></a>

            </ul>
        </li>
        <li>
            <p>公告管理</p>
            <ul>
                <a href="/selectNoticeServlet" target="right"> <li class="item" style="color: white;">查看公告</li></a>
            </ul>
        </li>
        <li>
            <p>职位管理</p>
            <ul>
                <a href="/selectPostServlet" target="right"> <li class="item" style="color: white;">职位申请</li></a>
                <a href="/selectApplyPostServlet" target="right"> <li class="item" style="color: white;">查看申请进度</li></a>
                <a href="javascript"> <li class="item" style="color: white;">离职申请</li></a>
                <a href="javascript"> <li class="item" style="color: white;">查看离职进度</li></a>
            </ul>
        </li>
        <li>
            <p>假期管理</p>
            <ul>
                <a href="javascript"> <li class="item" style="color: white;">申请假期</li></a>
                <a href="javascript"> <li class="item" style="color: white;">查看审核进度</li></a>
            </ul>
        </li>
        <li>
            <p>项目管理</p>
            <ul>
                <a href="javascript"> <li class="item" style="color: white;">查看项目信息</li></a>

            </ul>
        </li>
    </ul>

</nav>
</body>
</html>
