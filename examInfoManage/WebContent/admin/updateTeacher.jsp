<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form>
			<input id="id" type="hidden" value="${teacherId}"> <label
				class="label">请修改教师号:</label> <input class="input" id="num"
				type="text" value="${teacherNum}" /></br> <label class="label">请修改教师名:</label>
			<input class="input" id="name" type="text" value="${teacherName}" /><br>
			<label class="label">请修改年龄:</label> <input class="input" id="age"
				type="text" value="${age}" /><br> <label class="label">请修改性别:</label>
			<select class="input" id="sex">
				<option>男</option>
				<option>女</option>
			</select>
			<br>
		</form>
	</div>
	<button class="button border-sub" id="xgjsxx">保存修改</button>
	<script type="text/javascript">
		$(function() {
			$("#xgjsxx").click(function() {
				var teacherId = $("#id").val();
				var teacherNum = $("#num").val();
				var teacherName = $("#name").val();
				var age = $("#age").val();
				var sex = $("#sex").val();
				$.ajax({
					url:"teacherManage_updateTeacher.action",
					type :"post",
					async : false,
					data:{
						"teacherId":teacherId,
						"teacherNum":teacherNum,
						"teacherName":teacherName,
						"age":age,
						"sex":sex
						},
					success : function(data){
						window.location.reload();
						},
					error:function(){
						
						}
					});
			});
		});
	</script>
</body>
</html>