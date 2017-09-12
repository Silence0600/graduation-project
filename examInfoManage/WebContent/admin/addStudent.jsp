<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form id="">
			<label class = "label">请填写学号</label> 
			<input id="studentNum" type="text" class="input"/>
			<label class = "label">请填写姓名:</label>
			<input id="studentName" type="text" class="input"/>
			<label class = "label">请填写班级:</label>
			 <input id="clazz" type="text" class="input"/>
			 <label class = "label">请选择性别:</label>
			 <select id="sex" class="input">
			 	<option>男</option>
			 	<option>女</option>
			 </select>
		</form>
	</div>
	<button id="bcxsxs" class="button border-sub" style="margin-top: 10px;">保存</button>
</body>
<script>
		$(function() {
			 $("#bcxsxs").click(function() {
				 console.log("32324");
				var studentNum = $("#studentNum").val();
				var studentName = $("#studentName").val();
				var clazz = $("#clazz").val();
				var sex = $("#sex").val();
				$.ajax({
					type : "post",
					url : "studentManage_saveStudent.action",
					async : false,
					data : {
						'studentNum' : studentNum,
						'studentName' : studentName,
						'clazz' : clazz,
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