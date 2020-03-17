<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
 <%  request.setCharacterEncoding( "utf-8");%>
<% response.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/calendar/WdatePicker.js"></script>
</head>
<body>

<!-- 	pageContext对象  这个对象代表页面上下文，该对象主要用于访问JSP之间的共享数据。 -->
<!-- pageContext为jsp中9大内置对象 -->
<%-- 	<form action="${pageContext.request.contextPath }/user/doUpdateUser" method="post"> --%>
<%-- 		<input type="hidden" name="id" value="${user.id }"><br> --%>
<%-- 		userCode:<input name="userCode" value="${user.userCode }"/><br> --%>
<%-- 		userName:<input name="userName" value="${user.userName }"/><br> --%>
<%-- 		userPassword:<input name="userPassword" value="${user.userPassword }"/><br> --%>
<!-- 		userRole:<select name="userRole"> -->
<!-- 					<option>-请选择-</option> -->
<%-- 					<c:forEach items="${roleList }" var="role"> --%>
<%-- 						<c:if test="${user.userRole==role.id }"> --%>
<%-- 							<option value="${role.id }" selected>${role.roleName }</option> --%>
<%-- 						</c:if> --%>
<%-- 						<c:if test="${user.userRole!=role.id }"> --%>
<%-- 							<option value="${role.id }" selected>${role.roleName }</option> --%>
<%-- 						</c:if> --%>
<%-- 					</c:forEach> --%>
<!-- 				</select><br> -->
<!-- 		gender: -->
<%-- 			<c:if test="${user.gender==1 }"> --%>
<!-- 				<input type="radio" name="gender" value="1" checked>女&nbsp;<input type="radio" name="gender" value="2">男<br> -->
<%-- 			</c:if> --%>
<%-- 			<c:if test="${user.gender==2 }"> --%>
<!-- 				<input type="radio" name="gender" value="1">女&nbsp;<input type="radio" name="gender" value="2" checked>男<br> -->
<%-- 			</c:if> --%>
<%-- 		birthday:<input name="birthday" class="Wdate" onclick="WdatePicker()" value='<fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd"/>'/><br> --%>
<!-- 		<input type="submit" value="提交" /><br> -->
<!-- 	</form> -->
	<frm:form action="${pageContext.request.contextPath }/user/doUpdateUser" method="post" modelAttribute="user">
		<frm:hidden path="id" /><br>
		userCode:<frm:input path="userCode" /><frm:errors path="userCode"/><br>
		userName:<frm:input path="userName" /><br>
		userPassword:<frm:password path="userPassword" /><br>
		userRole:
				<frm:select path="userRole" >
					<frm:option value="0">-请选择-</frm:option>
						<c:forEach items="${rolelist }" var="role">
							<frm:option value="${role.id }">${role.roleName }</frm:option>
						</c:forEach>
				</frm:select><br>
		gender:
			<frm:radiobutton path="gender" value="1" />女&nbsp;
			<frm:radiobutton path="gender" value="2" />男
			<br>
		birthday:<frm:input path="birthday" class="Wdate" onclick="WdatePicker()" /><br>
		<input type="submit" value="提交" /><br>
	</frm:form>
</body>
</html>