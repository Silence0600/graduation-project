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
			<input id="id" type="hidden" value="${examRoomId}"> <label
				class="label">请修改考场号:</label> <input class="input" id="num"
				type="text" value="${examRoomNum}" /></br> <label class="label">请修改考场名:</label>
			<input class="input" id="name" type="text" value="${examRoomName}" /><br>
			<label class="label">请修改容纳人数:</label> <input class="input"
				id="accNum" type="text" value="${accommodateNum}" /><br>
		</form>
	</div>
	<button class="button border-sub" id="bcxg">保存修改</button>
	<!-- <script>
	$(function(){
		 $("#bcxg").on("click",function(){
				var examRoomId=$("#id").val();
				var examRoomNum = $("#num").val();
				var examRoomName = $("#name").val();
				var accommodateNum = $("#accNum").val();
				console.log(examRoomId+examRoomNum+examRoomName+accommodateNum);
				$.ajax({
					asnyc:false,
					url:"examRoom_update.action",
					type:"post",
					data:{"examRoomId":examRoomId,"examRoomNum":examRoomNum,"examRoomName":examRoomName,"accommodateNum":accommodateNum},				
					success:function(data){
						console.log("chenggong");
						$("#xgkccg").trigger("click");
						},
					error:function(){
						alert("系统忙,请稍后重试");
						}
					});
				}); 
		});		
	</script> -->
</body>
</html>