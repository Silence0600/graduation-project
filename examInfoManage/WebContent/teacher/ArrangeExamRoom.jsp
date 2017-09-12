<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.Date"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/pintuer.js"></script>
<script type="text/javascript" src="../js/ArrangeExamRoom.js"></script>
</head>
<body>
	<script>
		/*将数据拼接json串插入到数据库  */
		$("#examRooms").on("click","#tjkcap",function() {
					var date = $("#date").val();
					var examTime = date + " " + $("#time").val();
					var course = $("#course").val();
					console.log(examTime + " " + course);
					var data = "[";
					$("#invigilators div").each(
							function(i) {
								var examRoomId = $("#examRoom" + i + " p").text();
								var clazz = $("#examRoom" + i + " label").text();
								data += "{\"examTime\" :\"" + examTime
										+ "\",\"course\" : \"" + course
										+ "\",\"examRoomId\" :" + examRoomId
										+ ",\"clazz\":\""+clazz+"\",\"invigilator\":\"";
								var len = $("#examRooms div").length;
								$("#examRoom" + i + " input").each(
										function(j) {
											var length = $("#examRoom" + i
													+ " input").length;
											if (j != length - 1) {
												data += $(this).val() + " ";
											} else {
												data += $(this).val();
											}

										});
								if (i != len - 1) {
									data += "\"},";
								} else {
									data += "\"}";
								}

							});
					data += "]"
					console.log(data);
					$.ajax({
						type : "post",
						async : true,
						dataType : "json",
						data : {
							"examRoomTimeJson" : data
						},
						url : "arrangeExamRoom_insertExamRoomTime.action",
						success : function(data) {
							$("#apkccg").trigger("click");
						},

						error : function() {
							alert("系统忙,请稍候重试");
						}
					});

				});
		$("#cxkykc")
				.click(
						function() {
							var date = $("#date").val();
							var examTime = date + " " + $("#time").val();
							var course = $("#course").val();
	

							console.log(examTime + " " + course);
							var data = {
								"examTime" : examTime,
								"course" : course,
							};
							$
									.ajax({
										type : "post",
										async : true,
										dataType : "json",
										data : data,
										url : "arrangeExamRoom_queryGoodExamRoom.action",
										success : function(data) {
											console.log(data);
											 if(data === null){
												 $("#examRooms").html("<hr class=\"bg-blue\" /><h4>对不起,由于没有足够考场或您当前已有考试安排,请重新选择考场数或安排考场时间!</h4>");
												 }else{
											var examRoomsJson = eval('(' + data+ ')');
											var examRoomsString = "<hr class=\"bg-blue\" /><h4>为您选择的考场:</h4><br><div id=\"invigilators\"style=\"height:140px;\">";
											$.each(examRoomsJson,function(index,content) {
																examRoomsString += "<div id=\"examRoom"+index+"\" style=\"width:230px;margin-right: 50px;float: left;\">"
																		+ content.examRoomName +"(<label>"+content.clazz+"</label>)<p hidden>"
																		+ content.examRoomId
																		+ "</p><br><input placeholder=\"监考老师姓名\" style=\"margin-bottom:10px;margin-top: 10px;\"class=\"input\" type=\"text\"/><input placeholder=\"监考老师姓名\" class=\"input\" type=\"text\"/></div>";

															});
											examRoomsString += "</div><button class=\"button bg-sub\" id=\"tjkcap\">提交考场安排</button>";
											$("#examRooms").html(
													examRoomsString);}  
										},
										error : function() {
											$("#examRooms").html("<hr class=\"bg-blue\" />对不起,系统繁忙,请稍后重试!");
										}
									});
						});
	</script>
	<div>
		<div style="height: 10px;">
			<div style="width: 230px; float: left">
				<label class="label">请选择考试课程</label> <select class="input"
					id="course">
					<s:iterator value="courses">
						<option><s:property value="courseName" /></option>
					</s:iterator>
				</select>
			</div>
			<div style="width: 230px; float: left; margin-left: 50px;">
				<label class="label">请选择考试日期:</label> <input class="input" id="date"
					type="date">
			</div>
			<div style="width: 230px; float: left; margin-left: 50px;">
				<label class="label">请选择考试时间:</label> <select id="time"
					class="input">
					<option value="08:00:00">上午第一大节(08:00-09:40)</option>
					<option value="10:00:00">上午第二大节(10:00-11:40)</option>
					<option value="14:00:00">下午第一大节(14:00-15:40)</option>
					<option value="16:00:00">下午第二大节(16:00-17:40)</option>
				</select>
			</div>
<%-- 			<div style="width: 230px; float: left; margin-left: 50px;">
				<label class="label">请选择需要几个考场: </label> <select class="input"
					id="num">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>

			</div> --%>
		</div>
		
		<div style="width: 230px; float: left; margin-left: 50px;">
			<button class="button bg-sub" id="cxkykc" style="margin-top:10px; margin-bottom:10px;">查询可用考场</button>
		</div>
	</div>
	<div id="examRooms"></div>
	  <p hidden="hidden">
		<button id="apkccg" class="button button-big bg-main dialogs"
			data-toggle="click" data-target="#apkccgDialog" data-mask="2"
			data-width="30%"></button>
	 </p> 

	 <div id="apkccgDialog">
		<div class="dialog">
			<div class="dialog-head">
				<span class="close rotate-hover"></span><strong>安排考场</strong>
			</div>
			<div class="dialog-body">
				<span>安排考场成功！</span>
			</div>
			<div class="dialog-foot">			
				<button id="sxapkcym" class="button">确定</button>
				<script type="text/javascript">
		$(function(){
			//点击确定的时候刷新页面
			$("#sxapkcym").click(function(){
			    window.location.reload(); 
				/* $("#gbdh").trigger("click");  */
				});
			});
	</script>
			</div>
		</div> 
</div>
	<script type="text/javascript">
		$(function() {
			Date.prototype.format = function(format) {
				var o = {
					"M+" : this.getMonth() + 1, //month 
					"d+" : this.getDate(), //day 
					"h+" : this.getHours(), //hour 
					"m+" : this.getMinutes(), //minute 
					"s+" : this.getSeconds(), //second 
					"q+" : Math.floor((this.getMonth() + 3) / 3), //quarter 
					"S" : this.getMilliseconds()
				//millisecond 
				}
				if (/(y+)/.test(format))
					format = format.replace(RegExp.$1,
							(this.getFullYear() + "")
									.substr(4 - RegExp.$1.length));
				for ( var k in o)
					if (new RegExp("(" + k + ")").test(format))
						format = format.replace(RegExp.$1,
								RegExp.$1.length == 1 ? o[k] : ("00" + o[k])
										.substr(("" + o[k]).length));
				return format;
			}
			var date = new Date().format("yyyy-MM-dd");
			$("#date").val(date);
		});
	</script>
</body>
</html>