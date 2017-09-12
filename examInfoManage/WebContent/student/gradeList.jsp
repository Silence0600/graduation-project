<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/pintuer.js"></script>
<script type="text/javascript" src="../js/gradeInput.js"></script>
</head>
<body>
<%-- <script>
	$(function(){
		$("#cxcj").click(function(){
			var studentNum = $("#xuehao").val();
			$.ajax({
				type:"post",
				data:{"studentNum":studentNum},
				asnyc:false,
				url : "queryTpAndG_queryGrade.action",
				success: function(data){
					$("#mainContent").html(data);
					},
				error: function(){
					console.log("失败了");
					}
				});
			});
		});
</script>
	<div>
		<form id="courseInfo">
		 <label	class="label">请输入学号：</label> 
				<input class="input" id="xuehao" type = "text" value="${studentNum}"/>
		</form>
		<button class="button bg-sub" id="cxcj"
			style="margin-top: 10px; width: 92px;">查询成绩</button>
	</div> --%>
	<hr class="bg-blue" />
	<div id="inputTable" class="table-responsive">
		<table class="table table-bordered" id="gradeTable">
			<tr class="blue">
				<th>班级</th>
				<th>姓名</th>
				<th>课程名</th>
				<th>任课老师</th>
				<th>平时成绩</th>
				<th>期末成绩</th>
				<th>总成绩</th>
			</tr>
			<tbody align="center">
				<s:iterator value="gradeList">
					<tr>
						<td><s:property value="clazz" /></td>
						<td><s:property value="studentName" /></td>
						<td><s:property value="courseName" /></td>
						<td><s:property value="teacherName" /></td>
						<td><s:property value="peaceTimeGrade" /></td>
						<td><s:property value="finalGrade" /></td>
						<td><s:property value="totalGrade" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>