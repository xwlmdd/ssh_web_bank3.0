<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>存款</title>
<meta name="keywords" content="毛豆豆银行，银行系统">
<meta name="description" content="毛豆豆银行是一个集查询、存款、取款、转账为一体的智能银行系统">
<link rel="stylesheet" href="<%=basePath%>css/style.css">
</head>
<script type="text/javascript">
	function comeback(){
		window.location.href="<%=basePath%>BankAction.do?method=toView&view=main";
	}
</script>
<body>
	<div class="header">
		<img src="images/logo.png" alt="logo图片">
		<div class="head">
			<a href="#" onclick="comeback()">首页</a> <span>|</span> <a href="<%=basePath %>BankAction.do?method=loginOut">退出</a>
		</div>
	</div>
	<div class="center">
		<p>您的账户余额为: 
		<c:choose>
			<c:when test="${empty money}">*****</c:when>
			<c:otherwise><font color="red">${money}</font></c:otherwise>
		</c:choose>
			
		</p>
		<p><font color="red">${errorMsg }</font></p>
		<form action="<%=basePath%>BankAction.do?method=cunkuan" method="post">
			<label for="">请输入要存入的金额：</label><input name="cunMoney" type="text">

			<ul>
				<li><input name="back" onclick="comeback()" value="返回" type="button">
				</li>
				<li><input name="submit" value="存款" type="submit">
				</li>
			</ul>
		</form>
	</div>
	<div class="foot">
		<p>copyright&copy;2016 All Right Reserved版权所有 许望禄 赣XWL备1205号</p>
	</div>
</body>
</html>