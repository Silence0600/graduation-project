<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="inputTable" class="table-responsive">
		<p>未监考科目:</p>
		<% List teacherTPList2 = (List)session.getAttribute("teacherTPList2");
			
		if(teacherTPList2.size()==0){%>
			<p>无</p>
		<%}else{ %>
		<table class="table table-bordered" id="gradeTable">
			<tr class="blue">
				<th>课程名</th>
				<th>任课老师</th>
				<th>考试时间</th>
				<th>考试地点</th>
				<th>监考教师</th>
			</tr>
			<tbody align="center">
				<s:iterator value="teacherTPList2">
					<tr>
						<td><s:property value="courseName" /></td>
						<td><s:property value="teacherName" /></td>
						<td><s:property value="examTime" /></td>
						<td><s:property value="examRoomName" /></td>
						<td><s:property value="invigilator" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div><%} %>
	
	<div id="inputTable" class="table-responsive">
	<p>已监考科目:</p>
		<% List teacherTPList = (List)session.getAttribute("teacherTPList");
			
		if(teacherTPList.size()==0){%>
			<p>无</p>
		<%}else{ %>
		<table class="table table-bordered" id="gradeTable">
			<tr class="blue">
				<th>课程名</th>
				<th>任课老师</th>
				<th>考试时间</th>
				<th>考试地点</th>
				<th>监考教师</th> 
			</tr>
			<tbody align="center">
				<s:iterator value="teacherTPList">
					<tr>
						<td><s:property value="courseName" /></td>
						<td><s:property value="teacherName" /></td>
						<td><s:property value="examTime" /></td>
						<td><s:property value="examRoomName" /></td>
						<td><s:property value="invigilator" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div><%} %>
</body>
</html>