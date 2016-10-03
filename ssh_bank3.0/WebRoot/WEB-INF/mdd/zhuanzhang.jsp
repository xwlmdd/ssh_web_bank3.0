<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>转账</title>
	<meta name="keywords" content="毛豆豆银行，银行系统">
	<meta name="description" content="毛豆豆银行是一个集查询、存款、取款、转账为一体的智能银行系统">
	<link rel="stylesheet" href="<%=basePath %>css/style.css">
	<script type="text/javascript"
	src="<%=basePath %>js/jquery.js"></script>
</head>
<script type="text/javascript">
	$(function(){
			$("#toUser").change(function(){
				$("#mesusername").html("");
				var username = $.trim($(this).val());
				if(username != ""){
					var url="<%=basePath %>BankAction.do?method=checkIsExistToUser";
					var args={"username":username,"time":new Date()};
					$.post(url,args,
					function(data){
						if(data==0){
							$("#mesusername").html("<font color='red'>此账户不存在！</font>");
						}
				});
			}
		});
	});
	
	function comeback(){
		window.location.href="<%=basePath%>BankAction.do?method=toView&view=main";
	}
	
	function check(){
		var zhuanMoney = document.getElementById("zhuanMoney");
		var f = document.form;
		f.submit();
	}
</script>
<body>
	<div class="header">
		<img src="<%=basePath %>images/logo.png" alt="logo图片">
		<div class="head">
			<a href="#" onclick="comeback()">首页</a>
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
		<form action="<%=basePath%>BankAction.do?method=zhuanzhang" name="form" method="post">
			<label for="">请输入要转入的账户：</label><input name="toUserName"  id="toUser" type="text"><p id="mesusername"></p>
			<label for="">请输入要转入的金额：</label><input name="zhuanMoney" id="zhuanMoney" type="text" >
		</form>
		<ul>
			<li><input type="button" value="确定" onclick="check()"/></li>
			<li><input type="button" onclick="comeback()" value="返回" /></li>
		</ul>
	</div>
	<div class="foot">
		<p>copyright&copy;2016 All Right Reserved版权所有 许望禄 赣XWL备1205号</p>
	</div>
</body>
</html>