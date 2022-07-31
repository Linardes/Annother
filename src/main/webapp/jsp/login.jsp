<%--
  Created by IntelliJ IDEA.
  User: 林明江
  Date: 2022/7/8
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>
    <div class="div1">
        <div class="div2">
            <img src="../images/cloud.jpg"><span>LOGIN</span>
        </div>
    <form id="myForm" class="myForm">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="name" id="nameId"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="psw" id="pswId"></td>
            </tr>
            <tr>
                <td>验证码：</td>
                <td><input type="text" name="verCode" id="verCodeId" autocomplete="off"></td>
            </tr>
        </table>
        <img src="/controller2/captcha.action" width="216px" height="50px" />
        <input type="button" value="登录" onclick="submitFrom()"></td>
        <input type="button" value="注册" onclick=""></td>
        ${msg}
    </form>
    </div>
</body>
<script>
    function submitFrom()
    {

        //检查用户名是否为空
        if(document.getElementById("nameId").value=="")
        {
            alert("请输入登录账户！");
            return;
        }
        //检查用户名是否为空
        if(document.getElementById("pswId").value=="")
        {
            alert("请输入登录密码！");
            return;
        }
        //检查验证码是否为空
        if(document.getElementById("verCodeId").value==""){
            alert("请输入验证码！");
            return;
        }
        //提交表单

        var myForm=document.getElementById("myForm");
        myForm.action="${pageContext.request.contextPath}/controller1/login.action";
        myForm.method="post";
        myForm.submit();
    }
</script>
</html>
