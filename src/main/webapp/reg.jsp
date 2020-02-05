<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script type="text/javascript" src="js/Calendar.js"></script>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="js/function.js"></script>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post"><h1><a href="index.jsp">首页</a></h1>
        <p>用户注册</p>
        <p><input type="text" name="username" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入用户名"><span class="error"></span></p>
        <p><input type="text" name="password" value="" placeholder="请输入密码"><span></span></p>
        <p><input type="text" name="mobile" value="" placeholder="请输入电话"><span></span></p>
        <p><input type="text" name="address" value="" placeholder="请输入地址"><span></span></p>
        <p><input type="text" name="birthday" value="" onClick="new Calendar().show(this);" placeholder="请输入生日"></p>
        <p class="txtL txt"><input class="code" onfocus="FocusItem(this)" onblur="CheckItem(this)" type="text" name="veryCode" value="" placeholder="验证码"><img
               src="createcode" onclick="changeImg()" id="codeimg"><span class="error">验证码不能为空</span>
<%--            <a href="javascript:void(0);" onclick="changeImg()">看不清，换一张</a>--%>
        </p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">使用条款和隐私策略</a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>

</body>
</html>