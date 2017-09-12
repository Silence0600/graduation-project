<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>登录</title>
<link rel="stylesheet" href="css/pintuer.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

<link href="css/login.css" rel="stylesheet" type="text/css" />

<script src="js/login.js" type="text/javascript"></script>
<%
	session.setAttribute("loginFlag", "false");
	//如果等于null 说明从action过来的,没有通过验证, 不需要给session赋值的
	if (request.getParameter("key") != null) {
		session.setAttribute("key", request.getParameter("key"));
	}
%>
</head>
<body>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 90px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<form action="login.action" method="post">
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>考试信息管理系统</h1>
						</div>
						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group" style="padding-bottom: 20px;">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="accNub"
										placeholder="登录账号" data-validate="required:请填写账号" /> <span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group" style="padding-bottom: 20px;">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="password"
										placeholder="登录密码" data-validate="required:请填写密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
							<div class="form-group" style="padding-bottom: 20px;">
								<div class="field field-icon-right">
									<select class="input input-big" name ="status">
										<option>请选择身份</option>
										<option>管理员</option>
										<option>教师</option>
										<option>学生</option>
									</select> <span class="icon icon-group margin-small"></span>
								</div>
							</div>

							<!-- 	<div class="form-group" style="padding-bottom: 20px;">
								<div class="field field-icon-right" id="drag"></div>
								<script type="text/javascript">
									$('#drag').drag();
								</script>
							</div> -->

						</div>

						<div class="text-center">
							<p style="color: red">
								<%
									if (session.getAttribute("mag") == null) {
										session.setAttribute("mag", "");
									}
								%>
								<%=session.getAttribute("mag")%></p>
						</div>

						<div style="padding: 30px;">
							<input type="submit"
								class="button button-block bg-main text-big input-big"
								value="登录">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>