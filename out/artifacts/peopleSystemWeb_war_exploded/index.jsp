<%--
  Created by IntelliJ IDEA.
  User: 张爷爷！！！
  Date: 2020/12/23
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>


      .box{
        position: absolute;/*生成绝对定位的元素，元素的位置通过 "left", "top", "right" 以及 "bottom" 属性进行规定。(此处相对于body)*/
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);/* 实现块元素百分比下居中*/
        width: 400px;
        padding: 40px;/*设置四个内边距*/
        background: rgba(0,0,0,0.8);/*函数的前三个变量为颜色（黑），后一个为透明度（1为不透明）*/
        box-sizing: border-box;/*使实际所占宽高度 = 设置的高度（height）/ 设置的宽度（width）+ 外边距（margin）*/
        box-shadow: 0 15px 25px rgba(0,0,0,.5);/*产生盒子阴影：x轴偏移，y轴偏移，模糊度，透明色*/
        border-radius: 10px;/*使矩形四边圆滑*/
      }
      .box h2{
        margin: 0 0 30px;/*上、左右、下*/
        padding: 0;
        color: #ffffff;/*设置字体颜色*/
        text-align: center;/*文字居中*/
      }
      .box .inputBox{
        position: relative;/*相对定位*/
      }
      .box .inputBox input{
        width: 100%;
        padding: 10px 0;/*上下、左右*/
        font-size: 16px;/*字体大小（可用于调节输入框高）*/
        color: #ffffff;/*输入框颜色*/
        letter-spacing: 1px;/*设置对象中的文字之间的间隔*/
        margin-bottom: 30px;/*设置下外距*/
        border: none;/*定义无边框*/
        border-bottom: 1px solid #ffffff;/*底边框：大小1PX 实线 颜色#ffffff */
        outline: none;/*设置无外边框*/
        background: transparent;/*背景设置为透明*/
      }
      .box .inputBox label{
        position: absolute;
        top: 0;
        left: 0;
        letter-spacing: 1px;
        padding: 10px 0;
        font-size: 16px;
        color: #ffffff;
        pointer-events:none;/*阻止区块被点击，使得点击穿透*/
        transition: 1s;/*动画运行时间*/
      }
      /*产生对应操作时，label发生的样式变化*/
      .box .inputBox input:focus~label,
      .box .inputBox input:valid~label
      {
        top:-18px;
        left: 0;
        color: #03a9f4;
        font-size: 12px;
      }
      .box input[type="submit"]{
        background: transparent;
        border: none;
        outline: none;
        color: #ffffff;
        background: #03a9f4;
        margin: 0px 80px;
        padding: 10px 30px;
        cursor: pointer;/*鼠标指针变成手的形状*/
        border-radius: 15px;/*调节矩形弧度*/
      }
      .box a{
        background: transparent;
        border: none;
        outline: none;
        color: #ffffff;

        margin: 10px 90px;
        padding: 10px 30px;
        cursor: pointer;/*鼠标指针变成手的形状*/
        border-radius: 15px;/*调节矩形弧度*/
      }
    </style>
      </head>
  <body>
  <div class="box">
    <h2>Login of employee</h2>
    <!--创建供用户输入的 HTML 表单-->
    <form action="/loginServlet" method="post" id = "myform">
      <div class="inputBox">
        <input type="text" name="empID" required="">
        <label>账号</label>
      </div>
      <div class="inputBox">
        <input type="password" name="empPassword" required="">
        <label>密码</label>
      </div>

      <input type="radio" name="ide"value="1"><font style="color:white">员工</font>
      <input type="radio" name="ide"value="2"><font style="color:white">部门经理</font>
      <input type="radio" name="ide"value="3"><font style="color:white">管理员</font>



      <div align="center">
        <br>
        <input type="submit" name="" value="Login" >
      </div><br>

    </form>
  </div>
  </body>
</html>
