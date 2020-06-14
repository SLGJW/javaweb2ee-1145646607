<%@ page import="com.csw.bean.Student" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertStudent.html" method="get">
		<input type="hidden" name="mark" value="queryAllStudent">
	</form>	
	<a href="insertStudent.html">添加</a>
	<table width="800" border="1">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>班级</th>
			<th>学历</th>
			<th>爱好</th>
			<th>生日</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${l }" var="s">
			<tr>
				<th>${s.sid }</th>
				<th>${s.sname }</th>
				<th>${s.sex==1?'男':'女' }</th>
				<th>${s.sclass }</th>
				<th>${s.edu }</th>
				<th>${s.shobbies }</th>
				<th>${s.birthday }</th>
				<th>
					<a href="studentServlet?mark=queryStudentBySid&sid=${s.sid }">修改</a>
					||
					<a href="studentServlet?mark=deleteStudent&sid=${s.sid }">删除</a>
				</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>