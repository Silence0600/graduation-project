<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="../css/examRoomManage.css">
<script src="../js/jquery.js"></script>
<script src="../js/pintuer.js"></script>
<script type="text/javascript" src = "../js/examRoomManage.js"></script>
</head>
<body>
	<div style="height: 83px;">
		<div class="form-group"
			style="float: left; width: 300px; margin-right: 50px;">
			<label class="label">请输入教室编号:</label> <input class="input"
				data-validate="required:请填写" id="jsbh" type="text" />
		</div>
		<div class="form-group"
			style="float: left; width: 300px; margin-right: 50px;">
			<label class="label">请输入考场名:</label> <input class="input"
				data-validate="required:请填写" id="kcm" type="text" />
		</div>
	</div>

	<div style="height: 45px;">
		<div style="float: left; margin-right: 20px;">
			<button id="cxzdkc" class="button bg-sub">查询</button>
		</div>
		<div style="float: left; margin-right: 20px;">
			<button id="xzkc" class="button bg-sub">新增考场</button>
			<!-- <button id="xzkc" class="button bg-sub" data-toggle="click"
				data-target="#adddialog" data-mask="1" data-width="30%">新增考场</button> -->
		</div>
	<script type="text/javascript">
	$("#xzkc").click(function() {
		$.ajax({
			type : "post",
			url : "examRoom_changeToAddPage.action",
			async : false,
			success : function(data) {
				$("#mainContent").html(data);
			},
			error : function(data) {
				alert("系统忙,请重试!");
			}
		});
	});
	</script>
		<form action="examRoom_insertExcel.action"
			enctype="multipart/form-data" method="post">
			<div style="float: left; margin-right: 20px;">
				<a class="button bg-sub input-file" href="javascript:void(0);">导入Excel<input
					type="file" name="uploadFile" id="uploadFile" /></a>
			</div>
			<div style="float: left; margin-right: 20px;">
				<input class="button bg-sub" type="submit" value="上传" />
			</div>

		</form>
		<!-- <div style="float: left; margin-right: 50px;">
			<button id="dcexcel" class="button bg-main">导出Excel</button>
		</div> -->
	</div>



	<script type="text/javascript">	
    $(function () {
        $("#mainContent").on("click","#dcexcel",function(){
            console.log("ok");
        	$.ajax({
				type : "post",
				async : true,
				url : "examRoom_exportExcel.action",
				success : function() {	
								
				},
				error : function() {
					alert("系统忙,请稍候重试");
				}
			});
            });
    	});
    </script>


	<hr class="bg-blue">
	<div class="table-responsive" id="examRoomTable">
		<table class="table table-bordered">
			<tr class="blue">
				<th>考场号</th>
				<th>考场名</th>
				<th>容纳人数</th>
				<th>操作</th>
			</tr>
			<tbody id="examRoomTab" align="center">
				<s:iterator value="examRooms">
					<tr>
						<td><s:property value="examRoomNum" /></td>
						<td><s:property value="examRoomName" /></td>
						<td><s:property value="accommodateNum" /></td>
						<!--字符串用引号括住  -->
						<td><button class="button border-main"
								onclick="xiugai( <s:property value="examRoomId"/> , <s:property value="examRoomNum"/> , '<s:property value="examRoomName"/>' , <s:property value="accommodateNum"/> )">修改</button>
							<button class="button border-dot"
								onclick="shanchu(<s:property value="examRoomId" /> )">删除</button>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<!-- 新增考场对话框 -->
	<div id="adddialog">
		<div class="dialog">
			<div class="dialog-head">
				<span class="close rotate-hover"></span><strong>新增考场</strong>
			</div>
			<div class="dialog-body">
				<form id="examRoomInfo">
					<label class="label">请填写考场号:</label> <input id="examRoomNum"
						type="text" input class="input" /><label class="label">请填写考场名:</label><input
						class="input" id="examRoomName" type="text" /><label
						class="label">请填写容纳人数:</label><input id="accommodateNum"
						type="text" input class="input" />
				</form>
			</div>
			<div class="dialog-foot">
				<button id="qxtj" class="button dialog-close">取消</button>
				<button class="button bg-green" id="bckcxx">保存</button>
				<script type="text/javascript">
		$(function(){
			$("#bckcxx").click(function(){
					var examRoomNum = $("#examRoomNum").val();
					var examRoomName = $("#examRoomName").val();
					var accommodateNum = $("#accommodateNum").val();
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
							//成功之后弹出保存成功对话框
							$("#cgan").trigger("click");
							 
							},
							error : function(data) {
								alert("系统请求超时,请重试!");
							}
					});
					//anjx提交之后退出对话框
					$("#qxtj").trigger("click");					
				});
			
		});
		</script>
			</div>
		</div>
	</div>
	<!-- 添加成功对话框 -->
	<p hidden="hidden">
		<button id="cgan" class="button button-big bg-main dialogs"></button>
	</p>
	<div id="addSuccessdialog">
		<div class="dialog">
			<div class="dialog-head">
				<span class="close rotate-hover"></span><strong>新增考场</strong>
			</div>
			<div class="dialog-body">
				<span>添加考场成功</span>
			</div>
			<div class="dialog-foot">
				<!-- <p hidden="hidden"><button id="gbdh" class="button dialog-close">取消</button></p> -->

				<button id="sxym" class="button">确定</button>
			</div>
			<script type="text/javascript">
		$(function(){
			//点击确定的时候刷新页面
			$("#sxym").click(function(){
			    window.location.reload();
				/* $("#gbdh").trigger("click");  */
				});
			});
	</script>
		</div>
	</div>
</body>
</html>