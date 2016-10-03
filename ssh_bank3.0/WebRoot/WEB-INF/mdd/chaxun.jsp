<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>查询</title>
	<meta name="keywords" content="毛豆豆银行，银行系统">
	<meta name="description" content="毛豆豆银行是一个集查询、存款、取款、转账为一体的智能银行系统">
	<link rel="stylesheet" href="<%=basePath %>css/style.css">
</head>
<script type="text/javascript">
	function comeback(){
		window.location.href="<%=basePath%>BankAction.do?method=toView&view=main";
	}
</script>
<body>
	<div class="header">
		<img src="<%=basePath %>images/logo.png" alt="logo图片">
		<div class="head">
			<a href="#" onclick="comeback()">首页</a>
			<span>|</span>
			<a href="<%=basePath %>BankAction.do?method=loginOut">退出</a>
		</div>	
	</div>
	<div class="center">
		<p>您的账户余额为:${money}</p>
		<ul>
			<li><a href="#" onclick="comeback()">继续</a></li>
			<li><a href="#" onclick="comeback()">返回</a></li>
		</ul>
	</div>
	<div class="foot">
		<p>copyright&copy;2016 All Right Reserved版权所有 许望禄 赣XWL备1205号</p>
	</div>
</body>
</html>