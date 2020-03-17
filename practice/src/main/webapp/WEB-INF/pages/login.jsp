<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!-- 导入css样式 -->
<link href="${pageContext.request.contextPath }/statics/css/style.css" type="text/css" rel="stylesheet"/>
</head>
<body class="login_bg">

	<span>${exception.message}</span>
<!-- 	pageContext对象  这个对象代表页面上下文，该对象主要用于访问JSP之间的共享数据。 -->
<!-- pageContext为jsp中9大内置对象 -->
	<form action="${pageContext.request.contextPath }/user/doLogin" method="post">
		<input name="userCode"/><br>
		<input name="userPassword"/><br>
		<input type="submit" value="提交" /><br>
	</form>
</body>
</html>