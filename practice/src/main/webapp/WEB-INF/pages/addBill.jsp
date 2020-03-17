<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%  request.setCharacterEncoding( "utf-8");%>
<% response.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>


<meta charset="utf-8">
<title>Insert title here</title>
<!-- 日期插件 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/calendar/WdatePicker.js"></script>
<!-- 引入jquery -->
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#userCode").blur(function(){
			$.getJSON("${pageContext.request.contextPath }/user/checkUserCode/"+$(this).val(),function(data){
				if(data.result=="exist"){
					$("#userCodeInfo").html("该用户已存在");
				}else{
					$("#userCodeInfo").html("该用户可用");
				}
			});
		})
	})
</script>
</head>
<body>

<!-- 	pageContext对象  这个对象代表页面上下文，该对象主要用于访问JSP之间的共享数据。 -->
<!-- pageContext为jsp中9大内置对象 -->
	<span>${exception.message }</span>
	<form action="${pageContext.request.contextPath }/user/doAddUser" method="post" enctype="multipart/form-data">
		userCode:<input name="userCode" id="userCode"/><span id="userCodeInfo" ></span><br>
		userName:<input name="userName"/><br>
		userPassword:<input name="userPassword"/><br>
		userRole:<select name="userRole">
					<option value="0">-请选择-</option>
					<c:forEach items="${roleList }" var="role">
						<option value="${role.id }">${role.roleName }</option>
					</c:forEach>
				</select><br>
		gender:<input type="radio" name="gender" value="1">女&nbsp;<input type="radio" name="gender" value="2">男<br>
		birthday:<input name="birthday" class="Wdate" onclick="WdatePicker()"/><br>
		personalPic:<input type="file" name="attachs"><br>
		workPic:<input type="file" name="attachs"><br>
		<input type="submit" value="提交" /><br>
	</form>
</body>
</html>