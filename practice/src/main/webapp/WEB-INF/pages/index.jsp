<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	li{
 		list-style:none;/*去掉点 */
		display:inline-block;/*一行显示*/
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".showUser").click(function(){
			$.getJSON("${pageContext.request.contextPath }/user/showUserJson/"+$(this).attr("userId"),function(data){
				$("#userCode").text(data.userCode);
				$("#userName").text(data.userName);
				$("#birthday").text(data.birthday);
			})
		})
	})
</script>
</head>
<body>
	<div>
		 <form action="${pageContext.request.contextPath }/user/userlist" method="post">
			userName:<input name="userName" value="${queryUser.userName }">&nbsp;
			userRole:<select name="userRole">
						<option value="0">-请选择-</option>
						<c:forEach items="${rolelist }" var="role">
							<c:if test="${queryUser.userRole==role.id }">
								<option value="${role.id }" selected>${role.roleName }</option>
							</c:if>
							<c:if test="${queryUser.userRole!=role.id }">
								<option value="${role.id }">${role.roleName }</option>
							</c:if>
						</c:forEach>
					 </select>&nbsp;
					 <input type="submit" value="查询" />
		</form> 
		 <button onclick="location='${pageContext.request.contextPath}/user/addUser'">添加用户</button>
		
		
	</div>
	
	<table>
		<tr>
			<th>用户编号</th>
			<th>真实姓名</th>
			<th>性别</th>
			<th>出生日期</th>
			<th>年龄</th>
			<th>证件照</th>
			<th>工作照</th>
			<th>角色</th>
			<th>handle</th>
		</tr>
		<c:forEach items="${userlist }" var="u" >
			<tr>
				<td>${u.userCode }</td>
				<td>${u.userName }</td>
				<td>
					<c:if test="${u.gender==1 }">女</c:if>
					<c:if test="${u.gender==2 }">男</c:if>
				</td>
				<td><fmt:formatDate value="${u.birthday }" pattern="yyyy-MM-dd" /></td>
				<td>${u.age }</td>
				<td><img width="20px" height="20px" src="/uploadfiles/${u.idPic}"></td>
				<td><img width="20px" height="20px" src="/uploadfiles/${u.workPic}"></td>
				<td>${u.role.roleName }</td>
				<td>
<%-- 					<a href="${pageContext.request.contextPath }/user/showUserJson/${u.id}">查看</a>&nbsp; --%>
					<a href="#" class="showUser" userId="${u.id }">查看</a>&nbsp;
					<a href="${pageContext.request.contextPath }/user/updateUser?id=${u.id}">修改</a>&nbsp;
					<a href="${pageContext.request.contextPath}/user/deleteUser?id=${u.id}" onclick="return confirm('是否要删除！')">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<ul>
		<li><a href="${pageContext.request.contextPath }/user/userlist?pageIndex=1">首页</a></li>
		
		<c:choose>
			<c:when test="${page.pageIndex>1 }">
				<li><a href="${pageContext.request.contextPath }/user/userlist?pageIndex=${page.pageIndex-1}">前页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#">前页</a></li>
			</c:otherwise>
		</c:choose>
		
		<li>第${page.pageIndex }页/共${page.totalPageCount }页</li>
		
		<c:choose>
			<c:when test="${page.pageIndex < page.totalPageCount }">
				<li><a href="${pageContext.request.contextPath }/user/userlist?pageIndex=${page.pageIndex+1}">后页</a>
			</c:when>
			<c:otherwise>
				<li><a href="#">后页</a></li>
			</c:otherwise>
		</c:choose>
		
		<li><a href="${pageContext.request.contextPath }/user/userlist?pageIndex=${page.totalPageCount}">末页</a></li>
	</ul>
	
	<div>
		用户编码：<span id="userCode"></span><br>
		用户姓名：<span id="userName"></span><br>
		生日：<span id="birthday"></span><br>
	</div>

</body>
</html>