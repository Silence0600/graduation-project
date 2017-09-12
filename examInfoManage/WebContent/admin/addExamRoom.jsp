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
			<label class = "label">请填写考场号</label> 
			<input id="ExamRoomNum" type="text" class="input"/>
			<label class = "label">请填写考场名:</label>
			<input id="ExamRoomName" type="text" class="input"/>
			<label class = "label">请填写容纳人数:</label>
			<input class = "input" id = "rongnarenshu" type="text">
		</form>
	</div>
	<button id="bcygkc" class="button border-sub" style="margin-top: 10px;">保存</button>
</body>
<script>
		$(function() {
			 $("#bcygkc").click(function() {
				 console.log("32324");
				var examRoomNum = $("#ExamRoomNum").val();
				var examRoomName = $("#ExamRoomName").val();
				var accommodateNum = $("#rongnarenshu").val();
				$.ajax({
					type : "post",
					url : "examRoom_add.action",
					async : false,
					data : {
						'examRoomNum' : examRoomNum,
						'examRoomName' : examRoomName,
						'accommodateNum' : accommodateNum
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