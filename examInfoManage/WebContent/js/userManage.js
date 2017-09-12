$(function() {
	$("#kcap").click(function kcap() {
		var url = "login.jsp";
		var data = {
			type : 1
		};
		$.ajax({
			type : "get",
			async : false, // 同步请求
			url : url,
			data : data,
			timeout : 1000,
			success : function(dates) {
				// alert(dates);
				$("#mainContent").html(dates);// 要刷新的div
			},
			error : function() {
				//alert("失败，请稍后再试！");
			}
		});
	});
	
	
});