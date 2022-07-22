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
</head>
<body>
    <form id="myForm">
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
                <td><input type="button" value="登录" onclick="submitFrom()"></td>
                <td>${msg}</td>
            </tr>
        </table>
    </form>
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
        //提交表单

        var myForm=document.getElementById("myForm");
        myForm.action="${pageContext.request.contextPath}/control/login.action";
        myForm.method="post";
        myForm.submit();
    }
</script>
</html>
