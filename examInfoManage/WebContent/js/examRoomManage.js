/*$(function(){
	$("#xzkc").click(function(){
		$.ajax({
			type : "post",
			async : false, // 同步请求
			url : "examRoom_change.action",
			data : {type:1},
			timeout : 1000,
			success : function(dates) {
				// alert(dates);
				$("#mainContent").html(dates);// 要刷新的div
			},
			error : function() {
				alert("失败，请稍后再试！");
			}
		});
	});	
});*/
$("#cxzdkc").click(function() {
					var examRoomNum = $("#jsbh").val();
					var examRoomName = $("#kcm").val();
					$
							.ajax({
								type : "post",
								url : "examRoom_query.action",
								async : false,
								data : {
									'examRoomNum' : examRoomNum,
									'examRoomName' : examRoomName,
								},
								cache : false,
								dataType : "json",
								success : function(data) {
									var examRoom = eval('(' + data + ')'); // 解析是第一步;
									console.log(examRoom[0].examRoomNum);
									// 然后each循环取出
									var tr = "<tr><td>"
											+ examRoom[0].examRoomNum
											+ "</td><td>"
											+ examRoom[0].examRoomName
											+ "</td><td>"
											+ examRoom[0].accommodateNum
											+ "</td><td><button class=\"button border-main\" onclick=\"xiugai("
											+ examRoom[0].examRoomId
											+ ","
											+ examRoom[0].examRoomNum
											+ ",'"
											+ examRoom[0].examRoomName
											+ "',"
											+ examRoom[0].accommodateNum
											+ " ) \">修改</button>&nbsp<button class=\"button border-dot\" onclick=\"shanchu("
											+ examRoom[0].examRoomId
											+ ")\">删除</button></td></tr>";
									$("#examRoomTab").html(tr);
								},
								error : function(data) {
									alert("系统忙,请重试!");
								}
							});

				});
function shanchu(examRoomId) {
	console.log(examRoomId);
	$.ajax({
		url : "examRoom_delete.action",
		data : {
			"examRoomId" : examRoomId
		},
		type : "post",
		async : false,
		success : function(data) {
			$("#mainContent").html(data);
		},
		error : function() {
			alert("删除失败,请稍后重试!");
		}
	});
}
/* 修改按钮的方法 */
function xiugai(examRoomId, examRoomNum, examRoomName, accommodateNum) {
	console.log(examRoomId);
	console.log(examRoomNum);
	console.log(examRoomName);
	console.log(accommodateNum);
	$.ajax({
		url : "examRoom_changeUpdate.action",
		data : {
			"examRoomId" : examRoomId,
			"examRoomNum" : examRoomNum,
			"examRoomName" : examRoomName,
			"accommodateNum" : accommodateNum
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
	/*$("#id").val(examRoomId);
	$("#num").val(examRoomNum);
	$("#name").val(examRoomName);
	$("#accNum").val(accommodateNum);
	$("#xgkc").trigger("click");*/
	
}