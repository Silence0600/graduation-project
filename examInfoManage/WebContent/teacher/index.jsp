
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>欢迎访问考试信息管理系统</title>
<link rel="stylesheet" href="../css/pintuer.css">
<link rel="stylesheet" href="../css/index.css">
<script src="../js/jquery.js"></script>
<script src="../js/pintuer.js"></script>
<script type="text/javascript" src="../js/index.js"></script>

</head>
<%
	//true 为可以进jsp .要把改成false
	if (session.getAttribute("loginFlag").equals("false")) {
		response.sendRedirect("logout.action");
	}
%>

<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="../images/y.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />考试信息管理系统
			</h1>
		</div>

		<div class="head-l" style="float: right; margin-right: 15px;">
			<a class="button button-little bg-red" href="../exam.html"><span
				class="icon-power-off"></span> 返回首页</a>
		</div>

		<div style="float: right; margin-top: 36px; margin-right: 100px;">
			<span>您的身份:${status}</span>
		</div>

	</div>
	<div class="leftnav">
		<div class="leftnav-title" style="height: 40px;">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-user"></span>系统信息管理
		</h2>
		<ul style="display: block">
			<li><a href="javascript:void(0)" target="_self" id="apkc"><span
					class="icon-caret-right"></span>安排考程</a></li>
			<li><a href="javascript:void(0)" target="_self" id="lrcj"><span
					class="icon-caret-right"></span>录入成绩</a></li>
			<li><a href="javascript:void(0)" target="_self" id="jkkc"><span
					class="icon-caret-right"></span>监考考程</a></li>		
		</ul>
	</div>

	<ul class="bread">
		<li><a href="index.jsp" target="_self" class="icon-home"> 首页</a></li>
	</ul>
	<div id="mainContent" class="admin">
	</div>
	<script type="text/javascript">
		$(function() {
	<%String key = (String) session.getAttribute("key");
			System.out.println(key);
			if ("kcap".equals(key)) {%>
		$("#apkc").trigger("click");
	<%} else {%>
		$("#lrcj").trigger("click");
	<%}%>
		});
	</script>
</body>
</html>