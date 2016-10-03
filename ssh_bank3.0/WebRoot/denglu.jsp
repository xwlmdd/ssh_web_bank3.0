<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>登录</title>
	<meta name="keywords" content="毛豆豆银行，银行系统">
	<meta name="description" content="毛豆豆银行是一个集查询、存款、取款、转账为一体的智能银行系统">
	<link rel="stylesheet" href="<%=basePath %>css/denglu.css">
</head>
<script type="text/javascript">
	function loginCheck(){
	var f = document.form;
		var username = f.userName.value;
		if(username==""){
			alert("用户名不能为空！");
			return false;
		}
		
		var password = f.password.value;
		if(password==""){
			alert("密码不能为空！");
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
			<a href="#"><bean:message key="bank.title"/></a>
			<span>|</span>
		</div>	
	</div>
	<div class="main">
		<p><bean:message key="bank.login"/></p>
		<p>${errorMsg}</p>
		<form action="<%=basePath%>BankAction.do" id="dl" name="form" method="post">
			<input type="hidden" name="method" value="login"/>
			<label for=""><bean:message key="bank.user.name"/></label>&nbsp;&nbsp;<input id="username" name="userName" type="text"><br><br>
			<label for=""><bean:message key="bank.user.password"/></label>&nbsp;&nbsp;<input id="password"  name="password" type="password"><br><br><br>
			<input type="button" onclick="loginCheck()" value="<bean:message key="bank.button.login"/>"  class="current">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="<bean:message key="bank.button.register"/>" class="current">
		</form>
	</div>
	<div class="foot">
		<p>copyright&copy;<bean:message key="bank.copyright"/></p>
	</div>
</body>
</html>