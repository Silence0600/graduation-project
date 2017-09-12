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
			<input id="id" type="hidden" value="${studentId}"> <label
				class="label">请修改学号:</label> <input class="input" id="num"
				type="text" value="${studentNum}" /></br> <label class="label">请修改学生名:</label>
			<input class="input" id="name" type="text" value="${studentName}" /><br>
			<label class="label">请修改年龄:</label> <input class="input" id="clazz"
				type="text" value="${clazz}" /><br> <label class="label">请修改性别:</label>
			<select class="input" id="sex">
				<option>男</option>
				<option>女</option>
			</select>
			<br>
		</form>
	</div>
	<button class="button border-sub" id="xgxsxx">保存修改</button>
	<script type="text/javascript">
		$(function() {
			$("#xgxsxx").click(function() {
				var studentId = $("#id").val();
				var studentNum = $("#num").val();
				var studentName = $("#name").val();
				var clazz = $("#clazz").val();
				var sex = $("#sex").val();
				$.ajax({
					url:"studentManage_updateStudent.action",
					type :"post",
					async : false,
					data:{
						"studentId":studentId,
						"studentNum":studentNum,
						"studentName":studentName,
						"clazz":clazz,
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