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
			
			$("#cxcj").click(function() {
				var studentNum = $("#xuehao").val();
				$.ajax({
					type : "post",
					data : {
						"studentNum" : studentNum
					},
					asnyc : false,
					url : "queryTpAndG_queryGrade.action",
					success : function(data) {
						$("#mainContent").html(data);
					},
					error : function() {
						console.log("失败了");
					}
				});
			});
		});
	</script>
 <div>
		<form id="courseInfo">
		 <label	class="label">请输入学号：</label> 
				<input class="input" id="xuehao" type = "text" />
		</form>
		<button class="button bg-sub" id="cxcj"
			style="margin-top: 10px; width: 92px;">查询成绩</button>
	</div> 
</body>
</html>