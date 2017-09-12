<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form id="">
			<label class = "label">请填写教师号</label> 
			<input id="teacherNum" type="text" class="input"/>
			<label class = "label">请填写教师名:</label>
			<input id="teacherName" type="text" class="input"/>
			<label class = "label">请填写年龄:</label>
			 <input id="age" type="text" class="input"/>
			 <label class = "label">请选择性别:</label>
			 <select id="sex" class="input">
			 	<option>男</option>
			 	<option>女</option>
			 </select>
		</form>
	</div>
	<button id="bcygjs" class="button border-sub" style="margin-top: 10px;">保存</button>
</body>
<script>
		$(function() {
			 $("#bcygjs").click(function() {
				 console.log("32324");
				var teacherNum = $("#teacherNum").val();
				var teacherName = $("#teacherName").val();
				var age = $("#age").val();
				var sex = $("#sex").val();
				$.ajax({
					type : "post",
					url : "teacherManage_saveTeacher.action",
					async : false,
					data : {
						'teacherNum' : teacherNum,
						'teacherName' : teacherName,
						'age' : age,
						'sex' :sex
					},
					success : function(result) {
						 location.reload();
						},
						error : function(data) {
							alert("失败!");
						}
				});
			}); 
		});
	</script>
</html>