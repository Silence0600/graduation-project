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
	<script>
	
		$(function() {
			$("#cxkc").click(function() {
				var gjz = $("#gjz").val();
				console.log(gjz);
				$.ajax({
					type : "post",
					async : true,
					//	dataType : "json",
					data : {
						"gjz" : gjz
					},
					url : "queryTpAndG_queryTp.action",
					success : function(data) {
						$("#mainContent").html(data);
					},
					error : function(data) {
						console.log("No");
					}
				});
			});
		});
	</script>
	<div>
		<form>
			<label class="label">请输入学生姓名/课程名/监考教师姓名:</label>
			<input class="input"id="gjz" type="text" value="${gjz}"/>
		</form>
	</div>
	<button class="button bg-sub" id="cxkc"style="margin-top: 10px; width: 92px;">查询考程</button>
	<hr class="bg-blue">
	<div id="inputTable" class="table-responsive">
		<table class="table table-bordered" id="gradeTable">
			<tr class="blue">
				<th>课程名</th>
				<th>任课老师</th>
				<th>考试时间</th>
				<th>考试地点</th>
				<th>监考教师</th>
			</tr>
			<tbody align="center">
				<s:iterator value="TpList">
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
	</div>
</body>
</html>