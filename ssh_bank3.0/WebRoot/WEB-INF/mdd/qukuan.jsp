<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>取款</title>
	<meta name="keywords" content="毛豆豆银行，银行系统">
	<meta name="description" content="毛豆豆银行是一个集查询、存款、取款、转账为一体的智能银行系统">
	<link rel="stylesheet" href="<%=basePath %>css/style.css">
</head>
<script type="text/javascript">
	function choose1(){
		var chooseMoney = document.getElementById("b1");
		var quMoney = document.getElementById("quMoney");
		quMoney.value = chooseMoney.value;
	}
	function choose2(){
		var chooseMoney = document.getElementById("b2");
		var quMoney = document.getElementById("quMoney");
		quMoney.value = chooseMoney.value;
	}
	function choose3(){
		var chooseMoney = document.getElementById("b3");
		var quMoney = document.getElementById("quMoney");
		quMoney.value = chooseMoney.value;
	}
	function choose4(){
		var chooseMoney = document.getElementById("b4");
		var quMoney = document.getElementById("quMoney");
		quMoney.value = chooseMoney.value;
	}
	function choose5(){
		var chooseMoney = document.getElementById("b5");
		var quMoney = document.getElementById("quMoney");
		quMoney.value = chooseMoney.value;
	}
	function choose6(){
		var chooseMoney = document.getElementById("b6");
		var quMoney = document.getElementById("quMoney");
		quMoney.value = chooseMoney.value;
	}
	
	function check(){
		var quMoney = document.getElementById("quMoney");
		var f = document.form;
		f.submit();
	}
	
	function comeback(){
		window.location.href="<%=basePath%>BankAction.do?method=toView&view=main";
	}
</script>
<body>
	<div class="header">
		<img src="<%=basePath %>images/logo.png" alt="logo图片">
		<div class="head">
			<a href="#"onclick="comeback()">首页</a>
			<span>|</span>
			<a href="<%=basePath %>BankAction.do?method=loginOut">注销</a>
		</div>	
	</div>
	<div class="center">
		<p>您的账户余额为: 
		<c:choose>
			<c:when test="${empty money}">*****</c:when>
			<c:otherwise><font color="red">${money}</font></c:otherwise>
		</c:choose>
		<p><font color="red">${errorMsg }</font></p>
		<form action="<%=basePath%>BankAction.do?method=qukuan" method="post" name="form">
			<label for="">请输入要取出的金额：</label><input id="quMoney" name="quMoney" type="text"><br>
		
		<ul class="current">
			<li><span><input type="button" id="b1" value="100" onclick="choose1()"/></span></li>
			<li><span><input type="button" id="b2" value="200" onclick="choose2()"/></span></li>
			<li><span><input type="button" id="b3" value="500" onclick="choose3()"/></span></li>
			<li><span><input type="button" id="b4" value="1000" onclick="choose4()"/></span></li>
			<li><span><input type="button" id="b5" value="2000" onclick="choose5()"/></span></li>
			<li><span><input type="button" id="b6" value="5000" onclick="choose6()"/></span></li>
		</ul>
		<ul>
				<li><input type="button" value="确定" onclick="check()"/></li>
				<li><input type="button" onclick="comeback()" value="返回" /></li>
		</ul>
		</form>
	</div>
	<div class="foot">
		<p>copyright&copy;2016 All Right Reserved版权所有 许望禄 赣XWL备1205号</p>
	</div>
</body>
</html>
