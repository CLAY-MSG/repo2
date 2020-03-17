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

		userCode:${user.userCode }<br>
		userName:${user.userName }<br>
		userPassword:${user.userPassword }<br>
		userRole:${user.role.roleName }<br>
		gender:
			<c:choose>
					<c:when test="${ user.gender==1}">女</c:when>
					<c:otherwise>男</c:otherwise>
			</c:choose>
		birthday:<fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd" /><br>
		<button onclick="location='${pageContext.request.contextPath }/user/userlist'">返回</button>
</body>
</html>