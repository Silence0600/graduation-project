<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/pintuer.js"></script>
<script type="text/javascript" src="../js/gradeInput.js"></script>
</head>
<body>
	<div id="context">
		<div id="kclb">
			<form id="courseInfo">
				<input type="hidden" name="teacherId" id="teacherId"
					value="<%=session.getAttribute("teacherId")%>" /> <label
					class="label">请选择录入课程</label> <select class="input" name="course"
					id="course">
					<s:iterator value="courses">
						<option><s:property value="courseName" /></option>
					</s:iterator>
				</select>
			</form>
			<button class="button bg-sub" id="cxxs"
				style="margin-top: 10px; width: 82px;">确定</button>
				<button class="button bg-sub dialogs" id="szbl" data-toggle="click"
				data-target="#mydialog" data-mask="1" data-width="30%"
				style="margin-top: 10px; width: 100px;">设置比例</button>
			<button class="button bg-sub dialogs" id="szbl" data-toggle="click"
				data-target="#mydialog1" data-mask="1" data-width="30%"
				style="margin-top: 10px; width: 100px;">保存</button>
			<label class="label" id="label1">平时成绩比例为<span style="color:red">0%</span>,期末成绩为<span style="color:red">100%</span>.</label>
		</div>
		<div id="student">
		</div>
		<!-- <hr class="bg-blue" />

		<div id="inputTable" class="table-responsive">
			<table class="table table-bordered" id="gradeTable">
				<tr class="blue">
					<th>编号</th>
					<th>学号</th>
					<th>班级</th>
					<th>姓名</th>
					<th>平时成绩</th>
					<th>期末成绩</th>
					<th>总成绩</th>
				</tr>
				<tbody id="stu" align="center">

				</tbody>
			</table> -->
	</div>

	<div id="mydialog1">
		<div class="dialog">
			<div class="dialog-head">
				<span class="close rotate-hover"></span><strong>对话框标题</strong>
			</div>
			<div class="dialog-body">你确定保存成绩</div>
			<div class="dialog-foot">
				<button class="button dialog-close" id="qxbccj">取消</button>
				<button class="button bg-green" id="qrbccj">确认</button>
			</div>
		</div>
	</div>
	<div id="mydialog">
		<div class="dialog">
			<div class="dialog-head">
				<span class="close rotate-hover"></span><strong>对话框标题</strong>
			</div>
			<div class="dialog-body">
				<label>请选择平时成绩比例</label> <select class="input" id="psbl">
					<option>0%</option>
					<option>10%</option>
					<option>20%</option>
					<option>30%</option>
					<option>40%</option>
					<option>50%</option>
					<option>60%</option>
					<option>70%</option>
					<option>80%</option>
					<option>90%</option>
					<option>100%</option>
				</select> <label>期末成绩比例为:</label> <input id="qmbl" class="input" value="100%"
					disabled="true" />
			</div>
			<div class="dialog-foot">
				<button class="button dialog-close" id="qx">取消</button>
				<button class="button bg-green" id="qdbl">确认</button>
			</div>
		</div>
	</div>
	
	<!-- 提示保存成功的对话框 -->
	<p hidden="hidden">
		<button id="bccjcg" class="button button-big bg-main dialogs"
			data-toggle="click" data-target="#bccjcgDialog" data-mask="1"
			data-width="30%"></button>
	 </p> 

	 <div id="bccjcgDialog">
		<div class="dialog">
			<div class="dialog-head">
				<span class="close rotate-hover"></span><strong>保存成绩</strong>
			</div>
			<div class="dialog-body">
				<span>保存成绩成功！</span>
			</div>
			<div class="dialog-foot">			
				<button id="sxlrcjym" class="button">确定</button>
				<script type="text/javascript">
		$(function(){
			//点击确定的时候刷新页面
			$("#sxlrcjym").click(function(){
			    window.location.reload(); 
				/* $("#gbdh").trigger("click");  */
				});
			});
	</script>
			</div>
		</div> 
</div>
	
</body>
</html>