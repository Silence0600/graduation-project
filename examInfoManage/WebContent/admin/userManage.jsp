<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div style="height: 70px;">
		<div style="float: left; width: 300px; margin-right: 50px;">
			<label class="label">请输入教室编号:</label> <input class="input" id="jsbh"
				type="text" />
		</div>
		<div style="float: left; width: 300px;">
			<label class="label">请输入考场名:</label> <input class="input" id="kcm"
				type="text" />
		</div>
	</div>
	<button id="cxzdkc" class="button bg-sub">查询</button>
	<button id="xzkc" class="button bg-main dialogs" data-toggle="click"
		data-target="#adddialog" data-mask="1" data-width="30%">新增考场</button>
	<hr class="bg-blue">
	<div class="table-responsive" id="examRoomTable">
		<table class="table table-bordered">
			<tr class="blue">
				<th style="text-align: center;">账号</th>
				<th style="text-align: center;">身份</th>
				<th style="text-align: center;">操作</th>
			</tr>
			<tbody id="userTab" align="center">
				<s:iterator value="allUser">
					<tr>
						<td><s:property value="accNub" /></td>
						<td><s:property value="status" /></td>
						<!--字符串用引号括住  -->
						<td><button class="button border-main">修改</button>
							<button class="button border-dot">删除</button></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>