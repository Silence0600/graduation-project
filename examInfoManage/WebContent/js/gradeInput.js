$(function() {
	var ps="0%";
	var qm="100%";
	var intPs=0;
	var intQm=100;
	$("body").on("change", "#psbl", function() {
		ps = $("#psbl").val();
		intPs = ps.replace("%", "");
		intQm = 100 - intPs;
		qm = intQm + "%";
		$("#qmbl").val(qm);
	});
	$("body").on("click", "#qdbl", function() {
		$("#label1").html("平时成绩比例为<span style=\"color:red\">" + ps + "</span>,期末成绩比例为<span style=\"color:red\">" + qm+"<span>.");
		$("#qx").trigger("click");
	});

	$("body").on(
			"click",
			"#qrbccj",
			function() {
				var gradeJson = "[";
				$('#gradeTable tr').each(
						function(i) {
							var trAry = $("#gradeTable tr"); // 获取tr数组
							if (i != 0) {
								gradeJson += "{";
								gradeJson += "\"";
								gradeJson += "studentId";
								gradeJson += "\":";

								var xuehao = $(this).children('td').eq(0)
										.text(); // td的下标为0时的值
								gradeJson += xuehao;
								gradeJson += ",\"peaceTimeGrade\":";
								var peaceTimegradeGrade = $(this).find(
										".input1").val();
								gradeJson += peaceTimegradeGrade;
								gradeJson += ",\"finalGrade\":";
								var finalGrade = $(this).find(".input2")
										.val();
								gradeJson += finalGrade;
								
								gradeJson += ",\"totalGrade\":";
								var totalGrade = $(this).find(".input3").val();
								gradeJson += totalGrade;
								
								if (i != trAry.length - 1) {
									gradeJson += "},"
								} else {
									gradeJson += "}"
								}

							}
						});
				gradeJson += "]";
				console.log(gradeJson);
				$.ajax({
					type : "post",
					url : "gradeInput_saveGrade.action",
					async : false,
					data : {
						"gradeJson" : gradeJson,
					},
					cache : false,
					dataType : "json",
					success : function(result) {
						$("#bccjcg").trigger("click");
					},
					error : function(data) {
						alert("系统忙,请稍后重试!");
					}
				});
				$("#qxbccj").trigger("click");
			});

	$("#cxxs")
			.on(
					"click",
					function() {

						var teacherId = $("#teacherId").val();
						var course = $("#course").val();
						$
								.ajax({
									type : "post",
									url : "gradeInput_queryStudent.action",
									async : false,
									data : {
										'teacherId' : teacherId,
										'course' : course
									},
									cache : false,
									dataType : "json",
									success : function(result) {
										var students = eval('(' + result + ')');
										console.log(students);
										var trs = "<hr class=\"bg-blue\" /><div id=\"inputTable\" class=\"table-responsive\"><table class=\"table table-bordered\" id=\"gradeTable\"><tr class=\"blue\"><th>学号</th><th>班级</th><th>姓名</th><th>平时成绩</th><th>期末成绩</th><th>总成绩</th></tr><tbody align=\"center\">";
										$
												.each(
														students,
														function(n, value) {

															trs += "<tr class=\"mytr\"><td style=\"display:none\">"
																	+ value.studentId
																	+ "</td> <td>"
																	+ value.studentNub
																	+ "</td> <td>"
																	+ value.clazz
																	+ "</td><td>"
																	+ value.name
																	+ "</td><td><input style=\"width: 64px;\" type=\"text\" class=\"input input1\" id=\"peaceTimeGrade\" /></td><td><input style=\"width: 64px;\" type=\"text\" class=\"input input2\" id=\"finalGrade\" /></td><td><input style=\"width: 64px;\" type=\"text\" disabled=\"true\"class=\"input input3\" id=\"grade\" name=\"grade\"/></td></tr>";

														});
										$("#student").html(
												trs + "</tbody></table>");
									},
									error : function(data) {
										alert("系统忙,请稍后重试!");
									}
								});
						$(".mytr").each(
								function() {

									var input1 = $(this).find(".input1");
									var input3 = $(this).find(".input3");
									var input2 = $(this).find(".input2");
									input1.on('blur', function() {
										var input1Val = input1.val();
										var input2Val = input2.val();
										if(input1Val!=""&&input2Val!=""){
											var input3Val = input1Val*intPs/100+input2Val*intQm/100;
											console.log(input3Val);
											input3.val(Math.round(input3Val));
										}else{
											input3.val("");
										}					
									});
									input2.on('blur', function() {
										var input1Val = input1.val();
										console.log(input1Val);
										var input2Val = input2.val();
										if(input1Val!=""&&input2Val!=""){
											var input3Val = input1Val*intPs/100+input2Val*intQm/100;
											console.log(input3Val);
											input3.val(Math.round(input3Val));
										}else{
											input3.val("");
										}				
									});
								});
					});

});