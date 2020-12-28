<%--
  Created by IntelliJ IDEA.
  User: 张爷爷！！！
  Date: 2020/12/25
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#button1").click(function(){

                $.ajax({
                    url:"/signinServlet",
                    data:"action=doGet",
                    type:"post",
                    success:function(data){

                        if(data==0){
                            alert("签到失败");
                        }else if(data==1){
                            alert("签到成功");
                        }else {
                            alert("已经签到啦");
                        }
                    },

                });
            });

            $("#button2").click(function(){

                $.ajax({
                    url:"/signoutServlet",
                    data:"action=doGet",
                    type:"post",
                    success:function(data){

                        if(data==0){
                            alert("签退失败");
                        }else if(data==1){
                            alert("签退成功");
                        }else {
                            alert("已经签退啦");
                        }
                    },

                });
            });
        });
    </script>
</head>
<body>
    <button type="button" class="btn btn-default" id="button1">签到</button>
    <button type="button" class="btn btn-default" id="button2">签退</button>
</body>
</html>
