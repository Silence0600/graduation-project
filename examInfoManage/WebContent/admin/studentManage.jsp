<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function xiugaijiemian(studentId, studentNum, studentName, clazz ,sex) {
	console.log(studentId);
	console.log(studentNum);
	console.log(studentName);
	console.log(clazz);
	console.log(sex);
	$.ajax({
		url : "studentManage_changeToUpdatePage.action",
		data : {
			"studentId" : studentId,
			"studentNum" : studentNum,
			"studentName" : studentName,
			"clazz" : clazz,
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
$(function() {
	$("#cxzdxs").click(
					function() {
						var studentNum = $("#xh").val();
						$.ajax({
									type : "post",
									url : "studentManage_queryStudent.action",
									async : false,
									data : {
										'studentNum' : studentNum,
									},
									cache : false, 
									dataType : "json",
									success : function(data) {
										var student = eval('(' + data + ')'); // 解析是第一步;
										console.log(student[0].studentNub);
										// 然后each循环取出
										var tr = "<tr><td>"
												+ student[0].studentNub
												+ "</td><td>"
												+ student[0].name
												+ "</td><td>"
												+ student[0].clazz
												+ "</td><td>"
												+ student[0].sex
												+ "</td><td><button class=\"button border-main\" onclick=\"xiugai("
												+ student[0].studentId
												+ ","
												+ student[0].studentNub
												+ ",'"
												+ student[0].name
												+ "',"
												+ student[0].clazz
												+ "',"
												+ student[0].sex
												+ " ) \">修改</button>&nbsp<button class=\"button border-dot\" onclick=\"shanchu("
												+ student[0].studentId
												+ ")\">删除</button></td></tr>";
										console.log(tr);
										$("#studentTab").html(tr);
									},
									error : function(data) {
										alert("系统忙,请重试!");
									}
								});

					});
	$("#xzjs").click(function() {
		$.ajax({
			type : "post",
			url : "studentManage_changeToAddPage.action",
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
function shanchuStudent(studentId){
	console.log(studentId);
	$.ajax({
		type : "post",
		url : "studentManage_deleteStudent.action",
		async : false,
		data : {
			"studentId":studentId
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
</head>
<body>
<div style="height: 70px;">
		<div style="float: left; width: 300px; margin-right: 50px;">
			<label class="label">请输入学号:</label> <input class="input" id="xh"
				type="text" />
		</div>
	</div>
	<button id="cxzdxs" class="button bg-sub">查询</button>	
	<button id="xzjs" class="button bg-sub">新增学生信息</button>
	<hr class="bg-blue">
	<div class="table-responsive">
		<table class="table table-bordered">
			<tr class="blue">
				<th>学号</th>
				<th>姓名</th>
				<th>班级</th>
				<th>性别</th>
				<th>操作</th>
			</tr>
			<tbody id="studentTab" align="center">
				<s:iterator value="allStudents">
					<tr>
						<td style="display:none"><s:property value="studentId"/></td>
						<td><s:property value="studentNub"/></td>
						<td><s:property value="name" /></td>
						<td><s:property value="clazz"/></td>
						<td><s:property value="sex" /></td>
						<td><button class="button border-main"
						onclick="xiugaijiemian( <s:property value="studentId"/> , <s:property value="studentNub"/> , '<s:property value="name"/>' , '<s:property value="clazz"/>', '<s:property value="sex"/>' )">修改</button>
							<button class="button border-dot" onclick="shanchuStudent(<s:property value="studentId"/> )">删除</button></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>