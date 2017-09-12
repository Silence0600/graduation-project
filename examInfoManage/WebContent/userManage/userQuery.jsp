<%@page import="java.util.Iterator"%>
<%@page import="edu.tjcu.entities.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="../css/pintuer.css">

<script src="../js/jquery.js"></script>


</head>
<body>

	<table class="table table-bordered">
		<tr>
			<th>姓名</th>
			<th>密码</th>
			<th>状态</th>
		</tr>

		<s:iterator value="allUser">
			<tr>
				<td><s:property value="name" /></td>
				<td><s:property value="password" /></td>
				<td><s:property value="status" /></td>
			</tr>
		</s:iterator>
	</table>

</body>
</html>