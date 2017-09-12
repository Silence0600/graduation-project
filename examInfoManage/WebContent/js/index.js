$(function() {
	$("#lrcj").click(function cxyh() {
		var url = "gradeInput_queryCourse.action";
		$.ajax({
			type : "post",
			async : false, // 异步请求
			url : url,
			success : function(dates) {
				$("#mainContent").html(dates);// 要刷新的div
			},
			error : function() {
				alert("失败，请稍后再试！");
			}
		});
	});

	$("#apkc").click(function() {

		var url = "arrangeExamRoom_change.action";
		$.ajax({
			type : "post",
			async : true, // 同步请求
			url : url,
			success : function(dates) {
				// alert(dates);
				$("#mainContent").html(dates);// 要刷新的div
			},
			error : function() {
				alert("失败，请稍后再试！");
			}
		});
	});
	
	$("#jkkc").click(function() {
		var url = "queryTpAndG_queryTeacherTP.action";
		$.ajax({
			type : "post",
			async : true, // 同步请求
			url : url,
			success : function(dates) {
					// alert(dates);
				$("#mainContent").html(dates);// 要刷新的div
			},
			error : function() {
				alert("失败，请稍后再试！");
			}
		});
	});
	
	//index.jsp管理教师按钮的时间
	$("#gljs").click(function() {
		$.ajax({
			type : "post",
			async : true, // 同步请求
			url : "teacherManage_queryAllTeacher.action",
			success : function(dates) {
				$("#mainContent").html(dates);// 
			},
			error : function() {
				alert("失败，请稍后再试！");
			}
		});
	});
	//管理考场
	$("#glkc").click(function() {
		$.ajax({
			url : "examRoom_queryAll.action",
			type : "post",
			async : false, // 同步请求
			success : function(dates) {
				// alert(dates);
				$("#mainContent").html(dates);// 要刷新的div
			},
			error : function() {
				alert("失败，请稍后再试！");
			}
		});
	});
	$("#glxs").click(function() {
		$.ajax({
			url : "studentManage_queryAllStudnet.action",
			type : "post",
			async : false, // 同步请求
			success : function(dates) {
				// alert(dates);
				$("#mainContent").html(dates);// 要刷新的div
			},
			error : function() {
				alert("失败，请稍后再试！");
			}
		});
	});
/*	$("#glyh").click(function() {
		$.ajax({
			url : "userManage_queryAllUser.action",
			type : "post",
			async : false, // 同步请求
			success : function(dates) {
				// alert(dates);
				$("#mainContent").html(dates);// 要刷新的div
			},
			error : function() {
				alert("失败，请稍后再试！");
			}
		});
	});*/
	//给body绑定保存考场按钮的事件..
	
	
	$(".leftnav h2").click(function() {
		$(this).next().slideToggle(200);
		$(this).toggleClass("on");
	});
	$(".leftnav ul li a").click(function() {
		$("#a_leader_txt").text($(this).text());
		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
	});
});