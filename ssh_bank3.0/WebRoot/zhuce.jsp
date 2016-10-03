<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>注册</title>
	<meta name="keywords" content="毛豆豆银行，银行系统">
	<meta name="description" content="毛豆豆银行是一个集查询、存款、取款、转账为一体的智能银行系统">
	<link rel="stylesheet" href="<%=basePath %>css/denglu.css">
</head>
<script type="text/javascript">
	function registerCheck(){
	var f = document.form;
		var username = f.userName.value;
		if(username==""){
			alert("用户名不能为空！");
			return false;
		}
		
		var onePassword = f.onePassword.value;
		if(onePassword==""){
			alert("密码不能为空！");
			return false;
		}
		
		var password = f.password.value;;
		if(password==""){
			alert("密码不能为空！");
			return false;
		}
		if(onePassword!=password){
			alert("两次密码不一致！");
			return false;
		}
		
		f.submit();
		return true;
	}
	
</script>
<body>
	<div class="header">
		<img src="<%=basePath %>images/logo.png" alt="logo图片">
		<div class="head">
			<a href="#">欢迎来毛豆豆银行</a>
			<span>|</span>
		
		</div>	
	</div>
	<div class="main">
		<p>用户注册</p>
		<p>${errorMsg }</p>
		<form action="<%=basePath %>BankAction.do?method=register" id="dl" name="form" method="post">
			<label for="">用户名</label>&nbsp;&nbsp;<input id="username"name="userName" type="text"><br><br>
			<label for="">密     码</label>&nbsp;&nbsp;<input id="onePassword" name="onePassword" type="password"><br><br>
			<label for="">重复密码</label>&nbsp;<input id="password" name="password" type="password"><br><br><br>
			<input id="zhuche" onclick="registerCheck()" type="button" value="注册" class="current">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" class="current">
		</form>
	</div>
	<div class="foot">
		<p>copyright&copy;2016 All Right Reserved版权所有 许望禄 赣XWL备1205号</p>
	</div>
</body>
</html>