<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>毛豆豆银行</title>
	<meta name="keywords" content="毛豆豆银行，银行系统">
	<meta name="description" content="毛豆豆银行是一个集查询、存款、取款、转账为一体的智能银行系统">
	<link rel="stylesheet" href="<%=basePath %>css/style.css">
</head>
<body>
	<div class="header">
		<img src="<%=basePath %>images/logo.png" alt="logo图片">
		<div class="head">
			<span>欢迎${username}</span>
			<span>|</span>
			<a href="<%=basePath %>BankAction.do?method=loginOut">注销</a>|
			<a href="<%=basePath %>BankAction.do?method=changelanguage&language=en">英文</a>|
			<a href="<%=basePath %>BankAction.do?method=changelanguage&language=zh">中文</a>
		</div>	
	</div>
	<ul class="homepage">
		<li><a href="<%=basePath %>BankAction.do?method=chaxun&username=${username}"><bean:message key="bank.query"/></a></li>
		<li><a href="<%=basePath %>BankAction.do?method=toView&view=cunkuan"><bean:message key="bank.cunkuan"/></a></li>
		<li><a href="<%=basePath %>BankAction.do?method=toView&view=qukuan"><bean:message key="bank.qukuan"/></a></li>
		<li><a href="<%=basePath %>BankAction.do?method=toView&view=zhuanzhang"><bean:message key="bank.zhuanzhang"/></a></li>
	</ul>
	<div class="foot">
		<p>copyright&copy;2016 All Right Reserved版权所有 许望禄 赣XWL备1205号</p>
	</div>
</body>
</html>