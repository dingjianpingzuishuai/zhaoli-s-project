<%@ page import="javaBean.noticeBean" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: 张爷爷！！！
  Date: 2020/12/25
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <style type="text/css">

        /* 按钮 */
        .btn {
            /* 内间距 */
            padding      : 1em 3em;
            /* 圆角 */
            border-radius: 6px;
            /* 背景色 */
            background-color: #fff;
            color          : #333;
            font-size      : 15px;
            text-decoration: none;
        }
        /* 按钮：鼠标移入效果 */
        .btn:hover {
            color: #00b894;
        }
        /* 模态框 背景 初始化样式 */
        .modal-window {
            /* 固定定位 */
            position: fixed;
            /* 实现满屏 */
            top     : 0;
            left    : 0;
            right   : 0;
            bottom  : 0;
            /* 半透明的背景 */
            background-color: rgba(0, 0, 0, 0.5);
            z-index: 9999;
            /* 初始化时让它隐藏 */
            visibility    : hidden;
            opacity       : 0;
            /* 不响应鼠标事件 */
            pointer-events: none;
            /* 让主体部分居中对齐 */
            display        : flex;
            justify-content: center;
            align-items    : center;

        }

        /* 模态框 背景 弹出样式 */
        .modal-window:target {
            visibility    : visible;
            opacity       : 1;
            pointer-events: auto;
        }

        /* 模态框主体部分 */
        .modal-window>div {
            position: relative;
            width  : 800px;
            padding: 2em;
            border-radius: 10px;
            background-color: #fff;
        }

        /* 模态框 关闭 */
        .modal-close {
            position: absolute;
            right: 30px;
            top  : 20px;
            color          : #aaa;
            text-decoration: none;
        }

        .modal-close:hover {
            color: #333;
        }
        /* 模态框 标题 */
        .modal-title {
            text-align: center;
            color    : #00b894;
            font-size: 30px;
            padding  : 15px 0;
        }
        /* 模态框正文 */
        .modal-body {
            font-size: 18px;
            margin: 15px 0;
        }
    </style>
</head>
<body>
    <table border="1" width="400px" height="80px" align="center">
        <tr>
            <td>公告标题</td>
            <td>操作</td>
        </tr>
        <%
            List<noticeBean> list = (List<noticeBean>)request.getAttribute("list");
            for(int i=0;i<list.size();i++){
        %>
            <tr>
                <td height="80px"><%=list.get(i).getNoticeTitle()%></td>
                <td height="80px">
                    <div class="container">
                        <!-- 今天实现一个纯css做的模态框 -->
                        <!-- 弹出按钮，这里使用a标签，链接地址使用#***模式 -->
                        <a class="btn" href="#open-modal<%=i%>">查看</a>
                    </div>
                    <!-- 这是里弹窗的目标区域。 -->
                    <!-- 这里是背景部分，会100%的满屏显示 -->
                    <div id="open-modal<%=i%>" class="modal-window">
                        <!-- 这里是弹框的主体部分 -->
                        <div>
                            <!-- 关闭按钮 -->
                            <a href="#" class="modal-close">Close</a>
                            <!-- 模态框标题 -->
                            <h1 class="modal-title">Title</h1>
                            <!-- 模态框的正文 -->
                            <div class="modal-body"><%=list.get(i).getNoticeBody()%></div>
                        </div>
                    </div>
                </td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
