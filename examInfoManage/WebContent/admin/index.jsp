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
	if (session.getAttribute("loginFlag").equals("false")||(!session.getAttribute("status").equals("管理员"))) {
		response.sendRedirect("logout.action");
	}
%>
<script type="text/javascript">
$(function(){
	<%String key = (String) session.getAttribute("key");
			if ("kcgl".equals(key)) {%>
		 $("#glkc").trigger("click"); 
		
	<%} else if("jsgl".equals(key)) {%>
		$("#gljs").trigger("click");
	<%} else{%>
		$("#glxs").trigger("click");
	<%}%>
});
</script>
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
			<li><a href="javascript:void(0)" id="glkc" ><span
					class="icon-caret-right"></span>管理考场信息</a></li>
			<li><a href="javascript:void(0)"  id="gljs"><span
					class="icon-caret-right"></span>管理教师信息</a></li>
			<li><a href="javascript:void(0)"  id="glxs"><span
					class="icon-caret-right"></span>管理学生信息</a></li>
		</ul>
	</div>
	<ul class="bread">
		<li id="shouye"><a href="index.jsp" class="icon-home"> 首页</a></li>
	</ul>
	<div id="mainContent" class="admin">
	</div>
	<!--对话框  -->
	<script type="text/javascript">
	$("body").on("click","#bcxg",function(e){
		e.stopPropagation();
		var examRoomId=$("#id").val();
		var examRoomNum = $("#num").val();
		var examRoomName = $("#name").val();
		var accommodateNum = $("#accNum").val();
		console.log(examRoomId+examRoomNum+examRoomName+accommodateNum);
		$.ajax({
			asnyc:false,
			url:"examRoom_update.action",
			type:"post",
			data:{"examRoomId":examRoomId,"examRoomNum":examRoomNum,"examRoomName":examRoomName,"accommodateNum":accommodateNum},				
			success:function(data){
				$("#gxkccg").trigger("click"); 
				},
			error:function(){
				alert("系统忙,请稍后重试");
				}
			});	
	});
	</script>
    <p hidden="hidden">
		<button id="gxkccg" class="button button-big bg-main dialogs"
			data-toggle="click" data-target="#updateSucDialog" data-mask="2"
			data-width="30%"></button>
	 </p> 
	 <div id="updateSucDialog">
		<div class="dialog">
			<div class="dialog-head">
				<span class="close rotate-hover"></span><strong>更新考场信息</strong>
			</div>
			<div class="dialog-body">
				<span>更新考场信息成功！</span>
			</div>
			<div class="dialog-foot">			
				<button id="sxgxym" class="button">确定</button>
				<script type="text/javascript">
		$(function(){
			//点击确定的时候刷新页面
			$("#sxgxym").click(function(){
			    window.location.reload(); 
				/* $("#gbdh").trigger("click");  */
				});
			});
	</script>
			</div>
		</div> 
 </div> 
</body>
</html>