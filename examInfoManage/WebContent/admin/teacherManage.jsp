<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/pintuer.js"></script>
<script type="text/javascript">
function xiugaijiemian(teacherId, teacherNum, teacherName, age ,sex) {
	console.log(teacherId);
	console.log(teacherNum);
	console.log(teacherName);
	console.log(age);
	console.log(sex);
	$.ajax({
		url : "teacherManage_changeToUpdatePage.action",
		data : {
			"teacherId" : teacherId,
			"teacherNum" : teacherNum,
			"teacherName" : teacherName,
			"age" : age,
			"sex" : sex
		},
		type : "post",
		async : false,
		success : function(data) {
			$("#mainContent").html(data);
		},
		error : function() {
			alert("系统忙,请稍后重试!");
		}
	});
	}
</script>
</head>
<body>
	<div style="height: 70px;">
		<div style="float: left; width: 300px; margin-right: 50px;">
			<label class="label">请输入教师编号:</label> <input class="input" id="jsh"
				type="text" />
		</div>
		<div style="float: left; width: 300px;">
			<label class="label">请输入教师名:</label><input class="input" id="jsm"
				type="text" />
		</div>
	</div>
	<button id="cxzdjs" class="button bg-sub">查询</button>
	<script type="text/javascript">
		$(function() {
			$("#cxzdjs").click(
							function() {
								var teacherNum = $("#jsh").val();
								var teacherName = $("#jsm").val();
								$
										.ajax({
											type : "post",
											url : "teacherManage_queryOne.action",
											async : false,
											data : {
												'teacherNum' : teacherNum,
												'teacherName' : teacherName,
											},
											cache : false, 
											dataType : "json",
											success : function(data) {
												var teacher = eval('(' + data
														+ ')'); // 解析是第一步;
												console
														.log(teacher[0].teacherNum);
												// 然后each循环取出
												var tr = "<tr><td>"
														+ teacher[0].teacherNum
														+ "</td><td>"
														+ teacher[0].teacherName
														+ "</td><td>"
														+ teacher[0].age
														+ "</td><td>"
														+ teacher[0].sex
														+ "</td><td><button class=\"button border-main\" onclick=\"xiugai("
														+ teacher[0].teacherId
														+ ","
														+ teacher[0].teacherNum
														+ ",'"
														+ teacher[0].teacherName
														+ "',"
														+ teacher[0].age
														+ "',"
														+ teacher[0].sex
														+ " ) \">修改</button>&nbsp<button class=\"button border-dot\" onclick=\"shanchu("
														+ teacher[0].teacherId
														+ ")\">删除</button></td></tr>";
												console.log(tr);
												$("#teacherTab").html(tr);
											},
											error : function(data) {
												alert("系统忙,请重试!");
											}
										});

							});
			$("#xzjs").click(function() {
				$.ajax({
					type : "post",
					url : "teacherManage_changeToAddPage.action",
					async : false,
					success : function(data) {
						$("#mainContent").html(data);
					},
					error : function(data) {
						alert("系统忙,请重试!");
					}
				});
			});
		});
		function shanchuTeacher(teacherId){
			console.log(teacherId);
			$.ajax({
				type : "post",
				url : "teacherManage_deleteTeacher.action",
				async : false,
				data : {
					"teacherId":teacherId
					},
				success : function(data) {
					 window.location.reload(); 
					
				},
				error : function(data) {
					alert("系统忙,请重试!");
				}
			});
			}
	</script>
	<button id="xzjs" class="button bg-sub">新增教师</button>
	<hr class="bg-blue">
	<div class="table-responsive" id="teacherList">
		<table class="table table-bordered">
			<tr class="blue">
				<th>教师编号</th>
				<th>教师姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>操作</th>
			</tr>
			<tbody id="teacherTab" align="center">
				<s:iterator value="allTeachers">
					<tr>
						<td style="display: none"><s:property value="teacherId" /></td>
						<td><s:property value="teacherNum" /></td>
						<td><s:property value="teacherName" /></td>
						<td><s:property value="age" /></td>
						<td><s:property value="sex" /></td>
						<td><button class="button border-main"
						onclick="xiugaijiemian( <s:property value="teacherId"/> , <s:property value="teacherNum"/> , '<s:property value="teacherName"/>' , <s:property value="age"/>, '<s:property value="sex"/>' )">修改</button>
							<button class="button border-dot" onclick="shanchuTeacher(<s:property value="teacherId"/> )">删除</button></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>